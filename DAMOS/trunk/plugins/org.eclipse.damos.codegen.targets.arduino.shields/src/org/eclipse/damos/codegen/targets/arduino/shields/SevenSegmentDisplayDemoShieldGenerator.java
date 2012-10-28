/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger. All rights reserved.
 ****************************************************************************/

package org.eclipse.damos.codegen.targets.arduino.shields;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.damos.codegen.c.AbstractBlockGenerator;
import org.eclipse.damos.codegen.c.IComponentGenerator;
import org.eclipse.damos.codegen.c.IGeneratorContext;
import org.eclipse.damos.codegen.c.util.GeneratorHelper;
import org.eclipse.damos.codegen.targets.arduino.AbstractShieldGenerator;
import org.eclipse.damos.codegen.targets.arduino.DataInComponentGenerator;
import org.eclipse.damos.codegen.targets.arduino.DataOutComponentGenerator;
import org.eclipse.damos.common.util.PrintAppendable;
import org.eclipse.damos.dconfig.Binding;
import org.eclipse.damos.dconfig.ResourceDeclaration;
import org.eclipse.damos.execution.ComponentNode;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 * 
 */
public class SevenSegmentDisplayDemoShieldGenerator extends AbstractShieldGenerator {

	@Inject
	private GeneratorHelper generatorHelper;

	private static final String DISPLAY_RESOURCE_NAME = "Display";
	private static final String DECIMAL_POINT_RESOURCE_NAME = "DecimalPoint";
	private static final String BUTTON_UP_RESOURCE_NAME = "ButtonUp";
	private static final String BUTTON_DOWN_RESOURCE_NAME = "ButtonDown";
	private static final String KNOB_RESOURCE_NAME = "Knob";
	private static final String LED_RESOURCE_NAME = "LED";
	
	public IComponentGenerator createBoundaryComponentGenerator(IGeneratorContext context, ComponentNode node,
			Binding binding) {
		ResourceDeclaration resourceDeclaration = binding.getTarget().getResourceDeclaration();
		if (resourceDeclaration != null) {
			if (DISPLAY_RESOURCE_NAME.equals(resourceDeclaration.getName())) {
				return new DisplayGenerator();
			} else if (DECIMAL_POINT_RESOURCE_NAME.equals(resourceDeclaration.getName())) {
				return new DataOutComponentGenerator(9);
			} else if (BUTTON_UP_RESOURCE_NAME.equals(resourceDeclaration.getName())) {
				return new DataInComponentGenerator(12);
			} else if (BUTTON_DOWN_RESOURCE_NAME.equals(resourceDeclaration.getName())) {
				return new DataInComponentGenerator(11);
			} else if (KNOB_RESOURCE_NAME.equals(resourceDeclaration.getName())) {
				return new DataInComponentGenerator(0);
			} else if (LED_RESOURCE_NAME.equals(resourceDeclaration.getName())) {
				return new DataOutComponentGenerator(10);
			}
		}
		return null;
	}

	private class DisplayGenerator extends AbstractBlockGenerator {

		@Override
		public boolean contributesInitializationCode() {
			return true;
		}

		@Override
		public CharSequence generateInitializationCode(IProgressMonitor monitor) {
			StringBuilder sb = new StringBuilder();
			sb.append("pinMode(3, OUTPUT);\n"); // a
			sb.append("pinMode(2, OUTPUT);\n"); // b
			sb.append("pinMode(8, OUTPUT);\n"); // c
			sb.append("pinMode(4, OUTPUT);\n"); // d
			sb.append("pinMode(7, OUTPUT);\n"); // e
			sb.append("pinMode(5, OUTPUT);\n"); // f
			sb.append("pinMode(6, OUTPUT);\n"); // g
			return sb;
		}

		@Override
		public boolean contributesComputeOutputsCode() {
			return true;
		}

		@Override
		public CharSequence generateComputeOutputsCode(IProgressMonitor monitor) {
			StringBuilder sb = new StringBuilder();
			PrintAppendable out = new PrintAppendable(sb);
			String v = generatorHelper.getIncomingVariableName(getConfiguration(), getNode(), getComponent().getFirstInputPort());
			out.printf("digitalWrite(3, !(%s == 0 || %s == 2 || %s == 3 || %s == 5 || %s == 6 || %s == 7 || %s == 8 || %s == 9));\n", v, v, v, v, v, v, v, v);
			out.printf("digitalWrite(2, !(%s == 0 || %s == 1 || %s == 2 || %s == 3 || %s == 4 || %s == 7 || %s == 8 || %s == 9));\n", v, v, v, v, v, v, v, v);
			out.printf("digitalWrite(8, !(%s == 0 || %s == 1 || %s == 3 || %s == 4 || %s == 5 || %s == 6 || %s == 7 || %s == 8 || %s == 9));\n", v, v, v, v, v, v, v, v, v);
			out.printf("digitalWrite(4, !(%s == 0 || %s == 2 || %s == 3 || %s == 5 || %s == 6 || %s == 8 || %s == 9));\n", v, v, v, v, v, v, v);
			out.printf("digitalWrite(7, !(%s == 0 || %s == 2 || %s == 6 || %s == 8));\n", v, v, v, v);
			out.printf("digitalWrite(5, !(%s == 0 || %s == 4 || %s == 5 || %s == 6 || %s == 8 || %s == 9));\n", v, v, v, v, v, v);
			out.printf("digitalWrite(6, !(%s == 2 || %s == 3 || %s == 4 || %s == 5 || %s == 6 || %s == 8 || %s == 9));\n", v, v, v, v, v, v, v);
			return sb;
		}

	}

}
