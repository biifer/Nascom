package nascom;

import java.io.Serializable;

public class Message implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String content;
	private int seqNumber; 
	public Message(String message, int seqNumber){
		this.setMessage(message);
		this.setSeqNumber(seqNumber);
	}
	public String getMessage() {
		return content;
	}
	public void setMessage(String message) {
		this.content = message;
	}
	public int getSeqNumber() {
		return seqNumber;
	}
	public void setSeqNumber(int seqNumber) {
		this.seqNumber = seqNumber;
	}
}
