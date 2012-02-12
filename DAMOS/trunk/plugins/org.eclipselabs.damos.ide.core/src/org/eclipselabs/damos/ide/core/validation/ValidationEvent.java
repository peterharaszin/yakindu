/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.ide.core.validation;

import java.util.EventObject;
import java.util.List;

/**
 * @author Andreas Unger
 *
 */
public class ValidationEvent extends EventObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Problem> problems;
	
	/**
	 * @param source
	 */
	public ValidationEvent(Object source, List<Problem> problems) {
		super(source);
		this.problems = problems;
	}
	
	/**
	 * @return the markerDescriptors
	 */
	public List<Problem> getMarkerDescriptors() {
		return problems;
	}

}
