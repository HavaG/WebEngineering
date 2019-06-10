package com.octest.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servlet_home
 */
@WebServlet("/servlet_poll_example")
public class servlet_poll_example extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet_poll_example() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String title = "Poll on Hobbies";
            request.setAttribute("title", title);
            
            String opening_text = "Here is a form on hobbies, your data will remain private. Thank you for answering all the questions.";
            request.setAttribute("opening_text", opening_text);
            
            String closing_text = "Thank you for your participation !";
            request.setAttribute("closing_text", closing_text);
            
            this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/poll_example.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/poll_example.jsp").forward(request, response);
	}

}