package org.eclipselabs.damos.simulation.ide.ui.internal.statushandlers;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.IStatusHandler;
import org.eclipse.ui.statushandlers.StatusManager;

public class GenericStatusHandler implements IStatusHandler {

	public Object handleStatus(IStatus status, Object source) throws CoreException {
		StatusManager.getManager().handle(status, StatusManager.SHOW);
		return null;
	}

}
