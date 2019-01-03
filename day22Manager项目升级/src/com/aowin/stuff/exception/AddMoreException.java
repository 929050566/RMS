package com.aowin.stuff.exception;

import com.aowin.stuff.model.Person;

public class AddMoreException extends Exception {
	
	Person person;

	public AddMoreException(Person person) {
		super();
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
}
