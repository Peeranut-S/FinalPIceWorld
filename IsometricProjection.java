import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;


public class IsometricProjection extends JFrame{
	JButton zoomIn,zoomOut,chat,yell,custom,sound,logout;
	//double i=1;

	IsometricShow iso;
	JTextField chatBox;
	private JMenuBar menuBar;
	
	private JMenuItem help,about;
	
	public static void main(String[] a){
		IsometricProjection mainFrame = new IsometricProjection();
	}
	public IsometricProjection(){
		//this.setBackground(Color.WHITE);
		iso = new  IsometricShow();

		this.setLayout(null);
		iso.setBounds(0,0,1000,600);

		JPanel panel_1 = new JPanel();   //panel for various option
		panel_1.setBounds(1000,300,300,410);
		panel_1.setBackground(Color.DARK_GRAY);
		this.add(panel_1);
		panel_1.setLayout(null);

		JLabel opt = new JLabel("Options");
		opt.setBounds(1075,210,200,100);
		opt.setForeground(Color.BLACK);
		opt.setFont(new Font("Lucida Grande", Font.PLAIN, 25));

		custom = new JButton("Customisation");
		custom.setBounds(40,50,200,40);
		panel_1.add(custom);     

		sound = new JButton("Sound Setting");
		sound.setBounds(40,110,200,40);
		panel_1.add(sound);

		zoomIn = new JButton("ZoomIn(+)");
		zoomIn.setBounds(40,170,200,40);
		panel_1.add(zoomIn);

		zoomOut = new JButton("ZoomOut(-)");
		zoomOut.setBounds(40,230,200,40);
		panel_1.add(zoomOut);
		
		logout = new JButton("Log Out");
		logout.setForeground(new Color(204, 0, 0));
		logout.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		logout.setBounds(50,290,190,50);
		panel_1.add(logout);

		this.add(opt);
		JPanel panel_2 = new JPanel();     //panel for chatbox
		panel_2.setBounds(0,600,1000,180);
		panel_2.setBackground(Color.BLACK);
		this.add(panel_2);
		panel_2.setLayout(null);
		
		chatBox = new JTextField();
		chatBox.setBounds(20,8,750,50);
		panel_2.add(chatBox);
		
		chat= new JButton("Chat");
		chat.setBounds(800,15,80,40);
		panel_2.add(chat);
		
		yell= new JButton("YELL");
		yell.setBounds(900,15,80,40);
		panel_2.add(yell);
		

		this.add(iso);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	    
	    // making the ICEWORLD confirming exit upon clicking
	    this.addWindowListener(new WindowAdapter() {
	        public void windowClosing(WindowEvent e) { 
	             int reply = JOptionPane.showConfirmDialog(null, 
	            		 "You want to quit?", "ICEWORLD", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	             if (reply == JOptionPane.YES_OPTION)
	            	 // do log out before exiting if =yes
	                 System.exit(0);
	        }});
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height);
		this.setVisible(true);

		 menuBar = new JMenuBar();
			setJMenuBar(menuBar);
		
				
				JMenu mntmAboutWindow = new JMenu("File");
				menuBar.add(mntmAboutWindow);
				
				about = new JMenuItem("About");
				mntmAboutWindow.add(about);
				
		
				
				help = new JMenuItem("Help(F1)");
				mntmAboutWindow.add(help);
				addListener();

	}

	private void addListener() {

		help.addActionListener(new MyHandler());
		about.addActionListener(new MyHandler());
		logout.addActionListener(new MyHandler());
		}
	
	class MyHandler implements ActionListener{

		
		public void actionPerformed(ActionEvent e){
			

			if(e.getSource()==about){
				JFrame aboutDialog = new JFrame();
				aboutDialog.setSize(1000, 1000);
				aboutDialog.setTitle("aboutDialog");
				aboutDialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				//gonna put some pic instead of spongebob
				ImageIcon info = new ImageIcon("spongebob.jpg");
				
				JLabel n = new JLabel(info);
				//aboutDialog.setSize(500, 500);
				
				aboutDialog.add(n);
				aboutDialog.setVisible(true);
			}

		//	if(e.getSource()==help){
				//to be inserted
			//}
			if(e.getSource()==logout){
				//logout
				int reply = JOptionPane.showConfirmDialog(null, 
       		 "Do you want to log out from ICEWORLD?", "ICEWORLD", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (reply == JOptionPane.YES_OPTION)
        	//do log out
				System.exit(0);
			}
		}
		}
}
