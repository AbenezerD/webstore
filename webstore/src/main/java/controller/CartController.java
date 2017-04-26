package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDAO;
import model.Cart;
import model.Product;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/Cart")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO dao;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		dao = new ProductDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Cart cart;
//		HttpSession session = request.getSession(false);
//		if (session == null || session.getAttribute("cart") == null) {
//			cart = new Cart(null, new ArrayList<>());
//		} else {
//			cart = (Cart) session.getAttribute("cart");
//		}
//
//		int productId = Integer.parseInt(request.getParameter("remove"));
//		Product product = dao.getProductById(productId);
//		cart.removeProduct(product); // add to product Cart
//		session.setAttribute("cart", cart);
//		
		RequestDispatcher view = request.getRequestDispatcher("cart.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cart cart;
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("cart") == null) {
			cart = new Cart(null, new ArrayList<>());
		} else {
			cart = (Cart) session.getAttribute("cart");
		}

		int productId = Integer.parseInt(request.getParameter("productId"));
		Product product = dao.getProductById(productId);
		cart.removeProduct(product); // add to product Cart
		session.setAttribute("cart", cart);
		
		RequestDispatcher view = request.getRequestDispatcher("cart.jsp");
		view.forward(request, response);
	}

}
