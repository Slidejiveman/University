package unvPD;

import java.math.BigDecimal;

public class Enrollment
{

	private String grade;
	private Student student;
	private Section section;

	public String getGrade()
	{
		return this.grade;
	}

	public void setGrade(String grade)
	{
		this.grade = grade;
	}

	public Student getStudent()
	{
		return this.student;
	}

	public void setStudent(Student student)
	{
		this.student = student;
	}

	public Section getSection()
	{
		return this.section;
	}

	public void setSection(Section section)
	{
		this.section = section;
	}

	public Enrollment()
	{
	
	}
	public Enrollment(University university, String studentId, String semester, String deptCode, String courseNumber, String sectionNumber, String grade )
	{
		this();
		setGrade(grade);
		setStudent(university.findStudent(studentId));;
		Section section = university.findSemester(semester).findSection(deptCode+" "+courseNumber+"-"+sectionNumber);
		getStudent().addEnrollment(this);
		section.addEnrollment(this);
		setSection(section);
	}
	
	public BigDecimal getCompletedHours()
	{
		if (getGrade() == null) return(new BigDecimal("0"));
		return new BigDecimal(getSection().getCourse().getCreditHours());
	}
	
	public BigDecimal getCompletedGradePoints()
	{
		if (getGrade() == null)
			return new BigDecimal("0");
		BigDecimal hours = getCompletedHours();
		switch (getGrade())
		{
		
		case "A":
			return new BigDecimal("4").multiply(hours);
		case "B":
			return new BigDecimal("3").multiply(hours);
		case "C":
			return new BigDecimal("2").multiply(hours);
		case "D":
			return new BigDecimal("1").multiply(hours);
		case "F":
			return new BigDecimal("0");
		}
		return new BigDecimal("0");
	}
	public String toString()
	{
		return getStudent().getName()+" "+getSection().getFullNumber() +" "+getGrade();
	}

}