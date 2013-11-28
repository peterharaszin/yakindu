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
package org.mda4e.statemachine.contribution.tools;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import statemachine.Statechart;
import statemachine.diagram.edit.parts.StateEditPart;
import statemachine.diagram.edit.parts.TransitionEditPart;
import statemachine.diagram.part.StatemachineDiagramEditor;

public class StaticMethods {

	public static Statechart getStatechart(StatemachineDiagramEditor editor) {
		if (editor == null) {
			throw new NullPointerException("editor");
		}
		DiagramEditPart diagramEditPart = editor.getDiagramEditPart();
		return (Statechart) diagramEditPart.resolveSemanticElement();
	}

	public static Statechart getStatechart() {
		if (PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage() != null) {
			IWorkbenchPage page = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getActivePage();
			// IWorkbenchPage page = getSite().getPage();
			if (page.getActiveEditor() instanceof StatemachineDiagramEditor) {
				StatemachineDiagramEditor editor = (StatemachineDiagramEditor) page
						.getActiveEditor();
				return getStatechart(editor);
			}
		}
		return null;
	}

	public static StatemachineDiagramEditor getStateEditor() {
		if (PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage() != null) {
			IWorkbenchPage page = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getActivePage();
			// IWorkbenchPage page = getSite().getPage();
			if (page.getActiveEditor() instanceof StatemachineDiagramEditor)
				return (StatemachineDiagramEditor) page.getActiveEditor();
		}
		return null;
	}

	public static List<TransitionEditPart> getRegionTransitionsEditParts(
			ShapeCompartmentEditPart regionCompartment) {
		List<TransitionEditPart> transitions = new ArrayList<TransitionEditPart>();
		// Innerhalb eines RegionCompartment alle Transitionen von Elementen
		// suchen und Visibility setzen.
		for (int CompIndex = 0; CompIndex < regionCompartment.getChildren()
				.size(); CompIndex++) {
			// Nur States sind interessant; Pseudostates nicht
			ShapeNodeEditPart node = (ShapeNodeEditPart) regionCompartment
					.getChildren().get(CompIndex);
			for (int i = 0; i < node.getTargetConnections().size(); i++)
				if (!transitions.contains(node.getTargetConnections().get(i)))
					transitions.add((TransitionEditPart) node
							.getTargetConnections().get(i));
			for (int i = 0; i < node.getSourceConnections().size(); i++)
				if (!transitions.contains(node.getSourceConnections().get(i)))
					transitions.add((TransitionEditPart) node
							.getSourceConnections().get(i));

			// Rekursiver Aufruf der Methode um auch Transitionen in tieferen
			// Ebenen zu erreichen.
			if (node instanceof StateEditPart) {
				StateEditPart state = (StateEditPart) node;
				ShapeCompartmentEditPart stateCompartment = (ShapeCompartmentEditPart) state
						.getChildren().get(4);
				if (stateCompartment != null) {
					for (int i = 0; i < stateCompartment.getChildren().size(); i++) {
						ShapeNodeEditPart region = (ShapeNodeEditPart) stateCompartment
								.getChildren().get(i);
						List<TransitionEditPart> temp = getRegionTransitionsEditParts((ShapeCompartmentEditPart) region
								.getChildren().get(1));
						for (int j = 0; j < temp.size(); j++)
							if (!transitions.contains(temp.get(j)))
								transitions.add(temp.get(j));
					}
				}
			}
		}
		return transitions;
	}
}
