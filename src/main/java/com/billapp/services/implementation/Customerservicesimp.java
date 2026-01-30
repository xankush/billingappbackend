package com.billapp.services.implementation;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billapp.Dao.CustomerListrepository;
import com.billapp.Dao.RentItemPriceRepo;
import com.billapp.Dao.RentItemRepo;
import com.billapp.Dao.ReturnEntriesDAO;
import com.billapp.ENTITY.Customer;
import com.billapp.ENTITY.RentItemPrice;
import com.billapp.ENTITY.Renteditem;
import com.billapp.ENTITY.ReturnEntries;
import com.billapp.service.CustomerServices;

import jakarta.transaction.Transactional;

@Service
public class Customerservicesimp implements CustomerServices {
	@Autowired
    ReturnEntriesDAO returnEntriesDAO;

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

	@Override
	@Transactional
	public void addReturnEntery(Integer renteditem_id, Integer numberofreturnitem, String return_date) {
		// TODO Auto-generated method stub
		
		 if (numberofreturnitem == null || numberofreturnitem <= 0) {
		        // do nothing if 0 or negative
		        return;
		    }
		 
		 
		ReturnEntries returnentries = new ReturnEntries();
		
		returnentries.setNumberofreturnitem(numberofreturnitem);
		
		Optional<Renteditem> rentedItem = getRentedItem(renteditem_id);
		Renteditem renteditem = rentedItem.orElseThrow(() -> new RuntimeException("Customer not found"));
		
		int alreadyReturned = renteditem.getReturnEntries()
	            .stream()
	            .mapToInt(ReturnEntries::getNumberofreturnitem)
	            .sum();
	    int totalQty = Integer.parseInt(renteditem.getNumberofrenteditem());
	    int newTotalReturned = alreadyReturned + numberofreturnitem;

	    // 1) block if new total would exceed total rented quantity
	    if (newTotalReturned > totalQty) {
	        // just return or throw exception; here we choose no-op
	        return;
	    }
	    
		returnentries.setReturn_date(LocalDate.parse(return_date));
		Integer days = (int) ChronoUnit.DAYS.between(renteditem.getRenteddate(), LocalDate.parse(return_date));
		if(days==0) {
			days = 1;
		}
		returnentries.setDaysrented(days);
		
		Integer totalrent = Integer.parseInt(renteditem.getRentitemprice().getItem_rentprice())*days*numberofreturnitem;
		returnentries.setTotal_rent(totalrent);
		
		renteditem.addreturnentry(returnentries);
		
		returnEntriesDAO.save(returnentries);
	}

	@Override
	public Optional<Renteditem> getRentedItem(Integer RentedItem_id) {
		// TODO Auto-generated method stub
		return rentitemrepo.findById(RentedItem_id);
	
	}

}
