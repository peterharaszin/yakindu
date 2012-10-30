/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger. All rights reserved.
 ****************************************************************************/

package org.eclipse.damos.codegen.targets.arduino.shields;


import org.eclipse.damos.codegen.c.IComponentGenerator;
import org.eclipse.damos.codegen.c.IGeneratorContext;
import org.eclipse.damos.codegen.targets.arduino.AbstractShieldGenerator;
import org.eclipse.damos.dconfig.Binding;
import org.eclipse.damos.dconfig.BindingResourceReference;
import org.eclipse.damos.dconfig.ResourceDeclaration;
import org.eclipse.damos.execution.ComponentNode;

/**
 * @author Andreas Unger
 * 
 */
public class MotorShieldGenerator extends AbstractShieldGenerator {

	private static final String DIRECTION_RESOURCE_NAME = "Direction";
	private static final String PWM_RESOURCE_NAME = "PWM";
	private static final String BRAKE_RESOURCE_NAME = "Brake";
	private static final String CURRENT_SENSING_RESOURCE_NAME = "CurrentSensing";

	public IComponentGenerator createBoundaryComponentGenerator(IGeneratorContext context, ComponentNode node,
			Binding binding) {
		BindingResourceReference target = binding.getTarget();
		ResourceDeclaration resourceDeclaration = target.getResourceDeclaration();
		if (resourceDeclaration != null) {
			int index = 0;
			if (target.getSubscript() != null) {
				index = target.getSubscript().getIndex();
			}
			if (DIRECTION_RESOURCE_NAME.equals(resourceDeclaration.getName())) {
				return createDataOutComponentGenerator(index + 12);
			} else if (PWM_RESOURCE_NAME.equals(resourceDeclaration.getName())) {
				return createDataOutComponentGenerator(index == 0 ? 3 : 11);
			} else if (BRAKE_RESOURCE_NAME.equals(resourceDeclaration.getName())) {
				return createDataOutComponentGenerator(index == 0 ? 9 : 8);
			} else if (CURRENT_SENSING_RESOURCE_NAME.equals(resourceDeclaration.getName())) {
				return createDataInComponentGenerator(index);
			}
		}
		return null;
	}

}
