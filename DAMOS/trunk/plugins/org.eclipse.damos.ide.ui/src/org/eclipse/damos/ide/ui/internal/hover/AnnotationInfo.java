/*******************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Andreas Unger - initial API and implementation
 *******************************************************************************/
package org.eclipse.damos.ide.ui.internal.hover;

import java.util.List;

import org.eclipse.damos.ide.core.validation.Problem;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.text.IInformationControl;

/*
 * Classes of this package have been copied from other Eclipse projects like Jface and Xtext,
 * since only parts of the required classes are public API.
 * 
 * TODO: Clean-up this code
 */

public class AnnotationInfo {

	public final List<Problem> resourceProblems;
	public final List<Problem> liveProblems;
	
	public AnnotationInfo(List<Problem> resourceProblems, List<Problem> liveProblems) {
		this.resourceProblems = resourceProblems;
		this.liveProblems = liveProblems;
	}

	/**
	 * Adds actions to the given toolbar.
	 *
	 * @param manager the toolbar manager to add actions to
	 * @param infoControl the information control
	 */
	public void fillToolBar(ToolBarManager manager, IInformationControl infoControl) {
	}

}
