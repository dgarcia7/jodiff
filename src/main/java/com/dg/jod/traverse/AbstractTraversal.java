package com.dg.jod.traverse;

import com.dg.jod.model.tree.AbstractNode;
import com.dg.jod.model.tree.CollectionNode;
import com.dg.jod.model.tree.InternalNode;
import com.dg.jod.model.tree.LeafNode;
import com.dg.jod.model.tree.ObjectDifferenceTree;

public abstract class AbstractTraversal<R>
{
	public abstract R traverse(ObjectDifferenceTree tree);
	protected abstract void visit(AbstractNode node, R result);

	protected void traverseRecursive(AbstractNode node, int level, R result)
	{
		if(node == null)
		{
			// skip, no way to handle null nodes
		}
		else if(node instanceof InternalNode)
		{
			InternalNode internalNode = (InternalNode)node;
			for(AbstractNode internalNodeChild : internalNode.getNodes())
			{
				//visit(internalNodeChild,result);
				traverseRecursive(internalNodeChild,level+1,result);
			}
		}
		else if(node instanceof CollectionNode)
		{
			CollectionNode collectionNode = (CollectionNode)node;
			for(int c = 0; c < collectionNode.size(); c++)
			{
				AbstractNode collectionNodeChild = collectionNode.getIndex(c);
				//visit(collectionNodeChild,result);
				traverseRecursive(collectionNodeChild,level+1,result);
			}
		}
		else if(node instanceof LeafNode)
		{
			visit(node,result);
		}
	}
}