package com.twilio.interview.cloudinfrastructure.model.impl;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.twilio.interview.cloudinfrastructure.model.GroupType;
import com.twilio.interview.cloudinfrastructure.model.HostSize;

public class GroupTypeImpl extends HostTypeImpl implements GroupType {

	private List<GroupType> dependencies;
	private HostSize size;
	@JsonProperty("num_hosts")
	private int num_hosts;
	@JsonProperty("active_on_boot")
	private boolean active_on_boot;
	
	public GroupTypeImpl(){
		
	}
	
	public GroupTypeImpl(String type, String description, List<GroupType> dependencies, 
				HostSize size, int num_hosts, boolean active_on_boot){
		super(type, description, size);	
		this.dependencies = dependencies;
		this.size = size;
		this.num_hosts = num_hosts;
		this.active_on_boot = active_on_boot;
	}
	
    @Override
    public HostSize getSize() {
        return size;
    }

    @Override
    public int getHostCount() {
        return num_hosts;
    }

    @Override
    public boolean isActiveOnBoot() {
        return active_on_boot;
    }

    @Override
    public List<GroupType> getDependencies() {
        return dependencies;
    }

}
