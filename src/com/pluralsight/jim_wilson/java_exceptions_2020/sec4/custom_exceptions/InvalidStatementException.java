package com.pluralsight.jim_wilson.java_exceptions_2020.sec4.custom_exceptions;

public class InvalidStatementException extends Exception {
	public InvalidStatementException(String message) {
		super(message);
	}
}
