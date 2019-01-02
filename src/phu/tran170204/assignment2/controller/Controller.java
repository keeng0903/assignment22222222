package phu.tran170204.assignment2.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import phu.tran170204.assignment2.define.Define;
import phu.tran170204.assignment2.model.Staff;
import phu.tran170204.assignment2.model.Casual;
import phu.tran170204.assignment2.model.Lecturer;
import phu.tran170204.assignment2.model.Person;

public class Controller {
	public static void ArrayList() {
		ArrayList<String> srt = new ArrayList<String>() ;
	}

	public static void menuOne() { 
		int value;
		while (true) {
			System.out.println("Menu 1 :");
			System.out.println("1.1 Add cadre to the end of the list.");
			System.out.println("1.2 Add cadre to the top of the list.");
			System.out.println("1.3 Add the cadence to the rear of the k position.");
			System.out.println("1.4 Add new cadence to the end of the list from the staff.txt file.");
			System.out.println("1.5 Add new seasonal workers from the labor.txt list.");
			System.out.println("1.6 Back to previous section.");
		
				value = inputSelection(1, 6);
				switch (value) {
				case 1: {
					switch (selectTypeOfEmployee()) {
					case Define.TYPE_OF_LECTURER: {
						 Lecturer lecturer = (Lecturer)PersonFactory.getPerson(Define.TYPE_OF_LECTURER);
						 lecturer.input();
						 Define.persons.add(lecturer);
						 break;
					}
					
					case Define.TYPE_OF_STAFF: {
						Staff staff = (Staff)PersonFactory.getPerson(Define.TYPE_OF_STAFF);
						staff.input();
						Define.persons.add(staff);
						break;
					}
					
					case Define.TYPE_OF_CASUAL: {
						Casual casualWorker = (Casual)PersonFactory.getPerson(Define.TYPE_OF_CASUAL);
						casualWorker.input();
						Define.persons.add(casualWorker);
						break;
					}
					}
					break;
				}
				
				case 2: {
					switch (selectTypeOfEmployee()) {
					case Define.TYPE_OF_LECTURER: {
						 Lecturer lecturer = (Lecturer)PersonFactory.getPerson(Define.TYPE_OF_LECTURER);
						 lecturer.input();
						 Define.persons.add(0, lecturer);
						 break;
					}
					
					case Define.TYPE_OF_STAFF: {
						Staff staff = (Staff)PersonFactory.getPerson(Define.TYPE_OF_STAFF);
						staff.input();
						Define.persons.add(0, staff);
						break;
					}
					
					case Define.TYPE_OF_CASUAL: {
						Casual casualWorker = (Casual)PersonFactory.getPerson(Define.TYPE_OF_CASUAL);
						casualWorker.input();
						Define.persons.add(0, casualWorker);
						break;
					}
					}
					break;
				}
				
				case 3: {
					Scanner sc = new Scanner(System.in);
					System.out.println("Enter k position: ");
					int k = sc.nextInt();
					
					switch (selectTypeOfEmployee()) {
					case Define.TYPE_OF_LECTURER: {
						 Lecturer lecturer = (Lecturer)PersonFactory.getPerson(Define.TYPE_OF_LECTURER);
						 lecturer.input();
						 Define.persons.add(k - 1, lecturer);
						 break;
					}
					
					case Define.TYPE_OF_STAFF: {
						Staff staff = (Staff)PersonFactory.getPerson(Define.TYPE_OF_STAFF);
						staff.input();
						Define.persons.add(k - 1, staff);
						break;
					}
					
					case Define.TYPE_OF_CASUAL: {
						Casual casualWorker = (Casual)PersonFactory.getPerson(Define.TYPE_OF_CASUAL);
						casualWorker.input();
						Define.persons.add(k - 1, casualWorker);
						break;
					}
					}
					break;
				}
				
				case 4: {
					Scanner sc = null;
					try {
						sc = new Scanner(new File("staff.txt"));
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} 
					int numberOfStaffs = Integer.parseInt(sc.nextLine());
					int type;
					float salaryRatio, basicSalary;
					int yearOfBirth, workYear, workDays, periodsInMonth;
					String name, homeTown, department, position, level;
					
					for (int index = 0; index < numberOfStaffs; index++) {
						Define.LastestID++;
						
						type = Integer.parseInt(sc.nextLine());
						yearOfBirth = Integer.parseInt(sc.nextLine());
						name = sc.nextLine();
						homeTown = sc.nextLine();
						department = sc.nextLine();
						level = sc.nextLine();
						workYear = Integer.parseInt(sc.nextLine());
						salaryRatio = Float.parseFloat(sc.nextLine());
						basicSalary = Float.parseFloat(sc.nextLine());
						
						if (type == Define.TYPE_OF_LECTURER) {
							level = sc.nextLine();
							periodsInMonth = Integer.parseInt(sc.nextLine());
							
							Lecturer newLecturer = new Lecturer.LecturerBuilder(Define.LastestID, Define.TYPE_OF_LECTURER)
														.setYearOfBirth(yearOfBirth)
														.setName(name)
														.setHomeTown(homeTown)
														.setDepartment(department)
														.setWorkYear(workYear)
														.setSalaryRatio(salaryRatio)
														.setLevel(level)
														.setPeriodsInMonth(periodsInMonth)
														.setBasicSalary(basicSalary)
														.build();
							
							Define.persons.add(newLecturer);
						} else {
							position = sc.nextLine();
							workDays = Integer.parseInt(sc.nextLine());
							
							Staff newStaff = new Staff.StaffBuilder(Define.LastestID, Define.TYPE_OF_STAFF)
														.setYearOfBirth(yearOfBirth)
														.setName(name)
														.setHomeTown(homeTown)
														.setDepartment(department)
														.setWorkYear(workYear)
														.setSalaryRatio(salaryRatio)
														.setPosition(position)
														.setWorkDays(workDays)
														.setBasicSalary(basicSalary)
														.build();
							
							Define.persons.add(newStaff);							
						}
					}
					
					break;
				}
				
				case 5: {
					Scanner sc = null;
					try {
						sc = new Scanner(new File("labor.txt"));
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					int numberOfCasualWorkers = Integer.parseInt(sc.nextLine());
					int yearOfBirth, workDays;
					float dayRates, basicSalary;
					String name;
					
					for (int index = 0; index < numberOfCasualWorkers; index++) {
						name = sc.nextLine();
						yearOfBirth = Integer.parseInt(sc.nextLine());
						workDays = Integer.parseInt(sc.nextLine());
						dayRates = Float.parseFloat(sc.nextLine());
						
						Casual newCasualWorker = new Casual.CasualBuilder(Define.LastestID, Define.TYPE_OF_CASUAL)
								.setName(name)
								.setWorkDays(workDays)
								.setYearOfBirth(yearOfBirth)
								.setDayRates(dayRates)
								.build();
						
						Define.persons.add(newCasualWorker);
					}
		
					break;
				}
				
				case 6: {
					return;
				}
			}
		}
	}
	
	public static void menuTwo() {
		System.out.println("Menu 2 :");
		System.out.println("Enter the staff number to edit. ");
		Scanner sc = new Scanner(System.in);
		int value = sc.nextInt();
		
		if ((value >= 0) && (value < Define.persons.size())) {
			Define.persons.get(value).input();
		}
		else {
			System.out.println("Can not found!");
		}
		
		return;
	}
	
	public static void menuThree() {
		System.out.println("Menu 3 : ");
		System.out.println("Enter the staff number to delete .");
		Scanner sc = new Scanner(System.in);
		int value = sc.nextInt();
		
		if ((value >= 0) && (value < Define.persons.size())) {
			Define.persons.remove(value);
		}
		else {
			System.out.println("Can not found! ");
		}
		
		return;
	}
	
	public static void menuFour() {
		int value;
		System.out.println("Menu 4 : ");
		System.out.println("4.1 Displays the current list.");
		System.out.println("4.2 Displays the list after incremental payroll.");
		System.out.println("4.3 Displays the list after alphabetical order.");
		System.out.println("4.4 Personnel Search by Name .");
		System.out.println("4.5 Personnel search by year of birth .");
		System.out.println("4.6 Return . ");
		
				value = inputSelection(1, 6);
				switch (value) {
				case 1: {
					showListPerson(Define.persons);
					break;
				}
				
				case 2: {
					ArrayList<Person> persons = new ArrayList<Person>();
					persons = Define.persons;
					
					for(int i = 0 ; i < Define.persons.size() ; i++ ) {
						for (int j = i + 1 ; j < Define.persons.size() ; j++ ) {
							if ( persons.get(i).getSalary() > persons.get(j).getSalary()) {
								Person temp = persons.get(j);
								persons.set(j,  persons.get(i));
								persons.set(i, temp);
							}
						}
					}
					showListPerson(persons);
					break;
				}
				
				case 3: {
					ArrayList<Person> tempPersons = (ArrayList<Person>) Define.persons.clone();
					
					Collections.sort(tempPersons, new Comparator<Person>() {
						
						@Override
						public int compare(Person t1, Person t2) {
							
							String s1 = t1.getName();
							String s2 = t2.getName();
							return s1.compareTo(s2);
						}
					});
					showListPerson(tempPersons);
					break;
				}
				
				
				case 4 : {
					Scanner sc = new Scanner(System.in);
					System.out.println("Enter name ");
					String name = sc.nextLine();
					
					ArrayList<Person> persons = new ArrayList<Person>();
					Person person;
					boolean isFound = false;
					
					for (int index = 0; index < Define.persons.size(); index++) {
						person = Define.persons.get(index);
					
						if(person.getName().toLowerCase().contains(name.toLowerCase())) {
							persons.add(person);
							isFound = true;
							}
						}
					if(isFound == false) {
						System.out.println("Can not Found!");
					}
					else {
						showListPerson(persons);
					}
				}
				
				case 5: {
					Scanner sc = new Scanner(System.in);
					System.out.println("Enter your Year Of Birth");
					int year = sc.nextInt();
					
					ArrayList<Person> persons = new ArrayList<Person>();
					Person person;
					boolean isFound = false;
					
					for (int index = 0; index < Define.persons.size(); index++) {
						person = Define.persons.get(index);
						
						if (person.getType() == Define.TYPE_OF_LECTURER || person.getType() == Define.TYPE_OF_STAFF) {
							if (person.getYearOfBirth() == year) {
								persons.add(person);
								isFound = true;
							}
						}
					}
					
					if (isFound == false) {
						
					} 
					else {
						showListPerson(persons);
					}
				}
					
				case 6: {
					return;
				}
			}
		}
	
	public static void menuFive() {
		System.out.println("Menu 5 : ");
		System.out.println("Delete all data.");
		while (Define.persons.isEmpty() == false) {
			Define.persons.clear();
		}
	}
	
	public static void menuSix() {
		System.out.println("Menu 6 : ");
		System.out.println("Display the list of employees with salary.");
		showListNameAndSalary(Define.persons);
	}
	
	public static void menuSeven() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Menu 7 : ");
		System.out.println("Enter new basic salary (" + Define.newBasiSalary + "): ");
		Define.newBasiSalary = Float.parseFloat(sc.nextLine());
	}
	
	public static void menuEight() {
		System.out.println("Menu 8 : ");
		System.out.println("Enter employee's id: ");
		Scanner sc = new Scanner(System.in);
		
		String text = sc.nextLine();
		String indexs[] = text.split(" ");
		
		Subject subject = new Subject();
		int indexTemp;
		for (int index = 0;  index < indexs.length; index++) {
			indexTemp = Integer.parseInt(indexs[index]);
			
			if ((indexTemp >= 0) && (indexTemp < Define.persons.size())) {
				if ((Define.persons.get(indexTemp).getType() == Define.TYPE_OF_LECTURER) || (Define.persons.get(indexTemp).getType() == Define.TYPE_OF_STAFF )) {
					subject.attach((Observer)Define.persons.get(indexTemp));
					subject.notifyChange(Define.newBasiSalary);
				} 
				else System.out.println("Cannot edit!");
			} 
			else System.out.println("Cannot found!");
		}
	}
		
	
	public static void menuNine() {
		System.out.print("Thank You!");
		System.exit(0);
	}
	
	public static int selectTypeOfEmployee() {
		int value;
		System.out.println("1. Lecturer.  \n" +
						   "2. Staff. \n"  +
						   "3. Casual worker.");
		value = inputSelection(1, 3);
		
		switch (value) {
		case 1: return Define.TYPE_OF_LECTURER;
		case 2: return Define.TYPE_OF_STAFF;
		default: return Define.TYPE_OF_CASUAL;
		}
	}
	
	public static void showListPerson(ArrayList<Person> persons) {
		System.out.format("%-6s %-20s %-20s %-10s %-10s %-15s %-15s %-15s %-15s %-15s %n", "N#", "Name", "YearOfBirth", "HomeTown", "Type", "C1", "C2", "C3", "C4", "C5");
		for (int index = 0; index < persons.size(); index++) {
			System.out.format("%-6d %-20s %-20d "
					, index
					, persons.get(index).getName()
					, persons.get(index).getYearOfBirth());
			
			switch (persons.get(index).getType()) {
			
			case Define.TYPE_OF_LECTURER: {
				System.out.format("%-10s %-10s %-15s %-15s %-15s %-15s %-15s %n"
						, ((Lecturer)persons.get(index)).getHomeTown()
						, "Lecturer"
						, ((Lecturer)persons.get(index)).getDepartment()
						, ((Lecturer)persons.get(index)).getLevel()
						, ((Lecturer)persons.get(index)).getAllowance()
						, ((Lecturer)persons.get(index)).getPeriodsInMonth()
						, ((Lecturer)persons.get(index)).getSalaryRatio());
				
				break;
			}
			
			case Define.TYPE_OF_STAFF: {
				System.out.format("%-10s %-10s %-15s %-15s %-15s %-15s %-15s %n"
						, ((Staff)persons.get(index)).getHomeTown()
						, "Staff"
						, ((Staff)persons.get(index)).getDepartment()
						, ((Staff)persons.get(index)).getPosition()
						, ((Staff)persons.get(index)).getAllowance()
						, ((Staff)persons.get(index)).getWorkDays()
						, ((Staff)persons.get(index)).getSalaryRatio());
				
				break;
			}
			
			case Define.TYPE_OF_CASUAL: {
				System.out.format("%-10s %-10s %-15s %-15s %-15s %-15s %-15s %n"
						 , "null"
						 , "CWorker"
						 , "null"
						 , "null"
						 , "null"
						 , ((Casual)persons.get(index)).getWorkDays()
						 , ((Casual)persons.get(index)).getDayRates());
			}
			}
		}
		
		System.out.println("\n \n \n" +
						   "C1-5 for Lecturer: Department, Level, Allowance, PeriodsInMonth, SalaryRatio.\n" + 
				   		   "C1-5 for Staff: Department, Position, Allowance, WorkDays, SalaryRatio.\n" +
						   "C1-5 for Casual Worker: null, null, null, WorkDays, DayRates.");
	}
	
	public static void showListNameAndSalary(ArrayList<Person> persons) {
		System.out.format("%-6s %-20s %-10s %n", "N#", "Name", "Salary");
		for (int index = 0; index < persons.size(); index++) {
			System.out.format("%-6d %-20s %-10f %n"
						, index
						, persons.get(index).getName()
						, persons.get(index).getSalary());
		}
	}
	
	public static int inputSelection(int min, int max) {
		Scanner sc = new Scanner(System.in);
		int value = min - 1;
		boolean check = false;
		
		System.out.println("Input selection (" + min + " - " + max +")");
		
		while (check == false) {
			System.out.println("Input : ");
			value = Integer.parseInt(sc.nextLine());
			
			if (value < min || value > max)
				System.out.println("Wrong input!");
			else
				check = true;
		}
		return value;
	}

}


