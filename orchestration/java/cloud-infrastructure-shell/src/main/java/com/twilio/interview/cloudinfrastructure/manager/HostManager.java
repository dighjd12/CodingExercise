package com.twilio.interview.cloudinfrastructure.manager;

import java.util.HashMap;
import java.util.Map;

import com.twilio.interview.cloudinfrastructure.model.Host;
import com.twilio.interview.cloudinfrastructure.model.HostSize;
import com.twilio.interview.cloudinfrastructure.model.HostState;
import com.twilio.interview.cloudinfrastructure.model.impl.HostImpl;

public class HostManager {
	
	    private static HostManager manager = null;
	    private Map<String, Host> hosts;
	   
	    private HostManager(){
		    hosts = new HashMap<String,Host>();
	    }
	
	    public static HostManager getInstance(){
		    if (manager == null) manager = new HostManager();
	        return manager;
	    }
	   
	   
		public boolean boot(String id){
			Host host = hosts.get(id);
			if (host == null) return false;
			try {
				host.boot();
			} catch (IllegalStateException e){
				return false;
			}
			return true;
		}
		
		public String create(String type, String description, HostSize size){
			Host host = new HostImpl(type, description, size);
			hosts.put(host.getId(), host);
			return host.getId();
		}
		
		public boolean activate(String id){
			Host host = hosts.get(id);
			if (host == null) return false;
			try {
				host.activate();
			} catch (IllegalStateException e){
				return false;
			}
			return true;
		}
		
		public boolean deactivate(String id){
			Host host = hosts.get(id);
			if (host == null) return false;
			try {
				host.deactivate();
			} catch (IllegalStateException e){
				return false;
			}
			return true;
		}
		
		public boolean shutdown(String id){
			Host host = hosts.get(id);
			if (host == null) return false;
			try {
				host.shutdown();
			} catch (IllegalStateException e){
				return false;
			}
			return true;
		}
		
		public boolean delete(String id){
			Host host = hosts.remove(id);
			if (host == null) return false;
			return true;
		}
		
		public String query(String id){
			Host host = hosts.get(id);
			if (host == null) return null;
			if (host.getState() == HostState.RUNNING) {
				return host.getState().toString() + ", active? " + host.isActive();
			}
			return host.getState().toString();
		}

}
