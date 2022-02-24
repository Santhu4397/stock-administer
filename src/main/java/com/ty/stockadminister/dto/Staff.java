package com.ty.stockadminister.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Staff {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "name should not be null")
	private String name;
	@Pattern(regexp = "[a-z0-9]+@[a-z]+\\.[a-z]{2,3}",message = "Enter proper email id")
	private String email;
	@NotNull(message = "password should not be null")
	private String password;
	@NotNull(message = "phone should not be null")
	private Long phone;
	@ManyToOne
	@JoinColumn
	private Owner owner;
	@OneToMany(mappedBy = "staff")
	private List<Stock> stock;
	
	
	
	public List<Stock> getStock() {
		return stock;
	}

	public void setStock(List<Stock> stock) {
		this.stock = stock;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Staff [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", phone=" + phone
				+ "]";
	}

	public Staff(int id, String name, String email, String password, Long phone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
	}

	public Staff() {
		super();
	}

}
