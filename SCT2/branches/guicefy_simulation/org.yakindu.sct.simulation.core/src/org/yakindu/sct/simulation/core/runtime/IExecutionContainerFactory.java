package org.yakindu.sct.simulation.core.runtime;

import org.eclipse.core.runtime.CoreException;
import org.yakindu.sct.simulation.core.debugmodel.SCTDebugTarget;

import com.google.inject.ImplementedBy;

@ImplementedBy(DefaultExecutionContainerFactory.class)
public interface IExecutionContainerFactory {

	public IExecutionContainer createExecutionContainer(SCTDebugTarget target) throws CoreException;
}
