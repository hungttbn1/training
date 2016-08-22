/*package io.fruitbase.model.entities;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Embeddable
public class AssignProjectId {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id", nullable = false)
	private Project project;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id", nullable = false)
	private Employee employee;

	public AssignProjectId(Project project, Employee employee) {
		super();
		this.project = project;
		this.employee = employee;
	}

	public AssignProjectId() {
		
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}


*/