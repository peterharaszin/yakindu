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

package org.eclipselabs.damos.common.ui.viewers;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipselabs.damos.dml.Fragment;

/**
 * @author Andreas Unger
 *
 */
public class FragmentLabelProvider extends LabelProvider {

	public String getText(Object element) {
		if (element instanceof Fragment) {
			return ((Fragment) element).getName();
		}
		return element.toString();
	}

}
