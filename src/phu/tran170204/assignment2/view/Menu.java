package phu.tran170204.assignment2.view;

import phu.tran170204.assignment2.controller.Controller;

public class Menu {
	
	public static void mainMenu(){
		int value;
		while (true) {
		System.out.println("Menu : ");
		System.out.println("1. Add new workers.");
		System.out.println("2. Correction of cadre information.");
		System.out.println("3. Delete the officer.");
		System.out.println("4. Display the list of officers.");
		System.out.println("5. Delete all data.");
		System.out.println("6. Show the payroll costs of all employees in the system.");
		System.out.println("7. Update basic salary.");
		System.out.println("8. Enter the payroll code of the basic salary staff.");
		System.out.println("9. Exit the program.");
		
			value = Controller.inputSelection(1, 9);
			switch(value) {
				case 1: {
					Controller.menuOne();
					break;
				}
				case 2: {
					Controller.menuTwo();
					break;
				}
				case 3: {
					Controller.menuThree();
					break;
				}
				case 4: {
					Controller.menuFour();
					break;
				}
				case 5: {
					Controller.menuFive();
					break;
				}
				case 6: {
					Controller.menuSix();
					break;
				}
				case 7: {
					Controller.menuSeven();
					break;
				}
				case 8: {
					Controller.menuEight();
					break;
				}
				case 9: {
					Controller.menuNine();
					break;
				}
			}
		}
	}
}
