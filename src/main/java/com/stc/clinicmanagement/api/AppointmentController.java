package com.stc.clinicmanagement.api;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stc.clinicmanagement.dto.AppointmentRequest;
import com.stc.clinicmanagement.dto.CancellationReason;
import com.stc.clinicmanagement.enitities.Appointment;
import com.stc.clinicmanagement.service.AppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

	private AppointmentService appointmentService;

	public AppointmentController(AppointmentService appointmentService) {
		this.appointmentService = appointmentService;
	}

	@PostMapping
	public ResponseEntity<Appointment> addAppointment(@Valid @RequestBody AppointmentRequest appointmentRequest) {

		return new ResponseEntity<>(appointmentService.addAppointment(appointmentRequest), HttpStatus.CREATED);
	}

	@GetMapping(value = "/today")
	public ResponseEntity<List<Appointment>> listTodayAppointments() {

		return new ResponseEntity<>(appointmentService.listTodayAppointments(), HttpStatus.OK);
	}

	@PatchMapping(value = "/{id}/cancel/{reason}")
	public ResponseEntity<Appointment> cancelAppointments(@PathVariable Long id,
			@PathVariable CancellationReason reason) {
		Appointment appointment = appointmentService.cancelAppointments(id, reason);
		HttpStatus status = HttpStatus.OK;
		if (appointment == null) {
			status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<>(appointment, status);
	}

	@GetMapping(value = "/{date}")
	public ResponseEntity<List<Appointment>> listAppointmentsByDate(
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {

		return new ResponseEntity<>(appointmentService.listAppointmentsByDate(date), HttpStatus.OK);
	}

	@GetMapping(value = "/{patientId}/history")
	public ResponseEntity<List<Appointment>> listAppointmentsHistoryByPatientId(@PathVariable Long patientId) {

		return new ResponseEntity<>(appointmentService.listAppointmentsHistoryByPatientId(patientId), HttpStatus.OK);
	}
	
	@GetMapping(value = "patient/{patientName}")
	public ResponseEntity<List<Appointment>> listAppointmentsByPatientName(@PathVariable String patientName) {

		return new ResponseEntity<>(appointmentService.listAppointmentsByPatientName(patientName.toUpperCase()), HttpStatus.OK);
	}
}
