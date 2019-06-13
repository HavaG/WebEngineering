package pollweb.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pollweb.data.dao.PollWebDataLayer;
import pollweb.data.impl.UserImpl;
import pollweb.data.model.Manager;
import pollweb.data.model.User;
import pollweb.data.util.DataException;
import pollweb.security.SecurityLayer;

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

//        HttpSession s = SecurityLayer.checkSession(request);
//        if (s == null) {
        this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/login.jsp").forward(request, response);
//        } else {
//            request.setAttribute("exception", new Exception("You already logged in"));
//            action_error(request, response);
//        }

    }

    private void action_login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String userEmail = request.getParameter("email");
        String password = request.getParameter("password");
        //... IDENTITY CHECKS ...

        if (!userEmail.isEmpty() && !password.isEmpty()) {
            //if the identity validation succeeds
            //load userid from user database

            try {
                String log = "Login";
                request.setAttribute("log", log);                  
                
                User user = ((PollWebDataLayer) request.getAttribute("datalayer")).getUserDAO().getUser(userEmail, password);

                //if there is no user with this name and pwd it throws exception
                //create session
                //redirect to homepage
                SecurityLayer.createSession(request, user.getEmail(), user.getKey());
                this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/home.jsp").forward(request, response);

            } catch (DataException ex) {
                //if there is not user with these atributes
                //chech is there any manager
                String message;
                if (ex != null && ex.getMessage() != null) {
                    message = ex.getMessage();
                    if (message.equals("Not existing user")) {
                        try {
                            Manager manager = ((PollWebDataLayer) request.getAttribute("datalayer")).
                                    getManagerDAO().getManager(userEmail, password);
                            SecurityLayer.createSession(request, manager.getEmail(), manager.getKey());
                            
                            if(!userEmail.equals("admin@admin.com")){
                                this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/mana.jsp").forward(request, response);
                            } else {
                                this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/admin.jsp").forward(request, response);
                            }
                        } catch (DataException ex1) {
                            request.setAttribute("exception", ex1);
                            action_error(request, response);
                        }
                    } else {
                        request.setAttribute("exception", ex);
                        action_error(request, response);
                    }
                }
            }
        } else {
            request.setAttribute("exception", new Exception("Login failed"));
            action_error(request, response);
        }
    }

    private void action_create(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String userEmail = request.getParameter("email");
        String password = new PasswordGenerator().generate(16); //generated for the user
        int poll_ID = 0; //the id of the poll, what the user is created for

        if (!userEmail.isEmpty()) {
            try {
                UserImpl user = new UserImpl();
                user.setEmail(userEmail);
                user.setPassword(password);
                user.setPollID(poll_ID);

                //add to database
                ((PollWebDataLayer) request.getAttribute("datalayer")).getUserDAO().storeUser(user);

                //redirect to homepage
                this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/home.jsp").forward(request, response);

            } catch (DataException | ServletException ex) {
                request.setAttribute("exception", ex);
                action_error(request, response);
            }

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
