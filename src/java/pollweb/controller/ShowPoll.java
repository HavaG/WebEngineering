/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pollweb.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pollweb.data.dao.PollWebDataLayer;
import pollweb.data.impl.PollImpl;
import pollweb.data.model.Poll;
import pollweb.data.model.Question;
import pollweb.data.util.DataException;
import pollweb.security.SecurityLayer;

/**
 *
 * @author venecia2
 */
@WebServlet("/Poll_example")
public class ShowPoll extends PollWebBaseController {
    static{
    Poll poll = new PollImpl();
    List<Question> questions;
    }
    private void action_error(HttpServletRequest request, HttpServletResponse response) {
        String message;

        Exception ex = (Exception) request.getAttribute("exception");

        if (ex != null && ex.getMessage() != null) {
            message = ex.getMessage();
        } else if (ex != null) {
            message = ex.getClass().getName();
        } else {
            message = "Unknown Error";
        }
        request.setAttribute("message", message);
        try {
            this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/error.jsp").forward(request, response);
        } catch (ServletException | IOException ex1) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex1);
        }
    }

    private void action_default(HttpServletRequest request, HttpServletResponse response,int poll_id) throws IOException, ServletException {
        try {
            Poll poll = ((PollWebDataLayer) request.getAttribute("datalayer")).getPollDAO().getPoll(poll_id);
            List<Question> questions = ((PollWebDataLayer) request.getAttribute("datalayer")).getQuestionDAO().getQuestionsByPoll(poll);
            if(questions.isEmpty()){
                action_error(request, response);
            }
            request.setAttribute("questions", questions);
            this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/poll-example.jsp").forward(request, response);

        } catch (DataException ex) {
            request.setAttribute("exception", ex);
            action_error(request, response);
        }
    }
    private void action_write_answers(HttpServletRequest request, HttpServletResponse response, int poll_id) throws IOException, ServletException{
        //Answer tempAnswer = null;
        String contextPath = getServletContext().getRealPath("/");
        String csvFilePath=contextPath+"\\test";
        File answerFile = new File(csvFilePath);
        FileWriter fr = new FileWriter(answerFile);
        
       
        StringBuffer header = new StringBuffer();
        final String commaDelimeter = ",";        
        
        try{
            //TODO: set userID to database
            HttpSession s = SecurityLayer.checkSession(request);
            int userID = (int) s.getAttribute("userid");
            
            Poll poll = ((PollWebDataLayer) request.getAttribute("datalayer")).getPollDAO().getPoll(poll_id);
            List<Question> questions = ((PollWebDataLayer) request.getAttribute("datalayer")).getQuestionDAO().getQuestionsByPoll(poll);

            for(Question question:questions){
                header.append(question.getText());
            }
            fr.append(header.toString());
            fr.append(System.lineSeparator());           
            
            for(Question question:questions){
                String answer = request.getParameter(String.valueOf(question.getPosition()));
                fr.append(answer);
                fr.append(commaDelimeter);
            }           
            } catch (Exception ex) {
                request.setAttribute("exception", ex);
                action_error(request, response);           
            
            }finally {
                fr.flush();
                fr.close();            
        }
        
        answerFile = new File(csvFilePath);
        FileInputStream file = new FileInputStream(answerFile);
  
//        tempAnswer = new Answer();
//        tempAnswer.setUserID= userID;
//        tempAnswer.setPollID = poll
    }
    
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        int poll_id;
        if (request.getParameter("ID") != null) {           
            poll_id = Integer.parseInt(request.getParameter("ID"));
        } else {
            throw new NumberFormatException("String argument is null");
        }
        try {
            action_default(request, response,poll_id);
            if (request.getParameter("Send") != null) {
                action_write_answers(request, response,poll_id);
            }
        } catch (IOException ex) {
            request.setAttribute("exception", ex);
            action_error(request, response);
        }
    }
}
