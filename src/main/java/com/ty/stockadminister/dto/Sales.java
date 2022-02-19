package com.ty.stockadminister.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Sales {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private LocalDateTime date_and_time;
	private String email;
	private long phone;
	private int qty;
	private double price;
	@ManyToOne
	@JoinColumn
	private Stock stock; 

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
}
