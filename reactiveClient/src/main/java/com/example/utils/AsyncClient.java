package com.example.utils;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.rx.Rx;
import org.glassfish.jersey.client.rx.rxjava.RxObservable;
import org.glassfish.jersey.client.rx.rxjava.RxObservableInvoker;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Observer;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class AsyncClient 
{

    private String URL = "http://localhost:8005";
    private String path = "/api/server";
    
    WebTarget webTarget; 
    
    public AsyncClient()
    {
    	Client client = ClientBuilder.newClient();
    	webTarget = client.target( URL ).path( path ); 
    }
    
    public void makeCall( String param )
    {
    	Observable<Response> result = RxObservable.from (webTarget ).queryParam( "param", param ).
    			request().header("Whatever", "value").rx().get();
    	
    	
    	result.subscribeOn( Schedulers.io() );
    	
    	System.out.println( "Current Thread is : " + Thread.currentThread().getName() );
    	
    	System.out.println( "Before Subscribe ");
    	
    	result.subscribe( new MySubscriber() );
    	
    	System.out.println( "After Subscribe ");
    }
}
