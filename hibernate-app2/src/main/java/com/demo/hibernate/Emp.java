package com.demo.hibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "EMP")
public class Emp {
	@Id
	@Column(name = "EMPNO")
	private int empId;

	@Column(name = "NAME")
	private String empName;

	@Column(name = "ADDRESS")
	private String city;

	// @Column(name="SALARY")
	private double salary;

	@Embedded
	private Address address;
	
	@ElementCollection()
	@CollectionTable(name="IMAGES",joinColumns = @JoinColumn(name="EMPNO"))

	@Column(name="IMAGE_NAME")
	Set<String> images=new HashSet<>();

	public Emp() {

	}

	public Emp(int empId, String empName, String city, double salary) {
		this.empId = empId;
		this.empName = empName;
		this.city = city;
		this.salary = salary;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<String> getImages() {
		return images;
	}

	public void setImages(Set<String> images) {
		this.images = images;
	}

}
