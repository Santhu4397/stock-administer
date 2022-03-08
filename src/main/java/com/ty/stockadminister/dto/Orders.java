package com.ty.stockadminister.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	@NotNull(message = "Product name should not be null")
	private String productName;
	private int qtyOrder;
	private double totalOrderCost;
	private double qtyRecived;
	private double totalOrderRecived;

	public SupplierDto getDto() {
		return dto;
	}

	public void setDto(SupplierDto dto) {
		this.dto = dto;
	}

	public Owner getOwner2() {
		return owner2;
	}

	public void setOwner2(Owner owner2) {
		this.owner2 = owner2;
	}

	public Staff getStaff1() {
		return staff1;
	}

	public void setStaff1(Staff staff1) {
		this.staff1 = staff1;
	}

	@JsonIgnore
	@ManyToOne
	@JoinColumn
	private SupplierDto dto;
	@JsonIgnore
	@ManyToOne
	@JoinColumn
	private Owner owner2;
	@JsonIgnore
	@ManyToOne
	@JoinColumn
	private Staff staff1;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQtyOrder() {
		return qtyOrder;
	}

	public void setQtyOrder(int qtyOrder) {
		this.qtyOrder = qtyOrder;
	}

	public double getTotalOrderCost() {
		return totalOrderCost;
	}

	public void setTotalOrderCost(double totalOrderCost) {
		this.totalOrderCost = totalOrderCost;
	}

	public double getQtyRecived() {
		return qtyRecived;
	}

	public void setQtyRecived(double qtyRecived) {
		this.qtyRecived = qtyRecived;
	}

	public double getTotalOrderRecived() {
		return totalOrderRecived;
	}

	public void setTotalOrderRecived(double totalOrderRecived) {
		this.totalOrderRecived = totalOrderRecived;
	}

	public Orders(int orderId, @NotNull(message = "Product name should not be null") String productName, int qtyOrder,
			double totalOrderCost, double qtyRecived, double totalOrderRecived, SupplierDto dto, Owner owner2,
			Staff staff1) {
		super();
		this.orderId = orderId;
		this.productName = productName;
		this.qtyOrder = qtyOrder;
		this.totalOrderCost = totalOrderCost;
		this.qtyRecived = qtyRecived;
		this.totalOrderRecived = totalOrderRecived;
		this.dto = dto;
		this.owner2 = owner2;
		this.staff1 = staff1;
	}

	public Orders() {
		super();
		
	}
	
	

}
