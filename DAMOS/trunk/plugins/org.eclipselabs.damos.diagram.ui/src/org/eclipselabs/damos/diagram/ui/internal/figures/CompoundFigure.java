/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.diagram.ui.internal.figures;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;

/**
 * @author Andreas Unger
 *
 */
public abstract class CompoundFigure extends NodeFigure {

	/**
	 * 
	 */
	public CompoundFigure() {
		ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
		layout.setStretchMinorAxis(true);
		setLayoutManager(layout);
		setPreferredSize(new Dimension(4000, 3000));
	}
	
}
