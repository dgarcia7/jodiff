package com.dg.jod;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.dg.jod.tg.HighLevelObject;

public class JavaObjectDifferencerTest extends AbstractTest
{
	private JavaObjectDifferencer<HighLevelObject> objectUnderTest = new JavaObjectDifferencer<HighLevelObject>();
	
	private HighLevelObject expected = loadScenario("main.xml");
	private HighLevelObject actualNoDiff = loadScenario("main.xml");
	private HighLevelObject actualOneDiffIntObj = loadScenario("one-diff-int-obj.xml");
	
	@Test public final void testNoDiff() throws IllegalAccessException
	{
		List<String> diffs = objectUnderTest.diffToStrings(expected,actualNoDiff);
		Assert.assertNotNull(diffs);
		Assert.assertEquals(0,diffs.size());
	}
	
	@Test public final void testOneDiffIntObj() throws IllegalAccessException
	{
		List<String> diffs = objectUnderTest.diffToStrings(expected,actualOneDiffIntObj);
		Assert.assertNotNull(diffs);
		Assert.assertEquals(1,diffs.size());
		Assert.assertEquals("HighLevelObject.integerObject (class java.lang.Integer): expected=[111], actual=[119].",diffs.get(0));
	}
}