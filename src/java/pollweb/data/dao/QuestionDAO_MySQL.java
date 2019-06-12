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
import pollweb.data.impl.QuestionImpl;
import pollweb.data.model.Poll;
import pollweb.data.model.Question;
import pollweb.data.util.DAO;
import pollweb.data.util.DataException;
import pollweb.data.util.DataLayer;

/**
 *
 * @author venecia2
 */
public class QuestionDAO_MySQL extends DAO implements QuestionDAO{
    
    private PreparedStatement getQuestionByID,getQuestionsByPoll;
    private PreparedStatement insertQuestion, updateQuestion, deleteQuestion;
    
    public QuestionDAO_MySQL(DataLayer d) {
        super(d);
    }
    
        public void init() throws DataException {
        try {
            super.init();

            //precompiliamo tutte le query utilizzate nella classe
            //precompile all the queries uses in this class
            getQuestionByID = connection.prepareStatement("SELECT * FROM question WHERE ID=?");
            getQuestionsByPoll = connection.prepareStatement("SELECT ID AS questionID FROM article WHERE poll_ID=? ORDER BY position");
            
            //notare l'ultimo paametro extra di questa chiamata a
            //prepareStatement: lo usiamo per assicurarci che il JDBC
            //restituisca la chiave generata automaticamente per il
            //record inserito
            //note the last parameter in this call to prepareStatement:
            //it is used to ensure that the JDBC will sotre and return
            //the auto generated key for the inserted recors

        } catch (SQLException ex) {
            throw new DataException("Error initializing pollweb data layer", ex);
        }
    }
        
     @Override
    public void destroy()throws DataException{
        try{

            getQuestionByID.close();
            getQuestionsByPoll.close();

        }catch(SQLException ex){
            throw new DataException("Error destroying pollweb data layer",ex);
        }
        super.destroy();
    }
    @Override
    public Question createQuestion() {
       return new QuestionImpl();
    }

    @Override
    public Question createQuestion(ResultSet rs) throws DataException {
        QuestionImpl q = (QuestionImpl) createQuestion();
       try{
            q.setKey(rs.getInt("ID"));
            q.setPoll_ID(rs.getInt("poll_ID"));
            q.setText(rs.getString("text"));
            q.setType(rs.getString("type"));
            q.setNote(rs.getString("note"));
            q.setPosition(rs.getInt("position"));
            q.setMandatory(rs.getBoolean("isMandatory"));
           
            return q;
       }catch(SQLException ex){
            throw new DataException("Unable to create question object from ResultSet",ex);
       }
    }
    
    @Override
    public Question getQuestion(int question_ID) throws DataException {
        try {
            getQuestionByID.setInt(1, question_ID);
            try (ResultSet rs = getQuestionByID.executeQuery()) {
                if (rs.next()) {
                    return createQuestion(rs);
                }
            }
        } catch (SQLException ex) {
            throw new DataException("Unable to load question by ID", ex);
        }

        return null;
    }

    @Override
    public List<Question> getQuestionsByPoll(Poll poll) throws DataException {
        List<Question> result = new ArrayList();

        try {
            getQuestionsByPoll.setInt(1, poll.getKey());
            try (ResultSet rs = getQuestionsByPoll.executeQuery()) {
                while (rs.next()) {
                    result.add((Question) getQuestion(rs.getInt("questionID")));
                }
            }
        } catch (SQLException ex) {
            throw new DataException("Unable to load questions by poll", ex);
        }
        return result;
    }

    @Override
    public void storeQuestion(Question polll) throws DataException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    
}
