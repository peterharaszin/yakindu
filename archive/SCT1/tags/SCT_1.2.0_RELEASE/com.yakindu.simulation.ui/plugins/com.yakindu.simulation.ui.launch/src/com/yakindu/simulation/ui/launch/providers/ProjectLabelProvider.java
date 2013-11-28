/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package com.yakindu.simulation.ui.launch.providers;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.LabelProvider;

public class ProjectLabelProvider extends LabelProvider {
	
	public String getText(final Object element) {
		if (element instanceof IProject) {
			IProject project = (IProject) element;
			return project.getName();
		}
		return super.getText(element);
	}
} //ProjectLabelProvider