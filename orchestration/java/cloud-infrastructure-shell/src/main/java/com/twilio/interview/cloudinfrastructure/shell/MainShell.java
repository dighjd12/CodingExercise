package com.twilio.interview.cloudinfrastructure.shell;

import java.io.IOException;

import com.twilio.interview.cloudinfrastructure.manager.HostTypeManager;
import com.twilio.interview.cloudinfrastructure.model.HostSize;

import asg.cliche.Command;
import asg.cliche.Shell;
import asg.cliche.ShellDependent;
import asg.cliche.ShellFactory;

public class MainShell implements ShellDependent{

	private Shell shell;

    // to get the shell field set
    public void cliSetShell(Shell shell) {
        this.shell = shell;
    }
    
    @Command
    public String help() {
    	StringBuilder sb = new StringBuilder();
    	sb.append("inithosts [path]                         -- initializes host types");
    	sb.append("addhosttypes [type] [description] [size] -- adds new host type");
    	sb.append("removehosttypes [id]                     -- removes host type by id");
    	sb.append("host                                     -- begins host management shell");
    	sb.append("group                                    -- begins group management shell");
    	return sb.toString();
    }
    
    @Command
    public void inithosts(String path){
    	HostTypeManager.getInstance().initialize(path);
    }
    
    @Command
    public String addhosttypes(String type, String description, String size){
    	HostSize hSize = HostSize.valueOf(size.toUpperCase());
    	String id = HostTypeManager.getInstance().add(type, description, hSize);
    	return "successfully created type with id: " + id;
    }
    
    @Command
    public String removehosttypes(String id){
    	boolean success = HostTypeManager.getInstance().delete(id);
    	return success ? "successfully deleted type " : "failed to delete " + id;
    }
    
    @Command
    public void initgroups(String path){
    	
    }
    
    @Command
    public void host() throws IOException {
        ShellFactory.createSubshell("host", shell, "Host Manager", new HostManagerShell())
                .commandLoop();
    }
    
    @Command
    public void group() throws IOException {
        ShellFactory.createSubshell("group", shell, "Host Group Manager", new GroupManagerShell())
                .commandLoop();
    }
    
	
}
