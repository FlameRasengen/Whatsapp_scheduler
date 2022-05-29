package com.springbbot.scheduler.Scheduler_whatsapp.services;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.springbbot.scheduler.Scheduler_whatsapp.dao.messagedao;
import com.springbbot.scheduler.Scheduler_whatsapp.entity.message;


@Service
public class messageserviceimpl implements messageservice {

	@Autowired
	private messagedao messagedao;

	@Override
	public message add_message(message message) {
		messagedao.save(message);
		return message;
	}


	@Override
	public List<message> pollMessagesFromDatabase(String time) {
		// TODO Auto-generated method stub
		List<message> messages= messagedao.findAll();
		//List<message> ms1=null;
		messages.forEach((p) -> {
          System.out.println(p.getMessage());
        });
		System.out.println("checking the query");
		List<message> ms= messagedao.getAllMessagesInOneMinute(1,time);
		ms.forEach((p) -> {
	          System.out.println(p.getMessage());
	          System.out.println("Ending the query");
	        });
		/*for( message m1: messages)
		{
			if(m1.isPending_status()==0)
			{
				ms1.add(m1);
				System.out.println("checking the query");
				System.out.println(m1.getMessage());
			}
		}*/
		return ms;
	}

	
	
	

		@Override
		public int updateMessageStatus(Integer pending_status, Boolean submited_status, String whatsAppMessageId,	LocalDateTime submitted_at, Integer message_id) {
			// TODO Auto-generated method stub
			message message= messagedao.findById(message_id).get();
			message.setWhatsapp_api_message_id(whatsAppMessageId);
			message.setPending_status(pending_status);
			message.setSubmitted_status(submited_status);
			 LocalDateTime currentLocalDateTime=submitted_at;
		        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		        String formattedDateTime = currentLocalDateTime.format(dateTimeFormatter);
		        message.setSubmitted_at(formattedDateTime);
		    	messagedao.save(message);
		    	return 1;
			
		}

		
	
	
	
	
}
