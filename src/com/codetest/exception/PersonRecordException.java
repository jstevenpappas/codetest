package com.codetest.exception;

public class PersonRecordException extends Exception {

	/**
	 * Custom Exception to wrap exceptions and, therefore,
	 * decouple calling methods from implementation
	 * (e.g., if service method is calling a DAO method
	 * and the DAO throws FileNotFound now but later the 
	 * DAOImpl changes implementation from File access to
	 * DBMS and now throws SqlException the service interface/implementation
	 * need not change)
	 */
	private static final long serialVersionUID = 1L;

	public PersonRecordException() {
		
	}

	public PersonRecordException(String message) {
		super(message);
	}

	public PersonRecordException(Throwable cause) {
		super(cause);
	}

	public PersonRecordException(String message, Throwable cause) {
		super(message, cause);
	}

}
