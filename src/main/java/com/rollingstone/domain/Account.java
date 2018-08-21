package com.rollingstone.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="ROLLINGSTONE_ACCOUNT")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@Column(name="account_number", nullable = false)
	String accountNumber;
	
	@Column(name="account_name", nullable = false)
	String accountName;
	
	@OneToOne
	@JoinColumn(name="USER_PROFILE_ID")
	private User user;
	
	/*
	 * One Account may have Many Addresses like Separate Shipping Address, and Billing Address
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	@JsonIgnore private Set<Address> addresses = new HashSet<Address>();
	
	/*
	 * One Account may have Many place many Orders
	 
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	@JsonIgnore private Set<Order> orders = new HashSet<Order>();*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	/*public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}*/

	
	public String getAccountName() {
		return accountName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Account(Long id, User user, Set<Address> addresses) {
		super();
		this.id = id;
		this.user = user;
		this.addresses = addresses;
		//this.orders = orders;
	}

	public Account() {
		super();
	}

	

	@Override
	public String toString() {
		return "Account [id=" + id + ", accountName=" + accountName + ", user=" + user + ", addresses=" + addresses
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountName == null) ? 0 : accountName.hashCode());
		result = prime * result + ((addresses == null) ? 0 : addresses.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Account other = (Account) obj;
		if (accountName == null) {
			if (other.accountName != null)
				return false;
		} else if (!accountName.equals(other.accountName))
			return false;
		if (addresses == null) {
			if (other.addresses != null)
				return false;
		} else if (!addresses.equals(other.addresses))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	
	
	
}
