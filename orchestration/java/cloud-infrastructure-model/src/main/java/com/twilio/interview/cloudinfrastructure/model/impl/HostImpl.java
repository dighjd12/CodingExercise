package com.twilio.interview.cloudinfrastructure.model.impl;

import java.util.UUID;

import com.twilio.interview.cloudinfrastructure.fsm.FSM;
import com.twilio.interview.cloudinfrastructure.fsm.FSMExecutor;
import com.twilio.interview.cloudinfrastructure.fsm.FSMFactory;
import com.twilio.interview.cloudinfrastructure.model.Host;
import com.twilio.interview.cloudinfrastructure.model.HostSize;
import com.twilio.interview.cloudinfrastructure.model.HostState;

public class HostImpl implements Host {

	private String id;
	private String type;
	private String description;
	private HostSize size;
	private boolean active;
	private String groupID;
	private HostState state;
	private FSM fsm;
	
	public HostImpl(){
		
	}
	
	public HostImpl(String type, String description, HostSize size){
		this.id = UUID.randomUUID().toString();
		this.type =type;
		this.description = description;
		this.size = size;
		this.active = false;
		this.groupID = null;
		this.state = HostState.CREATED;
		this.fsm = FSMFactory.makeFSM(this);
	}
	
    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public HostSize getSize() {
        return size;
    }

    @Override
    public HostState getState() {
        return state;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void boot() throws IllegalStateException {
        if (state != HostState.CREATED && state != HostState.RUNNING){
        	throw new IllegalStateException();
        }
        
        FSMExecutor.getInstance().execute(fsm, "BOOT");
        
    }

    @Override
    public void activate() throws IllegalStateException {
    	if (state != HostState.RUNNING){
        	throw new IllegalStateException();
        }
        
        active = true;
    }

    @Override
    public void deactivate() throws IllegalStateException {
    	if (state != HostState.RUNNING){
        	throw new IllegalStateException();
        }
        
        active = false;

    }

    @Override
    public void shutdown() throws IllegalStateException {
    	if (state != HostState.RUNNING){
        	throw new IllegalStateException();
        }
        
        FSMExecutor.getInstance().execute(fsm, "SHUTDOWN");

    }

	@Override
	public void setState(HostState state) {
		this.state = state;
	}

}
