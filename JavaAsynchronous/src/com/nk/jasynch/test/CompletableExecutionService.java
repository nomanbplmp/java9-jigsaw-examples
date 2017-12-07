package com.nk.jasynch.test;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public interface CompletableExecutionService extends ExecutorService{
	
	@Override
	public <T> CompletableFuture<T>  submit(Callable<T> task);

	@Override
	public <T> CompletableFuture<T>  submit(Runnable task, T result);
}
