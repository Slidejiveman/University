package unvPD;


import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;
import unvDM.UniversityDM;

public class University
{

	private String name;
	private String abbreviation;
	private String nickName;
	/**
	 * Association Type = unvPD.Student
	 */
	private TreeMap<String, Student> students;
	/**
	 * Association Type = unvPD.Semester
	 */
	private TreeMap<String, Semester> semesters;
	/**
	 * Association Type = unvPD.College
	 */
	private TreeMap<String, College> colleges;
	/**
	 * Association Type = unvPD.FacultyMember
	 */
	private TreeMap<String, FacultyMember> faculty;
	/**
	 * Association Type = unvPD.Course
	 */
	private TreeMap<String, Course> courses;

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAbbreviation()
	{
		return this.abbreviation;
	}

	public void setAbbreviation(String abbreviation)
	{
		this.abbreviation = abbreviation;
	}

	public String getNickName()
	{
		return this.nickName;
	}

	public void setNickName(String nickName)
	{
		this.nickName = nickName;
	}
	public TreeMap<String, College> getColleges()
	{
		return colleges;
	}
	public University()
	{
		students = new TreeMap<String, Student>();
		faculty = new TreeMap <String, FacultyMember>();
		semesters = new TreeMap <String, Semester>();
		courses = new TreeMap <String, Course>();
		colleges = new TreeMap <String, College>();
	}

	/**
	 * 
	 * @param college
	 */
	public void addCollege(College college)
	{
		colleges.put(college.getAbrev(),college);
	}
	
	public void removeCollege(College college)
	{
		colleges.remove(college.getAbrev());
	}

	/**
	 * 
	 * @param name
	 */
	public College findCollege(String name)
	{
		return colleges.get(name);
	}

	/**
	 * 
	 * @param student
	 */
	public void addStudent(Student student)
	{
		students.put(student.getId(), student);
	}

	/**
	 * 
	 * @param id
	 */
	public Student findStudent(String id)
	{
		return students.get(id);
	}
	
	public TreeMap<String, Student> getStudents()
	{
		return students;
	}

	/**
	 * 
	 * @param semester
	 */
	public void addSemester(Semester semester)
	{
		semesters.put(semester.getSemCode(), semester);
	}
	
	public TreeMap<String, Semester> getSemesters()
	{
		return semesters;
	}
	/**
	 * 
	 * @param course
	 */
	public void addCourse(Course course)
	{
		courses.put(course.getFullNumber(), course);
	}

	/**
	 * 
	 * @param dept
	 * @param number
	 */
	public Course findCourse(String fullNumber)
	{
		return courses.get(fullNumber);
	}

	/**
	 * 
	 * @param faculty
	 */
	public void addFaculty(FacultyMember facultyMember)
	{
		faculty.put(facultyMember.getName(),facultyMember);
	}
	
	public TreeMap<String, FacultyMember> getFaculty()
	{
		return faculty;
	}

	/**
	 * 
	 * @param name
	 */
	public FacultyMember findFaculty(String name)
	{
		// TODO - implement University.findFaculty
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param code
	 */
	public Department findDepartment(String code)
	{
		for (Entry<String, College> collegeEntry : colleges.entrySet())
		{
			College college = collegeEntry.getValue();
			Department department = college.findDepartment(code);
			if (department != null) return department;
		}
		return null;
	}

	public String toString()
	{
		return getName();
	}

	/**
	 * 
	 * @param semCode
	 */
	public Semester findSemester(String semCode)
	{
		return semesters.get(semCode);
	}
	
	public void loadUniversity()
	{
		UniversityDM.loadUniversity(this);
	}
	
	public String[] getCollegeList() 
	{
		String[] collegeList = new String[getColleges().entrySet().size()];
		String collegeString;
		int i =0;
		for (Entry<String, College> collegeEntry : getColleges().entrySet())
		{
			collegeString = collegeEntry.getValue().getAbrev()+" "+collegeEntry.getValue().getName();
			collegeList[i] = collegeString;
			i++;
		}
		return collegeList;
			
	}
	public College getCollegeForIndex( int index)
	{
		int i=0;
		for (Entry<String, College> collegeEntry : getColleges().entrySet())
		{
			 
			if (i == index) return (collegeEntry.getValue());
			i++;
		}	
		return(null);
	}
	
	public String[] getFacultyList() 
	{
		String[] facultyList = new String[getFaculty().entrySet().size()];
		String facultyString;
		int i =0;
		for (Entry<String, FacultyMember> facultyEntry : getFaculty().entrySet())
		{
			facultyString = facultyEntry.getValue().getName();
			facultyList[i] = facultyString;
			i++;
		}
		return facultyList;
			
	}
	public FacultyMember getFacultyForIndex( int index)
	{
		int i=0;
		for (Entry<String, FacultyMember> facultyEntry : getFaculty().entrySet())
		{
			if (i == index) return (facultyEntry.getValue());
			i++;
		}	
		return(null);
	}
	public ArrayList<Department> getDepartments()
	{
		ArrayList<Department> deptList = new ArrayList<Department>();
		for (Entry<String, College> collegeEntry : getColleges().entrySet())
		{
			for (Entry<String, Department> deptEntry : 
					collegeEntry.getValue().getDepartments().entrySet())
			{
				deptList.add(deptEntry.getValue());
			}
		}
		return deptList;
	}

	public String[] getDeptList() 
	{
		String[] deptList = new String[getDepartments().size()];
		String deptString;
		int i =0;
		for (Department dept : getDepartments())
		{
			deptString = dept.getCode();
			deptList[i] = deptString;
			i++;
		}
		return deptList;
			
	}
	public Department getDepartemntForIndex( int index)
	{
		int i=0;
		for (Department dept : getDepartments())
		{
			 
			if (i == index) return (dept);
			i++;
		}	
		return(null);
	}
	
	public int findDepartmentIndex(Department department)
	{
		int i=0;
	for (Department dept : getDepartments())
	{
		 
		if (dept == department) return (i);
		i++;
	}	
	return(0);
	}

}