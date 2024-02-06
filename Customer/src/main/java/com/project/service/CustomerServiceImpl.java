package com.project.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.business.bean.CustomerBean;
import com.project.dao.CustomerDAOWrapper;

@Service
public class CustomerServiceImpl {
	@Autowired
	private CustomerDAOWrapper custDAOwrapper;
	
	public int addCustomer(CustomerBean custBean) {
		return custDAOwrapper.addCustomer(custBean);
	}
	
	public Collection<CustomerBean> getCustomerDetails(){
		return custDAOwrapper.getCustomerDetails();
	}
	
	public CustomerBean getCustomerDetailByCustomerId(int custId) {
		return custDAOwrapper.getCustomerDetailByCustomerId(custId);
	}
	
	public CustomerBean deleteCustomer(int custId) {
		return custDAOwrapper.deleteCustomer(custId);
	}
	
	public CustomerBean updateCustomer(CustomerBean custBean) {
		return custDAOwrapper.updateCustomer(custBean);
	}

}
