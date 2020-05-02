package com.vms.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "VISITOR_INFO")
public class Visitor {

	@Id
	@Column (name = "visitor_id")
	@GeneratedValue
	private int visitorId;
	
	@Column (name = "visitor_name")
	@NotNull
	private String visitorName;
	
	@Column (name = "contact_number")
	@NotNull
	private long contactNumber;
	
	@Column (name = "email_id")
	@NotNull
	private String emailId;
	
	@Column (name = "organisation")
	@NotNull
	private String organisation;
	
	@Column (name = "co_visitor_no")
	private int numberOfCoVisitor;
	
	@OneToOne(mappedBy = "visitor")
	@JoinColumn
	private MeetingBooking meeting;

	/*
	 * public VisitorInfo(){
	 * 
	 * } public VisitorInfo(MeetingDto meeting){ visitorName =
	 * meeting.getVisitorName(); contactNumber = meeting.getContactNumber(); emailId
	 * = meeting.getEmailId(); organisation = meeting.getOrganisation(); visitWith=
	 * meeting.getVisitWith(); }
	 */
	public int getVisitorId() {
		return visitorId;
	}

	public void setVisitorId(int visitorId) {
		this.visitorId = visitorId;
	}

	public String getVisitorName() {
		return visitorName;
	}

	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getOrganisation() {
		return organisation;
	}

	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}

	public int getNumberOfCoVisitor() {
		return numberOfCoVisitor;
	}

	public void setNumberOfCoVisitor(int numberOfCoVisitor) {
		this.numberOfCoVisitor = numberOfCoVisitor;
	}

	
}
