package com.stc.clinicmanagement.service;

import java.util.Date;
import java.util.List;

import com.stc.clinicmanagement.dto.AppointmentRequest;
import com.stc.clinicmanagement.dto.CancellationReason;
import com.stc.clinicmanagement.enitities.Appointment;

public interface AppointmentService {

	public Appointment addAppointment(AppointmentRequest appointmentRequest);

	public List<Appointment> listTodayAppointments();

	public Appointment cancelAppointments(Long id, CancellationReason reason);

	public List<Appointment> listAppointmentsByDate(Date date);

	public List<Appointment> listAppointmentsHistoryByPatientId(Long patientId);

	public List<Appointment> listAppointmentsByPatientName(String patientName);

}
