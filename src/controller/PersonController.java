package controller;

import java.util.ArrayList;

import model.Person;

public class PersonController {
	private ArrayList<Person> people;
	public PersonController() {
		people = new ArrayList<>();
	}
	public void addPerson(Person p) {
		System.out.println("Se está añadiendo la persona " + p);
		people.add(p);
	}
	
	public ArrayList<Person> getPeople() {
		return people;
	}

	public void setPeople(ArrayList<Person> people) {
		this.people = people;
	}
	
	
}
