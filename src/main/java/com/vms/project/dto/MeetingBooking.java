package com.vms.project.dto;

import java.util.Date;
import java.sql.Time;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "MEETING_BOOKING")
public class MeetingBooking {

	@Id
	@Column (name = "visit_no")
	@GeneratedValue
	private int visitNo;
	
	@Column (name = "emp_id")
	@NotNull
	private int empId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "visitorId")
	private VisitorInfo visitor;
	
	@Column (name = "meeting_type")
	@NotNull
	private String meetingType;
	
	@Column (name = "visit_date")
	@NotNull
	private Date visitDate;
	
	@Column (name = "visit_time")
	@NotNull
	private Time visitTime;
	
	@Column (name = "visit_location")
	@NotNull
	private String visitLocation;
	
	@Column (name = "created_by")
	@NotNull
	private int createdBy;
	
	@Column (name = "created_at")
	@NotNull
	private java.util.Date createdAt;
	
	@Column (name = "remarks")
	private String Remarks;
	
	@OneToOne(mappedBy = "meetingBooked")
	private MeetingStatus meetingStatus;

	/*
	 * public MeetingBooking(MeetingDto meeting) { empId = meeting.getVisitWith();
	 * meetingType = meeting.getMeetingType(); visitDate = meeting.getVisitDate();
	 * visitTime = Time.valueOf(meeting.getVisitTime()); visitLocation =
	 * meeting.getVisitLocation(); }
	 */
	
	public int getVisitNo() {
		return visitNo;
	}

	public void setVisitNo(int visitNo) {
		this.visitNo = visitNo;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getMeetingType() {
		return meetingType;
	}

	public void setMeetingType(String meetingType) {
		this.meetingType = meetingType;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public Time getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(Time visitTime) {
		this.visitTime = visitTime;
	}

	public String getVisitLocation() {
		return visitLocation;
	}

	public void setVisitLocation(String visitLocation) {
		this.visitLocation = visitLocation;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public java.util.Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(java.util.Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getRemarks() {
		return Remarks;
	}

	public void setRemarks(String remarks) {
		Remarks = remarks;
	}

	public VisitorInfo getVisitor() {
		return visitor;
	}

	public void setVisitor(VisitorInfo visitor) {
		this.visitor = visitor;
	}
	
	
}
