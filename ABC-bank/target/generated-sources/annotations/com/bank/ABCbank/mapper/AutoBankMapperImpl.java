package com.bank.ABCbank.mapper;

import com.bank.ABCbank.dto.BankDto;
import com.bank.ABCbank.entity.Bank;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-09T23:26:42+0530",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 1.4.200.v20220802-0458, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
@Component
public class AutoBankMapperImpl implements AutoBankMapper {

    @Override
    public BankDto mapToBankDto(Bank bank) {
        if ( bank == null ) {
            return null;
        }

        BankDto bankDto = new BankDto();

        bankDto.setAccountNumber( bank.getAccountNumber() );
        bankDto.setBalanceAmount( bank.getBalanceAmount() );
        bankDto.setCommunicationAddress( bank.getCommunicationAddress() );
        bankDto.setDepositAmount( bank.getDepositAmount() );
        bankDto.setName( bank.getName() );
        bankDto.setNotes( bank.getNotes() );
        bankDto.setPermanentAddress( bank.getPermanentAddress() );
        bankDto.setWithdrawAmount( bank.getWithdrawAmount() );

        return bankDto;
    }

    @Override
    public Bank mapToBank(BankDto bankDto) {
        if ( bankDto == null ) {
            return null;
        }

        Bank bank = new Bank();

        bank.setAccountNumber( bankDto.getAccountNumber() );
        bank.setBalanceAmount( bankDto.getBalanceAmount() );
        bank.setCommunicationAddress( bankDto.getCommunicationAddress() );
        bank.setDepositAmount( bankDto.getDepositAmount() );
        bank.setName( bankDto.getName() );
        bank.setNotes( bankDto.getNotes() );
        bank.setPermanentAddress( bankDto.getPermanentAddress() );
        bank.setWithdrawAmount( bankDto.getWithdrawAmount() );

        return bank;
    }
}
