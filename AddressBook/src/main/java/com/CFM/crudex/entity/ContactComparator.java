package com.CFM.crudex.entity;

import java.util.Comparator;
/**
 * Implements Comparator to compare the contacts by name and ignoring case. 
 * @author jesseturner
 *
 */
public class ContactComparator implements Comparator<Contact> {

	@Override
	public int compare(Contact person, Contact person2) {
		
		return person.getName().toLowerCase().compareTo(person2.getName().toLowerCase());
	}

}
