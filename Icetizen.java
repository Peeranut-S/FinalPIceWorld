import iceworld.given.IcetizenLook;
import iceworld.given.MyIcetizen;


public class Icetizen implements MyIcetizen{
	

	private int portID;
	private int listeningPort;
	private String uname;
	private IcetizenLook Customization;


	@Override
	public int getIcePortID() {					//return the port ID set
		// TODO Auto-generated method stub
		return portID;
	}

	@Override
	public IcetizenLook getIcetizenLook() {			//return the look of our Icetizen
		// TODO Auto-generated method stub
		return this.Customization;
	}

	@Override
	public int getListeningPort() {
		// TODO Auto-generated method stub
		return this.listeningPort;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.uname;
	}

	@Override
	public void setIcePortID(int arg0) {
		this.portID = arg0;
		
	}

	@Override
	public void setIcetizenLook(IcetizenLook arg0) {
		this.Customization = arg0;
		
	}

	@Override
	public void setListeningPort(int arg0) {
		// TODO Auto-generated method stub
		this.listeningPort = arg0;
		
	}

	@Override
	public void setUsername(String arg0) {
		this.uname = arg0;
		
	}
	
	

}
