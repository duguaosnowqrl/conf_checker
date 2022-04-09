package com.aizxue.confchecker.exception;

public class UnsupportedFieldTypeException extends Exception{
	public UnsupportedFieldTypeException() {
	}
	
	public UnsupportedFieldTypeException(String msg) {
		super(msg);
	}

	public UnsupportedFieldTypeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UnsupportedFieldTypeException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnsupportedFieldTypeException(Throwable cause) {
		super(cause);
	}
	
	
}
