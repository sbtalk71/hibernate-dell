package com.demo.hibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("t")
@Entity
public class TraineeEmp extends Employee {
	private String performance;

	public TraineeEmp() {
		// TODO Auto-generated constructor stub
	}
	public String getPerformance() {
		return performance;
	}

	public void setPerformance(String performance) {
		this.performance = performance;
	}

}
