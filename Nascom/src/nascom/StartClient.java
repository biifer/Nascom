package nascom;

public class StartClient {

	private static int CLIENT_PORT;

	public static void main(String[] args) {
		
		CLIENT_PORT = Integer.parseInt(args[0]);
		
		/*
		 * Start the client
		 */
        (new Thread(new Client(CLIENT_PORT))).start();
        
        return;
	}

}
