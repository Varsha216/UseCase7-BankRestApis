package com.bank.ABCbank.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BankDto {

	private Long accountNumber;
	
	@NotBlank(message = "Name field must not be empty")
	@Size(min = 3, max = 20, message = "Name field's size must be between 3-20")
	@Pattern(regexp = "^[a-zA-Z ]{3,20}$", message = "Name field can have alphabets only.")
	private String name;
	
	@Positive(message = "Deposit amount must be greater than 0")
	private double depositAmount;
	
	@PositiveOrZero(message = "Withdraw amount cannot be negative")
	private double withdrawAmount;
	
	private double balanceAmount;
	
	@NotBlank(message = "Permanent Address field must not be empty")
	@Pattern(regexp = "^[a-zA-Z- ]*[0-9]+,[a-zA-Z- ]*[0-9]+,[a-zA-Z ]{3,15},[a-zA-Z ]{3,15},[a-zA-Z- ]*[0-9]{6}$", message = "Address should be like- House no,Street,City,State,Pin(6-numbers)")
	private String permanentAddress;
	
	@NotBlank(message = "Communication Address field must not be empty")
	@Pattern(regexp = "^[a-zA-Z- ]*[0-9]+,[a-zA-Z- ]*[0-9]+,[a-zA-Z ]{3,15},[a-zA-Z ]{3,15},[a-zA-Z- ]*[0-9]{6}$", message = "Address should be like- House no,Street,City,State,Pin(6-numbers)")
	private String communicationAddress;
	
	private String notes;
}
