package com.dg.jod.proc;

import com.dg.jod.model.Delta;

public interface IDeltaProcessor<I extends Delta,O>
{
	public O process(I delta);
}