package com.billapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.billapp.ENTITY.Customer;
import com.billapp.ENTITY.RentItemPrice;
import com.billapp.service.CustomerServices;

@RestController
public class billappcontroller {
	@Autowired
	private CustomerServices customerservice;
	
	@GetMapping("/alldata")
	List<Customer> findalluser(){
		return customerservice.showAllCustomer(); 
	}
	
	@PostMapping("/savecustomer")
	void createcustomer(@RequestBody Customer c) {
		customerservice.saveCustomer(c);
	}
	@GetMapping("/showitempricelist")
	List<RentItemPrice> showallpriceofitem(){
		return customerservice.showallitemprice();
	}
	
	@GetMapping("/additem")
	void saveitemprice() {
		RentItemPrice r = new RentItemPrice("carpet", "50");
		
		customerservice.additeminitemlist(r);
	}
	
	@GetMapping("/customer/{id}")
	public Customer showallrenteditemofcustomer(@PathVariable int id ) {
		//TODO: process POST request
		
		return customerservice.showcustomerrenteditem(id);
		
	}
	
	@PostMapping("/customer/{id}")
	public void addnewrentitemforcustomer(@PathVariable int id,@RequestParam String renteditemname, @RequestParam String numberofrentitem) {
		//TODO: process POST request
		
		customerservice.addnewrentitemtouser(id,renteditemname,numberofrentitem);
	}
	
	@PostMapping("/customer/{id}/return-entry")
	public void addreturnentries(@RequestParam int renteditem_id ,@RequestParam int numberofitemreturn,@RequestParam String returndata) {
		customerservice.addReturnEntery(renteditem_id, numberofitemreturn, returndata);
	}
	
}
