package com.project.dao;

import java.util.ArrayList;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.business.bean.CustomerBean;
import com.project.entity.CustomerEntity;

@Service
public class CustomerDAOWrapper {
	@Autowired
	private CustomerDAO custDAO;

	public int addCustomer(CustomerBean cust) {
		CustomerEntity custEntity = new CustomerEntity();
		BeanUtils.copyProperties(cust, custEntity);
		CustomerEntity cust1 = custDAO.save(custEntity);
		return cust1.getCustId();
	}

	public Collection<CustomerBean> getCustomerDetails() {
		Collection<CustomerEntity> custEntities = custDAO.findAll();
		List<CustomerBean> custBeans = new ArrayList<>();
		for (CustomerEntity custEntity : custEntities) {
			CustomerBean custBean = new CustomerBean();
			BeanUtils.copyProperties(custEntity, custBean);
			custBeans.add(custBean);
		}
		return custBeans;
	}

	public CustomerBean getCustomerDetailByCustomerId(int custId) {
		Optional<CustomerEntity> CustomerEntityResult = custDAO.findById(custId);
		CustomerBean CustomerBean = null;
		if (CustomerEntityResult.isPresent()) {
			CustomerEntity CustomerEntity = CustomerEntityResult.get();
			CustomerBean = new CustomerBean();
			BeanUtils.copyProperties(CustomerEntity, CustomerBean);
		}
		return CustomerBean;
	}

	public CustomerBean deleteCustomer(int custId) {
		Optional<CustomerEntity> CustomerEntityResult = custDAO.findById(custId);
		CustomerBean CustomerBean = null;
		if (CustomerEntityResult.isPresent()) {
			CustomerEntity CustomerEntity = CustomerEntityResult.get();
			custDAO.delete(CustomerEntity);
			CustomerBean = new CustomerBean();
			BeanUtils.copyProperties(CustomerEntity, CustomerBean);
		}
		return CustomerBean;
	}

	public CustomerBean updateCustomer(CustomerBean CustomerBean) {
		Optional<CustomerEntity> CustomerEntityResult = custDAO.findById(CustomerBean.getCustId());
		CustomerBean CustomerBean2=null;
		if (CustomerEntityResult.isPresent()) {
			CustomerEntity CustomerEntity = CustomerEntityResult.get();
			BeanUtils.copyProperties(CustomerBean, CustomerEntity);
			custDAO.save(CustomerEntity);
		}
		return CustomerBean2;
	}

}
