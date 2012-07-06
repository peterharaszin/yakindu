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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipselabs.damos.mscript.BuiltinDeclaration;
import org.eclipselabs.damos.mscript.ConstantDeclaration;
import org.eclipselabs.damos.mscript.FeatureCall;
import org.eclipselabs.damos.mscript.FunctionDeclaration;
import org.eclipselabs.damos.mscript.IterationCall;
import org.eclipselabs.damos.mscript.MscriptPackage;
import org.eclipselabs.damos.mscript.StateVariableDeclaration;
import org.eclipselabs.damos.mscript.StaticParameterDeclaration;
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
		if (eObject instanceof FunctionDeclaration) {
			highlightFeature(eObject, MscriptPackage.eINSTANCE.getDeclaration_Name(), MscriptHighlightingConfiguration.FUNCTION_ID, acceptor);
		} else if (eObject instanceof FeatureCall) {
			FeatureCall featureCall = (FeatureCall) eObject;
			if (featureCall.getFeature() instanceof StateVariableDeclaration) {
				highlightFeature(eObject, MscriptPackage.eINSTANCE.getFeatureCall_Feature(), MscriptHighlightingConfiguration.STATE_VARIABLE_ID, acceptor);
			} else if (featureCall.getFeature() instanceof ConstantDeclaration) {
				highlightFeature(eObject, MscriptPackage.eINSTANCE.getFeatureCall_Feature(), MscriptHighlightingConfiguration.CONSTANT_ID, acceptor);
			} else if (featureCall.getFeature() instanceof StaticParameterDeclaration) {
				highlightFeature(eObject, MscriptPackage.eINSTANCE.getFeatureCall_Feature(), MscriptHighlightingConfiguration.STATIC_PARAMETER_ID, acceptor);
			} else if (featureCall.getFeature() instanceof BuiltinDeclaration) {
				highlightFeature(eObject, MscriptPackage.eINSTANCE.getFeatureCall_Feature(), MscriptHighlightingConfiguration.BUILTIN_ID, acceptor);
			}
		} else if (eObject instanceof ConstantDeclaration) {
			highlightFeature(eObject, MscriptPackage.eINSTANCE.getVariableDeclaration_Name(), MscriptHighlightingConfiguration.CONSTANT_ID, acceptor);
		} else if (eObject instanceof StaticParameterDeclaration) {
			highlightFeature(eObject, MscriptPackage.eINSTANCE.getVariableDeclaration_Name(), MscriptHighlightingConfiguration.STATIC_PARAMETER_ID, acceptor);
		} else if (eObject instanceof StateVariableDeclaration) {
			highlightFeature(eObject, MscriptPackage.eINSTANCE.getVariableDeclaration_Name(), MscriptHighlightingConfiguration.STATE_VARIABLE_ID, acceptor);
		} else if (eObject instanceof IterationCall) {
			highlightFeature(eObject, MscriptPackage.eINSTANCE.getIterationCall_Identifier(), MscriptHighlightingConfiguration.ITERATION_ID, acceptor);
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
	
	private void highlightFeature(EObject eObject, EStructuralFeature structuralFeature, String id, IHighlightedPositionAcceptor acceptor) {
		List<INode> nodes = NodeModelUtils.findNodesForFeature(eObject, structuralFeature);
		for (INode node : nodes) {
			acceptor.addPosition(node.getOffset(), node.getLength(), id);
		}
	}

}
