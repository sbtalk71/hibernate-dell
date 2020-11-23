package com.demo.hibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="MYDEPT")
public class Dept {
	@Id
	@Column(name="DNO")
	private int deptNo;
	
	@Column(name="DNAME")
	private String deptName;
	
	@Column(name="MANAGER")
	private String manager;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "dept")
	//@JoinColumn(name="DNO")
	private Set<Emp> emps=new HashSet<>();
	
	public Dept() {
		// TODO Auto-generated constructor
	}

	public Dept(int deptNo, String deptName, String manager) {
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.manager = manager;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public Set<Emp> getEmps() {
		return emps;
	}

	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}
	
	

}
