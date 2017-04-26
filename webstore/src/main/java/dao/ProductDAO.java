package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Product;


public class ProductDAO {
	
	Map<Integer, Product> productDb = new HashMap<>();
	
	{
		productDb.put(1, new Product(1,"name","price","image","des"));
		
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
