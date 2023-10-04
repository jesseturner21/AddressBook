package com.CFM.crudex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CFM.crudex.entity.Person;

public interface PersonRepository extends JpaRepository< Person, Integer>{

}
