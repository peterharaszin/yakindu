/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.mscript.ui.syntaxcoloring;

import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipselabs.damos.mscript.BuiltinDeclaration;
import org.eclipselabs.damos.mscript.ConstantStringSegment;
import org.eclipselabs.damos.mscript.FeatureCall;
import org.eclipselabs.damos.mscript.FunctionDeclaration;
import org.eclipselabs.damos.mscript.IterationCall;
import org.eclipselabs.damos.mscript.MscriptPackage;
import org.eclipselabs.damos.mscript.MultiLineStringLiteral;
import org.eclipselabs.damos.mscript.StepExpression;
import org.eclipselabs.damos.mscript.Unit;

/**
 * @author Andreas Unger
 *
 */
public class MscriptSemanticHighlightingCalculator implements ISemanticHighlightingCalculator {

	/* (non-Javadoc)
	 * @see org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator#provideHighlightingFor(org.eclipse.xtext.resource.XtextResource, org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor)
	 */
	public void provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
		if (resource == null || resource.getParseResult() == null) {
			return;
		}

		EObject root = resource.getParseResult().getRootASTElement();
		if (root == null) {
			return;
		}
		
		for (TreeIterator<EObject> it = root.eAllContents(); it.hasNext();) {
			EObject next = it.next();
			if (!provideHighlightingFor(next, acceptor)) {
				it.prune();
			}
		}
	}
	
	protected boolean provideHighlightingFor(EObject eObject, IHighlightedPositionAcceptor acceptor) {
		boolean proceed = true;
		if (eObject instanceof ConstantStringSegment) {
			INode node = NodeModelUtils.getNode(eObject);
			acceptor.addPosition(node.getOffset(), node.getLength(), MscriptHighlightingConfiguration.MULTI_LINE_STRING_ID);
			proceed = false;
		} else if (eObject instanceof MultiLineStringLiteral) {
			INode node = NodeModelUtils.findActualNodeFor(eObject);
			acceptor.addPosition(node.getOffset(), 3, MscriptHighlightingConfiguration.MULTI_LINE_STRING_ID);
			acceptor.addPosition(node.getTotalEndOffset() - 3, 3, MscriptHighlightingConfiguration.MULTI_LINE_STRING_ID);
		} else if (eObject instanceof FunctionDeclaration) {
			List<INode> nodes = NodeModelUtils.findNodesForFeature(eObject, MscriptPackage.eINSTANCE.getDeclaration_Name());
			for (INode node : nodes) {
				acceptor.addPosition(node.getOffset(), node.getLength(), MscriptHighlightingConfiguration.FUNCTION_ID);
			}
		} else if (eObject instanceof FeatureCall) {
			FeatureCall featureCall = (FeatureCall) eObject;
			if (featureCall.getFeature() instanceof BuiltinDeclaration) {
				List<INode> nodes = NodeModelUtils.findNodesForFeature(featureCall, MscriptPackage.eINSTANCE.getFeatureCall_Feature());
				for (INode node : nodes) {
					acceptor.addPosition(node.getOffset(), node.getLength(), MscriptHighlightingConfiguration.BUILTIN_ID);
				}
			}
		} else if (eObject instanceof IterationCall) {
			List<INode> nodes = NodeModelUtils.findNodesForFeature(eObject, MscriptPackage.eINSTANCE.getIterationCall_Identifier());
			for (INode node : nodes) {
				acceptor.addPosition(node.getOffset(), node.getLength(), MscriptHighlightingConfiguration.ITERATION_ID);
			}
		} else if (eObject instanceof Unit) {
			INode node = NodeModelUtils.getNode(eObject);
			acceptor.addPosition(node.getOffset(), node.getLength(), MscriptHighlightingConfiguration.UNIT_ID);
			proceed = false;
		} else if (eObject instanceof StepExpression) {
			INode node = NodeModelUtils.getNode(eObject);
			acceptor.addPosition(node.getOffset(), node.getLength(), MscriptHighlightingConfiguration.STEP_EXPRESSION_ID);
			proceed = false;
		}
		return proceed;
	}

}
