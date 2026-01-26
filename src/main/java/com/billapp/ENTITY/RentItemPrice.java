package com.billapp.ENTITY;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class RentItemPrice {

	@Id
	@Column(name = "item_name")
	String item_name;
	
	@Column(name = "item_price")
	String item_rentprice;

	
	
	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getItem_rentprice() {
		return item_rentprice;
	}

	public void setItem_rentprice(String item_rentprice) {
		this.item_rentprice = item_rentprice;
	}

	public RentItemPrice(String item_name, String item_rentprice) {
		super();
		this.item_name = item_name;
		this.item_rentprice = item_rentprice;
	}

	public RentItemPrice() {
		super();
		// TODO Auto-generated constructor stub
	}


	
}
