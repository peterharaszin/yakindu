package org.yakindu.sct.simulation.core.runtime;

import static org.yakindu.sct.simulation.core.launch.IStatechartLaunchParameters.CYCLE_PERIOD;
import static org.yakindu.sct.simulation.core.launch.IStatechartLaunchParameters.DEFAULT_CYCLE_PERIOD;
import static org.yakindu.sct.simulation.core.launch.IStatechartLaunchParameters.DEFAULT_IS_CYCLE_BASED;
import static org.yakindu.sct.simulation.core.launch.IStatechartLaunchParameters.IS_CYCLE_BASED;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunch;
import org.yakindu.sct.simulation.core.debugmodel.SCTDebugTarget;
import org.yakindu.sct.simulation.core.runtime.impl.CycleBasedExecutionContainer;
import org.yakindu.sct.simulation.core.runtime.impl.EventDrivenExecutionContainer;

public class DefaultExecutionContainerFactory implements IExecutionContainerFactory {

	public IExecutionContainer createExecutionContainer(SCTDebugTarget target) throws CoreException {
		ILaunch launch = target.getLaunch();
		IExecutionContainer controller = null;
		boolean isCycleBased = launch.getLaunchConfiguration().getAttribute(IS_CYCLE_BASED, DEFAULT_IS_CYCLE_BASED);
		if (isCycleBased) {
			long cyclePeriod = launch.getLaunchConfiguration().getAttribute(CYCLE_PERIOD, DEFAULT_CYCLE_PERIOD);
			controller = new CycleBasedExecutionContainer(target, cyclePeriod);
		} else {
			controller = new EventDrivenExecutionContainer(target);
		}
		return controller;
	}

}
