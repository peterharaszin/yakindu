/**
 * Copyright (c) 2014 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	itemis AG - initial API and implementation
 *  
 */
package org.yakindu.sct.model.stext.types;

import org.yakindu.base.expressions.types.ExpressionsTypeSystem;
import org.yakindu.sct.model.stext.stext.StextPackage;

import com.google.inject.Singleton;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 *         TODOS: How to handle operations?
 *         TODO:Guard Expression /  Variable Definition / TimeExptession
 */
@Singleton
public class STextTypeSystem extends ExpressionsTypeSystem {

	public static final String GUARD_EXPRESSION = "The evaluation result of a guard expression must be of type boolean";
	public static final String TIME_EXPRESSION = "The evaluation result of a time expression must be of type integer";
	
	protected StextPackage stextLang = StextPackage.eINSTANCE;
	
	@Override
	protected void initializeExpressions() throws Exception {
		super.initializeExpressions();
		initializeVariableDefinition();
		initializeEventRaisingExpression();
		initializeEventValueReferenceExpression();
		initializeActiveStateReferenceExpression();

	}

	protected void initializeActiveStateReferenceExpression() throws Exception {
		useFixedType(stextLang.getActiveStateReferenceExpression(), typeLang.getBoolean());
	}

	protected void initializeEventValueReferenceExpression() throws Exception {
		useTypeOfFeature(stextLang.getEventValueReferenceExpression(),
				stextLang.getEventValueReferenceExpression_Value());
	}

	protected void initializeEventRaisingExpression() throws Exception {
		useFixedType(stextLang.getEventRaisingExpression(), typeLang.getVoid());
	}

	protected void initializeVariableDefinition() throws Exception {
		useTypeOfFeature(stextLang.getVariableDefinition(), typeLang.getTypedElement_Type());
		ensureOrderedCompatibility(stextLang.getVariableDefinition(), typeLang.getTypedElement_Type(),
				stextLang.getVariableDefinition_InitialValue());
	}

}
