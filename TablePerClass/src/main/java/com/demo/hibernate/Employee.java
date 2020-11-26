package com.demo.hibernate;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="EMPLOYEE1")
public class Employee extends Person {
	private double salary;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
