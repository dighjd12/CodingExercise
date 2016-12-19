package com.twilio.interview.cloudinfrastructure.manager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.interview.cloudinfrastructure.model.HostSize;
import com.twilio.interview.cloudinfrastructure.model.GroupType;
import com.twilio.interview.cloudinfrastructure.model.impl.GroupTypeImpl;

public class GroupTypeManager {
	   private static GroupTypeManager manager = null;
	   private List<GroupType> groupTypes;
	   private static String DEFAULT_PATH = "/Users/gamjatang1/desktop/twilio_temp/files/group_types.json";
	   
	   private GroupTypeManager(){
		    groupTypes = new ArrayList<GroupType>();
	   }
	
	   public static GroupTypeManager getInstance(){
		    if (manager == null) manager = new GroupTypeManager();
	        return manager;
	   }
	   
	   public List<GroupType> getGroupTypes(){
		   return groupTypes;
	   }
	   
	   public void initialize(String path){
		    ObjectMapper mapper = new ObjectMapper();
		    try {
			    groupTypes = mapper.readValue(new File(path), new TypeReference<List<GroupType>>() {});
			} catch (IOException e) {
				e.printStackTrace();
			}
	   }
	   
	   public String add(String type, String description, List<GroupType> dependencies, HostSize size, int num_hosts, boolean active_on_boot){
		   GroupType newGroup = new GroupTypeImpl(type, description, dependencies, size, num_hosts, active_on_boot);
		   groupTypes.add(newGroup);
		   updateFile(DEFAULT_PATH);
		   return newGroup.getId();
	   }
	   
	   public boolean delete(String id){
		   
		   for (GroupType groupType : groupTypes){
			   if (groupType.getId().equals(id)){
				   groupTypes.remove(groupType);
				   updateFile(DEFAULT_PATH);
				   return true;
			   }
		   }
		   return false;
	   }
	   
	   public void updateFile(String path){
		   ObjectMapper mapper = new ObjectMapper();
		    try {
			    mapper.writeValue(new File(path), groupTypes);
			} catch (IOException e) {
				e.printStackTrace();
			}
	   }
	   
	   
	
}
