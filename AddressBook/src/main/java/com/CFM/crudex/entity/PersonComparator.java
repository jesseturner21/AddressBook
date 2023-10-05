package com.CFM.crudex.entity;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {

	@Override
	public int compare(Person person, Person person2) {
		
		return person.getName().toLowerCase().compareTo(person2.getName().toLowerCase());
	}

}
