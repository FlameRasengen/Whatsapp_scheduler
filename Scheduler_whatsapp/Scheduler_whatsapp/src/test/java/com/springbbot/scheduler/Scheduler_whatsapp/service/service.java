package com.springbbot.scheduler.Scheduler_whatsapp.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.springbbot.scheduler.Scheduler_whatsapp.dao.messagedao;
import com.springbbot.scheduler.Scheduler_whatsapp.entity.message;
import com.springbbot.scheduler.Scheduler_whatsapp.services.messageservice;



@SpringBootTest
public class service {
	
	@Autowired
	private messageservice service;
	
	@MockBean
	private messagedao dao;
	
	@Test
	public void testsave()
	{
		message message = new message();
		
		message.setMessage_id(30);
		message.setMessage("Junit Testing");
		message.setDestination_phone_number("919634822810");
		message.setScheduled_at("06:30");
		message.setClient_id(1);
		message.setPending_status(1);
		message.setCreated_at("06:20");
		message.setScheduled_status(false);
		message.setSubmitted_at(null);
		message.setSubmitted_status(false);
		message.setWhatsapp_api_message_id(null);
		
Mockito.when(dao.save(message)).thenReturn(message);
	    
	    assertThat(service.add_message(message)).isEqualTo(message);
	}
	
	@Test
	public void testfindbypendingstatus()
	{
        message message = new message();
		message.setMessage_id(30);
		message.setMessage("Junit Testing");
		message.setDestination_phone_number("919634822810");
		message.setScheduled_at("06:30");
		message.setClient_id(1);
		message.setPending_status(1);
		message.setCreated_at("06:20");
		message.setScheduled_status(false);
		message.setSubmitted_at(null);
		message.setSubmitted_status(false);
		message.setWhatsapp_api_message_id(null);
		
		message message2 = new message();
		message2.setMessage_id(31);
		message2.setMessage("Junit Testing");
		message2.setDestination_phone_number("919634822810");
		message2.setScheduled_at("06:31");
		message2.setClient_id(2);
		message2.setPending_status(1);
		message2.setCreated_at("06:21");
		message2.setScheduled_status(false);
		message2.setSubmitted_at(null);
		message2.setSubmitted_status(false);
		message2.setWhatsapp_api_message_id(null);
		
		List<message> demolist= new ArrayList<>();
		demolist.add(message);
		demolist.add(message2);
	
		
		Mockito.when(dao.getAllMessagesInOneMinute(1,"06:35")).thenReturn(demolist);
		assertThat(service.pollMessagesFromDatabase("06:35")).isEqualTo(demolist);
	}
	
	

}
