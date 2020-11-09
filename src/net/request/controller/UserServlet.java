package net.request.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.request.dao.UserDao;
import net.request.model.User;

@WebServlet("/register")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDao;

    public void init() {
        userDao = new UserDao();
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException{
    	RequestDispatcher dispatcher = request.getRequestDispatcher("userdata.jsp");
		dispatcher.forward(request, response);	
    	    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("username");
        String email = request.getParameter("email");
        String companyName = request.getParameter("companyname");
        String description = request.getParameter("description");
        String file = request.getParameter("file");
        

        User user = new User();
        user.setUserName(userName);
        user.setEmail(email);
        user.setCompanyName(companyName);
        user.setDescription(description);
        user.setFile(file);

        try {
            userDao.registerUser(user);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        response.sendRedirect("success.jsp");
    }
}