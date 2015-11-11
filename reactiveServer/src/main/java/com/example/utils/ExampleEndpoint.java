package com.example.utils;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.stereotype.Component;

import rx.Observable;

import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;


@Component
@Path( "" )
public class ExampleEndpoint
{

    @Path( "/server" )
    @GET
    @Produces( "text/plain" )
    public void stockBySimpleSku( @Suspended final AsyncResponse asyncResponse,
    		@QueryParam( value = "param" ) String param ) throws InterruptedException
    {
    	MyOnSubscribe< String > onSubscribe = new MyOnSubscribe<>( param );
    	
    	MySubscriber subscriber = new MySubscriber( asyncResponse );
    	
    	Observable.create( onSubscribe ).subscribe( subscriber );
    }
}
