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

package org.eclipse.damos.execution.internal;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.damos.execution.datatype.IEObjectStatus;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Andreas Unger
 *
 */
public class EObjectMultiStatus extends MultiStatus implements IEObjectStatus {

	private EObject eObject;
	
	/**
	 * 
	 */
	public EObjectMultiStatus(EObject eObject, IStatus[] newChildren, String message) {
		super(ExecutionPlugin.PLUGIN_ID, 0, newChildren, message, null);
		this.eObject = eObject;
	}

	public EObject getEObject() {
		return eObject;
	}

}
