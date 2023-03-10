package com.bank.ABCbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.bank.ABCbank.entity.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {

}
