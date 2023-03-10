package com.bank.ABCbank.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.bank.ABCbank.dto.BankDto;
import com.bank.ABCbank.entity.Bank;

@SpringBootTest
public class BankMapperTest {

	@Test
	public void mapToBankDtotest() {
		Bank bank = new Bank(987654321L,"Varsha",2000,500,1500,"House-100,2,Delhi,Delhi,110023","House-100,2,Delhi,Delhi,110023","Testing");
		BankDto bankDto = AutoBankMapper.MAPPER.mapToBankDto(bank);
		
		assertEquals("Varsha", bankDto.getName());
	}
	
	@Test
	public void mapToBankTest(){
		BankDto bankDto = new BankDto(987654321L,"Varsha",2000,500,1500,"House-100,2,Delhi,Delhi,110023","House-100,2,Delhi,Delhi,110023","Testing");
		Bank bank = AutoBankMapper.MAPPER.mapToBank(bankDto);
		
		assertEquals("Varsha", bank.getName());
	}

}
