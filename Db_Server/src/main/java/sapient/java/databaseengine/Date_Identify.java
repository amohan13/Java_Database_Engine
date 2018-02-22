package sapient.java.databaseengine;
import java.io.*;
import java.util.ArrayList;
import java.util.regex.*;
public class Date_Identify
{
	public void Date() throws IOException {
	  File file = new File("ipl.csv");
	  BufferedReader br = new BufferedReader(new FileReader(file));
	  String header[]=null;
	  String line,temp = "";
	  
	  ArrayList<Integer> data=new ArrayList();
	  ArrayList<String> data1=new ArrayList();
	  header=br.readLine().split(",");
	  while ((line=br.readLine())!= null)
		  {for (String f : line.split(",")) {
			try {Pattern pattern=Pattern.compile("[0-9]{4}[-][0-9]{2}[-][0-9]{2}");
			Matcher match=pattern.matcher(f);
	        if(match.find())
	        	{data1.add(match.group());
	        
	        	}
			}
		  catch(Exception e){
		  }
	  
			}

		  }
	  System.out.println("date" +data1);
	}
  }
