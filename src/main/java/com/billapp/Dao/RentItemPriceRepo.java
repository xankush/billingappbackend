package com.billapp.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billapp.ENTITY.RentItemPrice;
import com.billapp.ENTITY.Renteditem;

public interface RentItemPriceRepo extends JpaRepository<RentItemPrice, String> {
	
}
