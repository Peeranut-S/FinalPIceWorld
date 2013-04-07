import java.awt.BorderLayout;
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
	
	//panel for help
	private JPanel panel1;
	 private JPanel panel2;
	 private JPanel panel3;
    
	private JMenuItem quit, REFRESH_INTERVAL_item,help,about;
	private JButton btnLogIn;
	
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
    
    btnLogIn = new JButton("Log In");
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
		
		JMenu mntmAboutWindow = new JMenu("About");
		menuBar.add(mntmAboutWindow);
		
		about = new JMenuItem("About window");
		mntmAboutWindow.add(about);
		
		JMenu mntmHelpWindow  = new JMenu("Help");
		menuBar.add(mntmHelpWindow );
		
		help = new JMenuItem("Help Window(F1)");
		mntmHelpWindow .add(help);
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


	private void addListener() {


		//quitting the program
		quit.addActionListener(new MyHandler());
		help.addActionListener(new MyHandler());
		about.addActionListener(new MyHandler());
		REFRESH_INTERVAL_item.addActionListener(new MyHandler());
		yellButtonddActionListener(new MyHandler());
		btnLogIn.addActionListener(new MyHandler());


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

	class MyHandler extends JComponent implements ActionListener{


		public void actionPerformed(ActionEvent e){
			if(e.getSource() ==quit){
				System.exit(0);
			}

			if(e.getSource()== about){
				JDialog aboutDialog = new JDialog();
				aboutDialog.setBounds(10,10,300,300);
				aboutDialog.setVisible(true);
			}


			if(e.getSource()==btnLogIn){
				// if the password is right
				try {
                    new splashScr().initUI();
                    
                } catch (MalformedURLException d) {
                    d.printStackTrace();
                }
				setVisible(false);
				
				//open up iceWorld 
			}

			if(e.getSource()== help){

			 JFrame helpJFrame = new JFrame("Help");
					final JDialog helpJDialog = new JDialog(helpJFrame,"Help");
					 JTabbedPane helpTab = new JTabbedPane();
					    JPanel helpPanel = new JPanel();
			helpJDialog.setLayout(new BorderLayout());
					    helpPanel.add(helpTab, BorderLayout.CENTER);
				    
					 // Create the tab pages
					    createPage1();
					    createPage2();
					    createPage3();
					 
					//create a tabbed pane
					helpTab.addTab( "Page 1", panel1 );
					helpTab.addTab( "Page 2", panel2 );
					helpTab.addTab( "Page 3", panel3 );
					
					helpJDialog.setModal(true);
					helpJDialog.add(helpPanel,BorderLayout.CENTER);
					helpJDialog.setPreferredSize(new Dimension(1000,600));
					helpJDialog.pack();
				   helpJDialog.setVisible(true);

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

						int new_value= (Integer) combo.getSelectedItem();
						StateFetching.setREFRESH_INTERVAL(new_value);
					}
				});


				panel.add(text, BorderLayout.CENTER);
				panel.add(combo, BorderLayout.CENTER);
				RIframe.setVisible(true);
			}	
		}

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



	}
}
