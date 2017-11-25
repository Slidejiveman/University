package unvPD;

import java.util.Collection;
import java.util.TreeMap;
import java.util.Map.Entry;

public class College
{

	private String name;
	private String abrev;
	private University university;
	/**
	 * Association Type = unvPD.Department
	 */
	private TreeMap<String, Department> departments;

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	public String getAbrev()
	{
		return this.abrev;
	}

	public void setAbrev(String abrev)
	{
		this.abrev = abrev;
	}

	public University getUniversity()
	{
		return this.university;
	}

	public void setUniversity(University university)
	{
		this.university = university;
	}
	
	public College()
	{
		departments = new TreeMap<String, Department>();
	}
	
	public College(University university, String name, String abrev)
	{
		this();
		setName(name);
		setAbrev(abrev);
		university.addCollege(this);
	}

	/**
	 * 
	 * @param department
	 */
	public void addDepartment(Department department)
	{
		departments.put(department.getCode(), department);
	}
	public void removeDepartment(Department department)
	{
		departments.remove(department.getCode());
	}
	public TreeMap<String, Department> getDepartments()
	{
		return departments;
	}
	/**
	 * 
	 * @param code
	 */
	public Department findDepartment(String code)
	{
		return departments.get(code);
	}
	public boolean isUsed()
	{
		return (getDepartments().size() != 0);
	}

	public String toString()
	{
		return getName();
	}

}