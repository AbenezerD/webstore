package filter;


import java.io.IOException;
import java.util.HashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

//@WebFilter("/myFilter")
public class myFilter implements Filter {

	public myFilter() {}public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		HttpSession session = req.getSession();
		
		
		if (req.getMethod().equalsIgnoreCase("POST")) {
			System.out.println("my filter .....");
			HttpServletResponse res = (HttpServletResponse) response;
			
			//UserDAO vUsers = new UserDAO();
			HashMap<String, String> vu = new HashMap<>();//vUsers.setOfUsers());
			User currentUser;

			String un = request.getParameter("user_name");
			String pw = request.getParameter("pass");
			
			currentUser = new User(un, pw);
			if (vu.containsKey(currentUser.getUsername()) && vu.get(currentUser.getUsername()).equals(currentUser.getPassword())) {
				System.out.println("input is verfied..");
				
				session.setAttribute("user_info", currentUser);
				
			} else {
				session.setAttribute("err_msg", "Username and/or password invalid.");
				System.out.println("invalid user from doFilter");
			}
		}
		chain.doFilter(req, response);

	}

	public void init(FilterConfig fConfig) throws ServletException {}

}
