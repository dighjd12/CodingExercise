package com.twilio.interview.cloudinfrastructure.shell;

import com.twilio.interview.cloudinfrastructure.manager.HostManager;
import com.twilio.interview.cloudinfrastructure.model.HostSize;

import asg.cliche.Command;

public class HostManagerShell {
	
	@Command
	public String help(){
		return "no help yet";
	}
	
	@Command
	public String boot(String id){
		boolean success = HostManager.getInstance().boot(id);
		return success ? "booting the host " + id : "failed to boot " + id;
	}
	
	@Command
	public String create(String type, String description, String size){
		HostSize hSize = HostSize.valueOf(size.toUpperCase());
		String id = HostManager.getInstance().create(type, description, hSize);
		if (id == null) return "could not create the host";
		return "created a host with id: " + id;
	}
	
	@Command
	public String activate(String id){
		boolean success = HostManager.getInstance().activate(id);
		return success ? "activating the host " + id : "failed to activate " + id;
	}
	
	@Command
	public String deactivate(String id){
		boolean success = HostManager.getInstance().deactivate(id);
		return success ? "deactivating the host " + id : "failed to deactivate " + id;
	}
	
	@Command
	public String shutdown(String id){
		boolean success = HostManager.getInstance().shutdown(id);
		return success ? "shutting the host " + id : "failed to shut down " + id;
	}
	
	@Command
	public String delete(String id){
		boolean success = HostManager.getInstance().delete(id);
		return success ? "deleted the host " + id : "failed to delete " + id;
	}
	
	@Command
	public String query(String id){
		String ans = HostManager.getInstance().query(id);
		if (ans == null) return "cannot query the host " + id;
		return "queried host has the current state " + ans;
	}
	
}
