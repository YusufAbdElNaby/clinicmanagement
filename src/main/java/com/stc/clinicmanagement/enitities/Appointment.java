package com.stc.clinicmanagement.enitities;



import javax.persistence.*;

import com.stc.clinicmanagement.dto.CancellationReason;
import com.stc.clinicmanagement.enitities.converter.CancellationReasonConverter;

import java.util.Date;

@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public Appointment() {
    }

    @Column(name ="appointment_date")
    private Date appointmentDate;


    @ManyToOne(targetEntity = Patient.class)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public CancellationReason getCancellationReason() {
		return cancellationReason;
	}

	public void setCancellationReason(CancellationReason cancellationReason) {
		this.cancellationReason = cancellationReason;
	}

	@Column(name = "cancellation_reason", nullable = false)
    @Convert(converter = CancellationReasonConverter.class)
    private CancellationReason cancellationReason;

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}


}
