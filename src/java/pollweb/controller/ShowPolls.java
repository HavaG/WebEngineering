/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pollweb.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pollweb.data.dao.PollWebDataLayer;
import pollweb.data.model.Poll;
import pollweb.data.util.DataException;

/**
 *
 * @author venecia2
 */
@WebServlet("/servlet_home")
public class ShowPolls extends PollWebBaseController{
    List<Poll> polls = new ArrayList<>();
    private void action_error(HttpServletRequest request, HttpServletResponse response) {
//        if (request.getAttribute("exception") != null) {
//            (new FailureResult(getServletContext())).activate((Exception) request.getAttribute("exception"), request, response);
//        } else {
//            (new FailureResult(getServletContext())).activate((String) request.getAttribute("message"), request, response);
//        }
    }

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {    
        try{
            List<Poll> polls = new ArrayList<>();
            polls = ((PollWebDataLayer)request.getAttribute("datalayer")).getPollDAO().getUnsignedPolls();
            request.setAttribute("polls", polls);
            //this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/home.jsp").forward(request, response);
       
        } catch (DataException ex) {
                request.setAttribute("message", "Data access exception: " + ex.getMessage());
                action_error(request, response);
//        } catch (IOException ex) {
//            Logger.getLogger(ShowPolls.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

