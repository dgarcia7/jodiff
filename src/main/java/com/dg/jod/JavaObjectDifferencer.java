package com.dg.jod;

import com.dg.jod.model.tree.ObjectDifferenceTree;
import com.dg.jod.model.tree.AbstractNode;
import java.lang.reflect.Field;

public class JavaObjectDifferencer<T>
{
    public ObjectDifferenceTree diff(T expected, T actual)
    {
        return new ObjectDifferenceTree(diffHelper(expected,actual));
    }

    private AbstractNode diffHelper(T expected, T actual)
    {
        if(expected == null || actual == null)
        {
            //
        }
        else
        {
            Class<?> clazz = expected.getClass();
            Field fields[] = clazz.getDeclaredFields();
            for(Field field : fields)
            {
                field.setAccessible(true);
            }
        }




        return null;
    }
}