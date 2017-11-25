package unvPD;

import java.util.*;




public class Semester
{

	private String semCode;
	private GregorianCalendar startDate;
	private GregorianCalendar endDate;
	/**
	 * Association Type = unvPD.Section
	 */
	private TreeMap<String, Section> sections;

	public String getSemCode()
	{
		return this.semCode;
	}

	public void setSemCode(String semCode)
	{
		this.semCode = semCode;
	}

	public GregorianCalendar getStartDate()
	{
		return this.startDate;
	}

	public void setStartDate(GregorianCalendar startDate)
	{
		this.startDate = startDate;
	}

	public GregorianCalendar getEndDate()
	{
		return this.endDate;
	}

	public void setEndDate(GregorianCalendar endDate)
	{
		this.endDate = endDate;
	}

	public Semester()
	{
		sections = new TreeMap<String, Section>();
	}
	public Semester(University university, String semCode, String startDate, String endDate)
	{
		this();
		int i = 0;
 
		setSemCode(semCode);
		String sd[] = startDate.split("/");
		setStartDate(new GregorianCalendar(Integer.parseInt(sd[2])+2000,Integer.parseInt(sd[0])-1,Integer.parseInt(sd[1])));
		university.addSemester(this);
	
	}

	/**
	 * 
	 * @param seciton
	 */
	public void addSection(Section section)
	{
		sections.put(section.getFullNumber(),section);
	}
	public Section findSection(String fullNumber)
	{
		return sections.get(fullNumber);
	}
	
	public TreeMap<String, Section> getSections()
	{
		return sections;
	}
	public String toString()
	{
		return getSemCode();
	}

}