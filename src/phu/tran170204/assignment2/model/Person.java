package phu.tran170204.assignment2.model;

import java.util.Scanner;

public abstract class Person {
	
	protected int id;
	protected String name;
	protected int yearOfBirth;
	protected int type;
	
	public Person() {
	}
	
	public Person(int id) {
		this.id = id;
	}
	
	public Person(int id , int type) {
		this.id = id;
		this.type = type;
	}
	
	public Person(int id , String name , int yearOfBirth , int type ) {
		this.id = id;
		this.name = name;
		this.yearOfBirth = yearOfBirth;
		this.type = type;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYearOfBirth() {
		return yearOfBirth;
	}
	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	
	public abstract void input();
	public abstract String toString();
	public abstract float getSalary();
}