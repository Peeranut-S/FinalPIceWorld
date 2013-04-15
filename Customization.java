import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.*;


public class Customization extends JFrame implements ActionListener{
	JButton body,head,shirt,weapon;
	CharacterLoad loader;
	public Customization() throws IOException {
		this.setSize(900, 600);
		setGui();
	}

	public void setGui() throws IOException {
		loader.init();
		loader= new CharacterLoad();
		this.setLayout(new GridLayout(1, 2, 1, 1));
		JPanel left = new JPanel();
		left.setLayout(new BorderLayout());
		JPanel cha =new JPanel();
		JLabel headline = new JLabel("Your Character");
		headline.setFont(new Font("Serif",Font.BOLD,36));
		left.add(loader,BorderLayout.CENTER);
		left.add(headline,BorderLayout.NORTH);
		JPanel right = new JPanel();
		right.setLayout(new GridLayout(8,1,1,1));
		JPanel right1 = new JPanel();
		right1.setLayout(new BorderLayout());
		 head = new JButton("Head");
		right1.add(head,BorderLayout.CENTER);
		JPanel right2 = new JPanel();
		right2.setLayout(new BorderLayout());
		 body = new JButton("Body");
		right2.add(body,BorderLayout.CENTER);
		JPanel right3 = new JPanel();
		right3.setLayout(new BorderLayout());
		 shirt = new JButton("Shirt");
		right3.add(shirt,BorderLayout.CENTER);
		JPanel right4 = new JPanel();
		right4.setLayout(new BorderLayout());
		 weapon = new JButton("Weapon");
		right4.add(weapon,BorderLayout.CENTER);
		JLabel h = new JLabel("Head");
		h.setFont(new Font("Serif",Font.PLAIN,28));
		h.setVerticalAlignment(JLabel.BOTTOM);
		right.add(h);
		right.add(right1);
		JLabel b = new JLabel("Body");
		b.setFont(new Font("Serif",Font.PLAIN,28));
		b.setVerticalAlignment(JLabel.BOTTOM);
		right.add(b);
		right.add(right2);
		JLabel s = new JLabel("Shirt");
		s.setFont(new Font("Serif",Font.PLAIN,28));
		s.setVerticalAlignment(JLabel.BOTTOM);
		right.add(s);
		right.add(right3);
		JLabel w = new JLabel("Weapon");
		w.setFont(new Font("Serif",Font.PLAIN,28));
		w.setVerticalAlignment(JLabel.BOTTOM);
		right.add(w);
		right.add(right4);
		body.addActionListener(this);
		shirt.addActionListener(this);
		weapon.addActionListener(this);
		head.addActionListener(this);
		this.add(left);
		this.add(right);
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==head&&loader.headcount<=loader.headS.length){
		
		loader.headcount++;
		loader.repaint();
		if(loader.headcount==loader.headS.length){loader.headcount=0;}
		}



		if(e.getSource()==body&&loader.bodycount<=loader.bodyS.length){
		loader.bodycount++;
		loader.repaint();
		if(loader.bodycount==loader.bodyS.length){loader.bodycount=0;}
		}




		if(e.getSource()==weapon&&loader.weaponcount<=loader.weaponS.length){
		loader.weaponcount++;
		loader.repaint();
		if(loader.weaponcount==loader.weaponS.length){loader.weaponcount=0;}
		}

		if(e.getSource()==shirt&&loader.shirtcount<=loader.shirtS.length){
		loader.shirtcount++;
		loader.repaint();
		if(loader.shirtcount==loader.shirtS.length){loader.shirtcount=0;}
		}

		}
	
	
	
	
	
	public void paint(Graphics g){
		super.paint(g);
	}
	public static void main(String[]args) throws IOException{
		Customization a = new Customization();
		a.setVisible(true);
		}

}
