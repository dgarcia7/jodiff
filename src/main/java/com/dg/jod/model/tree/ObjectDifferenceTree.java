package com.dg.jod.model.tree;

public class ObjectDifferenceTree
{
    private AbstractNode rootDiffNode = null;

    public ObjectDifferenceTree(AbstractNode diffNodeInput)
    {
        rootDiffNode = diffNodeInput;
    }

    public AbstractNode getRootDiffNode()
    {
        return rootDiffNode;
    }
}