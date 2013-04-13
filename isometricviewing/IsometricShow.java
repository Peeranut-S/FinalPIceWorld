import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class IsometricShow extends JPanel {
	
	private int scrX = Toolkit.getDefaultToolkit().getScreenSize().width;
	private int scrY = Toolkit.getDefaultToolkit().getScreenSize().height;
	Image image;
	Graphics graphics2D;
	IsometricTile tile ;
	Point p;
	
	
	public IsometricShow(){
		setSize(scrX,scrY);
		Refresh refresh = new Refresh();
    	refresh.start();
    	
	}
	
	
	 public void paintComponent(Graphics g) {
		  
	          	image = createImage (getWidth(),getHeight());
	        	graphics2D =  image.getGraphics();
	            
	        	p = getMousePosition();
	                for (int line = 0 ; line<100 ; line++) {
	                	for (int row = 100; row > 0; row --) {
	               			tile = new IsometricTile (line,row);
	               			if (p != null){
	               				if (tile.contains(p)) {
	               					tile.setHighlighted(true);
	               				}
	               				
	               			}
	               			tile.paintComponent(graphics2D);
	                	}
	                }
	                g.drawImage(image, 0,0,this);
	              
	           	}
	 
	 class Refresh extends Thread{
     	public void run(){
     		while(true){
	        			try{
	        				sleep(40);
	        			}catch(InterruptedException e){
	        				
	        			}
     		repaint();
     		}
     	}
     }
	 
	 public static void main(String[] args) {
		    JFrame frame = new JFrame();
		    frame.getContentPane().add(new IsometricShow());

		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height);
		    
		    frame.setVisible(true);
		  }

	 
	 
}
