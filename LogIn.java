import iceworld.given.ICEWorldImmigration;

import javax.swing.*;

//combine with the Log in GUI later in the action listener part.......

public class LogIn {
	JTextField username;
	JPasswordField password;
	JButton Login,LoginAlien;
	IceWorldImmigration immigration;
	Icetizen user;
	
	public LogIn() {
		user = new Icetizen();
		user.setIcePortID(250);
		user.setListeningPort(12345);
		ICEWorldImmigration immigration = new ICEWorldImmigration(user);
		// check with the listener : which type of log in is chosen
	}
	public void LogInAlien(){
		if(immigration.loginAlien()){
			//user can login as Alien. Switch to ICEPort
		}else{
			System.out.println("Login as Alien : Error");
		}
	}
	public void LogIn(){
		String us = username.getText();
		char[] pw = password.getPassword();
		String pass="";
		for(int i=0;i<pw.length;i++){
			pass = pass+pw[i];
		}
		user.setUsername(us);
		if(immigration.login(pass)){
			//username and password is correct. Switch to ICEPort
		}else{
			System.out.println("Login Error : Username or Password incorrect");
		}
	}
}
