package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Customers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerDetails {

	@Id
	@Column(name = "Customer_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genName2")
	@SequenceGenerator(name = "genName2", sequenceName = "customer", initialValue = 146501, allocationSize = 1)
	private long customerId;

	@Column(name = "Customer_First_Name")
	private String customerFirstName;

	@Column(name = "Customer_Last_Name")
	private String customerLastName;

	@Column(name = "DOB")
	private String DOB;

	@Column(name = "Age")
	private String age;

	@Column(name = "Gender")
	private String gender;

	@Column(name = "Contact_Number")
	private String contactNumber;

	@Column(name = "Pan_Number")
	private String panNumber;

	@Column(name = "Adhaar_Number")
	private String adhaarNumber;

	@Column(name = "Account_Type")
	private String accountType;

	@Column(name = "Opening_Balance")
	private int openingBalance;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private AddressDetails address;

	@Column(name = "BranchId")
	private int branchId;

	@Column(name = "Credit_Score")
	private int creditScore;

}
