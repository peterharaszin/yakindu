package org.yakindu.sct.simulation.core.runtime;

import static org.yakindu.sct.simulation.core.launch.IStatechartLaunchParameters.CYCLE_PERIOD;
import static org.yakindu.sct.simulation.core.launch.IStatechartLaunchParameters.DEFAULT_CYCLE_PERIOD;
import static org.yakindu.sct.simulation.core.launch.IStatechartLaunchParameters.DEFAULT_IS_CYCLE_BASED;
import static org.yakindu.sct.simulation.core.launch.IStatechartLaunchParameters.IS_CYCLE_BASED;
import static org.yakindu.sct.simulation.core.launch.IStatechartLaunchParameters.OPERATION_CLASS;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.yakindu.sct.commons.WorkspaceClassLoaderFactory;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.simulation.core.runtime.impl.CycleBasedExecutionContainer;
import org.yakindu.sct.simulation.core.runtime.impl.EventDrivenExecutionContainer;

import com.google.inject.Inject;
import com.google.inject.Injector;

public class DefaultExecutionContainerFactory implements IExecutionContainerFactory {

	@Inject
	private Injector injector;

	public IExecutionContainer createExecutionContainer(Statechart statechart, ILaunch launch) throws CoreException {
		IExecutionContainer controller = null;
		boolean isCycleBased = launch.getLaunchConfiguration().getAttribute(IS_CYCLE_BASED, DEFAULT_IS_CYCLE_BASED);
		if (isCycleBased) {
			long cyclePeriod = launch.getLaunchConfiguration().getAttribute(CYCLE_PERIOD, DEFAULT_CYCLE_PERIOD);
			controller = new CycleBasedExecutionContainer(statechart, cyclePeriod);
		} else {
			controller = new EventDrivenExecutionContainer(statechart);
		}
		loadOperationObjects(launch, statechart, controller);
		injector.injectMembers(controller);
		return controller;
	}

	protected void loadOperationObjects(ILaunch launch, Statechart statechart, IExecutionContainer controller) {
		IProject project = WorkspaceSynchronizer.getFile(statechart.eResource()).getProject();
		ClassLoader classLoader = new WorkspaceClassLoaderFactory().createClassLoader(project, getClass()
				.getClassLoader());
		ILaunchConfiguration config = launch.getLaunchConfiguration();
		try {
			String classes = config.getAttribute(OPERATION_CLASS, "").trim();
			String[] split = classes.split(",");
			if (split.length > 0)
				for (String string : split) {
					string = string.trim();
					if (string.length() == 0)
						continue;
					Class<?> operationClass = classLoader.loadClass(string);
					controller.addCallbackObject(operationClass.newInstance());
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
