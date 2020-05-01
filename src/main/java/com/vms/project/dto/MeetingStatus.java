package com.vms.project.dto;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MEETING_STATUS")
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
	
	@Column (name = "sec_checkin_at")
	private Date secCheckinAt;
	
	@Column (name = "emp_checkin")
	private boolean empCheckin;
	
	@Column (name = "emp_checkin_at")
	private Date empCheckinAt;
	
	@Column (name = "sec_checkout")
	private boolean secCheckout;
	
	@Column (name = "sec_checkout_at")
	private Date secCheckoutAt;
	
	@Column (name = "emp_checkout")
	private boolean empCheckout;
	
	@Column (name = "emp_checkout_at")
	private Date empCheckoutAt;
	
	@Column (name = "status")
	private String status;
	
	@Column (name = "last_updated_at")
	private Date lastUpdatedAt;
	
	@Column (name = "last_updated_by")
	private int lastUpdatedBy;

	
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

	public Date getSecCheckinAt() {
		return secCheckinAt;
	}

	public void setSecCheckinAt(Date secCheckinAt) {
		this.secCheckinAt = secCheckinAt;
	}

	public boolean isEmpCheckin() {
		return empCheckin;
	}

	public void setEmpCheckin(boolean empCheckin) {
		this.empCheckin = empCheckin;
	}

	public Date getEmpCheckinAt() {
		return empCheckinAt;
	}

	public void setEmpCheckinAt(Date empCheckinAt) {
		this.empCheckinAt = empCheckinAt;
	}

	public boolean isSecCheckout() {
		return secCheckout;
	}

	public void setSecCheckout(boolean secCheckout) {
		this.secCheckout = secCheckout;
	}

	public Date getSecCheckoutAt() {
		return secCheckoutAt;
	}

	public void setSecCheckoutAt(Date secCheckoutAt) {
		this.secCheckoutAt = secCheckoutAt;
	}

	public boolean isEmpCheckout() {
		return empCheckout;
	}

	public void setEmpCheckout(boolean empCheckout) {
		this.empCheckout = empCheckout;
	}

	public Date getEmpCheckoutAt() {
		return empCheckoutAt;
	}

	public void setEmpCheckoutAt(Date empCheckoutAt) {
		this.empCheckoutAt = empCheckoutAt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getLastUpdatedAt() {
		return lastUpdatedAt;
	}

	public void setLastUpdatedAt(Date lastUpdatedAt) {
		this.lastUpdatedAt = lastUpdatedAt;
	}

	public int getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(int lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	
}
