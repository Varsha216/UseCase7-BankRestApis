package com.bank.ABCbank.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.bank.ABCbank.dto.BankDto;
import com.bank.ABCbank.entity.Bank;

@Mapper(componentModel = "spring")
public interface AutoBankMapper {
	
	AutoBankMapper MAPPER = Mappers.getMapper(AutoBankMapper.class);
	
	BankDto mapToBankDto(Bank bank);
	
	Bank mapToBank(BankDto bankDto);
}
