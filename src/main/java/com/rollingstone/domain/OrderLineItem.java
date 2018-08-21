package com.rollingstone.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ROLLINGSTONE_ORDER_ITEMS")
public class OrderLineItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name="PRODUCT_ID")
	private Product product;
	

	
	@Column(name="quantity_ordered", nullable=false)
	String quantity;
	
	@Column(name="unit_price", nullable=false)
	Double unitPrice;
	
	@Column(name="uom", nullable=false)
	String unitOfMeasurement;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORDER_ID", nullable = false)
	@JsonIgnore
	Order order;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getUnitOfMeasurement() {
		return unitOfMeasurement;
	}

	public void setUnitOfMeasurement(String unitOfMeasurement) {
		this.unitOfMeasurement = unitOfMeasurement;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}



	
	public OrderLineItem() {
		super();
	}
	
	

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public OrderLineItem(Long id, Product product, String quantity, Double unitPrice, String unitOfMeasurement,
			Order order) {
		super();
		this.id = id;
		this.product = product;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.unitOfMeasurement = unitOfMeasurement;
		this.order = order;
	}

	@Override
	public String toString() {
		return "OrderLineItem [id=" + id + ", product=" + product + ", quantity=" + quantity + ", unitPrice="
				+ unitPrice + ", unitOfMeasurement=" + unitOfMeasurement + ", order=" + order + "]";
	}

	
	
	
	
	
}
