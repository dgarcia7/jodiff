package com.dg.jod.traverse;

import java.util.LinkedList;
import java.util.List;

import com.dg.jod.model.Delta;
import com.dg.jod.model.tree.AbstractNode;
import com.dg.jod.model.tree.LeafNode;
import com.dg.jod.model.tree.ObjectDifferenceTree;

public class DiffTraversal extends AbstractTraversal<List<Delta>>
{
	public List<Delta> traverse(ObjectDifferenceTree tree)
	{
		List<Delta> deltas = new LinkedList<Delta>();
		traverseRecursive(tree.getRootDiffNode(),0,deltas);
		return deltas;
	}
	
	protected void visit(AbstractNode node, List<Delta> result)
	{
		if(node instanceof LeafNode)
		{
			LeafNode leafNode = (LeafNode)node;
			if(!leafNode.isEqual())
			{
				result.add(new Delta(leafNode.getExpected(),leafNode.getActual(),leafNode.getLocation()));
			}
		}
	}
}