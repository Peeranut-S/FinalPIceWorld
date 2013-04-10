import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JLabel;
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
	int refresh_interval=1;
	JMenuItem REFRESH_INTERVAL_item;
	StateFetching statefetching;

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
		statefetching= new StateFetching();

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
		function.add(quit);
		function.add(REFRESH_INTERVAL_item);

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

		//quitting the program
		quit.addActionListener(new MyHandler());
		help.addActionListener(new MyHandler());
		about.addActionListener(new MyHandler());
		REFRESH_INTERVAL_item.addActionListener(new MyHandler());

	}

	class MyHandler extends JComponent implements ActionListener{

		public void actionPerformed(ActionEvent e){
			if(e.getSource() ==quit){
				System.exit(0);
			}

			if(e.getSource()== about){
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

			if(e.getSource()== help){
				
				JDialog helpDialog = new JDialog();	
				helpDialog.setBounds(10,10,300,300);
				helpDialog.setModal(true);
				helpDialog.setLocationRelativeTo(null);
				helpDialog.setVisible(true);
				//  set Layout to whatever Layout Manager
			    //  flowLayout, GridLayout, etc...
			    getContentPane().setLayout(new FlowLayout());
			    JLabel label = new JLabel("Text-Only Label");
			    label.setFont(new Font("Serif", Font.PLAIN, 36));
			    getContentPane().add(label);
			    setSize(230, 230);  //  or whatever size you want
			    //  Place Frame in middle of Screen
			    setLocationRelativeTo(null);  
			    setVisible(true);
			/*	JLabel label = new JLabel("<!DOCTYPE html>
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
</html>");*/
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
				
				combo.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						refresh_interval= (Integer) combo.getSelectedItem();
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




	}
}