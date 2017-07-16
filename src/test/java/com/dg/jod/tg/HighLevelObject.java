package com.dg.jod.tg;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement public class HighLevelObject
{
	private MidLevelObject midLevelObject = new MidLevelObject();
	private Integer integerObject = Integer.valueOf(111);
	private int integerPrimitive = 112;
	private String string = "high";
	private List<MidLevelObject> listMidLevelObjects = new LinkedList<MidLevelObject>();
	private List<Integer> listIntegers = new LinkedList<Integer>();

	public HighLevelObject()
	{
		listMidLevelObjects.add(new MidLevelObject());
		listMidLevelObjects.add(new MidLevelObject());
		listMidLevelObjects.add(new MidLevelObject());
		listIntegers.add(Integer.valueOf(997));
		listIntegers.add(Integer.valueOf(998));
		listIntegers.add(Integer.valueOf(999));
	}
	
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
	public MidLevelObject getMidLevelObject() {
		return midLevelObject;
	}
	public void setMidLevelObject(MidLevelObject midLevelObject) {
		this.midLevelObject = midLevelObject;
	}
	public List<MidLevelObject> getListMidLevelObjects() {
		return listMidLevelObjects;
	}

	public void setListMidLevelObjects(List<MidLevelObject> listMidLevelObjects) {
		this.listMidLevelObjects = listMidLevelObjects;
	}

	public List<Integer> getListIntegers() {
		return listIntegers;
	}

	public void setListIntegers(List<Integer> listIntegers) {
		this.listIntegers = listIntegers;
	}
}