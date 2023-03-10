package com.bank.ABCbank.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.ABCbank.exception.BankAccountNotFoundException;
import com.bank.ABCbank.exception.NegativeBalanceAmountException;
import com.bank.ABCbank.dto.BankDto;
import com.bank.ABCbank.service.BankService;

@RestController
@RequestMapping("/ABC_bank")
public class BankController {
	
	Logger logger = LoggerFactory.getLogger(BankController.class);

	private BankService bankService;
	
	@Autowired
	public BankController(BankService bankService){
		this.bankService = bankService;
	}
	
	/**
	 * @return Welcome message
	 */
	@GetMapping("/welcome")
	public String welcome(){
		logger.info("Service testing..");
		return "Welcome Varsha";
	}

	/**
	 * @param bankDto
	 * @return Response entity with Http status
	 * @throws NegativeBalanceAmountException
	 */
	@PostMapping("/save")
	public ResponseEntity<BankDto> addAccount(@RequestBody @Valid BankDto bankDto) throws NegativeBalanceAmountException{
		logger.info("Adding Bank Account..");
		return new ResponseEntity<BankDto>(bankService.addAccount(bankDto), HttpStatus.CREATED);
	}
	
	/**
	 * @param Account number as id
	 * @return Response entity with Http status
	 * @throws BankAccountNotFoundException
	 */
	@GetMapping("/{id}")
	public ResponseEntity<BankDto> getAccountById(@PathVariable Long id) throws BankAccountNotFoundException{
		logger.info("Retrieving Account details by Account No..");
		return new ResponseEntity<BankDto>(bankService.getAccountById(id), HttpStatus.OK);
	}
	
	/**
	 * @param id
	 * @param bankDto
	 * @return Response Entity with Http status
	 * @throws NegativeBalanceAmountException
	 * @throws BankAccountNotFoundException
	 */
	@PutMapping("/{id}")
	public ResponseEntity<BankDto> updateAccount(@PathVariable Long id, @RequestBody @Valid BankDto bankDto) throws NegativeBalanceAmountException, BankAccountNotFoundException{
		logger.info("Updating Account details..");
		return new ResponseEntity<BankDto>(bankService.updateAccount(id, bankDto), HttpStatus.CREATED);
	}
	
	/**
	 * @param id
	 * @return Response entity with Http status
	 * @throws BankAccountNotFoundException
	 */
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable Long id) throws BankAccountNotFoundException{
		logger.info("Deleting Account details by Account No.. ");
		return new ResponseEntity<String>(bankService.deleteAccount(id), HttpStatus.ACCEPTED);
	}
	
}
