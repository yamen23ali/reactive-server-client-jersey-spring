package com.example.utils;

import javax.ws.rs.container.AsyncResponse;
import rx.Subscriber;

public class MySubscriber extends Subscriber
{
	AsyncResponse asyncResponse;
	
	public MySubscriber( AsyncResponse asyncResponse )
	{
		this.asyncResponse = asyncResponse;
		
	}

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
		System.out.println( "We are in Thread:  " + Thread.currentThread().getName() );
		
		asyncResponse.resume( "Hello from the other side ( "+ object.toString() + " )");
	}

}
