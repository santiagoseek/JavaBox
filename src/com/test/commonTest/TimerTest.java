package com.test.commonTest;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Timer timer = new Timer();
		timer.schedule(new DateTask(), 1000, 5000);
		System.out.println("current time is:" + new Date());

		try{
			Thread.sleep(8000);
		}
		catch(InterruptedException e){
			
		}
		// timer.cancel();
	}

}

class DateTask extends TimerTask {
	public void run(){
		System.out.println("task time is: " + new Date());
	}
}
