package com.resumegenius.ResumeGenius.services.impl;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.resumegenius.ResumeGenius.entities.AdminEntity;
import com.resumegenius.ResumeGenius.repositories.PersonRepository;
import com.resumegenius.ResumeGenius.services.PersonService;
import com.resumegenius.ResumeGenius.shared.dto.PersonDto;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

@Service
public class PersonServiceimpl implements PersonService {
//    injection de dependence
    @Autowired
    PersonRepository personRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public PersonDto createPerson(PersonDto person) throws InvocationTargetException, IllegalAccessException {
//        check user if already exists
        AdminEntity checkPerson =  personRepository.findByEmail(person.getEmail());
        if(checkPerson!=null) throw new RuntimeException("Person already exists");
        AdminEntity personEntity = new AdminEntity();
        BeanUtils.copyProperties(personEntity,person);
//        crypter le mot de passe d'utilisateur
        personEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(person.getPassword()));
        personEntity.setPersonId("personid");
//        persistance
        AdminEntity newPerson = personRepository.save(personEntity);
//        create new object type userDto
        PersonDto newPersonDto = new PersonDto();
        BeanUtils.copyProperties(newPersonDto,newPerson);

        return newPersonDto;
    }

    @Override
    public AdminEntity findPersonByEmail(String email) throws InvocationTargetException, IllegalAccessException {
        AdminEntity personEntity = new AdminEntity();
        personEntity =  personRepository.findByEmail(email);
        if (personEntity == null) throw new UsernameNotFoundException("email not found");
        return personEntity;
    }
}