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

package org.eclipse.damos.ide.ui.internal.directedit;

import org.eclipse.damos.diagram.ui.editparts.ITextualContentEditPart;
import org.eclipse.damos.diagram.ui.tools.IValueSpecificationDirectEditHelper;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.label.ILabelDelegate;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Text;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class ValueSpecificationDirectEditHelper implements IValueSpecificationDirectEditHelper {

	@Inject
	private ValueSpecificationDirectEditPolicy directEditPolicy;
	
	private TextDirectEditManager textDirectEditManager;

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.tools.IValueSpecificationDirectEditHelper#createDefaultEditPolicies(org.eclipse.damos.diagram.ui.editparts.IEditableContentEditPart)
	 */
	public void createDefaultEditPolicies(ITextualContentEditPart editPart) {
		editPart.installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, directEditPolicy);
	}
	
	public void performDirectEditRequest(final ITextualContentEditPart editPart, final Request request) {
		try {
			editPart.getEditingDomain().runExclusive(new Runnable() {
				
				public void run() {
					if (editPart.isActive() && request instanceof DirectEditRequest) {
						DirectEditRequest editRequest = (DirectEditRequest) request;
						getTextDirectEditManager(editPart).show(editRequest.getLocation().getSWTPoint());
					}
				}
				
			});
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	private TextDirectEditManager getTextDirectEditManager(final ITextualContentEditPart editPart) {
		if (textDirectEditManager == null) {
			textDirectEditManager = new TextDirectEditManager(editPart, new CellEditorLocator() {
				
	            public void relocate(CellEditor celleditor) {
		           	ILabelDelegate label = editPart.getContentLabel();
					if (label != null) {
		                Rectangle rect = label.getTextBounds().getCopy();
		                int minWidth = 4 * rect.height;
		                if (rect.width < minWidth) {
		                	rect.width = minWidth;
		                }
		                Text text = (Text) celleditor.getControl();
		                if (!rect.equals(new Rectangle(text.getBounds()))) {
		                    text.setBounds(rect.x, rect.y, rect.width, rect.height);
		                }
	            	}
	            }
	            
	        });
		}
		return textDirectEditManager;
	}

}
