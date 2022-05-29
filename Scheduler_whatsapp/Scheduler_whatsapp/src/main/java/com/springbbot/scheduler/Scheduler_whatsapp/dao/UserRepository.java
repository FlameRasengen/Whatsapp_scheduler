package com.springbbot.scheduler.Scheduler_whatsapp.dao;

import com.springbbot.scheduler.Scheduler_whatsapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    //username , it will return the user of given username
    public User findByUsername(String username);
}

