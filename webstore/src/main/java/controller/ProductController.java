package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.CustomerDAO;
import dao.ProductDAO;
import dao.ProductImp;
import model.Cart;
import model.Product;

//@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductDAO dao;
	private ProductImp dbm;
	private CustomerDAO cDao;
	public static final String lIST_PRODUCTS = "listProducts.jsp";
	public static final String INSERT_OR_EDIT = "product.jsp";
	public static final String CART = "cart.jsp";
	public static final String DETAIL = "ProductDetail";

	@Override
	public void init() throws ServletException {
		dao = new ProductDAO();
		dbm = new ProductImp();
		cDao = new CustomerDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Cart cart;
		HttpSession session = request.getSession();
		if (session == null || session.getAttribute("cart") == null) {
			cart = new Cart(null, new ArrayList<>());
		} else {
			cart = (Cart) session.getAttribute("cart");
		}

		String forward = "";
		String action = request.getParameter("action");

		// if (session != null && session.getAttribute("user") != null) {
		if (action.equalsIgnoreCase("addToCart")) {
			forward = lIST_PRODUCTS;
			int productId = Integer.parseInt(request.getParameter("productId"));
			Product product = dbm.getProductById(productId);
			cart.addProduct(product); // add to product Cart
			session.setAttribute("cart", cart);
			RequestDispatcher view = request.getRequestDispatcher(forward);
			view.forward(request, response);

		}
		else if (action.equalsIgnoreCase("detail")) {
			forward = DETAIL;
			int productId = Integer.parseInt(request.getParameter("productId"));
			Product product = dbm.getProductById(productId);
			session.setAttribute("product", product);
			System.out.println(product.getName());
			RequestDispatcher view = request.getRequestDispatcher(forward);
			view.forward(request, response);

		}
		/*
		 * else if (action.equalsIgnoreCase("edit")) { forward = INSERT_OR_EDIT;
		 * int contactId = Integer.parseInt(request.getParameter("contactId"));
		 * Product contact = dao.getProductById(contactId);
		 * request.setAttribute("contact", contact);
		 * 
		 * } else if (action.equalsIgnoreCase("insert")) { forward =
		 * INSERT_OR_EDIT; }
		 */
		else {
			forward = lIST_PRODUCTS;
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(dbm.getAllProducts());
		    response.setContentType("text/json");
		    response.setCharacterEncoding("UTF-8");

		    out.write(json);
		    out.close();
		    //request.setAttribute("products", dao.getAllProducts());
		}

//		session.setAttribute("products", dao.getAllProducts());
//		session.setAttribute("cusomers", cDao.getAllCustomers());

		/*
		 * } else {
		 * 
		 * }
		 */
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String prName = request.getParameter("name");
		String price = request.getParameter("price");
		String prId = request.getParameter("productId");

		Product product = new Product(0, prName, price, "images/ab.jpg", "");
		if (prId == null || prId.isEmpty()) {
			product.setProductId(dbm.genId());
		} else {
			product.setProductId(Integer.parseInt(prId));
		}
		dbm.addProduct(product);
		RequestDispatcher view = request.getRequestDispatcher(lIST_PRODUCTS);
		request.setAttribute("products", dbm.getAllProducts());
		view.forward(request, response);

	}
}

/*
 * 
 * package controller;
 * 
 * import java.io.IOException;
 * 
 * import javax.servlet.RequestDispatcher; import
 * javax.servlet.ServletException; import javax.servlet.annotation.WebServlet;
 * import javax.servlet.http.HttpServlet; import
 * javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse; import
 * javax.servlet.http.HttpSession;
 * 
 * import dao.ProductDAO; import model.Product;
 * 
 * //@WebServlet("/ProductController") public class ProductController extends
 * HttpServlet { private static final long serialVersionUID = 1L;
 * 
 * private ProductDAO dao; public static final String lIST_CONTACTS =
 * "/listProducts.jsp"; public static final String INSERT_OR_EDIT =
 * "/contact.jsp";
 * 
 * @Override public void init() throws ServletException { dao = new
 * ProductDAO(); }
 * 
 * protected void doGet(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException { HttpSession session =
 * request.getSession(false); String forward = ""; String action =
 * request.getParameter("action"); if (session != null &&
 * session.getAttribute("user") != null) { if
 * (action.equalsIgnoreCase("delete")) { forward = lIST_CONTACTS; int contactId
 * = Integer.parseInt(request.getParameter("contactId"));
 * dao.deleteProduct(contactId); request.setAttribute("contacts",
 * dao.getAllProducts()); } else if (action.equalsIgnoreCase("edit")) { forward
 * = INSERT_OR_EDIT; int contactId =
 * Integer.parseInt(request.getParameter("contactId")); Product contact =
 * dao.getProductById(contactId); request.setAttribute("contact", contact); }
 * else if (action.equalsIgnoreCase("insert")) { forward = INSERT_OR_EDIT; }
 * else { forward = lIST_CONTACTS; request.setAttribute("contacts",
 * dao.getAllProducts()); } RequestDispatcher view =
 * request.getRequestDispatcher(forward); view.forward(request, response);
 * 
 * } else { response.sendRedirect("index.jsp"); } }
 * 
 * protected void doPost(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException {
 * 
 * Product contact = new Product();
 * contact.setName(request.getParameter("name"));
 * contact.setPhone(request.getParameter("phone")); String contactId =
 * request.getParameter("contactId"); if (contactId == null ||
 * contactId.isEmpty()) { contact.setProductId(dao.genId());
 * dao.addProduct(contact); } else {
 * contact.setProductId(Integer.parseInt(contactId));
 * dao.updateProduct(contact); } RequestDispatcher view =
 * request.getRequestDispatcher(lIST_CONTACTS); request.setAttribute("contacts",
 * dao.getAllProducts()); view.forward(request, response);
 * 
 * } }
 */
