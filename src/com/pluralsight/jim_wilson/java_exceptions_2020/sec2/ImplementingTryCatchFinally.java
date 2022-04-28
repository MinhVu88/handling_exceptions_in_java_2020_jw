package com.pluralsight.jim_wilson.java_exceptions_2020.sec2;

import java.io.BufferedReader;
import java.io.FileReader;

public class ImplementingTryCatchFinally {
	private static void performOperation(String inputLine) {
		String[] parts = inputLine.split(" ");

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

	public static void main(String[] args) {
		BufferedReader file = null;

		String inputLine;

		try {
			file = new BufferedReader(new FileReader(args[0]));

			while((inputLine = file.readLine()) != null) {
				performOperation(inputLine);
			}
		}catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}finally {
			try {
				if(file != null) {
					System.out.println(args[0] + " is closed");

					file.close();
				}
			}catch(Exception e) {
				System.out.println("Error: can't close " + args[0]);
			}
		}
	}
}
