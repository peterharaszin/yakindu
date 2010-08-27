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

package org.eclipselabs.damos.evaluation.internal;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.evaluation.EvaluationPlugin;
import org.eclipselabs.damos.evaluation.IEvaluationStatus;

/**
 * @author Andreas Unger
 *
 */
public class EvaluationMultiStatus extends MultiStatus implements IEvaluationStatus {

	private Component component;
	
	/**
	 * 
	 */
	public EvaluationMultiStatus(Component component, IStatus[] newChildren) {
		this(component, newChildren, "Evaluating component '" + component.getName() + "' failed");
	}
	
	/**
	 * 
	 */
	public EvaluationMultiStatus(Component component, IStatus[] newChildren, String message) {
		super(EvaluationPlugin.PLUGIN_ID, 0, newChildren, message, null);
		this.component = component;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IEvaluationStatus#getComponent()
	 */
	public Component getComponent() {
		return component;
	}

}
