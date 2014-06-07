package nascom;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;

public class ServerConnectionHelper implements Runnable {

	private static int port;
	ServerSocket ss;
	Socket s;
	InputStream is;
	ObjectInputStream ois;
	final Logger Log = Logger.getLogger(Nascom.class);

	
	public ServerConnectionHelper(String serverPort) {
		// TODO Auto-generated constructor stub
		this.port = port;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {  
			ss = new ServerSocket(port);  
			s = ss.accept();  
			is = s.getInputStream();  
			ois = new ObjectInputStream(is);  
		}catch(Exception e){
			Log.error(e); 
		} 
		
		

	}

}
