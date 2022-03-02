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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Stock {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	@NotNull(message = "Product name should not be null")
	private String productName;
	@NotNull(message = "category should not be null")
	private String category;
	@NotNull(message = "unit_Price should not be null")
	private double unitPrice;
	@NotNull(message = "quantity should not be null")
	private int quantity;
	@NotNull(message = "total_Cost should not be null")
	private double total_Cost;
	private int reorderLevel;
	private int reorderQuantity;
	@JsonIgnore
	@ManyToOne
	@JoinColumn
	private Staff staff;
	@JsonIgnore
	@ManyToOne
	@JoinColumn
	private Owner owner1; 
	@JsonIgnore
	@ManyToOne
	@JoinColumn
	private SupplierDto supplier;
	@OneToMany(mappedBy = "stock")
	private List<Sales> sales;
	
	
	public SupplierDto getSupplier() {
		return supplier;
	}

	public void setSupplier(SupplierDto supplier) {
		this.supplier = supplier;
	}

	public Owner getOwner1() {
		return owner1;
	}

	public void setOwner1(Owner owner1) {
		this.owner1 = owner1;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduct_Name() {
		return productName;
	}

	public void setProduct_Name(String product_Name) {
		this.productName = product_Name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getUnit_Price() {
		return unitPrice;
	}

	public void setUnit_Price(double unit_Price) {
		this.unitPrice = unit_Price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotal_Cost() {
		return total_Cost;
	}

	public void setTotal_Cost(double total_Cost) {
		this.total_Cost = total_Cost;
	}

	public int getReorder_Level() {
		return reorderLevel;
	}

	public void setReorder_Level(int reorder_Level) {
		this.reorderLevel = reorder_Level;
	}

	public int getReorder_Quantity() {
		return reorderQuantity;
	}

	public void setReorder_Quantity(int reorder_Quantity) {
		this.reorderQuantity = reorder_Quantity;
	}

}
