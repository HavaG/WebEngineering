package pollweb.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pollweb.data.dao.PollWebDataLayer;
import pollweb.data.impl.PollImpl;
import pollweb.data.impl.UserImpl;
import pollweb.data.model.Poll;
import pollweb.data.util.DataException;
import pollweb.security.SecurityLayer;

/**
 * Servlet implementation class servlet_home
 */
public class PollCreate extends PollWebBaseController {

    private Poll tempPoll = null;

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
            Logger.getLogger(PollCreate.class.getName()).log(Level.SEVERE, null, ex1);
        }
    }

    private void action_default(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession s = SecurityLayer.checkSession(request);
        if (s == null) {
            //you have to login
            String log = "Login";
            request.setAttribute("log", log);
            request.setAttribute("message", "You have to log in");

            this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/login.jsp").forward(request, response);
        } else if (s.getAttribute("role").equals("manager")) {
            String log = "Logout";
            request.setAttribute("log", log);
            this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/poll_designing.jsp").forward(request, response);
        } else {
            //you are logged in, but you are not manager
            request.setAttribute("exception", new Exception("You have no rights to open this page"));
            action_error(request, response);
        }
    }

    private void action_create_users(HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.println("createUser");
        String emails = request.getParameter("emails");
        String[] emailArray;

        emails = emails.replaceAll(" ", "");
        emails = emails.trim();

        emailArray = emails.split(",");

        try {
            for (String emailArray1 : emailArray) {
                if (emailArray1 != null) {
                    String password = new PasswordGenerator().generate(16); //generated for the user
                    UserImpl user = new UserImpl();
                    user.setEmail(emailArray1);
                    user.setPassword(password);
                    user.setPoll(tempPoll);

                    System.out.println(emailArray1);
                    //add to database
                    ((PollWebDataLayer) request.getAttribute("datalayer")).getUserDAO().storeUser(user);
                }
            }
            //save the poll
            action_save_poll(request, response);

            //redirect to homepage
            response.sendRedirect(request.getContextPath() + "/Home");

        } catch (DataException | ServletException ex) {
            request.setAttribute("exception", ex);
            action_error(request, response);
        }
    }

    private void action_create_poll(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {

            //create the poll
            //General informations of the Poll
            String poll_title = request.getParameter("poll_title");
            String opening_text = request.getParameter("opening_text");
            String closing_text = request.getParameter("closing_text");
            String poll_reserved = request.getParameter("reserved");
            
            tempPoll = new PollImpl();

            HttpSession s = SecurityLayer.checkSession(request);
            int managerID = (int) s.getAttribute("userid");
            pollweb.data.model.Manager manager = ((PollWebDataLayer) request.getAttribute("datalayer")).getManagerDAO().getManager(managerID);
            tempPoll.setManager(manager);

            tempPoll.setTitle(poll_title);
            tempPoll.setOpenText(opening_text);
            tempPoll.setCloseText(closing_text);

            Boolean reserved = poll_reserved.equals("yes");
            tempPoll.setReserved(reserved);

            
            //TODO
            //Question 1
                String question_text_1 = request.getParameter("question_name_1");
                String question_type_1 = request.getParameter("question_type_1"); //short_text, long_text, number, date, single_choice, multiple_choice
                String question_mandatory_1 = request.getParameter("mandatory_1");
                
                //Question 2
                String question_text_2 = request.getParameter("question_name_2");
                String question_type_2 = request.getParameter("question_type_2");
                String question_mandatory_2 = request.getParameter("mandatory_2");
                
                //Question 3
                String question_text_3 = request.getParameter("question_name_3");
                String question_type_3 = request.getParameter("question_type_3");
                String question_mandatory_3 = request.getParameter("mandatory_3");
                
                //Question 4
                String question_text_4 = request.getParameter("question_name_4");
                String question_type_4 = request.getParameter("question_type_4");
                String question_mandatory_4 = request.getParameter("mandatory_4");
                
                //Question 5
                String question_text_5 = request.getParameter("question_name_5");
                String question_type_5 = request.getParameter("question_type_5");
                String question_mandatory_5 = request.getParameter("mandatory_5");
                
                //Question 6
                String question_text_6 = request.getParameter("question_name_6");
                String question_type_6 = request.getParameter("question_type_6");
                String question_mandatory_6 = request.getParameter("mandatory_6");
                
                //Question 7
                String question_text_7 = request.getParameter("question_name_7");
                String question_type_7 = request.getParameter("question_type_7");
                String question_mandatory_7 = request.getParameter("mandatory_7");
                
                //Question 8
                String question_text_8 = request.getParameter("question_name_8");
                String question_type_8 = request.getParameter("question_type_8");
                String question_mandatory_8 = request.getParameter("mandatory_8");
                
                //Question 9
                String question_text_9 = request.getParameter("question_name_9");
                String question_type_9 = request.getParameter("question_type_9");
                String question_mandatory_9 = request.getParameter("mandatory_9");
                
                //Question 10
                String question_text_10 = request.getParameter("question_name_10");
                String question_type_10 = request.getParameter("question_type_10");
                String question_mandatory_10 = request.getParameter("mandatory_10");
                
                
                
            if (reserved) {
                getServletContext().getRequestDispatcher("/WEB-INF/JSP/poll_user.jsp").forward(request, response);
            } else {
                //save the poll
                action_save_poll(request, response);
            }
            
            //redirect at the end
            response.sendRedirect(request.getContextPath() + "/Home");
            
        } catch (DataException ex) {
            request.setAttribute("exception", ex);
            action_error(request, response);
        }
    }

    private void action_save_poll(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            ((PollWebDataLayer) request.getAttribute("datalayer")).getPollDAO().storePoll(tempPoll);
            tempPoll = null;
        } catch (DataException ex) {
            request.setAttribute("exception", ex);
            action_error(request, response);
        }
    }

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            if (request.getParameter("OK") != null) {
                action_create_poll(request, response);
            } else if (request.getParameter("submit") != null) {
                action_create_users(request, response);
            } else {
                action_default(request, response);
            }
        } catch (IOException ex) {
            request.setAttribute("exception", ex);
            action_error(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Login and create servlet";
    }// </editor-fold>

}
