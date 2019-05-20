/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pollweb.data.model;

import java.util.Date;

/**
 *
 * @author venecia2
 */
public interface Question {
    
    int getKey();

    void setKey(int key);
    
    int getNumber();

    void setNumber(int number);
    
    String getQuestionType();

    void setQuestionType(String type);

    String getText();

    void setText(String Text);//Or type is Data?
    
    String getNote();
    
    void setNote(String note);
    
    boolean isMandatory();
    
    void setMandatory(boolean mandatory);
    
}
