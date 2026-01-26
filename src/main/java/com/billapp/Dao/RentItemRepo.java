package com.billapp.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billapp.ENTITY.Renteditem;

public interface RentItemRepo extends JpaRepository<Renteditem, Integer> {


	
}
