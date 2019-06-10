/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pollweb.data.impl;

import java.util.List;
import pollweb.data.model.Poll;
import pollweb.data.model.User;

/**
 *
 * @author venecia2
 */
public class UserImpl implements User{
     private int key;
      private String password;
      private String email;
//    public User type;	
//    List<Poll> polls;//TODO: delete

    public UserImpl() {
        this.key = 0;
        this.password = "";
        this.email = "";
    }

    
    @Override
    public int getKey() {
        return key;
    }

     @Override
    public String getPassword() {
        return password;
    }

     @Override
    public String getEmail() {
        return email;
    }


     @Override
    public void setKey(int key) {
        this.key = key;
    }

     @Override
    public void setPassword(String password) {
        this.password = password;
    }

     @Override
    public void setEmail(String email) {
        this.email = email;
    }

//    @Override
//    public User getType() {
//        return type;
//    }
//
//    @Override
//    public void setType(User newType) {
//        this.type = newType;
//    }
//
//    @Override
//    public List<Poll> getAvailablePolls() {
//        return polls;
//    }
//
//    @Override
//    public void setAvailablePolls(List<Poll> polls) {
//        this.polls = polls;
//    }
 
}
