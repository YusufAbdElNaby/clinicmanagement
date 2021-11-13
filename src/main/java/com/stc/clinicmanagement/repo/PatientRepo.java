package com.stc.clinicmanagement.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stc.clinicmanagement.enitities.Patient;


public interface PatientRepo extends JpaRepository<Patient, Long> {
    
	List<Patient> findByNationalId(Long nationalId);
}
