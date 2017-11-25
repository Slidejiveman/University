package unvDM;
import unvPD.*;
import java.io.*;

public class UniversityDM 
{
	
	public static void loadUniversity(University university)
	{
		
		String fileName ="University_Data.csv";
		String line = null;
		String[] token;
		String dataRowClass; 
		
	    try {
	        // FileReader reads text files in the default encoding.
	        FileReader fileReader = 
	            new FileReader(fileName);

	        // Always wrap FileReader in BufferedReader.
	        BufferedReader bufferedReader = 
	            new BufferedReader(fileReader);

	        while((line = bufferedReader.readLine()) != null) 
	        {
		        	token = line.split(",");
		        	dataRowClass = token[0];
		        	
		        	if (dataRowClass.equals("University"))
		        	{
		        		university.setName(token[1]);
		        	}
		        	else if (dataRowClass.equals("College"))
		        	{
		        		College college = new College(university, token[1],token[2]);
		        		
		        	}
		        	else if (dataRowClass.equals("Department"))
		        		
		        	{
		        		new Department(university, token[1],token[2],token[3]);
		        		
		        	}
		        	else if (dataRowClass.equals("FacultyMember"))
		        	{
		        		new FacultyMember(university,token[1],token[2],token[3],token[4]);
		        	}
		        	else if (dataRowClass.equals("Course"))
		        		
		        	{
		        		new Course(university,token[1],token[2],token[3],token[4]);
		        	}
		        	else if (dataRowClass.equals("Semester"))
		        	{
		        		new Semester(university,token[1],token[2],token[3]);
		        	}
		        	else if (dataRowClass.equals("Section"))
		        	{
		        		new Section (university, token[1],token[2],token[3],token[4]); 
		        	}
		        	else if (dataRowClass.equals("Student"))
		        	{
		        		new Student (university, token[1],token[2],token[3]); 

		        	}
		        	else if (dataRowClass.equals("Enrollment"))
		        		
		        	{
		        		String grade = null;
		        		if (token.length >6)  grade = token[6];
		        		new Enrollment(university,token[1],token[2],token[3],token[4], token[5], grade);
		        	}
	        }    

	        // Always close files.
	        bufferedReader.close();            
	    }
	    catch(FileNotFoundException ex) 
	    {
	        System.out.println(
	            "Unable to open file '" + 
	            fileName + "'");                
	    }
	    catch(IOException ex) 
	    {
	        System.out.println(
	            "Error reading file '" 
	            + fileName + "'");   	
		
		}
	}


}

