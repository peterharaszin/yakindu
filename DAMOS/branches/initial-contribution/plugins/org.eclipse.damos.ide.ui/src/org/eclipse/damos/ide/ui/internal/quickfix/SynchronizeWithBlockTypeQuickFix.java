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

package org.eclipse.damos.ide.ui.internal.quickfix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.damos.dml.Argument;
import org.eclipse.damos.dml.Block;
import org.eclipse.damos.dml.BlockInput;
import org.eclipse.damos.dml.BlockOutput;
import org.eclipse.damos.dml.BlockType;
import org.eclipse.damos.dml.Connection;
import org.eclipse.damos.dml.DMLFactory;
import org.eclipse.damos.dml.Input;
import org.eclipse.damos.dml.InputDefinition;
import org.eclipse.damos.dml.InputPort;
import org.eclipse.damos.dml.Output;
import org.eclipse.damos.dml.OutputDefinition;
import org.eclipse.damos.dml.OutputPort;
import org.eclipse.damos.dml.Parameter;
import org.eclipse.damos.dml.util.DMLUtil;
import org.eclipse.damos.ide.core.validation.Problem;
import org.eclipse.damos.ide.ui.IDEUIPlugin;
import org.eclipse.damos.ide.ui.quickfix.AbstractQuickFix;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.graphics.Image;

/**
 * @author Andreas Unger
 *
 */
public class SynchronizeWithBlockTypeQuickFix extends AbstractQuickFix {

	/* (non-Javadoc)
	 * @see org.eclipse.damos.ide.ui.quickfix.IQuickFix#getDescription()
	 */
	public String getDescription() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.ide.ui.quickfix.IQuickFix#getImage()
	 */
	public Image getImage() {
		return IDEUIPlugin.getDefault().getImageRegistry().get(IDEUIPlugin.IMAGE_CORRECTION_SYNCHRONIZE);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.ide.ui.quickfix.IQuickFix#getLabel()
	 */
	public String getLabel() {
		return "Synchronize with block type";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.ide.ui.quickfix.AbstractQuickFix#run(org.eclipse.damos.ide.core.validation.Problem, org.eclipse.emf.transaction.TransactionalEditingDomain)
	 */
	@Override
	protected void run(final Problem problem, final TransactionalEditingDomain editingDomain) {
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain, "Synchronize with Block Type") {
			
			@Override
			protected void doExecute() {
				URI uri = problem.getElementURI();
				
				ResourceSet resourceSet = editingDomain.getResourceSet();
				
				EObject eObject = resourceSet.getEObject(uri, true);
				if (eObject == null) {
					return;
				}
				
				Block block = DMLUtil.getOwner(eObject, Block.class);
				if (block == null) {
					return;
				}

				BlockType blockType = block.getType();
				if (blockType == null) {
					return;
				}
				
				Map<InputDefinition, BlockInput> existingInputs = new HashMap<InputDefinition, BlockInput>();
				
				for (Iterator<Input> it = block.getInputs().iterator(); it.hasNext();) {
					Input input = it.next();
					if (input instanceof BlockInput) {
						BlockInput blockInput = (BlockInput) input;
						if (DMLUtil.isResolved(blockInput.getDefinition())) {
							existingInputs.put(blockInput.getDefinition(), blockInput);
						} else {
							for (InputPort port : input.getPorts()) {
								for (Connection connection : new ArrayList<Connection>(port.getConnections())) {
									EcoreUtil.remove(connection);
								}
							}
							it.remove();
						}
					}
				}
				
				for (int i = 0; i < blockType.getInputDefinitions().size(); ++i) {
					InputDefinition definition = blockType.getInputDefinitions().get(i);
					Input existingInput = existingInputs.get(definition);
					if (existingInput != null) {
						block.getInputs().move(i, existingInput);
					} else {
						BlockInput input = DMLFactory.eINSTANCE.createBlockInput();
						input.setDefinition(definition);
						block.getInputs().add(input);

						int portCount = Math.max(definition.getDefaultPortCount(), definition.getMinimumPortCount());
						for (int j = 0; j < portCount; ++j) {
							input.createPort();
						}
					}
				}
				
				Map<OutputDefinition, BlockOutput> existingOutputs = new HashMap<OutputDefinition, BlockOutput>();
				
				for (Iterator<Output> it = block.getOutputs().iterator(); it.hasNext();) {
					Output output = it.next();
					if (output instanceof BlockOutput) {
						BlockOutput blockOutput = (BlockOutput) output;
						if (DMLUtil.isResolved(blockOutput.getDefinition())) {
							existingOutputs.put(blockOutput.getDefinition(), blockOutput);
						} else {
							for (OutputPort port : output.getPorts()) {
								for (Connection connection : new ArrayList<Connection>(port.getConnections())) {
									EcoreUtil.remove(connection);
								}
							}
							it.remove();
						}
					}
				}
				
				for (int i = 0; i < blockType.getOutputDefinitions().size(); ++i) {
					OutputDefinition definition = blockType.getOutputDefinitions().get(i);
					Output existingOutput = existingOutputs.get(definition);
					if (existingOutput != null) {
						block.getOutputs().move(i, existingOutput);
					} else {
						BlockOutput output = DMLFactory.eINSTANCE.createBlockOutput();
						output.setDefinition(definition);
						block.getOutputs().add(output);

						int portCount = Math.max(definition.getDefaultPortCount(), definition.getMinimumPortCount());
						for (int j = 0; j < portCount; ++j) {
							output.createPort();
						}
					}
				}
				
				Map<Parameter, Argument> existingArguments = new HashMap<Parameter, Argument>();
				
				for (Iterator<Argument> it = block.getArguments().iterator(); it.hasNext();) {
					Argument argument = it.next();
					if (DMLUtil.isResolved(argument.getParameter())) {
						existingArguments.put(argument.getParameter(), argument);
					} else {
						it.remove();
					}
				}
				
				for (int i = 0; i < blockType.getParameters().size(); ++i) {
					Parameter parameter = blockType.getParameters().get(i);
					Argument existingArgument = existingArguments.get(parameter);
					if (existingArgument != null) {
						block.getArguments().move(i, existingArgument);
					} else {
						Argument argument = DMLFactory.eINSTANCE.createArgument();
						argument.setValue(parameter.getDefaultValue().copy());
						argument.setParameter(parameter);
						block.getArguments().add(argument);
					}
				}
			}
			
		});
	}

}
