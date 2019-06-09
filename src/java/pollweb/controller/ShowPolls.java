/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pollweb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pollweb.data.dao.PollWebDataLayer;
import pollweb.data.util.DataException;

/**
 *
 * @author venecia2
 */
public class ShowPolls extends PollWebBaseController{
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
            request.setAttribute("poll_title", "Polls");
            request.setAttribute("polls", ((PollWebDataLayer)request.getAttribute("datalayer")).getPollDAO().getUnsignedPolls());

        } catch (DataException ex) {
                request.setAttribute("message", "Data access exception: " + ex.getMessage());
                action_error(request, response);
        }
    }
}
