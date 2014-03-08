package com.js.commons.exception;

public class AuthorizationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7985986143721593740L;

	public AuthorizationException(){
		super();
	}
	
	public AuthorizationException(String msg){
		super(msg);
	}
}
