package com.stc.clinicmanagement.enitities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patient")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	public Patient() {
	}

	@Column(name = "name")
	private String name;

	@Column(name = "national_id")
	private Long nationalId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getNationalId() {
		return nationalId;
	}

	public void setNationalId(Long nationalId) {
		this.nationalId = nationalId;
	}
	
	

}
