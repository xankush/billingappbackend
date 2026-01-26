package com.billapp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billapp.ENTITY.Customer;

public interface CustomerListrepository extends JpaRepository<Customer, Integer> {

}
