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
public class UserImpl implements User{
     private int key;
      private String password;
      private String name;
      private String email;
      public boolean valid;
      //public User type;	

    public UserImpl() {
        this.key = 0;
        this.password = "";
        this.name = "";
        this.email = "";
        this.valid = false;
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
    public String getName() {
        return name;
    }

     @Override
    public String getEmail() {
        return email;
    }

     @Override
    public boolean isValid() {
        return valid;
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
    public void setName(String name) {
        this.name = name;
    }

     @Override
    public void setEmail(String email) {
        this.email = email;
    }

     @Override
    public void setValid(boolean valid) {
        this.valid = valid;
    }
      
    
     
}
