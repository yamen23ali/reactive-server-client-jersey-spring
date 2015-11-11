package com.example.utils;

import rx.Observable.OnSubscribe;
import rx.Subscriber;

public class MyOnSubscribe< T > implements OnSubscribe< T >
{
	String param = "";

	public MyOnSubscribe( String param )
	{
		this.param = param;
	}

	@Override
	public void call( Subscriber< ? super T > observer )
	{
		try
		{
			System.out.println( "In Thread : " + Thread.currentThread().getName()  );
			
			if ( param.equals( "Safaa" ) )
			{
				Thread.sleep( 5000 );
			}
			else
			{
				Thread.sleep( 10000 );
			}
		}
		catch ( InterruptedException e )
		{
			e.printStackTrace();
		}

		observer.onNext( (T) param );
		observer.onCompleted();
	}
}
