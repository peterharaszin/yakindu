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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.BlockType;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.ide.core.validation.Problem;
import org.eclipselabs.damos.ide.ui.IDEUIPlugin;
import org.eclipselabs.damos.ide.ui.internal.util.ProblemUtil;
import org.eclipselabs.damos.ide.ui.quickfix.IQuickFix;

/**
 * @author Andreas Unger
 *
 */
public class BlockTypeRenamedQuickFix extends BlockTypeReferenceChangedQuickFix {

	public static final Factory FACTORY = new Factory();
		
	private BlockTypeRenamedQuickFix(String label, String description, URI blockURI, URI blockTypeURI) {
		super(label, description, blockURI, blockTypeURI);
	}
	
	private static class Factory extends BlockTypeReferenceChangedFactory {

		protected Collection<IQuickFix> doCreateQuickFixes(Problem problem, TransactionalEditingDomain editingDomain) {
			URI uri = ProblemUtil.getPlatformResourceElementURI(problem);
			if (uri == null) {
				return Collections.emptyList();
			}
				
			Block block = (Block) editingDomain.getResourceSet().getEObject(uri, true);
			if (block == null) {
				return Collections.emptyList();
			}

			BlockType oldBlockType = block.getType();
			if (oldBlockType == null) {
				return Collections.emptyList();
			}
			
			URI containerURI = EcoreUtil.getURI(oldBlockType).trimFragment().trimSegments(1);
			IResource container = ResourcesPlugin.getWorkspace().getRoot().findMember(containerURI.toPlatformString(true));
			if (!(container instanceof IContainer)) {
				return Collections.emptyList();
			}

			List<IQuickFix> quickFixes = new ArrayList<IQuickFix>();
			try {
				for (IResource member : ((IContainer) container).members()) {
					if (member instanceof IFile && BLOCK_TYPE_FILE_EXTENSION.equals(member.getFileExtension())) {
						URI newURI = URI.createPlatformResourceURI(member.getFullPath().toString(), true);
						Resource resource = editingDomain.getResourceSet().getResource(newURI, true);
						if (resource != null) {
							BlockType blockType = (BlockType) EcoreUtil.getObjectByType(resource.getContents(), DMLPackage.eINSTANCE.getBlockType());
							if (blockType != null && blockTypeMatches(block, blockType)) {
								BlockTypeRenamedQuickFix quickFix = new BlockTypeRenamedQuickFix(
										"Change block type to " + member.getFullPath().lastSegment(), null,
										EcoreUtil.getURI(block), EcoreUtil.getURI(blockType));
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
