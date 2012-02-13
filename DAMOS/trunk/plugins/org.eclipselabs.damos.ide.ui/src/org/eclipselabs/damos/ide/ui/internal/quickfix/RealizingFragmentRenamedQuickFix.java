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
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.Subsystem;
import org.eclipselabs.damos.dml.SubsystemRealization;
import org.eclipselabs.damos.dml.SystemInterface;
import org.eclipselabs.damos.ide.core.validation.Problem;
import org.eclipselabs.damos.ide.ui.IDEUIPlugin;
import org.eclipselabs.damos.ide.ui.internal.util.ProblemUtil;
import org.eclipselabs.damos.ide.ui.quickfix.IQuickFix;

/**
 * @author Andreas Unger
 *
 */
public class RealizingFragmentRenamedQuickFix extends RealizingFragmentReferenceChangedQuickFix {

	public static final Factory FACTORY = new Factory();
		
	private RealizingFragmentRenamedQuickFix(String label, String description, URI realizationURI, URI contextFragmentURI) {
		super(label, description, realizationURI, contextFragmentURI);
	}
	
	private static class Factory extends RealizingFragmentReferenceChangedFactory {

		protected Collection<IQuickFix> doCreateQuickFixes(Problem problem, TransactionalEditingDomain editingDomain) {
			URI uri = ProblemUtil.getPlatformResourceElementURI(problem);
			if (uri == null) {
				return Collections.emptyList();
			}
				
			SubsystemRealization realization = (SubsystemRealization) editingDomain.getResourceSet().getEObject(uri, true);
			if (realization == null) {
				return Collections.emptyList();
			}

			Subsystem subsystem = realization.getRealizedSubsystem();
			if (subsystem == null) {
				return Collections.emptyList();
			}
			
			SystemInterface interface_ = subsystem.getInterface();
			if (interface_ == null) {
				return Collections.emptyList();
			}
			
			Fragment oldRealizingFragment = realization.getRealizingFragment();
			URI oldRealizingFragmentURI = EcoreUtil.getURI(oldRealizingFragment);

			URI containerURI = oldRealizingFragmentURI.trimFragment().trimSegments(1);
			IResource container = ResourcesPlugin.getWorkspace().getRoot().findMember(containerURI.toPlatformString(true));
			if (!(container instanceof IContainer)) {
				return Collections.emptyList();
			}

			List<IQuickFix> quickFixes = new ArrayList<IQuickFix>();
			try {
				for (IResource member : ((IContainer) container).members()) {
					if (member instanceof IFile && BLOCK_DIAGRAM_FILE_EXTENSION.equals(member.getFileExtension())) {
						URI newURI = URI.createPlatformResourceURI(member.getFullPath().toString(), true).appendFragment(oldRealizingFragmentURI.fragment());
						EObject eObject = editingDomain.getResourceSet().getEObject(newURI, true);
						if (eObject instanceof Fragment) {
							Fragment contextFragment = (Fragment) eObject;
							if (systemInterfaceMatches(contextFragment, interface_)) {
								String name = contextFragment.getName();
								if (name == null) {
									name = "UNNAMED";
								}
								RealizingFragmentRenamedQuickFix quickFix = new RealizingFragmentRenamedQuickFix(
										"Change realizing fragment to " + name + " in " + member.getFullPath().lastSegment(), null,
										uri, EcoreUtil.getURI(contextFragment));
								quickFixes.add(quickFix);
							}
						}
					}
				}
			} catch (CoreException e) {
				IDEUIPlugin.getDefault().getLog().log(e.getStatus());
			}

			return quickFixes;
		}

	}
	
}
