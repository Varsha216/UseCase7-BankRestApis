package com.bank.ABCbank.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "ABC_bank")
public class Bank {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accNo_generator")
	@SequenceGenerator(name = "accNo_generator", sequenceName = "accNo_seq", initialValue = 543216700, allocationSize=1)
	@Column(name = "account_number", length = 9)
	private Long accountNumber;
	
	@Column(name = "name", length = 20, nullable = false)
	private String name;
	
	@Column(name = "deposit_amount", nullable = false, columnDefinition="Decimal(10,2)")
	private double depositAmount;
	
	@Column(name = "withdraw_amount", nullable = false, columnDefinition="Decimal(10,2) default 0.00")
	private double withdrawAmount;
	
	@Column(name = "balance_amount", nullable = false, columnDefinition="Decimal(10,2)")
	private double balanceAmount;
	
	@Column(name = "permanent_address", length = 250, nullable = false)
	private String permanentAddress;
	
	@Column(name = "communication_address", length = 250, nullable = false)
	private String communicationAddress;
	
	@Column(name = "notes", length = 250)
	private String notes;
	
}
