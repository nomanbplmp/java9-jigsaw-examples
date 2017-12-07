package com.nk.jasynch.test;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class CFWithExecutorService {


	
	public static void main(String[] args) {
		final  ExecutorService es = Executors.newFixedThreadPool(3,new ThreadFactory() {
			
			@Override
			public Thread newThread(Runnable arg0) {
				Thread t = new Thread(arg0);
				t.setName("mythread");
				return t;
			}
		});
		  final status stat =  status.getInstance();
		 
				CompletableFuture<Void> cf = CompletableFuture.supplyAsync(()->  { printThreadName(); return "task";},es)
						.thenApplyAsync((val)-> { 
							for(int i=0;i<10;i++){
								System.out.println(1);
								CFWithExecutorService.sleep();
							} return "val of 1";},es)
						.thenApplyAsync((val)->{ for(int i=0;i<10;i++){
							System.out.println(val);
							System.out.println(2);
							CFWithExecutorService.sleep();
						} return "val2";},es)
						.thenAccept((val)-> {printThreadName();System.out.println(val); stat.done=true; });
						
			
	
		
		System.out.println("waiting");
		cf.join();
		es.shutdown();
	System.out.println("done");
	
	}

static void printThreadName(){	
	System.out.println("Thread name :: " + Thread.currentThread().getName());
}

@SuppressWarnings("static-access")
static void sleep(){	
	try {
		System.out.println("going to sleep");
		Thread.currentThread().sleep(100l);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

	
static class status {
	public boolean done;

	public static status getInstance() {
		// TODO Auto-generated method stub
		return new status();
	}
	
}





}
