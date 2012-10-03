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

import java.util.Collection;

import org.eclipse.damos.dml.Block;
import org.eclipse.damos.dml.BlockInput;
import org.eclipse.damos.dml.BlockOutput;
import org.eclipse.damos.dml.BlockType;
import org.eclipse.damos.dml.INamedElement;
import org.eclipse.damos.dml.Input;
import org.eclipse.damos.dml.InputDefinition;
import org.eclipse.damos.dml.Output;
import org.eclipse.damos.dml.OutputDefinition;
import org.eclipse.damos.dml.Parameter;
import org.eclipse.damos.dml.util.DMLUtil;
import org.eclipse.damos.ide.core.validation.Problem;
import org.eclipse.damos.ide.ui.IDEUIPlugin;
import org.eclipse.damos.ide.ui.quickfix.AbstractQuickFix;
import org.eclipse.damos.ide.ui.quickfix.IQuickFix;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.graphics.Image;

/**
 * @author Andreas Unger
 *
 */
public abstract class BlockTypeReferenceChangedQuickFix extends AbstractQuickFix {

	/**
	 * 
	 */
	protected static final String BLOCK_TYPE_FILE_EXTENSION = "blocktype";
	
	private final String label;
	private final String description;
	
	private final URI blockURI;
	private final URI blockTypeURI;
	
	protected BlockTypeReferenceChangedQuickFix(String label, String description, URI blockURI, URI blockTypeURI) {
		this.label = label;
		this.description = description;
		this.blockURI = blockURI;
		this.blockTypeURI = blockTypeURI;
	}

	public String getDescription() {
		return description;
	}

	public Image getImage() {
		return IDEUIPlugin.getDefault().getImageRegistry().get(IDEUIPlugin.IMAGE_CORRECTION_CHANGE);
	}

	public String getLabel() {
		return label;
	}

	protected final void run(final Problem problem, final TransactionalEditingDomain editingDomain) {
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain, "Change Block Type") {
			
			@Override
			protected void doExecute() {
				ResourceSet resourceSet = editingDomain.getResourceSet();
				
				EObject eObject = resourceSet.getEObject(blockURI, true);
				if (!(eObject instanceof Block)) {
					return;
				}
				Block block = (Block) eObject;

				eObject = resourceSet.getEObject(blockTypeURI, true);
				if (!(eObject instanceof BlockType)) {
					return;
				}
				
				BlockType blockType = (BlockType) eObject;
				
				block.setType(blockType);

				for (int i = 0; i < blockType.getInputDefinitions().size() && i < block.getInputs().size(); ++i) {
					Input input = block.getInputs().get(i);
					if (input instanceof BlockInput) {
						((BlockInput) input).setDefinition(blockType.getInputDefinitions().get(i));
					}
				}
				
				for (int i = 0; i < blockType.getOutputDefinitions().size() && i < block.getOutputs().size(); ++i) {
					Output output = block.getOutputs().get(i);
					if (output instanceof BlockOutput) {
						((BlockOutput) output).setDefinition(blockType.getOutputDefinitions().get(i));
					}
				}

				for (int i = 0; i < blockType.getParameters().size() && i < block.getArguments().size(); ++i) {
					block.getArguments().get(i).setParameter(blockType.getParameters().get(i));
				}
			}
			
		});
	}

	protected abstract static class BlockTypeReferenceChangedFactory extends AbstractQuickFixFactory {

		public Collection<IQuickFix> createQuickFixes(final Problem problem, final TransactionalEditingDomain editingDomain) throws InstantiationException, IllegalAccessException {
			RunnableWithResult<Collection<IQuickFix>> runnable = new RunnableWithResult.Impl<Collection<IQuickFix>>() {
				
				public void run() {
					setResult(doCreateQuickFixes(problem, editingDomain));
				}
				
			};
			try {
				editingDomain.runExclusive(runnable);
				return runnable.getResult();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			return null;
		}
		
		protected abstract Collection<IQuickFix> doCreateQuickFixes(Problem problem, TransactionalEditingDomain editingDomain);

		protected boolean blockTypeMatches(Block block, BlockType blockType) {
			EList<InputDefinition> inputDefinitions = blockType.getInputDefinitions();
			if (inputDefinitions.size() != block.getInputs().size()) {
				return false;
			}
			
			EList<OutputDefinition> outputDefinitions = blockType.getOutputDefinitions();
			if (outputDefinitions.size() != block.getOutputs().size()) {
				return false;
			}

			EList<Parameter> parameters = blockType.getParameters();
			if (parameters.size() != block.getArguments().size()) {
				return false;
			}

			for (int i = 0; i < inputDefinitions.size(); ++i) {
				Input input = block.getInputs().get(i);
				if (!(input instanceof BlockInput)) {
					return false;
				}
				if (!equalNames(inputDefinitions.get(i), ((BlockInput) input).getDefinition())) {
					return false;
				}
			}
			
			for (int i = 0; i < outputDefinitions.size(); ++i) {
				Output output = block.getOutputs().get(i);
				if (!(output instanceof BlockOutput)) {
					return false;
				}
				if (!equalNames(outputDefinitions.get(i), ((BlockOutput) output).getDefinition())) {
					return false;
				}
			}

			for (int i = 0; i < parameters.size(); ++i) {
				if (!equalNames(parameters.get(i), block.getArguments().get(i).getParameter())) {
					return false;
				}
			}
			
			return true;
		}

		private boolean equalNames(INamedElement namedElement, EObject eObject) {
			String name = namedElement.getName();
			return name != null && name.equals(DMLUtil.extractElementName(EcoreUtil.getURI(eObject)));
		}

	}

}