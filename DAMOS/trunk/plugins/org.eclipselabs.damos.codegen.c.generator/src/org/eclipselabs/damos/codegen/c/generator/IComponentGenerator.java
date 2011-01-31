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

package org.eclipselabs.damos.codegen.c.generator;

import java.io.Writer;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.execution.engine.IComponentSignature;

/**
 * @author Andreas Unger
 *
 * @noextend
 * @noimplement This interface is <em>not</em> intended to be implemented by
 * clients. Clients should extend {@link AbstractComponentGenerator}.
 */
public interface IComponentGenerator {

	IGeneratorContext getContext();

	void setContext(IGeneratorContext context);

	Component getComponent();
	
	void setComponent(Component component);
	
	IComponentSignature getSignature();
	
	void setSignature(IComponentSignature signature);

	void initialize() throws CoreException;
	
	boolean contributesContextCode();
	
	void generateContextCode(Writer writer, String typeName, IProgressMonitor monitor) throws CoreException;

	boolean contributesInitializationCode();
	
	void generateInitializationCode(Writer writer, IVariableAccessor variableAccessor, IProgressMonitor monitor) throws CoreException;
	
	boolean contributesComputeOutputsCode();

	void generateComputeOutputsCode(Writer writer, IVariableAccessor variableAccessor, IProgressMonitor monitor) throws CoreException;

	boolean contributesUpdateCode();

	void generateUpdateCode(Writer writer, IVariableAccessor variableAccessor, IProgressMonitor monitor) throws CoreException;

}
