package com.dg.jod.build;

import org.junit.Assert;
import org.junit.Test;

import com.dg.jod.AbstractTest;
import com.dg.jod.model.tree.ObjectDifferenceTree;
import com.dg.jod.tg.HighLevelObject;

public class TreeBuilderTest extends AbstractTest
{
	private TreeBuilder<HighLevelObject> objectUnderTest = new TreeBuilder<HighLevelObject>();
	
	@Test public final void testBothNull() throws IllegalAccessException
	{
		ObjectDifferenceTree tree = objectUnderTest.buildTree(null,null);
		Assert.assertNotNull(tree);
	}
	
	@Test public final void testEqual() throws IllegalAccessException
	{
		HighLevelObject hloExpected = loadScenario("main.xml");
		HighLevelObject hloActual = loadScenario("main.xml");
		Assert.assertNotNull(hloExpected);
		Assert.assertNotNull(hloActual);
		
		ObjectDifferenceTree tree = objectUnderTest.buildTree(hloExpected,hloActual);
		Assert.assertNotNull(tree);
	}
}