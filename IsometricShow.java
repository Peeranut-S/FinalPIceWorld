import iceworld.given.ICEWorldImmigration;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;




public class IsometricShow extends JPanel {

	
	MyIcetizen tester = new MyIcetizen();

	ICEWorldImmigration imm = new ICEWorldImmigration(tester);
	

	private int scrX = Toolkit.getDefaultToolkit().getScreenSize().width;
	private int scrY = Toolkit.getDefaultToolkit().getScreenSize().height;
	private int OriX = scrX/2;
	private int OriY= scrX/2;
	private int targetX;
	private int targetY;
	private String currentWeather;
	
	private String text; 
	boolean yell = false; //--
	boolean talk = false;  //--
	private int TALK_VISIBLE_DURATION = 5000;   //--
	Image image;
	Graphics graphics2D;
	IsometricTile tile ;
	Point p; //act as target
	Point current; //act as original point

	private JPanel buttonPanel;
	private int zoomValue=1;


	public IsometricShow(){
		this.setBackground(Color.WHITE);
		this.setSize(scrX/10,scrY/10);
		current =new Point(300,300);//--
		
		
		addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){   //for click on target to get the position
				p.x = e.getX();
				p.y=e.getY();
				System.out.println(p.x);
				System.out.println(p.y);
			}
			});
		
		Refresh refresh = new Refresh();
		refresh.start();

	}
	public void setZoomValue(int zoomV){
		this.zoomValue = zoomV;
	}

	public int getZoomValue(){
		return zoomValue;
	}

	public void paintComponent(Graphics g) {

		image = createImage (getWidth(),getHeight());
		graphics2D =  image.getGraphics();

		p = getMousePosition();
		for (int line = 0 ; line<100 ; line++) {
			for (int row = 100; row > 0; row --) {
				tile = new IsometricTile (line,row,zoomValue);
				if (p != null){
					repaint();  // need thread, else stop work if click other button
					if (tile.contains(p)) {

						tile.setHighlighted(true);

					}

				}
				tile.paintComponent(graphics2D);

			}
		}
		
		g.setColor(Color.WHITE);  //--
        g.fillRect(0,0,getWidth(),getHeight());//--
      
		g.drawImage(image, 0,0,this);
		//drawForegroundWeather(g);
		 
		//if(talk==true){
		  //      talking.paintTalking(g,this.getCurrent().x, this.getCurrent().y);
		    //    }
		paintYell(g);
		paintTalk(g,TALK_VISIBLE_DURATION,current);
	}
		
	
	
	public void paintTalk(Graphics g, final int TALK_VISIBLE_DURATION,Point charPos){
		 if(talk==true){
			 
				 int rectWidth = 100*zoomValue, rectHeight = 50*zoomValue;
				 
				 g.setColor(Color.white);
				 g.fillRect(charPos.x, charPos.y,rectWidth, rectHeight);
				 
			 
		        FontMetrics ft = g.getFontMetrics();
		        double textWidth = ft.getStringBounds(text, g).getWidth();
		        g.setColor(Color.BLACK);
		        g.drawString(text, ((int) charPos.x),
		        					(int) (charPos.y)+20);
		        (new DisplayBubble ()).start();
		        
		 }
		
		        
		       // if (imm.talk(text)){
		        //	System.out.println("Talk OK");
		        	//}
		        
		
	}
	//========================       ========================       ========================       
	  //======================== YELL METHOD================================================       
		
			public void paintYell(Graphics g){
	if(yell==true){  //--
        	// Some parameters.
            //String text = "Some Label";
            int centerX = 500, centerY = 300;
            int ovalWidth = 200*zoomValue, ovalHeight = 100*zoomValue;

            // Draw oval
            g.setColor(Color.BLUE);
            g.fillOval(centerX-ovalWidth/2, centerY-ovalHeight/2,
                       ovalWidth, ovalHeight);
//left to set fontsize once zoomed
            // Draw centered text
            FontMetrics fm = g.getFontMetrics();
            double textWidth = fm.getStringBounds(text, g).getWidth();
            g.setColor(Color.WHITE);
            g.drawString(text, (int) (centerX - textWidth/2),
                               (int) (centerY + fm.getMaxAscent() / 2));//--
            //this.yell=false;    //to set yell back so that it does not show permanently
            (new DisplayYell ()).start();
            if (imm.yell("Hello")){
            	System.out.println("Yell OK");
            	}
	
	
	}
		
	}
	
   //========================       ========================       ========================       
	//    ========================       ========================       =====================
			
	public void targetToCurrent(Point target){   //once click and moved [update] the target point to current point
		this.current.x = target.x;
		this.current.y = current.y;
	
	}

	public Point getCurrent(){
		return this.current;
	}
	
	public Point getTarget(){
		return this.p;
		
	}
	
	public void setYell(){
		this.yell = true;
	}
	
	public void setText(String text){
		this.text=text;
	}
	
	public void setTalk(){
		this.talk = true;
	}
	
	public void drawForegroundWeather(Graphics g){
		switch (currentWeather){
			case "Sunny":
				Weather.sunny(g, this.getWidth(), this.getHeight());
				break;
			case "Cloudy":
				System.out.println("It's cloudy");
				Weather.cloudy(g, this.getWidth(), this.getHeight());
				break;
			case "Raining":
				Weather.raining(g, this.getWidth(), this.getHeight());
				break;
			case "Snowing":
				Weather.snowing(g, this.getWidth(), this.getHeight());
				break;
			default:
				System.out.println("it's default");
				Weather.raining(g, this.getWidth(), this.getHeight());
			
		} 
	}
	public void drawBackgroundWeather(Graphics g){
		switch (currentWeather){
			case "Raining":
			case "Snowing":
				Weather.rainingBackground(g, this.getWidth(), this.getHeight());
			break;
			case "Cloudy":
			case "Sunny":
			default:
				Weather.sunnyBackground(g, this.getWidth(), this.getHeight());
			
		} 
	
	}
	
	
	
	
	
	
	
	
	class DisplayYell extends Thread {   // Thread for the talk showing
		public void run (){
			try {
				sleep (TALK_VISIBLE_DURATION);
			} catch (InterruptedException e) {}
			yell = false;
		}
	}
	
	 class DisplayBubble extends Thread {   // Thread for the talk showing
			public void run (){
				try {
					sleep (TALK_VISIBLE_DURATION);
				} catch (InterruptedException e) {}
				talk = false;
			}
		}
	
	
	
	class Refresh extends Thread{
		public void run(){
			while(true){
				try{
					sleep(1);
				}catch(InterruptedException e){

				}
				repaint();
			}
		}
	}


	
}
