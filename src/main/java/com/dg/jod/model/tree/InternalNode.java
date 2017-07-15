package com.dg.jod.model.tree;

import java.util.List;
import java.util.LinkedList;

public class InternalNode extends AbstractNode
{
    private List<AbstractNode> nodes = new LinkedList<AbstractNode>();

    public InternalNode(String locationInput)
    {
        super(locationInput);
    }

    public List<AbstractNode> getNodes()
    {
        return nodes;
    }

    public void addNode(AbstractNode nodeInput)
    {
        nodes.add(nodeInput);
    }
}