/*package io.fruitbase.model.entities;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="assignproject", catalog = "myschema")
public class AssignProject {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id", nullable = false)
	private Project project;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id", nullable = false)
	private Employee employee;

	public AssignProject(Integer id, Project project, Employee employee) {
		super();
		this.id = id;
		this.project = project;
		this.employee = employee;
	}

	public AssignProject() {
		
	}

	public AssignProject(Project project, Employee employee) {
		super();
		this.project = project;
		this.employee = employee;
	}

	
	

		


}



*/