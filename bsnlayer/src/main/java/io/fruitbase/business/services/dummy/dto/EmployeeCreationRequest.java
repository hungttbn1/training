package io.fruitbase.business.services.dummy.dto;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class EmployeeCreationRequest {

	@NotEmpty
	private String name;
	@Email
	private String email;
	@Min(1)
	private Integer teamId;

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

	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

}
