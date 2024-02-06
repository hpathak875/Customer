package com.project.business.bean;

import java.util.Date;



public class CustomerBean {
	private Integer custId;
	private String custName;
	private double bill;
	private Date billingDate;
	public CustomerBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerBean(String custName, Integer custId, double bill, Date billingDate) {
		super();
		this.custName = custName;
		this.custId = custId;
		this.bill = bill;
		this.billingDate = billingDate;
	}
	@Override
	public String toString() {
		return "CustomerBean [custName=" + custName + ", custId=" + custId + ", bill=" + bill + ", billingDate="
				+ billingDate + "]";
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public double getBill() {
		return bill;
	}
	public void setBill(double bill) {
		this.bill = bill;
	}
	public Date getBillingDate() {
		return billingDate;
	}
	public void setBillingDate(Date billingDate) {
		this.billingDate = billingDate;
	}


}
