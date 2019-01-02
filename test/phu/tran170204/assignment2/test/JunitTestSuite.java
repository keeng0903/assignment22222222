package phu.tran170204.assignment2.test;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import phu.tran170204.assignment2.model.test.CasualTest;
import phu.tran170204.assignment2.model.test.LecturerTest;
import phu.tran170204.assignment2.model.test.StaffTest;

	@RunWith(Suite.class)

	@Suite.SuiteClasses({
	   CasualTest.class,
	   LecturerTest.class,
	   StaffTest.class
	})

	public class JunitTestSuite {   
	}  	
