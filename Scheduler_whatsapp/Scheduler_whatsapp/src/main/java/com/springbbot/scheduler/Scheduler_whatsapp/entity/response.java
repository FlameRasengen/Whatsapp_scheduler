package com.springbbot.scheduler.Scheduler_whatsapp.entity;

public class response {
	String code;
	String details;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public response(String code, String details) {
		super();
		this.code = code;
		this.details = details;
	}
	public response() {
		super();
		// TODO Auto-generated constructor stub
	}

}
