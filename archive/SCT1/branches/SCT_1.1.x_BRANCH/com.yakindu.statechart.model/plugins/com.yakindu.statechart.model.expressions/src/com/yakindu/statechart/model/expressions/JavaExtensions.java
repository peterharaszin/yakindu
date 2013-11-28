/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package com.yakindu.statechart.model.expressions;

import java.io.ByteArrayInputStream;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.typesystem.MetaModel;
import org.eclipse.xtend.typesystem.emf.EmfMetaModel;
import org.eclipse.xtend.typesystem.emf.EmfRegistryMetaModel;
import org.eclipse.xtext.parser.IParseResult;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.yakindu.statechart.model.expressions.parser.antlr.StatechartExpressionsParser;

public class JavaExtensions {

	public static final IParseResult parseTriggerExpression(String expression) {
		if (expression == null || "".equals(expression)) {
			return null;
		}

		// parse expression string
		Injector injector = Guice.createInjector(new com.yakindu.statechart.model.expressions.StatechartExpressionsRuntimeModule());
		StatechartExpressionsParser parser = injector.getInstance(StatechartExpressionsParser.class);
		IParseResult rootNode;
		try {
			rootNode = parser.parse("TriggerExpression", new ByteArrayInputStream(expression.getBytes()));
		} catch (WrappedException e) {
			throw new IllegalArgumentException(e.getMessage(), e);
		}

		return rootNode;
	}

	public static final EObject parseTriggerExpressionObject(String expression) {
		IParseResult triggerExpression = parseTriggerExpression(expression);
		if (triggerExpression != null) {
			return triggerExpression.getRootNode().getElement();
		}
		return null;
	}
	
	public static final IParseResult parseGuardExpression(String expression) {
		if (expression == null || "".equals(expression)) {
			return null;
		}

		// parse expression string
		Injector injector = Guice.createInjector(new com.yakindu.statechart.model.expressions.StatechartExpressionsRuntimeModule());
		StatechartExpressionsParser parser = injector.getInstance(StatechartExpressionsParser.class);
		IParseResult rootNode;
		try {
			rootNode = parser.parse("GuardExpression", new ByteArrayInputStream(expression.getBytes()));
		} catch (WrappedException e) {
			throw new IllegalArgumentException(e.getMessage(), e);
		}
		return rootNode;
	}

	public static final EObject parseGuardExpressionObject(String expression) {
		IParseResult guardExpression = parseGuardExpression(expression);
		if (guardExpression != null) {
			return guardExpression.getRootNode().getElement();
		}
		return null;
	}

	public static final IParseResult parseActionExpression(String expression) {
		if (expression == null || "".equals(expression)) {
			return null;
		}

		// parse expression string
		Injector injector = Guice.createInjector(new com.yakindu.statechart.model.expressions.StatechartExpressionsRuntimeModule());
		StatechartExpressionsParser parser = injector.getInstance(StatechartExpressionsParser.class);
		IParseResult rootNode;
		try {
			rootNode = parser.parse("ActionExpression", new ByteArrayInputStream(expression.getBytes()));
		} catch (WrappedException e) {
			throw new IllegalArgumentException(e.getMessage(), e);
		}
		return rootNode;
	}
	public static final EObject parseActionExpressionObject(String expression) {
		IParseResult actionExpression = parseActionExpression(expression);
		if (actionExpression != null) {
			return actionExpression.getRootNode().getElement();
		}
		return null;
	}

}
