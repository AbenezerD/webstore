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

import dao.UserDAO;
import model.User;

//@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Login() {}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("user_info") == null)
			request.getRequestDispatcher("view/login.jsp").forward(request, response);
		else
			response.sendRedirect("AddressController");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	

		UserDAO vUsers = new UserDAO();
		HashMap<String, String> vu = new HashMap<>(vUsers.setOfUsers());
		User user;

		String un = request.getParameter("user_name");
		String pw = request.getParameter("pass");
		String remember = request.getParameter("remember");
		
		user = new User(un, pw);
		if (vu.containsKey(user.getUsername()) && vu.get(user.getUsername()).equals(user.getPassword())) {
	
			request.getSession().setAttribute("userName", user.getUsername());
			 
			if("on".equals(remember)){
				Cookie cok= new Cookie("user",user.getUsername());
				cok.setMaxAge(1*24*60*60);
				response.addCookie(cok);
			}else{
				Cookie cok= new Cookie("user", null);
				cok.setMaxAge(0);
				response.addCookie(cok);
			}

			response.sendRedirect("AddressController");
		}
		else {	
			request.setAttribute("err_msg", "Username and/or password invalid.");
			request.getRequestDispatcher("view/login.jsp").forward(request, response);
			
		}
	}

}
