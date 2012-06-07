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

package org.eclipselabs.damos.diagram.ui.editparts;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.label.ILabelDelegate;

/**
 * @author Andreas Unger
 *
 */
public interface ITextualContentEditPart extends IGraphicalEditPart {

	EObject getContentElement();
	
	EStructuralFeature getContentFeature();
	
	String getContentText();

	void setContentText(String text);

	ILabelDelegate getContentLabel();
	
}
