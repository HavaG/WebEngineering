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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
