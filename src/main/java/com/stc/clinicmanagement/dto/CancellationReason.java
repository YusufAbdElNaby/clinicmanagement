package com.stc.clinicmanagement.dto;

import java.util.stream.Stream;

public enum CancellationReason {
	NO_SHOW("NO_SHOW"),
	PATIENT_REQUEST("PATIENT_REQUEST"),
	PHYSICIAN_APOLOGY("PHYSICIAN_APOLOGY");

	private String databaseValue;

	CancellationReason(String databaseValue) {
		this.databaseValue = databaseValue;
	}

	public String getDatabaseValue() {
		return databaseValue;
	}

	public static CancellationReason of(String databaseValue) {
		if(databaseValue==null) {
			return null;
		}
		return Stream.of(CancellationReason.values())
				.filter(meetingPointStatus -> meetingPointStatus.getDatabaseValue().equals(databaseValue)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}
}
