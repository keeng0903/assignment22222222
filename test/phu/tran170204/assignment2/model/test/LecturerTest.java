package phu.tran170204.assignment2.model.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import phu.tran170204.assignment2.define.Define;
import phu.tran170204.assignment2.model.Lecturer;

public class LecturerTest {
	private final double delta = 0.00001;
	
	Lecturer l;
	
	@Before
	public void setUp() {
		l = new Lecturer.LecturerBuilder(Define.LastestID, Define.TYPE_OF_LECTURER)
				.setName("Phu")
				.setYearOfBirth(1999)
				.setHomeTown("Da Nang")
				.setDepartment("C")
				.setSalaryRatio((float)52)
				.setLevel(Define.LEVEL_OF_MASTER)
				.setAllowance(Define.ALLOWANCE_OF_MASTER)
				.setPeriodsInMonth(10)
				.setWorkYear(10)
				.setBasicSalary((float)Define.DEFAULT_BASIC_SALARY)
				.build();
	}
	
	@Test
	public void test_set_getHomeTown() {
		l.setHomeTown("Da Nang");
		assertEquals(l.getHomeTown(),"Da Nang");
	}
	
	@Test
	public void test_set_getDepartment() {
		l.setDepartment("C");
		assertEquals(l.getDepartment(), "C");
	}
	
	@Test
	public void test_set_getSalaryRatio() {
		l.setSalaryRatio(52);
		assertEquals(l.getSalaryRatio(), 52,delta);
	}
	
	@Test
	public void test_set_getCertificateOfMaster() {
		l.setLevel(Define.LEVEL_OF_MASTER);
		assertEquals(l.getLevel(), "Master");
	}
	
	@Test
	public void test_set_getCertificateOfDoctor() {
		l.setLevel(Define.LEVEL_OF_DOCTOR);
		assertEquals(l.getLevel(), "Doctor");
	}
	
	@Test
	public void test_set_getCertificateOfBachelor() {
		l.setLevel(Define.LEVEL_OF_BACHELOR);
		assertEquals(l.getLevel(), "Bachelor");
	}
	
	@Test
	public void test_set_getAllowanceOfMaster() {
		l.setAllowance(Define.ALLOWANCE_OF_MASTER);
		assertEquals(l.getAllowance(), 900,delta);
	}
	
	@Test
	public void test_set_getAllowanceOfDoctor() {
		l.setAllowance(Define.ALLOWANCE_OF_DOCTOR);
		assertEquals(l.getAllowance(), 2000,delta);
	}
	
	@Test
	public void test_set_getAllowanceOfBachelor() {
		l.setAllowance(Define.ALLOWANCE_OF_BACHELOR);
		assertEquals(l.getAllowance(), 300,delta);
	}
	
	@Test
	public void test_set_getPeriodsInMonth() {
		l.setPeriodsInMonth(10);
		assertEquals(l.getPeriodsInMonth(), 10);
	}
	
	@Test
	public void test_set_getWorkYears() {
		l.setWorkYear(10);
		assertEquals(l.getWorkYear(),10);
	}
	
	@Test
	public void test_set_getBasicSalary() {
		l.setBasicSalary(Define.DEFAULT_BASIC_SALARY);
		assertEquals(l.getBasicSalary(),Define.DEFAULT_BASIC_SALARY,delta);
	}
	
	@Test
    public void test_toString_Master() {
	        assertEquals("Lecturer [homeTown=Da Nang, department=C, certificate=Master, allowance=900, periodsInMonth=10, salaryRatio=52.0, workYears=10, basicSalary=730.0, fullName=Phu, yearOfBirth=1999, id=0, type=2]",l.toString());
	}
	
	@Test
	public void testBuilderSetAllowanceWithDoctor() {
			l = new  Lecturer.LecturerBuilder(Define.LastestID, Define.TYPE_OF_LECTURER)
				.setLevel(Define.LEVEL_OF_DOCTOR)
				.setAllowance(Define.ALLOWANCE_OF_DOCTOR)
				.build();
	}
	
	@Test
	public void testBuilderSetAllowanceWithBachelor() {
			l = new  Lecturer.LecturerBuilder(Define.LastestID, Define.TYPE_OF_LECTURER)
				.setLevel(Define.LEVEL_OF_BACHELOR)
				.setAllowance(Define.ALLOWANCE_OF_BACHELOR)
				.build();
	}	
	
	@Test
	public void test_update() {
		l.update(400);
		assertEquals(400 , l.getBasicSalary() , delta);
	}
	
	
	@Test
	public void test_getSalary() {
		l.setSalaryRatio(3575);
		assertEquals(2611100.0,l.getSalary() , delta);
	}
	
}
