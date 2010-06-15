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
import org.eclipse.gmf.runtime.notation.View;

import statemachine.diagram.edit.parts.FinalStateEditPart;
import statemachine.diagram.edit.parts.Pseudostate2EditPart;
import statemachine.diagram.edit.parts.Pseudostate3EditPart;
import statemachine.diagram.edit.parts.Pseudostate4EditPart;
import statemachine.diagram.edit.parts.Pseudostate5EditPart;
import statemachine.diagram.edit.parts.PseudostateEditPart;
import statemachine.diagram.edit.parts.Region2EditPart;
import statemachine.diagram.edit.parts.RegionEditPart;
import statemachine.diagram.edit.parts.StateEditPart;
import statemachine.diagram.edit.parts.StatemachineEditPartFactory;
import statemachine.diagram.edit.parts.TransitionEditPart;
import statemachine.diagram.edit.parts.TransitionExpressionEditPart;
import statemachine.diagram.edit.parts.TransitionPriorityEditPart;
import statemachine.diagram.part.StatemachineVisualIDRegistry;

public class OurStatemachineEditPartFactory extends StatemachineEditPartFactory {
	
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			int viewVisualID = StatemachineVisualIDRegistry.getVisualID(view);
			switch (viewVisualID) {
			
			case FinalStateEditPart.VISUAL_ID:
				return new OurFinalStateEditPart(view);
			case RegionEditPart.VISUAL_ID:
				return new OurRegionEditPart(view);
			case Region2EditPart.VISUAL_ID:
				return new OurRegion2EditPart(view);
			case StateEditPart.VISUAL_ID:
				return new OurStateEditPart(view);
			case PseudostateEditPart.VISUAL_ID:
			case Pseudostate2EditPart.VISUAL_ID:
			case Pseudostate3EditPart.VISUAL_ID:
			case Pseudostate4EditPart.VISUAL_ID:
			case Pseudostate5EditPart.VISUAL_ID:
			/*case Pseudostate6EditPart.VISUAL_ID:
			case Pseudostate7EditPart.VISUAL_ID:
			case Pseudostate8EditPart.VISUAL_ID:*/
				return new OurPseudostateEditPart(view);
			case TransitionEditPart.VISUAL_ID:
				return new OurTransitionEditPart(view);
			case TransitionExpressionEditPart.VISUAL_ID:
				return new OurTransitionExpressionEditPart(view);
			case TransitionPriorityEditPart.VISUAL_ID:
				return new OurTransitionPriorityEditPart(view);
			}
		}
		return super.createEditPart(context, model);
	}
}
