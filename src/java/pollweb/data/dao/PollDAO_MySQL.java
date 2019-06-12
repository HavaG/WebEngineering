/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pollweb.data.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pollweb.data.impl.PollImpl;
import pollweb.data.model.Manager;
import pollweb.data.model.Poll;
import pollweb.data.model.User;
import pollweb.data.util.DAO;
import pollweb.data.util.DataException;
import pollweb.data.util.DataLayer;

/**
 *
 * @author venecia2
 */
public class PollDAO_MySQL extends DAO implements PollDAO{
    
    private PreparedStatement getUnsignedPolls, getPollByID;
    private PreparedStatement insertPoll, updatePoll, deletePoll;


    public PollDAO_MySQL(DataLayer d) {
        super(d);
    }
    
    @Override
    public void init()throws DataException{
        try{
            super.init();
            getUnsignedPolls = connection.prepareStatement("SELECT ID AS poll_ID FROM poll");
            getPollByID = connection.prepareStatement("SELECT * FROM poll WHERE ID=?");
            insertPoll = connection.prepareStatement("INSERT INTO poll (title,open_tag,close_tag,isReserved,managerID) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            updatePoll = connection.prepareStatement("UPDATE poll SET title=?, open_tag=?, close_tag=?, isReserved=?,managerId=?");
            deletePoll = connection.prepareStatement("DELETE FROM poll WHERE ID=?");
            
        }catch(SQLException ex){
            throw new DataException("Error initializing pollweb data layer",ex);
        }                    
    }
    
    @Override
    public void destroy()throws DataException{
        try{

            getUnsignedPolls.close();
            getPollByID.close();
            insertPoll.close();
            updatePoll.close();
            deletePoll.close();
        }catch(SQLException ex){
            throw new DataException("Error destroying pollweb data layer",ex);
        }
        super.destroy();
    }
    
    public Poll createPoll() {
        return new PollImpl();
    }

    @Override
    public Poll createPoll(ResultSet rs) throws DataException {
        PollImpl p = (PollImpl) createPoll();
        try{
            p.setKey(rs.getInt("ID"));
            p.setManagerID(rs.getInt("managerID"));
            p.setTitle(rs.getString("title"));
            p.setOpenText(rs.getString("open_tag"));
            p.setCloseText(rs.getString("close_tag"));
            p.setReserved(rs.getBoolean("isReserved"));
            //TODO: where and how to get users,questions?
            return p;
        }catch(SQLException ex){
            throw new DataException("Unable to create poll object from ResultSet",ex);
        }      
    }

    @Override
    public Poll getPoll(int poll_key) throws DataException {
         try {
            getPollByID.setInt(1, poll_key);
            try (ResultSet rs = getPollByID.executeQuery()) {
                if (rs.next()) {
                    return createPoll(rs);
                }
            }
        } catch (SQLException ex) {
            throw new DataException("Unable to load poll by ID", ex);
        }
        return null;
    }

    @Override
    public void storePoll(Poll poll) throws DataException {
        
    }

    @Override
    public List<Poll> getUnsignedPolls() throws DataException {
         List<Poll> result = new ArrayList();
        
        try(ResultSet rs = getUnsignedPolls.executeQuery()){
            while (rs.next()) {
                result.add(getPoll(rs.getInt("ID")));
            }
        } catch (SQLException ex) {
            throw new DataException("Unable to load polls", ex);
        }
        return result;
    }
    
}
