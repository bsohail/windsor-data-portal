package net.request.controller;
 
import java.io.*;
import java.sql.SQLException;
 
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import net.request.dao.*;
import net.request.model.*;

@WebServlet("/login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public Login() {
        super();
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	//getting parameters from the JSP file
        String email = request.getParameter("email");
        String password = request.getParameter("password");
         
        UserLoginDao userLoginDao = new UserLoginDao();
         
        try {
        	//checking if the credentials are correct
            Employee user = userLoginDao.checkLogin(email, password);
            String destPage = "login.jsp";
             
            if (user != null) {
            	//if the user is logged in, creating a session
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                destPage = "regSuccess.jsp";
            } else {
            	//incorrect credentials
                String message = "Invalid email/password";
                request.setAttribute("message", message);
            }
             
            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);
             
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }
}