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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.yakindu.base.expressions.types.ExpressionsTypeSystem;
import org.yakindu.sct.model.stext.stext.EventRaisingExpression;
import org.yakindu.sct.model.stext.stext.EventValueReferenceExpression;
import org.yakindu.sct.model.stext.stext.StextPackage;

import com.google.inject.Singleton;

import de.itemis.xtext.typesystem.trace.TypeCalculationTrace;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 *         TODOS: How to handle operations? TODO:Guard Expression / Variable
 *         Definition / TimeExptession
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
		initializeEventDefinition();
		initializeEventRaisingExpression();
		initializeEventValueReferenceExpression();
		initializeActiveStateReferenceExpression();

	}

	protected void initializeEventDefinition() throws Exception {
		// if an event is used within an expression, the type is boolean and the
		// value indicates if the event is raised or not
		useFixedType(stextLang.getEventDefinition(), typeLang.getBoolean());
	}

	protected void initializeActiveStateReferenceExpression() throws Exception {
		useFixedType(stextLang.getActiveStateReferenceExpression(), typeLang.getBoolean());
	}

	protected void initializeEventValueReferenceExpression() throws Exception {
		useTypeOfFeature(stextLang.getEventValueReferenceExpression(),
				stextLang.getEventValueReferenceExpression_Value());
	}

	protected void initializeEventRaisingExpression() throws Exception {
		// TODO: Is this correct or should the result of a raise expression be
		// void?
		useTypeOfFeature(stextLang.getEventRaisingExpression(), stextLang.getEventRaisingExpression_Value());
		// useFixedType(stextLang.getEventRaisingExpression(),
		// typeLang.getVoid());
	}

	public EObject type(EventRaisingExpression exp, TypeCalculationTrace trace){
		return exp.getValue() != null ? typeof(exp.getValue(), trace) : VOID;
	}

	protected void initializeVariableDefinition() throws Exception {
		useTypeOfFeature(stextLang.getVariableDefinition(), typeLang.getTypedElement_Type());
		ensureOrderedCompatibility(stextLang.getVariableDefinition(), typeLang.getTypedElement_Type(),
				stextLang.getVariableDefinition_InitialValue());
	}

}
