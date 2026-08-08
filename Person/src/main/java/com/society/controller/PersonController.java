package com.society.controller;

import com.society.exception.MissingParameterException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.society.model.dto.PersonDto;
import com.society.service.PersonService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/persons")
public class PersonController {
	private final PersonService personService;
	public PersonController(PersonService personService) {
		this.personService=personService;
	}
	@PostMapping("/save")
	public ResponseEntity<PersonDto> savePerson(@RequestBody PersonDto personDto){
		PersonDto response = personService.savePerson(personDto);
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<PersonDto> updatePerson(@RequestBody PersonDto personDto, @PathVariable Long id){
		PersonDto response = personService.updatePerson(id, personDto);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletePerson(@PathVariable Long id){
		personService.deletePerson(id);
		return new ResponseEntity<>("Person deleted Successfully", HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PersonDto> getSinglePerson(@PathVariable Long id){
		PersonDto response = personService.getSinglePerson(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	@GetMapping("/all")
	public ResponseEntity<Iterable<PersonDto>>getAllPersons(){
		Iterable<PersonDto> response = personService.getAllPerson();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/get-by-username-and-firstname")
	public ResponseEntity<PersonDto> getPersonByusernameAndfirst_name(@RequestParam(required = false) String username,
															 @RequestParam(required = false) String first_name ){
		List<String> missingParameters = new ArrayList<>();
		if (username == null || username.trim().isEmpty()){
			missingParameters.add("username");
		}
		if (first_name == null || first_name.trim().isEmpty()){
			missingParameters.add("first_name");
		}
		if (!missingParameters.isEmpty()){
			String finalMessage= missingParameters.stream().collect(Collectors.joining(","));
			throw new MissingParameterException("Please Provide :"+ finalMessage);
		}

		PersonDto response = personService.getPersonByusernameAndfirst_name(username,first_name);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
}
