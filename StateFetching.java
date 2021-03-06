
import java.awt.Container;
import java.awt.Point;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.URL;

import java.net.URLConnection;

import java.util.HashMap;

import java.util.Iterator;

import java.util.Scanner;

import java.util.Set;

import java.util.LinkedList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;





import org.json.simple.*;

import org.json.simple.parser.JSONParser;





public class StateFetching implements Runnable{
	
	static int REFRESH_INTERVAL=10000;
	protected Thread thread;
	long last_change;
	String weatherConditon; 
		
	public void start(){
		
	}
	
	public StateFetching() {
	
		thread= new Thread(this);
		thread.start();
		
		final String domain = "http://iceworld.sls-atl.com/api/&cmd=states";	
		String locat = "http://iceworld.sls-atl.com/api/explore";
		
	
	try {
	    URL url = new URL(locat);
	    HttpURLConnection uconn = (HttpURLConnection) url.openConnection();
	    uconn.connect();
	
	    //check if connected if connect show can be reached
	    //assertEquals(HttpURLConnection.HTTP_OK, uconn.getResponseCode());
	   
	} catch (IOException e) {
	  
	  JDialog warning = new JDialog();
	warning.setBounds(10,10,300,300);
	warning.setModal(true);
	Container container= warning.getContentPane();
	JOptionPane.showMessageDialog(container,
	      "The ICE World cannot be reached",
	      "Warning",
	      JOptionPane.WARNING_MESSAGE);
	warning.setVisible(true);
	    
	
	} 






int testing =1;

	try{
		
	URL iceworld = new URL(domain);
	URLConnection con = iceworld.openConnection();
	BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	String json = in.readLine();
	
	
	JSONParser parser = new JSONParser();
	
	
	JSONObject state = (JSONObject) parser.parse(json);
	
	System.out.println("Printing State!!!!!!!!!!!");
	System.out.println(state);
	
	Set keyInState = state.keySet();
	System.out.println("key in state:"+keyInState);
	
	System.out.println("********************************************");
	
	
	
	
	
	JSONObject data = (JSONObject) state.get("data");
	
	
	
	System.out.println("Priting data!!!!!!!!!!!");
	System.out.println(data);
	
	Set keyInData = data.keySet();
	System.out.println("key in data:"+keyInData);
	
	System.out.println("********************************************");
	
	
	
	
	
	JSONObject icetizen = (JSONObject) data.get("icetizen");
	
	System.out.println("Printing Icetizen!!!!!!!!!!!");
	System.out.println(icetizen);
	
	Set keys = icetizen.keySet();
	System.out.println("Key in icetizen"+keys);
	
	System.out.println("********************************************");
	
	
	
	
	
	JSONObject weather = (JSONObject) data.get("weather");
	
	Set weatherKey = weather.keySet();
	System.out.println("Key in weather is:"+weatherKey);
	
	String last_change_String = ""+weather.get("last_change");
	last_change = Long.parseLong(last_change_String);
	System.out.println("Last weather time change: "+last_change);
	
	
	weatherConditon = (String) weather.get("condition");
	System.out.println("weather condition: "+weatherConditon);
	
	System.out.println();
	
	System.out.println();
	
	
	
	int countError =1;
	
	for(Object key:keys){
	
	
	System.out.println("############################");
	
	System.out.println("Right now you working with:"+ Integer.parseInt((String) key));
	
	System.out.println("#########################");
	
	
	
	
	JSONObject userid = (JSONObject) icetizen.get(key);
	
	
	JSONObject last_known_destination = (JSONObject) userid.get("last_known_destination");


	try{
		
		if(!last_known_destination.get("timestamp").equals(null) && 
				!last_known_destination.get("position").equals(null)) {
			
			String timestampString = ""+last_known_destination.get("timestamp");		
			String stringPosition = (String) last_known_destination.get("position");		
			long timestamp = Long.parseLong(timestampString);
			
					
			int beginIndex = 1;		
			int endIndex = stringPosition.indexOf(",");		
			int beginIndex2 = endIndex+1;		
			int endIndex2 = stringPosition.indexOf(")");
					
			int x = Integer.parseInt(stringPosition.substring(beginIndex, endIndex));		
			int y = Integer.parseInt(stringPosition.substring(beginIndex2, endIndex2));
					
			Point position = new Point( x , y);
			
			
			JSONObject user = (JSONObject) userid.get("user");
			
			System.out.println("==========================");
			
			System.out.println(stringPosition);
			
			
			
			System.out.println("UserID:"+ Integer.parseInt((String) key));
			
			System.out.println("username:" + user.get("username"));
			
			System.out.println("type:" + user.get("type"));
			
			System.out.println("ip:" + user.get("ip"));
			
			System.out.println("port:" + user.get("port"));
			
			System.out.println("pid:" + user.get("pid"));
			
			System.out.println("stringpositon:"+stringPosition);
			
			System.out.println("postion:"+position);
			
			System.out.println("timestamp:"+timestamp);
			
			System.out.println("Testing Subject:"+testing);
			
			}
		
		
		
		else{
		
		
		
		System.out.println("Input error"+countError++);
		
		// do nothing
		
		}
	
	}catch(Exception e){}
	
	
	
	testing++;	

	}
	
	
	
	System.out.println("Testing:"+testing);
	
	
	
	
	
	}catch(Exception e){
	
	System.out.println(e);
	
	}
	
	
	
	System.out.println("********************************");	
	System.out.println("Total peole(included null positon):"+--testing);

}
	
	
	
	public void run(){
		
		while(true){	
			
			
			
			try{Thread.currentThread();
			Thread.sleep(REFRESH_INTERVAL);	
			
			System.out.println("Test of keys and necessary information");		
			System.out.println("The refresh interval is  : "+ REFRESH_INTERVAL/1000+" sec");
			
			StateFetching fetch= new StateFetching();
			
			
			
			}catch(InterruptedException e){}

		}
	}

	 
    public void setREFRESH_INTERVAL(int interval){
      REFRESH_INTERVAL=interval*1000;
   }
    
    public String getWeatherCondition(){
    	return weatherConditon;
    }
    
    public long getLastWeatherChange(){
    	return last_change;
    }
	
    
}


