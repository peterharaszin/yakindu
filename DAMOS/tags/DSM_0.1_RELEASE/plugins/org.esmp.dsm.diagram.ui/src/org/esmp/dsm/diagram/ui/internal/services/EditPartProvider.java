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

package org.esmp.dsm.diagram.ui.internal.services;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.notation.View;
import org.esmp.dsm.diagram.ui.editparts.BlockDiagramEditPart;
import org.esmp.dsm.diagram.ui.editparts.ConnectionEditPart;
import org.esmp.dsm.diagram.ui.editparts.InputPortEditPart;
import org.esmp.dsm.diagram.ui.editparts.OutputPortEditPart;
import org.esmp.dsm.diagram.ui.internal.editparts.BlockNameEditPart;
import org.esmp.dsm.diagram.ui.internal.editparts.FallbackBlockEditPart;
import org.esmp.dsm.diagram.ui.view.SemanticHints;
import org.esmp.dsm.semantic.blockdiagram.Block;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagram;
import org.esmp.dsm.semantic.blockdiagram.Connection;
import org.esmp.dsm.semantic.blockdiagram.Input;
import org.esmp.dsm.semantic.blockdiagram.InputPort;
import org.esmp.dsm.semantic.blockdiagram.Output;
import org.esmp.dsm.semantic.blockdiagram.OutputPort;

public class EditPartProvider extends AbstractEditPartProvider {

	protected Class<?> getDiagramEditPartClass(View view) {
		if (view.getElement() instanceof BlockDiagram) {
			return BlockDiagramEditPart.class;
		}
		return super.getDiagramEditPartClass(view);
	}
	
	protected Class<?> getNodeEditPartClass(View view) {
		EObject element = view.getElement();
		
		if (element instanceof InputPort) {
			Input input = ((InputPort) element).getInput();
			Class<?> clazz = EditPartMappingService.getInstance().getInputClass(
					input.getSpecification().eResource().getURI(), input.getSpecification().getName());
			if (clazz != null) {
				return clazz;
			}
			return InputPortEditPart.class;
		}
	
		if (element instanceof OutputPort) {
			Output output = ((OutputPort) element).getOutput();
			Class<?> clazz = EditPartMappingService.getInstance().getOutputClass(
					output.getSpecification().eResource().getURI(), output.getSpecification().getName());
			if (clazz != null) {
				return clazz;
			}
			return OutputPortEditPart.class;
		}
		
		if (element instanceof Block) {
			String semanticHint = view.getType();
			if (SemanticHints.BLOCK_NAME.equals(semanticHint)) {
				return BlockNameEditPart.class;
			}
			URI uri = ((Block) element).getType().eResource().getURI();
			if (semanticHint != null && semanticHint.length() != 0) {
				Class<?> clazz = EditPartMappingService.getInstance().getContentClass(uri, semanticHint);
				if (clazz != null) {
					return clazz;
				}
			} else {
				Class<?> clazz = EditPartMappingService.getInstance().getClazz(uri);
				if (clazz != null) {
					return clazz;
				}
			}
			return FallbackBlockEditPart.class;
		}
		
		return null;
	}
	
	protected Class<?> getEdgeEditPartClass(View view) {
		if (view.getElement() instanceof Connection) {
			return ConnectionEditPart.class;
		}
		return super.getEdgeEditPartClass(view);
	}

}
