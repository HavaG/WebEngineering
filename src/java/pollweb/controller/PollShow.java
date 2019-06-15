package pollweb.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pollweb.data.dao.PollWebDataLayer;
import pollweb.data.model.Poll;
import pollweb.data.model.Question;
import pollweb.data.util.DataException;
import pollweb.security.SecurityLayer;

/**
 * Servlet implementation class servlet_home
 */
public class PollShow extends PollWebBaseController {
    
    private void action_error(HttpServletRequest request, HttpServletResponse response) {
        HttpSession s = SecurityLayer.checkSession(request);
        String log;
        if (s == null) {
            log = "Login";
        } else {
            log = "Logout";
        }
        request.setAttribute("log", log);

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

    private void action_default(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            int poll_id = 1;
            
                //TODO: get the poll ID
//            if (request.getParameter("pollID") != null) {   
//                System.out.println(request.getParameter("pollID"));        
//                poll_id = Integer.parseInt(request.getParameter("pollID"));
//                System.out.println(poll_id);
//            } else {
//              throw new NumberFormatException("String argument is null");
//            }

            Poll poll = ((PollWebDataLayer) request.getAttribute("datalayer")).getPollDAO().getPoll(poll_id);
            List<Question> questions = ((PollWebDataLayer) request.getAttribute("datalayer")).getQuestionDAO().getQuestionsByPoll(poll);
            if(questions.isEmpty()){
                action_error(request, response);
            }
            request.setAttribute("poll", poll);
            request.setAttribute("questions", questions);
            this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/poll_example.jsp").forward(request, response);

        } catch (DataException ex) {
            request.setAttribute("exception", ex);
            action_error(request, response);
        }
    }

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        try { 
            action_default(request, response);
        } catch (IOException ex) {
            request.setAttribute("exception", ex);
            action_error(request, response);
        }
    }
}