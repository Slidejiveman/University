package unvPD;

import java.util.Collection;
import java.util.TreeMap;

public class Course
{

	private TreeMap<String, Section> sections;
	private String number;
	private String name;
	private int creditHours;
	private Department department;

	public String getNumber()
	{
		return this.number;
	}
	
	public String getFullNumber()
	{
		return getDepartment().getCode() +" "+getNumber();
	}

	public void setNumber(String number)
	{
		this.number = number;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getCreditHours()
	{
		return this.creditHours;
	}

	public void setCreditHours(int creditHours)
	{
		this.creditHours = creditHours;
	}

	public Department getDepartment()
	{
		return this.department;
	}

	public void setDepartment(Department department)
	{
		this.department = department;
	}

	public Course()
	{
		sections = new TreeMap<String, Section>();
	}
	public Course(University university, String deptCode, String number, String description, String hours)
	{
		this();
		setNumber(number);
		setName(description);
		setCreditHours(Integer.parseInt(hours));
		Department department= university.findDepartment(deptCode);
		setDepartment(department);
		department.addCourse(this);
		university.addCourse(this);
	}

	/**
	 * 
	 * @param section
	 */
	public void addSection(Section section)
	{
		sections.put(section.getNumber(),section);
	}

	public String toString()
	{
		return getFullNumber()+" "+getName()+"("+new Integer(getCreditHours()).toString()+" hours)";
	}

}