package pollweb.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pollweb.data.dao.PollWebDataLayer;
import pollweb.data.impl.PollImpl;
import pollweb.data.impl.UserImpl;
import pollweb.data.model.Manager;
import pollweb.data.model.Poll;
import pollweb.data.model.User;
import pollweb.data.util.DataException;
import pollweb.security.SecurityLayer;

/**
 * Servlet implementation class servlet_home
 */
public class Login extends PollWebBaseController {
<<<<<<< HEAD

=======
 
>>>>>>> a9b4f562b2bb7e797b8641cbad8949db3f9f2475
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

        String log = "Login";
        request.setAttribute("log", log);

//        HttpSession s = SecurityLayer.checkSession(request);
<<<<<<< HEAD
//        if (s == null) {
        this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/login.jsp").forward(request, response);
=======
//        if (s == null) {    
            this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/login.jsp").forward(request, response);
>>>>>>> a9b4f562b2bb7e797b8641cbad8949db3f9f2475
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

<<<<<<< HEAD
            try {
=======
            try {              
                
>>>>>>> a9b4f562b2bb7e797b8641cbad8949db3f9f2475
                User user = ((PollWebDataLayer) request.getAttribute("datalayer")).getUserDAO().getUser(userEmail, password);

                //if there is no user with this name and pwd it throws exception
                //create session
                //redirect to homepage
                SecurityLayer.createSession(request, user.getEmail(), user.getKey());
                System.out.println("redirected");

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

                            if (!userEmail.equals("admin@admin.com")) {
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

    //I gonna need this :D
    private void action_create(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String userEmail = request.getParameter("email");
        String password = new PasswordGenerator().generate(16); //generated for the user
        Poll poll = new PollImpl(); //the poll, what the user is created for

        if (!userEmail.isEmpty()) {
            try {
                UserImpl user = new UserImpl();
                user.setEmail(userEmail);
                user.setPassword(password);
                user.setPoll(poll);

                //add to database
                ((PollWebDataLayer) request.getAttribute("datalayer")).getUserDAO().storeUser(user);

                //redirect to homepage
                response.sendRedirect("/WEB-INF/JSP/home.jsp");
                
            } catch (DataException ex) {
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
                System.out.println("home");
                
                System.out.println("redirect");
                String redirect = "/WEB-INF/JSP/home.jsp";
                request.setAttribute("redirect", redirect);
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
