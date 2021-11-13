package com.stc.clinicmanagement.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stc.clinicmanagement.enitities.Appointment;

public interface AppointmentRepo extends JpaRepository<Appointment, Long> {

	@EntityGraph(attributePaths = { "patient" })
	@Query("SELECT a FROM Appointment a where DATE(a.appointmentDate) = CURDATE()")
	public List<Appointment> listTodayAppointment();

	@EntityGraph(attributePaths = { "patient" })
	@Query("SELECT a FROM Appointment a where DATE(a.appointmentDate) = ?1")
	public List<Appointment> listAppointmentsByDate(Date date);

	@EntityGraph(attributePaths = { "patient" })
	@Query("SELECT a FROM Appointment a join  a.patient p on p.id = ?1  where DATE(a.appointmentDate) < CURDATE()")
	public List<Appointment> listAppointmentsHistoryByPatientId(Long patientId);

	@EntityGraph(attributePaths = { "patient" })
	@Query("SELECT a FROM Appointment a join  a.patient p on UPPER(p.name) like concat('%', ?1,'%') ")
	public List<Appointment> listAppointmentsByPatientName(String patientName);
}
