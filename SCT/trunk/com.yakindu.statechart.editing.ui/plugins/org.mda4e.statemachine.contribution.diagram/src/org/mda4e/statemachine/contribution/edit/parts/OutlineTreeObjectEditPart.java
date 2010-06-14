/**
 * Copyright (c) 2006-2009 committers of mda4e and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of mda4e (http://www.mda4e.org/) - initial API and implementation
 *
 */
package org.mda4e.statemachine.contribution.edit.parts;

import java.util.List;


import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.editparts.AbstractTreeEditPart;
import org.eclipse.gef.editpolicies.RootComponentEditPolicy;
import org.mda4e.statemachine.contribution.model.OutlineTreeObject;

public class OutlineTreeObjectEditPart extends AbstractTreeEditPart {
	
	public OutlineTreeObjectEditPart(OutlineTreeObject treeObject){
		super(treeObject);
	}
	
	/*
	public void activate() {
		if (!isActive()) {
			super.activate();
			((OutlineTreeRoot) getModel()).eAdapters().add(adapter);
		}
	}

	public void deactivate() {
		if (isActive()) {
			super.deactivate();
			((VarContainer) getModel()).removePropertyChangeListener(adapter);
		}
	}
	*/
	
	protected void createEditPolicies() {
		// If this editpart is the root content of the viewer, then disallow
		// removal
		if (getParent() instanceof RootEditPart) {
			installEditPolicy(EditPolicy.COMPONENT_ROLE,
					new RootComponentEditPolicy());
		}
	}
	
	public String getText(){
		return getCastedModel().getName();
	}
	
	protected List <Object> getModelChildren(){
		return getCastedModel().getChildren();
	}
	
	private OutlineTreeObject getCastedModel(){
		return (OutlineTreeObject) getModel();
	}
}
