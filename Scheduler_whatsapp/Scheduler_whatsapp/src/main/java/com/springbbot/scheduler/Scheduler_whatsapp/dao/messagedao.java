package com.springbbot.scheduler.Scheduler_whatsapp.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.springbbot.scheduler.Scheduler_whatsapp.entity.message;


public interface messagedao extends JpaRepository<message, Integer>{

	//@Query(value="SELECT * FROM message WHERE pending_status=?1 and scheduled_at<=?2", nativeQuery=true)
	@Query(value="SELECT * FROM message WHERE pending_status=?1 ", nativeQuery=true)
	public List<message>getAllMessagesInOneMinute(Integer m,String time);
	
}
