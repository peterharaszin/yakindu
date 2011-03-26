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

package org.eclipselabs.damos.diagram.ui.internal.editparts;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
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
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.LabelDirectEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager;
import org.eclipse.gmf.runtime.draw2d.ui.figures.LabelEx;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.swt.widgets.Text;
import org.eclipselabs.damos.dml.ActionLink;
import org.eclipselabs.damos.dml.DMLFactory;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.OpaqueConditionSpecification;

/**
 * @author Andreas Unger
 *
 */
public class ActionLinkConditionEditPart extends LabelEditPart implements ITextAwareEditPart {

	private Label conditionLabel;

	private IParser parser;
	private TextDirectEditManager textDirectEditManager;
	
	/**
	 * @param view
	 */
	public ActionLinkConditionEditPart(View view) {
		super(view);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart#createDefaultEditPolicies()
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new LabelDirectEditPolicy());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart#createFigure()
	 */
	@Override
	protected IFigure createFigure() {
		IFigure figure = super.createFigure();
		conditionLabel = new LabelEx();
		figure.add(conditionLabel);
		return figure;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart#refreshVisuals()
	 */
	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshCondition();
	}
	
	protected void refreshCondition() {
		ActionLink actionLink = (ActionLink) resolveSemanticElement();
		if (conditionLabel != null && actionLink != null) {
			if (actionLink.getCondition() != null) {
				conditionLabel.setText(actionLink.getCondition().stringCondition());
			} else {
				conditionLabel.setText("default");
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart#handleNotificationEvent(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	protected void handleNotificationEvent(Notification notification) {
		if (notification.getFeature() == DMLPackage.eINSTANCE.getActionLink_Condition()) {
			refreshCondition();
		} else {
			super.handleNotificationEvent(notification);
		}
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
		           	if (conditionLabel != null) {
		                Text text = (Text) celleditor.getControl();
		                Rectangle rect = conditionLabel.getTextBounds().getCopy();
		                conditionLabel.translateToAbsolute(rect);
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
					ActionLink actionLink = (ActionLink) resolveSemanticElement();
					if (actionLink != null) {
						if (actionLink.getCondition() != null) {
							return actionLink.getCondition().stringCondition();
						} else {
							return "default";
						}
					}
					return "";
				}
	
				public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
					OpaqueConditionSpecification conditionSpecification = null;
					newString = newString.trim();
					if (!("".equals(newString) || "default".equals(newString) || "else".equals(newString))) {
						conditionSpecification = DMLFactory.eINSTANCE.createOpaqueConditionSpecification();
						conditionSpecification.setCondition(newString);
					}
					return new SetValueCommand(new SetRequest(getEditingDomain(), resolveSemanticElement(), DMLPackage.eINSTANCE.getActionLink_Condition(), conditionSpecification));
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

}
