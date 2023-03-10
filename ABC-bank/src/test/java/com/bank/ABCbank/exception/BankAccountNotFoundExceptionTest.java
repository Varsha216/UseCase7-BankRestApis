package com.bank.ABCbank.exception;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.bank.ABCbank.repository.BankRepository;
import com.bank.ABCbank.service.BankServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class BankAccountNotFoundExceptionTest {

	@InjectMocks
	private BankServiceImpl bankService;

	@Mock
	private BankRepository bankRepository;

	@Test
	public void testBankAccountNotFoundException() throws BankAccountNotFoundException {
		Long accountNo = (long) 987654321;
		when(bankRepository.findById(anyLong())).thenReturn(Optional.empty());
		assertThrows(BankAccountNotFoundException.class, ()->{
			bankService.getAccountById(accountNo);
		});
	}
}

