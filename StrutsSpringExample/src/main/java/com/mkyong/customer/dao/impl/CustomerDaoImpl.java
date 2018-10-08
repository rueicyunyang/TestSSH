package com.mkyong.customer.dao.impl;

import java.util.Date;
import java.util.List;

import com.mkyong.customer.dao.CustomerDao;
import com.mkyong.customer.model.Customer;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao{
	
	public void addCustomer(Customer customer){
		
		customer.setCreatedDate(new Date());
		customer.setCustomerId(null);
		getHibernateTemplate().save(customer);
	}
	
	public void editCustomer(Customer customer){

		List<Customer> oldCustomerList = getHibernateTemplate().find("from Customer where customerId = '"+customer.getCustomerId()+"'");
		Date createdDate = oldCustomerList.get(0).getCreatedDate();
		customer.setCreatedDate(createdDate);
		getHibernateTemplate().update(customer);
	}
	
	public List<Customer> findAllCustomer(){
		
		return getHibernateTemplate().find("from Customer");
		
	}
	
	public void deleteCustomer(Customer customer){
		List<Customer> oldCustomerList = getHibernateTemplate().find("from Customer where customerId = '"+customer.getCustomerId()+"'");
		Date createdDate = oldCustomerList.get(0).getCreatedDate();
		customer.setCreatedDate(createdDate);
		getHibernateTemplate().delete(customer);
	}
}