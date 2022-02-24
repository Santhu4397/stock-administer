package com.ty.stockadminister.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

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

	@ManyToOne
	@JoinColumn
	private SupplierDto dto;
	@ManyToOne
	@JoinColumn
	private Owner owner2;
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

}
