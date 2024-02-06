package com.project.entity;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="customer")
public class CustomerEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="custid")
	private Integer custId;
	@Column(name="custname")
	private String custName;
	@Column(name="billingdate")
	private Date billingDate;
	@Column(name="bill")
	private double bill;
	public CustomerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerEntity(Integer custId, String custName, double bill, Date billingDate) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.bill = bill;
		this.billingDate = billingDate;
	}
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
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
	@Override
	public String toString() {
		return "CustomerEntity [custId=" + custId + ", custName=" + custName + ", bill=" + bill + ", billingDate="
				+ billingDate + "]";
	}


}
