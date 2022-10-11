package Project4;

import java.util.ArrayList;

public class School {

	/*
	 * School object that holds the students, testAverage, the school name and location. 
	 * Has several methods to set and get the different variables.
	 * Has a sort and search of the student ArrayList at the bottom. 
	 */
	
	protected String schoolName;
	protected String location;
	private int testAverage;
	public ArrayList<Student> students;
	
	
	public School () {
		testAverage = 0;
		schoolName = "";
		location = "";
	}
	
	public School (String SchoolName, String location, ArrayList<Student> students) {  //Puts the students into a collection of an ArrayList and computes the testAverage.
		this.schoolName = SchoolName;
		this.students = students;
		this.location = location; 
		int total = 0;
		for (int i = 0; i < students.size(); ++i) {
			total += students.get(i).getTestScore();
		}
		testAverage = total / students.size();
	}
	
	public void setName (String name) {
		schoolName = name;
	}
	
	public void setStudents (ArrayList<Student> students) {
		this.students = students;
		int total = 0;
		for (int i = 0; i < students.size(); ++i) {
			total += students.get(i).getTestScore();
		}
		testAverage = total / students.size();
	}
	
	public void addStudents (String name) {                                            // Adds a student into the array list based off a given name.
		students.add(new Student(name, this.location, this.schoolName));
	}
	
	public void setLocation (String location) {
		this.location = location;
	}
	
	public String getName () {
		return schoolName;
	}
	
	public Student getStudent (int rank) {
		return students.get(rank);
	}
	
	public String getLocation () {
		return location;
	}
	
	public int getAverage () {
		return testAverage;
	}
	
	public void studentSort () {                                                        //Selection Sort.
		
		for (int i = 0; i < students.size(); ++i) {
			Student frontStudent = students.get(i);
			int temp = students.get(i).getTestScore();
			Student tempStudent = students.get(i);
			int tempInd = i;
			for (int j = 0 + i; j < students.size(); ++j) {
				if (students.get(j).getTestScore() > temp) {
					temp = students.get(j).getTestScore();
					tempStudent = students.get(j);
					tempInd = j;
				}
			}
				students.set(i, tempStudent);
				students.set(tempInd, frontStudent);
				
			}
		
	}
	
	public String studentSearch (int num) {                                           //binary search for a student with a particular score.
		int low = 0;
		int high = students.size() - 1;
		int count = 0;
		
		while (low <= high) {
			int middle = low + (high - low) / 2;
			if (num < (students.get(middle)).getTestScore()) {
				low = middle + 1;
				++count;
			}
			else if (num > (students.get(middle)).getTestScore()) {
				high = middle - 1;
				++count;
			}
			else {
				String binary = "The student who got a " + num + " was " + students.get(middle).getName() + " which was found after checking " + count + " other students.";
				return binary;
			}
		}
		return "No student had that score";
	}
	
	public String toString () {
		return schoolName + " in " + location + " has a test average of " + testAverage;
	}
	
}
