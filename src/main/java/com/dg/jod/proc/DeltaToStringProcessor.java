package com.dg.jod.proc;

import org.apache.log4j.Logger;

import com.dg.jod.model.Delta;

public class DeltaToStringProcessor implements IDeltaProcessor<Delta,String>
{
	private Logger logger = Logger.getLogger(DeltaToStringProcessor.class);
	
	public String process(Delta delta)
	{
		StringBuilder sb = new StringBuilder();
		sb.append(delta.getLocation());
		sb.append(" (");
		sb.append(delta.findClass());
		sb.append("): expected=[");
		sb.append(delta.getExpected());
		sb.append("], actual=[");
		sb.append(delta.getActual());
		sb.append("].");
		
		logger.trace(sb.toString());
		return sb.toString();
	}
}