package nascom;

import java.io.Serializable;
import java.net.InetAddress;

public class Message implements Serializable{

	private static final long serialVersionUID = 1L;
	private String content;
	private int seqNumber; 
	private String message;
	private InetAddress sourceAddr, destAddr;  
	
	public Message(String message, int seqNumber){
		this.setMessage(message);
		this.setSeqNumber(seqNumber);
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the seqNumber
	 */
	public int getSeqNumber() {
		return seqNumber;
	}

	/**
	 * @param seqNumber the seqNumber to set
	 */
	public void setSeqNumber(int seqNumber) {
		this.seqNumber = seqNumber;
	}

	/**
	 * @return the sourceAddr
	 */
	public InetAddress getSourceAddr() {
		return sourceAddr;
	}

	/**
	 * @param sourceAddr the sourceAddr to set
	 */
	public void setSourceAddr(InetAddress sourceAddr) {
		this.sourceAddr = sourceAddr;
	}

	/**
	 * @return the destAddr
	 */
	public InetAddress getDestAddr() {
		return destAddr;
	}

	/**
	 * @param destAddr the destAddr to set
	 */
	public void setDestAddr(InetAddress destAddr) {
		this.destAddr = destAddr;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
