package com.bank.ABCbank.exception;

public class BankAccountNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public BankAccountNotFoundException(String msg) {
		super(msg);
	}
}
