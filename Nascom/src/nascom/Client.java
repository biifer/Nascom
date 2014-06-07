package nascom;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import org.apache.log4j.Logger;

/*
 * This class should at some point start a GUI
 */

public class Client implements Runnable {
	private int port;
	boolean running;
	Socket s;
	OutputStream os;
	ObjectOutputStream oos;
	Message message;
	Scanner scan;
	Logger Log;

	public Client(int port) {
		this.port = port;
		this.running = true;
		this.scan = new Scanner(System.in);
	}

	public void run() {
		Thread.currentThread().setName("ClientThread");
		Log = Logger.getLogger(Nascom.class);		
		Log.info("Client started!");
		try{  
			s = new Socket("localhost",port);  
			os = s.getOutputStream();  
			oos = new ObjectOutputStream(os);  
		}
		catch(Exception e){
			Log.trace(e);
		}


		while(running){
			message = new Message(scan.nextLine(), 1);  
			try {
				message.setSourceAddr(InetAddress.getLocalHost());
			} catch (UnknownHostException e1) {
				Log.debug(e1);
			}
			try {
				Log.debug("Sending message: " + message.getMessage());
				oos.writeObject(message);
			} catch (IOException e) {
				Log.trace(e);

			}   
		}

	}  

	public int close(){
		/*
		 * Shut down!
		 */
		running = false;
		try {
			oos.close();
			os.close();  
			s.close();
		} catch (IOException e) {
			Log.trace(e);
		}
		return 0;
	}

}
