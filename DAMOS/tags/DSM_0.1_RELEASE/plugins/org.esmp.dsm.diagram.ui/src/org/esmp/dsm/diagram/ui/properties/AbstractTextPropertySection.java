/****************************************************************************
 * Copyright (c) 2008, 2009 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.esmp.dsm.diagram.ui.properties;

import org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractBasicTextPropertySection;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Composite;
import org.esmp.dsm.diagram.ui.internal.util.PropertySectionUtil;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractTextPropertySection extends AbstractBasicTextPropertySection {

	protected int calculateMinimumLabelWidth(GC gc) {
		return PropertySectionUtil.calculateMinimumLabelWidth(gc);
	}

	protected int getStandardLabelWidth(Composite parent, String[] labels) {
		GC gc = new GC(parent);
		return PropertySectionUtil.calculateStandardLabelWidth(gc, labels, calculateMinimumLabelWidth(gc));
	}

}
