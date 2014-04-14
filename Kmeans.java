import java.io.*;

 
public class Kmeans {
 
	public static void main(String[] args) {
 
		Double bat[]=new Double[20];
		Double bowl[]=new Double[20];
		String name[]=new String[20];
		int c=0;
		BufferedReader br = null;
 
		try {
 
			String sCurrentLine;
 
			br = new BufferedReader(new FileReader("pakistan.txt"));
 
			while ((sCurrentLine = br.readLine()) != null) {
				
				
					String[] tempy1 = sCurrentLine.split(",");	
					name[c]=tempy1[0];
					String[] tempy = tempy1[8].split(" ");
				
					 bat[c]=Double.parseDouble(tempy[1]);
					bowl[c++]=Double.parseDouble(tempy[2]);
					
						
					
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

	double xofc1=bat[0],yofc1=bowl[0],xofc2=bat[4],yofc2=bowl[4],xofc3=bat[8],yofc3=bowl[8]; 	//random values 
	
	
for(int f=0;f<100;f++)	
{	
	
	double matrix[][]=new double[3][c];
	
	for(int j=0;j<3;j++)
	{
		for(int i=0;i<c;i++)
		{
				if(j==0)
				{
				
				matrix[j][i]=Math.sqrt((bat[i]-xofc1)*(bat[i]-xofc1)+(bowl[i]-yofc1)*(bowl[i]-yofc1));
				}
				if(j==1)
				{
				matrix[j][i]=Math.sqrt((bat[i]-xofc2)*(bat[i]-xofc2)+(bowl[i]-yofc2)*(bowl[i]-yofc2));
				}
				if(j==2)
				{
				matrix[j][i]=Math.sqrt((bat[i]-xofc3)*(bat[i]-xofc3)+(bowl[i]-yofc3)*(bowl[i]-yofc3));
				}
		}
	}	
	
	
	
		
	//Euclidean Distance done Here 
	
	
	//Object Clustering Starts HERE
	
	
	for(int i=0;i<c;i++)
	{	
		if(matrix[0][i]>matrix[1][i])
		{ 	
			
			if(matrix[1][i] >matrix[2][i])
			{matrix[0][i]=0;matrix[1][i]=0;matrix[2][i]=1;}
			else
			{matrix[0][i]=0;matrix[1][i]=1;matrix[2][i]=0;}
		
		}
		else
		{
			if(matrix[0][i] >matrix[2][i])
			{matrix[0][i]=0;matrix[1][i]=0;matrix[2][i]=1;}
			else
			{matrix[0][i]=1;matrix[1][i]=0;matrix[2][i]=0;}
		}
	}
	
	System.out.println();
	System.out.println("Object Clustering");
	for(int i=0;i<3;i++)
	{
		for(int j=0;j<c;j++)
		{System.out.print(matrix[i][j]+"  ");}
		System.out.println();
	}	
	//Object Clustering Done
	
	//Iteration 1
	
	//Centroid  Finding
	System.out.println("Old Centroid");
	System.out.println(xofc1+"  "+yofc1);
	System.out.println(xofc2+"  "+yofc2);
	System.out.println(xofc3+"  "+yofc3);
	
	double oxofc1=xofc1,oyofc1=yofc1,oxofc2=xofc2,oyofc2=yofc2,oxofc3=xofc3,oyofc3=yofc3; 	//random values 
	
	
	for(int i=0;i<3;i++)
	{	int n=0;double totalx=0,totaly=0;
		for(int j=0;j<c;j++)
		{
		
			if(i==0)
			{	if(matrix[i][j]==1.0)
				{
					totalx=totalx+bat[j];totaly=totaly+bowl[j];
					n++;
					xofc1=totalx/n;yofc1=totaly/n;
				}
			}
			else if(i==1)
			{	if(matrix[i][j]==1.0)
				{
					totalx=totalx+bat[j];totaly=totaly+bowl[j];
					n++;
					xofc2=totalx/n;yofc2=totaly/n;
				}
			}
			else if(i==2)
			{	if(matrix[i][j]==1.0)
				{
					totalx=totalx+bat[j];totaly=totaly+bowl[j];
					n++;
					xofc3=totalx/n;yofc3=totaly/n;
				}
			}
			
		}
	}	
	
	System.out.println("New Centroid");
	System.out.println(xofc1+"  "+yofc1);
	System.out.println(xofc2+"  "+yofc2);
	System.out.println(xofc3+"  "+yofc3);

	
	if(oxofc1-xofc1==0.0 && oyofc1-yofc1==0.0 && oxofc2-xofc2==0.0 && oyofc2-yofc2==0.0 && oxofc3-xofc3==0.0 && oyofc3-yofc3==0.0)
	{System.out.println(" Loop break :P");
	
		for(int i=0;i<3;i++)
		{	System.out.println("Cluster formed of");
		for(int j=0;j<c;j++)
		{	
			if(matrix[i][j]==1.0)
			System.out.println(name[j]);
		}
		}
	
	
	
	break;}
}	
	
	
}}