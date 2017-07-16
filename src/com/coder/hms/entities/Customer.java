package com.coder.hms.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CustomerId")
	private long CustomerId;
	
	@Column(name="FirstName")
	private String FirstName;
	
	@Column(name="LastName")
	private String LastName;
	
	@Column(name="Country")
	private String Country;
	
	@Column(name="Document")
	private String Document;
	
	@Column(name="DocumentNo")
	private long DocumentNo;
	
	@Column(name="DateOfBirth")
	private String DateOfBirth;
	
	@Column(name="Gender")
	private String Gender;
	
	@Column(name="MaritalStatus")
	private String MaritalStatus;
	
	@Column(name="FatherName")
	private String FatherName;
	
	@Column(name="MotherName")
	private String MotherName;
	
	@Column(name="Email")
	private String Email;
	
	private static final long serialVersionUID = 1L;
	
	public Customer() {}

	public long getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(long customerId) {
		CustomerId = customerId;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getDocument() {
		return Document;
	}

	public void setDocument(String document) {
		Document = document;
	}

	public long getDocumentNo() {
		return DocumentNo;
	}

	public void setDocumentNo(long documentNo) {
		DocumentNo = documentNo;
	}

	public String getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getMaritalStatus() {
		return MaritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		MaritalStatus = maritalStatus;
	}

	public String getFatherName() {
		return FatherName;
	}

	public void setFatherName(String fatherName) {
		FatherName = fatherName;
	}

	public String getMotherName() {
		return MotherName;
	}

	public void setMotherName(String motherName) {
		MotherName = motherName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	//Without ID
	public Customer(String firstName, String lastName, String country, String document, long documentNo,
			String dateOfBirth, String gender, String maritalStatus, String fatherName, String motherName,
			String email) {
		super();
		FirstName = firstName;
		LastName = lastName;
		Country = country;
		Document = document;
		DocumentNo = documentNo;
		DateOfBirth = dateOfBirth;
		Gender = gender;
		MaritalStatus = maritalStatus;
		FatherName = fatherName;
		MotherName = motherName;
		Email = email;
	}

	//With ID
	public Customer(long customerId, String firstName, String lastName, String country, String document,
			long documentNo, String dateOfBirth, String gender, String maritalStatus, String fatherName,
			String motherName, String email) {
		super();
		CustomerId = customerId;
		FirstName = firstName;
		LastName = lastName;
		Country = country;
		Document = document;
		DocumentNo = documentNo;
		DateOfBirth = dateOfBirth;
		Gender = gender;
		MaritalStatus = maritalStatus;
		FatherName = fatherName;
		MotherName = motherName;
		Email = email;
	}

	@Override
	public String toString() {
		return "Customer [CustomerId=" + CustomerId + ", FirstName=" + FirstName + ", LastName=" + LastName
				+ ", Country=" + Country + ", Document=" + Document + ", DocumentNo=" + DocumentNo + ", DateOfBirth="
				+ DateOfBirth + ", Gender=" + Gender + ", MaritalStatus=" + MaritalStatus + ", FatherName=" + FatherName
				+ ", MotherName=" + MotherName + ", Email=" + Email + "]";
	}

	
}