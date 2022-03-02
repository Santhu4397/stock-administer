  package com.ty.stockadminister.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.ty.stockadminister.validation.PhoneNumber;

@Entity
public class SupplierDto {
	public SupplierDto() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "name should not be null")
	private String name;
	@Pattern(regexp = "[a-z0-9]+@[a-z]+\\.[a-z]{2,3}",message = "Enter proper email id")
	private String mailId;
	@PhoneNumber
	private long phone;
	@NotNull(message = "address name should not be null")
	private String address;
	@OneToMany(mappedBy = "supplier")
	private List<Stock> stocks;
	@OneToMany(mappedBy = "dto")
	private List<Orders> list;
	@ManyToOne
	private Staff staff;
	@ManyToOne
	private Owner  owner;
	
	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public List<Orders> getList() {
		return list;
	}

	public void setList(List<Orders> list) {
		this.list = list;
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

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}
	 public SupplierDto(int id, @NotNull(message = "name should not be null") String name,
				@Pattern(regexp = "[a-z0-9]+@[a-z]+\\.[a-z]{2,3}", message = "Enter proper email id") String mailId,
				long phone, @NotNull(message = "address name should not be null") String address, List<Stock> stocks,
				List<Orders> list) {
			super();
			this.id = id;
			this.name = name;
			this.mailId = mailId;
			this.phone = phone;
			this.address = address;
			this.stocks = stocks;
			this.list = list;
		}

	

	
	 

}
