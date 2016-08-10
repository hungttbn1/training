package io.fruitbase.business.services.dummy.entity;

public class ProjectManager extends Employee {

	private Double managerAllowance = 500.0;

	public Double getManagerAllowance() {
		return managerAllowance;
	}

	public void setManagerAllowance(Double managerAllowance) {
		this.managerAllowance = managerAllowance;
	}

}
