package br.com.erudio.restwhitspringbootandjavaerudio.service.unittests.mockito;

import br.com.erudio.restwhitspringbootandjavaerudio.data.vo.v1.PersonVO;
import br.com.erudio.restwhitspringbootandjavaerudio.exception.RequireObjectIsNullException;
import br.com.erudio.restwhitspringbootandjavaerudio.exception.ResourceNotFoundException;
import br.com.erudio.restwhitspringbootandjavaerudio.mapper.mocks.MockPerson;
import br.com.erudio.restwhitspringbootandjavaerudio.model.Person;
import br.com.erudio.restwhitspringbootandjavaerudio.repository.PersonRepository;
import br.com.erudio.restwhitspringbootandjavaerudio.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    MockPerson input;

    @InjectMocks
    private PersonService personService;

    @Mock
    PersonRepository personRepository;

    @BeforeEach
    void setUp() {
        input = new MockPerson();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void create() {
        Person entity = input.mockEntity(1);
        Person persisted = entity;
        persisted.setId(1L);

        PersonVO vo = input.mockVO(1);
        vo.setKey(1L);

        when(personRepository.save(entity)).thenReturn(persisted);

        var result = personService.create(vo);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());

        assertTrue(result.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]"));

        assertEquals("First Name Test1", result.getFirstName());
        assertEquals("Last Name Test1", result.getLastName());
        assertEquals("Addres Test1", result.getAddress());
        assertEquals("Female", result.getGender());
    }
    @Test
    void createWithNullPerson() {
        Exception exception = assertThrows(RequireObjectIsNullException.class, () -> {
            personService.create(null);
        });
        String expectedMessage = "It is not allowed to persist a null object!";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void findById() {
        Person entity = input.mockEntity(1);
        entity.setId(1L);

        when(personRepository.findById(1L)).thenReturn(Optional.of(entity));

        var result = personService.findById(1L);

        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());

        assertTrue(result.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]"));

        assertEquals("First Name Test1", result.getFirstName());
        assertEquals("Last Name Test1", result.getLastName());
        assertEquals("Addres Test1", result.getAddress());
        assertEquals("Female", result.getGender());
    }

    @Test
    void findAll() {
        List<Person> entityList = input.mockEntityList();

        when(personRepository.findAll()).thenReturn(entityList);

        var people = personService.findAll();

        assertNotNull(people);
        assertEquals(14, people.size());

        var personOne = people.get(1);

        assertNotNull(personOne);
        assertNotNull(personOne.getKey());
        assertNotNull(personOne.getLinks());

        assertTrue(personOne.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]"));

        assertEquals("First Name Test1", personOne.getFirstName());
        assertEquals("Last Name Test1", personOne.getLastName());
        assertEquals("Addres Test1", personOne.getAddress());
        assertEquals("Female", personOne.getGender());

        var personTwo = people.get(4);

        assertNotNull(personTwo);
        assertNotNull(personTwo.getKey());
        assertNotNull(personTwo.getLinks());

        assertTrue(personTwo.toString().contains("links: [</api/person/v1/4>;rel=\"self\"]"));

        assertEquals("First Name Test4", personTwo.getFirstName());
        assertEquals("Last Name Test4", personTwo.getLastName());
        assertEquals("Addres Test4", personTwo.getAddress());
        assertEquals("Male", personTwo.getGender());

        var personSeven = people.get(7);

        assertNotNull(personSeven);
        assertNotNull(personSeven.getKey());
        assertNotNull(personSeven.getLinks());

        assertTrue(personSeven.toString().contains("links: [</api/person/v1/7>;rel=\"self\"]"));

        assertEquals("First Name Test7", personSeven.getFirstName());
        assertEquals("Last Name Test7", personSeven.getLastName());
        assertEquals("Addres Test7", personSeven.getAddress());
        assertEquals("Female", personSeven.getGender());

    }

    @Test
    void update() {
        Person entity = input.mockEntity(1);
        entity.setId(1L);

        Person persisted = entity;
        persisted.setId(1L);

        PersonVO vo = input.mockVO(1);
        vo.setKey(1L);

        when(personRepository.findById(1L)).thenReturn(Optional.of(entity));

        when(personRepository.save(entity)).thenReturn(persisted);

        var result = personService.update(vo);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());

        assertTrue(result.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]"));

        assertEquals("First Name Test1", result.getFirstName());
        assertEquals("Last Name Test1", result.getLastName());
        assertEquals("Addres Test1", result.getAddress());
        assertEquals("Female", result.getGender());
    }

    @Test
    void updateWithNullPerson() {
        Exception exception = assertThrows(RequireObjectIsNullException.class, () -> {
            personService.update(null);
        });
        String expectedMessage = "It is not allowed to persist a null object!";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void delete() throws ResourceNotFoundException {
        Person entity = input.mockEntity(1);
        entity.setId(1L);

        when(personRepository.findById(1L)).thenReturn(Optional.of(entity));

        personService.delete(1L);
    }

}