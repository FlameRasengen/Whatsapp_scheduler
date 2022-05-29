package com.springbbot.scheduler.Scheduler_whatsapp.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.springbbot.scheduler.Scheduler_whatsapp.dao.UserRepository;
import com.springbbot.scheduler.Scheduler_whatsapp.entity.User;
import com.springbbot.scheduler.Scheduler_whatsapp.services.CustomUserDetailsService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class userservice {

	
	private CustomUserDetailsService service;
	@MockBean
	 private UserRepository userRepository;
	
	@BeforeEach
	void setup()
	{
		this.service= new CustomUserDetailsService(this.userRepository);
	}
	@Test
	public void testuserservice()
	{
		User user= new User();
		user.setPassword("12345");
		user.setUsername("demo");
	//	userRepository.save(user);
		Mockito.when(userRepository.findByUsername("demo")).thenReturn(user);
		 assertThat(service.loadUserByUsername("demo").getUsername()).isEqualTo(user.getUsername());
	}
}
