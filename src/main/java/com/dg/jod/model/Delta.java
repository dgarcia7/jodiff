package com.dg.jod.model;

public class Delta
{
	protected Object expected = null;
	protected Object actual = null;
	protected String location = null;;
	
	public Delta(Object expectedInput, Object actualInput, String locationInput)
	{
		expected = expectedInput;
		actual = actualInput;
		location = locationInput;
	}
	
	public String getLocation()
	{
		return location;
	}
	
	public Object getExpected()
	{
		return expected;
	}
	
	public Object getActual()
	{
		return actual;
	}
	
	public Class<?> findClass()
	{
		if(expected != null)
			return expected.getClass();
		else if(actual != null)
			return actual.getClass();
		return null;
	}
}