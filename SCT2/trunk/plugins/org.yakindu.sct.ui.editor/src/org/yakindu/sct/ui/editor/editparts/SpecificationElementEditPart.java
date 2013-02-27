/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.editparts;

import static org.yakindu.base.base.BasePackage.Literals.DOCUMENTED_ELEMENT__DOCUMENTATION;
import static org.yakindu.sct.model.sgraph.SGraphPackage.Literals.SPECIFICATION_ELEMENT__SPECIFICATION;
import static org.yakindu.sct.ui.editor.commands.ToggleShowDocumentationCommand.FEATURE_TO_SHOW;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager;
import org.eclipse.gmf.runtime.notation.StringValueStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.ui.editor.extensions.ExpressionLanguageProviderExtensions.SemanticTarget;
import org.yakindu.sct.ui.editor.utils.GMFNotationUtil;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class SpecificationElementEditPart extends PlugableXtextLabelEditPart {

	public SpecificationElementEditPart(View view, SemanticTarget target) {
		super(view, target);
	}
	
	@Override
	protected DirectEditManager createDirectEditManager() {
		if (getAttribute() == DOCUMENTED_ELEMENT__DOCUMENTATION)
			return new TextDirectEditManager(this);
		return super.createDirectEditManager();
	}

	public EAttribute getAttribute() {
		StringValueStyle featureStyle = GMFNotationUtil.getStringValueStyle(getPrimaryView(), FEATURE_TO_SHOW);
		if (featureStyle == null) {
			return SPECIFICATION_ELEMENT__SPECIFICATION;
		}
		String feature = featureStyle.getStringValue();
		if (feature.equals(DOCUMENTED_ELEMENT__DOCUMENTATION.getName())) {
			return DOCUMENTED_ELEMENT__DOCUMENTATION;
		}
		return SPECIFICATION_ELEMENT__SPECIFICATION;
	}

}
