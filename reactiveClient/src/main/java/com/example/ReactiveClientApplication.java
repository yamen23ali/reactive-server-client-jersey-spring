package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.utils.AsyncClient;

@SpringBootApplication
public class ReactiveClientApplication {

    public static void main(String[] args) 
    {
        SpringApplication.run(ReactiveClientApplication.class, args);
        
        AsyncClient caller = new AsyncClient();
       
        caller.makeCall( "Yamen");
        caller.makeCall( "Safaa");
    }
}
