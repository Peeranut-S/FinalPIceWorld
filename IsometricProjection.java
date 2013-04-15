import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import iceworld.given.*;
import javax.swing.*;
import javax.swing.plaf.TabbedPaneUI;

import iceworld.given.ICEWorldImmigration;

public class IsometricProjection extends JFrame{
	JButton zoomIn,zoomOut,chat,yell,custom,sound,logout;
	//double i=1;
	private    JTabbedPane tabbedPane;
	private    JPanel    panel1;
	private    JPanel    panel2;
	private    JPanel    panel3;
	//MyIcetizen ice = new MyIcetizen();
	//ICEWorldImmigration immigrate = new ICEWorldImmigration(ice);
	
	IsometricShow iso;
	JTextField chatBox;
	private JMenuBar menuBar;
private JMenuItem help,about,quit, REFRESH_INTERVAL_item;
private JPanel mini;

	public static void main(String[] a) throws IOException{
		IsometricProjection mainFrame = new IsometricProjection();
	}
	public IsometricProjection() throws IOException{
		super("My Frame");
		this.setBackground(Color.WHITE);
		iso = new  IsometricShow();


		this.setLayout(null);
		iso.setBounds(0,0,1000,600);
		this.add(iso);
		mini = new JPanel();
		mini.setBounds(1000,0,400,250);
		mini.setBackground(Color.BLACK);
		this.add(mini);
		//JEditorPane htmlP = new JEditorPane();
		//htmlP.setPage((TabbedPane.class.getResource("mini.html")));
		//htmlP.setBounds(1000,0,300,300);
		//this.add(htmlP);
	      
createGUI();
	}
		

public void createGUI(){
	

JPanel panel_1 = new JPanel();   //panel for various option
		panel_1.setBounds(1000,300,300,410);
		panel_1.setBackground(Color.DARK_GRAY);
		this.add(panel_1);
		panel_1.setLayout(null);

		JLabel opt = new JLabel("Options");
		opt.setBounds(1075,225,200,100);
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
		this.add(menuBar);
		setJMenuBar(menuBar);


		JMenu mntmAboutWindow = new JMenu("File");
		menuBar.add(mntmAboutWindow);

		about = new JMenuItem("About");
		mntmAboutWindow.add(about);


		help = new JMenuItem("Help(F1)");
		mntmAboutWindow.add(help);

		REFRESH_INTERVAL_item = new JMenuItem("Refresh Interval");
		mntmAboutWindow.add(REFRESH_INTERVAL_item);

		quit= new JMenuItem("Quit");
		mntmAboutWindow.add(quit);
		addListener();

	}

	private void addListener() {

		help.addActionListener(new MyHandler());
		about.addActionListener(new MyHandler());
		logout.addActionListener(new MyHandler());
		quit.addActionListener(new MyHandler());
		sound.addActionListener(new MyHandler());
		chat.addActionListener(new MyHandler());
		yell.addActionListener(new MyHandler());
		custom.addActionListener(new MyHandler());
	}
	
	public void createPage1()
	{
		panel1 = new JPanel();
	    panel1.setVisible(true);
	    panel1.setBackground(new Color(250,251,253)); 
	    try {
	      JEditorPane htmlPane = new JEditorPane();
	      htmlPane.setPage(TabbedPane.class.getResource("index.html"));
	      htmlPane.setEditable(false);
	      JScrollPane scrollpane = new JScrollPane(htmlPane);
	      panel1.add(scrollpane);
	      //File file1= new File("path of the file");
	      //htmlPane.setPage(TabbedPane.class.getResource("index.html"));
	      //htmlPane.setEditable(false);
	      //panel1.add(new JScrollPane(htmlPane));
	    } catch(IOException ioe) {
	      System.err.println("Error displaying file");
	    }
	}

	public void createPage2()
	{
		panel2 = new JPanel();
	    panel2.setVisible(true);
	    panel2.setBackground(new Color(250,251,253)); 
	    try {
	      JEditorPane htmlPane2 = new JEditorPane();
	      htmlPane2.setPage(TabbedPane.class.getResource("index2.html"));
	      htmlPane2.setEditable(false);
	      JScrollPane scrollpane = new JScrollPane(htmlPane2);
	      panel2.add(scrollpane);
	      //File file1= new File("path of the file");
	      //htmlPane.setPage(TabbedPane.class.getResource("index.html"));
	      //htmlPane.setEditable(false);
	      //panel1.add(new JScrollPane(htmlPane));
	    } catch(IOException ioe) {
	      System.err.println("Error displaying file");
	    }
	}

	public void createPage3()
	{
		panel3 = new JPanel();
	    panel3.setVisible(true);
	    panel3.setBackground(new Color(250,251,253)); 
	    try {
	      JEditorPane htmlPane3 = new JEditorPane();
	      htmlPane3.setPage(TabbedPane.class.getResource("index3.html"));
	      htmlPane3.setEditable(false);
	      JScrollPane scrollpane = new JScrollPane(htmlPane3);
	      panel3.add(scrollpane);
	      //File file1= new File("path of the file");
	      //htmlPane.setPage(TabbedPane.class.getResource("index.html"));
	      //htmlPane.setEditable(false);
	      //panel1.add(new JScrollPane(htmlPane));
	    } catch(IOException ioe) {
	      System.err.println("Error displaying file");
	    }
	}

	class MyHandler implements ActionListener{


		public void actionPerformed(ActionEvent e){

			if(e.getSource() ==quit){
				String message = "Are you sure you want to exit the ICEWORLD?";
				int rep = JOptionPane.showConfirmDialog(null, message,"Confirmation", JOptionPane.YES_NO_OPTION);

				if (rep == JOptionPane.YES_OPTION)
				{
					System.exit(0);
				}
			}
			if(e.getSource()==about){
				JFrame aboutDialog = new JFrame();
				aboutDialog.setSize(1450, 1450);
				aboutDialog.setTitle("aboutDialog");
				//aboutDialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


				ImageIcon info = new ImageIcon("/Users/ZethaRia/Desktop/about.jpg");

				JLabel n = new JLabel(info);

				aboutDialog.add(n);
				aboutDialog.setVisible(true);
			}

				if(e.getSource()==help){
					JFrame helpDialog = new JFrame();
					helpDialog.setSize(1000, 1000);
					helpDialog.setTitle("HelpDialog");
					helpDialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

					//setTitle( "Tabbed Pane Application" );
					//setSize( 500, 500 );
					//setBackground( Color.gray );


					//JPanel topPanel = new JPanel();
					//topPanel.setLayout( new BorderLayout() );
					//getContentPane().add( topPanel );

					// Create the tab pages
					createPage1();
					createPage2();
					createPage3();

					// Create a tabbed pane
					tabbedPane = new JTabbedPane();
					tabbedPane.addTab( "Page 1", panel1 );
					tabbedPane.addTab( "Page 2", panel2 );
					tabbedPane.addTab( "Page 3", panel3 );
					helpDialog.add( tabbedPane, BorderLayout.CENTER );
					helpDialog.setVisible(true);
					}
					
					if(e.getSource()==custom){
						try {
							Customization cus = new Customization();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
			
			if(e.getSource()==logout){
				//logout
				int reply = JOptionPane.showConfirmDialog(null, 
						"Do you want to log out from ICEWORLD?", "ICEWORLD", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (reply == JOptionPane.YES_OPTION)
					//do log out
					System.exit(0);
			}


			if(e.getSource()==sound){

				soundSetting test= new soundSetting();

			}

			/*if(e.getSource()==yell){
				 //String getTxt = chatBox.getText();
				 
				 mainFrame.add(new JComponent() {
			            public void paintComponent(Graphics g) {

			                // Some parameters.
			            	String text = chatBox.getText();
			                int centerX = 150, centerY = 100;
			                int ovalWidth = 200, ovalHeight = 100;

			                // Draw oval
			                g.setColor(Color.BLUE);
			                g.fillOval(centerX-ovalWidth/2, centerY-ovalHeight/2,
			                           ovalWidth, ovalHeight);

			                // Draw centered text
			                FontMetrics fm = g.getFontMetrics();
			                double textWidth = fm.getStringBounds(text, g).getWidth();
			                g.setColor(Color.WHITE);
			                g.drawString(text, (int) (centerX - textWidth/2),
			                                   (int) (centerY + fm.getMaxAscent() / 2));

			            }
			        });
				   
				  
			}

			if(e.getSource()==about){
				JFrame aboutDialog = new JFrame();
				aboutDialog.setSize(1000, 1000);
				aboutDialog.setTitle("aboutDialog");
				aboutDialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				//gonna put some pic instead of spongebob
				ImageIcon info = new ImageIcon("about.jpg");
				
				JLabel n = new JLabel(info);
				//aboutDialog.setSize(500, 500);
				
				aboutDialog.add(n);
				aboutDialog.setVisible(true);
			}
			if(e.getSource()==chat){
				String getTxt = chatBox.getText();
				 
				int messageType = JOptionPane.PLAIN_MESSAGE;
 
				JOptionPane.showMessageDialog(null, getTxt, "Java Programming Forums!!", messageType);
			}*/
			}
	}
}
