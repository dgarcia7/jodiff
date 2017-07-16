package com.dg.jod.build;

import java.util.Collection;

public class CollectionUtil
{
    public static boolean isCollection(Class<?> clazz)
    {
        return Collection.class.isAssignableFrom(clazz);
    }
    
    public static long findLargestCollectionSize(Collection<?> ... collections)
    {
        if(collections != null)
        {
        	long longestSize = 0;
        	for(Collection<?> collection : collections)
        	{
        		if(collection.size() > longestSize)
        			longestSize = collection.size();
        	}
        	return longestSize;
        }
        return 0;
    }
}