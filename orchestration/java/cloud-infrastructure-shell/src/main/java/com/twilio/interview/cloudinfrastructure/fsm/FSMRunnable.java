package com.twilio.interview.cloudinfrastructure.fsm;

public class FSMRunnable implements Runnable {

	private FSM fsm;
	private String event;
	
	public FSMRunnable(FSM fsm, String event){
		
		this.fsm = fsm;
		this.event = event;
		
	}
	
	@Override
	public void run() {

		fsm.addEvent(event);
		
	}

	
	
}
