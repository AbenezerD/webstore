package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import model.User;

@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CustomerController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("view/addCustomerInfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String uName = request.getParameter("uName");
		String pwd = request.getParameter("pwd");
		
		Customer customer = new Customer(name, email, phone, null, new User(uName, pwd));
		request.getSession().setAttribute("customer", customer);
		request.getSession().setAttribute("user_info", customer.getUser());
		request.getSession().setAttribute("userName", customer.getUser().getUsername());
		
		response.sendRedirect("AddressController");
	}

}
