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


import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.mda4e.statemachine.contribution.model.OutlineTreeObject;

import statemachine.Event;
import statemachine.Statechart;
import statemachine.Variable;

public class OurTreeEditpartFactory implements EditPartFactory {
	
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof Diagram) {
			Diagram diagram = (Diagram) model;
			Statechart statechart = (Statechart) diagram.getElement();
			return new OutlineRootTreeEditPart(statechart);
		} else if (model instanceof OutlineTreeObject) {
			return new OutlineTreeObjectEditPart((OutlineTreeObject) model);
		} else if (model instanceof Event) {
			return new OutlineEventTreeEditPart((Event)model);
		} else if (model instanceof Variable) {
			return new OutlineVariableTreeEditPart((Variable)model);
		}
		return null;
	}

}
