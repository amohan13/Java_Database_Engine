package sapient.java.databaseengine;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {
        
       Query q=new Query();
       q.tokenizer();
       q.parts();
       q.logicalandcondition();
		String field[]=q.fields();
		q.orderby();
		String a=q.groupby();
		System.out.println(a);
		q.aggregate();
		Header_datatypes m=new Header_datatypes();
		m.method();
		Date_Identify d=new Date_Identify();
		d.Date();
		String filename = "ipl.csv";
		 ArrayList<String> list[] = new ArrayList[18];
		    for(int i=0;i<18;i++)
		    {
		    	list[i]=new ArrayList<String>();
		    }
			FileReader fileread=null;
			BufferedReader br=null;
			String head=" "; 
			String value=" ";
			StringTokenizer st;
			
			try {
		            fileread=new FileReader(filename);
		            br=new BufferedReader(fileread);
					String CurrentLine=" ";
			//reads the first line of the file		
					head= br.readLine();
		   //reads the whole file			
				    while ((CurrentLine = br.readLine()) != null) {
				    	value+=CurrentLine;
				    	st = new StringTokenizer(CurrentLine, ",");
				    	int curr=0;
				    	while(st.hasMoreTokens())
				    	{
				    		list[curr++].add(st.nextToken());
				    	}
				    }
				  
			        Parse_query qparse= new Parse_query();
			        qparse.getData(head,list,field);
				    	

				} catch (IOException e) {
					e.printStackTrace();
				}
			    finally {
			    	if(br!=null) {
			    		try {
			    			br.close();
			  	    		}catch(IOException e){
			  	    			e.printStackTrace();			
			  	    		}
			    	}
			    	if(fileread!=null)
			    	{
			    		try {
			    			fileread.close();
			    		}catch(IOException e) {
			    			e.printStackTrace();
			    		}
			    	}
			    }
			

    }
}
    

