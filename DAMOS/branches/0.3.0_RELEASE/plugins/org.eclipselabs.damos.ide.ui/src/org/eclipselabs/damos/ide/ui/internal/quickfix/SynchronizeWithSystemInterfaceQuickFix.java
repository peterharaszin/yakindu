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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.graphics.Image;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.DMLFactory;
import org.eclipselabs.damos.dml.Inlet;
import org.eclipselabs.damos.dml.Input;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.Outlet;
import org.eclipselabs.damos.dml.Output;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.dml.Subsystem;
import org.eclipselabs.damos.dml.SubsystemInput;
import org.eclipselabs.damos.dml.SubsystemOutput;
import org.eclipselabs.damos.dml.SystemInterface;
import org.eclipselabs.damos.dml.util.DMLUtil;
import org.eclipselabs.damos.ide.core.validation.Problem;
import org.eclipselabs.damos.ide.ui.IDEUIPlugin;
import org.eclipselabs.damos.ide.ui.quickfix.AbstractQuickFix;

/**
 * @author Andreas Unger
 *
 */
public class SynchronizeWithSystemInterfaceQuickFix extends AbstractQuickFix {

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.ide.ui.quickfix.IQuickFix#getDescription()
	 */
	public String getDescription() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.ide.ui.quickfix.IQuickFix#getImage()
	 */
	public Image getImage() {
		return IDEUIPlugin.getDefault().getImageRegistry().get(IDEUIPlugin.IMAGE_CORRECTION_SYNCHRONIZE);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.ide.ui.quickfix.IQuickFix#getLabel()
	 */
	public String getLabel() {
		return "Synchronize with interface";
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.ide.ui.quickfix.AbstractQuickFix#run(org.eclipselabs.damos.ide.core.validation.Problem, org.eclipse.emf.transaction.TransactionalEditingDomain)
	 */
	@Override
	protected void run(final Problem problem, final TransactionalEditingDomain editingDomain) {
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain, "Synchronize with Interface") {
			
			@Override
			protected void doExecute() {
				URI uri = problem.getElementURI();
				
				ResourceSet resourceSet = editingDomain.getResourceSet();
				
				EObject eObject = resourceSet.getEObject(uri, true);
				if (eObject == null) {
					return;
				}
				
				Subsystem subsystem = DMLUtil.getOwner(eObject, Subsystem.class);
				if (subsystem == null) {
					return;
				}

				SystemInterface interface_ = subsystem.getInterface();
				if (interface_ == null) {
					return;
				}
				
				Map<Inlet, SubsystemInput> existingInputs = new HashMap<Inlet, SubsystemInput>();
				
				for (Iterator<Input> it = subsystem.getInputs().iterator(); it.hasNext();) {
					Input input = it.next();
					if (input instanceof SubsystemInput) {
						SubsystemInput subsystemInput = (SubsystemInput) input;
						if (DMLUtil.isResolved(subsystemInput.getInlet())) {
							existingInputs.put(subsystemInput.getInlet(), subsystemInput);
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
				
				for (int i = 0; i < interface_.getInlets().size(); ++i) {
					Inlet inlet = interface_.getInlets().get(i);
					Input existingInput = existingInputs.get(inlet);
					if (existingInput != null) {
						subsystem.getInputs().move(i, existingInput);
					} else {
						SubsystemInput input = DMLFactory.eINSTANCE.createSubsystemInput();
						input.setInlet(inlet);
						subsystem.getInputs().add(input);
						input.createPort();
					}
				}
				
				Map<Outlet, SubsystemOutput> existingOutputs = new HashMap<Outlet, SubsystemOutput>();
				
				for (Iterator<Output> it = subsystem.getOutputs().iterator(); it.hasNext();) {
					Output output = it.next();
					if (output instanceof SubsystemOutput) {
						SubsystemOutput subsystemOutput = (SubsystemOutput) output;
						if (DMLUtil.isResolved(subsystemOutput.getOutlet())) {
							existingOutputs.put(subsystemOutput.getOutlet(), subsystemOutput);
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
				
				for (int i = 0; i < interface_.getOutlets().size(); ++i) {
					Outlet outlet = interface_.getOutlets().get(i);
					Output existingOutput = existingOutputs.get(outlet);
					if (existingOutput != null) {
						subsystem.getOutputs().move(i, existingOutput);
					} else {
						SubsystemOutput output = DMLFactory.eINSTANCE.createSubsystemOutput();
						output.setOutlet(outlet);
						subsystem.getOutputs().add(output);
						output.createPort();
					}
				}
			}
			
		});
	}

}
