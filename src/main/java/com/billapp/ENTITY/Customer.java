package com.billapp.ENTITY;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer custmerid ;
	
	@Column(name = "customername")
	private String customer_name; 
	
	@Column(name = "c_address")
	private String customer_address;
	
	@Column(name = "c_phonenumber")
	private String phonenumber;
	
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Renteditem> renteditemlist = new ArrayList<>();



	public Integer getCustmerid() {
		return custmerid;
	}

	public void setCustmerid(Integer custmerid) {
		this.custmerid = custmerid;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_address() {
		return customer_address;
	}

	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public List<Renteditem> getRenteditemlist() {
		return renteditemlist;
	}

	public void setRenteditemlist(List<Renteditem> renteditemlist) {
		this.renteditemlist = renteditemlist;
	}

	public Customer(Integer custmerid, String customer_name, String customer_address, String phonenumber) {
		super();
		this.custmerid = custmerid;
		this.customer_name = customer_name;
		this.customer_address = customer_address;
		this.phonenumber = phonenumber;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Customerlist [custmerid=" + custmerid + ", customer_name=" + customer_name + ", customer_address="
				+ customer_address + ", phonenumber=" + phonenumber + "]";
	}
	
	
}
