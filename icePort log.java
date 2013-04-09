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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
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
	private JMenuBar menuBar;
	private JMenu function;
	
	//panel for help
	private JPanel panel1;
	 private JPanel panel2;
	 private JPanel panel3;
    
	private JMenuItem quit, REFRESH_INTERVAL_item,help,about;
	private JButton btnLogIn;
	
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
    
    JButton btnLogInAs = new JButton("Log in as Alien");
    springlayout.putConstraint(SpringLayout.NORTH, btnLogInAs, 0, SpringLayout.NORTH, btnLogIn);
    springlayout.putConstraint(SpringLayout.WEST, btnLogInAs, 6, SpringLayout.EAST, btnLogIn);
    springlayout.putConstraint(SpringLayout.EAST, btnLogInAs, -410, SpringLayout.EAST, getContentPane());
    getContentPane().add(btnLogInAs);
    setSize(1200,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		 menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		 function = new JMenu("File");
		menuBar.add(function);
		
		 REFRESH_INTERVAL_item = new JMenuItem("Refresh Interval");
		function.add(REFRESH_INTERVAL_item);
		
		 quit = new JMenuItem("Exit");
		function.add(quit);
		
		JMenu mntmAboutWindow = new JMenu("About");
		menuBar.add(mntmAboutWindow);
		
		about = new JMenuItem("About window");
		mntmAboutWindow.add(about);
		
		JMenu mntmHelpWindow  = new JMenu("Help (F1)");
		menuBar.add(mntmHelpWindow );
		
		help = new JMenuItem("Help Window");
		mntmHelpWindow .add(help);
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
	
	//create panel for the help
			public void createPage1()
			 {
			panel1 = new JPanel();
			 panel1.setLayout( null );
			 JLabel label1 = new JLabel( "Logging In/Out" );
			label1.setBounds( 10, 15, 150, 20 );
			 panel1.add( label1 );
			 }

			 public void createPage2()
			 {
				 panel2 = new JPanel();
			 panel2.setLayout( new BorderLayout() );

			 panel2.add( new JButton( "North" ), BorderLayout.NORTH );
			 panel2.add( new JButton( "South" ), BorderLayout.SOUTH );
			 panel2.add( new JButton( "East" ), BorderLayout.EAST );
			 panel2.add( new JButton( "West" ), BorderLayout.WEST );
			panel2.add( new JButton( "Center" ), BorderLayout.CENTER );
			 }

			 public void createPage3()
			 {
			 panel3= new JPanel();
			 panel3.setLayout( new GridLayout(3, 2,5,5));

			 panel3.add( new JLabel( "Field 1:" ) );
			 panel3.add( new TextArea() );
			panel3.add( new JLabel( "Field 2:" ) );
			panel3.add( new TextArea() );
			panel3.add( new JLabel( "Field 3:" ) );
			 panel3.add( new TextArea() );
			 }
	private void addListener() {

		//quitting the program
		quit.addActionListener(new MyHandler());
		help.addActionListener(new MyHandler());
		about.addActionListener(new MyHandler());
		REFRESH_INTERVAL_item.addActionListener(new MyHandler());
		btnLogIn.addActionListener(new MyHandler());

	}

class MyHandler implements ActionListener{

		public void actionPerformed(ActionEvent e){
			if(e.getSource() ==quit){
				System.exit(0);
				
			}

			if(e.getSource()==about){
				JDialog aboutDialog = new JDialog();
				aboutDialog.setBounds(10,10,300,300);
				aboutDialog.setModal(true);
				aboutDialog.setVisible(true);
			}

			if(e.getSource()==help){
				 JFrame helpJFrame = new JFrame("Help");
					final JDialog helpJDialog = new JDialog(helpJFrame,"Help");
					 JTabbedPane helpTab = new JTabbedPane();
					    JPanel helpPanel = new JPanel();
			helpJDialog.getContentPane().setLayout(new BorderLayout());
					    helpPanel.add(helpTab, BorderLayout.CENTER);
				    
					 // Create the tab pages
					    createPage1();
					    createPage2();
					    createPage3();
					 
					//create a tabbed pane
					helpTab.addTab( "Page 1", panel1 );
					helpTab.addTab( "Page 2", panel2 );
					helpTab.addTab( "Page 3", panel3 );
					
					helpJDialog.setBounds(0,0,1200,600);
					helpJDialog.setModal(true);
					helpJDialog.getContentPane().add(helpPanel,BorderLayout.CENTER);
					helpJDialog.setPreferredSize(new Dimension(1000,600));
				//	helpJDialog.pack();
				   helpJDialog.setVisible(true);
					
				
				/*	JDialog helpDialog = new JDialog();	
				helpDialog.setBounds(10,10,300,300);
				helpDialog.setModal(true);
				helpDialog.setLocationRelativeTo(null);
				helpDialog.setVisible(true);*/
				}
			
			if(e.getSource()==btnLogIn){
				// if the password is right
	dispose();
	
	//	SplashScrn wait = new SplashScrn();
		Thread a = new Thread(new SplashScrn());
		a.start();
	
			
				
				
			}

			if(e.getSource()== REFRESH_INTERVAL_item){
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

}
	}
}}

