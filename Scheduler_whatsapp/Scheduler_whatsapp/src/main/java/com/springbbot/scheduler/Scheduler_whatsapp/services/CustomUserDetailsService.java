package com.springbbot.scheduler.Scheduler_whatsapp.services;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springbbot.scheduler.Scheduler_whatsapp.dao.UserRepository;
import com.springbbot.scheduler.Scheduler_whatsapp.entity.CustomUserDetails;
import com.springbbot.scheduler.Scheduler_whatsapp.entity.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
    private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		
		final User user = this.userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found !!");
        } else {
            return new CustomUserDetails(user);
        }
		
	}

	public CustomUserDetailsService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	

}
