package phu.tran170204.assignment2.controller;

import phu.tran170204.assignment2.define.Define;
import phu.tran170204.assignment2.model.Person;
import phu.tran170204.assignment2.model.Lecturer;
import phu.tran170204.assignment2.model.Staff;
import phu.tran170204.assignment2.model.Casual;


public class PersonFactory {
	public static Person getPerson(int type) {
		Define.LastestID++;
		switch (type) {
		case Define.TYPE_OF_LECTURER: return new Lecturer.LecturerBuilder(Define.LastestID, type).build();
		case Define.TYPE_OF_STAFF : return new Staff.StaffBuilder(Define.LastestID, type).build();
		case Define.TYPE_OF_CASUAL: return new Casual.CasualBuilder(Define.LastestID, type).build();		}
		return null;
	}
}
