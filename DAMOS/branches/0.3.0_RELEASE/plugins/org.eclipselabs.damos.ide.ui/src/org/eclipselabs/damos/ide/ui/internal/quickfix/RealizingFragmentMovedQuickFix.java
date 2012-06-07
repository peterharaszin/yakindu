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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
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
public class RealizingFragmentMovedQuickFix extends RealizingFragmentReferenceChangedQuickFix {

	public static final Factory FACTORY = new Factory();
		
	private RealizingFragmentMovedQuickFix(String label, String description, URI realizationURI, URI contextFragmentURI) {
		super(label, description, realizationURI, contextFragmentURI);
	}
	
	private static class Factory extends RealizingFragmentReferenceChangedFactory {

		protected Collection<IQuickFix> doCreateQuickFixes(Problem problem, final TransactionalEditingDomain editingDomain) {
			final URI uri = ProblemUtil.getPlatformResourceElementURI(problem);
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

			final SystemInterface interface_ = subsystem.getInterface();
			if (interface_ == null) {
				return Collections.emptyList();
			}

			Fragment oldRealizingFragment = realization.getRealizingFragment();
			final URI oldRealizingFragmentURI = EcoreUtil.getURI(oldRealizingFragment);
			
			final String blockDiagramFileName = oldRealizingFragmentURI.lastSegment();
			if (blockDiagramFileName == null) {
				return Collections.emptyList();
			}

			if (uri.segmentCount() < 2) {
				return Collections.emptyList();
			}
			
			String projectName = uri.segment(1);
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
			if (project == null) {
				return Collections.emptyList();
			}
			
			final List<IQuickFix> quickFixes = new ArrayList<IQuickFix>();
			try {
				project.accept(new IResourceVisitor() {
					
					public boolean visit(IResource resource) throws CoreException {
						if (resource instanceof IFile && blockDiagramFileName.equals(resource.getName())) {
							IPath path = resource.getFullPath();
							URI newURI = URI.createPlatformResourceURI(path.toString(), true).appendFragment(oldRealizingFragmentURI.fragment());
							EObject eObject = editingDomain.getResourceSet().getEObject(newURI, true);
							if (eObject instanceof Fragment) {
								Fragment contextFragment = (Fragment) eObject;
								if (systemInterfaceMatches(contextFragment, interface_)) {
									String name = contextFragment.getName();
									if (name == null) {
										name = "UNNAMED";
									}
									RealizingFragmentMovedQuickFix quickFix = new RealizingFragmentMovedQuickFix(
											"Change realizing fragment to " + name + " in " + path.makeRelative(), null,
											uri, EcoreUtil.getURI(contextFragment));
									quickFixes.add(quickFix);
								}
							}
							return false;
						}
						return true;
					}
					
				});
			} catch (CoreException e) {
				IDEUIPlugin.getDefault().getLog().log(e.getStatus());
			}

			return quickFixes;
		}

	}
	
}
