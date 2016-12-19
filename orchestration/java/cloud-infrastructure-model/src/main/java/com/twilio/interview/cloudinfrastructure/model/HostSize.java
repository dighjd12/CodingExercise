package com.twilio.interview.cloudinfrastructure.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Enumeration {@link HostSize} defines available host (instance) sizes.
 */
public enum HostSize {
	@JsonProperty("small")
    SMALL,
    @JsonProperty("medium")
    MEDIUM,
    @JsonProperty("large")
    LARGE
}
