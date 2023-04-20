package br.com.erudio.restwhitspringbootandjavaerudio.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HellController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public HelloDTO getHello(){
        return new HelloDTO("Hello World!");
    }
}

@Data
@Getter
@AllArgsConstructor
class HelloDTO {

    @NotFound
    private String hello;
}