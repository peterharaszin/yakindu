/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.statechart.diagram.editparts;

import static org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.LabelDirectEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.label.ILabelDelegate;
import org.eclipse.gmf.runtime.diagram.ui.label.WrappingLabelDelegate;
import org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.viewers.ICellEditorValidator;
import org.yakindu.sct.statechart.diagram.parser.AttributeParser;

/**
 * This is a common abstract base class for all Label Edit Parts which are
 * {@link ITextAwareEditPart}.
 * 
 * 
 * @author Andreas Muelder <a
 *         href="mailto:andreas.muelder@itemis.de">andreas.muelder@itemis.de</a>
 * 
 */
public abstract class TextAwareLabelEditPart extends CompartmentEditPart
		implements ITextAwareEditPart {

	private final DirectEditManager manager;

	private final EAttribute feature;


	public TextAwareLabelEditPart(View view, EAttribute feature) {
		super(view);
		this.feature = feature;
		manager = createDirectEditManager();
	}
	
	private void updateLabelText() {
		getWrappingLabel().setText(getEditText());
	}
	
	@Override
	public void activate() {
		super.activate();
		updateLabelText();
	}

	protected DirectEditManager createDirectEditManager() {
		return new TextDirectEditManager(this);
	}
	
	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class key) {
		if(key.equals(ILabelDelegate.class)){
			WrappingLabel wrappingLabel = getWrappingLabel();
			if(wrappingLabel == null)
				return super.getAdapter(key);
			return new WrappingLabelDelegate(wrappingLabel);
		}
		return super.getAdapter(key);
	}


	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE,
				new LabelDirectEditPolicy());
		// TODO: Add a Feedback role
	}

	
	public String getEditText() {
		return getParser().getEditString(
				new EObjectAdapter(resolveSemanticElement()), -1);
	}

	
	public void setLabelText(String text) {
		getWrappingLabel().setText(text);

	}

	private WrappingLabel getWrappingLabel() {
		return (WrappingLabel) getFigure();
	}

	
	public ICellEditorValidator getEditTextValidator() {
		return null;
	}

	
	public ParserOptions getParserOptions() {
		return ParserOptions.NONE;
	}

	
	public IParser getParser() {
		return new AttributeParser(feature);
	}

	
	public IContentAssistProcessor getCompletionProcessor() {
		return null;
	}

	@Override
	protected void performDirectEditRequest(Request request) {
		final Request theRequest = request;
		try {
			getEditingDomain().runExclusive(new Runnable() {
				
				public void run() {
					if (isActive()) {
						if (theRequest.getExtendedData().get(
								REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR) instanceof Character
								&& manager instanceof TextDirectEditManager) {
							Character initialChar = (Character) theRequest
									.getExtendedData()
									.get(REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR);

							((TextDirectEditManager) manager).show(initialChar);

						} else {
							manager.show();
						}
					}
				}
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void handleNotificationEvent(Notification event) {
		if (event.getFeature() == feature) {
			updateLabelText();
		}
		super.handleNotificationEvent(event);
	}
}
