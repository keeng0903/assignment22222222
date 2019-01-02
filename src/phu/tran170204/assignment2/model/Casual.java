package phu.tran170204.assignment2.model;

import java.util.Scanner;

public class Casual extends Person {
	private int workDays;
	private float dayRates;
	private boolean isCreated;
	
	public Casual(int id, String name, int yearOfBirth, int type, int workDays, float dayRates) {
		super(id, name, yearOfBirth, type);
		this.workDays = workDays;
		this.dayRates = dayRates;
	}
	

	public int getWorkDays() {
		return workDays;
	}

	public void setWorkDays(int workDays) {
		this.workDays = workDays;
	}

	public float getDayRates() {
		return dayRates;
	}

	public void setDayRates(float dayRates) {
		this.dayRates = dayRates;
	}

	@Override
	public String toString() {
		return "Casual [workDays=" + workDays + ", dayRates=" + dayRates + ", id=" + id + ", yearOfBirth="
				+ yearOfBirth + ", type=" + type + ", name=" + name + "]";
	}
	
	@Override
	public void input() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter your name " + ((isCreated) ? this.name : " ") + " ");
		this.name = sc.nextLine();
		
		System.out.println("Enter yearOfBirth " + ((isCreated) ? this.yearOfBirth : " ") + ": ");
		this.yearOfBirth = Integer.parseInt(sc.nextLine());
		
		System.out.println("Enter your number of working days " + ((isCreated) ? this.workDays : " ") + ": ");
		this.workDays = Integer.parseInt(sc.nextLine());
		
		System.out.println("Enter your earning per working day " + ((isCreated) ? this.dayRates : " ") + ": ");
		this.dayRates= Float.parseFloat(sc.nextLine());
		
		if (!isCreated) isCreated = true;
	}
	
	private Casual (CasualBuilder builder) {
		this.isCreated = false;
		this.id = builder.id;
		this.name = builder.name;
		this.yearOfBirth = builder.yearOfBirth;
		this.type = builder.type;
		
		this.workDays = builder.workDays;
		this.dayRates = builder.dayRates;
	}
	
	public static class CasualBuilder{
		
		private int id;
		private String name;
		private int yearOfBirth;
		private int type;
		
		private int workDays;
		private float dayRates;
		
		public CasualBuilder(int id, int type) {
			this.id = id;
			this.type = type;
		}
		
		public CasualBuilder setYearOfBirth(int yearOfBirth) {
			this.yearOfBirth = yearOfBirth;
			return this;
		}
		
		public CasualBuilder setName(String name) {
			this.name = name;
			return this;
		}
		
		public CasualBuilder setWorkDays(int workDays) {
			this.workDays = workDays;
			return this;
		}
		
		public CasualBuilder setDayRates(float dayRates) {
			this.dayRates = dayRates;
			return this;
		}
		
		public Casual build() {
			return new Casual(this);
		}
	}
	@Override
	public float getSalary() {
		float salary = workDays * dayRates;
		return salary;
	}
}
