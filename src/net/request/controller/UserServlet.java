package net.request.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


import net.request.dao.UserDao;
import net.request.model.User;

@WebServlet("/request")
@MultipartConfig(maxFileSize = 16177215)
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
    	//getting parameters from the JSP file
        String userName = request.getParameter("username");
        String email = request.getParameter("email");
        String companyName = request.getParameter("companyname");
        String description = request.getParameter("description");
        InputStream inputStream = null;
        Part filePart = request.getPart("data");
        //String file = request.getParameter("data");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }

        User user = new User();
        user.setUserName(userName);
        user.setEmail(email);
        user.setCompanyName(companyName);
        user.setDescription(description);
        user.setFile(inputStream);

        try {
            userDao.registerUser(user);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        response.sendRedirect("success.jsp");
    }
}