package br.com.erudio.restwhitspringbootandjavaerudio.service;

import br.com.erudio.restwhitspringbootandjavaerudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person create(Person person){
        logger.info("Finding one person!");
        person.setId(counter.incrementAndGet());
        return person;
    }

    public Person findById(String id) {
        logger.info("Finding one person!");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("firstName");
        person.setLastName("lastName");
        person.setAddress("Rua nomeRua, numeroRua, bairroRua");
        person.setGender("Masculino");
        return person;
    }

    public List<Person> findAll() {
        List<Person> persons = new ArrayList<>();
        logger.info("Finding one person!");
        for (int i = 0; i < 10; i++) {
            Person person = mockListPerson(i);

            persons.add(person);
        }
        return persons;
    }

    public Person update(Person person, String id){
        logger.info("Finding one person!");
        person.setId(Long.parseLong(id));
        return person;
    }

    public void delete(String id){
        logger.info("delete one person!");
    }

    private Person mockListPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("firstName");
        person.setLastName("lastName "+i);
        person.setAddress("Rua nomeRua, numeroRua, bairroRua");
        person.setGender(i%2 == 0 ? "Masculino" : "Feminino");
        return person;
    }
}
