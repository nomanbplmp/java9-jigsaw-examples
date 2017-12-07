package com.nk.jasynch.test;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

public class CFWithJavaFunction {
public static void main(String[] args) {
	CompletableFuture<Object> cf = new CompletableFuture<>();
    Function<String, String> f = new Function<String, String>() {
		@Override
		public String apply(String arg0) {
			// TODO Auto-generated method stub
			return "hello";
		}
	}; 
	
	cf.complete(f.apply(""));

	try {
		
		System.out.println(cf.get());
	
	} catch (InterruptedException | ExecutionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
