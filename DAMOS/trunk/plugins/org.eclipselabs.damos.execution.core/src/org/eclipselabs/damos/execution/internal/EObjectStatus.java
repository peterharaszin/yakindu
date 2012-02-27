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

package org.eclipselabs.damos.execution.internal;

import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.damos.execution.ExecutionCorePlugin;
import org.eclipselabs.damos.execution.IEObjectStatus;

/**
 * @author Andreas Unger
 *
 */
public class EObjectStatus extends Status implements IEObjectStatus {

	private EObject eObject;
	
	/**
	 * 
	 */
	public EObjectStatus(int severity, EObject eObject, String message) {
		super(severity, ExecutionCorePlugin.PLUGIN_ID, message);
		this.eObject = eObject;
	}

	public EObject getEObject() {
		return eObject;
	}

}
