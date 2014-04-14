import java.io.*;

import java.net.*;
 
public class FileReader {
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Input 2 teams ");
		String team1=br1.readLine();
		String team2=br1.readLine();
		String team;
 
 
 for(int q=1;q<=2;q++)
{ 
	if(q==1)
	team=team1;
	else
	team=team2;

		BufferedReader br = null;
		
		String line;
			try {
			br = new BufferedReader(new FileReader("playerinformation.txt"));
			 
			while ((line = br.readLine()) != null) 
{	
				//	http://www.espncricinfo.com/ci/content/player/42639.html
				
				String[] element = line.split(",");
			
				if(element[2].equals(team))				
				{

					System.out.println(line);

					try {
          				  // Create a URL object

	  				  String temp="http://ccnabaaps.hostingsiteforfree.com/folder/phppart.php?q=http://www.espncricinfo.com/ci/content/player/"+element[1]+".html";	
           				 URL url = new URL(temp);
 
           				 // Read all of the text returned by the HTTP server
          				  BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
 
           				 String htmlText;
 					htmlText = in.readLine(); 
           				System.out.println(htmlText);
					String[] stats = htmlText.split("<br>");	
							

			
					int indx=stats[7].indexOf("<");
					
					
					//POINTS STARTS HERE
					
					double p1=0,p2=0,p3=0,p4=0,p5=0,p6=0,p7=0,p8=0;
					
					//NO of matches
					if(Integer.parseInt(stats[0])>=400)
					p1=1;
					else
					p1=Integer.parseInt(stats[0])/400;
					
					//runs Scored
					if(Integer.parseInt(stats[1])>=10000)
					p2=1;
					else
					p2=Integer.parseInt(stats[1])/1000;
						
					
					//Batting avg
					if(Integer.parseInt(stats[2])>=40)
					p3=1;
					else
					p3=Integer.parseInt(stats[2])/40;
					
					//strike rate
					if(Integer.parseInt(stats[3])>=90)
					p4=1;
					else
					p4=Integer.parseInt(stats[3])/90;
					
					
					//Batting Stats
					
					
					double batting=(p1+p2+p3*2+p4)*2;
					
					//POINTS ENDS HERE
					
					String tempstr=element[0]+","+stats[0]+","+stats[1]+","+stats[2]+","+stats[3]+","+stats[4]+","+stats[5]+","+stats[6]+","+stats[7].substring(0,indx)+" "+batting;
					
					System.out.println(tempstr);

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
 
	      				  System.out.println("Done"+batting);
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
		}
 
}	