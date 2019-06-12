/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pollweb.data.impl;

import pollweb.data.model.Question;

/**
 *
 * @author venecia2
 */
public class QuestionImpl implements Question{
    
    int key;
    int position;// position of question
    String type;//TODO: String or object type
    String text;
    String note;//explanatory note
    boolean isMandatory;
    int poll_ID;

    public QuestionImpl() { }


    @Override
    public int getKey() {
       return key;
    }

    @Override
    public void setKey(int key) {
        this.key=key;
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public void setPosition(int position) {
        this.position=position;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
       this.type=type;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getNote() {
        return note;
    }

    @Override
    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean isMandatory() {
        return isMandatory;
    }

    @Override
    public void setMandatory(boolean mandatory) {
        this.isMandatory = mandatory;
    }

    @Override
    public int getPoll_ID() {
        return poll_ID;
    }

    @Override
    public void setPoll_ID(int poll_ID) {
        this.poll_ID=poll_ID;
    }
    
}
