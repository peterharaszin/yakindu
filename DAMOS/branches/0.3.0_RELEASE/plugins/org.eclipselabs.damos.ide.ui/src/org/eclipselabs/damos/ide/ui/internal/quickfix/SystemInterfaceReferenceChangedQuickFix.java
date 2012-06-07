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

package org.eclipselabs.damos.ide.ui.internal.quickfix;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.graphics.Image;
import org.eclipselabs.damos.dml.INamedElement;
import org.eclipselabs.damos.dml.Inlet;
import org.eclipselabs.damos.dml.Input;
import org.eclipselabs.damos.dml.Outlet;
import org.eclipselabs.damos.dml.Output;
import org.eclipselabs.damos.dml.Subsystem;
import org.eclipselabs.damos.dml.SubsystemInput;
import org.eclipselabs.damos.dml.SubsystemOutput;
import org.eclipselabs.damos.dml.SystemInterface;
import org.eclipselabs.damos.dml.util.DMLUtil;
import org.eclipselabs.damos.ide.core.validation.Problem;
import org.eclipselabs.damos.ide.ui.IDEUIPlugin;
import org.eclipselabs.damos.ide.ui.quickfix.AbstractQuickFix;
import org.eclipselabs.damos.ide.ui.quickfix.IQuickFix;

/**
 * @author Andreas Unger
 *
 */
public abstract class SystemInterfaceReferenceChangedQuickFix extends AbstractQuickFix {

	/**
	 * 
	 */
	protected static final String SYSTEM_INTERFACE_FILE_EXTENSION = "systeminterface";
	
	private final String label;
	private final String description;
	
	private final URI subsystemURI;
	private final URI interfaceURI;
	
	protected SystemInterfaceReferenceChangedQuickFix(String label, String description, URI subsystemURI, URI interfaceURI) {
		this.label = label;
		this.description = description;
		this.subsystemURI = subsystemURI;
		this.interfaceURI = interfaceURI;
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
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain, "Change System Interface") {
			
			@Override
			protected void doExecute() {
				ResourceSet resourceSet = editingDomain.getResourceSet();
				
				EObject eObject = resourceSet.getEObject(subsystemURI, true);
				if (!(eObject instanceof Subsystem)) {
					return;
				}
				Subsystem subsystem = (Subsystem) eObject;

				eObject = resourceSet.getEObject(interfaceURI, true);
				if (!(eObject instanceof SystemInterface)) {
					return;
				}
				
				SystemInterface interface_ = (SystemInterface) eObject;
				
				subsystem.setInterface(interface_);

				for (int i = 0; i < interface_.getInlets().size() && i < subsystem.getInputs().size(); ++i) {
					Input input = subsystem.getInputs().get(i);
					if (input instanceof SubsystemInput) {
						((SubsystemInput) input).setInlet(interface_.getInlets().get(i));
					}
				}
				
				for (int i = 0; i < interface_.getOutlets().size() && i < subsystem.getOutputs().size(); ++i) {
					Output output = subsystem.getOutputs().get(i);
					if (output instanceof SubsystemOutput) {
						((SubsystemOutput) output).setOutlet(interface_.getOutlets().get(i));
					}
				}
			}
			
		});
	}

	protected abstract static class SystemInterfaceReferenceChangedFactory extends AbstractQuickFixFactory {

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

		protected boolean systemInterfaceMatches(Subsystem subsystem, SystemInterface interface_) {
			EList<Inlet> inlets = interface_.getInlets();
			if (inlets.size() != subsystem.getInputs().size()) {
				return false;
			}
			
			EList<Outlet> outlets = interface_.getOutlets();
			if (outlets.size() != subsystem.getOutputs().size()) {
				return false;
			}

			for (int i = 0; i < inlets.size(); ++i) {
				Input input = subsystem.getInputs().get(i);
				if (!(input instanceof SubsystemInput)) {
					return false;
				}
				if (!equalNames(inlets.get(i), ((SubsystemInput) input).getInlet())) {
					return false;
				}
			}
			
			for (int i = 0; i < outlets.size(); ++i) {
				Output output = subsystem.getOutputs().get(i);
				if (!(output instanceof SubsystemOutput)) {
					return false;
				}
				if (!equalNames(outlets.get(i), ((SubsystemOutput) output).getOutlet())) {
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