package com.dg.jod;

import com.dg.jod.model.tree.ObjectDifferenceTree;
import com.dg.jod.build.TreeBuilder;
import com.dg.jod.model.tree.AbstractNode;

public class JavaObjectDifferencer<T>
{
	private TreeBuilder<T> treeBuilder = new TreeBuilder<T>();
	
    public ObjectDifferenceTree diff(T expected, T actual) throws IllegalAccessException
    {
        return new ObjectDifferenceTree(diffHelper(expected,actual));
    }

    private AbstractNode diffHelper(T expected, T actual) throws IllegalAccessException
    {
        ObjectDifferenceTree tree = treeBuilder.buildTree(expected,actual);


        return null;
    }
}