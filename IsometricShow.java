import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class IsometricShow extends JPanel {

	private int scrX = Toolkit.getDefaultToolkit().getScreenSize().width;
	private int scrY = Toolkit.getDefaultToolkit().getScreenSize().height;
	Image image;
	Graphics graphics2D;
	IsometricTile tile ;
	Point p;

	private JPanel buttonPanel;
	private int zoomValue=1;


	public IsometricShow(){
		this.setBackground(Color.WHITE);
		this.setSize(scrX/10,scrY/10);

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


		g.drawImage(image, 0,0,this);

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
