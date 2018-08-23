package com.rollingstone.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class ROShipping {


	private Long id;

	private Long offerId;		
	
	private boolean isAvailable;
	
	private Date availableDate;
	
	private boolean isFree;
		
	private int daysInTransit;	
	
	private Double shippingCharge;
		
	private boolean isFreeShippingForMembers;	

	private String shippingMode;
	

	private String shipCarrier;
	
	private String orderNumber;
	
	private Date orderDate;
	

    private Set<ROShippingLineItem> shippingItems = new HashSet<ROShippingLineItem>();


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getOfferId() {
		return offerId;
	}


	public void setOfferId(Long offerId) {
		this.offerId = offerId;
	}


	public boolean isAvailable() {
		return isAvailable;
	}


	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}


	public Date getAvailableDate() {
		return availableDate;
	}


	public void setAvailableDate(Date availableDate) {
		this.availableDate = availableDate;
	}


	public boolean isFree() {
		return isFree;
	}


	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}


	public int getDaysInTransit() {
		return daysInTransit;
	}


	public void setDaysInTransit(int daysInTransit) {
		this.daysInTransit = daysInTransit;
	}


	public Double getShippingCharge() {
		return shippingCharge;
	}


	public void setShippingCharge(Double shippingCharge) {
		this.shippingCharge = shippingCharge;
	}


	public boolean isFreeShippingForMembers() {
		return isFreeShippingForMembers;
	}


	public void setFreeShippingForMembers(boolean isFreeShippingForMembers) {
		this.isFreeShippingForMembers = isFreeShippingForMembers;
	}


	public String getShippingMode() {
		return shippingMode;
	}


	public void setShippingMode(String shippingMode) {
		this.shippingMode = shippingMode;
	}


	public String getShipCarrier() {
		return shipCarrier;
	}


	public void setShipCarrier(String shipCarrier) {
		this.shipCarrier = shipCarrier;
	}


	public String getOrderNumber() {
		return orderNumber;
	}


	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}


	public Date getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}


	public Set<ROShippingLineItem> getShippingItems() {
		return shippingItems;
	}


	public void setShippingItems(Set<ROShippingLineItem> shippingItems) {
		this.shippingItems = shippingItems;
	}


	public ROShipping(Long id, Long offerId, boolean isAvailable, Date availableDate, boolean isFree, int daysInTransit,
			Double shippingCharge, boolean isFreeShippingForMembers, String shippingMode, String shipCarrier,
			String orderNumber, Date orderDate, Set<ROShippingLineItem> shippingItems) {
		super();
		this.id = id;
		this.offerId = offerId;
		this.isAvailable = isAvailable;
		this.availableDate = availableDate;
		this.isFree = isFree;
		this.daysInTransit = daysInTransit;
		this.shippingCharge = shippingCharge;
		this.isFreeShippingForMembers = isFreeShippingForMembers;
		this.shippingMode = shippingMode;
		this.shipCarrier = shipCarrier;
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.shippingItems = shippingItems;
	}


	public ROShipping() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((availableDate == null) ? 0 : availableDate.hashCode());
		result = prime * result + daysInTransit;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isAvailable ? 1231 : 1237);
		result = prime * result + (isFree ? 1231 : 1237);
		result = prime * result + (isFreeShippingForMembers ? 1231 : 1237);
		result = prime * result + ((offerId == null) ? 0 : offerId.hashCode());
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + ((orderNumber == null) ? 0 : orderNumber.hashCode());
		result = prime * result + ((shipCarrier == null) ? 0 : shipCarrier.hashCode());
		result = prime * result + ((shippingCharge == null) ? 0 : shippingCharge.hashCode());
		result = prime * result + ((shippingItems == null) ? 0 : shippingItems.hashCode());
		result = prime * result + ((shippingMode == null) ? 0 : shippingMode.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ROShipping other = (ROShipping) obj;
		if (availableDate == null) {
			if (other.availableDate != null)
				return false;
		} else if (!availableDate.equals(other.availableDate))
			return false;
		if (daysInTransit != other.daysInTransit)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isAvailable != other.isAvailable)
			return false;
		if (isFree != other.isFree)
			return false;
		if (isFreeShippingForMembers != other.isFreeShippingForMembers)
			return false;
		if (offerId == null) {
			if (other.offerId != null)
				return false;
		} else if (!offerId.equals(other.offerId))
			return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (orderNumber == null) {
			if (other.orderNumber != null)
				return false;
		} else if (!orderNumber.equals(other.orderNumber))
			return false;
		if (shipCarrier == null) {
			if (other.shipCarrier != null)
				return false;
		} else if (!shipCarrier.equals(other.shipCarrier))
			return false;
		if (shippingCharge == null) {
			if (other.shippingCharge != null)
				return false;
		} else if (!shippingCharge.equals(other.shippingCharge))
			return false;
		if (shippingItems == null) {
			if (other.shippingItems != null)
				return false;
		} else if (!shippingItems.equals(other.shippingItems))
			return false;
		if (shippingMode == null) {
			if (other.shippingMode != null)
				return false;
		} else if (!shippingMode.equals(other.shippingMode))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ROShipping [id=" + id + ", offerId=" + offerId + ", isAvailable=" + isAvailable + ", availableDate="
				+ availableDate + ", isFree=" + isFree + ", daysInTransit=" + daysInTransit + ", shippingCharge="
				+ shippingCharge + ", isFreeShippingForMembers=" + isFreeShippingForMembers + ", shippingMode="
				+ shippingMode + ", shipCarrier=" + shipCarrier + ", orderNumber=" + orderNumber + ", orderDate="
				+ orderDate + ", shippingItems=" + shippingItems + "]";
	}
	
	

}
