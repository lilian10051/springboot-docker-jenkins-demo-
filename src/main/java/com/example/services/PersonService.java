package com.example.services;

import com.example.data.Person;
import com.example.repos.PersonRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

	private final PersonRepo personRepo;

	public PersonService(PersonRepo personRepo) {
		this.personRepo = personRepo;
	}

	public Person savePerson(Person student) {
		return personRepo.save(student);
	}

	public List<Person> getAllPersons() {
		return personRepo.findAll();
	}

	public Optional<Person> getPersonById(Long id) {
		return personRepo.findById(id);
	}

	public void deletePerson(Long id) {
		personRepo.deleteById(id);
	}
}
