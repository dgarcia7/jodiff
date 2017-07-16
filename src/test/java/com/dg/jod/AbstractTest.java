package com.dg.jod;

import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.junit.Assert;

import com.dg.jod.model.tree.AbstractNode;
import com.dg.jod.model.tree.CollectionNode;
import com.dg.jod.model.tree.InternalNode;
import com.dg.jod.model.tree.LeafNode;
import com.dg.jod.model.tree.ObjectDifferenceTree;
import com.dg.jod.tg.HighLevelObject;

public abstract class AbstractTest
{
	private String scenarioBase = "scenario/";
	private static Logger logger = Logger.getLogger(AbstractTest.class);
	
	@SuppressWarnings("deprecation") protected HighLevelObject loadScenario(String scenarioName)
	{
		HighLevelObject hlo = null;
		try
		{
			ClassLoader classLoader = this.getClass().getClassLoader();
			String scenarioPath = scenarioBase+scenarioName;
			InputStream inputStream = classLoader.getResourceAsStream(scenarioPath);
			String xml = IOUtils.toString(inputStream);
			JAXBContext jaxbContext = JAXBContext.newInstance(HighLevelObject.class);
			StringReader stringReader = new StringReader(xml);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			hlo = (HighLevelObject)unmarshaller.unmarshal(stringReader);
		}
		catch(Exception ex)
		{
			logger.error(ex.getClass().getSimpleName() + ": " + ex.getMessage());
		}
		
		Assert.assertNotNull(hlo);
		return hlo;
	}
	
	protected void printXml(HighLevelObject hlo) throws JAXBException
	{
		JAXBContext jaxbContext = JAXBContext.newInstance(hlo.getClass());
		Marshaller marshaller = jaxbContext.createMarshaller();
		StringWriter stringWriter = new StringWriter();
		marshaller.marshal(hlo,stringWriter);
		System.out.println(stringWriter.toString());
	}
	
	protected void traverse(ObjectDifferenceTree tree)
	{
		traverse(tree.getRootDiffNode(),0);
	}
	
	protected void traverse(AbstractNode node, int level)
	{
		if(node == null)
		{
			//System.out.println(getTabs(level) + "null, dying");
		}
		else if(node instanceof InternalNode)
		{
			//System.out.println(getTabs(level) + "InternalNode - " + node.getLocation());
			InternalNode internalNode = (InternalNode)node;
			for(AbstractNode internalNodeChild : internalNode.getNodes())
			{
				traverse(internalNodeChild,level+1);
			}
		}
		else if(node instanceof CollectionNode)
		{
			//System.out.println(getTabs(level) + "CollectionNode - " + node.getLocation());
			CollectionNode collectionNode = (CollectionNode)node;
			for(int c = 0; c < collectionNode.size(); c++)
			{
				AbstractNode collectionNodeChild = collectionNode.getIndex(c);
				traverse(collectionNodeChild,level+1);
			}
		}
		else if(node instanceof LeafNode)
		{
			System.out.println(getTabs(level) + "LeafNode - " + node.getLocation());
		}
		else
		{
			System.out.println(getTabs(level) + "unknown, dying - " + node.getLocation());
		}
	}
	
	private String getTabs(int count)
	{
		StringBuilder sb = new StringBuilder();
		for(int c = 0; c < count; c++)
			sb.append("\t");
		return sb.toString();
	}
}