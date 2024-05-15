package com.SpringbootRest.demo.Entity;

public class StudentErrorResponse {
	
	private int code;
	
	private String massege;
	
	private long timeStamp;
	
	public StudentErrorResponse() {
		
	}

	public StudentErrorResponse(int code, String massege, long timeStamp) {
		super();
		this.code = code;
		this.massege = massege;
		this.timeStamp = timeStamp;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMassege() {
		return massege;
	}

	public void setMassege(String massege) {
		this.massege = massege;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	


}
