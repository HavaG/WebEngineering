package pollweb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servlet_home
 */
@WebServlet("/Poll_designing")
public class Poll_designing extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Poll_designing() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                String log = "Login";
                request.setAttribute("log", log);
		this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/poll_designing.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
                String poll_title = request.getParameter("poll_title");
                request.setAttribute("poll_title", poll_title);
                String opening_text = request.getParameter("opening_text");
                request.setAttribute("opening_text", opening_text);
                String closing_text = request.getParameter("closing_text");
                request.setAttribute("closing_text", closing_text);
                String poll_reserved = request.getParameter("reserved");
                request.setAttribute("poll_reserved", poll_reserved);
            
            
		this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/poll_designing.jsp").forward(request, response);
	}

}