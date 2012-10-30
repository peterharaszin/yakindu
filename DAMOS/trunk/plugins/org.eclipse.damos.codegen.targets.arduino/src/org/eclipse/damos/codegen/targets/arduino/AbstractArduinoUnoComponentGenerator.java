/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger. All rights reserved.
 ****************************************************************************/

package org.eclipse.damos.codegen.targets.arduino;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.damos.codegen.c.AbstractComponentGenerator;
import org.eclipse.damos.codegen.c.util.GeneratorConfigurationExtensions;
import org.eclipse.damos.dconfig.Binding;
import org.eclipse.damos.dconfig.BindingResourceSubscript;
import org.eclipse.damos.mscript.codegen.c.Include;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractArduinoUnoComponentGenerator extends AbstractComponentGenerator {

	private int pinIndex = -1;
	
	@Override
	public boolean contributesComputeOutputsCode() {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.codegen.c.AbstractComponentGenerator#getImplementationIncludes()
	 */
	@Override
	protected Collection<Include> getImplementationIncludes() {
		return Collections.singleton(new Include("Arduino.h"));
	}
	
	/**
	 * @return the pinIndex
	 */
	protected int getPinIndex() {
		if (pinIndex == -1) {
			pinIndex = 0; // default
			Binding binding = getConfiguration().getBinding(GeneratorConfigurationExtensions.TARGET_PROPERTY_PATH, getNode().getSystemPath());
			if (binding != null && binding.getTarget() != null) {
				BindingResourceSubscript subscript = binding.getTarget().getSubscript();
				if (subscript != null) {
					pinIndex = subscript.getIndex();
				}
			}
		}
		return pinIndex;
	}
	
	/**
	 * @param pinIndex the pinIndex to set
	 */
	public void setPinIndex(int pinIndex) {
		this.pinIndex = pinIndex;
	}

}