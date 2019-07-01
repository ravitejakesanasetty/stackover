package com.pawana.stack.post.util;

import java.util.Date;

public class Status {
	private String statusCode;
	private Date timeStamp;
	
	public Status() {
		super();
		this.statusCode = "success";
		this.timeStamp = new Date();
	}
	
	public Status(String statusCode, Date timeStamp) {
		super();
		this.statusCode = statusCode;
		this.timeStamp = timeStamp;
	}

	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
	
}
