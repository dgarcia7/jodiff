package com.dg.jod.build;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ObjectUtil
{
	public static List<Field> buildFieldList(Class<?> clazz)
    {
        List<Field> fields = new LinkedList<Field>();
        while(clazz != null)
        {
            Field fieldArray[] = clazz.getDeclaredFields();
            fields.addAll(Arrays.asList(fieldArray));
            clazz = clazz.getSuperclass();
        }
        return fields;
    }

    public static String getObjectName(Object input)
    {
        try
        {
            return input.getClass().getSimpleName();
        }
        catch(Exception ex)
        {
            return "unknown";
        }
    }
}