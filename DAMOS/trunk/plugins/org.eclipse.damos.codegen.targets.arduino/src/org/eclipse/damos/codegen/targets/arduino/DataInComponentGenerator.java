/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger. All rights reserved.
 ****************************************************************************/

package org.eclipse.damos.codegen.targets.arduino;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.damos.mscript.BooleanType;
import org.eclipse.damos.mscript.OperatorKind;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.codegen.c.IMultiplicativeExpressionGenerator;
import org.eclipse.damos.mscript.codegen.c.INumericExpressionOperand;
import org.eclipse.damos.mscript.codegen.c.NumericExpressionCaster;
import org.eclipse.damos.mscript.codegen.c.TextualNumericExpressionOperand;
import org.eclipse.damos.mscript.computation.NumberFormat;
import org.eclipse.damos.mscript.computation.PredefinedFixedPointFormatKind;
import org.eclipse.damos.mscript.computation.util.ComputationModelUtil;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class DataInComponentGenerator extends AbstractArduinoUnoComponentGenerator {
	
	@Inject
	private NumericExpressionCaster numericExpressionCaster;
	
	@Inject
	private IMultiplicativeExpressionGenerator multiplicativeExpressionGenerator;

	/* (non-Javadoc)
	 * @see org.eclipse.damos.codegen.c.AbstractComponentGenerator#initialize(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected void initialize(IProgressMonitor monitor) throws CoreException {
		super.initialize(monitor);
		if (getComponent().getFirstOutputPort() == null) {
			throw new CoreException(new Status(IStatus.ERROR, ArduinoPlugin.PLUGIN_ID, "No output port found on component " + getComponent().getName()));
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.codegen.c.AbstractComponentGenerator#contributesInitializationCode()
	 */
	@Override
	public boolean contributesInitializationCode() {
		Type outputDataType = getContext().getComponentSignature().getOutputDataType(getComponent().getFirstOutputPort());
		return outputDataType instanceof BooleanType;		
	}
	
	@Override
	public CharSequence generateInitializationCode(IProgressMonitor monitor) {
		return new StringBuilder().append("pinMode(").append(getPinIndex()).append(", INPUT);\n");
	}
	
	@Override
	public CharSequence generateComputeOutputsCode(IProgressMonitor monitor) {
		StringBuilder sb = new StringBuilder();
		CharSequence outputVariable = getContext().getVariableAccessor().generateOutputVariableReference(getContext().getNode().getComponent().getFirstOutputPort(), false);
		Type outputDataType = getContext().getComponentSignature().getOutputDataType(getComponent().getFirstOutputPort());
		if (outputDataType instanceof BooleanType) {
			sb.append(outputVariable).append(" = digitalRead(").append(Integer.toString(getPinIndex())).append(");\n");
		} else {
			NumberFormat outputNumberFormat = getComputationModel().getNumberFormat(outputDataType);
			sb.append(outputVariable).append(" = ");
			
			CharSequence leftOperandText = new StringBuilder().append("analogRead(").append(Integer.toString(getPinIndex())).append(")");
			INumericExpressionOperand leftOperand = new TextualNumericExpressionOperand(numericExpressionCaster, leftOperandText, ComputationModelUtil.createFixedPointFormat(PredefinedFixedPointFormatKind.UINT16));
			CharSequence rightOperandText = Integer.toString(getAnalogRange());
			INumericExpressionOperand rightOperand = new TextualNumericExpressionOperand(numericExpressionCaster, rightOperandText, ComputationModelUtil.createFixedPointFormat(PredefinedFixedPointFormatKind.UINT16));
			sb.append(multiplicativeExpressionGenerator.generate(getContext().getCodeFragmentCollector(), OperatorKind.DIVIDE, outputNumberFormat, leftOperand, rightOperand));
			sb.append(";\n");
		}
		return sb;
	}
	
	protected int getAnalogRange() {
		return 1023;
	}
	
}
