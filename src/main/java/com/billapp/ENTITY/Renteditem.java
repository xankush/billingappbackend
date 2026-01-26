package com.billapp.ENTITY;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Renteditem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer renteditemid;
	
	@Column(name = "item_name")
	private String item_name;
	
	@Column(name = "number_of_item_rented")
	private String numberofrenteditem;
	
	@ManyToOne
	@JoinColumn(name = "customerid")
	@JsonBackReference
	private Customer customer;
	
	public RentItemPrice getRentitemprice() {
		return rentitemprice;
	}

	public void setRentitemprice(RentItemPrice rentitemprice) {
		this.rentitemprice = rentitemprice;
	}

	public Integer getRenteditemid() {
		return renteditemid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_name",insertable = false, updatable = false)
	private RentItemPrice rentitemprice;

	

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getNumberofrenteditem() {
		return numberofrenteditem;
	}

	public void setNumberofrenteditem(String numberofrenteditem) {
		this.numberofrenteditem = numberofrenteditem;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setRenteditemid(Integer renteditemid) {
		this.renteditemid = renteditemid;
	}

	public Renteditem(String item_name, String numberofrenteditem) {
		super();
		this.item_name = item_name;
		this.numberofrenteditem = numberofrenteditem;
	}

	public Renteditem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
