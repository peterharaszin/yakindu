/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger. All rights reserved.
 ****************************************************************************/

package org.eclipselabs.damos.codegen.targets.arduino;

import java.util.Collection;
import java.util.Collections;

import org.eclipselabs.damos.codegen.c.AbstractComponentGenerator;
import org.eclipselabs.damos.mscript.codegen.c.Include;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractArduinoUnoComponentGenerator extends AbstractComponentGenerator {

	private final int pinIndex;

	/**
	 * 
	 */
	public AbstractArduinoUnoComponentGenerator(int pinIndex) {
		this.pinIndex = pinIndex;
	}

	@Override
	public boolean contributesComputeOutputsCode() {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.AbstractComponentGenerator#getImplementationIncludes()
	 */
	@Override
	protected Collection<Include> getImplementationIncludes() {
		return Collections.singleton(new Include("Arduino.h"));
	}
	
	/**
	 * @return the pinIndex
	 */
	protected int getPinIndex() {
		return pinIndex;
	}

}