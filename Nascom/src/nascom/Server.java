package nascom;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;


public class Server implements Runnable {

	int port;
	boolean running;
	String threadName;
	ServerSocket ss;
	Socket s;
	InputStream is;
	ObjectInputStream ois;
	Message message;

	public Server(int port) {
		this.port = port;
	}

	public void run() {
		Thread.currentThread().setName("ServerThread");
		final Logger Log = Logger.getLogger(Nascom.class);
		Log.info("Server thread started!");

		
		running = true;
		try {  
			ss = new ServerSocket(port);  
			s = ss.accept();  
			is = s.getInputStream();  
			ois = new ObjectInputStream(is);  
		}catch(Exception e){
			Log.error(e);
			System.out.println(e);  
		} 

		while(running){
			try {
				Log.trace("Inside server loop.");
				message = (Message)ois.readObject();
			} catch (ClassNotFoundException e) {
				Log.error(e);
			} catch (IOException e) {
				Log.error(e);
			} 
			if (message!=null){
				Log.debug("Message recvieved: " + "\'" + message.getMessage() + "\'");
				System.out.println(message.getMessage());
			} 

		}

	}

}