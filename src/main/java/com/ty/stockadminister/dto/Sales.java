package com.ty.stockadminister.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ty.stockadminister.validation.PhoneNumber;
@Entity
public class Sales {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "Name should not be null")
	private String name;
	private LocalDateTime date_and_time;
	@Pattern(regexp = "[a-z0-9]+@[a-z]+\\.[a-z]{2,3}",message = "Enter proper email id")
	private String email;
	@PhoneNumber
	private long phone;
	@NotNull(message = "Quantity should not be null")
	private int qty;
	@NotNull(message = "Price should not be null")
	private double price;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn
	private Stock stock;
	    
	@ManyToOne
	private Staff staff;
	

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getDate_and_time() {
		return date_and_time;
	}

	public void setDate_and_time(LocalDateTime date_and_time) {
		this.date_and_time = date_and_time;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email; 
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Sales(int id, @NotNull(message = "Name should not be null") String name, LocalDateTime date_and_time,
			@Pattern(regexp = "[a-z0-9]+@[a-z]+\\.[a-z]{2,3}", message = "Enter proper email id") String email,
			long phone, @NotNull(message = "Quantity should not be null") int qty,
			@NotNull(message = "Price should not be null") double price, Stock stock) {
		super();
		this.id = id;
		this.name = name;
		this.date_and_time = date_and_time;
		this.email = email;
		this.phone = phone;
		this.qty = qty;
		this.price = price;
		this.stock = stock;
	}

	public Sales() {
		super();
	}
	
}
