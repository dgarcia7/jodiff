package com.dg.jod.tg;

public class LowLevelObject
{
	private Integer integerObject = Integer.valueOf(1);
	private int integerPrimitive = 2;
	private String string = "low";
	
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
}