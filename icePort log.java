import java.awt.BorderLayout;
<<<<<<< HEAD
import java.awt.EventQueue;
import java.awt.Graphics;
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

import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
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
	private JMenuItem help,about,quit, REFRESH_INTERVAL_item;

	// Yelling attributes
	private TextArea yellArea;
	private JButton yellButton;
	
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
		myImage = ImageIO.read(new File("/Users/ZethaRia/Desktop/PC/ice3.jpg"));
	this.setContentPane(this.new ImagePanel(myImage));
		 } catch (IOException e1) {
		// TODO Auto-generated catch block
		 e1.printStackTrace();
		  }
    setBounds(100, 100, 1300, 800);

    //setting layout
    getContentPane().setBackground(new Color(204, 255, 255));
    SpringLayout springlayout = new SpringLayout();
    getContentPane().setLayout(springlayout);
    
   //setting GUI
   JComboBox comboBox = new JComboBox();
    springlayout.putConstraint(SpringLayout.NORTH, comboBox, 236, SpringLayout.NORTH, getContentPane());
    springlayout.putConstraint(SpringLayout.WEST, comboBox, -643, SpringLayout.EAST, getContentPane());
    springlayout.putConstraint(SpringLayout.SOUTH, comboBox, 278, SpringLayout.NORTH, getContentPane());
    springlayout.putConstraint(SpringLayout.EAST, comboBox, -461, SpringLayout.EAST, getContentPane());
    comboBox.setModel(new DefaultComboBoxModel(new String[] {"Inhabitant", "Alien"}));
    getContentPane().add(comboBox);
    
    textField = new JTextField();
    springlayout.putConstraint(SpringLayout.NORTH, textField, 13, SpringLayout.SOUTH, comboBox);
    springlayout.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.WEST, comboBox);
    springlayout.putConstraint(SpringLayout.EAST, textField, 0, SpringLayout.EAST, comboBox);
    getContentPane().add(textField);
    textField.setColumns(10);
    
    passwordField = new JPasswordField();
    springlayout.putConstraint(SpringLayout.NORTH, passwordField, 15, SpringLayout.SOUTH, textField);
    springlayout.putConstraint(SpringLayout.WEST, passwordField, 0, SpringLayout.WEST, comboBox);
    springlayout.putConstraint(SpringLayout.EAST, passwordField, -5, SpringLayout.EAST, comboBox);
    getContentPane().add(passwordField);
    
    JButton btnLogIn = new JButton("Log In");
    springlayout.putConstraint(SpringLayout.NORTH, btnLogIn, 26, SpringLayout.SOUTH, passwordField);
    springlayout.putConstraint(SpringLayout.WEST, btnLogIn, 0, SpringLayout.WEST, comboBox);
    getContentPane().add(btnLogIn);
    
    JLabel lblCharacterSelection = new JLabel("Character Selection :");
    springlayout.putConstraint(SpringLayout.NORTH, lblCharacterSelection, 12, SpringLayout.NORTH, comboBox);
    springlayout.putConstraint(SpringLayout.EAST, lblCharacterSelection, -20, SpringLayout.WEST, comboBox);
    getContentPane().add(lblCharacterSelection);
    
    JLabel lblUsername = new JLabel("Username :");
    springlayout.putConstraint(SpringLayout.NORTH, lblUsername, 0, SpringLayout.NORTH, textField);
    springlayout.putConstraint(SpringLayout.EAST, lblUsername, -64, SpringLayout.WEST, textField);
    getContentPane().add(lblUsername);
    
    JLabel lblPassword = new JLabel("Password :");
    springlayout.putConstraint(SpringLayout.NORTH, lblPassword, 0, SpringLayout.NORTH, passwordField);
    springlayout.putConstraint(SpringLayout.WEST, lblPassword, 0, SpringLayout.WEST, lblUsername);
    getContentPane().add(lblPassword);
    setSize(1200,700);
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //allow closing of programme


		 menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		 function = new JMenu("File");
		menuBar.add(function);

		 REFRESH_INTERVAL_item = new JMenuItem("Refresh Interval");
		function.add(REFRESH_INTERVAL_item);

		 quit = new JMenuItem("Exit");
		function.add(quit);

		 about = new JMenu("About");
		menuBar.add(about);

		 help = new JMenu("Help (F1)");
		menuBar.add(help);
		addListener();
		
        // components used to yell
        yellArea= new TextArea("Write your yell");
    	yellButton= new JButton("Yell!");
    	yellArea.setVisible(true);
    	yellButton.setVisible(true);


	}

	class ImagePanel extends JComponent {
		  private Image image;

		public ImagePanel(Image image) {
		 this.image = image;}
		@Override

		protected void paintComponent(Graphics g){
			g.drawImage(image,0,0,null);
			yellButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{

					// Action performed to yell:
					
						String text=textArea.getText();
						textArea.setText("Write your yell!");
						Yelling yell= new Yelling(text);
						int nb_yells= yell.getNBYells();
					
						while(yell.yell_start-5000>=0 ){
							g.setColor(Color.BLACK); 
							g.fillOval(200,200,20=nb_yells*10,20=nb_yells*10);
				}
			});
			
		}
}
	/*private void addListener() {
=======
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;



public class icePort extends JFrame{
	JMenuBar menuBar;
	JMenu function;
	JMenuItem help,about,quit;
	JDesktopPane desktop;
	static int offsetMultiplier = 0;
	
	// refreshing states attributes
	int refresh_interval=10000;
	JMenuItem REFRESH_INTERVAL_item;

	public icePort(){
		super("IcePort");
		Toolkit toolkit = Toolkit.getDefaultToolkit(); // get screen size
		Dimension screensize = toolkit.getScreenSize(); // get screen size
		desktop = new JDesktopPane();
		desktop.setBackground(Color.WHITE);
		setContentPane(desktop);
		setJMenuBar(setGUI());
		setPreferredSize(screensize);
		addListener();

		desktop.setDragMode(JDesktopPane.LIVE_DRAG_MODE); 
	}


	public static void main(String[] args) 
	{

		javax.swing.SwingUtilities.invokeLater(new Runnable() 
		{
            public void run() 
            {
                createAndShowGUI();
            }
        });
	}

	//Setting of GUI to actually show the help and author
	protected JMenuBar setGUI(){

		menuBar = new JMenuBar();
		function = new JMenu("File");
		help = new JMenuItem ("Help"); // to be done by nad
		about = new JMenuItem ("About"); // to be done by chubby
		quit = new JMenuItem("Exit");
		REFRESH_INTERVAL_item= new JMenuItem("Refresh interval");

		function.add(help);
		function.addSeparator();
		function.add(about);
		function.addSeparator();
		function.add(REFRESH_INTERVAL_item);
		function.addSeparator();
		function.add(quit);
		
		help.setAccelerator(KeyStroke.getKeyStroke("F1"));

		menuBar.add(function);

		return menuBar;
	}

	// create and show GUI allowing it to close
	protected static void createAndShowGUI()
	{
		icePort initialFrame = new icePort();
		initialFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initialFrame.pack();
		initialFrame.setVisible(true);
	}


	// create the basic frame with background 
	protected void createFrame()
	{
		MyInternalFrame frame = new MyInternalFrame();
		ImageIcon image = new ImageIcon("Users/ZethaRia/Documents/Chat.jpg"); //adding the splash screen

		 frame.setFrameIcon(image);

	     frame.pack();
	    frame.setVisible(true);
        desktop.add(frame);
        try 
        {
            frame.setSelected(true);
        } 
        catch (java.beans.PropertyVetoException e) {}
	}


	// ensure that multiple frame can be created
	 	public static class MyInternalFrame extends JInternalFrame
	{
	    static int openFrameCount = 0;
	    static final int xOffset = 30, yOffset = 30;

	   public MyInternalFrame() 
	    {
	        super("Untitled-"+(++openFrameCount),true,true,true,true);
	        setSize(600,600);
	        ++offsetMultiplier;
	        setLocation(xOffset*offsetMultiplier, yOffset*offsetMultiplier);
	    }

	}



	private void addListener() {
>>>>>>> e4cf3f89af2ea9ca12815efe3b1cae9796986af5

		//quitting the program
		quit.addActionListener(new MyHandler());
		help.addActionListener(new MyHandler());
		about.addActionListener(new MyHandler());
		REFRESH_INTERVAL_item.addActionListener(new MyHandler());
		yellButtonddActionListener(new MyHandler());

	}

<<<<<<< HEAD
class MyHandler implements ActionListener{
=======
	class MyHandler extends JComponent implements ActionListener{
>>>>>>> e4cf3f89af2ea9ca12815efe3b1cae9796986af5

		public void actionPerformed(ActionEvent e){
			if(e.getSource() ==quit){
				System.exit(0);
			}

			if(e.getSource()== about){
				JDialog aboutDialog = new JDialog();
				aboutDialog.setBounds(10,10,300,300);
				aboutDialog.setVisible(true);
			}

			if(e.getSource()== help){
<<<<<<< HEAD
				JDialog helpDialog = new JDialog();	
=======
				
				/*JDialog helpDialog = new JDialog();	
>>>>>>> e4cf3f89af2ea9ca12815efe3b1cae9796986af5
				helpDialog.setBounds(10,10,300,300);
				helpDialog.setModal(true);
				helpDialog.setLocationRelativeTo(null);
				helpDialog.setVisible(true);
<<<<<<< HEAD
				}

		/*	if(e.getSource()== REFRESH_INTERVAL_item){
				// Open an internal frame when the item is selected :
				JInternalFrame RIframe = new JInternalFrame();	
				RIframe.setBounds(10,10,300,300);
				JPanel panel= (JPanel) RIframe.getContentPane();

				// In the frame, we can select the refresh interval via a combo box : 
				JTextArea text = new JTextArea("Select the refresh interval of the ICE World :"); 
				DefaultComboBoxModel mdc = new DefaultComboBoxModel(); 
				final JComboBox combo = new JComboBox();
				combo.setModel(mdc);
				combo.setBounds(new Rectangle(19, 36, 129, 23)); 

				for(int i=1; i<=10; i++){
				mdc.addElement(""+i); 
				combo.addItem(""+i); 	// adding the elements of the combo			
				}	

=======
				//  set Layout to whatever Layout Manager
			    //  flowLayout, GridLayout, etc...
			    getContentPane().setLayout(new FlowLayout());
			    JLabel label = new JLabel("Text-Only Label");
			    label.setFont(new Font("Serif", Font.PLAIN, 36));
			    getContentPane().add(label);
			    setSize(230, 230);  //  or whatever size you want
			    //  Place Frame in middle of Screen
			    setLocationRelativeTo(null);  
			    setVisible(true);*/
				JLabel label = new JLabel("<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>iceWorld Manual</title>
    <link href="css/html5reset.css" rel="stylesheet" />
    <link href="css/style.css" rel="stylesheet" />
</head>
<body>
    <header>
        <hgroup>
            <h1>Header in h1</h1>
            <h2>Subheader in h2</h2>
        </hgroup>
    </header>
    <nav>
        <ul>
            <li><a href="#">iceWorldPeek</a></li>
            <li><a href="#">icePort</a></li>
            <li><a href="#">iceWorld</a></li>
            <li><a href="#">iceWorldPeek</a></li>
            <li><a href="#">icePort</a></li>
            <li><a href="#">iceWorld</a></li>
        </ul>
    </nav>
    <section>
        <article>
            <header>
                <h1><a href="#">iceWorldPeek</a></h1>
            </header>
            <section>
                iceWorldPeek, after you run the program iceWorldPeek will check for your internet that if it is reachable or not if it is not reachable
                the program will print that it is not reachable or the server is busy but if it connectable the program will redirect you to the icePort
                windows automatically.
            </section>
        </article>
        <article>
            <header>
                <h1><a href="#">icePort</a></h1>
            </header>
            <section>
                After you are redirected to icePort windows you will see that there is a space to insert your Username and Password go ahead and enter
                if you insert the incorrect Username or Password exceeding 3 times you will be banned for 5 mins but if you insert it correctly you will
                be redirect to your iceWorld windows automatically
            </section>
        </article>
        	<article>
        	<header>
        	<h1><a href="#">iceWorld</a></h1>
        	</header>
        	<section>
        		There are many components in iceWorld start with:
        			- Weather : Once you press the button it will show a splash screen of a realtime weather in iceWorld.
        			- Profile : The profile page let you be able to customize your avatar with weapon, shield, armor, and helmet.
        			- Chat Box : See the text-bix below? Type your text and press chat the text will automatically appear above
        					your avatar head. If you press yell there will be an big size of quote box with your text inside coming 
        					on the screen.
        			- Sound : You can adjust the volume of BGM(Background Music) or SFX(Sound Effect) by scrolling the scrollbar on 
        					top right corner of the screen
    </section>
</article>
    </section>
    <aside>
        <section>
            <h1>Links</h1>
            <ul>
                <li><a href="#">Link 1</a></li>
                <li><a href="#">Link 2</a></li>
                <li><a href="#">Link 3</a></li>
            </ul>
        </section>
        <figure>
            <img width="85" height="85" 
                src=/Users/jtrnx/Desktop/AppPro/ProjMain.jpg
                alt="Play Harder Work later" />
            <figcaption>My Group</figcaption>
        </figure>
    </aside>
    <footer>Footer - Copyright 2013</footer>
</body>
</html>");
				//JTextField new_text = new JTextField("Test text");
				JDialog new_dialog = new JDialog();
				new_dialog.pack();
				new_dialog.setVisible(true);
				new_dialog.toFront();
				new_dialog.setSize(500,150);
				new_dialog.setLocation(500,500);
				new_dialog.add(label);

				}




			if(e.getSource()== REFRESH_INTERVAL_item){
				// Open an internal frame when the item is selected :
				JInternalFrame RIframe = new JInternalFrame("Setting the refresh interval", true, true, true, true);	
				RIframe.setBounds(500,100,300,300);

				JPanel panel= (JPanel) RIframe.getContentPane();

				// In the frame, we can select the refresh interval via a combo box : 
				JTextArea text = new JTextArea("Select the refresh interval of the ICE World :"); 
				final JComboBox combo = new JComboBox();
				combo.setBounds(new Rectangle(2, 2, 2, 2)); 


				for(int i=1; i<=10; i++){
					combo.addItem(i); 	// adding the elements of the combo			
				}	

>>>>>>> e4cf3f89af2ea9ca12815efe3b1cae9796986af5
				combo.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
<<<<<<< HEAD
						int new_value= (Integer) combo.getSelectedItem();
						StateFetching.setREFRESH_INTERVAL(new_value);
					}
				});


				panel.add(text, BorderLayout.CENTER);
				panel.add(combo, BorderLayout.CENTER);
				RIframe.setVisible(true);
			}	
	//	}
=======
						refresh_interval= (Integer) combo.getSelectedItem();
						StateFetching statefetching= new StateFetching();
						statefetching.setREFRESH_INTERVAL(refresh_interval);
					}
				});

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


=======
	}
}

>>>>>>> e4cf3f89af2ea9ca12815efe3b1cae9796986af5
