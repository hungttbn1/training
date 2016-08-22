package io.fruitbase.model.entities;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.repository.cdi.Eager;







@Entity
@Table(name= "team")
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "name", nullable = false)
	private String name;
	//1 team have many employees
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "team")
	private Set<Employee> employees;

	public Team() {
		
	}

	public Team(Integer id, String name, Set<Employee> employees) {
		
		this.id = id;
		this.name = name;
		this.employees = employees;
	}

	public Team(String name) {
		
		this.name = name;
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

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	
}
