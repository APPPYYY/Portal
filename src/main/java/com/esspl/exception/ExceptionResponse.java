package com.esspl.exception;

import java.util.Date;

public class ExceptionResponse  {

	private Date date;
	private String message;
	private String trace;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTrace() {
		return trace;
	}
	public void setTrace(String trace) {
		this.trace = trace;
	}
	@Override
	public String toString() {
		return "ExceptionResponse [date=" + date + ", message=" + message + ", trace=" + trace + "]";
	}
	public ExceptionResponse(Date date, String message, String trace) {
		super();
		this.date = date;
		this.message = message;
		this.trace = trace;
	}
	public ExceptionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
