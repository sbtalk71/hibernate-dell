package com.demo.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({ 
		@NamedQuery(name = "query1", query = "select e from Emp e where e.empId between 107 and 112"),
		@NamedQuery(name = "query11", query = "select e from Emp e where e.empId between ?1 and :var2"),
		@NamedQuery(name = "query2", query = "select e from Emp e where e.salary>45000"),
		@NamedQuery(name = "joinQuery", query = "select e.empName,e.salary,d.deptName,d.manager from Dept d inner join d.emps e"),

})

@NamedNativeQueries({ 
	@NamedNativeQuery(name = "query3", query = "select name,salary,address from MYEMP") 
	})

@Entity
@Table(name = "MYEMP")
public class Emp {
	@Id
	@Column(name = "EMPNO")
	private int empId;
	@Column(name = "NAME")
	private String empName;

	@Column(name = "ADDRESS")
	private String city;

	@Column(name = "SALARY")
	private double salary;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DNO")
	private Dept dept;

	public Emp() {
		// TODO Auto-generated constructor stub
	}

	public Emp(int empId, String empName, String city, double salary) {
		this.empId = empId;
		this.empName = empName;
		this.city = city;
		this.salary = salary;
	}

	public Emp(String empName, double salary) {

		this.empName = empName;

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

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

}
