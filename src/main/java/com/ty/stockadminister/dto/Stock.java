package com.ty.stockadminister.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Stock {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private String product_Name;
	private String category;
	private double unit_Price;
	private int quantity;
	private double total_Cost;
	private int reorder_Level;
	private int reorder_Quantity;
	@ManyToOne
	@JoinColumn
	private Staff staff;
	@ManyToOne
	@JoinColumn
	private Owner owner1; 
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
		return product_Name;
	}

	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getUnit_Price() {
		return unit_Price;
	}

	public void setUnit_Price(double unit_Price) {
		this.unit_Price = unit_Price;
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
		return reorder_Level;
	}

	public void setReorder_Level(int reorder_Level) {
		this.reorder_Level = reorder_Level;
	}

	public int getReorder_Quantity() {
		return reorder_Quantity;
	}

	public void setReorder_Quantity(int reorder_Quantity) {
		this.reorder_Quantity = reorder_Quantity;
	}

}
