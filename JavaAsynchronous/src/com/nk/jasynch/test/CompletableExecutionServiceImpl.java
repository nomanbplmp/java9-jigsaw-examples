package com.nk.jasynch.test;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class CompletableExecutionServiceImpl  extends 
	AbstractCompletableExecutionService implements CompletableExecutionService{
	
	public CompletableExecutionServiceImpl(ExecutorService es) {
		super(es);
	}
	
	@Override
	public <T> CompletableFuture<T>  submit(Callable<T> task){
		CompletableFuture<T> cf = new CompletableFuture<>();
		try {
			es.submit(()->{
				try {
					cf.complete(task.call());
				} catch (Exception e) {
					cf.completeExceptionally(e);
				}
			});
			
			cf.complete(task.call());
		} catch (Exception e) {
			cf.completeExceptionally(e);
		}
		cf.thenAccept((T)->System.out.println(""));
		return cf;
	}

	@Override
	public <T> CompletableFuture<T>  submit(Runnable task, T result){
		return null;
	}
}
