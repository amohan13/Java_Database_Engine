package sapient.java.databaseengine;
import java.util.*;
public class Parse_query{
	public void getData(String head, ArrayList<String>[] list,String field[]) {		
		 //StringTokenizer st= new StringTokenizer(str1);
		 //StringTokenizer st1= new StringTokenizer(head);
		 String heads[]=head.split(",");
		  for(int j=1;j<field.length;j++)
		   {  
			   if(field[j].equals("*"))
			   {
				   //printing column wise data 	
					for(ArrayList ele : list){
				        System.out.println(ele+"  ");
				    }
			   }
			   for(int i=0;i<heads.length;i++)
			   {
				   if(heads[i].equals(field[j]))
				   {
					   System.out.println(list[i]);
				   }
			   }
			   
			   
			   }
		   }	   
		  
	}
	
