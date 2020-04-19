package com.paf.project;

public class Appointment {
	
	private String app_id;
	private String doctor_id;
	private String patient_id;
	private String prescription;
	private String doc_notes;
	
	
	public String getApp_id() {
		return app_id;
	}
	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}
	public String getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(String doctor_id) {
		this.doctor_id = doctor_id;
	}
	public String getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}
	public String getPrescription() {
		return prescription;
	}
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	public String getDoc_notes() {
		return doc_notes;
	}
	public void setDoc_notes(String doc_notes) {
		this.doc_notes = doc_notes;
	}

	

}
