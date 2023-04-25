package br.com.erudio.restwhitspringbootandjavaerudio.service;

import br.com.erudio.restwhitspringbootandjavaerudio.exception.ResourceNotFoundException;
import br.com.erudio.restwhitspringbootandjavaerudio.model.Person;
import br.com.erudio.restwhitspringbootandjavaerudio.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person create(Person person) {
        logger.info("create one person!");
        return personRepository.save(person);
    }

    public Person findById(Long id) {
        logger.info("findById one person!");
        return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));
    }

    public List<Person> findAll() {
        List<Person> persons = new ArrayList<>();
        logger.info("findAll one person!");
        return personRepository.findAll();
    }

    public Person update(Person person) {
        logger.info("Update one person!");
        var response = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));
        return personRepository.save(new Person(person));

    }

    public void delete(Long id) {
        logger.info("delete one person!");
        var response = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));
        personRepository.delete(response);
    }
}