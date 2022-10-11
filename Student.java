package Project4;

import java.util.Random;

public class Student extends School {

	/* 
	* Each student has a name and a test score. Name of school and school information is inherited from the School object.
	* Uses the Random class in order to obtain a random test score from 0 to 100.
	*/
	
	int testScore;
	String name;
	
	
	public Student () {
		location = "";
		schoolName = "";
		Random r = new Random();
		testScore = r.nextInt(101);
		name = "";
	}
	
	public Student (String name, String location, String schoolName) {
		this.location = location;
		this.schoolName = schoolName;
		this.name = name;
		Random r = new Random();
		testScore = r.nextInt(101);
	}
	
	public int getTestScore () {
		return testScore;
	}
	
	public String getName () {
		return name;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	public void setTestScore (int score) {
		testScore = score;
	}
	
	public String toString () {
		return name + " got a " + testScore;
	}
	
}
