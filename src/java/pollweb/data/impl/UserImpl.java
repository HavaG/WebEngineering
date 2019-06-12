/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pollweb.data.impl;
import pollweb.data.model.User;

/**
 *
 * @author venecia2
 */
public class UserImpl extends PersonImpl implements User{
    
    private int pollID;

    public UserImpl() {
        this.key = 0;
        this.password = "";
        this.email = "";
        this.pollID = 0;
    }
    
    @Override
    public int getPollID() {
        return pollID;
    }

    @Override
    public void setPollID(int newPollID) {
        pollID = newPollID;
    }
}
