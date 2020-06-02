package com.vms.Model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
	
	@Column (name = "visitor_image", length = 100000)
	private byte[] visitorImage;
	
	/*
	 * @Column (name = "visitor_name")
	 * 
	 * @NotNull private String visitorName;
	 */
	
	@Column (name = "salutation")
	@NotNull
	private String salutation;
	
	@Column (name = "first_name")
	@NotNull
	private String firstName;
	
	@Column (name = "middle_name")
	private String middleName;
	
	@Column (name = "last_name")
	@NotNull
	private String lastName;
	
	@Column (name = "designation")
	@NotNull
	private String designation;
	
	@Column (name = "gender")
	@NotNull
	private String gender;
	
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
	
	@Column (name = "batch_no")
	private long batchNo;
	
	@Column (name = "batch_status")
	private String batchStatus;
	
	@Column(name = "arogya_present")
	private boolean arogyaPresent;
	
	@Column(name = "body_temperature")
	private int bodyTemperature;
	
	@OneToOne(mappedBy = "visitor")
	@JoinColumn
	private MeetingBooking meeting;
	
	@OneToMany(mappedBy = "mainVisitor",cascade = CascadeType.REMOVE)
	private Set<Asset> assets;

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

	/*
	 * public String getVisitorName() { return visitorName; }
	 * 
	 * public void setVisitorName(String visitorName) { this.visitorName =
	 * visitorName; }
	 */

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

	public byte[] getVisitorImage() {
		return visitorImage;
	}

	public void setVisitorImage(byte[] visitorImage) {
		this.visitorImage = visitorImage;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(long batchNo) {
		this.batchNo = batchNo;
	}

	public String getBatchStatus() {
		return batchStatus;
	}

	public void setBatchStatus(String batchStatus) {
		this.batchStatus = batchStatus;
	}

	public boolean isArogyaPresent() {
		return arogyaPresent;
	}

	public void setArogyaPresent(boolean arogyaPresent) {
		this.arogyaPresent = arogyaPresent;
	}

	public int getBodyTemperature() {
		return bodyTemperature;
	}

	public void setBodyTemperature(int bodyTemperature) {
		this.bodyTemperature = bodyTemperature;
	}

	
}
