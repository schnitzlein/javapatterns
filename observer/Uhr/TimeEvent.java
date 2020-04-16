package Uhr;

import java.util.Date;
import java.util.EventObject;

public abstract class TimeEvent extends EventObject{
	
	private static final long serialVersionUID = 1L;
	private Date now = new Date();
	
	
	public TimeEvent(Date source) {
		super(source);
		System.out.println("source.toString()");
	}

	
	public Date getTime(){
		return now = new Date();
	}
	
	//timer kram
	/*public TimeEvent(long delay) {
    this.delay = delay;
}*//*
	long start = 0;
	long delay;

	
	public void start() {
	    this.start = System.currentTimeMillis();
	}

	public boolean isExpired() {
	    return (System.currentTimeMillis() - this.start) > this.delay;
	}	
	  
*/
	
}//TimeEvent

  