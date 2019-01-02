package phu.tran170204.assignment2.controller;

import java.util.ArrayList;
import java.util.List;

public class Subject {
	private List<Observer> observers = new ArrayList<Observer>();
	public void attach(Observer observer) {
		observers.add(observer);
	}
	public void datach(Observer observer) {
		observers.remove(observer);
	}
	public void notifyChange(float basicsalary) {
		for (Observer observer : observers) {
			observer.update(basicsalary);
		}
	}
}


