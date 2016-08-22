package io.fruitbase.model.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import javax.persistence.Table;



@Entity
@Table(name= "project")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name="name", nullable = false)
	private String name;
		
	@Column(name="code", nullable = false)
	private String code;
	//1 project by many employees	
	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
	private Set<AssignProject> assignProjects;*/
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "projects")
	private Set<Employee> employees;

	public Project(){
		
	}
	public Project(Integer id, String name, String code, Set<Employee> employees) {
		
		this.id = id;
		this.name = name;
		this.code = code;
		this.employees = employees;
	}
	public Project(String name, String code, Set<Employee> employees) {
		super();
		this.name = name;
		this.code = code;
		this.employees = employees;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	/*public Set<AssignProject> getAssignProject() {
		return assignProjects;
	}
	public void setAssignProject(Set<AssignProject> assignProjects) {
		this.assignProjects = assignProjects;
	}
	*/
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	

	
}
