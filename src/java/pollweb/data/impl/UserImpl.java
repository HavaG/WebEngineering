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
     private String key;
      private String password;
      private String name;
      private String email;
      public boolean valid;
      //public User type;	

    @Override
    public String getKey() {
        return key;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public boolean isValid() {
        return valid;
    }
      
     
}
