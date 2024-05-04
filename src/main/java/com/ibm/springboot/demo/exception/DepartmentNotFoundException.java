package com.ibm.springboot.demo.exception;

public class DepartmentNotFoundException extends RuntimeException {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 2507837930604086011L;

	public DepartmentNotFoundException(String message) {
		super(message);
	}

	public DepartmentNotFoundException() {
		super();
	}
}