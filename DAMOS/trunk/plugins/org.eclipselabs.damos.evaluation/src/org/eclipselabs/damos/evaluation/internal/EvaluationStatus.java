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

import org.eclipse.core.runtime.Status;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.evaluation.EvaluationPlugin;
import org.eclipselabs.damos.evaluation.IEvaluationStatus;

/**
 * @author Andreas Unger
 *
 */
public class EvaluationStatus extends Status implements IEvaluationStatus {

	private Component component;
	
	/**
	 * 
	 */
	public EvaluationStatus(int severity, Component component, String message) {
		super(severity, EvaluationPlugin.PLUGIN_ID, message);
		this.component = component;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IEvaluationStatus#getComponent()
	 */
	public Component getComponent() {
		return component;
	}

}
