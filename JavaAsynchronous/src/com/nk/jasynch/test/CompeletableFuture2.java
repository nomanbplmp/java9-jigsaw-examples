package com.nk.jasynch.test;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompeletableFuture2 {
public static void main(String[] args) throws InterruptedException, ExecutionException {
	CompletableFuture<String> cfOne =	CompletableFuture.supplyAsync(()-> "one");
	System.out.println(cfOne.get());
}
}
