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

package org.eclipse.damos.mscript.ui.syntaxcoloring;

import java.util.List;

import org.eclipse.damos.mscript.BuiltinDeclaration;
import org.eclipse.damos.mscript.ConstantDeclaration;
import org.eclipse.damos.mscript.ExpressionCheckArgument;
import org.eclipse.damos.mscript.FeatureReference;
import org.eclipse.damos.mscript.FunctionDeclaration;
import org.eclipse.damos.mscript.InputParameterDeclaration;
import org.eclipse.damos.mscript.MscriptPackage;
import org.eclipse.damos.mscript.StandardFunctionDeclaration;
import org.eclipse.damos.mscript.StateVariableDeclaration;
import org.eclipse.damos.mscript.StepExpression;
import org.eclipse.damos.mscript.Unit;
import org.eclipse.damos.mscript.VariableDeclaration;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;

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
		if (eObject instanceof StandardFunctionDeclaration) {
			FunctionDeclaration functionDeclaration = (FunctionDeclaration) eObject;
			highlightFeature(functionDeclaration, MscriptPackage.eINSTANCE.getStandardFunctionDeclaration_Name(), MscriptHighlightingConfiguration.FUNCTION_ID, acceptor);
		} else if (eObject instanceof FeatureReference) {
			FeatureReference featureReference = (FeatureReference) eObject;
			if (featureReference.getFeature() instanceof StateVariableDeclaration) {
				highlightFeature(eObject, MscriptPackage.eINSTANCE.getFeatureReference_Feature(), MscriptHighlightingConfiguration.STATE_VARIABLE_ID, acceptor);
			} else if (featureReference.getFeature() instanceof ConstantDeclaration) {
				highlightFeature(eObject, MscriptPackage.eINSTANCE.getFeatureReference_Feature(), MscriptHighlightingConfiguration.CONSTANT_ID, acceptor);
			} else if (featureReference.getFeature() instanceof InputParameterDeclaration) {
				InputParameterDeclaration inputParameterDeclaration = (InputParameterDeclaration) featureReference.getFeature();
				if (inputParameterDeclaration.isConstant()) {
					highlightFeature(eObject, MscriptPackage.eINSTANCE.getFeatureReference_Feature(), MscriptHighlightingConfiguration.CONSTANT_ID, acceptor);
				}
			} else if (featureReference.getFeature() instanceof BuiltinDeclaration) {
				highlightFeature(eObject, MscriptPackage.eINSTANCE.getFeatureReference_Feature(), MscriptHighlightingConfiguration.BUILTIN_ID, acceptor);
			}
		} else if (eObject instanceof VariableDeclaration) {
			VariableDeclaration variableDeclaration = (VariableDeclaration) eObject;
			if (variableDeclaration instanceof ConstantDeclaration) {
				highlightFeature(variableDeclaration, variableDeclaration.getNameFeature(), MscriptHighlightingConfiguration.CONSTANT_ID, acceptor);
			} else if (variableDeclaration instanceof InputParameterDeclaration) {
				InputParameterDeclaration inputParameterDeclaration = (InputParameterDeclaration) variableDeclaration;
				if (inputParameterDeclaration.isConstant()) {
					highlightFeature(variableDeclaration, variableDeclaration.getNameFeature(), MscriptHighlightingConfiguration.CONSTANT_ID, acceptor);
				}
			} else if (variableDeclaration instanceof StateVariableDeclaration) {
				highlightFeature(variableDeclaration, variableDeclaration.getNameFeature(), MscriptHighlightingConfiguration.STATE_VARIABLE_ID, acceptor);
			}
		} else if (eObject instanceof Unit) {
			INode node = NodeModelUtils.getNode(eObject);
			acceptor.addPosition(node.getOffset(), node.getLength(), MscriptHighlightingConfiguration.UNIT_ID);
			proceed = false;
		} else if (eObject instanceof StepExpression) {
			INode node = NodeModelUtils.getNode(eObject);
			acceptor.addPosition(node.getOffset(), node.getLength(), MscriptHighlightingConfiguration.STEP_EXPRESSION_ID);
			proceed = false;
		} else if (eObject instanceof ExpressionCheckArgument) {
			INode node = NodeModelUtils.getNode(eObject);
			acceptor.addPosition(node.getOffset(), 1, MscriptHighlightingConfiguration.CHECK_EXPRESSION_DELIMITER_ID);
			acceptor.addPosition(node.getTotalEndOffset() - 1, 1, MscriptHighlightingConfiguration.CHECK_EXPRESSION_DELIMITER_ID);
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
