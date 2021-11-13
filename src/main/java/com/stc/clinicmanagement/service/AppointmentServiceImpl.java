package com.stc.clinicmanagement.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stc.clinicmanagement.dto.AppointmentRequest;
import com.stc.clinicmanagement.dto.CancellationReason;
import com.stc.clinicmanagement.enitities.Appointment;
import com.stc.clinicmanagement.enitities.Patient;
import com.stc.clinicmanagement.repo.AppointmentRepo;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepo appointmentRepo;

	@Autowired
	private PatientService patientService;

	@Override
	public Appointment addAppointment(AppointmentRequest appointmentRequest) {
		Patient patient = patientService.addPatient(appointmentRequest.getPatient());
		Appointment appointment = new Appointment();
		appointment.setAppointmentDate(appointmentRequest.getAppointmentDate());
		appointment.setPatient(patient);
		return appointmentRepo.save(appointment);
	}

	@Override
	public List<Appointment> listTodayAppointments() {
		return appointmentRepo.listTodayAppointment();
	}

	@Override
	public Appointment cancelAppointments(Long id, CancellationReason reason) {
		Optional<Appointment> appointmentOptional = appointmentRepo.findById(id);
		if (!appointmentOptional.isPresent())
			return null;
		Appointment appointment = appointmentOptional.get();
		appointment.setCancellationReason(reason);
		appointment = appointmentRepo.save(appointment);
		return appointment;
	}

	@Override
	public List<Appointment> listAppointmentsByDate(Date date) {
		return appointmentRepo.listAppointmentsByDate(date);
	}

	@Override
	public List<Appointment> listAppointmentsHistoryByPatientId(Long patientId) {
		return appointmentRepo.listAppointmentsHistoryByPatientId(patientId);
	}

	@Override
	public List<Appointment> listAppointmentsByPatientName(String patientName) {
		return appointmentRepo.listAppointmentsByPatientName(patientName);
	}

}
