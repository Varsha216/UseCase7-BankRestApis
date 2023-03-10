package com.bank.ABCbank.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.ABCbank.exception.BankAccountNotFoundException;
import com.bank.ABCbank.exception.NegativeBalanceAmountException;
import com.bank.ABCbank.mapper.AutoBankMapper;
import com.bank.ABCbank.dto.BankDto;
import com.bank.ABCbank.entity.Bank;
import com.bank.ABCbank.repository.BankRepository;

import net.bytebuddy.implementation.Implementation;

@Service
public class BankServiceImpl implements BankService {

	private BankRepository bankRepository;

	@Autowired
	public BankServiceImpl(BankRepository bankRepository) {
		this.bankRepository = bankRepository;
	}

	/**
	 * Implementation to add bank account 
	 * @param Request object of bank bankDto
	 * @return bankDto
	 * @throws NegativeBalanceAmountException
	 */
	@Override
	public BankDto addAccount(BankDto bankDto) throws NegativeBalanceAmountException {
		
		Bank bank = AutoBankMapper.MAPPER.mapToBank(bankDto);

		bank.setBalanceAmount(bank.getDepositAmount() - bank.getWithdrawAmount());
		if(bank.getBalanceAmount() < 0)
			throw new NegativeBalanceAmountException("Withdraw amount cannot be greater than deposit amount");
		
		return AutoBankMapper.MAPPER.mapToBankDto(bankRepository.save(bank));
	}

	/**
	 * Implementation to get account details by id
	 * @param Account number as ID
	 * @return Found account object bankDto
	 * @throws BankAccountNotFoundException
	 */
	@Override
	public BankDto getAccountById(Long id) throws BankAccountNotFoundException {
		
		//Bank bank = bankRepository.findById(id).get();
     	//if(Optional.of(bank).isPresent())
		
		Bank bank = bankRepository.findById(id).orElse(null);
		if(bank!=null)
			return AutoBankMapper.MAPPER.mapToBankDto(bank);
		else
			throw new BankAccountNotFoundException("No Bank account found with account no: "+id);
	}

	/**
	 * Implementation to update account details by Account number as ID
	 * @param id, bankDto
	 * @return updated account object bankDto
	 * @throws BankAccountNotFoundException, NegativeBalanceAmountException
	 */
	@Override
	public BankDto updateAccount(Long id, BankDto bankDto) throws NegativeBalanceAmountException, BankAccountNotFoundException {
		Bank existingAcc = bankRepository.findById(id).orElseThrow(()-> new BankAccountNotFoundException("No Bank account found with account no: "+id));

		Bank bank = AutoBankMapper.MAPPER.mapToBank(bankDto);
		bank.setBalanceAmount(bank.getDepositAmount() - bank.getWithdrawAmount());
		if(bank.getBalanceAmount() < 0)
			throw new NegativeBalanceAmountException("Withdraw amount cannot be greater than deposit amount");
		
		existingAcc.setName(bank.getName());
		existingAcc.setDepositAmount(bank.getDepositAmount());
		existingAcc.setWithdrawAmount(bank.getWithdrawAmount());
		existingAcc.setBalanceAmount(bank.getBalanceAmount());
		existingAcc.setPermanentAddress(bank.getPermanentAddress());
		existingAcc.setCommunicationAddress(bank.getCommunicationAddress());
		existingAcc.setNotes(bank.getNotes());
		
		return AutoBankMapper.MAPPER.mapToBankDto(bankRepository.save(existingAcc));
	}

	/**
	 * Implementation to delete account by id
	 * @param Account number as ID
	 * @return Response message
	 * @throws BankAccountNotFoundException
	 */
	@Override
	public String deleteAccount(Long id) throws BankAccountNotFoundException {
		bankRepository.findById(id).orElseThrow(()-> new BankAccountNotFoundException("No Bank account found with account no: "+id));
		
		bankRepository.deleteById(id);
		return "Account got deleted with id "+id+"";
		
	}
}
