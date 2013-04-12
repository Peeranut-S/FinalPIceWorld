import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;

class TabbedPane
		extends 	JFrame
{
	private		JTabbedPane tabbedPane;
	private		JPanel		panel1;
	private		JPanel		panel2;
	private		JPanel		panel3;


	public TabbedPane()
	{
		// NOTE: to reduce the amount of code in this example, it uses
		// panels with a NULL layout.  This is NOT suitable for
		// production code since it may not display correctly for
		// a look-and-feel.
		
		setTitle( "Tabbed Pane Application" );
		setSize( 500, 500 );
		setBackground( Color.gray );

		JPanel topPanel = new JPanel();
		topPanel.setLayout( new BorderLayout() );
		getContentPane().add( topPanel );

		// Create the tab pages
		createPage1();
		createPage2();
		createPage3();

		// Create a tabbed pane
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab( "Page 1", panel1 );
		tabbedPane.addTab( "Page 2", panel2 );
		tabbedPane.addTab( "Page 3", panel3 );
		topPanel.add( tabbedPane, BorderLayout.CENTER );
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

    // Main method to get things started
	public static void main( String args[] )
	{
		// Create an instance of the test application
		TabbedPane mainFrame	= new TabbedPane();
		mainFrame.setVisible( true );
	}
	public static void doLoadCommand(JTextComponent textComponent,
		      String filename) {
		    FileReader reader = null;
		    try {
		      System.out.println("Loading");
		      reader = new FileReader(filename);

		      // Create empty HTMLDocument to read into
		      HTMLEditorKit htmlKit = new HTMLEditorKit();
		      HTMLDocument htmlDoc = (HTMLDocument) htmlKit
		          .createDefaultDocument();
		      // Create parser (javax.swing.text.html.parser.ParserDelegator)
		      HTMLEditorKit.Parser parser = new ParserDelegator();
		      // Get parser callback from document
		      HTMLEditorKit.ParserCallback callback = htmlDoc.getReader(0);
		      // Load it (true means to ignore character set)
		      parser.parse(reader, callback, true);
		      // Replace document
		      textComponent.setDocument(htmlDoc);
		      System.out.println("Loaded");

		    } catch (IOException exception) {
		      System.out.println("Load oops");
		      exception.printStackTrace();
		    } finally {
		      if (reader != null) {
		        try {
		          reader.close();
		        } catch (IOException ignoredException) {
		        }
		      }
		    }
		  }
}