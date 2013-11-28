/**
 * Copyright (c) 2006-2009 committers of mda4e and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of mda4e (http://www.mda4e.org/) - initial API and implementation
 *
 */
package org.mda4e.simulation.core.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.ui.PlatformUI;

public abstract class AbstractSimulationParameterDialog extends Dialog implements
		ISimulationParameterDialog {

	protected AbstractSimulationParameterDialog() {
		super(PlatformUI.getWorkbench().getWorkbenchWindows()[0].getShell());
	}
}
