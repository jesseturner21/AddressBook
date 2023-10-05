package com.CFM.crudex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CFM.crudex.entity.Person;

public interface PersonRepository extends JpaRepository< Person, Integer>{

	List<Person> findByName(String name);
}
