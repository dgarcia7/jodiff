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

import com.dg.jod.graph.HighLevelObject;

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
}