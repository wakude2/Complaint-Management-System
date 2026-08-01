package com.society.service;

import java.util.List;

import com.society.model.dto.PersonDto;

public interface PersonService {
	PersonDto  personDto(PersonDto personDto);
	PersonDto  savePerson(PersonDto personDto);
	PersonDto  updatePerson(Long id,PersonDto personDto);
	
	void  deletePerson(Long id);
	PersonDto  getSinglePerson(Long id);
	List<PersonDto> getAllPerson();

    PersonDto getPersonByusernameAndfirst_name(String username, String first_name);
}
