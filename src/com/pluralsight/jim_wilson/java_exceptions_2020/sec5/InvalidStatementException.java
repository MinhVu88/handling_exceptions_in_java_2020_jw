package com.pluralsight.jim_wilson.java_exceptions_2020.sec5;

public class InvalidStatementException extends Exception {
	public InvalidStatementException(String message) {
		super(message);
	}

	public InvalidStatementException(String message, Exception e) {
		super(message, e);
	}
}
