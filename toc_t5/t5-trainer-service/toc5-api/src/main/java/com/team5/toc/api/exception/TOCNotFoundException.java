package com.team5.toc.api.exception;

/**
 * 
 * @author Anurag
 * @see 
 * @since Feb 2022
 *
 */

public class TOCNotFoundException extends Exception{

	
	private static final long serialVersionUID = 1L;
	private String message;
	
	public TOCNotFoundException() {
		this.message = "Not found!!";
	}

	public TOCNotFoundException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}
	
	
}
