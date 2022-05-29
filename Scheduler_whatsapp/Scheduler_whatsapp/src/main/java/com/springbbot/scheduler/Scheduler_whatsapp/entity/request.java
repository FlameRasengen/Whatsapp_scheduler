package com.springbbot.scheduler.Scheduler_whatsapp.entity;
import java.util.regex.*;

public class request {
	
	private String message;
	private String phone_number;
	private String scheduled_time;
	
	public request(String msg, String phn, String schd_time) {
		super();
		this.setMessage(msg);
		this.setPhone_number(phn);
		this.setScheduled_time(schd_time);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getScheduled_time() {
		return scheduled_time;
	}

	public void setScheduled_time(String scheduled_time) {
		this.scheduled_time = scheduled_time;
	}
	@Override
	public String toString() {
		return "request [message=" + message + ", phone_number=" + phone_number + ", scheduled_time=" + scheduled_time
				+ "]";
	}
	
	

}
