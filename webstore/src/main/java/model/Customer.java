package model;

public class Customer {

	private int id;
	private String name;
	private String email;
	private String phone;
	private Address sbAddress;
	private User user;

	public Customer(int id, User user) {
		this.id = id;
		this.user = user;
	}
	
	public Customer(String name, String email, String phone, Address sbAddress,
			User user) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.sbAddress = sbAddress;
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String fName) {
		this.name = fName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getSbAddress() {
		return sbAddress;
	}

	public void setSbAddress(Address sbAddress) {
		this.sbAddress = sbAddress;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

}
