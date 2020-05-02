package com.vms.Model;

import java.sql.Date;
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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "MEETING_STATUS")
@JsonIgnoreProperties(ignoreUnknown = true)
public class MeetingStatus {

	@Id
	@GeneratedValue
	@Column (name = "meeting_id")
	private int meetingId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "visit_no")
	private MeetingBooking meetingBooked;
	
	@Column (name = "sec_checkin")
	private boolean secCheckin;
	
	@Column (name = "sec_checkin_date")
	private Date secCheckinDate;
	
	@Column (name = "sec_checkin_time")
	private Time secCheckinTime;
	
	@Column (name = "emp_checkin")
	private boolean empCheckin;
	
	@Column (name = "emp_checkin_date")
	private Date empCheckinDate;
	
	@Column (name = "emp_checkin_time")
	private Time empCheckinTime;
	
	@Column (name = "sec_checkout")
	private boolean secCheckout;
	
	@Column (name = "sec_checkout_Date")
	private Date secCheckoutDate;
	
	@Column (name = "sec_checkout_time")
	private Time secCheckoutTime;
	
	@Column (name = "emp_checkout")
	private boolean empCheckout;
	
	@Column (name = "emp_checkout_date")
	private Date empCheckoutDate;
	
	@Column (name = "emp_checkout_time")
	private Time empCheckoutTime;
	
	@Column (name = "status")
	private String status;
	
	@Column (name = "last_updated_Date")
	private Date lastUpdatedDate;
	
	@Column (name = "last_updated_time")
	private Time lastUpdatedTime;
	
	@Column (name = "last_updated_by")
	private int lastUpdatedBy;
	
	@Column (name = "created_by")
	private int createdBy;
	
	@Column (name = "created_date")
	private Date createdDate;
	
	@Column (name = "created_time")
	private Time createdTime;

	
	public int getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(int meetingId) {
		this.meetingId = meetingId;
	}

	public MeetingBooking getMeetingBooked() {
		return meetingBooked;
	}

	public void setMeetingBooked(MeetingBooking meetingBooked) {
		this.meetingBooked = meetingBooked;
	}

	public boolean isSecCheckin() {
		return secCheckin;
	}

	public void setSecCheckin(boolean secCheckin) {
		this.secCheckin = secCheckin;
	}

	public boolean isEmpCheckin() {
		return empCheckin;
	}

	public void setEmpCheckin(boolean empCheckin) {
		this.empCheckin = empCheckin;
	}

	public boolean isSecCheckout() {
		return secCheckout;
	}

	public void setSecCheckout(boolean secCheckout) {
		this.secCheckout = secCheckout;
	}

	public boolean isEmpCheckout() {
		return empCheckout;
	}

	public void setEmpCheckout(boolean empCheckout) {
		this.empCheckout = empCheckout;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(int lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Time getSecCheckinTime() {
		return secCheckinTime;
	}

	public void setSecCheckinTime(Time secCheckinTime) {
		this.secCheckinTime = secCheckinTime;
	}

	public Date getEmpCheckinDate() {
		return empCheckinDate;
	}

	public void setEmpCheckinDate(Date empCheckinDate) {
		this.empCheckinDate = empCheckinDate;
	}

	public Time getEmpCheckinTime() {
		return empCheckinTime;
	}

	public void setEmpCheckinTime(Time empCheckinTime) {
		this.empCheckinTime = empCheckinTime;
	}

	public Time getSecCheckoutTime() {
		return secCheckoutTime;
	}

	public void setSecCheckoutTime(Time secCheckoutTime) {
		this.secCheckoutTime = secCheckoutTime;
	}

	public Date getEmpCheckoutDate() {
		return empCheckoutDate;
	}

	public void setEmpCheckoutDate(Date empCheckoutDate) {
		this.empCheckoutDate = empCheckoutDate;
	}

	public Time getEmpCheckoutTime() {
		return empCheckoutTime;
	}

	public void setEmpCheckoutTime(Time empCheckoutTime) {
		this.empCheckoutTime = empCheckoutTime;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public Time getLastUpdatedTime() {
		return lastUpdatedTime;
	}

	public void setLastUpdatedTime(Time lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Time getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Time createdTime) {
		this.createdTime = createdTime;
	}

	public Date getSecCheckinDate() {
		return secCheckinDate;
	}

	public void setSecCheckinDate(Date secCheckinDate) {
		this.secCheckinDate = secCheckinDate;
	}

	public Date getSecCheckoutDate() {
		return secCheckoutDate;
	}

	public void setSecCheckoutDate(Date secCheckoutDate) {
		this.secCheckoutDate = secCheckoutDate;
	}
	
	
}