package com.springbbot.scheduler.Scheduler_whatsapp.repo;

import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.springbbot.scheduler.Scheduler_whatsapp.dao.messagedao;
import com.springbbot.scheduler.Scheduler_whatsapp.entity.message;

@SpringBootTest
public class repotest {
	
	@Autowired
	private messagedao dao;

	@Test
	public void testgetbyeid()
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
		dao.save(message);
	//	Mockito.when(dao.save(message)).thenReturn(message);
	    
	List<message> actual= dao.getAllMessagesInOneMinute(1,null);
	//System.out.println(actual);
	actual.forEach((p) -> {
        System.out.println(p.getMessage());
        System.out.println("Ending the query");
      });
		assertThat(actual.size()).isEqualTo(1);
	}
	
}
