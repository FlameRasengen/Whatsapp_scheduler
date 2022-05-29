package com.springbbot.scheduler.Scheduler_whatsapp;

import java.util.Timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.springbbot.scheduler.Scheduler_whatsapp.timertask.CustomTimerTask;

@SpringBootApplication
@EnableScheduling
public class SchedulerWhatsappApplication {

	@Autowired
    public Timer timer;
	
	  @Autowired
	    public CustomTimerTask task;
	
	public static void main(String[] args) {
		SpringApplication.run(SchedulerWhatsappApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
   public void startScheduler()
    {
        //run a task after every 30 seconds....
        timer.schedule(task,1000,60000);

    }
}
