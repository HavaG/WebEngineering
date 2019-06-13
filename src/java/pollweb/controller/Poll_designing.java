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
                String log = "Login";
                request.setAttribute("log", log);            
            
            
                //General informations of the Poll
                String poll_title = request.getParameter("poll_title");
                String opening_text = request.getParameter("opening_text");
                String closing_text = request.getParameter("closing_text");
                String poll_reserved = request.getParameter("reserved");
                
                //Question 1
                String question_text_1 = request.getParameter("question_name_1");
                String question_type_1 = request.getParameter("question_type_1"); //short_text, long_text, number, date, single_choice, multiple_choice
                String question_mandatory_1 = request.getParameter("mandatory_1");
                
                //Question 2
                String question_text_2 = request.getParameter("question_name_2");
                String question_type_2 = request.getParameter("question_type_2");
                String question_mandatory_2 = request.getParameter("mandatory_2");
                
                //Question 3
                String question_text_3 = request.getParameter("question_name_3");
                String question_type_3 = request.getParameter("question_type_3");
                String question_mandatory_3 = request.getParameter("mandatory_3");
                
                //Question 4
                String question_text_4 = request.getParameter("question_name_4");
                String question_type_4 = request.getParameter("question_type_4");
                String question_mandatory_4 = request.getParameter("mandatory_4");
                
                //Question 5
                String question_text_5 = request.getParameter("question_name_5");
                String question_type_5 = request.getParameter("question_type_5");
                String question_mandatory_5 = request.getParameter("mandatory_5");
                
                //Question 6
                String question_text_6 = request.getParameter("question_name_6");
                String question_type_6 = request.getParameter("question_type_6");
                String question_mandatory_6 = request.getParameter("mandatory_6");
                
                //Question 7
                String question_text_7 = request.getParameter("question_name_7");
                String question_type_7 = request.getParameter("question_type_7");
                String question_mandatory_7 = request.getParameter("mandatory_7");
                
                //Question 8
                String question_text_8 = request.getParameter("question_name_8");
                String question_type_8 = request.getParameter("question_type_8");
                String question_mandatory_8 = request.getParameter("mandatory_8");
                
                //Question 9
                String question_text_9 = request.getParameter("question_name_9");
                String question_type_9 = request.getParameter("question_type_9");
                String question_mandatory_9 = request.getParameter("mandatory_9");
                
                //Question 10
                String question_text_10 = request.getParameter("question_name_10");
                String question_type_10 = request.getParameter("question_type_10");
                String question_mandatory_10 = request.getParameter("mandatory_10");
            
		this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/poll_designing.jsp").forward(request, response);
	}

}