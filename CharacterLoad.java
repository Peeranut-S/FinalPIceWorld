import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import org.json.simple.parser.ContainerFactory;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class CharacterLoad extends JPanel{

static BufferedImage head,body,shirt,weapon,background;
int bodycount=0;
int headcount=0;
int shirtcount=0;
int weaponcount=0;
static String[] headS, bodyS, shirtS, weaponS; 
static JSONParser json = new JSONParser();
static ContainerFactory containerFactory = new ContainerFactory() {
    public LinkedList creatArrayContainer() { return new LinkedList(); } 
    public Map createObjectContainer() { return new LinkedHashMap(); }

};
/*String [] shirtnum = {"t_ice","t_ice2","t_apppro","armor1","armor2","armor3","armor4","armor5","shirt1","shirt2","shirt3","shirt4","shirt5","shirt6","tank2","tank3","tank4","tank5","suit1","suit2","suit3","suit4","suit5"};
String [] weaponnum = {"hammer1","hammer2","hammer3","hammer4","hammer5","sword1","sword2","sword3","sword4","sword5","stick1","stick2","stick3","stick4","sabre1","sabre2","sabre3","sabre4","sabre5"};
String [] headnum = {"crown1","crown2","hat1","hat2","bighair1","bighair2","bighair3","bighair4","rider1","rider2","rider3"};
String [] bodynum = {"skin","tan","blue","pink","yellow","pale","gray","orangy","blue",};*/

public static void init() throws IOException{
	String inputLine;
    URL url = null;
	url= new URL("http://iceworld.sls-atl.com/api/&cmd=gresources&uid=0");
	//{"status":1,"data":["B001","B002","B003","B004","B005","B006","B007",......
	URLConnection connection = url.openConnection();
	connection.connect();
	BufferedReader temp = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	int b=0,h=0,s=0,w=0;
	while ((inputLine = temp.readLine()) != null) 
	{
	//System.out.println(inputLine);			
	String datArray = inputLine.substring(inputLine.lastIndexOf("["));
	//System.out.println(datArray);
	for(int i=0;i<datArray.length();i++){
		if(datArray.charAt(i)=='B')
			b++;
		if(datArray.charAt(i)=='H')
			h++;
		if(datArray.charAt(i)=='S')
			s++;
		if(datArray.charAt(i)=='W')
			w++;
	}
	
	bodyS =new String[b];
	headS =new String[h];
	shirtS =new String[s];
	weaponS =new String[w];
	int bcount=0,hcount=0,scount=0,wcount=0;
	
	for(int i=0;i<datArray.length();i++){
		if(datArray.charAt(i)=='B'){
			bodyS[bcount]=datArray.substring(i, i+4);
			bcount++;
		}	
		if(datArray.charAt(i)=='H'){
			headS[hcount]=datArray.substring(i, i+4);
			hcount++;
		}
		if(datArray.charAt(i)=='S'){
			shirtS[scount]=datArray.substring(i, i+4);
			scount++;
		}
		if(datArray.charAt(i)=='W'){
			weaponS[wcount]=datArray.substring(i, i+4);
			wcount++;
		}
	}
	//System.out.println("B"+b+"H"+h+"S"+s+"W"+w);
	/*for(int i=0;i<bcount;i++){
		System.out.print(body[i]+",");
	}
	*/
	}
}
public static void GetCharacterImage(String H,String B,String S,String W, String BG){
try{
head=ImageLoader.GetImageFromCloud(H);
body=ImageLoader.GetImageFromCloud(B);
shirt=ImageLoader.GetImageFromCloud(S);
weapon=ImageLoader.GetImageFromCloud(W);
}
catch(Exception e){}
/*background=ImageLoader.GetImageFromCloud(BG);*/


}
public static String getBody(int i) throws IOException{
	//getGraphicsArray();
	URL url = null;
	String breq="http://iceworld.sls-atl.com/api/&cmd=gurl&gid="+bodyS[i];
	String bla, linkToImage ="";;
	ImageIcon bodyimg;
	url= new URL (breq);
	//{"status":1,"data":{"gid":"B001","location":"graphics\/body\/blue.png"}}
	URLConnection connection = url.openConnection();
	connection.connect();
	BufferedReader temp = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	while ((bla = temp.readLine()) != null) 
	{
		
		try {
			Map jsonMap = (Map) json.parse(bla, containerFactory);
			Map jsonData = (Map)jsonMap.get("data");
			
			linkToImage = (String) jsonData.get("location");
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}	
		Image image = null;
		URL blink = new URL("http://iceworld.sls-atl.com/"+linkToImage);
		image = ImageIO.read(blink);
		
		bodyimg= new ImageIcon(image);

	return linkToImage;
}
public static String getHead(int i) throws IOException{
	URL url = null;
	String hreq="http://iceworld.sls-atl.com/api/&cmd=gurl&gid="+headS[i];
	String bla, linkToImage ="";;
	ImageIcon headimg;
	url= new URL (hreq);
	//{"status":1,"data":{"gid":"B001","location":"graphics\/body\/blue.png"}}
	URLConnection connection = url.openConnection();
	connection.connect();
	BufferedReader temp = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	while ((bla = temp.readLine()) != null) 
	{
		
		try {
			Map jsonMap = (Map) json.parse(bla, containerFactory);
			Map jsonData = (Map)jsonMap.get("data");
			
			linkToImage = (String) jsonData.get("location");
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}	

	return linkToImage;
}

public static String getShirt(int i) throws IOException{
	URL url = null;
	String sreq="http://iceworld.sls-atl.com/api/&cmd=gurl&gid="+shirtS[i];
	String bla, linkToImage ="";;
	ImageIcon shirtimg;
	url= new URL (sreq);
	//{"status":1,"data":{"gid":"B001","location":"graphics\/body\/blue.png"}}
	URLConnection connection = url.openConnection();
	connection.connect();
	BufferedReader temp = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	while ((bla = temp.readLine()) != null) 
	{
		
		try {
			Map jsonMap = (Map) json.parse(bla, containerFactory);
			Map jsonData = (Map)jsonMap.get("data");
			
			linkToImage = (String) jsonData.get("location");
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
		

	return linkToImage;
}

public static String getWeapon(int i) throws IOException{
	URL url = null;
	String wreq="http://iceworld.sls-atl.com/api/&cmd=gurl&gid="+weaponS[i];
	String bla, linkToImage ="";;
	ImageIcon weaponimg;
	url= new URL (wreq);
	//{"status":1,"data":{"gid":"B001","location":"graphics\/body\/blue.png"}}
	URLConnection connection = url.openConnection();
	connection.connect();
	BufferedReader temp = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	while ((bla = temp.readLine()) != null) 
	{
		
		try {
			Map jsonMap = (Map) json.parse(bla, containerFactory);
			Map jsonData = (Map)jsonMap.get("data");
			
			linkToImage = (String) jsonData.get("location");
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	return linkToImage;
}


public void paintComponent(Graphics g){

super.paintComponent(g);
try {
	GetCharacterImage("http://iceworld.sls-atl.com/"+getHead(headcount),"http://iceworld.sls-atl.com/"+getBody(bodycount),"http://iceworld.sls-atl.com/"+getShirt(shirtcount),"http://iceworld.sls-atl.com/"+getWeapon(weaponcount),"null");
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

g.drawImage(background, 40,20, this);

g.drawImage(body, 50,25, this);
g.drawImage(shirt, 50,25, this);
g.drawImage(head, 50,25, this);
g.drawImage(weapon,50,25,this);
}
}