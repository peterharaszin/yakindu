/****************************************************************************
 * Copyright (c) 2008, 2009 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.dml.internal.util;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.damos.dml.Argument;
import org.eclipse.damos.dml.Block;
import org.eclipse.damos.dml.Category;
import org.eclipse.damos.dml.DMLFactory;
import org.eclipse.damos.dml.Parameter;
import org.eclipse.damos.dml.ParameterableElement;
import org.eclipse.damos.dml.ParameterizedElement;
import org.eclipse.damos.dml.ValueSpecification;

/**
 * @author Andreas Unger
 *
 */
public class ConfigureUtil {

	public static void configureParameters(Block block) {
		Set<String> parameterNames = new HashSet<String>();
		for (Parameter p : block.getType().getParameters()) {
			if (!parameterNames.contains(p.getName())) {
				addParameter(block, p);
				parameterNames.add(p.getName());
			}
		}
		for (Category category : block.getType().getBelongingCategories()) {
			addCategoryParameters(block, category, parameterNames);
		}
	}
	
	private static void addCategoryParameters(Block block, Category category, Set<String> parameterNames) {
		for (Parameter p : category.getParameters()) {
			if (!parameterNames.contains(p.getName())) {
				addParameter(block, p);
				parameterNames.add(p.getName());
			}
		}
		for (Category parent : category.getBelongingCategories()) {
			addCategoryParameters(block, parent, parameterNames);
		}
	}
	
	public static void configureParameters(ParameterizedElement parameterizedElement, ParameterableElement parameterableElement) {
		Set<String> parameterNames = new HashSet<String>();
		for (Parameter p : parameterableElement.getParameters()) {
			if (!parameterNames.contains(p.getName())) {
				addParameter(parameterizedElement, p);
				parameterNames.add(p.getName());
			}
		}
	}
	
	private static void addParameter(ParameterizedElement parameterizedElement, Parameter parameter) {
		Argument a = DMLFactory.eINSTANCE.createArgument();
		a.setParameter(parameter);
		ValueSpecification defaultValue = parameter.getDefaultValue();
		if (defaultValue != null) {
			a.setValue(defaultValue.copy());
		}
		parameterizedElement.getArguments().add(a);
	}

}
