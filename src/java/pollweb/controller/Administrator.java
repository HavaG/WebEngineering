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
import pollweb.data.impl.ManagerImpl;
import pollweb.data.model.Manager;
import pollweb.data.model.Poll;
import pollweb.data.util.DataException;
import pollweb.security.SecurityLayer;

public class Administrator extends PollWebBaseController {

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

        HttpSession s = SecurityLayer.checkSession(request);
        if (s == null) {
            //you have to login
            this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/login.jsp").forward(request, response);
        } else if (s.getAttribute("username").equals("admin@admin.com")) {
            //you are the admin
            action_load_managers(request, response);
            this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/admin.jsp").forward(request, response);
        } else {
            //you are logged in, but you are not admin
            request.setAttribute("exception", new Exception("You have no rights to open this page"));
            action_error(request, response);
        }

    }
    
    
    private void action_load_managers(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String log = "Login";
            request.setAttribute("log", log);            
            
            List<Manager> managers = ((PollWebDataLayer) request.getAttribute("datalayer")).getManagerDAO().getManagers();
            
                String the_managers = "Gaabor, Tanya, Aurelien";
                request.setAttribute("managers", the_managers);
                String polls = "Poll 1, Poll 2, Poll 3";
                request.setAttribute("polls", polls);
            
            //TODO: load everything to the user
            
        } catch (DataException ex) {
            request.setAttribute("exception", ex);
            action_error(request, response);
        }

    }

    private void action_create_manager(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String managerEmail = request.getParameter("email");
        String managerPassword = request.getParameter("password");

        if (!managerEmail.isEmpty() && !managerPassword.isEmpty()) {
            try {
                ManagerImpl manager = new ManagerImpl();
                manager.setEmail(managerEmail);
                manager.setPassword(managerPassword);

                //add to database
                ((PollWebDataLayer) request.getAttribute("datalayer")).getManagerDAO().storeManager(manager);

                //redirect to admin page
                this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/admin.jsp").forward(request, response);

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
            if (request.getParameter("create") != null) {
                action_create_manager(request, response);
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
        return "Create manager and ??? servlet";
    }// </editor-fold>

}
