import java.io.*;
import java.net.*;


class PlayerInfo 
{
public static void main (String args[]) throws IOException
{

try {
            // Create a URL object

	    String temp="http://ccnabaaps.hostingsiteforfree.com/folder/phppart.php?q=http://www.espncricinfo.com/india/content/player/253802.html";	
            URL url = new URL(temp);
 
            // Read all of the text returned by the HTTP server
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
 
            String htmlText;
 
            while ((htmlText = in.readLine()) != null) {
                // Keep in mind that readLine() strips the newline characters
                System.out.println(htmlText);
            }
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }




}
}