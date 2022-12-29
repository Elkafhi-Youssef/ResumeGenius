package com.resumegenius.ResumeGenius.services;

import com.resumegenius.ResumeGenius.entities.AdminEntity;
import com.resumegenius.ResumeGenius.shared.dto.PersonDto;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;


public interface PersonService  {
    PersonDto createPerson(PersonDto userDto) throws InvocationTargetException, IllegalAccessException;
    AdminEntity findPersonByEmail(String email) throws InvocationTargetException, IllegalAccessException;

}