package com.stc.clinicmanagement.service;

import com.stc.clinicmanagement.dto.PatientRequest;
import com.stc.clinicmanagement.enitities.Patient;

public interface PatientService {
	
	public Patient addPatient(PatientRequest patientRequest);

}
