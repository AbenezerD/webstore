package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDAO;
import model.Address;
import model.Customer;
import model.User;

/**
 * Servlet implementation class AddressController
 */
@WebServlet("/AddressController")
public class AddressController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CustomerDAO dao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressController() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
    	dao = new CustomerDAO();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("view/addSBaddress.jsp").forward(request, response);			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String billingAddress = request.getParameter("bAddress");
		String shippingAddress = request.getParameter("sAddress");
		
		Customer customer = (Customer)request.getSession().getAttribute("customer");//, dao.getCustomerByUser(user));

		if(customer != null) {
			dao.addCustomer(customer);
		}
		User user = (User)request.getSession().getAttribute("user_info");
		customer = dao.getCustomerByUser(user);
		dao.updateCustomerAddress(customer, new Address(shippingAddress, billingAddress));
		
		request.getSession().setAttribute("customer", dao.getCustomerByUser(user));
		
		response.sendRedirect("view/confirmation.jsp");
	}

}
