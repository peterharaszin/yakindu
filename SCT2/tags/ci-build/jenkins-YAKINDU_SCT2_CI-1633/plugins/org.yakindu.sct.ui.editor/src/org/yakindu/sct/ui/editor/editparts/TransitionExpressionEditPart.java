/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.editparts;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager;
import org.eclipse.gmf.runtime.notation.StringValueStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.yakindu.base.base.BasePackage;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.ui.editor.commands.ToggleShowDocumentationCommand;
import org.yakindu.sct.ui.editor.extensions.ExpressionLanguageProviderExtensions.SemanticTarget;
import org.yakindu.sct.ui.editor.policies.ContextSensitiveHelpPolicy;
import org.yakindu.sct.ui.editor.policies.TransitionExpressionComponentEditPolicy;
import org.yakindu.sct.ui.editor.utils.GMFNotationUtil;
import org.yakindu.sct.ui.editor.utils.HelpContextIds;

import de.itemis.xtext.utils.gmf.directedit.IXtextAwareEditPart;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class TransitionExpressionEditPart extends PlugableExternalXtextLabelEditPart implements IXtextAwareEditPart {

	public TransitionExpressionEditPart(View view) {
		super(view, SemanticTarget.TransitionSpecification);
	}

	@Override
	protected DirectEditManager createDirectEditManager() {
		if (getAttribute() == BasePackage.Literals.DOCUMENTED_ELEMENT__DOCUMENTATION)
			return new TextDirectEditManager(this);
		return super.createDirectEditManager();
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new TransitionExpressionComponentEditPolicy());
		installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, new ContextSensitiveHelpPolicy(
				HelpContextIds.SC_PROPERTIES_TRANSITION_EXPRESSION));
	}

	@Override
	protected int getEditorStyles() {
		return SWT.MULTI;
	}

	@Override
	public Transition resolveSemanticElement() {
		return (Transition) super.resolveSemanticElement();
	}

	public EAttribute getAttribute() {
		StringValueStyle featureStyle = GMFNotationUtil.getStringValueStyle(getPrimaryView(),
				ToggleShowDocumentationCommand.FEATURE_TO_SHOW);
		if (featureStyle == null) {
			return SGraphPackage.Literals.SPECIFICATION_ELEMENT__SPECIFICATION;
		}
		String feature = featureStyle.getStringValue();
		if (feature.equals(BasePackage.Literals.DOCUMENTED_ELEMENT__DOCUMENTATION.getName())) {
			return BasePackage.Literals.DOCUMENTED_ELEMENT__DOCUMENTATION;
		}
		return SGraphPackage.Literals.SPECIFICATION_ELEMENT__SPECIFICATION;
	}
}
