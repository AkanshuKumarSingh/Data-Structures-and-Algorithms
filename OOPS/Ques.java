package OOPS;

import java.util.ArrayList;

public class Ques {
	
	static int key = 1234;
	static ArrayList<Student> list = new ArrayList<>();
	
	public static class Student{
		String name;
		int dob;
		Student(String name, int dob){
			this.name = name;
			this.dob = dob;
		}
	}
	
	public static void takeAdmission(Student s,int passKey) {
		if(passKey == key) {
			int year = s.dob%10000;
			int mon = (s.dob/10000)%100;
			int day = (s.dob/1000000)%100;
			if(year <= 2005 && mon <= 5 && day <= 14) {
				System.out.println("Admission Granted");
			}else {
				System.out.println("Your age is less");
			}
		}else {
			System.out.println("Admission Not Granted Invalid Password");
		}
	}
	
	
	
	public static void main(String[] args) {
		Student s = new Student("Mohit",14052005);
		takeAdmission(s,1234);
	}

}
