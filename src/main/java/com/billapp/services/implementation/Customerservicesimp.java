package com.billapp.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billapp.Dao.CustomerListrepository;
import com.billapp.Dao.RentItemPriceRepo;
import com.billapp.Dao.RentItemRepo;
import com.billapp.ENTITY.Customer;
import com.billapp.ENTITY.RentItemPrice;
import com.billapp.ENTITY.Renteditem;
import com.billapp.service.CustomerServices;

@Service
public class Customerservicesimp implements CustomerServices {

	@Autowired
	CustomerListrepository customerrepository;

	@Autowired
	RentItemPriceRepo rentitempricerepo;
	
	@Autowired
	RentItemRepo rentitemrepo;

	@Override
	public List<Customer> showAllCustomer() {
		// TODO Auto-generated method stub
		return customerrepository.findAll();
	}

	@Override
	public Optional<Customer> searchCustomer(int id) {
		// TODO Auto-generated method stub
		return customerrepository.findById(id);
	}

	@Override
	public void saveCustomer(Customer s) {
		// TODO Auto-generated method stub
		   for (Renteditem r : s.getRenteditemlist()) {
		        r.setCustomer(s);
		    }
		customerrepository.save(s);
	}

	@Override
	public List<RentItemPrice> showallitemprice() {
		// TODO Auto-generated method stub
		return rentitempricerepo.findAll();
	}

	@Override
	public void additeminitemlist(RentItemPrice r) {
		// TODO Auto-generated method stub

		rentitempricerepo.save(r);

	}

	@Override
	public Customer showcustomerrenteditem(int id) {
		// TODO Auto-generated method stub
		Optional<Customer> byId = customerrepository.findById(id);
		Customer c = byId.orElseThrow(() -> new RuntimeException("Customer not found"));

		return c;
	}

	@Override
	public void addnewrentitemtouser(int id, String renteditemname , String numberofrenteditem) {
		// TODO Auto-generated method stub
		Optional<Customer> byId = customerrepository.findById(id);
		Customer c = byId.orElseThrow(() -> new RuntimeException("Customer not found"));
		Renteditem r = new Renteditem();
		r.setItem_name(renteditemname);
		r.setCustomer(c);
		r.setNumberofrenteditem(numberofrenteditem);
//		Optional<Renteditem> rentitem = rentitemrepo.findByItem_name(renteditemname);
//		Renteditem rt = rentitem.orElseThrow(() -> new RuntimeException("item not found"));
		c.getRenteditemlist().add(r);
		customerrepository.save(c);
	}

}
