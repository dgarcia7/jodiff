package com.dg.jod.model.tree;

public class LeafNode extends AbstractNode
{
    private Object expected = null;
    private Object actual = null;

    public LeafNode(Object expectedInput, Object actualInput, String locationInput)
    {
        super(locationInput);
        expected = expectedInput;
        actual = actualInput;
    }

    public boolean isEqual()
    {
        if(expected == null || actual == null)
        {
            if(expected == null && actual == null)
                return true;
            return false;
        }
        else
        {
            return expected.equals(actual);
        }
    }
    
    public Object getExpected()
    {
    	return expected;
    }
    
    public Object getActual()
    {
    	return actual;
    }
}