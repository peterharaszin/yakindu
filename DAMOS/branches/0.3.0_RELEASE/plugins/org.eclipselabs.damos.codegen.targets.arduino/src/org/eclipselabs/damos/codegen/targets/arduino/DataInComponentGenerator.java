/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger. All rights reserved.
 ****************************************************************************/

package org.eclipselabs.damos.codegen.targets.arduino;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipselabs.damos.mscript.BooleanType;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.MultiplicativeOperator;
import org.eclipselabs.damos.mscript.codegen.c.IMultiplicativeExpressionWriter;
import org.eclipselabs.damos.mscript.codegen.c.IWriter;
import org.eclipselabs.damos.mscript.codegen.c.InlineMultiplicativeExpressionWriter;
import org.eclipselabs.damos.mscript.codegen.c.NumericExpressionInfo;
import org.eclipselabs.damos.mscript.computationmodel.NumberFormat;
import org.eclipselabs.damos.mscript.computationmodel.PredefinedFixedPointFormatKind;

/**
 * @author Andreas Unger
 *
 */
public class DataInComponentGenerator extends AbstractArduinoUnoComponentGenerator {
	
	/**
	 * @param pinIndex
	 */
	public DataInComponentGenerator(int pinIndex) {
		super(pinIndex);
	}

	private final IMultiplicativeExpressionWriter multiplicativeExpressionWriter = new InlineMultiplicativeExpressionWriter();

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
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.AbstractComponentGenerator#writeInitializationCode(java.lang.Appendable, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void writeInitializationCode(Appendable appendable, IProgressMonitor monitor) throws IOException {
		appendable.append("pinMode(").append(Integer.toString(getPinIndex())).append(", INPUT);\n");
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.AbstractComponentGenerator#writeComputeOutputsCode(java.lang.Appendable, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void writeComputeOutputsCode(Appendable appendable, IProgressMonitor monitor) throws IOException {
		String outputVariable = getContext().getVariableAccessor().getOutputVariable(getContext().getNode().getComponent().getFirstOutputPort(), false);
		DataType outputDataType = getContext().getComponentSignature().getOutputDataType(getComponent().getFirstOutputPort());
		if (outputDataType instanceof BooleanType) {
			appendable.append(outputVariable).append(" = digitalRead(").append(Integer.toString(getPinIndex())).append(");\n");
		} else {
			NumberFormat outputNumberFormat = getComputationModel().getNumberFormat(outputDataType);
			appendable.append(outputVariable).append(" = ");
			NumericExpressionInfo leftOperand = NumericExpressionInfo.create(PredefinedFixedPointFormatKind.UINT16, new IWriter() {
				
				public void write(Appendable appendable) throws IOException {
					appendable.append("analogRead(").append(Integer.toString(getPinIndex())).append(")");
				}
				
			});
			NumericExpressionInfo rightOperand = NumericExpressionInfo.create(PredefinedFixedPointFormatKind.UINT16, new IWriter() {
				
				public void write(Appendable appendable) throws IOException {
					appendable.append(Integer.toString(getAnalogRange()));
				}
				
			});
			multiplicativeExpressionWriter.write(appendable, getContext().getCodeFragmentCollector(), MultiplicativeOperator.DIVIDE, outputNumberFormat, leftOperand, rightOperand);
			appendable.append(";\n");
		}
	}
	
	protected int getAnalogRange() {
		return 1023;
	}
	
}
