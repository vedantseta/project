import java.io.*;
import java.util.*;
 
public class Apiori {
 
	public static void main(String[] args) throws IOException {
 
		
		int count[]=new int[50];
		String id[]=new String[20];
		String[] transactn=new String [50];
		int c=0;int p=1;
		BufferedReader br = null;
		BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
				System.out.println("id items ");

		try {
 
			String sCurrentLine;
 
			br = new BufferedReader(new FileReader("inputofapiori.txt"));
 
			while ((sCurrentLine = br.readLine()) != null) {
				
					
					String[] tempy = sCurrentLine.split(" ");	
					transactn[p++]=sCurrentLine;
					System.out.println(sCurrentLine);
					
					for(int i=1;i<tempy.length;i++)
					 {c=Integer.parseInt(tempy[i]);count[c]++;	
						id[c]=tempy[i];idformerge[c]=tempy[i];
					 }
					
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	System.out.println("Enter minimum support :");
	int min=Integer.parseInt(br1.readLine());
	c=0;
	
	//Step 1 
	System.out.println("\n \n  Step 1 :C1 \n \n ");
	System.out.println("id  count");
	
	
	
	
	
	for(int i=1;count[i]!=0;i++)
	{System.out.println(id[i]+"    "+count[i]);
		//if(count[i]>=support)
		c++;
	} 
	
	//Step 1 Ends
	
	int c1=0;
	
	//Step 2 
	
	System.out.println("\n \n  Step 2 :L1  Minimum support is "+min+" \n \n ");
	
	for(int i=1;i<=c;i++)
	{
		if(count[i]>=min)
		{	c1++;
		}
		else
		{	
			count[i]=0;
		}
	}
	
	
	for (int i = 1; i <=c1; i++)
{
       for(int j = 1; j <= c1; j++)
       {
                if(count[j] < count[j + 1])
                {		
                          int   tempVar = count[j + 1];
						  String tempstr=id[j+1];
  						  count [j + 1]= count[j];
                          id[j+1]=id[j];
						  count [j] = tempVar;
						  id[j]=tempstr;
                }
        }
}

for(int asd=0;asd<3;asd++)
{
	for(int i=1;i<=c1;i++)
	{System.out.println(id[i]+"    "+count[i]);
	
	} 
	//Deleted Min
	
	String sets[]=new String[20]; int z=1;
	int f1=0;
	
	//merge
	for(int i=1;i<=c1;i++)
	{	String[] temp1 = id[i].split(",");	
		for(int j=i+1;j<=c1;j++)
		{	String[] temp2 = id[j].split(",");
				for(int k=0;k<temp1.length;k++)
				{
			
					for(int r=0;r<temp2;r++)
					{
						for(int g=0;g<sets[z].length;g++) //checking inside set 
						{
						}
					}
			
				}
			
			//if(i!=j )
			//{sets[z++]=id[i]+","+id[j];
			//f1++;}
		}
	}
	
	
	System.out.println(Arrays.toString(sets));
	
	
	//Scanning Transcations
	c=1;
	for(int i=1;i<z;i++)	//loop for sets
	{
	
	String[] temp1 = sets[i].split(",");	
	
	int qwe=0,c5=0;
		for(int j=1;j<p;j++)	//loop for trancs
		{	String[] temp2 = transactn[j].split(" ");	
			qwe=0;
			for(int k=0;k<temp1.length;k++) 	//loop for checking sets
			{
						
						for(int r=0;r<temp2.length;r++) 	//loop for checking trans
						{
							if(temp1[k].equals(temp2[r]) )
							{qwe++;break;}
								
						}
						
						
			}
			if(temp1.length==qwe)
			c5++;
			
		}
		count[c++]=c5;
	
	//delete soon
	}

	
	System.arraycopy(sets, 1, id, 1, f1);
	
	
}	
	
	
	
}}