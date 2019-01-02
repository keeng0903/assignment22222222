package phu.tran170204.assignment2.model.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import phu.tran170204.assignment2.define.Define;
import phu.tran170204.assignment2.model.Staff;

public class StaffTest {
	
		private final double delta = 0.00001;
		
		
		Staff s;
		
		@Before
		public void setUp() {
			s = new Staff.StaffBuilder(Define.LastestID, Define.TYPE_OF_STAFF)
					.setName("Phu")
					.setYearOfBirth(1999)
					.setHomeTown("Da Nang")
					.setDepartment("C")
					.setSalaryRatio((float)52.0)
					.setAllowance(Define.ALLOWANCE_OF_MANAGER)
					.setPosition(Define.POSITION_OF_MANAGER)
					.setWorkDays(10)
					.setWorkYear(10)
					.setBasicSalary((float)Define.DEFAULT_BASIC_SALARY)
					.build();
		}
		
		@Test
		public void test_toString_Chief() {
		        assertEquals("Staff [homeTown=Da Nang, department=C, salaryRatio=52.0, allowance=1000, position=Chief, workDays=10, workYears=10, basicSalary=730.0, Name=Phu, yearOfBirth=1999, id=0, type=1]",s.toString());
		}
		 
		@Test
		public void testBuilderSetAllowanceWithDeputy() {
			s = new  Staff.StaffBuilder(Define.LastestID, Define.TYPE_OF_STAFF)
				.setPosition(Define.POSITION_OF_DEPUTY)
				.setAllowance(Define.ALLOWANCE_OF_DEPUTY)
				.build();
		}
		
		@Test
		public void testBuilderSetAllowanceWithEmployee() {
			s = new  Staff.StaffBuilder(Define.LastestID, Define.TYPE_OF_STAFF)
				.setPosition(Define.POSITION_OF_EMPLOYEES)
				.setAllowance(Define.ALLOWANCE_OF_EMPLOYEES)
				.build();
		}
		
		@Test
		public void test_Staff() {
			Staff s = new Staff();
			assertNotNull(s);
		}
		
		@Test
		public void test_getID() {
			assertEquals(0 , s.getId());
		}
		
		@Test
		public void test_set_getHomeTown() {
			s.setHomeTown("Da Nang");
			assertEquals(s.getHomeTown(),"Da Nang");
		}
		
		@Test
		public void test_set_getDepartment() {
			s.setDepartment("C");
			assertEquals(s.getDepartment(), "C");
		}
		
		@Test
		public void test_set_getSalaryRatio() {
			s.setSalaryRatio(52);
			assertEquals(s.getSalaryRatio(), 52,delta);
		}
		
		@Test
		public void test_set_getAllowanceOfChief() {
			s.setAllowance(Define.ALLOWANCE_OF_MANAGER);
			assertEquals(s.getAllowance(), 1000,delta);
		}
		
		@Test
		public void test_set_getAllowanceOfDeputy() {
			s.setAllowance(Define.ALLOWANCE_OF_DEPUTY);
			assertEquals(s.getAllowance(), 600,delta);
		}
		
		@Test
		public void test_set_getAllowanceOfEmployee() {
			s.setAllowance(Define.ALLOWANCE_OF_EMPLOYEES);
			assertEquals(s.getAllowance(), 400,delta);
		}
		
		@Test
		public void test_set_getPositionOfChief() {
			s.setPosition(Define.POSITION_OF_MANAGER);
			assertEquals(s.getPosition(), "Chief");
		}
		
		@Test
		public void test_set_getPositionOfDeputy() {
			s.setPosition(Define.POSITION_OF_DEPUTY);
			assertEquals(s.getPosition(), "Deputy");
		}
		
		@Test
		public void test_set_getPositionOfEmployee() {
			s.setPosition(Define.POSITION_OF_EMPLOYEES);
			assertEquals(s.getPosition(), "Employee");
		}
		
		@Test
		public void test_set_getWorkDays() {
			s.setWorkDays(10);
			assertEquals(s.getWorkDays(),10);
		}
		
		@Test
		public void test_set_getWorkYears() {
			s.setWorkYear(10);
			assertEquals(s.getWorkYear(),10);
		}
		
		@Test
		public void test_set_getBasicSalary() {
			s.setBasicSalary(Define.DEFAULT_BASIC_SALARY);
			assertEquals(s.getBasicSalary(),730,delta);
		}
			
		@Test
		public void test_update() {
			s.update(400);
			assertEquals(400 , s.getBasicSalary() , delta);
		}
		
		@Test
		public void test_getSalary() {
			s.setSalaryRatio(3575);
			assertEquals(2611050.0,s.getSalary() , delta);
		}
}
		
