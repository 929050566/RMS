package com.aowin.stuff.exception;

import com.aowin.stuff.model.Person;

public class IdIsExistException extends Exception {
	
	private Person person;
	private int id;
	
	public IdIsExistException(Person person) {
		super();
		this.person = person;
	}
	
	
	public IdIsExistException(int id) {
		super();
		this.id = id;
	}


	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
}
