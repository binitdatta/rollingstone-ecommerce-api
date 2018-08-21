package com.rollingstone.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class ROOrder {


	private Long id;
	
	String orderNumber;

	String orderTrackingNumber;	
	
	private Date orderDate;
	
	Double orderTotal;	
	
	private String userName;
	
	private String firstName;	

	private String lastName;	

	private String sex;	

	private String memberType;	

	private Date rgistrationDate;
	
	
	private String shippingHouseNumber;
	

	private String shippingStreetAddress;

	
	private String shippingCity;
	
	private String shippingState;
	
	
	private String shippingZipCode;
	

	
	private String billingHouseNumber;
	

	private String billingStreetAddress;

	
	private String billingCity;
	
	private String billingState;
	
	
	private String billingZipCode;
	
	private String accountNumber;
	
	
	private String accountName;

    private Set<ROrderLineItem> orderItems = new HashSet<ROrderLineItem>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOrderTrackingNumber() {
		return orderTrackingNumber;
	}

	public void setOrderTrackingNumber(String orderTrackingNumber) {
		this.orderTrackingNumber = orderTrackingNumber;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(Double orderTotal) {
		this.orderTotal = orderTotal;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public Date getRgistrationDate() {
		return rgistrationDate;
	}

	public void setRgistrationDate(Date rgistrationDate) {
		this.rgistrationDate = rgistrationDate;
	}

	public String getShippingHouseNumber() {
		return shippingHouseNumber;
	}

	public void setShippingHouseNumber(String shippingHouseNumber) {
		this.shippingHouseNumber = shippingHouseNumber;
	}

	public String getShippingStreetAddress() {
		return shippingStreetAddress;
	}

	public void setShippingStreetAddress(String shippingStreetAddress) {
		this.shippingStreetAddress = shippingStreetAddress;
	}

	public String getShippingCity() {
		return shippingCity;
	}

	public void setShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}

	public String getShippingState() {
		return shippingState;
	}

	public void setShippingState(String shippingState) {
		this.shippingState = shippingState;
	}

	public String getShippingZipCode() {
		return shippingZipCode;
	}

	public void setShippingZipCode(String shippingZipCode) {
		this.shippingZipCode = shippingZipCode;
	}

	public String getBillingHouseNumber() {
		return billingHouseNumber;
	}

	public void setBillingHouseNumber(String billingHouseNumber) {
		this.billingHouseNumber = billingHouseNumber;
	}

	public String getBillingStreetAddress() {
		return billingStreetAddress;
	}

	public void setBillingStreetAddress(String billingStreetAddress) {
		this.billingStreetAddress = billingStreetAddress;
	}

	public String getBillingCity() {
		return billingCity;
	}

	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}

	public String getBillingState() {
		return billingState;
	}

	public void setBillingState(String billingState) {
		this.billingState = billingState;
	}

	public String getBillingZipCode() {
		return billingZipCode;
	}

	public void setBillingZipCode(String billingZipCode) {
		this.billingZipCode = billingZipCode;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Set<ROrderLineItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<ROrderLineItem> orderItems) {
		this.orderItems = orderItems;
	}

	public ROOrder(Long id, String orderNumber, String orderTrackingNumber, Date orderDate, Double orderTotal,
			String userName, String firstName, String lastName, String sex, String memberType, Date rgistrationDate,
			String shippingHouseNumber, String shippingStreetAddress, String shippingCity, String shippingState,
			String shippingZipCode, String billingHouseNumber, String billingStreetAddress, String billingCity,
			String billingState, String billingZipCode, String accountNumber, String accountName,
			Set<ROrderLineItem> orderItems) {
		super();
		this.id = id;
		this.orderNumber = orderNumber;
		this.orderTrackingNumber = orderTrackingNumber;
		this.orderDate = orderDate;
		this.orderTotal = orderTotal;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.sex = sex;
		this.memberType = memberType;
		this.rgistrationDate = rgistrationDate;
		this.shippingHouseNumber = shippingHouseNumber;
		this.shippingStreetAddress = shippingStreetAddress;
		this.shippingCity = shippingCity;
		this.shippingState = shippingState;
		this.shippingZipCode = shippingZipCode;
		this.billingHouseNumber = billingHouseNumber;
		this.billingStreetAddress = billingStreetAddress;
		this.billingCity = billingCity;
		this.billingState = billingState;
		this.billingZipCode = billingZipCode;
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.orderItems = orderItems;
	}

	public ROOrder() {
		super();
	}
    
	
    
}
