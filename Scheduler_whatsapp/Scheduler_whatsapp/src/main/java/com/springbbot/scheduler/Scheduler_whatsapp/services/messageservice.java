package com.springbbot.scheduler.Scheduler_whatsapp.services;

import java.time.LocalDateTime;
import java.util.List;

import com.springbbot.scheduler.Scheduler_whatsapp.entity.message;

public interface messageservice {
     public message add_message(message message);
     public int updateMessageStatus(Integer pending_status , Boolean submited_status, String whatsAppMessageId, LocalDateTime submitted_at, Integer message_id);
     public List<message> pollMessagesFromDatabase(String time) ;

}
