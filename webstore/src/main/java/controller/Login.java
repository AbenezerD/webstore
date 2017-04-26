package controller;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserImp;
import model.User;

//@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Login() {}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("user_info") == null)
			request.getRequestDispatcher("login.jsp").forward(request, response);
		else
			response.sendRedirect("AddressController");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	

		UserImp userDb = new UserImp();
		
		String un = request.getParameter("user_name").trim();
		String pw = request.getParameter("pass").trim();
		String remember = request.getParameter("remember");
		
		User user=userDb.getUserById(un);

		if (user.getUsername().trim().equals(un) && user.getPassword().trim().equals(pw)) {
			
			request.getSession().setAttribute("userName", user.getUsername());
			 
			if("on".equals(remember)){
				Cookie cookie= new Cookie("user",user.getUsername());
				cookie.setMaxAge(1*24*60*60);
				response.addCookie(cookie);
			}else{
				Cookie cookie= new Cookie("user", null);
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
			request.getSession().setAttribute("user_info", user);
			response.sendRedirect("AddressController");
		}
		else {	
			request.setAttribute("err_msg", "Username and/or password invalid.");
			doGet(request, response);			
		}
	}

}
