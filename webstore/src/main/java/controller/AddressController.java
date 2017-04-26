package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AddressImp;
import dao.CustomerDAO;
import dao.CustomerImp;
import model.Address;
import model.Customer;
import model.User;

/**
 * Servlet implementation class AddressController
 */
//@WebServlet("/AddressController")
public class AddressController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerImp dao;
	private AddressImp addressDb;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddressController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		dao = new CustomerImp();
		addressDb = new AddressImp();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("addSBaddress.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String billingAddress = request.getParameter("bAddress");
		String shippingAddress = request.getParameter("sAddress");

		//Customer customer = dao.getCustomerByUser(user));//(Customer) request.getSession().getAttribute("customer");// ,
																						// dao.getCustomerByUser(user));
//		if (customer != null) {
//			// dao.addCustomer(customer);
//		}

		User user = (User) request.getSession().getAttribute("user_info");
		Customer customer = dao.getCustomerById(user.getUserid());
		
		Address address = new Address(shippingAddress, billingAddress);
		address = addressDb.addCustomerAddress(address);
		//address
		dao.updateCustomerAddress(customer, address);

		request.getSession().setAttribute("customer", customer);
		request.getSession().setAttribute("address", address);
		response.sendRedirect("confirmation.jsp");
	}

}
