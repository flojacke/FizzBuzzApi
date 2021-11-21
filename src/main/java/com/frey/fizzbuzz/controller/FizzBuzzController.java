package com.frey.fizzbuzz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frey.fizzbuzz.service.FizzBuzzService;

@RestController
@RequestMapping("/api/v1/fizz-buzz/")
public class FizzBuzzController {

	private final FizzBuzzService service;

	@Autowired
	public FizzBuzzController(FizzBuzzService service) {
		this.service = service;
	}

	@GetMapping(value = "/numbers/{input}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<String>> getFizzBuzz(@PathVariable int input) {
		List<String> sequences = service.calculate(input);
		return new ResponseEntity<List<String>>(sequences, HttpStatus.OK);
	}

}
