package com.dg.jod.build;

import com.dg.jod.model.tree.AbstractNode;
import com.dg.jod.model.tree.InternalNode;
import com.dg.jod.model.tree.LeafNode;
import com.dg.jod.model.tree.CollectionNode;
import com.dg.jod.model.tree.ObjectDifferenceTree;
import com.dg.jod.model.ComparablePackages;
import com.dg.jod.build.CollectionUtil;
import java.lang.reflect.Field;
import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class TreeBuilder<T>
{
    private ComparablePackages comparablePackages = new ComparablePackages();

    public ObjectDifferenceTree buildTree(T expected, T actual) throws IllegalAccessException
    {
        String objectName = ObjectUtil.getObjectName(expected);
        AbstractNode root = buildNode(expected,actual,objectName);
        ObjectDifferenceTree tree = new ObjectDifferenceTree(root);
        return tree;
    }

    public AbstractNode buildNode(T expected, T actual, String location) throws IllegalAccessException
    {
        return buildNodeHelper(expected,actual,location);
    }

    private AbstractNode buildNodeHelper(Object expected, Object actual, String location) throws IllegalAccessException
    {
        if(expected != null && actual != null)
        {
            Class<?> clazz = expected.getClass();
            if(CollectionUtil.isCollection(expected.getClass()))
            {
                CollectionNode node = new CollectionNode(location);
                Collection<?> expectedCollection = (Collection<?>)expected;
                Collection<?> actualCollection = (Collection<?>)actual;
                Iterator<?> expectedIterator = expectedCollection.iterator();
                Iterator<?> actualIterator = actualCollection.iterator();
                long maxSize = CollectionUtil.findLargestCollectionSize(expectedCollection,actualCollection);
                for(int c = 0; c < maxSize; c++)
                {
                	Object expectedElement = null;
                	Object actualElement = null;
                	if(expectedIterator.hasNext())
                		expectedElement = expectedIterator.next();
                	if(actualIterator.hasNext())
                		actualElement = actualIterator.next();
                	AbstractNode indexNode = buildNodeHelper(expectedElement,actualElement,location+"["+c+"]");
                    node.addIndex(c,indexNode);
                }
                return node;
            }
            else if(comparablePackages.isComparable(clazz))
            {
                return new LeafNode(expected,actual,location);
            }
            else
            {
                List<Field> fields = ObjectUtil.buildFieldList(clazz);
                InternalNode internalNode = new InternalNode(location);
                for(Field field : fields)
                {
                    field.setAccessible(true);
                    Object expectedInternal = field.get(expected);
                    Object actualInternal = field.get(actual);
                    AbstractNode node = buildNodeHelper(expectedInternal,actualInternal,location+"."+field.getName());
                    internalNode.addNode(node);
                }
                return internalNode;
            }
        }
        else
        {
            return new LeafNode(expected,actual,location);
        }
    }
}