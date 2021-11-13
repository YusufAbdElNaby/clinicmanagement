package com.stc.clinicmanagement.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonFormat;



@Validated
public class AppointmentRequest {

    @NotNull(message = "patient cannot be null")
	private PatientRequest patient;

    @NotNull(message = "appointmentDate cannot be null")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date appointmentDate;

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public PatientRequest getPatient() {
		return patient;
	}

	public void setPatient(PatientRequest patient) {
		this.patient = patient;
	}

}
