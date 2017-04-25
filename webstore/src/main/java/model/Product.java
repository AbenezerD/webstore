package model;

public class Product {
	private int productId;
	private String name;
	private String price;
	private String image;
	private String description;

	public Product(int productId, String name, String price, String image, String description) {
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.image = image;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Product))
			return false;
		Product product = (Product) obj;
		return product.getName().equals(this.name) && product.getPrice().equals(this.price)
				&& product.getProductId() == this.productId;
	}

	@Override
	public int hashCode() {
		int result = 17;
		result += 31 * this.productId;
		result += 31 * this.name.hashCode();
		result += 31 * this.price.hashCode();
		return result;
	}

}
