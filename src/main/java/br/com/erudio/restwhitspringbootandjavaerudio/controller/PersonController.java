package br.com.erudio.restwhitspringbootandjavaerudio.controller;

import br.com.erudio.restwhitspringbootandjavaerudio.model.Person;
import br.com.erudio.restwhitspringbootandjavaerudio.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService service;
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Person findById(@PathVariable String id){
        return service.findById(id);
    }
}
