/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger. All rights reserved.
 ****************************************************************************/

package org.eclipselabs.damos.codegen.targets.arduino;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipselabs.damos.mscript.BooleanType;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.MultiplicativeOperator;
import org.eclipselabs.damos.mscript.codegen.c.IMultiplicativeExpressionWriter;
import org.eclipselabs.damos.mscript.codegen.c.InlineMultiplicativeExpressionWriter;
import org.eclipselabs.damos.mscript.codegen.c.NumericExpressionInfo;
import org.eclipselabs.damos.mscript.computationmodel.NumberFormat;
import org.eclipselabs.damos.mscript.computationmodel.PredefinedFixedPointFormatKind;

/**
 * @author Andreas Unger
 *
 */
public class DataInComponentGenerator extends AbstractArduinoUnoComponentGenerator {
	
	private final IMultiplicativeExpressionWriter multiplicativeExpressionWriter = new InlineMultiplicativeExpressionWriter();

	/**
	 * @param pinIndex
	 */
	public DataInComponentGenerator(int pinIndex) {
		super(pinIndex);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.AbstractComponentGenerator#initialize(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected void initialize(IProgressMonitor monitor) throws CoreException {
		super.initialize(monitor);
		if (getComponent().getFirstOutputPort() == null) {
			throw new CoreException(new Status(IStatus.ERROR, ArduinoPlugin.PLUGIN_ID, "No output port found on component " + getComponent().getName()));
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.AbstractComponentGenerator#contributesInitializationCode()
	 */
	@Override
	public boolean contributesInitializationCode() {
		DataType outputDataType = getContext().getComponentSignature().getOutputDataType(getComponent().getFirstOutputPort());
		return outputDataType instanceof BooleanType;		
	}
	
	@Override
	public CharSequence generateInitializationCode(IProgressMonitor monitor) {
		return new StringBuilder().append("pinMode(").append(getPinIndex()).append(", INPUT);\n");
	}
	
	@Override
	public CharSequence generateComputeOutputsCode(IProgressMonitor monitor) {
		StringBuilder sb = new StringBuilder();
		String outputVariable = getContext().getVariableAccessor().getOutputVariable(getContext().getNode().getComponent().getFirstOutputPort(), false);
		DataType outputDataType = getContext().getComponentSignature().getOutputDataType(getComponent().getFirstOutputPort());
		if (outputDataType instanceof BooleanType) {
			sb.append(outputVariable).append(" = digitalRead(").append(Integer.toString(getPinIndex())).append(");\n");
		} else {
			NumberFormat outputNumberFormat = getComputationModel().getNumberFormat(outputDataType);
			sb.append(outputVariable).append(" = ");

			CharSequence leftOperandText = new StringBuilder().append("analogRead(").append(Integer.toString(getPinIndex())).append(")");
			NumericExpressionInfo leftOperand = NumericExpressionInfo.create(PredefinedFixedPointFormatKind.UINT16, leftOperandText);
			CharSequence rightOperandText = Integer.toString(getAnalogRange());
			NumericExpressionInfo rightOperand = NumericExpressionInfo.create(PredefinedFixedPointFormatKind.UINT16, rightOperandText);
			sb.append(multiplicativeExpressionWriter.generate(getContext().getCodeFragmentCollector(), MultiplicativeOperator.DIVIDE, outputNumberFormat, leftOperand, rightOperand));
			sb.append(";\n");
		}
		return sb;
	}
	
	protected int getAnalogRange() {
		return 1023;
	}
	
}
