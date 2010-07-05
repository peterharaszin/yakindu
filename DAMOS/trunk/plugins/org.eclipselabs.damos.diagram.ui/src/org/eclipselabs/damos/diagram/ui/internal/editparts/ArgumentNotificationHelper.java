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

package org.eclipselabs.damos.diagram.ui.internal.editparts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipselabs.damos.dml.Argument;

/**
 * @author Andreas Unger
 *
 */
public class ArgumentNotificationHelper {

	GraphicalEditPart editPart;
	List<EObject> registry;
	
	/**
	 * 
	 */
	public ArgumentNotificationHelper(GraphicalEditPart editPart) {
		this.editPart = editPart;
	}
	
	public void addSemanticListeners(List<Argument> arguments) {
		if (arguments.size() > 0) {
			if (registry != null) {
				removeSemanticListeners();
			}
			DiagramEventBroker diagramEventBroker = getDiagramEventBroker();
			if (diagramEventBroker != null) {
				registry = new ArrayList<EObject>();
				for (Argument a : arguments) {
					diagramEventBroker.addNotificationListener(a, editPart);
					registry.add(a);
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
