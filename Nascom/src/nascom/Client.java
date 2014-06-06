package nascom;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
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
	Logger LOGGER;

	/*
	 * Constructor
	 */
	public Client(int port) {
		this.port = port;
		this.running = true;
		this.scan = new Scanner(System.in);
	}

	public void run() {
		Thread.currentThread().setName("ClientThread");
		final Logger Log = Logger.getLogger(Nascom.class);
		
		Log.info("Client started!");
		try{  
			s = new Socket("localhost",port);  
			os = s.getOutputStream();  
			oos = new ObjectOutputStream(os);  
		}
		catch(Exception e){
			System.err.println(e);
		}


		while(running){
			message = new Message(scan.next(), 1);  
			try {
				oos.writeObject(message);
			} catch (IOException e) {
				e.printStackTrace();
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
			e.printStackTrace();
		}
		return 0;
	}

}
