package nascom;


public class StartServer {

	private static int SERVER_PORT;

	public static void main(String[] args) {
		
			SERVER_PORT = Integer.parseInt(args[0]);
		
		/*
		 * Start the server
		 */
        (new Thread(new Server(SERVER_PORT))).start();
        
        return;
	}

}
