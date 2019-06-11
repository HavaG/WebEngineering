package pollweb.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pollweb.data.dao.PollWebDataLayer;
import pollweb.data.impl.UserImpl;
import pollweb.data.model.User;
import pollweb.data.util.DataException;

public class Login extends PollWebBaseController {

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

    private void action_default(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //add to the template a wrapper object that allows to call the stripslashes function

        this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/login.jsp").forward(request, response);
    }

    private void action_login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String userEmail = request.getParameter("email");
        String password = request.getParameter("password");
        //... IDENTITY CHECKS ...

        if (!userEmail.isEmpty() && !password.isEmpty()) {
            //if the identity validation succeeds
            //load userid from user database

            try {
                User user = ((PollWebDataLayer) request.getAttribute("datalayer")).getUserDAO().getUser(userEmail, password);

                //if there is no user with this name and pwd it throws exception
                //create session
                //redirect to homepage
                //TODO
                //SecurityLayer.createSession(request, user.getEmail(), user.getKey());
                response.sendRedirect("/WEB-INF/JSP/home.jsp");

            } catch (DataException ex) {
                request.setAttribute("exception", ex);
                action_error(request, response);
            }
        } else {
            request.setAttribute("exception", new Exception("Login failed"));
            action_error(request, response);
        }
    }

    private void action_create(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userEmail = request.getParameter("email");
        String password = request.getParameter("pwd");

        if (!userEmail.isEmpty() && !password.isEmpty()) {
            try {

                //this is the create part
                //this methos is not using userProxy!!
                UserImpl user = new UserImpl();
                user.setEmail(userEmail);
                user.setPassword(password);

                //add to database
                ((PollWebDataLayer) request.getAttribute("datalayer")).getUserDAO().storeUser(user);

            } catch (DataException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }

            //redirect to homepage
            response.sendRedirect("issues");
        } else {
            request.setAttribute("exception", new Exception("Creation failed"));
            action_error(request, response);
        }
    }

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            if (request.getParameter("login") != null) {
                action_login(request, response);
            } else if (request.getParameter("create") != null) {
                action_create(request, response);
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
