import java.io.*;

 
public class Hierarchical {
 
	public static void main(String[] args) {
 
		Double bat[]=new Double[20];
		Double bowl[]=new Double[20];
		String name[]={"A","B","C","D","E","F"};
		int c=0,count=0;
		BufferedReader br = null;
				System.out.println("Values of attributes ");

		try {
 
			String sCurrentLine;
 
			br = new BufferedReader(new FileReader("input.txt"));
 
			while ((sCurrentLine = br.readLine()) != null) {
				
				
					String[] tempy1 = sCurrentLine.split(" ");	
					
				
					 bat[c]=Double.parseDouble(tempy1[0]);
					bowl[c++]=Double.parseDouble(tempy1[1]);
					
					count=c;
					
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


	for(int i=0;i<c;i++)
	{System.out.println(bat[i]+"      "+bowl[i]);}
int mini=-1,minj=-1,minis=-1,minjs=-1;
	//STATRS HERE
for(int y=0;y<10;y++)
{	

	double matrix[][]=new double[c][c];
	double min=-1;
	for(int j=0;j<c;j++)
	{
		for(int i=0;i<c;i++)
		{	if(y==0 || mini!=j || minj!=i)  //for first iteration	
			{	matrix[j][i]=Math.sqrt((bat[i]-bat[j])*(bat[i]-bat[j])+(bowl[i]-bowl[j])*(bowl[i]-bowl[j]));
				
				matrix[j][i]=Math.round(matrix[j][i]*10000)/(double)10000;
				
				if(min==-1 && matrix[j][i]!=0.0)
				{
					min=matrix[j][i];minis=j; minjs=i;
				}
				else if(min>matrix[j][i] && matrix[j][i]!=0.0)
				{	min=matrix[j][i];minis=j; minjs=i;
				}
				
			}	
			else	if( mini==j && minj==i)
			{	
				
				double m1=Math.sqrt((bat[mini]-bat[i])*(bat[mini]-bat[i])+(bowl[mini]-bowl[i])*(bowl[mini]-bowl[i]));
				double m2=Math.sqrt((bat[minj]-bat[i])*(bat[minj]-bat[i])+(bowl[minj]-bowl[i])*(bowl[minj]-bowl[i]));
			
				matrix[j][i]=Math.min(m1,m2);
				
				matrix[j][i]=Math.round(matrix[j][i]*10000)/(double)10000;
				
				if(min==-1 && matrix[j][i]!=0.0)
				{
					min=matrix[j][i];minis=j; minjs=i;
				}
				else if(min>matrix[j][i] && matrix[j][i]!=0.0)
				{	min=matrix[j][i];minis=j; minjs=i;
				}
				
			}
			
		}
 mini=minis; minj=minjs;
	
	}
System.out.println("\n \n Distance Matrix \n \n");
	for(int j=0;j<c;j++)
	{	System.out.print(name[j]+"  ");
		for(int i=0;i<=j;i++)
		{
				
				System.out.print(matrix[j][i]+"    ");
				
				
		}
		System.out.println();
	}	
	
	
		

	
	
System.out.println(" MIN IS "+min+" at "+name[mini]+" "+name[minj]);



int ms=Math.min(mini,minj);
int m=Math.max(mini,minj);



name[ms]=name[ms]+name[m];

for(int u=m;u<count;u++)
{	String tempy=name[u];
		name[u]=name[u+1];
		name[u+1]=tempy;
}

System.out.println("Clusters Combined : ");



for(int u=0;u<c-1;u++)
{	System.out.println(name[u]);

}


if(name[ms].length()==count)
break;
	c--;
	//Object Clustering Starts HERE
	
	
	

	
	
}	
	
	
}}