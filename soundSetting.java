import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;


public class soundSetting extends JFrame {
private JLabel label;
private ImageIcon Image;
private JSlider bgmS,sfxS;
	
	
public soundSetting(){
	

 
    this.setSize(400,200);
	this.setBounds(1000,0,400,200);
	
	createGUI();
}

	public void createGUI(){
		this.setBackground(Color.BLACK);
	JPanel sounding = new JPanel();
	sounding.setBounds(0,0,500,250);
	this.add(sounding);
	sounding.setLayout(null);
	JLabel bgm = new JLabel("BGM :");
	bgm.setForeground(Color.WHITE);
	bgm.setBounds(50,30,100,50);
	sounding.add(bgm);
	 bgmS = new JSlider(JSlider.HORIZONTAL,0,25,10);
	bgmS.setBounds(130,40,200,30);
	sounding.add(bgmS);
	
	JLabel sfx = new JLabel("SFX :");
	sfx.setForeground(Color.WHITE);
	sfx.setBounds(50,80,100,50);
	sounding.add(sfx);

	sfxS = new JSlider(JSlider.HORIZONTAL,0,25,10);
	sfxS.setBounds(130,90,200,30);
	sounding.add(sfxS);
	
	this.setResizable(false);
	this.setVisible(true);
	
}

	class ImagePanel extends JComponent {
		  private Image image;
		  
		public ImagePanel(Image image) {
		 this.image = image;}
		@Override
		
		protected void paintComponent(Graphics g){
			g.drawImage(image,0,0,null);
		}
		
}
public static void main(String[]args){
	soundSetting setting = new soundSetting();
	setting.setVisible(true);
}
}
