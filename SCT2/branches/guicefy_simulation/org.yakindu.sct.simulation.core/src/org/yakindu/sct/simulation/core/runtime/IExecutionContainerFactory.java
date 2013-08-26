package org.yakindu.sct.simulation.core.runtime;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunch;
import org.yakindu.sct.model.sgraph.Statechart;

import com.google.inject.ImplementedBy;

@ImplementedBy(DefaultExecutionContainerFactory.class)
public interface IExecutionContainerFactory {

	public IExecutionContainer createExecutionContainer(Statechart statechart, ILaunch launch) throws CoreException;
}
