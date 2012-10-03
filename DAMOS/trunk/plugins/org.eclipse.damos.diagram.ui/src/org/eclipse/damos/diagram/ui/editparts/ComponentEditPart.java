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

import org.eclipse.damos.diagram.dmlnotation.DMLNotationPackage;
import org.eclipse.damos.diagram.dmlnotation.RotatableBounds;
import org.eclipse.damos.diagram.ui.editpolicies.ComponentCanonicalEditPolicy;
import org.eclipse.damos.diagram.ui.editpolicies.DeleteSemanticComponentEditPolicy;
import org.eclipse.damos.diagram.ui.editpolicies.IEditPolicyRoles;
import org.eclipse.damos.diagram.ui.editpolicies.InputPortCountEditPolicy;
import org.eclipse.damos.diagram.ui.editpolicies.OutputPortCountEditPolicy;
import org.eclipse.damos.diagram.ui.editpolicies.TransformEditPolicy;
import org.eclipse.damos.diagram.ui.figures.ComponentFigure;
import org.eclipse.damos.diagram.ui.figures.IFontColorAwareFigure;
import org.eclipse.damos.diagram.ui.internal.editparts.ComponentEditPartDelegate;
import org.eclipse.damos.diagram.ui.internal.editpolicies.FragmentSelectionEditPolicy;
import org.eclipse.damos.diagram.ui.internal.figures.BlankableBorderedNodeFigure;
import org.eclipse.damos.dml.Component;
import org.eclipse.damos.dml.Input;
import org.eclipse.damos.dml.InputPort;
import org.eclipse.damos.dml.Output;
import org.eclipse.damos.dml.OutputPort;
import org.eclipse.damos.dml.Port;
import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.GradientData;
import org.eclipse.swt.graphics.Color;

public abstract class ComponentEditPart extends AbstractBorderedShapeEditPart {
	
	private static final ComponentEditPartDelegate PASSIVE_DELEGATE = new ComponentEditPartDelegate(null);
	private ComponentEditPartDelegate delegate;

	public ComponentEditPart(View view) {
		super(view);
	}
	
	/**
	 * @return the delegate
	 */
	ComponentEditPartDelegate getDelegate() {
		if (delegate == null) {
			delegate = createDelegate();
		}
		return delegate;
	}
	
	protected ComponentEditPartDelegate createDelegate() {
		return PASSIVE_DELEGATE;
	}
	
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		removeEditPolicy(IEditPolicyRoles.CONNECTION_HANDLES_ROLE);
		installEditPolicy(IEditPolicyRoles.CANONICAL_ROLE, new ComponentCanonicalEditPolicy());
		installEditPolicy(IEditPolicyRoles.TRANSFORM_ROLE, new TransformEditPolicy());
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new DeleteSemanticComponentEditPolicy());
		installEditPolicy(IEditPolicyRoles.INPUT_PORT_COUNT_ROLE, new InputPortCountEditPolicy());
		installEditPolicy(IEditPolicyRoles.OUTPUT_PORT_COUNT_ROLE, new OutputPortCountEditPolicy());
		installEditPolicy(IEditPolicyRoles.FRAGMENT_SELECTION_ROLE, new FragmentSelectionEditPolicy());
		getDelegate().createDefaultEditPolicies();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart#createNodeFigure()
	 */
	@Override
	protected NodeFigure createNodeFigure() {
		return new BlankableBorderedNodeFigure(createMainFigure());
	}

	public ComponentFigure getComponentFigure() {
		return (ComponentFigure) getMainFigure();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart#refreshVisuals()
	 */
	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshFontColor();
		refreshFlipped();
		refreshRotation();
	}
	
	protected void refreshFlipped() {
		Node node = (Node) getNotationView();
		if (node != null) {
			LayoutConstraint l = node.getLayoutConstraint();
			if (l instanceof RotatableBounds) {
				getComponentFigure().setFlipped(((RotatableBounds) l).isFlipped());
			}
		}
	}
	
	protected void refreshRotation() {
		Node node = (Node) getNotationView();
		if (node != null) {
			LayoutConstraint l = node.getLayoutConstraint();
			if (l instanceof RotatableBounds) {
				getComponentFigure().setRotation(((RotatableBounds) l).getRotation());
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#setFontColor(org.eclipse.swt.graphics.Color)
	 */
	@Override
	protected void setFontColor(Color color) {
		IFigure mainFigure = getMainFigure();
		if (mainFigure instanceof IFontColorAwareFigure) {
			IFontColorAwareFigure fontColorAwareFigure = (IFontColorAwareFigure) mainFigure;
			fontColorAwareFigure.setFontColor(color);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#performRequest(org.eclipse.gef.Request)
	 */
	@Override
	public void performRequest(Request request) {
		if (!delegate.performRequest(request)) {
			super.performRequest(request);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart#handleNotificationEvent(org.eclipse.emf.common.notify.Notification)
	 */
	protected void handleNotificationEvent(Notification notification) {
		Object feature = notification.getFeature();
		if (NotationPackage.eINSTANCE.getFontStyle_FontColor().equals(feature)) {
			refreshFontColor();
		} else if (DMLNotationPackage.eINSTANCE.getFlippableBounds_Flipped().equals(feature)) {
			refreshFlipped();
		} else if (DMLNotationPackage.eINSTANCE.getRotatableBounds_Rotation().equals(feature)) {
			refreshRotation();
		} else {
			super.handleNotificationEvent(notification);
		}
	}

	public EditPart getPrimaryChildEditPart() {
		EditPart primaryChildEditPart = getDelegate().getPrimaryChildEditPart();
		if (primaryChildEditPart != null) {
			return primaryChildEditPart;
		}
		// The first non-port edit part is our primary edit part.
		for (Object ep : getChildren()) {
			if (!(ep instanceof PortEditPart)) {
				return (EditPart) ep;
			}
		}
		return super.getPrimaryChildEditPart();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart#addChildVisual(org.eclipse.gef.EditPart, int)
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		index = getChildVisualIndexOf(childEditPart, index);

		super.addChildVisual(childEditPart, index);

		if (childEditPart instanceof PortEditPart) {
			PortEditPart portEditPart = (PortEditPart) childEditPart;
			Port port = (Port) portEditPart.resolveSemanticElement();
			if (port != null) {
				getMainFigure().setConstraint(portEditPart.getFigure(), getPortFigureConstraint(port));
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart#getContentPaneFor(org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart)
	 */
	@Override
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if (editPart instanceof ComponentAttributeEditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		return super.getContentPaneFor(editPart);
	}

	protected int getChildVisualIndexOf(EditPart childEditPart, int index) {
		if (childEditPart instanceof PortEditPart) {
			EObject element = resolveSemanticElement();
			if (element instanceof Component) {
				Component component = (Component) element;
				EObject semanticChild = ((IGraphicalEditPart) childEditPart).resolveSemanticElement();
				int newIndex = 0;
				for (Input input : component.getInputs()) {
					for (InputPort inputPort : input.getPorts()) {
						if (inputPort == semanticChild) {
							return newIndex;
						}
						++newIndex;
					}
				}
				for (Output output : component.getOutputs()) {
					for (OutputPort outputPort : output.getPorts()) {
						if (outputPort == semanticChild) {
							return newIndex;
						}
						++newIndex;
					}
				}
			}
		}
		return -1;
	}

	protected Object getPortFigureConstraint(Port port) {
		return null;
	}
	
	protected void addSemanticListeners() {
		super.addSemanticListeners();
		getDelegate().addSemanticListeners();
	}
	
	protected void removeSemanticListeners() {
		getDelegate().removeSemanticListeners();
		super.removeSemanticListeners();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart#supportsGradient()
	 */
	@Override
	public boolean supportsGradient() {
		return true;
	}
	
    protected void setGradient(GradientData gradient) {
    	IFigure mainFigure = getMainFigure();
    	if (mainFigure instanceof NodeFigure) {
    		NodeFigure nodeFigure = (NodeFigure) mainFigure;
	    	if (gradient != null) {    		    		
	    		nodeFigure.setIsUsingGradient(true);
	    		nodeFigure.setGradientData(gradient.getGradientColor1(), gradient.getGradientColor2(), gradient.getGradientStyle()); 		
	    	} else {
	    		nodeFigure.setIsUsingGradient(false);
	    	}
    	} else {
    		super.setGradient(gradient);
    	}
    }
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#getAdapter(java.lang.Class)
	 */
	public Object getAdapter(@SuppressWarnings("rawtypes") Class key) {
		Object adapter = getDelegate().getAdapter(key);
		if (adapter != null) {
			return adapter;
		}
		return super.getAdapter(key);
	}

}
