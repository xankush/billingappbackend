package com.billapp.service;

import java.util.List;
import java.util.Optional;

import com.billapp.ENTITY.Customer;
import com.billapp.ENTITY.RentItemPrice;
import com.billapp.ENTITY.Renteditem;

public interface CustomerServices {
	 public List<Customer> showAllCustomer();
	 public Optional<Customer> searchCustomer(int id);
	 public void saveCustomer(Customer s);
	 public List<RentItemPrice> showallitemprice();
	 public void additeminitemlist(RentItemPrice r);
	 public Customer showcustomerrenteditem(int id);
	 void addnewrentitemtouser(int id, String renteditemname, String numberofrenteditem);
}
