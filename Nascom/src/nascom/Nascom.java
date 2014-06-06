package nascom;

import java.io.IOException;
import java.util.logging.*;

public class Nascom {
	
	static int port;
	static Handler handler;
	static String LOG_FILE_NAME = "Nascom";
		
	private final static Logger LOGGER= Logger.getLogger(Nascom.class.getName());

	private static final int LOG_SIZE = 100;
	private static final int LOG_ROTAION_COUTNTs = 100;
	
	public static void main(String[] args) {
		LOGGER.setLevel(Level.INFO);
		
		try {
			handler = new FileHandler(LOG_FILE_NAME+".log", LOG_SIZE, LOG_ROTAION_COUTNTs);
		} catch (SecurityException e1) {
			LOGGER.warning(e1.toString());
			e1.printStackTrace();
		} catch (IOException e1) {
			LOGGER.warning(e1.toString());
			e1.printStackTrace();
		}
		LOGGER.addHandler(handler);

		
		if (args.length > 0) {
		    try {
		        port = Integer.parseInt(args[0]);
		    } catch (NumberFormatException e) {
		    	
		        System.err.println("The first argument is the port and must be an integer.");
		        LOGGER.warning("invalid port");
		        LOGGER.warning(e.toString());
		        System.exit(1);
		    }
		}else{
			LOGGER.info("No startup parameters given!");
			System.out.println("Input parameters required: Port");
			System.exit(1);
		}
			
		
        /*
         * Start the server
         */
		(new Thread(new Server(port))).start();
		LOGGER.info("Server thread started!");
		
		/*
		 * Start the client
		 */
        (new Thread(new Client())).start();
        LOGGER.info("Client thread started!");
        
        return;
	}

}
