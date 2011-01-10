/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.simulation.engine;

import org.eclipse.core.runtime.CoreException;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.execution.engine.IComponentSignature;
import org.eclipselabs.mscript.computation.engine.value.IValue;

/**
 * @author Andreas Unger
 *
 * @noextend
 * @noimplement This interface is <em>not</em> intended to be implemented by
 * clients. Clients should extend {@link AbstractComponentSimulationObject}.
 */
public interface IComponentSimulationObject {
	
	ISimulationContext getContext();

	void setContext(ISimulationContext context);

	Component getComponent();
	
	void setComponent(Component component);
	
	IComponentSignature getSignature();
	
	void setSignature(IComponentSignature signature);

	void initialize() throws CoreException;
	
	void reset() throws CoreException;

	void setInputValue(int inputIndex, int portIndex, IValue value) throws CoreException;
	
	void computeOutputValues() throws CoreException;

	IValue getOutputValue(int outputIndex, int portIndex) throws CoreException;
	
	void update() throws CoreException;

}
