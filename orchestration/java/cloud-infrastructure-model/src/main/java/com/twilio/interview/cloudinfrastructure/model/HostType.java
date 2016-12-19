package com.twilio.interview.cloudinfrastructure.model;

import java.lang.String;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.twilio.interview.cloudinfrastructure.model.impl.HostTypeImpl;

/**
 * Interface {@link HostType} defines the contract for the HostType objects.
 */
@JsonDeserialize(as=HostTypeImpl.class)
public interface HostType {
    /**
     * Returns the host (instance) type ID.
     * 
     * @return  host type ID
     */
    String getId ();

    /**
     * Returns the host (instance) type.
     * 
     * @return  host type
     */
    String getType ();

    /**
     * Returns the host (instance) type description.
     * 
     * @return  host type description
     */
    String getDescription ();
}
