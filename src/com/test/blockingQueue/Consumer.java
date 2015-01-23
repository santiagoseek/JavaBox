package com.test.blockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {

	private BlockingQueue<String> queue;
	
	public Consumer(BlockingQueue<String> queue){
		this.queue = queue;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Consumer thread start...");
		boolean isRunning = true;
		try{
			while(isRunning){
				System.out.println("consumer data from queue......");
				String data = queue.poll(2,TimeUnit.SECONDS);
				if(null != data){
					System.out.println("get the data:" + data);
					System.out.println("consumer the data:" + data);
					Thread.sleep(3000);
				}else{
					isRunning = false;
				}
			}
		}catch(InterruptedException e){
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}finally{
			System.out.println("Consumer thread end...");
		}

	}

}
