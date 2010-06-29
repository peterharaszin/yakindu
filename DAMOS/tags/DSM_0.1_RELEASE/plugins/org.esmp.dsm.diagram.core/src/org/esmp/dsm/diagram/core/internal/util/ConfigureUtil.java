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

package org.esmp.dsm.diagram.core.internal.util;

import java.util.HashSet;
import java.util.Set;

import org.esmp.dsm.semantic.blockdiagram.Block;
import org.esmp.dsm.semantic.blockdiagram.BlockCategory;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagramFactory;
import org.esmp.dsm.semantic.blockdiagram.Parameter;
import org.esmp.dsm.semantic.blockdiagram.ParameterDescriptor;
import org.esmp.dsm.semantic.blockdiagram.ParameterDescriptorContainer;
import org.esmp.dsm.semantic.blockdiagram.ParameterableElement;

/**
 * @author Andreas Unger
 *
 */
public class ConfigureUtil {

	public static void configureParameters(Block block) {
		Set<String> parameterNames = new HashSet<String>();
		for (ParameterDescriptor d : block.getType().getParameters()) {
			if (!parameterNames.contains(d.getName())) {
				addParameter(block, d);
				parameterNames.add(d.getName());
			}
		}
		for (BlockCategory category : block.getType().getCategories()) {
			addCategoryParameters(block, category, parameterNames);
		}
	}
	
	private static void addCategoryParameters(Block block, BlockCategory category, Set<String> parameterNames) {
		for (ParameterDescriptor d : category.getParameters()) {
			if (!parameterNames.contains(d.getName())) {
				addParameter(block, d);
				parameterNames.add(d.getName());
			}
		}
		for (BlockCategory parent : category.getParents()) {
			addCategoryParameters(block, parent, parameterNames);
		}
	}
	
	public static void configureParameters(ParameterableElement parameterableElement, ParameterDescriptorContainer parameterDescriptorContainer) {
		Set<String> parameterNames = new HashSet<String>();
		for (ParameterDescriptor d : parameterDescriptorContainer.getParameters()) {
			if (!parameterNames.contains(d.getName())) {
				addParameter(parameterableElement, d);
				parameterNames.add(d.getName());
			}
		}
	}
	
	private static void addParameter(ParameterableElement parameterableElement, ParameterDescriptor parameterDescriptor) {
		Parameter p = BlockDiagramFactory.eINSTANCE.createParameter();
		p.setDescriptor(parameterDescriptor);
		p.setValue(parameterDescriptor.getDefaultValue());
		parameterableElement.getParameters().add(p);
	}

}
