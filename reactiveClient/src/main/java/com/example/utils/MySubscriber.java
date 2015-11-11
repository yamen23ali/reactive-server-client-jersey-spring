package com.example.utils;

import javax.ws.rs.core.Response;
import rx.Subscriber;

public class MySubscriber extends Subscriber
{

	@Override
	public void onCompleted() 
	{
		System.out.println("Task Completed");
	}

	@Override
	public void onError(Throwable e) 
	{
		System.out.println("Exception in Subscriber : " + e.getMessage() );	
	}

	@Override
	public void onNext(Object object) 
	{
		Response response = (Response)object;
		
		System.out.println( "We are in Thread:  " + Thread.currentThread().getName() );
		System.out.println( "The response is: " + response.readEntity( String.class) );
	}

}
