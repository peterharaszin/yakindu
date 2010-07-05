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

package org.eclipselabs.damos.diagram.ui.editparts;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.LabelDirectEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.label.ILabelDelegate;
import org.eclipse.gmf.runtime.diagram.ui.label.LabelExDelegate;
import org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager;
import org.eclipse.gmf.runtime.draw2d.ui.figures.LabelEx;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.swt.widgets.Text;

/**
 * @author Andreas Unger
 *
 */
public abstract class EditableContentComponentEditPart extends StandardComponentEditPart implements ITextAwareEditPart {

	private IParser parser;
	private TextDirectEditManager textDirectEditManager;

	/**
	 * @param view
	 */
	public EditableContentComponentEditPart(View view) {
		super(view);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.editparts.TransformableBlockEditPart#createDefaultEditPolicies()
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new LabelDirectEditPolicy());
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
	
	protected ILabelDelegate getContentLabel() {
		IFigure figure = getComponentFigure().getContentFigure();
		if (figure instanceof LabelEx) {
			return new LabelExDelegate((LabelEx) figure);
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.TopGraphicEditPart#performDirectEditRequest(org.eclipse.gef.Request)
	 */
	protected void performDirectEditRequest(final Request request) {
		try {
			getEditingDomain().runExclusive(new Runnable() {
				public void run() {
					if (isActive() && request instanceof DirectEditRequest) {
						DirectEditRequest editRequest = (DirectEditRequest) request;
						getTextDirectEditManager().show(editRequest.getLocation().getSWTPoint());
					}
				}
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private TextDirectEditManager getTextDirectEditManager() {
		if (textDirectEditManager == null) {
			textDirectEditManager = new TextDirectEditManager(this, null, new CellEditorLocator() {
	            public void relocate(CellEditor celleditor) {
	            	ILabelDelegate label = getContentLabel();
		           	if (label != null) {
		                Text text = (Text) celleditor.getControl();
		                Rectangle rect = label.getTextBounds().getCopy();
		                int minWidth = 4 * rect.height;
		                if (rect.width < minWidth) {
		                	rect.width = minWidth;
		                }
		                if (!rect.equals(new Rectangle(text.getBounds()))) {
		                    text.setBounds(rect.x, rect.y, rect.width, rect.height);
		                }
	            	}
	            }
	        });
		}
		return textDirectEditManager;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart#getCompletionProcessor()
	 */
	public IContentAssistProcessor getCompletionProcessor() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart#getEditText()
	 */
	public String getEditText() {
		return getParser().getEditString(null, 0);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart#getEditTextValidator()
	 */
	public ICellEditorValidator getEditTextValidator() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart#getParser()
	 */
	public IParser getParser() {
		if (parser == null) {
			parser = new IParser() {
	
				public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
					return null;
				}
	
				public String getEditString(IAdaptable element, int flags) {
					return getContentText();
				}
	
				public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
					return createParseCommand(element, newString, flags);
				}
	
				public String getPrintString(IAdaptable element, int flags) {
					return getEditString(element, flags);
				}
	
				public boolean isAffectingEvent(Object event, int flags) {
					return false;
				}
	
				public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
					return ParserEditStatus.EDITABLE_STATUS;
				}
				
			};
		}
		return parser;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart#getParserOptions()
	 */
	public ParserOptions getParserOptions() {
		return ParserOptions.NONE;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart#setLabelText(java.lang.String)
	 */
	public void setLabelText(String text) {
	}

	protected abstract String getContentText();
	
	protected abstract ICommand createParseCommand(IAdaptable element, String newString, int flags);
	
}
