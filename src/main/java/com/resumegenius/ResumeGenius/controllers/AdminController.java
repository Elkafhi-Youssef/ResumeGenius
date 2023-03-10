package com.resumegenius.ResumeGenius.controllers;

import com.resumegenius.ResumeGenius.requests.PersonRequest;
import com.resumegenius.ResumeGenius.responses.PersonResponse;
import com.resumegenius.ResumeGenius.services.PersonService;
import com.resumegenius.ResumeGenius.shared.dto.PersonDto;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;

@RestController
@RequestMapping("/person")
public class AdminController {
    @Autowired
    PersonService personService;
//    get one person and use dynamic segment
    @GetMapping(path = "/{id}")
    public  String getPerson(@PathVariable String id){
        return "get person methode "+ id;
    }

//   Create new admin
    @PostMapping("/createPerson")
    public PersonResponse createPerson(@RequestBody PersonRequest personRequest) throws InvocationTargetException, IllegalAccessException {
        System.out.println("koalaaaa");
        PersonDto personDto = new PersonDto();
        BeanUtils.copyProperties( personDto,personRequest );
        PersonDto createPerson = personService.createPerson(personDto);
        PersonResponse personResponse = new PersonResponse();
        BeanUtils.copyProperties( personResponse,createPerson );
        return personResponse;
    }
    @PutMapping
    public  String updatePerson(){
        return "createPerson methode ";
    }
    @DeleteMapping // pascalCase
    public  String deletePerson(){
        return "deletePerson methode ";
    }
}