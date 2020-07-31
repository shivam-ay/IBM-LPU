package com.example.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Account")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccountDetails {
	

	@Id
	@Column(name="Account_number")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="genName1")
	@SequenceGenerator(name="genName1", sequenceName="acc",initialValue=1170000011,allocationSize=1)
	private long accountNumber;

	@OneToOne(cascade=CascadeType.ALL)   
	@JoinColumn(name="Customer_ID")
	CustomerDetails customerDetails;
	
	@Column(name="Account_Holder_Name")
	private String accountHolderName;
	
	@Column(name="Account_Status")
	private String accountStatus;
	
	@Column(name="Account_Balance")
	private double accountBalance;
	
	@Column(name="Account_Interest")
	private float accountInterest;
	
	@Column(name="Opening_Date")
	private LocalDateTime openingDate;	
	
    @ManyToOne(optional = false)
	@JoinColumn(name="Branch_Id") //According the customer location the branch is assigned.
	BranchDetails branchdetails;
    
}
