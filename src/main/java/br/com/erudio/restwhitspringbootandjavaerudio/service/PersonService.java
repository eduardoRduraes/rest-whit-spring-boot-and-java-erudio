package br.com.erudio.restwhitspringbootandjavaerudio.service;

import br.com.erudio.restwhitspringbootandjavaerudio.data.vo.v1.PersonVO;
import br.com.erudio.restwhitspringbootandjavaerudio.data.vo.v2.PersonVOV2;
import br.com.erudio.restwhitspringbootandjavaerudio.exception.ResourceNotFoundException;
import br.com.erudio.restwhitspringbootandjavaerudio.mapper.DozerMapper;
import br.com.erudio.restwhitspringbootandjavaerudio.mapper.custom.PersonMapper;
import br.com.erudio.restwhitspringbootandjavaerudio.model.Person;
import br.com.erudio.restwhitspringbootandjavaerudio.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonMapper personMapper;

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public PersonVO create(PersonVO person) {
        logger.info("create one person!");
        var entity = DozerMapper.parseObject(person, Person.class);
        return DozerMapper.parseObject(personRepository.save(entity), PersonVO.class);
    }

    public PersonVOV2 createV2(PersonVOV2 person) {
        logger.info("create one person VOV2!");
        var entity = personMapper.converteVoToEntity(person);
        return personMapper.converteEntityToVo(personRepository.save(entity));
    }

    public PersonVO findById(Long id) {
        logger.info("findById one person!");
        var entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));
        return DozerMapper.parseObject(entity, PersonVO.class);
    }

    public List<PersonVO> findAll() {
        List<PersonVO> persons = new ArrayList<>();
        logger.info("findAll one person!");
        return DozerMapper.parseListObjects(personRepository.findAll(), PersonVO.class);
    }

    public PersonVO update(PersonVO person) {
        logger.info("Update one person!");
        var entity = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return DozerMapper.parseObject(personRepository.save(entity), PersonVO.class);

    }

    public void delete(Long id) {
        logger.info("delete one person!");
        var response = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));
        personRepository.delete(response);
    }
}