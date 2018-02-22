package sapient.java.databaseengine;
import java.io.*;
import java.util.ArrayList;
public class Header_datatypes
{
	public void method() throws IOException {
	  File file = new File("ipl.csv");
	  BufferedReader br = new BufferedReader(new FileReader(file));
	  String header[]=null;
	  String line,temp = "";
	  
	  ArrayList<Integer> data=new ArrayList();
	  ArrayList<String> data1=new ArrayList();
	  header=br.readLine().split(",");
	  while ((line=br.readLine())!= null)
		  {for (String f : line.split(",")) {
			try {  temp=f;
			data.add(Integer.parseInt(f));
		  }
		  catch(Exception e){
			  data1.add(temp);
		  }
	  
	  }

	}
	  System.out.println("integer"+ data);
	  System.out.println("string" + data1);
	
	  
	}}