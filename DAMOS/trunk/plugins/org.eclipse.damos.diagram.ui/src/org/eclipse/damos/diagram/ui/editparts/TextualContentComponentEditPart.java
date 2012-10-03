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

package org.eclipse.damos.diagram.ui.editparts;

import org.eclipse.damos.diagram.ui.tools.IValueSpecificationDirectEditHelper;
import org.eclipse.damos.dml.ui.registry.UIInjectorProviderRegistry;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.label.ILabelDelegate;
import org.eclipse.gmf.runtime.diagram.ui.label.LabelExDelegate;
import org.eclipse.gmf.runtime.draw2d.ui.figures.LabelEx;
import org.eclipse.gmf.runtime.notation.View;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Andreas Unger
 *
 */
public abstract class TextualContentComponentEditPart extends StandardComponentEditPart implements ITextualContentEditPart {

	@Inject
	private IValueSpecificationDirectEditHelper directEditHelper;
	
	private ILabelDelegate contentLabel;

	/**
	 * @param view
	 */
	public TextualContentComponentEditPart(View view) {
		super(view);
		Injector injector = UIInjectorProviderRegistry.getInstance().getInjector(view.getElement());
		if (injector != null) {
			injector.injectMembers(this);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.editparts.TransformableBlockEditPart#createDefaultEditPolicies()
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		directEditHelper.createDefaultEditPolicies(this);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#refreshVisuals()
	 */
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshContent();
	}
	
	protected void refreshContent() {
		ILabelDelegate label = getContentLabel();
		if (label != null) {
			label.setText(getContentText());
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.TopGraphicEditPart#performDirectEditRequest(org.eclipse.gef.Request)
	 */
	protected void performDirectEditRequest(final Request request) {
		directEditHelper.performDirectEditRequest(this, request);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.editparts.ITextualContentEditPart#setContentText(java.lang.String)
	 */
	public void setContentText(String text) {
		ILabelDelegate label = getContentLabel();
		if (label != null) {
			label.setText(text);
		}
	}

	public ILabelDelegate getContentLabel() {
		if (contentLabel == null) {
			IFigure figure = getComponentFigure().getPrimaryContentFigure();
			if (figure instanceof LabelEx) {
				contentLabel = new LabelExDelegate((LabelEx) figure);
			}
		}
		return contentLabel;
	}
	
}
