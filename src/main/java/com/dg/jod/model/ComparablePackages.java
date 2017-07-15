package com.dg.jod.model;

import java.util.List;
import java.util.LinkedList;

public class ComparablePackages
{
    private List<String> comparablePackages = new LinkedList<String>();

    public ComparablePackages()
    {
        comparablePackages.add("java.");
    }

    public void addPackage(String pkg)
    {
        comparablePackages.add(pkg);
    }

    public boolean isComparable(Class<?> clazz)
    {
        for(String comp : comparablePackages)
        {
            if(clazz.getName().startsWith(comp))
                return true;
        }
        return false;
    }
}