package com.mkyong.customer.bo.impl;

import java.util.List;

import com.mkyong.customer.bo.CustomerBo;
import com.mkyong.customer.dao.CustomerDao;
import com.mkyong.customer.model.Customer;
 
public class CustomerBoImpl implements CustomerBo{
 
	CustomerDao customerDao;
	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void addCustomer(Customer customer){
		
		customerDao.addCustomer(customer);

	}

	public void editCustomer(Customer customer){
		
		customerDao.editCustomer(customer);

	}	
	public List<Customer> findAllCustomer(){
		
		return customerDao.findAllCustomer();
	}
	public void deleteCustomer(Customer customer){
		
		customerDao.deleteCustomer(customer);
	}
}