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

package org.eclipselabs.damos.mscript.resource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.DefaultLocationInFileProvider;

/**
 * @author Andreas Unger
 *
 */
public class MscriptLocationInFileProvider extends DefaultLocationInFileProvider {

	/**
	 * Fix for NPE when invoking <code>sibling.getGrammarElement()</code>.
	 * 
	 * @see org.eclipse.xtext.resource.DefaultLocationInFileProvider#findNodeFor(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	protected ICompositeNode findNodeFor(EObject semanticObject) {
		ICompositeNode result = NodeModelUtils.getNode(semanticObject);
		if (result != null) {
			ICompositeNode node = result;
			while (GrammarUtil.containingAssignment(node.getGrammarElement()) == null && node.getParent() != null && !node.getParent().hasDirectSemanticElement()) {
				ICompositeNode parent = node.getParent();
				if (node.hasSiblings()) {
					for(INode sibling : parent.getChildren()) {
						EObject grammarElement = sibling.getGrammarElement();
						if (grammarElement != null && GrammarUtil.containingAssignment(grammarElement) != null) {
							result = parent;
						}
					}
				}
				node = parent;
			}
		}
		return result;
	}
	
}
