package pollweb.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import pollweb.data.model.User;
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
            int poll_id;

            if (request.getParameter("pollID") != null) {
                System.out.println(request.getParameter("pollID"));
                poll_id = Integer.parseInt(request.getParameter("pollID"));
            } else {
                throw new NumberFormatException("String argument is null");
            }

            Poll poll = ((PollWebDataLayer) request.getAttribute("datalayer")).getPollDAO().getPoll(poll_id);
            List<Question> questions = ((PollWebDataLayer) request.getAttribute("datalayer")).getQuestionDAO().getQuestionsByPoll(poll);
            if (questions.isEmpty()) {
                request.setAttribute("exception", new Exception("No questions were found"));
                action_error(request, response);
            }

            HttpSession s = SecurityLayer.checkSession(request);
            if (poll.isReserved()) {
                String role = (String) s.getAttribute("role");
                int ID = (int) s.getAttribute("userid");
                if (role.equals("user")) {

                    User user = ((PollWebDataLayer) request.getAttribute("datalayer")).getUserDAO().getUser(ID);
                    if (user.getPoll().getKey() != poll.getKey()) {
                        request.setAttribute("exception", new Exception("You have no rights to visit this form"));
                        action_error(request, response);
                    }
                } else if (role.equals("manager") && poll.getManager().getKey() != ID) {
                    request.setAttribute("exception", new Exception("This poll is not belongs to you"));
                    action_error(request, response);
                }
            }

            request.setAttribute("poll", poll);
            request.setAttribute("questions", questions);

            //TODO
            //if the s.getManagerID = poll.managerID --> MODIFY
            request.setAttribute("manager", questions);

            this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/poll_example.jsp").forward(request, response);

        } catch (DataException ex) {
            request.setAttribute("exception", ex);
            action_error(request, response);
        }
    }

    private void action_modify(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.sendRedirect(request.getContextPath() + "/Home");
    }

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        try {
            if (request.getParameter("save") != null) {
                action_modify(request, response);
            } else {
                action_default(request, response);
            }
        } catch (IOException ex) {
            request.setAttribute("exception", ex);
            action_error(request, response);
        }
    }
}
