package com.stc.clinicmanagement.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PatientRequest {

	@NotEmpty(message = "name cannot be empty")
	private String name;

	@NotNull(message = "nationalId cannot be null")
	private Long nationalId;

	public Long getNationalId() {
		return nationalId;
	}

	public void setNationalId(Long nationalId) {
		this.nationalId = nationalId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
