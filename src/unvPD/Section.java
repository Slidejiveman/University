package unvPD;



import java.math.BigDecimal;
import java.util.TreeMap;


public class Section
{

	private String number;
	private String daysOfWeek;
	private String startTime;
	private String endTime;
	private String room;
	private int cap;
	private Semester semester;
	private FacultyMember instructor;
	private Course course;
	/**
	 * Association Type = unvPD.Enrollment
	 */
	private TreeMap< String, Enrollment> enrollments;

	public String getNumber()
	{
		return this.number;
	}

	public void setNumber(String number)
	{
		this.number = number;
	}
	public Course getCourse()
	{
		return this.course;
	}

	public void setCourse(Course course)
	{
		this.course = course;
	}
	public String getDaysOfWeek()
	{
		return this.daysOfWeek;
	}

	public void setDaysOfWeek(String daysOfWeek)
	{
		this.daysOfWeek = daysOfWeek;
	}

	public String getStartTime()
	{
		return this.startTime;
	}

	public void setStartTime(String startTime)
	{
		this.startTime = startTime;
	}

	public String getEndTime()
	{
		return this.endTime;
	}

	public void setEndTime(String endTime)
	{
		this.endTime = endTime;
	}

	public String getRoom()
	{
		return this.room;
	}

	public void setRoom(String room)
	{
		this.room = room;
	}

	public int getCap()
	{
		return this.cap;
	}

	public void setCap(int cap)
	{
		this.cap = cap;
	}

	public Semester getSemester()
	{
		return this.semester;
	}

	public void setSemester(Semester semester)
	{
		this.semester = semester;
	}

	public FacultyMember getInstructor()
	{
		return this.instructor;
	}

	public void setInstructor(FacultyMember instructor)
	{
		this.instructor = instructor;
	}
	
	public String getFullNumber()
	
	{
		return getCourse().getFullNumber()+"-"+getNumber();
	
	}

	public Section()
	{
		enrollments = new TreeMap<String, Enrollment>();
	}
	public Section(University university, String semCode, String deptCode, String courseNumber,String sectionNumber )
	{
		this();
		setNumber(sectionNumber);
		Department department = university.findDepartment(deptCode);
		Course course = department.findCourse(courseNumber);
		setCourse(course);
		course.addSection(this);
		Semester semester = university.findSemester(semCode);
		setSemester(semester);
		semester.addSection(this);
		
	}

	/**
	 * 
	 * @param student
	 */
	public void addStudent(Student student)
	{
		Enrollment enrollment = new Enrollment();
		enrollment.setStudent(student);
		enrollment.setSection(this);
		addEnrollment(enrollment);
	}

	/**
	 * 
	 * @param enrollment
	 */
	public void addEnrollment(Enrollment enrollment)
	{
		enrollments.put(enrollment.getStudent().getId(),enrollment);
	}
	public Enrollment findEnrollment(String studentID)
	{
		return enrollments.get(studentID);
	}
	public BigDecimal calcGPA()
	{
		// TODO - implement Section.calcGPA
		throw new UnsupportedOperationException();
	}

	public String toString()
	{
		return getCourse().getFullNumber() +"-"+getNumber();
	}

}