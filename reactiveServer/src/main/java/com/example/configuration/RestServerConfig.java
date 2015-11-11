package com.example.configuration;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.example.utils.ExampleEndpoint;

@Configuration
@ApplicationPath( "/api" )
public class RestServerConfig
    extends ResourceConfig
{
    @PostConstruct
    public void init()
    {
        register(ExampleEndpoint.class);
    }
}
