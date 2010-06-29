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

package org.esmp.dsm.diagram.ui.internal.editparts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.esmp.dsm.semantic.blockdiagram.Parameter;

/**
 * @author Andreas Unger
 *
 */
public class ParameterNotificationHelper {

	GraphicalEditPart editPart;
	List<EObject> registry;
	
	/**
	 * 
	 */
	public ParameterNotificationHelper(GraphicalEditPart editPart) {
		this.editPart = editPart;
	}
	
	public void addSemanticListeners(List<Parameter> parameters) {
		if (parameters.size() > 0) {
			if (registry != null) {
				removeSemanticListeners();
			}
			DiagramEventBroker diagramEventBroker = getDiagramEventBroker();
			if (diagramEventBroker != null) {
				registry = new ArrayList<EObject>();
				for (Parameter p : parameters) {
					diagramEventBroker.addNotificationListener(p, editPart);
					registry.add(p);
				}
			}
		}
	}
	
	public void removeSemanticListeners() {
		if (registry != null) {
			DiagramEventBroker diagramEventBroker = getDiagramEventBroker();
			if (diagramEventBroker != null) {
				for (EObject target : registry) {
					diagramEventBroker.removeNotificationListener(target, editPart);
				}
				registry = null;
			}
		}
	}

    private DiagramEventBroker getDiagramEventBroker() {
        TransactionalEditingDomain theEditingDomain = editPart.getEditingDomain();
        if (theEditingDomain != null) {
        	return DiagramEventBroker.getInstance(theEditingDomain);
        }
        return null;
    }

}
