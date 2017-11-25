package unvPD;

import java.util.Collection;
import java.util.TreeMap;

public class Department
{

	private String code;
	private String name;
	private College college;
	private TreeMap<String, Course> courses;
	/**
	 * Association Type = unvPD.FacultyMember
	 */
	private TreeMap<String,FacultyMember> faculty;

	public String getCode()
	{
		return this.code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public College getCollege()
	{
		return this.college;
	}

	public void setCollege(College college)
	{
		this.college = college;
	}

	public Department()
	{
		faculty = new TreeMap<String, FacultyMember>();
		courses = new TreeMap<String, Course>();
	}
	
	public Department(University univirsity, String name, String code, String collegeAbv)
	{
		this();
		setName(name);
		setCode(code);
		College college = univirsity.findCollege(collegeAbv);
		setCollege(college);
		college.addDepartment(this);
		
	}

	/**
	 * 
	 * @param faculty
	 */
	public void addFaculty(FacultyMember facultyMember)
	{
		faculty.put(facultyMember.getName(), facultyMember);
	}
	public void removeFaculty(FacultyMember facultyMember)
	{
		faculty.remove(facultyMember.getName());
	}

	/**
	 * 
	 * @param name
	 */
	public FacultyMember findFaculty(String name)
	{
		return faculty.get(name);
	}
	
	public TreeMap<String, FacultyMember> getFaculty()
	{
		return faculty;
	}

	/**
	 * 
	 * @param course
	 */
	public void addCourse(Course course)
	{
		courses.put(course.getNumber(),course);
		
	}

	/**
	 * 
	 * @param number
	 */
	public Course findCourse(String number)
	{
		return courses.get(number);
	}
	public TreeMap<String, Course> getCourses()
	{
		return courses;
	};
	
	public boolean isUsed()
	{
		return getFaculty().size() !=0 || getCourses().size()!=0;
	}
	public String toString()
	{
		return getCode();
	}

}