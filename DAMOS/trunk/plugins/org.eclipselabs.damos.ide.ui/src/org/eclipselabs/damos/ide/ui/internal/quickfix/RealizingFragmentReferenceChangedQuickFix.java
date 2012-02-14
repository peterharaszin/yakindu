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
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.graphics.Image;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.Inlet;
import org.eclipselabs.damos.dml.Inport;
import org.eclipselabs.damos.dml.Outlet;
import org.eclipselabs.damos.dml.Outport;
import org.eclipselabs.damos.dml.SubsystemRealization;
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
public abstract class RealizingFragmentReferenceChangedQuickFix extends AbstractQuickFix {

	/**
	 * 
	 */
	protected static final String BLOCK_DIAGRAM_FILE_EXTENSION = "blockdiagram";
	
	private final String label;
	private final String description;
	
	private final URI realizationURI;
	private final URI contextFragmentURI;
	
	protected RealizingFragmentReferenceChangedQuickFix(String label, String description, URI realizationURI, URI contextFragmentURI) {
		this.label = label;
		this.description = description;
		this.realizationURI = realizationURI;
		this.contextFragmentURI = contextFragmentURI;
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
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain, "Change Realizing Fragment") {
			
			@Override
			protected void doExecute() {
				ResourceSet resourceSet = editingDomain.getResourceSet();
				
				EObject eObject = resourceSet.getEObject(realizationURI, true);
				if (!(eObject instanceof SubsystemRealization)) {
					return;
				}
				SubsystemRealization realization = (SubsystemRealization) eObject;

				eObject = resourceSet.getEObject(contextFragmentURI, true);
				if (!(eObject instanceof Fragment)) {
					return;
				}
				
				Fragment fragment = (Fragment) eObject;
				
				realization.setRealizingFragment(fragment);
			}
			
		});
	}

	protected abstract static class RealizingFragmentReferenceChangedFactory extends AbstractQuickFixFactory {

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

		protected boolean systemInterfaceMatches(Fragment contextFragment, SystemInterface interface_) {
			Map<String, Inport> inports = DMLUtil.getComponentMap(contextFragment, Inport.class);
			Map<String, Outport> outports = DMLUtil.getComponentMap(contextFragment, Outport.class);
			
			EList<Inlet> inlets = interface_.getInlets();
			if (inlets.size() != inports.size()) {
				return false;
			}
			
			EList<Outlet> outlets = interface_.getOutlets();
			if (outlets.size() != outports.size()) {
				return false;
			}

			for (Inlet inlet : interface_.getInlets()) {
				if (!inports.containsKey(inlet.getName())) {
					return false;
				}
			}
			
			for (Outlet outlet : interface_.getOutlets()) {
				if (!outports.containsKey(outlet.getName())) {
					return false;
				}
			}
			
			return true;
		}

	}

}