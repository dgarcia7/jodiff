package com.dg.jod;

import java.util.LinkedList;
import java.util.List;

import com.dg.jod.build.TreeBuilder;
import com.dg.jod.model.Delta;
import com.dg.jod.model.tree.ObjectDifferenceTree;
import com.dg.jod.proc.DeltaToStringProcessor;
import com.dg.jod.proc.IDeltaProcessor;
import com.dg.jod.traverse.AbstractTraversal;
import com.dg.jod.traverse.DiffTraversal;

public class JavaObjectDifferencer<T>
{
	private TreeBuilder<T> treeBuilder = new TreeBuilder<T>();
	private AbstractTraversal<List<Delta>> traversal = new DiffTraversal();
	private IDeltaProcessor<Delta,String> deltaProcessor = new DeltaToStringProcessor();
	
	public ObjectDifferenceTree diffToTree(T expected, T actual) throws IllegalAccessException
	{
		return treeBuilder.buildTree(expected,actual);
	}
	
	public List<Delta> diffToDeltas(T expected, T actual) throws IllegalAccessException
	{
		ObjectDifferenceTree tree = diffToTree(expected,actual);
		return traversal.traverse(tree);
	}
	
    public List<String> diffToStrings(T expected, T actual) throws IllegalAccessException
    {
    	List<String> results = new LinkedList<String>();
    	List<Delta> deltas = diffToDeltas(expected,actual);
    	for(Delta delta : deltas)
    	{
    		String result = deltaProcessor.process(delta);
    		results.add(result);
    	}
    	return results;
    }
}