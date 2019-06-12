package com.octest.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pollweb.data.dao.PollWebDataLayer;
import pollweb.data.model.Poll;
import pollweb.data.util.DataException;

/**
 * Servlet implementation class servlet_home
 */
//@WebServlet("/servlet_home")
public class servlet_home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet_home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             List<Poll> polls = new ArrayList<>();
            try {
                polls = ((PollWebDataLayer)request.getAttribute("datalayer")).getPollDAO().getUnsignedPolls();
            } catch (DataException ex) {
                Logger.getLogger(servlet_home.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("polls", polls);
            this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/home.jsp").forward(request, response);
                
//                String[] titles = {"Poll on Hobbies", "Poll on Pasta", "Poll on Events", "Poll on Sport", "Poll on Cinema", "Poll on Sleep"};
//                request.setAttribute("titles", titles);
//            
//		this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/home.jsp").forward(request, response);
	}

}
