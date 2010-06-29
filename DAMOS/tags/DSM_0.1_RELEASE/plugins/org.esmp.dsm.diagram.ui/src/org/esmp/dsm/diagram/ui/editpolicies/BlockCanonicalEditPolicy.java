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

package org.esmp.dsm.diagram.ui.editpolicies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.esmp.dsm.semantic.blockdiagram.Block;
import org.esmp.dsm.semantic.blockdiagram.Input;
import org.esmp.dsm.semantic.blockdiagram.Output;

/**
 * Sync notation views with semantic children
 * 
 * @author Andreas Unger
 */
public class BlockCanonicalEditPolicy extends CanonicalEditPolicy {
	
	private List<EObject> listenerTargets;

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy#activate()
	 */
	public void activate() {
		if (isActive()) {
			return;
		}

		super.activate();
		
		EObject o = ViewUtil.resolveSemanticElement((View) host().getModel());
		if (o instanceof Block) {
			Block block = (Block) o;
			
			if (listenerTargets == null) {
				listenerTargets = new ArrayList<EObject>();
			}
	
			DiagramEventBroker deb = getDiagramEventBroker();
			for (Input input : block.getInputs()) {
				deb.addNotificationListener(input, this);
				listenerTargets.add(input);
			}
			for (Output output : block.getOutputs()) {
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
		EObject o = ViewUtil.resolveSemanticElement((View) host().getModel());
		
		if (!(o instanceof Block)) {
			return Collections.emptyList();
		}
		
		Block block = (Block) o;

		List<EObject> children = new ArrayList<EObject>();
		children.addAll(block.getInputPorts());
		children.addAll(block.getOutputPorts());

		return children;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy#shouldDeleteView(org.eclipse.gmf.runtime.notation.View)
	 */
	protected boolean shouldDeleteView(View view) {
		return !(ViewUtil.resolveSemanticElement(view) instanceof Block);
	}
	
	private DiagramEventBroker getDiagramEventBroker() {
		TransactionalEditingDomain theEditingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		if (theEditingDomain != null) {
			return DiagramEventBroker.getInstance(theEditingDomain);
		}
		return null;
    }

}
