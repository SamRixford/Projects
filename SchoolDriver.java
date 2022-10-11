package Project4;

import java.util.Scanner;
import java.util.ArrayList;

public class SchoolDriver {

	/*
	 * This program seeks to rank schools based on a test average in order to determine which school has more success with their students.
	 * The concepts that I chose were inheritance, collections, and sort & search. 
	 * The inheritance is found within my student class as it inherits the school name and location that are associated with the school they belong to.
	 * The collections I used are ArrayLists which are found in this driver and school file as I have an array list of the schools as well as of each schools students as I can add different types of students and schools to the array list easier.
	 * The sort and search are found in this file as there is a sort for the schools below and also there is a sort and search for the students in the school class.
	 * Other comments are throughout my other files.
	 */
	
	public static void main(String[] args){
		
		Scanner scnr = new Scanner (System.in);
		System.out.println("How many schools would you like to add?");
		int numOfSchools = scnr.nextInt();
		ArrayList<School> schools = new ArrayList<School>();
		
		for (int i = 0; i < numOfSchools; ++i) {
			System.out.println("What is the name of school number " + (i + 1) + "?");          // Getting the data of the school.
			String schoolName = scnr.nextLine();
			schoolName = scnr.nextLine();
			System.out.println("What is this school's state?");
			String location = scnr.nextLine();
			System.out.println("How many random students would you like to add?");
			int randStudents = scnr.nextInt();
			ArrayList<Student> students = new ArrayList<Student>();
			
			for (int j = 0; j < randStudents; ++j) {                                            // Assigns however many students the names Sam 1 through Sam randStudents and creates a random score.
				String name = "Sam " + (j + 1);
				students.add(new Student (name, location, schoolName));
			}
			
			System.out.println("How many select students would you like to add?");
			int selectStudents = scnr.nextInt();
			
			for (int j = 0; j < selectStudents; ++j) {
				System.out.println("What is the name of student number " + (j + 1) + "?");      // Creates a student that has a given name and score.
				String name = scnr.nextLine();	
				name = scnr.nextLine();
				Student tempStudent = new Student(name, location, schoolName);
				System.out.println("What test score did they get?");
				tempStudent.setTestScore(scnr.nextInt());
				students.add(tempStudent);
			}
			
			School school = new School (schoolName, location, students);                        //Sorts and adds the schools to the schools Array List.
			school.studentSort();
			schools.add(school);
		}
		
		schoolSort(schools);
		
		System.out.println("Here is the rankings of all the schools: ");                        //Prints out the top schools and then students of the top school, allowing a search of those students.
		
		for (int i = 0; i < numOfSchools; ++i) {
			System.out.println("\n" + (i + 1) + ". " + schools.get(i));
		}
		
		System.out.println("\n" + "Here are the students of the top school: " + "\n");
		
		for (int i = 0; i < schools.get(0).students.size(); ++i) {
			System.out.println((i + 1) + ". " + schools.get(0).getStudent(i));
		}
		
		System.out.println("Which score would you like to search for among the top school?");
		System.out.println(schools.get(0).studentSearch(scnr.nextInt()));
		
		scnr.close();
	}
	
	public static ArrayList<School> schoolSort (ArrayList<School> schools) {                   // insertion sort for the schools ArrayList.
		int temp = 0;
		School tempSchool = new School();
		
		for (int i = 1; i < schools.size(); ++i) {
			temp = schools.get(i).getAverage();
			tempSchool = schools.get(i);
			
			for (int j = i - 1; (j >= 0) && (schools.get(j).getAverage() < temp); --j) {
				schools.set(j + 1, schools.get(j));
				schools.set(j, tempSchool);
			}
		}
		return schools;
	}
	
	
}
