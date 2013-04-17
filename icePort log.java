import iceworld.given.ICEWorldImmigration;

//============================================================================================
//============================================================================================


//NOTED LOGIN AS  			User     : Peeranut.S  
//							Password : 6113503   to make it works
//else really have to remove the ... relay to server for paintTalk method and paintYell


//cant manage to get them to work as any password will fix it soon for presentation instead. 



//============================================================================================
//============================================================================================
public class icePort extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnLogIn,bAlien;
	public static ICEWorldImmigration immigration;
	public static MyIcetizen tester; 
	String password, username;
	Audio bgm;

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
		myImage = ImageIO.read(new File("ice3.jpg"));
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
		
		
		tester = new MyIcetizen();
		tester.setIcePortID(254);
		tester.setUsername("Peeranut.S");
		tester.setListeningPort(12345);
		IcetizenLook look = new IcetizenLook();
		look.gidB = "B001";
		look.gidS = "S001";
		look.gidH = "H001";
		look.gidW = "W001";
		immigration = new ICEWorldImmigration(tester);
	
		bgm = new Audio("bgm3.wav");
		
	}
	
	public ICEWorldImmigration getICEWorld(){
		return this.immigration;
	}

	public MyIcetizen getIcetizen(){
		return this.tester;
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
				
				if (immigration.login("6113503"))
				{
					JOptionPane.showMessageDialog(null,"Login Success");
					bgm.stop();
					
				dispose();

				SplashScrn wait = new SplashScrn();
				Thread a = new Thread(wait);
				a.start();
					System.out.println("Login OK");
			
	
				}			else{
					JOptionPane.showMessageDialog(null,"Login Failed please re-enter your ID/Password");
							
					}
					 
				 textField.setText("");
			passwordField.setText("");
			textField.requestFocus();   //move cursor back to username field
			
		
			}
			
			
			
			if (e.getSource() == bAlien ){
				
				if (immigration.loginAlien()){
				System.out.println("Login Alien OK");
				JOptionPane.showMessageDialog(null,"Login as Alien");
				dispose();

				SplashScrn wait = new SplashScrn();
				Thread a = new Thread(wait);
				a.start();
				
				
			}
				
				
			

	
	}
}}}

