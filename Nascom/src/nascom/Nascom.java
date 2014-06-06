package nascom;

import org.apache.log4j.Logger;
public class Nascom {

	static int port;
	private static final Logger Log = Logger.getLogger(Nascom.class);

	private static final int CLIENT_PORT = 1000;
	private static final int SERVER_PORT = 1000;

	public static void main(String[] args) {


		if (args.length > 0) {
			try {
				port = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				System.err.println("The first argument is the port and must be an integer.");
				System.exit(1);
			}
		}else{
			System.out.println("Input parameters required: Port");
			Log.warn("Input parameters required: Port");
			System.exit(1);
		}


		/*
		 * Start the server
		 */
		(new Thread(new Server(SERVER_PORT))).start();
		Log.info("Server started on port: " + SERVER_PORT);
		
		/*
		 * Start the client
		 */
		(new Thread(new Client(CLIENT_PORT))).start();
		Log.info("Client started on port: " + CLIENT_PORT);
		try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}

}
