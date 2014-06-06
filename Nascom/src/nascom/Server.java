package nascom;

public class Server implements Runnable {

	int port;
    public Server(int port) {
		this.port = port;
	}

	public void run() {
    	
    	/*
    	 * Should implement a log file writer instead of writing to the system output. 
    	 */
        System.out.println("Starting server on port: " + port);
    }

}