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

package org.eclipse.damos.diagram.ui.internal.providers;

import org.eclipse.damos.diagram.ui.editparts.BlockDiagramEditPart;
import org.eclipse.damos.diagram.ui.editparts.BlockInputPortEditPart;
import org.eclipse.damos.diagram.ui.editparts.BlockOutputPortEditPart;
import org.eclipse.damos.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.damos.diagram.ui.editparts.FunctionBlockEditPart;
import org.eclipse.damos.diagram.ui.editparts.InoutportEditPart;
import org.eclipse.damos.diagram.ui.editparts.InputPortEditPart;
import org.eclipse.damos.diagram.ui.editparts.NamedBlockInputPortEditPart;
import org.eclipse.damos.diagram.ui.editparts.NamedBlockOutputPortEditPart;
import org.eclipse.damos.diagram.ui.editparts.OutputPortEditPart;
import org.eclipse.damos.diagram.ui.editparts.SubsystemEditPart;
import org.eclipse.damos.diagram.ui.editparts.SubsystemInputPortEditPart;
import org.eclipse.damos.diagram.ui.editparts.SubsystemOutputPortEditPart;
import org.eclipse.damos.diagram.ui.internal.editparts.ActionEditPart;
import org.eclipse.damos.diagram.ui.internal.editparts.ActionLinkConditionEditPart;
import org.eclipse.damos.diagram.ui.internal.editparts.ActionLinkEditPart;
import org.eclipse.damos.diagram.ui.internal.editparts.BlockDiagramRootEditPart;
import org.eclipse.damos.diagram.ui.internal.editparts.ChoiceEditPart;
import org.eclipse.damos.diagram.ui.internal.editparts.ComponentNameEditPart;
import org.eclipse.damos.diagram.ui.internal.editparts.CompoundCompartmentEditPart;
import org.eclipse.damos.diagram.ui.internal.editparts.FallbackComponentEditPart;
import org.eclipse.damos.diagram.ui.internal.editparts.JoinEditPart;
import org.eclipse.damos.diagram.ui.internal.editparts.LatchEditPart;
import org.eclipse.damos.diagram.ui.internal.editparts.MemoryEditPart;
import org.eclipse.damos.diagram.ui.internal.editparts.WhileLoopConditionEditPart;
import org.eclipse.damos.diagram.ui.internal.editparts.WhileLoopEditPart;
import org.eclipse.damos.diagram.ui.view.ISemanticHints;
import org.eclipse.damos.dml.Action;
import org.eclipse.damos.dml.ActionLink;
import org.eclipse.damos.dml.Block;
import org.eclipse.damos.dml.BlockInput;
import org.eclipse.damos.dml.BlockInputPort;
import org.eclipse.damos.dml.BlockOutput;
import org.eclipse.damos.dml.BlockOutputPort;
import org.eclipse.damos.dml.Choice;
import org.eclipse.damos.dml.Component;
import org.eclipse.damos.dml.Compound;
import org.eclipse.damos.dml.Connection;
import org.eclipse.damos.dml.Inoutport;
import org.eclipse.damos.dml.InputPort;
import org.eclipse.damos.dml.Join;
import org.eclipse.damos.dml.Latch;
import org.eclipse.damos.dml.Memory;
import org.eclipse.damos.dml.OutputPort;
import org.eclipse.damos.dml.Subsystem;
import org.eclipse.damos.dml.SubsystemInput;
import org.eclipse.damos.dml.SubsystemOutput;
import org.eclipse.damos.dml.System;
import org.eclipse.damos.dml.WhileLoop;
import org.eclipse.damos.dml.WhileLoopCondition;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateRootEditPartOperation;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

public class EditPartProvider extends AbstractEditPartProvider {
	
	private EditPartProviderDelegate delegate = new EditPartProviderDelegate();

	public RootEditPart createRootEditPart(Diagram diagram) {
		if (diagram.getElement() instanceof System) {
			return new BlockDiagramRootEditPart(diagram.getMeasurementUnit());
		}
		return super.createRootEditPart(diagram);
	}
	
	protected Class<?> getDiagramEditPartClass(View view) {
		if (view.getElement() instanceof System) {
			return BlockDiagramEditPart.class;
		}
		return super.getDiagramEditPartClass(view);
	}
	
	protected Class<?> getNodeEditPartClass(View view) {
		EObject element = view.getElement();
		String semanticHint = view.getType();
		
		if (element instanceof InputPort) {
			InputPort inputPort = (InputPort) element;
			if (inputPort.getInput() instanceof SubsystemInput) {
				return SubsystemInputPortEditPart.class;
			}
			if (inputPort instanceof BlockInputPort) {
				Class<?> clazz = null;
				BlockInput input = (BlockInput) inputPort.getInput();
				Block block = (Block) input.getComponent();
				clazz = delegate.getInputClass(block.getType().getQualifiedName(), input.getDefinition().getName());
				if (clazz != null) {
					return clazz;
				}
				if (getBlockEditPartClass(block, semanticHint) == null) {
					return NamedBlockInputPortEditPart.class;
				}
				return BlockInputPortEditPart.class;
			}
			return InputPortEditPart.class;
		}
	
		if (element instanceof OutputPort) {
			OutputPort outputPort = (OutputPort) element;
			if (outputPort.getOutput() instanceof SubsystemOutput) {
				return SubsystemOutputPortEditPart.class;
			}
			if (outputPort instanceof BlockOutputPort) {
				Class<?> clazz = null;
				BlockOutput output = (BlockOutput) outputPort.getOutput();
				Block block = (Block) output.getComponent();
				clazz = delegate.getOutputClass(block.getType().getQualifiedName(), output.getDefinition().getName());
				if (clazz != null) {
					return clazz;
				}
				if (getBlockEditPartClass(block, semanticHint) == null) {
					return NamedBlockOutputPortEditPart.class;
				}
				return BlockOutputPortEditPart.class;
			}
			return OutputPortEditPart.class;
		}
		
		if (element instanceof Component) {
			if (ISemanticHints.COMPONENT_NAME.equals(view.getType())) {
				return ComponentNameEditPart.class;
			}
			if (element instanceof Inoutport) {
				return InoutportEditPart.class;
			}
			if (element instanceof Subsystem) {
				return SubsystemEditPart.class;
			}
			if (element instanceof Choice) {
				return ChoiceEditPart.class;
			}
			if (element instanceof Join) {
				return JoinEditPart.class;
			}
			if (element instanceof Memory) {
				return MemoryEditPart.class;
			}
			if (element instanceof Latch) {
				return LatchEditPart.class;
			}
			if (element instanceof Block) {
				Block block = (Block) element;
				Class<?> clazz = getBlockEditPartClass(block, semanticHint);
				return clazz != null ? clazz : FunctionBlockEditPart.class;
			}
			return FallbackComponentEditPart.class;
		}
		
		if (element instanceof Compound) {
			if (ISemanticHints.COMPOUND_COMPARTMENT.equals(semanticHint)) {
				return CompoundCompartmentEditPart.class;
			}
			if (element instanceof WhileLoop) {
				return WhileLoopEditPart.class;
			}
			if (element instanceof Action) {
				return ActionEditPart.class;
			}
		}
		
		if (element instanceof WhileLoopCondition) {
			return WhileLoopConditionEditPart.class;
		}
		
		if (ISemanticHints.ACTION_LINK_CONDITION.equals(view.getType())) {
			return ActionLinkConditionEditPart.class;
		}

		return super.getNodeEditPartClass(view);
	}
	
	protected Class<?> getBlockEditPartClass(Block block, String semanticHint) {
		if (semanticHint != null && semanticHint.length() != 0) {
			Class<?> clazz = delegate.getContentClass(block.getType().getQualifiedName(), semanticHint);
			if (clazz != null) {
				return clazz;
			}
		} else {
			Class<?> clazz = delegate.getClazz(block.getType().getQualifiedName());
			if (clazz != null) {
				return clazz;
			}
		}
		return null;
	}
	
	protected Class<?> getEdgeEditPartClass(View view) {
		if (view.getElement() instanceof Connection) {
			return ConnectionEditPart.class;
		}
		if (view.getElement() instanceof ActionLink) {
			return ActionLinkEditPart.class;
		}
		return super.getEdgeEditPartClass(view);
	}

	public boolean provides(IOperation operation) {
		if (operation instanceof CreateRootEditPartOperation) {
			return true;
		}
		return super.provides(operation);
	}

}
