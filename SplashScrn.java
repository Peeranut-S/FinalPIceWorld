import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;


public class SplashScrn extends JWindow implements Runnable{

	Image img = Toolkit.getDefaultToolkit().getImage("/Users/ZethaRia/Desktop/ICEFETCH2.jpg");
	
	public SplashScrn(){
		setSize(600,400);
		  setBounds(260, 200, 600, 400);
		setVisible(true);

	}
	public void paint(Graphics g){

		g.drawImage(img,0,0,this);
		
	}
	public void run(){

		try{
			Thread.sleep(3000);
			dispose();
			IsometricProjection a = new IsometricProjection();
			a.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}


	}
}