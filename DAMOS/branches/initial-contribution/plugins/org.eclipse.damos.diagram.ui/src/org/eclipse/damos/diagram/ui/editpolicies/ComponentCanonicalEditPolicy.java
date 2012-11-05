/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.diagram.ui.editpolicies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.damos.dml.Component;
import org.eclipse.damos.dml.Input;
import org.eclipse.damos.dml.InputPort;
import org.eclipse.damos.dml.Output;
import org.eclipse.damos.dml.OutputPort;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

/**
 * Sync notation views with semantic children
 * 
 * @author Andreas Unger
 */
public class ComponentCanonicalEditPolicy extends CanonicalConnectionEditPolicy {
	
	private List<EObject> listenerTargets;

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy#activate()
	 */
	public void activate() {
		if (isActive()) {
			return;
		}

		super.activate();
		
		EObject o = resolveSemanticElement();
		if (o instanceof Component) {
			Component component = (Component) o;
			
			if (listenerTargets == null) {
				listenerTargets = new ArrayList<EObject>();
			}
	
			DiagramEventBroker deb = getDiagramEventBroker();
			for (Input input : component.getInputs()) {
				deb.addNotificationListener(input, this);
				listenerTargets.add(input);
			}
			for (Output output : component.getOutputs()) {
				deb.addNotificationListener(output, this);
				listenerTargets.add(output);
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy#deactivate()
	 */
	public void deactivate() {
		if (!isActive()) {
			return;
		}

		if (listenerTargets != null) {
			DiagramEventBroker deb = getDiagramEventBroker();
			for (EObject target : listenerTargets) {
				deb.removeNotificationListener(target, this);
			}
			listenerTargets.clear();
		}
		
		super.deactivate();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy#getSemanticChildrenList()
	 */
	protected List<EObject> getSemanticChildrenList() {
		EObject o = resolveSemanticElement();
		
		if (!(o instanceof Component)) {
			return Collections.emptyList();
		}
		
		Component component = (Component) o;

		List<EObject> children = new ArrayList<EObject>();
		children.addAll(component.getInputPorts());
		children.addAll(component.getOutputPorts());

		return children;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy#getSemanticConnectionsList()
	 */
	@Override
	protected List<EObject> getSemanticConnectionsList() {
		return Collections.emptyList();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy#getSourceElement(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	protected EObject getSourceElement(EObject relationship) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy#getTargetElement(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	protected EObject getTargetElement(EObject relationship) {
		return null;
	}

	/**
	 * Also handle move notifications.
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy#shouldHandleNotificationEvent(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	protected boolean shouldHandleNotificationEvent(Notification event) {
		if (super.shouldHandleNotificationEvent(event)) {
			return true;
		}

		Object element = event.getNotifier();
		if (element instanceof EObject && !(element instanceof View)) {
			return NotificationUtil.isMove(event);
		}
		
		return false;
	}
	
	/**
	 * Ensure semantic elements and views are in the same order.
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy#refreshSemantic()
	 */
	@Override
	protected void refreshSemantic() {
		super.refreshSemantic();

		if (isSemanticOrdered()) {
			return;
		}
		
		executeCommand(new ReorderCommand());
	}
	
	private boolean isSemanticOrdered() {
		Component component = (Component) resolveSemanticElement();
		View container = (View) getHost().getModel();
		EList<?> children = container.getChildren();

		int i = 0;
		
		for (InputPort port : component.getInputPorts()) {
			if (children.size() == i) {
				return false;
			}
			View view = (View) children.get(++i);
			if (view.getElement() != port) {
				return false;
			}
		}
		
		for (OutputPort port : component.getOutputPorts()) {
			if (children.size() == i) {
				return false;
			}
			View view = (View) children.get(++i);
			if (view.getElement() != port) {
				return false;
			}
		}
		
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy#shouldIncludeConnection(org.eclipse.gmf.runtime.notation.Edge, java.util.Collection)
	 */
	@Override
	protected boolean shouldIncludeConnection(Edge connection, Collection<View> children) {
		return false;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy#shouldDeleteView(org.eclipse.gmf.runtime.notation.View)
	 */
	protected boolean shouldDeleteView(View view) {
		return "".equals(view.getType()) || view.getType() == null;
	}
	
	private DiagramEventBroker getDiagramEventBroker() {
		TransactionalEditingDomain theEditingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		if (theEditingDomain != null) {
			return DiagramEventBroker.getInstance(theEditingDomain);
		}
		return null;
    }

	/**
	 * @author Andreas Unger
	 *
	 */
	private class ReorderCommand extends Command {
		
		@Override
		public void execute() {
			Component component = (Component) resolveSemanticElement();
			View container = (View) getHost().getModel();
	
			Map<InputPort, View> inputPortViews = new HashMap<InputPort, View>();
			Map<OutputPort, View> outputPortViews = new HashMap<OutputPort, View>();
	
			for (Object o : container.getChildren()) {
				View view = (View) o;
				if (view != null) {
					if (view.getElement() instanceof InputPort) {
						inputPortViews.put((InputPort) view.getElement(), view);
					} else if (view.getElement() instanceof OutputPort) {
						outputPortViews.put((OutputPort) view.getElement(), view);
					}
				}
			}
			
			int i = 0;
			for (InputPort port : component.getInputPorts()) {
				reorderView(container, inputPortViews.get(port), ++i);
			}
			for (OutputPort port : component.getOutputPorts()) {
				reorderView(container, outputPortViews.get(port), ++i);
			}
		}

		/**
		 * @param container
		 * @param view
		 * @param i
		 */
		private void reorderView(View container, View view, int i) {
			if (view != null) {
			    container.removeChild(view);
			    if (container.getChildren().size() < i) {
			    	container.insertChildAt(view, i);
			    } else {
			    	container.insertChild(view);
			    }
			}
		}
		
	}

}
