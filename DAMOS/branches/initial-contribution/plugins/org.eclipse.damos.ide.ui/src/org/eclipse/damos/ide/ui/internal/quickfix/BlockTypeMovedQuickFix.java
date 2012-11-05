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
import org.eclipse.damos.dml.Block;
import org.eclipse.damos.dml.BlockType;
import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.ide.core.validation.Problem;
import org.eclipse.damos.ide.ui.IDEUIPlugin;
import org.eclipse.damos.ide.ui.internal.util.ProblemUtil;
import org.eclipse.damos.ide.ui.quickfix.IQuickFix;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

/**
 * @author Andreas Unger
 *
 */
public class BlockTypeMovedQuickFix extends BlockTypeReferenceChangedQuickFix {

	public static final Factory FACTORY = new Factory();
		
	private BlockTypeMovedQuickFix(String label, String description, URI blockURI, URI blockTypeURI) {
		super(label, description, blockURI, blockTypeURI);
	}
	
	private static class Factory extends BlockTypeReferenceChangedFactory {

		protected Collection<IQuickFix> doCreateQuickFixes(Problem problem, final TransactionalEditingDomain editingDomain) {
			final URI uri = ProblemUtil.getPlatformResourceElementURI(problem);
			if (uri == null) {
				return Collections.emptyList();
			}
			
			final Block block = (Block) editingDomain.getResourceSet().getEObject(uri, true);
			if (block == null) {
				return Collections.emptyList();
			}
			
			BlockType oldBlockType = block.getType();
			if (oldBlockType == null) {
				return Collections.emptyList();
			}
			
			final String blockTypeFileName = EcoreUtil.getURI(oldBlockType).lastSegment();
			if (blockTypeFileName == null) {
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
						if (resource instanceof IFile && blockTypeFileName.equals(resource.getName())) {
							IPath path = resource.getFullPath();
							URI newURI = URI.createPlatformResourceURI(path.toString(), true);
							Resource emfResource = editingDomain.getResourceSet().getResource(newURI, true);
							if (emfResource != null) {
								BlockType blockType = (BlockType) EcoreUtil.getObjectByType(emfResource.getContents(), DMLPackage.eINSTANCE.getBlockType());
								if (blockType != null && blockTypeMatches(block, blockType)) {
									BlockTypeMovedQuickFix quickFix = new BlockTypeMovedQuickFix(
											"Change block type to " + path.makeRelative(), null,
											uri, EcoreUtil.getURI(blockType));
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
