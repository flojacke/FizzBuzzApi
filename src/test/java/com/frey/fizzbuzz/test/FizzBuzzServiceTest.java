package com.frey.fizzbuzz.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.internal.WhiteboxImpl;

import com.frey.fizzbuzz.service.FizzBuzzServiceImpl;

@RunWith(PowerMockRunner.class)
@PrepareForTest(FizzBuzzServiceImpl.class)
public class FizzBuzzServiceTest {

	List<String> response;

	FizzBuzzServiceImpl FizzBuzz;

	@BeforeEach
	public void init() {
		FizzBuzz = new FizzBuzzServiceImpl();
		response = new ArrayList<>();
	}

	// partie sans boucle: test de l'algo FizzBuzz:
	@Test
	public void Return1WhenNumberIs1() throws Exception {
		String msg = WhiteboxImpl.invokeMethod(FizzBuzz, "evaluateNumber", 1);
		assertEquals(msg, "1");
	}

	@Test
	public void Return2WhenNumberIs2() throws Exception {
		String msg = WhiteboxImpl.invokeMethod(FizzBuzz, "evaluateNumber", 2);
		assertEquals(msg, "2");
	}

	@Test
	public void ReturnFizzWhenNumberIs3() throws Exception {
		String msg = WhiteboxImpl.invokeMethod(FizzBuzz, "evaluateNumber", 3);
		assertEquals(msg, "Fizz");
	}

	@Test
	public void ReturnBuzzWhenNumberIs5() throws Exception {
		String msg = WhiteboxImpl.invokeMethod(FizzBuzz, "evaluateNumber", 5);
		assertEquals(msg, "Buzz");
	}
	
	@Test
	public void ReturnFizzWhenNumberIs6() throws Exception {
		String msg = WhiteboxImpl.invokeMethod(FizzBuzz, "evaluateNumber", 6);
		assertEquals(msg, "Fizz");
	}
	
	@Test
	public void ReturnBuzzWhenNumberIs10() throws Exception {
		String msg = WhiteboxImpl.invokeMethod(FizzBuzz, "evaluateNumber", 10);
		assertEquals(msg, "Buzz");
	}

	@Test
	public void ReturnFizzBuzzWhenNumberIs15() throws Exception {
		String msg = WhiteboxImpl.invokeMethod(FizzBuzz, "evaluateNumber", 15);
		assertEquals(msg, "FizzBuzz");
	}
	
	@Test
	public void ReturnFizzBuzzWhenNumberIs30() throws Exception {
		String msg = WhiteboxImpl.invokeMethod(FizzBuzz, "evaluateNumber", 30);
		assertEquals(msg, "FizzBuzz");
	}
	
	// partie avec boucle: :
	@Test
	public void Send1WhenNumberIs1() {
		String[] tab = { "1" };
		complete(1, tab);
		assertEquals(FizzBuzz.calculate(1), response);
	}

	@Test
	public void Send1and2WhenNumberIs2() {
		String[] tab = { "1", "2" };
		complete(2, tab);
		assertEquals(FizzBuzz.calculate(2), response);
	}

	@Test
	public void Send12FizzWhenNumberIs3() {
		String[] tab = { "1", "2", "Fizz" };
		complete(3, tab);
		assertEquals(FizzBuzz.calculate(3), response);
	}

	@Test
	public void Send12Fizz4BuzzWhenNumberIs5() {
		String[] tab = { "1", "2", "Fizz", "4", "Buzz" };
		complete(5, tab);
		assertEquals(FizzBuzz.calculate(5), response);
	}

	@Test
	public void Send12Fizz4Buzz6WhenNumberIs6() {
		String[] tab = { "1", "2", "Fizz", "4", "Buzz", "Fizz" };
		complete(6, tab);
		assertEquals(FizzBuzz.calculate(6), response);
	}

	@Test
	public void Send12Fizz4Buzz678FizzBuzzWhenNumberIs10() {
		String[] tab = { "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz" };
		complete(10, tab);
		assertEquals(FizzBuzz.calculate(10), response);
	}

	@Test
	public void Send12Fizz4Buzz678FizzBuzz11Fizz1314FizzBuzzWhenNumberIs15() {
		String[] tab = { "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14",
				"FizzBuzz" };
		complete(15, tab);
		assertEquals(FizzBuzz.calculate(15), response);
	}

	@Test
	public void SendCorrectListWhenNumberIs30() {
		String[] tab = { "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14",
				"FizzBuzz", "16", "17", "Fizz", "19", "Buzz", "Fizz", "22", "23", "Fizz", "Buzz", "26","Fizz", "28", 
				"29", "FizzBuzz" };
		complete(30, tab);
		assertEquals(FizzBuzz.calculate(30), response);
	}

	public List<String> complete(int number, String tab[]) {
		for (int i = 1; i <= number; i++) {
			response.add(tab[i - 1]);
		}
		return response;
	}

}
