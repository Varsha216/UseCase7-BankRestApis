package com.bank.ABCbank.exception;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bank.ABCbank.dto.BankDto;
import com.bank.ABCbank.service.BankService;
import com.bank.ABCbank.service.BankServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class NegativeBalanceAmountExceptionTest {

	@InjectMocks
	private BankServiceImpl bankService;
	
	@Test
	public void testNegativeBalanceAmountException() throws NegativeBalanceAmountException{
		
		BankDto bankDto = new BankDto();
		bankDto.setAccountNumber(987654321L);
		bankDto.setName("Varsha");
		bankDto.setDepositAmount(2000);
		bankDto.setWithdrawAmount(3000);
		bankDto.setPermanentAddress("440,1,delhi,delhi,110023");
		bankDto.setCommunicationAddress("440,1,delhi,delhi,110023");
		
		assertThrows(NegativeBalanceAmountException.class, ()->{
			bankService.addAccount(bankDto);
		});
		
		
	}

}
