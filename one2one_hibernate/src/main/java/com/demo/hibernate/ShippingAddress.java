package com.demo.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SHIPPING_ADDRES")
public class ShippingAddress {
	@Id
	private int addressId;
	private String doorNo;
	private String city;
	private String pinCode;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="CUST_ID")
	private Customer customer;

	public ShippingAddress() {
		// TODO Auto-generated constructor stub
	}

	public ShippingAddress(int addressId, String doorNo, String city, String pinCode) {
		this.addressId = addressId;
		this.doorNo = doorNo;
		this.city = city;
		this.pinCode = pinCode;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
