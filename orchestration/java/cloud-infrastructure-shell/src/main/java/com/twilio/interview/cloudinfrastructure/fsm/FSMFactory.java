package com.twilio.interview.cloudinfrastructure.fsm;

import java.util.concurrent.TimeUnit;

import com.twilio.interview.cloudinfrastructure.model.Host;
import com.twilio.interview.cloudinfrastructure.model.HostState;

public class FSMFactory {

	public static FSM makeFSM(Host host){
		
		FSM fsm = new FSM("no name");
		fsm.addState("CREATED");
		fsm.addState("BOOTING", new Runnable(){
			
			@Override
			public void run() {
				System.out.println("booting");
				host.setState(HostState.BOOTING);
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}, null, null);
		fsm.addState("RUNNING", new Runnable(){
			
			@Override
			public void run() {
				System.out.println("running");
				host.setState(HostState.RUNNING);
			}
			
		}, null, null);
		fsm.addState("SHUTTING_DOWN", new Runnable(){
			
			@Override
			public void run() {
				System.out.println("shutting down");
				host.setState(HostState.SHUTTING_DOWN);
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}, null, null);
		fsm.addState("SHUTDOWN", new Runnable(){
			
			@Override
			public void run() {
				System.out.println("shut down");
				host.setState(HostState.SHUTDOWN);
			}
			
		}, null, null);
		fsm.setAutoTransition("BOOTING", "RUNNING");
		fsm.setAutoTransition("SHUTTING_DOWN", "SHUTDOWN");
		
		fsm.addTransition(new FSM.Transition("BOOT", "CREATED", "BOOTING"));
		fsm.addTransition(new FSM.Transition("SHUTDOWN", "RUNNING", "SHUTTING_DOWN"));
		
		return fsm;
		
	}
	
}
