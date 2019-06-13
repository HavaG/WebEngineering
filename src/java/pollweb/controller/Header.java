/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pollweb.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author venecia2
 */
public class Header extends PollWebBaseController {
    
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
        this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/header.jsp").forward(request, response);
    }

     private void action_logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
            action_error(request, response);
    }
     
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            if (    request.getParameter("login") != null && 
                    request.getParameter("log").equals("Logout")) {
                action_logout(request, response);
            } else {
                action_default(request, response);
            }
        } catch (IOException ex) {
            request.setAttribute("exception", ex);
            action_error(request, response);
        }
    }
}