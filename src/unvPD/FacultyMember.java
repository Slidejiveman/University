package unvPD;

import java.util.TreeMap;

public class FacultyMember
{

	private String name;
	private String office;
	private String email;
	private Department department;
	/**
	 * Association Type = unvPD.Section
	 */
	private TreeMap<String, Section> sections;

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getOffice()
	{
		return this.office;
	}

	public void setOffice(String office)
	{
		this.office = office;
	}

	public String getEmail()
	{
		return this.email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public Department getDepartment()
	{
		return this.department;
	}

	public void setDepartment(Department department)
	{
		this.department = department;
	}

	public FacultyMember()
	{
		sections = new TreeMap<String, Section>();
	}
	public FacultyMember(University university,String name, String deptCode, String office, String email)
	{
		super();
		setName(name);
		setOffice(office);
		setEmail(email);
		
		Department department = university.findDepartment(deptCode);
		setDepartment(department);
	
		department.addFaculty(this);
		university.addFaculty(this);
	}
	/**
	 * 
	 * @param section
	 */
	public void addSection(Section section)
	{
		sections.put(section.getNumber(), section);
	}

	/**
	 * 
	 * @param semCode
	 */
	public int calcLoad(String semCode)
	{
		// TODO - implement FacultyMember.calcLoad
		throw new UnsupportedOperationException();
	}

	public String toString()
	{
		return getName()+" "+getOffice()+" "+getEmail();
	}

}