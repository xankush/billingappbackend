package com.billapp.ENTITY;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ReturnEntries {
	//this class is for if the item are return in the pieces i.e, partially 
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private Integer ReturnEntriesid;
	
	private LocalDate return_date;
	
	private Integer numberofreturnitem;
	
	private Integer daysrented;
	
	private Integer total_rent;
	
	public Integer getReturnEntriesid() {
		return ReturnEntriesid;
	}

	public void setReturnEntriesid(Integer returnEntriesid) {
		ReturnEntriesid = returnEntriesid;
	}

	public LocalDate getReturn_date() {
		return return_date;
	}

	public void setReturn_date(LocalDate return_date) {
		this.return_date = return_date;
	}

	public Integer getNumberofreturnitem() {
		return numberofreturnitem;
	}

	public void setNumberofreturnitem(Integer numberofreturnitem) {
		this.numberofreturnitem = numberofreturnitem;
	}

	public Integer getDaysrented() {
		return daysrented;
	}

	public void setDaysrented(Integer daysrented) {
		this.daysrented = daysrented;
	}

	public Integer getTotal_rent() {
		return total_rent;
	}

	public void setTotal_rent(Integer total_rent) {
		this.total_rent = total_rent;
	}

	public Renteditem getRenteditem() {
		return renteditem;
	}

	public void setRenteditem(Renteditem renteditem) {
		this.renteditem = renteditem;
	}

	//this class have the manytoone relation with the renteditem entity 
	@ManyToOne(optional = false) 
	@JoinColumn(name = "renteditemid")
	@JsonBackReference
	private Renteditem renteditem;

	public ReturnEntries(LocalDate return_date, Integer numberofreturnitem, Integer daysrented, Integer total_rent) {
		super();
		this.return_date = return_date;
		this.numberofreturnitem = numberofreturnitem;
		this.daysrented = daysrented;
		this.total_rent = total_rent;
	}

	public ReturnEntries() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
