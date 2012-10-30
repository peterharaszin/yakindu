/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger. All rights reserved.
 ****************************************************************************/

package org.eclipse.damos.codegen.targets.arduino;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.damos.codegen.c.IComponentGenerator;
import org.eclipse.damos.codegen.c.IGeneratorContext;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractShieldGenerator implements IShieldGenerator {

	@Inject
	private Provider<DataInComponentGenerator> dataInComponentGeneratorProvider;
	
	@Inject
	private Provider<DataOutComponentGenerator> dataOutComponentGeneratorProvider;

	/* (non-Javadoc)
	 * @see org.eclipse.damos.codegen.targets.arduino.IShieldGenerator#generate(org.eclipse.damos.codegen.c.IGeneratorContext, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void generate(IGeneratorContext context, IProgressMonitor monitor) throws CoreException {
	}

	protected IComponentGenerator createDataInComponentGenerator(int pinIndex) {
		DataInComponentGenerator generator = dataInComponentGeneratorProvider.get();
		generator.setPinIndex(pinIndex);
		return generator;
	}

	protected IComponentGenerator createDataOutComponentGenerator(int pinIndex) {
		DataOutComponentGenerator generator = dataOutComponentGeneratorProvider.get();
		generator.setPinIndex(pinIndex);
		return generator;
	}

}
