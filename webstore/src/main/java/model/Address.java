package model;

public class Address {

	private String shipping;
	private String billing;

	public Address(String shipping, String billing) {
		this.shipping = shipping;
		this.billing = billing;
	}

	public String getShipping() {
		return shipping;
	}

	public void setShipping(String shipping) {
		this.shipping = shipping;
	}

	public String getBilling() {
		return billing;
	}

	public void setBilling(String billing) {
		this.billing = billing;
	}

}
