import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;



public class iceMain extends JFrame{
	
		JMenuBar menuBar;
		JMenu function;
		JMenuItem help,about,quit, REFRESH_INTERVAL_item;
		JDesktopPane desktop;
		static int offsetMultiplier = 0;

		public iceMain(){
			super("icePort");
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
			icePort a = new icePort();

			 frame.add(a);

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
		    static final int xOffset = 200, yOffset = 200;

		   public MyInternalFrame() 
		    {
		        super("Untitled-"+(++openFrameCount),true,true,true,true);
		        setSize(1200,1200);
		        ++offsetMultiplier;
		        setLocation(xOffset*offsetMultiplier, yOffset*offsetMultiplier);
		    }

		}



	private void addListener() {
	/*	help.setMnemonic(KeyEvent.VK_F1);
		//accelerator() needed else setMnemonic would fire new menu as well as the menuitem wanted
		help.setAccelerator(KeyStroke.getKeyStroke
				(KeyEvent.VK_F1, ActionEvent.CTRL_MASK));
		help.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//put in the Help() 
			}
		});
		
		*/ 
		about.addActionListener(new AboutAction());
	
	
	
		//quitting the program
		quit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
			});
	
	}
	class AboutAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
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
				
			

		}
		
	
}

