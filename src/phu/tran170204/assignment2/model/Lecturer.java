package phu.tran170204.assignment2.model;

import java.util.Scanner;

import phu.tran170204.assignment2.controller.Observer;
import phu.tran170204.assignment2.define.Define;


public class Lecturer extends Person implements Observer {
	
	private String homeTown;
	private String department;
	private String level;
	private int allowance;
	private int periodsInMonth;
	private float salaryRatio;
	private int workYear;
	private int selection;
	private float basicSalary;
	private boolean isCreated;
	
	
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
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int getAllowance() {
		return allowance;
	}
	public void setAllowance(int allowance) {
		this.allowance = allowance;
	}
	public int getPeriodsInMonth() {
		return periodsInMonth;
	}
	public void setPeriodsInMonth(int periodsInMonth) {
		this.periodsInMonth = periodsInMonth;
	}
	public float getSalaryRatio() {
		return salaryRatio;
	}
	public void setSalaryRatio(float salaryRatio) {
		this.salaryRatio = salaryRatio;
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
		
		System.out.println("Enter name : " + ((isCreated ? this.name : " ") + " "));
		this.name = sc.nextLine();
		
		System.out.println("Enter year : "+ ((isCreated ? this.yearOfBirth : " ") + " "));
		this.yearOfBirth = Integer.parseInt(sc.nextLine());
		
		System.out.println("Enter homeTown "+ ((isCreated ? this.homeTown : " ") + " "));
		this.homeTown = sc.nextLine();
		
		System.out.println("Enter department " + ((isCreated ? this.department : " ") + " "));
		this.department = sc.nextLine();
		
		System.out.println("Enter level " + ((isCreated ? this.level : " ") + " "));
		System.out.println("1. Bachelor. ");
		System.out.println("2. Master . ");
		System.out.println("3. Doctor . ");
		
		selection = Integer.parseInt(sc.nextLine());
		switch (selection) {
		case Define.TYPE_OF_BACHELOR: {
			this.level = Define.LEVEL_OF_BACHELOR;
			this.allowance = Define.ALLOWANCE_OF_BACHELOR;
			break;
		}
		case Define.TYPE_OF_MASTER: {
			this.level = Define.LEVEL_OF_MASTER;
			this.allowance = Define.ALLOWANCE_OF_MASTER;
			break;
		}
		case Define.TYPE_OF_DOCTOR: {
			this.level = Define.LEVEL_OF_DOCTOR;
			this.allowance = Define.ALLOWANCE_OF_DOCTOR;
			break;
		}
		}
		
		basicSalary = Define.DEFAULT_BASIC_SALARY;
		
		if(!isCreated) {
			isCreated = true;
		}
		
	}
	
		private  Lecturer (LecturerBuilder builder) {
			this.isCreated = false;
			this.id = builder.id;
			this.name = builder.name;
			this.yearOfBirth = builder.yearOfBirth;
			this.type = builder.type;
			this.homeTown = builder.homeTown;
			this.department = builder.department;
			this.level = builder.level;
			this.allowance = builder.allowance;
			this.periodsInMonth = builder.periodsInMonth;
			this.salaryRatio = builder.salaryRatio;
			this.workYear = builder.workYear;
			this.basicSalary = builder.basicSalary;
			
	}
	
		public static class LecturerBuilder{
			
			private int id;
			private String name;
			private int yearOfBirth;
			private int type;
			
			private String homeTown;
			private String department;
			private String level;
			private int allowance;
			private int periodsInMonth;
			private float salaryRatio;
			private int workYear;
			private float basicSalary;
				
				public LecturerBuilder(int id, int type) {
					this.id = id;
					this.type = type;
			}
			
				public LecturerBuilder setYearOfBirth(int yearOfBirth) {
					this.yearOfBirth = yearOfBirth;
					return this;
			}
			
				public LecturerBuilder setName(String name) {
					this.name = name;
					return this;
			}
			
			
				public LecturerBuilder setHomeTown(String homeTown) {
					this.homeTown = homeTown;
					return this;
			}
				
				public LecturerBuilder setDepartment(String department) {
					this.department = department;
					return this;
			}
				
				public LecturerBuilder setLevel(String level) {
					this.level = level;
					return this;
			}
			
				public LecturerBuilder setAllowance(int allowance) {
					this.allowance = allowance;
					return this;
			}
				
				public LecturerBuilder setPeriodsInMonth(int periodsInMonth) {
					this.periodsInMonth = periodsInMonth;
					return this;
			}
				
				public LecturerBuilder setSalaryRatio(float salaryRatio) {
					this.salaryRatio = salaryRatio;
					return this;
			}
				
				public LecturerBuilder setWorkYear(int workYear) {
					this.workYear = workYear;
					return this;
			}
				public LecturerBuilder setBasicSalary(float basicSalary) {
					this.basicSalary = basicSalary;
					return this;
			}
				
				public Lecturer build() {
					return new Lecturer(this);
			}
		}

		@Override
		public void update(float basicSalary) {
			this.basicSalary = basicSalary;
		}
		
		@Override
		public float getSalary() {
			float salary = salaryRatio * basicSalary + allowance + periodsInMonth * 45;
			return salary;
		}

		@Override
		public String toString() {
			return "Lecturer [homeTown=" + homeTown + ", department=" + department + ", level=" + level + ", allowance="
					+ allowance + ", periodsInMonth=" + periodsInMonth + ", salaryRatio=" + salaryRatio
					+ ", workYear=" + workYear + ", basicSalary=" + basicSalary + ", id=" + id + ", yearOfBirth="
							+ yearOfBirth + ", type=" + type + ", name=" + name + "]";
		}
}