/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pollweb.data.model;

import java.util.List;

/**
 *
 * @author venecia2
 */
public interface User {
    
    int getKey();

    void setKey(int newKey);

    String getName();
    
    void setName(String newName);

    String getEmail();
    
    void setEmail(String newEmail);
    
    String getPassword();
    
    void setPassword(String newPassword);
    
    boolean isValid() ;
    
    void setValid(boolean newValid);
    
    User getType();
    
    void setType(User newType);
    
    List<Poll> getAvailablePolls();
    
    void setAvailablePolls(List<Poll> polls);
    
    
}
