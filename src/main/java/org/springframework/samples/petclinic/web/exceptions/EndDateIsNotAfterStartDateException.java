package org.springframework.samples.petclinic.web.exceptions;

public class EndDateIsNotAfterStartDateException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EndDateIsNotAfterStartDateException() {
		super();
	}
	public EndDateIsNotAfterStartDateException(String errorMessage) {
		super(errorMessage);
	}

}
