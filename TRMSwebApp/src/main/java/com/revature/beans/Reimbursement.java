package com.revature.beans;

import java.sql.Date;

public class Reimbursement {
	int reimbursementId;
	int employeeId;
	int eventTypeId;
	String description;
	String location;
	String justification;
	Date eventStartDate;
	int gradeFmtId;
	double eventCost;
	double reimbursementAmount;
	Date requestSubmissionDate;
	int workTimeMissed;
	int approvalStatus;
	String additionalComments;

	public Reimbursement(int reimbursementId, int employeeId, int eventTypeId, String description, String location,
			String justification, Date eventStartDate, int gradeFmtId, double eventCost, double reimbursementAmount,
			Date requestSubmissionDate, int workTimeMissed, int approvalStatus, String additionalComments) {
		super();
		this.reimbursementId = reimbursementId;
		this.employeeId = employeeId;
		this.eventTypeId = eventTypeId;
		this.description = description;
		this.location = location;
		this.justification = justification;
		this.eventStartDate = eventStartDate;
		this.gradeFmtId = gradeFmtId;
		this.eventCost = eventCost;
		this.reimbursementAmount = reimbursementAmount;
		this.requestSubmissionDate = requestSubmissionDate;
		this.workTimeMissed = workTimeMissed;
		this.approvalStatus = approvalStatus;
		this.additionalComments = additionalComments;
	}

	public int getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getEventTypeId() {
		return eventTypeId;
	}

	public void setEventTypeId(int eventTypeId) {
		this.eventTypeId = eventTypeId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public Date getEventStartDate() {
		return eventStartDate;
	}

	public void setEventStartDate(Date eventStartDate) {
		this.eventStartDate = eventStartDate;
	}

	public int getGradeFmtId() {
		return gradeFmtId;
	}

	public void setGradeFmtId(int gradeFmtId) {
		this.gradeFmtId = gradeFmtId;
	}

	public double getEventCost() {
		return eventCost;
	}

	public void setEventCost(double eventCost) {
		this.eventCost = eventCost;
	}

	public double getReimbursementAmount() {
		return reimbursementAmount;
	}

	public void setReimbursementAmount(double reimbursementAmount) {
		this.reimbursementAmount = reimbursementAmount;
	}

	public Date getRequestSubmissionDate() {
		return requestSubmissionDate;
	}

	public void setRequestSubmissionDate(Date requestSubmissionDate) {
		this.requestSubmissionDate = requestSubmissionDate;
	}

	public int getWorkTimeMissed() {
		return workTimeMissed;
	}

	public void setWorkTimeMissed(int workTimeMissed) {
		this.workTimeMissed = workTimeMissed;
	}

	public int getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(int approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public String getAdditionalComments() {
		return additionalComments;
	}

	public void setAdditionalComments(String additionalComments) {
		this.additionalComments = additionalComments;
	}

}
