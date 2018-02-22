package sapient.java.databaseengine;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Query {
	String tokenize="select id date from min(anand) max(pal)  ipl.csv where season > 2014 and city = 'Bangalore'  order by anand group by paul";
	String basepart;
    String lastpart;
    String s="where";
    int len=s.length()+1;
    int a=-1;
    ArrayList<String>list=new ArrayList();
    ArrayList<String>logical_operator=new ArrayList();
    ArrayList<String>conditions=new ArrayList();
    int index=tokenize.indexOf("where");
    
    
    void tokenizer() 
    {
          StringTokenizer st1 = new StringTokenizer(tokenize);
          for (; st1.hasMoreTokens();)
            {
               String str=st1.nextToken();
               System.out.println(str);
               a=str.indexOf('.');
               if(a!=-1)
                 {
                   list.add(str);
                   a=-1;
                 }
            }
         System.out.println(list);
    }
    
    
    
    void parts()
       {
    	  basepart=tokenize.substring(0,index);//gives base part
		  lastpart=tokenize.substring(tokenize.indexOf(s)+s.length()+1);//gives filtered part
	      System.out.println(tokenize.substring(0,index));
	      System.out.println(tokenize.substring(index+len,tokenize.length()));
       }
    
    
   void logicalandcondition()
      {
    	   if(lastpart!=null) 
    	     {
			   String Words[]=lastpart.split(" ");
			   int previous=0;
			   String condition="";
			   for(int i=0;i<Words.length;i++) 
			       {
				       if(Words[i].equalsIgnoreCase("and")||Words[i].equalsIgnoreCase("or")||Words[i].equalsIgnoreCase("not")) 
				          {
				                condition="";
				                logical_operator.add(Words[i]);
					            for(int j=previous;j<i;j++) 
					                {
						              condition+=Words[j]+" ";
					                }
					           conditions.add(condition.trim());
					           previous=i+1;
				          }
			        }
			           condition="";	
			    for(int j=previous;j<Words.length;j++) 
			    {
				    if(Words[j].equals("order"))
				        {
					       break;
				        }
				   condition+=Words[j]+" ";
			    }
			 conditions.add(condition.trim());
			 System.out.println(logical_operator);
			 System.out.println(conditions);
          }
      }
  String[] fields()
   {
	   int b=tokenize.indexOf("from");
	   String field=tokenize.substring(0,b);
	   String new_field[]=field.split(" ");
	   for(int i=1;i<new_field.length;i++)
	   {
		   System.out.print(new_field[i] + " ");
	   }
	   return new_field;
	
   }
   void orderby()
   {
	   Pattern pattern=Pattern.compile("(?<=order by) ([\\w]+)");
		Matcher matcher=pattern.matcher(tokenize);
		if(matcher.find()) {
			String temp=tokenize.substring(matcher.start()+1,matcher.end());
			System.out.println(temp);
		}
		else
		{
			System.out.println("null");
		}
   }
    String groupby()
   {
	   Pattern pattern=Pattern.compile("(?<=group by) ([\\w]+)");
		Matcher matcher=pattern.matcher(tokenize);
		if(matcher.find()) {
			String temp=tokenize.substring(matcher.start()+1,matcher.end());
			//System.out.println(temp);
			return temp;
		}
		else
		{
			//System.out.println("null");
			return null;
		}
   }
   void aggregate()
   {
	   StringTokenizer aggregates = new StringTokenizer(tokenize);
	   for (;aggregates.hasMoreTokens();)
	    {
	        String str=aggregates.nextToken();
	        if(str.contains("max") || str.contains("min") || str.contains("avg") || str.contains("sum") || str.contains("sub"))
	        System.out.print(str + " ");
   }
}
}

   
