package com.twilio.interview.cloudinfrastructure.model;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.twilio.interview.cloudinfrastructure.model.impl.GroupTypeImpl;

/**
 * Interface {@link GroupType} defines the contract implemented by the host
 * group type objects.
 */
@JsonDeserialize(as=GroupTypeImpl.class)
public interface GroupType extends HostType {
    /**
     * Returns host (instance) size for the group.
     * 
     * @return  host size
     */
    HostSize getSize ();

    /**
     * Returns the number of hosts (instances) for the group.
     * 
     * @return  host count
     */
    int getHostCount ();

    /**
     * Returns the flag indicating whether host group should be activated
     * (brought into the load balancer) after successful boot or not.
     * 
     * @return  activate on boot flag
     */
    boolean isActiveOnBoot ();

    /**
     * Returns the list of {@link GroupType}s the group depends on.
     * 
     * @return  group dependencies
     */
    List<GroupType> getDependencies ();
}
