package com.twilio.interview.cloudinfrastructure.manager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.interview.cloudinfrastructure.model.HostSize;
import com.twilio.interview.cloudinfrastructure.model.HostType;
import com.twilio.interview.cloudinfrastructure.model.impl.HostTypeImpl;

public class HostTypeManager {

	   private static HostTypeManager manager = null;
	   private List<HostType> hostTypes;
	   private static String DEFAULT_PATH = "/Users/gamjatang1/desktop/twilio_temp/files/host_types.json";
	   
	   private HostTypeManager(){
		    hostTypes = new ArrayList<HostType>();
	   }
	
	   public static HostTypeManager getInstance(){
		    if (manager == null) manager = new HostTypeManager();
	        return manager;
	   }
	   
	   public List<HostType> getHostTypes(){
		   return hostTypes;
	   }
	   
	   public void initialize(String path){
		    ObjectMapper mapper = new ObjectMapper();
		    try {
			    hostTypes = mapper.readValue(new File(path), new TypeReference<List<HostType>>() {});
			} catch (IOException e) {
				e.printStackTrace();
			}
	   }
	   
	   public String add(String type, String description, HostSize hostSize){
		   HostType newHost = new HostTypeImpl(type, description, hostSize);
		   hostTypes.add(newHost);
		   updateFile(DEFAULT_PATH);
		   return newHost.getId();
	   }
	   
	   public boolean delete(String id){
		   
		   for (HostType hostType : hostTypes){
			   if (hostType.getId().equals(id)){
				   hostTypes.remove(hostType);
				   updateFile(DEFAULT_PATH);
				   return true;
			   }
		   }
		   return false;
	   }
	   
	   public void updateFile(String path){
		   ObjectMapper mapper = new ObjectMapper();
		    try {
			    mapper.writeValue(new File(path), hostTypes);
			} catch (IOException e) {
				e.printStackTrace();
			}
	   }
	   
	   
	
	
}
