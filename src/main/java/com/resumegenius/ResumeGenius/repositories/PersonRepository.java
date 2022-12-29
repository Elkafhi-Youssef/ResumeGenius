package com.resumegenius.ResumeGenius.repositories;

import com.resumegenius.ResumeGenius.entities.AdminEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<AdminEntity,Long> {
//    verify if user already exists
    AdminEntity findByEmail(String email);
}