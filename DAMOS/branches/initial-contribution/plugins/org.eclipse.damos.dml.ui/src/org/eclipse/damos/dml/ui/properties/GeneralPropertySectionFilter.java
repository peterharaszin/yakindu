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
package org.eclipse.damos.dml.ui.properties;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.damos.dml.Component;
import org.eclipse.jface.viewers.IFilter;


public class GeneralPropertySectionFilter implements IFilter {

	public boolean select(Object toTest) {
		if (toTest instanceof Component) {
			return true;
		}
		if (toTest instanceof IAdaptable) {
			return ((IAdaptable) toTest).getAdapter(Component.class) != null;
		}
		return false;
	}

}
