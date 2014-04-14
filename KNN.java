import java.io.*;
import java.util.Arrays;
 
public class KNN {
 
	public static void main(String[] args) throws IOException {
 
		Double bat[]=new Double[20];
		Double bowl[]=new Double[20];
		String name[]=new String[20];
		int cluster[]=new int[20];
		int c=0;
		BufferedReader br = null;
 
		try {
 
			String sCurrentLine;
 
			br = new BufferedReader(new FileReader("india.txt"));
 
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
	
	
		
	//Object Clustering Done
	
	//Iteration 1
	
	//Centroid  Finding
	
	
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
	
	

	
	if(oxofc1-xofc1==0.0 && oyofc1-yofc1==0.0 && oxofc2-xofc2==0.0 && oyofc2-yofc2==0.0 && oxofc3-xofc3==0.0 && oyofc3-yofc3==0.0)
	{
		int d=0;
		for(int i=0;i<3;i++)
		{	System.out.println("Cluster formed of");
		for(int j=0;j<c;j++)
		{	
			if(matrix[i][j]==1.0)
			{System.out.println(name[j]);cluster[d++]=i;}
		}
		}
	
		
	//KNN STARTS HERE
		
	
	BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter the value of K");
	int knn=Integer.parseInt(br1.readLine());
	
	
	System.out.println("Enter new Entry in form of Name,Batting Points ,Bowling Points");
	String line=br1.readLine();
	
	String[] tem =line.split(",");
	
	
	double bw=Double.parseDouble(tem[2]);
	double bt=Double.parseDouble(tem[1]);
	
	
	Double distance[]=new Double[c];
	int index[]=new int[c];
	for(int i=0;i<c;i++)
	{
		distance[i]=Math.sqrt((bat[i]-bt)*(bat[i]-bt)+(bowl[i]-bw)*(bowl[i]-bw));
		index[i]=i;System.out.println(distance[i]);
	}



	int j;
    boolean flag = true;   
    double temp;int t;
	while ( flag )
     {
            flag= false;    
            for( j=0;  j < distance.length -1;  j++ )
            {
                   if ( distance[ j ] > distance[j+1] )   
                   {
                           temp = distance[ j ];                
                           distance[ j ] = distance[ j+1 ];
                           distance[ j+1 ] = temp;
                          flag = true;
							t=index[j];
							index[j]=index[j+1];
							index[j+1]=t;	
                  } 
            } 
      } 
		
	
	int m1=0,m2=0,m3=0;	
	for( j=0;  j < knn;  j++ )
    {	
		if(cluster[index[j]]==0)
		m1++;
		if(cluster[index[j]]==1)
		m2++;
		if(cluster[index[j]]==2)
		m3++;
	}	
	
	if(m1>m2 && m1>m3)
	System.out.println("New Entry belongs to first cluster");
	else if(m2>m3 && m2>m3)
	System.out.println("New Entry belongs to second cluster");
	else
	System.out.println("New Entry belongs to third cluster");
	
	
	break;}
}	
	
	
	
	
	
	
}}