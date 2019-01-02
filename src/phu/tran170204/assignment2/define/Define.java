package phu.tran170204.assignment2.define;

import java.util.ArrayList;

import phu.tran170204.assignment2.model.Person;

public class Define {
	public static final int TYPE_OF_LECTURER = 1 ;
	public static final int TYPE_OF_STAFF = 2;
	public static final int TYPE_OF_CASUAL = 3;
	
	public static int LastestID = 0;
	
	public static final int TYPE_OF_BACHELOR = 1;
	public static final int ALLOWANCE_OF_BACHELOR = 300;
	public static final int TYPE_OF_MASTER = 2;
	public static final int ALLOWANCE_OF_MASTER = 900;
	public static final int TYPE_OF_DOCTOR = 3;
	public static final int ALLOWANCE_OF_DOCTOR = 2000;
	public static final int TYPE_OF_MANAGER = 4;
	public static final int ALLOWANCE_OF_MANAGER = 1000;
	public static final int TYPE_OF_DEPUTY = 5;
	public static final int ALLOWANCE_OF_DEPUTY = 600;
	public static final int TYPE_OF_EMPLOYEES = 6;
	public static final int ALLOWANCE_OF_EMPLOYEES = 400;
	
	public static final String LEVEL_OF_BACHELOR = "Bachelor" ;
	public static final String LEVEL_OF_MASTER = "Master" ; 
	public static final String LEVEL_OF_DOCTOR = "Doctor" ;
	
	public static final String POSITION_OF_MANAGER = "Manager" ;
	public static final String POSITION_OF_DEPUTY = "Deputy" ;
	public static final String POSITION_OF_EMPLOYEES = "Employees" ;
	

	
	public static final float DEFAULT_BASIC_SALARY = 730;
	public static float newBasiSalary = DEFAULT_BASIC_SALARY;
	
	public static ArrayList <Person> persons = new ArrayList <>();
	
}
