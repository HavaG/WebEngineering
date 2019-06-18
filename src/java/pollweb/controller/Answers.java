package pollweb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import pollweb.data.dao.PollWebDataLayer;


@WebServlet("/Test")
public class Answers extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    @Resource(name = "jdbc/pollwebdb")
    private DataSource ds;

    public Answers() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void processBaseRequest(HttpServletRequest request, HttpServletResponse response) {
        try (PollWebDataLayer datalayer = new PollWebDataLayer(ds)) {
            
            
            this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/answers.jsp").forward(request, response);
            
        } catch (Exception ex) {
            ex.printStackTrace(); //for debugging only
//            (new FailureResult(getServletContext())).activate(
//            (ex.getMessage() != null || ex.getCause() == null) ? ex.getMessage() : ex.getCause().getMessage(), request, response);
        }
    }    


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processBaseRequest(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processBaseRequest(request, response);
        // TODO Auto-generated method stub
    }

}
