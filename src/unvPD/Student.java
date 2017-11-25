package unvPD;

import java.util.ArrayList;

import java.util.Collection;
import java.math.*;

public class Student
{

	private String id;
	private String name;
	private String email;
	/**
	 * Association Type = unvPD.Enrollment
	 */
	private ArrayList<Enrollment> enrollments;

	public String getId()
	{
		return this.id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getEmail()
	{
		return this.email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public Student()
	{
		enrollments = new ArrayList<Enrollment>();
	}
	
	public Student(University university, String name, String id, String email)
	{
		this();
		setName(name);
		setId(id);
		setEmail(email);
		university.addStudent(this);
	}
	

	/**
	 * 
	 * @param enrollment
	 */
	public void addEnrollment(Enrollment enrollment)
	{
		enrollments.add(enrollment);
	}
	
	public ArrayList<Enrollment> getEnrollments()
	{
		return enrollments;
	}

	public BigDecimal calcGPA()
	{
		BigDecimal gradePoints=new BigDecimal("0");
		BigDecimal hours = new BigDecimal("0");
		
		for (Enrollment e : enrollments)
		{
			gradePoints = gradePoints.add(e.getCompletedGradePoints());
			hours = hours.add(e.getCompletedHours());
		}
		return gradePoints.divide(hours).setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	public int calcCreditHours()
	{
		// TODO - implement Student.calcCreditHours
		throw new UnsupportedOperationException();
	}

	public String toString()
	{
		return getId()+" "+getName()+ " "+getEmail();
	}

}