package nascom;

import org.apache.log4j.*;

public class Nascom {

	static int port;
	static Level level;
	private static String DEFAULT_LEVEL = "info";
	private static final Logger Log = Logger.getLogger(Nascom.class);
	private static final int CLIENT_PORT = 1000;
	private static final int SERVER_PORT = 1000;

	public static void main(String[] args) {

		if (args.length > 0) {
			try {
				port = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				Log.error("Invalid port! " + e);
				System.exit(1);
			}if(args.length > 1){
				level = Level.toLevel(args[1].toString());
			}else{
				level = Level.toLevel(DEFAULT_LEVEL);
			}
			Log.setLevel(level);
		}else{
			Log.error("Invalid input parameters!");
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
			Log.error(e);
		}
		return;
	}

}
