package br.com.erudio.restwhitspringbootandjavaerudio.service;

import br.com.erudio.restwhitspringbootandjavaerudio.controller.PersonController;
import br.com.erudio.restwhitspringbootandjavaerudio.data.vo.v1.PersonVO;
import br.com.erudio.restwhitspringbootandjavaerudio.exception.RequireObjectIsNullException;
import br.com.erudio.restwhitspringbootandjavaerudio.exception.ResourceNotFoundException;
import br.com.erudio.restwhitspringbootandjavaerudio.mapper.DozerMapper;
import br.com.erudio.restwhitspringbootandjavaerudio.model.Person;
import br.com.erudio.restwhitspringbootandjavaerudio.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {

    @Autowired
    private PersonRepository personRepository;

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public PersonVO create(PersonVO person) {

        if(person == null) throw new RequireObjectIsNullException();

        logger.info("create one person!");
        var entity = DozerMapper.parseObject(person, Person.class);
        PersonVO vo = DozerMapper.parseObject(personRepository.save(entity), PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public PersonVO findById(Long id) {
        logger.info("findById one person!");
        var entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));
        PersonVO vo = DozerMapper.parseObject(entity, PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
        return vo;
    }

    public List<PersonVO> findAll() {
        List<PersonVO> persons = new ArrayList<>();
        logger.info("findAll one person!");
        List<PersonVO> vo = DozerMapper.parseListObjects(personRepository.findAll(), PersonVO.class);
        vo.stream().forEach(p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()));
        return vo;
    }

    public PersonVO update(PersonVO person) {

        if(person == null) throw new RequireObjectIsNullException();

        logger.info("Update one person!");
        var entity = personRepository.findById(person.getKey()).orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        PersonVO vo = DozerMapper.parseObject(personRepository.save(entity), PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
        return vo;

    }

    public void delete(Long key) {
        logger.info("delete one person!");
        var response = personRepository.findById(key).orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));
        personRepository.delete(response);
    }
}