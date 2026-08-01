package com.society.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.society.model.entity.Person;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByUsernameAndFirstName(String username, String firstName);
}
