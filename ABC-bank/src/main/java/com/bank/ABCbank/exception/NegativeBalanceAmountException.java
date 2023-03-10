package com.bank.ABCbank.exception;

public class NegativeBalanceAmountException extends Exception {

	private static final long serialVersionUID = 1L;

	public NegativeBalanceAmountException(String msg) {
		super(msg);
	}
}
