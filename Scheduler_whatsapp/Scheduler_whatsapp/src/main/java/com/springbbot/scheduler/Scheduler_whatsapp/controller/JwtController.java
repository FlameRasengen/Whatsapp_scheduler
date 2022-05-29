package com.springbbot.scheduler.Scheduler_whatsapp.controller;


import com.springbbot.scheduler.Scheduler_whatsapp.entity.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import com.springbbot.scheduler.Scheduler_whatsapp.services.CustomUserDetailsService;
import com.springbbot.scheduler.Scheduler_whatsapp.helper.JwtUtil;
import com.springbbot.scheduler.Scheduler_whatsapp.entity.JwtRequest;

@RestController
@CrossOrigin(origins = "*")
public class JwtController {

    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {

        System.out.println("Inside Controller");
        System.out.println(jwtRequest);
        try {

            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
           
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
            throw new Exception("Bad Credentials 1");
        }catch (BadCredentialsException e)
        {
            e.printStackTrace();
            throw new Exception("Bad Credentials 2");
        }


        //fine area..
        UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());

        String token = this.jwtUtil.generateToken(userDetails);
        System.out.println("JWT " + token);

        //{"token":"value"}

        return ResponseEntity.ok(new JwtResponse(token));

    }

}
