package com.dg.jod.graph;

public class MidLevelObject
{
	private LowLevelObject lowLevelObject = new LowLevelObject();
	private Integer integerObject = Integer.valueOf(11);
	private int integerPrimitive = 12;
	private String string = "mid";
	
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	public int getIntegerPrimitive() {
		return integerPrimitive;
	}
	public void setIntegerPrimitive(int integerPrimitive) {
		this.integerPrimitive = integerPrimitive;
	}
	public Integer getIntegerObject() {
		return integerObject;
	}
	public void setIntegerObject(Integer integerObject) {
		this.integerObject = integerObject;
	}
	public LowLevelObject getLowLevelObject() {
		return lowLevelObject;
	}
	public void setLowLevelObject(LowLevelObject lowLevelObject) {
		this.lowLevelObject = lowLevelObject;
	}
}