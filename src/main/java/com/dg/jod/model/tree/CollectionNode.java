package com.dg.jod.model.tree;

import java.util.Map;
import java.util.HashMap;

public class CollectionNode extends AbstractNode
{
    private Map<Integer,AbstractNode> map = new HashMap<Integer,AbstractNode>();

    public CollectionNode(String locationInput)
    {
        super(locationInput);
    }

    public void addIndex(Integer index, AbstractNode node)
    {
        map.put(index,node);
    }

    public AbstractNode getIndex(Integer index)
    {
        return map.get(index);
    }
}