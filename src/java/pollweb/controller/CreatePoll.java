/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pollweb.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pollweb.data.dao.PollWebDataLayer;
import pollweb.data.model.Poll;
import pollweb.data.model.Question;
import pollweb.data.util.DataException;

/**
 *
 * @author venecia2
 */
public class CreatePoll extends PollWebBaseController {
    
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
            Poll poll = ((PollWebDataLayer) request.getAttribute("datalayer")).getPollDAO().createPoll();
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

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        int poll_id;
        if (request.getParameter("button_poll") != null) {           
            poll_id = Integer.parseInt(request.getParameter("poll_id"));
        } else {
            throw new NumberFormatException("String argument is null");
        }
        try {
            action_default(request, response,poll_id);
        } catch (IOException ex) {
            request.setAttribute("exception", ex);
            action_error(request, response);
        }
    }
}
