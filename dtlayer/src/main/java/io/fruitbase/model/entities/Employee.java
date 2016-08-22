package io.fruitbase.model.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	// 1 employee in only 1 team
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "team_id", nullable = false, columnDefinition = "LONGVARBINARY")
	private Team team;
	
	// 1 employee have many project
	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	private Set<AssignProject> assignProjects;*/
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "assignproject", catalog = "myschema", joinColumns = {
			@JoinColumn(name = "employee_id", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "project_id",
					nullable = false, updatable = false) })
	private Set<Project> projects;

	
	public Employee(){
		
	}


	public Employee(Integer id, String name, String email, Team team, Set<Project> projects) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.team = team;
		this.projects = projects;
	}


	public Employee(String name, String email, Team team, Set<Project> projects) {
		super();
		this.name = name;
		this.email = email;
		this.team = team;
		this.projects = projects;
	}

	public Employee(String name, String email, Team team) {
		super();
		this.name = name;
		this.email = email;
		this.team = team;
	}


	public Employee(String name, String email) {
		super();
		this.name = name;
		this.email = email;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Team getTeam() {
		return team;
	}


	public void setTeam(Team team) {
		this.team = team;
	}


	public Set<Project> getProjects() {
		return projects;
	}


	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}


/*	public Set<AssignProject> getAssignProject() {
		return assignProjects;
	}


	public void setAssignProject(Set<AssignProject> assignProjects) {
		this.assignProjects = assignProjects;
	}
	
	*/
	
	
	
}
