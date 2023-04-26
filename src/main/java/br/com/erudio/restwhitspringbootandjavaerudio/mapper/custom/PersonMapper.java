package br.com.erudio.restwhitspringbootandjavaerudio.mapper.custom;

import br.com.erudio.restwhitspringbootandjavaerudio.data.vo.v2.PersonVOV2;
import br.com.erudio.restwhitspringbootandjavaerudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {
    public PersonVOV2 converteEntityToVo(Person person){
        PersonVOV2 vo = new PersonVOV2();
        vo.setId(person.getId());
        vo.setFirstName(person.getFirstName());
        vo.setLastName(person.getLastName());
        vo.setAddress(person.getAddress());
        vo.setGender(person.getGender());
        vo.setBirthDate(new Date());

        return vo;
    }
    public Person converteVoToEntity(PersonVOV2 personVOV2){
        Person person = new Person();
        person.setId(personVOV2.getId());
        person.setFirstName(personVOV2.getFirstName());
        person.setLastName(personVOV2.getLastName());
        person.setAddress(personVOV2.getAddress());
        person.setGender(personVOV2.getGender());

        return person;
    }
}
