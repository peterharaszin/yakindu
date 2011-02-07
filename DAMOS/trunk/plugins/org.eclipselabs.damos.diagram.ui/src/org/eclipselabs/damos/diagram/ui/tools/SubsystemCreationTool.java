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

package org.eclipselabs.damos.diagram.ui.tools;

import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.tools.CreationTool;
import org.eclipselabs.damos.diagram.core.type.ElementTypes;
import org.eclipselabs.damos.dml.SystemInterface;

/**
 * @author Andreas Unger
 *
 */
public class SubsystemCreationTool extends CreationTool {

	private SystemInterface providedInterface;
	
	/**
	 * 
	 */
	public SubsystemCreationTool(SystemInterface providedInterface) {
		super(ElementTypes.SUBSYSTEM);
		this.providedInterface = providedInterface;
	}
	
	@SuppressWarnings("unchecked")
	protected Request createTargetRequest() {
		Request request = super.createTargetRequest();
		request.getExtendedData().put(SystemInterface.class, providedInterface);
		return request;
	}

}
