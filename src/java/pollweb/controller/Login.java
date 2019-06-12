package pollweb.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pollweb.data.dao.PollWebDataLayer;

/**
 * Servlet implementation class servlet_home
 */

@WebServlet("/servlet_login")
public class Login extends PollWebBaseController {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
            try {                
                this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/login.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

}
