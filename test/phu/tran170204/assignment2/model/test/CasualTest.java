package phu.tran170204.assignment2.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import phu.tran170204.assignment2.define.Define;
import phu.tran170204.assignment2.model.Casual;

public class CasualTest {
	private final double delta = 0.00001;
	
	Casual c;
	
	@Before
	public void setUp() {
		c = new Casual.CasualBuilder(Define.LastestID, Define.TYPE_OF_CASUAL)
				.setName("Phu")
				.setYearOfBirth(1999)
				.setWorkDays(10)
				.setDayRates((float)1000.0)
				.build();
	}
	
	@Test
    public void test_toString() {
        assertEquals("CasualWorker [workDays=10, earningPerDay=1000.0, Name=Phun, yearOfBirth=1999, id=0, type=3]",c.toString());
}
	
	@Test
	public void test_set_getWorkDays() {
		c.setWorkDays(10);
		assertEquals(c.getWorkDays(),10);
	}
	
	@Test
	public void test_set_getEarningPerDay() {
		c.setDayRates(1000);
		assertEquals(c.getDayRates(), 1000,delta);
	}
		
	
	
}