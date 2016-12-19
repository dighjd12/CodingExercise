package com.twilio.interview.cloudinfrastructure.model.impl;

import java.util.List;

import com.twilio.interview.cloudinfrastructure.model.GroupType;
import com.twilio.interview.cloudinfrastructure.model.HostSize;

public class GroupTypeImpl extends HostTypeImpl implements GroupType {

    @Override
    public HostSize getSize() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getHostCount() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isActiveOnBoot() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<GroupType> getDependencies() {
        // TODO Auto-generated method stub
        return null;
    }

}
