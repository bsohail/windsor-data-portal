package net.request.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.Before;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.request.controller.UserServlet;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
 
public class UserServletTest {
 
    @Mock
    HttpServletRequest request;
 
    @Mock
    HttpServletResponse response;
 
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
 
    @Test
    public void testFullName() throws IOException, ServletException {
 
        when(request.getParameter("username")).thenReturn("Bilal");
        when(request.getParameter("email")).thenReturn("test@test.com");
        when(request.getParameter("username")).thenReturn("sohailb");
        when(request.getParameter("password")).thenReturn("secret-password");
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
         
        when(response.getWriter()).thenReturn(pw);
 
        UserServlet myServlet =new UserServlet();
        myServlet.doGet(request, response);
        String result = sw.getBuffer().toString().trim();
        assertEquals(result, new String("Name: Bilal"));
 
    }
}