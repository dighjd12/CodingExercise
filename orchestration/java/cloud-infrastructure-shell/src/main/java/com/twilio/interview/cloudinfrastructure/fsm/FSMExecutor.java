package com.twilio.interview.cloudinfrastructure.fsm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FSMExecutor {

	private ExecutorService executor;
	private static FSMExecutor fsmExecutor = null;
	
	public static FSMExecutor getInstance(){
		if (fsmExecutor == null) fsmExecutor = new FSMExecutor();
		return fsmExecutor;
	}
	
	private FSMExecutor(){
		executor = Executors.newFixedThreadPool(10);
	}
	
	public void execute(FSM fsm, String event){
		executor.execute(new FSMRunnable(fsm, event));
	}
	
}
