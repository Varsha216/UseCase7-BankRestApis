package com.bank.ABCbank.service;

import com.bank.ABCbank.exception.BankAccountNotFoundException;
import com.bank.ABCbank.exception.NegativeBalanceAmountException;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.bank.ABCbank.dto.BankDto;
import com.bank.ABCbank.entity.Bank;

@Service
public interface BankService {

	BankDto addAccount(@Valid BankDto bankDto) throws NegativeBalanceAmountException;
	BankDto getAccountById(Long id) throws BankAccountNotFoundException;
	BankDto updateAccount(Long id, BankDto bankDto) throws NegativeBalanceAmountException, BankAccountNotFoundException;
	String deleteAccount(Long id) throws BankAccountNotFoundException;

	
}
