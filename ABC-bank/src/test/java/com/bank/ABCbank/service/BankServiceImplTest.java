package com.bank.ABCbank.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.bank.ABCbank.dto.BankDto;
import com.bank.ABCbank.entity.Bank;
import com.bank.ABCbank.exception.BankAccountNotFoundException;
import com.bank.ABCbank.exception.NegativeBalanceAmountException;
import com.bank.ABCbank.repository.BankRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class BankServiceImplTest {

	@InjectMocks
	private BankServiceImpl bankService;
	
	@Mock
	private BankRepository bankRepository;
	
	Bank bank;
	BankDto bankDto;
	
	@BeforeEach
	public void setup(){
		bank = new Bank(987654321L, "Varsha", 220, 200, 20,"440,2,delhi,delhi,110023","440,2,delhi,delhi,110023","Testing");
		bankDto = new BankDto(987654321L, "Varsha", 220, 200, 20,"440,2,delhi,delhi,110023","440,2,delhi,delhi,110023","Testing");
	}
	
	@Test
	public void testAddAccount() throws NegativeBalanceAmountException {

		when(bankRepository.save(any(Bank.class))).thenReturn(bank);
		assertEquals("Varsha", bankService.addAccount(bankDto).getName());
		verify(bankRepository, times(1)).save(any(Bank.class));
		
	}

	@Test
	public void testGetAccountById() throws BankAccountNotFoundException {
		Long accNo = 987654321L;
		when(bankRepository.findById(accNo)).thenReturn(Optional.of(bank));
		assertEquals("Varsha", bankService.getAccountById(accNo).getName());
		
	}

	@Test
	public void testUpdateAccount() throws NegativeBalanceAmountException, BankAccountNotFoundException {
		Long accNo = 987654321L;
		when(bankRepository.findById(anyLong())).thenReturn(Optional.of(bank));
		when(bankRepository.save(any(Bank.class))).thenReturn(bank);
		assertEquals("Varsha", bankService.updateAccount(accNo, bankDto).getName());
	}

	@Test
	public void testDeleteAccount() throws BankAccountNotFoundException {
		Long accNo = 987654321L;
		doReturn(Optional.of(bank)).when(bankRepository).findById(accNo);
		doNothing().when(bankRepository).deleteById(anyLong());
		bankService.deleteAccount(accNo);
		verify(bankRepository, times(1)).deleteById(accNo);
	}

}
