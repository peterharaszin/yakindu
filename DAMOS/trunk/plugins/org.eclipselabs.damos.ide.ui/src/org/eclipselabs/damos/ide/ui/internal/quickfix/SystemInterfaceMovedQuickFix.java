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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.Subsystem;
import org.eclipselabs.damos.dml.SystemInterface;
import org.eclipselabs.damos.ide.core.validation.Problem;
import org.eclipselabs.damos.ide.ui.IDEUIPlugin;
import org.eclipselabs.damos.ide.ui.internal.util.ProblemUtil;
import org.eclipselabs.damos.ide.ui.quickfix.IQuickFix;

/**
 * @author Andreas Unger
 *
 */
public class SystemInterfaceMovedQuickFix extends SystemInterfaceReferenceChangedQuickFix {

	public static final Factory FACTORY = new Factory();
		
	private SystemInterfaceMovedQuickFix(String label, String description, URI subsystemURI, URI interfaceURI) {
		super(label, description, subsystemURI, interfaceURI);
	}
	
	private static class Factory extends SystemInterfaceReferenceChangedFactory {

		protected Collection<IQuickFix> doCreateQuickFixes(Problem problem, final TransactionalEditingDomain editingDomain) {
			URI uri = ProblemUtil.getPlatformResourceElementURI(problem);
			if (uri == null) {
				return Collections.emptyList();
			}
			
			final Subsystem subsystem = (Subsystem) editingDomain.getResourceSet().getEObject(uri, true);
			if (subsystem == null) {
				return Collections.emptyList();
			}
			
			SystemInterface oldInterface_ = subsystem.getInterface();
			if (oldInterface_ == null) {
				return Collections.emptyList();
			}
			
			final String interfaceFileName = EcoreUtil.getURI(oldInterface_).lastSegment();
			if (interfaceFileName == null) {
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
						if (resource instanceof IFile && interfaceFileName.equals(resource.getName())) {
							IPath path = resource.getFullPath();
							URI newURI = URI.createPlatformResourceURI(path.toString(), true);
							Resource emfResource = editingDomain.getResourceSet().getResource(newURI, true);
							if (emfResource != null) {
								SystemInterface interface_ = (SystemInterface) EcoreUtil.getObjectByType(emfResource.getContents(), DMLPackage.eINSTANCE.getSystemInterface());
								if (interface_ != null && systemInterfaceMatches(subsystem, interface_)) {
									SystemInterfaceMovedQuickFix quickFix = new SystemInterfaceMovedQuickFix(
											"Change interface to " + path.makeRelative(), null,
											EcoreUtil.getURI(subsystem), EcoreUtil.getURI(interface_));
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
