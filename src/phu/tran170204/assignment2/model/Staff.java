package phu.tran170204.assignment2.model;

import java.util.Scanner;

import phu.tran170204.assignment2.controller.Observer;
import phu.tran170204.assignment2.define.Define;

public class Staff extends Person implements Observer{
	private String homeTown;
	private String department;
	private int workDays;
	private float salaryRatio;
	private int allowance;
	private String position;
	private int workYear;
	private int selection;
	private float basicSalary;
	private boolean isCreated;
	
	public Staff() { 
		
	}
	

	public String getHomeTown() {
		return homeTown;
	}

	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getWorkDays() {
		return workDays;
	}

	public void setWorkDays(int workDays) {
		this.workDays = workDays;
	}

	public float getSalaryRatio() {
		return salaryRatio;
	}

	public void setSalaryRatio(float salaryRatio) {
		this.salaryRatio = salaryRatio;
	}

	public int getAllowance() {
		return allowance;
	}

	public void setAllowance(int allowance) {
		this.allowance = allowance;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getWorkYear() {
		return workYear;
	}

	public void setWorkYear(int workYear) {
		this.workYear = workYear;
	}

	public float getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(float basicSalary) {
		this.basicSalary = basicSalary;
	}

	public void input() {
		Scanner sc = new Scanner ( System.in);
		
		System.out.println("Enter name" + ((isCreated ? this.name : " ") + " "));
		this.name = sc.nextLine();
		
		System.out.println("Enter yearOfBirth" + ((isCreated ? this.yearOfBirth : " ") + " "));
		this.yearOfBirth = Integer.parseInt(sc.nextLine());
		
		System.out.println("Enter homeTown" + ((isCreated ? this.homeTown : " ") + " "));
		this.homeTown = sc.nextLine();
		
		System.out.println("Enter department" + ((isCreated ? this.department : " ") + " "));
		this.department = sc.nextLine();
		
		System.out.println("Enter work day" + ((isCreated ? this.workDays : " ") + " "));
		this.workDays = Integer.parseInt(sc.nextLine());
		
		System.out.println("Enter salary ratio " + ((isCreated ? this.salaryRatio : " ") + " "));
		this.salaryRatio = Float.parseFloat(sc.nextLine());
		
		System.out.println("Enter allowance " + ((isCreated ? this.allowance : " ") + " "));
		this.allowance = Integer.parseInt(sc.nextLine());
		
		System.out.println("Enter allowance" + ((isCreated ? this.workYear : " ") + " "));
		this.workYear = Integer.parseInt(sc.nextLine());
		
		System.out.println("Enter position" + ((isCreated ? this.position : " ") + " "));
		System.out.println("1. Manager ");
		System.out.println("2. Deputy ");
		System.out.println("3. Employees ");
		selection = sc.nextInt();
		switch (selection) {
		case Define.TYPE_OF_MANAGER: {
			this.position = Define.POSITION_OF_MANAGER;
			this.allowance = Define.ALLOWANCE_OF_MANAGER;
			break;
		}
		case Define.TYPE_OF_DEPUTY: {
			this.position = Define.POSITION_OF_DEPUTY;
			this.allowance = Define.ALLOWANCE_OF_DEPUTY;
			break;
		}
		case Define.TYPE_OF_EMPLOYEES: {
			this.position = Define.POSITION_OF_EMPLOYEES;
			this.allowance = Define.ALLOWANCE_OF_EMPLOYEES;
			break;
		}
		}
		
		basicSalary = Define.DEFAULT_BASIC_SALARY;
		
		if(!isCreated) {
			isCreated = true;
		}
		
	}
	
	private  Staff (StaffBuilder builder) {
		this.isCreated = false;
		this.id = builder.id;
		this.name = builder.name;
		this.yearOfBirth = builder.yearOfBirth;
		this.type = builder.type;
		this.homeTown = builder.homeTown;
		this.department = builder.department;
		this.workDays = builder.workDays;
		this.salaryRatio = builder.salaryRatio;
		this.allowance = builder.allowance;
		this.position = builder.position;
		this.workYear = builder.workYear;
		this.basicSalary = builder.basicSalary;
	}
	
	public static class StaffBuilder{
		
		private int id;
		private String name;
		private int yearOfBirth;
		private int type;
		
		private String homeTown;
		private String department;
		private int workDays;
		private float salaryRatio;
		private int allowance;
		private String position;
		private int workYear;
		private float basicSalary;
		
		
		
		public StaffBuilder (int id, int type) {
			this.id = id;
			this.type = type;
		}
		
		public StaffBuilder setYearOfBirth(int yearOfBirth) {
			this.yearOfBirth = yearOfBirth;
			return this;
		}
	
		public StaffBuilder setName(String name) {
			this.name = name;
			return this;
		}
		
		public StaffBuilder setHomeTown(String homeTown) {
			this.homeTown = homeTown;
			return this;
		}
	
		public StaffBuilder setDepartment(String department) {
			this.department = department;
			return this;
		}
	
		public StaffBuilder setWorkDays(int workDays) {
			this.workDays = workDays;
			return this;
		}
	
		public StaffBuilder setSalaryRatio(float salaryRatio) {
			this.salaryRatio = salaryRatio;
			return this;
		}
	
		public StaffBuilder setAllowance(int allowance) {
			this.allowance = allowance;
			return this;
		}
		
		public StaffBuilder setPosition(String position) {
			this.position = position;
			return this;
		}
	
		public StaffBuilder setWorkYear(int workYear) {
			this.workYear = workYear;
			return this;
		}
		
		public StaffBuilder setBasicSalary(float basicSalary) {
			this.basicSalary = basicSalary;
			return this;
		}
		
		public Staff build() {
			return new Staff(this);
		}
	}
	@Override 
	public void update(float basicSalary) {
		this.basicSalary = basicSalary;
	}
	
	@Override
	public float getSalary() {
		float salary = salaryRatio * basicSalary + allowance + workDays * 30;
		return salary;
	}

	@Override
	public String toString() {
		return "Staff [homeTown=" + homeTown + ", department=" + department + ", workDays=" + workDays
				+ ", salaryRatio=" + salaryRatio + ", allowance=" + allowance + ", position=" + position
				+ ", workYear=" + workYear + ", basicSalary=" + basicSalary + ", id=" + id + ", yearOfBirth="
						+ yearOfBirth + ", type=" + type + ", name=" + name + "]";
	}
}