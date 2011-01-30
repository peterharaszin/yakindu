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

package org.eclipselabs.damos.diagram.core.internal.util;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.dml.Argument;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.Category;
import org.eclipselabs.damos.dml.DMLFactory;
import org.eclipselabs.damos.dml.Parameter;
import org.eclipselabs.damos.dml.ParameterableElement;
import org.eclipselabs.damos.dml.ParameterizedElement;
import org.eclipselabs.damos.dml.ValueSpecification;

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
	
	public static void configureParameters(ParameterizedElement parameterizedElement, ParameterableElement parameterDescriptorContainer) {
		Set<String> parameterNames = new HashSet<String>();
		for (Parameter p : parameterDescriptorContainer.getParameters()) {
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
			a.setValue(EcoreUtil.copy(defaultValue));
		}
		parameterizedElement.getArguments().add(a);
	}

}
