/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pollweb.data.impl;
import java.io.File;
import java.sql.Blob;
import pollweb.data.model.Answer;
import pollweb.data.model.Poll;
import pollweb.data.model.User;

/**
 *
 * @author venecia2
 */
public class AnswerImpl implements Answer{
    
    private int key;
    private User user;
    private Poll poll;
    private Blob blob;

    @Override
    public int getKey() {
        return key;
    }

    @Override
    public void setKey(int newKey) {
        this.key = newKey;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public void setUser(User newUser) {
        this.user = newUser;
    }

    @Override
    public Poll getPoll() {
        return poll;
    }

    @Override
    public void setPoll(Poll newPoll) {
        this.poll = newPoll;
    }

    @Override
    public Blob getBlob() {
        return blob;
    }

    @Override
    public void setBlob(Blob newBlob) {
        this.blob = newBlob;
    }
    
    
}
