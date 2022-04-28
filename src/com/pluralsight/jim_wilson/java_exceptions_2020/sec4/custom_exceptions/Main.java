package com.pluralsight.jim_wilson.java_exceptions_2020.sec4.custom_exceptions;

import com.pluralsight.jim_wilson.java_exceptions_2020.sec2.MathOperation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	private static void performOperation(String inputLine) throws InvalidStatementException {
		String[] parts = inputLine.split(" ");

		if(parts.length != 3) {
			throw new InvalidStatementException("3 parts required: operation | leftVal | rightVal");
		}

		MathOperation operation = MathOperation.valueOf(parts[0].toUpperCase());

		int leftVal = valueFromWord(parts[1]);
		int rightVal = valueFromWord(parts[2]);

		int result = execute(operation, leftVal, rightVal);

		System.out.println(inputLine + " = " + result);
	}

	static int execute(MathOperation operation, int leftVal, int rightVal) {
		int result = 0;

		switch(operation) {
			case ADD:
				result = leftVal + rightVal;
				break;
			case SUBTRACT:
				result = leftVal - rightVal;
				break;
			case MULTIPLY:
				result = leftVal * rightVal;
				break;
			case DIVIDE:
				if(rightVal == 0) {
					throw new IllegalArgumentException("zero rightVal not permitted with divide operation");
				}

				result = leftVal / rightVal;

				break;
			default:
				System.out.println("invalid value: " + operation);
				break;
		}

		return result;
	}

	static int valueFromWord(String word) {
		String[] numberWords = {
		"zero", "one",
		"two", "three",
		"four", "five",
		"six", "seven",
		"eight", "nine"
		};

		int value = -1;

		for(int i = 0; i < numberWords.length; i++) {
			if(word.equals(numberWords[i])) {
				value = i;

				break;
			}
		}

		if(value == -1d) {
			value = Integer.parseInt(word);
		}

		return value;
	}

	private static void processFile(BufferedReader file) throws IOException, InvalidStatementException {
		String inputLine;

		while((inputLine = file.readLine()) != null) {
			performOperation(inputLine);
		}
	}

	public static void main(String[] args) {
		try(
			BufferedReader file = new BufferedReader(new FileReader(args[0]))
		) {
			processFile(file);
		}catch(FileNotFoundException e) {
			System.out.println("Error: " + args[0] + " not found");
		}catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}catch(InvalidStatementException e) {
			System.out.println("Error: " + e.getMessage());
		}catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
