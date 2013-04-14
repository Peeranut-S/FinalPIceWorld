import java.awt.*;

import javax.swing.*;


public class Customization extends JFrame {
	public Customization() {
		this.setSize(800, 600);
		setGui();
	}

	public void setGui() {
		this.setLayout(new GridLayout(1, 2, 1, 1));
		JPanel left = new JPanel();
		left.setLayout(new BorderLayout());
		JPanel cha =new JPanel();
		JLabel headline = new JLabel("Your Character");
		headline.setFont(new Font("Serif",Font.BOLD,36));
		left.add(cha,BorderLayout.CENTER);
		left.add(headline,BorderLayout.NORTH);
		JPanel right = new JPanel();
		right.setLayout(new GridLayout(8,1,1,1));
		JPanel right1 = new JPanel();
		right1.setLayout(new BorderLayout());
		JButton head = new JButton("Head");
		right1.add(head,BorderLayout.CENTER);
		JPanel right2 = new JPanel();
		right2.setLayout(new BorderLayout());
		JButton body = new JButton("Body");
		right2.add(body,BorderLayout.CENTER);
		JPanel right3 = new JPanel();
		right3.setLayout(new BorderLayout());
		JButton shirt = new JButton("Shirt");
		right3.add(shirt,BorderLayout.CENTER);
		JPanel right4 = new JPanel();
		right4.setLayout(new BorderLayout());
		JButton weapon = new JButton("Weapon");
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
		this.add(left);
		this.add(right);
	}
	public void paint(Graphics g){
		super.paint(g);
	}
	public static void main(String[]args){
		Customization a = new Customization();
		a.setVisible(true);
		}

}
