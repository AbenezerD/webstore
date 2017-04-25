package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Product;


public class ProductDAO {
	
	String description = "Ditching the cheeky, self-aware wink that helped to excuse the concept's inherent corniness, the movie attempts to look polished and 'cool,'"
			+ " but the been-there animation can't compete with the then-cutting-edge puppetry of the 1990 live-action movie.";
	Map<Integer, Product> productDb = new HashMap<>();
	{
		productDb.put(1, new Product(1, "Apple McBook", "$2000.00", "images/ab.jpg", description));
		productDb.put(2, new Product(2, "Samsung Galaxy S6", "$590", "images/ab.jpg", description));
		productDb.put(3, new Product(3, "HTC M8", "$350.00", "images/ab.jpg", description));
		productDb.put(4, new Product(4, "Lenovo Yoga", "$799.99", "images/ab.jpg", description));
		productDb.put(5, new Product(5, "Hp Server", "$3500.00", "images/ab.jpg", description));
		productDb.put(6, new Product(6, "Mouse and KeyBoard set", "$55.00", "images/ab.jpg", description));
	}
	
	public void addProduct(Product product){
		productDb.put(product.getProductId(), product);
	}
	
	public void deleteProduct(int productId){
		productDb.remove(productId);
	}
	
	public void updateProduct(Product product){
		productDb.put(product.getProductId(), product);
	}
	
	public List<Product> getAllProducts(){
		return new ArrayList<>(productDb.values());
	}
	
	public Product getProductById(int productId){
		return productDb.get(productId);
	}

	public int genId() {
		return productDb.size()+1;
	}
}
