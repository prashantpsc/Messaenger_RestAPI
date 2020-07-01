package org.prashant.javabrain.messenger.exception;

public class DataNotFoundException extends RuntimeException{

	//the way we map exception to repsonce jxrx to the class call exceptionmapper
	
	
	
	public DataNotFoundException(String message)
	{
		super(message);
	}
}
