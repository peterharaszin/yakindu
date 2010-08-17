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

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.diagram.dmlnotation.ComponentLayoutConstraint;
import org.eclipselabs.damos.diagram.dmlnotation.DMLNotationPackage;
import org.eclipselabs.damos.diagram.ui.editpolicies.ComponentCanonicalEditPolicy;
import org.eclipselabs.damos.diagram.ui.editpolicies.ComponentComponentEditPolicy;
import org.eclipselabs.damos.diagram.ui.editpolicies.IEditPolicyRoles;
import org.eclipselabs.damos.diagram.ui.editpolicies.TransformEditPolicy;
import org.eclipselabs.damos.diagram.ui.figures.ComponentFigure;
import org.eclipselabs.damos.diagram.ui.internal.editparts.ComponentEditPartDelegate;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.Input;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.Output;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.dml.Port;
import org.eclipselabs.damos.dml.util.DMLUtil;

public abstract class ComponentEditPart extends AbstractBorderedShapeEditPart {
	
	private static final ComponentEditPartDelegate PASSIVE_DELEGATE = new ComponentEditPartDelegate(null);
	private ComponentEditPartDelegate delegate;

	private IFragmentSelectionChangeListener fragmentChangeListener = new IFragmentSelectionChangeListener() {
		
		public void fragmentSelectionChanged(FragmentSelectionChangeEvent event) {
			refreshVisibility();
		}

	};

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
	
	public void activate() {
		super.activate();
		FragmentSelectionManager fragmentManager = (FragmentSelectionManager) getRoot().getContents().getAdapter(FragmentSelectionManager.class);
		if (fragmentManager != null) {
			fragmentManager.addFragmentSelectionChangeListener(fragmentChangeListener);
		}
	}
	
	public void deactivate() {
		FragmentSelectionManager fragmentManager = (FragmentSelectionManager) getRoot().getContents().getAdapter(FragmentSelectionManager.class);
		if (fragmentManager != null) {
			fragmentManager.removeFragmentSelectionChangeListener(fragmentChangeListener);
		}
		super.deactivate();
	}

	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		removeEditPolicy(IEditPolicyRoles.CONNECTION_HANDLES_ROLE);
		installEditPolicy(IEditPolicyRoles.CANONICAL_ROLE, new ComponentCanonicalEditPolicy());
		installEditPolicy(IEditPolicyRoles.TRANSFORM_ROLE, new TransformEditPolicy());
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new ComponentComponentEditPolicy());
		getDelegate().createDefaultEditPolicies();
	}
	
	public ComponentFigure getComponentFigure() {
		return (ComponentFigure) getMainFigure();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart#refreshVisuals()
	 */
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshFlipped();
		refreshRotation();
	}
	
	protected void refreshVisibility() {
		boolean visible = true;
		
		EObject element = resolveSemanticElement();
		if (element instanceof Component) {
			Component component = (Component) element;
			FragmentSelectionManager fragmentManager = (FragmentSelectionManager) getRoot().getContents().getAdapter(FragmentSelectionManager.class);
			if (fragmentManager != null) {
				Fragment selectedFragment = fragmentManager.getSelectedFragment();
				visible = selectedFragment == component.getOwningFragment() || DMLUtil.isChildFragment(selectedFragment, component.getOwningFragment());
			}
		}
		
		if (visible) {
			super.refreshVisibility();
		} else {
			setVisibility(false);
		}
	}

	protected void refreshFlipped() {
		Node node = (Node) getNotationView();
		if (node != null) {
			LayoutConstraint l = node.getLayoutConstraint();
			if (l instanceof ComponentLayoutConstraint) {
				getComponentFigure().setFlipped(((ComponentLayoutConstraint) l).isFlipped());
			}
		}
	}
	
	protected void refreshRotation() {
		Node node = (Node) getNotationView();
		if (node != null) {
			LayoutConstraint l = node.getLayoutConstraint();
			if (l instanceof ComponentLayoutConstraint) {
				getComponentFigure().setRotation(((ComponentLayoutConstraint) l).getRotation());
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart#handleNotificationEvent(org.eclipse.emf.common.notify.Notification)
	 */
	protected void handleNotificationEvent(Notification notification) {
		Object feature = notification.getFeature();
		if (DMLNotationPackage.eINSTANCE.getComponentLayoutConstraint_Flipped().equals(feature)) {
			refreshFlipped();
		} else if (DMLNotationPackage.eINSTANCE.getComponentLayoutConstraint_Rotation().equals(feature)) {
			refreshRotation();
		} else if (DMLPackage.Literals.FRAGMENT_ELEMENT__OWNING_FRAGMENT == feature) {
			refreshVisuals();
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

		if (childEditPart instanceof IBorderItemEditPart) {
			super.addChildVisual(childEditPart, index);
		} else {
			/*
			 * Workaround for a bug in the super class.
			 * TODO: Report addChildVisual() bug.
			 */

			IFigure childFigure = ((GraphicalEditPart) childEditPart).getFigure();
			IFigure parent = getContentPaneFor((IGraphicalEditPart) childEditPart);
			
			// Map the index within the edit parts to the index within the content pane figures.
			for (Object child : getChildren()) {
				if (child == childEditPart) {
					break;
				}
				if (child instanceof IBorderItemEditPart) {
					--index;
				}
			}

			index = Math.min(parent.getChildren().size(), index);
			
            parent.add(childFigure, index);
		}

		if (childEditPart instanceof PortEditPart) {
			PortEditPart portEditPart = (PortEditPart) childEditPart;
			Port port = (Port) portEditPart.resolveSemanticElement();
			if (port != null) {
				getMainFigure().setConstraint(portEditPart.getFigure(), getPortFigureConstraint(port));
			}
		}
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
		return index;
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
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#getAdapter(java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	public Object getAdapter(Class key) {
		Object adapter = getDelegate().getAdapter(key);
		if (adapter != null) {
			return adapter;
		}
		return super.getAdapter(key);
	}

}
