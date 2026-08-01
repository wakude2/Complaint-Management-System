package com.society.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.society.exception.BadRequestException;
import com.society.exception.ResourceNotFoundException;
import com.society.model.dto.PersonDto;
import com.society.model.entity.Person;
import com.society.repository.PersonRepository;
import com.society.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
	
	private final PersonRepository personRepository;
	private final ModelMapper modelMapper;
	
	public PersonServiceImpl(PersonRepository personRepository, ModelMapper modelMapper) {
		this.personRepository= personRepository;
		this.modelMapper=modelMapper;
	}

	@Override
	public PersonDto personDto(PersonDto personDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonDto savePerson(PersonDto personDto) {
		// TODO Auto-generated method stub
		
		if(personDto.getId() != null) {
			throw new RuntimeException("Person already Exists");
		}
		Person entity = modelMapper.map(personDto, Person.class);
		Person saveEntity = personRepository.save(entity);
		return modelMapper.map(saveEntity, PersonDto.class);
	}

	@Override
	public PersonDto updatePerson(Long id, PersonDto personDto) {
		// TODO Auto-generated method stub
		if(id == null || personDto.getId() == null){
            throw new BadRequestException("Please provide person id");
        }
        if(!Objects.equals(id, personDto.getId())) {
            throw new BadRequestException("Id mismatch");
        }
        personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found with id: " + id));
        Person entity = modelMapper.map(personDto, Person.class);
        Person updatePerson = personRepository.save(entity);
        //entity.setUpdatedAt(LocalDateTime.now());
        //Person updatedEmployee = personRepository.save(entity);
        return modelMapper.map(updatePerson, PersonDto.class);
		//return null;
	}

	@Override
	public void deletePerson(Long id) {
		// TODO Auto-generated method stub
		Person person= personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found with id: " + id +"!!!"));
		personRepository.delete(person);
	}

	@Override
	public PersonDto getSinglePerson(Long id) {
		// TODO Auto-generated method stub
		Person person= personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found with id: " + id+"!!!"));
		return modelMapper.map(person, PersonDto.class);
	}

	@Override
	public List<PersonDto> getAllPerson() {
		// TODO Auto-generated method stub
		List<Person> persons = personRepository.findAll();
		if(persons.isEmpty()) {
			throw new ResourceNotFoundException("No Person Found");
		}
		return persons.stream().map( per -> modelMapper.map(per, PersonDto.class)).toList();
	}

	@Override
	public PersonDto getPersonByusernameAndfirst_name(String username, String first_name) {
		Person person=personRepository.findByUsernameAndFirstName(username,first_name).orElseThrow(()-> new ResourceNotFoundException("Person Not Found with username:" + username+"and First Name"+first_name));
		return modelMapper.map(person, PersonDto.class);
	}
//
//	@Override
//	public PersonDto getPersonByUserNameAndFirstName(String username, String first_name) {
//		Person person=personRepository.findByUsernameAndfirstname(username,first_name).orElseThrow(()-> new ResourceNotFoundException("Person Not Found with username:" + username+"and First Name"+first_name));
//		return modelMapper.map(person, PersonDto.class);
//	}

}
