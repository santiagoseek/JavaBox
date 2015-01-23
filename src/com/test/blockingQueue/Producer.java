package com.test.blockingQueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {
	
	private volatile boolean isRunning = true;
	private BlockingQueue queue;
	private static AtomicInteger count = new AtomicInteger();
	// private static final int DEFAULT_RANGE_FOR_SLEEF = 1000;

	public Producer(BlockingQueue queue){
		this.queue = queue;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String data = null;
		Random r = new Random();
		System.out.println("Producer thread start...");
		
		try{
			while(isRunning){
				System.out.println("Producer data......");
				Thread.sleep(3000);
				data = "data:" + count.incrementAndGet();
				System.out.println("In Queue:" + data);
				if(!queue.offer(data,2,TimeUnit.SECONDS)){
					System.out.println("In Queue fail:" + data);
				}
			}
		} catch(InterruptedException e){
			e.printStackTrace();
			Thread.currentThread().interrupt();
		} finally{
			System.out.println("Producer thread end...");
		}

	}
	
	public void stop(){
		isRunning = false;
	}

}
