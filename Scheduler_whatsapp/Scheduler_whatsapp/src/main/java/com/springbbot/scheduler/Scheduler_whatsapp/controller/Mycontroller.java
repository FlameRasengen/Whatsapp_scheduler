package com.springbbot.scheduler.Scheduler_whatsapp.controller;

 
import java.text.SimpleDateFormat;
import com.springbbot.scheduler.Scheduler_whatsapp.entity.response;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbbot.scheduler.Scheduler_whatsapp.entity.message;
import com.springbbot.scheduler.Scheduler_whatsapp.entity.request;
import com.springbbot.scheduler.Scheduler_whatsapp.services.messageservice;

@RestController
public class Mycontroller {
	
	@Autowired
	private messageservice messageservice;
	private message message= new message();
	
	@PostMapping("/message")
	public response add_message(@RequestBody request mesage_request)
	{  
		request r1= mesage_request;
		
		if(isphonenumbervalid(r1.getPhone_number())&& isValidTime(r1.getScheduled_time())&&(!r1.getMessage().isEmpty()))
		{message.setMessage(r1.getMessage());
		message.setDestination_phone_number(r1.getPhone_number());
		message.setScheduled_at(r1.getScheduled_time());
		message.setClient_id(1);
		message.setPending_status(1);
		 SimpleDateFormat sdf= new SimpleDateFormat("HH:mm");
			Date date =new Date();
			Calendar cl = Calendar. getInstance();
	        cl.setTime(date);
	        cl.add(Calendar.MINUTE,1);
	        date=cl.getTime();
			String  s=sdf.format(date);
		message.setCreated_at(s);
		message.setScheduled_status(false);
		message.setSubmitted_at(null);
		message.setSubmitted_status(false);
		message.setWhatsapp_api_message_id(null);
		//return  this.messageservice.add_message(message);
		messageservice.add_message(message);
	//	messageservice.pollMessagesFromDatabase("22:15");
		
		return new response("200","Message scheduled Successfully");
		}
		else
		{return new response("406","Invalid credentials");}
		
		
		
		//String s1=r1.getMsg();
		//message.setMessage(s1);
		
		
		
	}

	public boolean isphonenumbervalid(String phone_number )
	{
		return phone_number.charAt(0)=='9'&& phone_number.charAt(1)=='1'&& phone_number.length()==12 && phone_number.matches("[0-9]+");
	}
	public boolean isValidTime(String schd_time)
	{
		  String regex = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
		  Pattern p = Pattern.compile(regex);
		  if (schd_time == null) {
	            return false;
	        }
		  Matcher m = p.matcher(schd_time);
		  return m.matches();
		
	}
	}
	


