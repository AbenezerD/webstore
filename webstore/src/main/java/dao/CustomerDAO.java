package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Address;
import model.Customer;
import model.User;

public class CustomerDAO {
Map<Integer, Customer> customerDb = new HashMap<>();
	
	{
		customerDb.put(1, new Customer("name","email","99999",200));
	}
	
	public void addCustomer(Customer customer){
		customer.setId(genId());
		customerDb.put(customer.getId(), customer);
	}
	
	public void deleteCustomer(int customerId){
		customerDb.remove(customerId);
	}
	
	public void updateCustomer(Customer customer){
		customerDb.put(customer.getId(), customer);
	}
	
	public List<Customer> getAllCustomers(){
		return new ArrayList<>(customerDb.values());
	}
	
	public Customer getCustomerById(int customerId){
		return customerDb.get(customerId);
	}

	/*public Customer getCustomerByUser(User user){
		for(Customer c : customerDb.values()) {
			if(c.getUser().equals(user))
				return c;
		}
		return null;
	}
	
	public void updateCustomerAddress(Customer customer, Address address) {
		customer.setSbAddress(address);
		updateCustomer(customer);
	}*/
	
	public int genId() {
		return customerDb.size()+1;
	}
}
