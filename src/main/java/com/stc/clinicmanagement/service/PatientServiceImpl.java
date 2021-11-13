package com.stc.clinicmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.stc.clinicmanagement.dto.PatientRequest;
import com.stc.clinicmanagement.enitities.Patient;
import com.stc.clinicmanagement.repo.PatientRepo;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepo patientRepo;

	@Override
	public Patient addPatient(PatientRequest patientRequest) {
		List<Patient> patients = patientRepo.findByNationalId(patientRequest.getNationalId());
		if (!CollectionUtils.isEmpty(patients)) {
			return patients.get(0);
		}
		Patient patient = new Patient();
		patient.setName(patientRequest.getName());
		patient.setNationalId(patientRequest.getNationalId());
		return patientRepo.save(patient);
	}

}
