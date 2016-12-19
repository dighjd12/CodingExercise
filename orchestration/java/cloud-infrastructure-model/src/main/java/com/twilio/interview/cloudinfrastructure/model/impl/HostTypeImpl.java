package com.twilio.interview.cloudinfrastructure.model.impl;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.twilio.interview.cloudinfrastructure.model.HostSize;
import com.twilio.interview.cloudinfrastructure.model.HostType;

public class HostTypeImpl implements HostType {

	private String id;
	private String type;
	private String description;
	@JsonProperty("size")
	private HostSize size;
	
	public HostTypeImpl(){
		
	}
	
	public HostTypeImpl(String type, String description, HostSize size){
		this.id = UUID.randomUUID().toString();
		this.type =type;
		this.description = description;
		this.size = size;
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

}
