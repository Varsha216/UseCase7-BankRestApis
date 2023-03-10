package com.bank.ABCbank.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bank.ABCbank.exception.BankAccountNotFoundException;
import com.bank.ABCbank.exception.NegativeBalanceAmountException;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	/**
	 * Returns response message if user provide invalid arguments
	 * @param exception
	 * @return error message
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleInvalidArgument( MethodArgumentNotValidException exception){
		
		Map<String, String> errorMap = new HashMap<>();
		exception.getBindingResult().getFieldErrors().forEach(error ->{
			errorMap.put(error.getField(), error.getDefaultMessage());
		});
		return errorMap;
	}
	
	/**
	 * Returns response message if Account not found
	 * @param exception
	 * @return error message
	 */
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(BankAccountNotFoundException.class)
	public Map<String, String> handleAccountNotFoundException(BankAccountNotFoundException exception){
		
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("errorMessage" , exception.getMessage());
		return errorMap;
	}
	
	/**
	 * Return response message if Balance amount is negative
	 * @param exception
	 * @return error message
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(NegativeBalanceAmountException.class)
	public Map<String, String> handleNegativeBalanceAmountException(NegativeBalanceAmountException exception){
		
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("errorMessage", exception.getMessage());
		return errorMap;
	}
}
