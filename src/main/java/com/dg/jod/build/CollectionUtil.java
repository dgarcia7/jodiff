package com.dg.jod.build;

import java.util.Collection;

public class CollectionUtil
{
    public static boolean isCollection(Class<?> clazz)
    {
        return Collection.class.isAssignableFrom(clazz);
    }
}