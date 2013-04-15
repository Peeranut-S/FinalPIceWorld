import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.TextArea;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComponent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;


public class icePort extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnLogIn,bAlien;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					icePort frame = new icePort();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public icePort() {
	
		
	BufferedImage myImage;
		
    try {
		myImage = ImageIO.read(new File("/Users/ZethaRia/ice3.jpg"));
	this.setContentPane(this.new ImagePanel(myImage));
		 } catch (IOException e1) {
		// TODO Auto-generated catch block
		 e1.printStackTrace();
		  }
    setBounds(100, 100, 1300, 800);

    getContentPane().setBackground(new Color(204, 255, 255));
    SpringLayout springlayout = new SpringLayout();
    getContentPane().setLayout(springlayout);
    
    textField = new JTextField();
    springlayout.putConstraint(SpringLayout.NORTH, textField, 291, SpringLayout.NORTH, getContentPane());
    springlayout.putConstraint(SpringLayout.EAST, textField, -461, SpringLayout.EAST, getContentPane());
    getContentPane().add(textField);
    textField.setColumns(10);
    
    passwordField = new JPasswordField();
    springlayout.putConstraint(SpringLayout.NORTH, passwordField, 15, SpringLayout.SOUTH, textField);
    springlayout.putConstraint(SpringLayout.EAST, passwordField, -466, SpringLayout.EAST, getContentPane());
    getContentPane().add(passwordField);
    
     btnLogIn = new JButton("Log In");
     springlayout.putConstraint(SpringLayout.NORTH, btnLogIn, 23, SpringLayout.SOUTH, passwordField);
     springlayout.putConstraint(SpringLayout.WEST, btnLogIn, 534, SpringLayout.WEST, getContentPane());
     springlayout.putConstraint(SpringLayout.EAST, btnLogIn, -574, SpringLayout.EAST, getContentPane());
    getContentPane().add(btnLogIn);
    
    JLabel lblUsername = new JLabel("Username :");
    springlayout.putConstraint(SpringLayout.EAST, lblUsername, -707, SpringLayout.EAST, getContentPane());
    springlayout.putConstraint(SpringLayout.WEST, textField, 64, SpringLayout.EAST, lblUsername);
    springlayout.putConstraint(SpringLayout.NORTH, lblUsername, 0, SpringLayout.NORTH, textField);
    getContentPane().add(lblUsername);
    
    JLabel lblPassword = new JLabel("Password :");
    springlayout.putConstraint(SpringLayout.WEST, passwordField, 67, SpringLayout.EAST, lblPassword);
    springlayout.putConstraint(SpringLayout.NORTH, lblPassword, 0, SpringLayout.NORTH, passwordField);
    springlayout.putConstraint(SpringLayout.WEST, lblPassword, 0, SpringLayout.WEST, lblUsername);
    getContentPane().add(lblPassword);
    
     bAlien = new JButton("Log in as Alien");
    springlayout.putConstraint(SpringLayout.NORTH, bAlien, 0, SpringLayout.NORTH, btnLogIn);
    springlayout.putConstraint(SpringLayout.WEST, bAlien, 6, SpringLayout.EAST, btnLogIn);
    springlayout.putConstraint(SpringLayout.EAST, bAlien, -410, SpringLayout.EAST, getContentPane());
    getContentPane().add(bAlien);
    setSize(1200,700);
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    
    // making the ICEWORLD confirming exit upon clicking
    this.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent e) { 
             int reply = JOptionPane.showConfirmDialog(null, 
            		 "You want to quit?", "ICEWORLD", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
             if (reply == JOptionPane.YES_OPTION)
                 System.exit(0);
        }});
    
		addListener();
		
		
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
	
	
	private void addListener() {
		
		btnLogIn.addActionListener(new MyHandler());
		bAlien.addActionListener(new MyHandler());

	}

class MyHandler implements ActionListener{

	
		public void actionPerformed(ActionEvent e){
				
			if(e.getSource()==btnLogIn){
				// if the password is right
	String utest = textField.getText();
	String passt = passwordField.getText();
	int count =0; int sum =0;
	
	
	if(utest.equals("peeranut")&&  passt.equals("1234")){
	
			
					JOptionPane.showMessageDialog(null,"Login Success");
					
				dispose();
	
		SplashScrn wait = new SplashScrn();
		Thread a = new Thread(wait);
		a.start();
				
			}
				else{
					String uname1 = utest; //get the username
					
					JOptionPane.showMessageDialog(null,"Attempt to login fail!"+"\n"+ "please re-check your username and password");
					
							
					if((uname1.equals(utest))&&(!passt.equals("1234"))){
						count++;
					}
					
					if(count==3) {
							//do the blocking log in access
						textField.setEditable(false);
							passwordField.setEditable(false);
						
							
					}
					
								
				 
				 textField.setText("");
			passwordField.setText("");
			textField.requestFocus();   //move cursor back to username field
			
			System.out.print(count);
			}
			
			}
			
			if (e.getSource() == bAlien ){
				JOptionPane.showMessageDialog(null,"Login as Alien");
			}
				
				
			

		/*	if(e.getSource()== REFRESH_INTERVAL_item){
				// Open an internal frame when the item is selected :
				JInternalFrame RIframe = new JInternalFrame("Setting the refresh interval", true, true, true, true);	
				RIframe.setBounds(500,100,300,300);
				
				JPanel panel= (JPanel) RIframe.getContentPane();

				// In the frame, we can select the refresh interval via a combo box : 
				JTextArea text = new JTextArea("Select the refresh interval of the ICE World :"); 
				DefaultComboBoxModel mdc = new DefaultComboBoxModel(); 
				final JComboBox combo = new JComboBox();
				combo.setBounds(new Rectangle(2, 2, 2, 2));

				for(int i=1; i<=10; i++){
					combo.addItem(i); 	// adding the elements of the combo			
				}	

				combo.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						int new_value= (Integer) combo.getSelectedItem();
						StateFetching.setREFRESH_INTERVAL(new_value);
					}
				});


				panel.add(text, BorderLayout.CENTER);
				panel.add(combo, BorderLayout.CENTER);
				RIframe.setVisible(true);
					
		
		int refresh_interval =(Integer) combo.getSelectedItem();
		//refresh_interval= (Integer) combo.getSelectedItem();
		StateFetching statefetching= new StateFetching();
	statefetching.setREFRESH_INTERVAL(refresh_interval);
	combo.setSelectedItem(refresh_interval);


	RIframe.setLayout( new GridLayout(2,1,5,5));

	panel.add(text, BorderLayout.CENTER);
	panel.add(combo, BorderLayout.CENTER);
	panel.setVisible(true);
	Container c = getContentPane();
	c.add(RIframe);
	RIframe.setVisible(true);

}*/
	}
}}

