package com.dg.jod.model.tree;

public abstract class AbstractNode
{
    protected String location;

    protected AbstractNode(String locationInput)
    {
        location = locationInput;
    }

    public String getLocation()
    {
        return location;
    }
}