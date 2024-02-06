package com.project.web.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.business.bean.CustomerBean;
import com.project.service.CustomerServiceImpl;

@RestController
public class CustomerController {
	@Autowired
	private CustomerServiceImpl custService;

	@RequestMapping(value="cust/controller/getDetails",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<CustomerBean>> getCustomerDetails(){
		Collection <CustomerBean> listcust = custService.getCustomerDetails();
		return new ResponseEntity<Collection<CustomerBean>>(listcust, HttpStatus.OK);
	}
	
	@RequestMapping(value="cust/controller/getDetailsById/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerBean> getCustomerDetailByCustomerId(@PathVariable("id") int myId){
		CustomerBean cust = custService.getCustomerDetailByCustomerId(myId);
		if (cust != null) {
			return new ResponseEntity<CustomerBean>(cust, HttpStatus.OK);
		} else {
			return new ResponseEntity<CustomerBean>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="cust/controller/addCust",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.TEXT_HTML_VALUE)
	public ResponseEntity<String> addCustomer(@RequestBody CustomerBean cust){
		int id= custService.addCustomer(cust);
		return new ResponseEntity<String>("Customer added successfully with id:"+id,HttpStatus.CREATED);
	}
	
	@RequestMapping(value="cust/controller/updateCust",method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerBean> updateCustomer(@RequestBody CustomerBean CustomerBean){
		if (custService.getCustomerDetailByCustomerId(CustomerBean.getCustId()) == null) {
			CustomerBean cust2 = null;
			return new ResponseEntity<CustomerBean>(cust2,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		CustomerBean updated = custService.updateCustomer(CustomerBean);
		return new ResponseEntity<CustomerBean>(updated, HttpStatus.OK);
	}
	@RequestMapping(value="cust/controller/deleteCust/{id}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerBean> deleteCustomer(@PathVariable("id") int myId){
		if (custService.getCustomerDetailByCustomerId(myId) == null) {
			CustomerBean cust2 = null;
			return new ResponseEntity<CustomerBean>(cust2,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		CustomerBean removed = custService.deleteCustomer(myId);
		return new ResponseEntity<CustomerBean>(removed, HttpStatus.OK);
	}

}
