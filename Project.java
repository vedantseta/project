import java.io.*;

import java.net.*;
 
public class Project {
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Input 2 teams ");
		String team1=br1.readLine();
		String team2=br1.readLine();
		String team;
 
		Double team1bat[]=new Double[20];
		Double team1bowl[]=new Double[20];
		
		Double team2bat[]=new Double[20];
		Double team2bowl[]=new Double[20];
		
		
		
		int c1=0,c2=0;int count1=0,count2=0;double avgbat1=0,avgbat2=0,avgbowl1=0,avgbowl2=0;
		
 for(int q=1;q<=2;q++)
{ 
	if(q==1)
	team=team1;
	else
	team=team2;

		BufferedReader br = null;
		System.out.println(team);
		String line;
			try {
			br = new BufferedReader(new FileReader("playerinformation.txt"));
			 
			while ((line = br.readLine()) != null) 
{	
				//	http://www.espncricinfo.com/ci/content/player/42639.html
				
				String[] element = line.split(",");
			
				if(element[2].equals(team))				
				{

					System.out.println(team);

					try {
          				  // Create a URL object

	  				  String temp="http://ccnabaaps.hostingsiteforfree.com/folder/phppart.php?q=http://www.espncricinfo.com/ci/content/player/"+element[1]+".html";	
           				 URL url = new URL(temp);
 
           				 // Read all of the text returned by the HTTP server
          				  BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
 
           				 String htmlText;
 					htmlText = in.readLine(); 
           				
					String[] stats = htmlText.split("<br>");	
							
					System.out.println(htmlText);
			
					int indx=stats[7].indexOf("<");
					String tempstr=element[0]+","+stats[0]+","+stats[1]+","+stats[2]+","+stats[3]+","+stats[4]+","+stats[5]+","+stats[6]+","+stats[7].substring(0,indx);
					
					
					//POINTS STARTS HERE
					
					double p1=0,p2=0,p3=0,p4=0,p5=0,p6=0,p7=0,p8=0;
					
					//NO of matches
					
					if(Double.parseDouble(stats[0])>=100 )
					p1=1;
					else
					p1=Double.parseDouble(stats[0])/100;
					
					//runs Scored
					if(Double.parseDouble(stats[1])>=10000)
					p2=1;
					else
					p2=Double.parseDouble(stats[1])/10000;
						
					
					//Batting avg
					if(Double.parseDouble(stats[2])>=40)
					p3=1;
					else
					p3=Double.parseDouble(stats[2])/40;
					
					//strike rate
					if(Double.parseDouble(stats[3])>=90)
					p4=1;
					else
					p4=Double.parseDouble(stats[3])/90;
					
					//Batting Stats
					
					
					double batting=(p1+p2+p3*2+p4)*2;
					
					//Bowling Stats
					//wickets
					if(stats[4].equals("-"))
					p1=0;
					else if(Double.parseDouble(stats[4])>=100)
					p1=1;
					else
					p1=Double.parseDouble(stats[4])/100;
					
					
					//avg
					if(stats[5].equals("-"))
					p2=0;
					else if(Double.parseDouble(stats[5])<=22)
					p2=1;
					else
					p2=22/Double.parseDouble(stats[5]);
					
					
					//wickets per match
					if(stats[4].equals("-"))
					p4=0;
					else 
					p4=Double.parseDouble(stats[4])/Double.parseDouble(stats[0]);
					
					if(p4>1)
					p4=1;
					
					
					//eco
					if(stats[6].equals("-"))
					p3=0;
					else if(Double.parseDouble(stats[6])<=4)
					p3=1;
					else if(Double.parseDouble(stats[6])<=4.5)
					p3=0.9;
					else if(Double.parseDouble(stats[6])<=5)
					p3=0.8;
					else if(Double.parseDouble(stats[6])<=5.5)
					p3=0.7;
					else if(Double.parseDouble(stats[6])<=6)
					p3=0.6;
					else if(Double.parseDouble(stats[6])<=6.5)
					p3=0.5;
					else if(Double.parseDouble(stats[6])<=7)
					p3=0.4;
					else 
					p3=0.2;
					double bowling=(p1+p2+p3+p4*2)*2;
					
					
					//Bowling Stats
					
					System.out.println(element[0]+" "+batting+"  "+bowling);

					
					//Storing Stats
					
					
					if(team.equals(team1))
					{team1bat[count1]=batting;c1=count1	;team1bowl[count1++]=bowling;}
					else
					{team2bat[count2]=batting;c2=count2	;team2bowl[count2++]=bowling;}
					//Storing Stats Ends HERE
					
					//POINTS ENDS HERE
					
					tempstr=tempstr+" "+batting+" "+bowling;
					
					//FILE WRITER STARTS HERE
					String data = tempstr;
 					String filename="C:\\Users\\Vedant\\Desktop\\project\\"+team+".txt";
    					File file =new File(filename);
 
    					//if file doesnt exists, then create it
    					if(!file.exists()){
    					file.createNewFile();
    					}
 
    					//true = append file
    					FileWriter fileWritter = new FileWriter(file.getName(),true);
    	    				BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
    	   			        bufferWritter.write(data);
					bufferWritter.newLine();
    	     			 	  bufferWritter.close();
 
	      				  
					//FILE WRITER CLOSES HERE




					System.out.println();
           				 in.close();
      					  } catch (MalformedURLException e) {
       					     e.printStackTrace();
      					  } catch (IOException e) {
       					     e.printStackTrace();
      					  }










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
 
 
 
 
 }
 
 
	for(int i=0;i<=c1;i++)
	{
		avgbat1=avgbat1+team1bat[i];
		avgbowl1=avgbowl1+team1bowl[i];
 
	}
	
	for(int i=0;i<=c2;i++)
	{
		avgbat2=avgbat2+team2bat[i];
		avgbowl2=avgbowl2+team2bowl[i];
 
	}
 
 
 
	avgbat1=avgbat1/c1;
	avgbat2=avgbat2/c2;
	avgbowl1=avgbowl1/c1;
	avgbowl2=avgbowl2/c2;
 
	System.out.println("avgbat1  "+avgbat1);
	System.out.println("avgbat2  "+avgbat2);
	System.out.println("avgbowl1  "+avgbowl1);
	System.out.println("avgbowl2  "+avgbowl2);
 
	double t1points=avgbowl1+avgbat1;
	double t2points=avgbowl2+avgbat2;
	
	
	double total=t1points+t2points;
	
	
	double pro1=(t1points/total)*1;
	double pro2=1-pro1;
	
	System.out.println("Pro of "+team1+" winning aganist "+team2+" is "+pro1);
  
 
 
 
 
 
 
 
 
 
 
		}
 
}	