package com.frey.fizzbuzz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FizzBuzzServiceImpl implements FizzBuzzService {

	@Override
	public List<String> calculate(int input) {
		return IterateOnInput(input);
	}

	private List<String> IterateOnInput(int number) {
		ArrayList<String> sequences = new ArrayList<String>();
		int i = 1;
		while (i <= number) {
			sequences.add(evaluateNumber(i++));
		}
		return sequences;
	}

	private String evaluateNumber(int number) {
		if (number % 15 == 0)
			return "FizzBuzz";
		if (number % 3 == 0)
			return "Fizz";
		if (number % 5 == 0)
			return "Buzz";
		return String.valueOf(number);
	}

}
