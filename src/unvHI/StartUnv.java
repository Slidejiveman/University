package unvHI;

import java.util.Map.Entry;

import unvPD.*;

public class StartUnv {
	
	private static University myUniv;

	public static void main(String[] args) {

					myUniv = new University();
					System.out.println("Ready to start up Universty");
					myUniv.loadUniversity();
					printUnviversity();
					UnivFrame.run(myUniv);					
	
					
			}

			public static void printUnviversity()
			{
				System.out.println("University : "+ myUniv.toString());
				
				for (Entry<String, College> collegeEntry : myUniv.getColleges().entrySet())
				{
					College college = collegeEntry.getValue();
					System.out.println("College : "+college.toString());
					for (Entry<String, Department> departmentEntry : college.getDepartments().entrySet())
					{
						Department department = departmentEntry.getValue();
						System.out.println("  Department : "+department.toString());
						for (Entry<String, FacultyMember> facultyMemberEntry: department.getFaculty().entrySet() )
						{
							FacultyMember facultyMember = facultyMemberEntry.getValue();
							System.out.println("    Faculty : "+ facultyMember.toString());
						}
						 
						for (Entry<String, Course> courseEntry: department.getCourses().entrySet() )
						{
							Course course = courseEntry.getValue();
							System.out.println("    Course : "+ course.toString());
						}
					}
				}
				
				for (Entry<String, Semester> semesterEntry : myUniv.getSemesters().entrySet())
				{
					Semester semester = semesterEntry.getValue();
					System.out.println("Semester : "+semester.getSemCode());
					for (Entry<String,Section> sectionEntry : semester.getSections().entrySet())
					{
						System.out.println( "  Section : "+sectionEntry.getValue().toString());
					}
				}
				for (Entry<String, Student> studentEntry : myUniv.getStudents().entrySet())
				{
					Student student = studentEntry.getValue();
					System.out.println( "Student : "+student.toString());
					for (Enrollment e : student.getEnrollments())
					{
						System.out.println("  Enrolled Section : "+e.toString());
					}
				}
				for (Entry<String, Student> studentEntry : myUniv.getStudents().entrySet())
				{
					Student student = studentEntry.getValue();
					System.out.println( "Student : "+student.toString() +" "+student.calcGPA());
					for (Enrollment e : student.getEnrollments())
					{
						System.out.println("  Enrolled Section : "+e.toString());
					}
				}
			}
		}
