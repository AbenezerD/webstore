package controller;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.AddressImp;
import dao.CustomerImp;
import dao.ProductImp;
import model.Address;
import model.Cart;
import model.Customer;
import model.History;
import model.Product;
import model.User;

/**
 * Servlet implementation class AddressController
 */
//@WebServlet("/AddressController")
public class AddressController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerImp dao;
	private AddressImp addressDb;
	private ProductImp productDao;
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
		productDao = new ProductImp();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user_info");
		Customer customer = dao.getCustomerById(user.getUserid());
		
		Address address = addressDb.getAddressById(customer.getAddressId());
		if(address != null) {
			request.getSession().setAttribute("bAddress", address.getBilling());
			request.getSession().setAttribute("sAddress", address.getShipping());
		}
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
		Cart cart = (Cart) request.getSession().getAttribute("cart"); 
		List<Product> products = cart.getProducts(); 
		
		List<Product> newList = new ArrayList<>();
		List<Product> outOfInventory = new ArrayList<>();
		for(Product product:products) {
			product = productDao.getProductById(product.getProductId());
			if(product.getQuantity() > 0) {
				product.setQuantity(product.getQuantity()-1);
				newList.add(product);
			}
			else {
				outOfInventory.add(product);
			}
		}
		
		if(outOfInventory.size() > 0) {
			StringBuilder strBuilder = new StringBuilder("The following item(s) couldn't be found in store:");
			outOfInventory.forEach(p -> strBuilder.append(p.getName() + "\n"));
			request.getSession().setAttribute("bAddress", billingAddress);
			request.getSession().setAttribute("sAddress", shippingAddress);
			
			request.getSession().setAttribute("store", strBuilder.toString());
			response.sendRedirect("addSBaddress.jsp");
		}
		else {
			for(Product product:newList) {
				productDao.updateProduct(product);
			}
			cart.setProducts(newList);
			User user = (User) request.getSession().getAttribute("user_info");
			Customer customer = dao.getCustomerById(user.getUserid());
			
			Address address = new Address(shippingAddress, billingAddress);
			address = addressDb.addCustomerAddress(address);
			//address
			dao.updateCustomerAddress(customer, address);
	
			request.getSession().setAttribute("cart", cart);
			request.getSession().setAttribute("customer", customer);
			request.getSession().setAttribute("address", address);
			
//			ObjectMapper mapper = new ObjectMapper();
//			History history = new History(Instant.now().toString(), newList, shippingAddress
//					, billingAddress, "PaymentInfo-N/A", user.getUsername());
//			//String json = mapper.writeValueAsString(history);
//			List<History> historyList = mapper.readValue(new File(user.getUsername() + ".json"), List.class); 
//			//List<History> historyList = new ArrayList<>();
//			historyList.add(history);
//			try {  
//
//		        mapper.writeValue(new File(user.getUsername() + ".json"), historyList );
//
//		    } catch (IOException e) {  
//		        e.printStackTrace();  
//		    }
			response.sendRedirect("PaymentController");
		}
	}

}
