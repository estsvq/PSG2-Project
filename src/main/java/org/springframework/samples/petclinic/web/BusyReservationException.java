package org.springframework.samples.petclinic.web;

public class BusyReservationException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BusyReservationException() {
		super();
	}

	public BusyReservationException(String errMessage) {
		super(errMessage);
	}

}
