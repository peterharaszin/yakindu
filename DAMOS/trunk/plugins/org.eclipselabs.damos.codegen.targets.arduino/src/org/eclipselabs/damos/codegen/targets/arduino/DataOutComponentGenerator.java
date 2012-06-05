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
import org.eclipselabs.damos.mscript.codegen.c.NumericExpressionCaster;
import org.eclipselabs.damos.mscript.codegen.c.NumericExpressionInfo;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModelFactory;
import org.eclipselabs.damos.mscript.computationmodel.FixedPointFormat;
import org.eclipselabs.damos.mscript.computationmodel.NumberFormat;
import org.eclipselabs.damos.mscript.computationmodel.PredefinedFixedPointFormatKind;

/**
 * @author Andreas Unger
 *
 */
public class DataOutComponentGenerator extends AbstractArduinoUnoComponentGenerator {

	/**
	 * @param pinIndex
	 */
	public DataOutComponentGenerator(int pinIndex) {
		super(pinIndex);
	}

	private final IMultiplicativeExpressionWriter multiplicativeExpressionWriter = new InlineMultiplicativeExpressionWriter();

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.AbstractComponentGenerator#initialize(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected void initialize(IProgressMonitor monitor) throws CoreException {
		super.initialize(monitor);
		if (getComponent().getFirstInputPort() == null) {
			throw new CoreException(new Status(IStatus.ERROR, ArduinoPlugin.PLUGIN_ID, "No input port found on component " + getComponent().getName()));
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.AbstractComponentGenerator#contributesInitializationCode()
	 */
	@Override
	public boolean contributesInitializationCode() {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.AbstractComponentGenerator#writeInitializationCode(java.lang.Appendable, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void writeInitializationCode(Appendable appendable, IProgressMonitor monitor) throws IOException {
		int pin = getPinIndex();
		appendable.append("pinMode(").append(Integer.toString(pin)).append(", OUTPUT);\n");
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.AbstractComponentGenerator#writeComputeOutputsCode(java.lang.Appendable, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void writeComputeOutputsCode(Appendable appendable, IProgressMonitor monitor) throws IOException {
		final String inputVariable = getContext().getVariableAccessor().getInputVariable(getContext().getNode().getComponent().getFirstInputPort(), false);
		int pin = getPinIndex();
		DataType inputDataType = getContext().getComponentSignature().getInputDataType(getComponent().getFirstInputPort());
		if (inputDataType instanceof BooleanType) {
			appendable.append("digitalWrite(").append(Integer.toString(pin)).append(", ").append(inputVariable).append(");\n");
		} else {
			FixedPointFormat targetNumberFormat = ComputationModelFactory.eINSTANCE.createFixedPointFormat();
			targetNumberFormat.setPredefinedKind(PredefinedFixedPointFormatKind.UINT16);
			final NumberFormat inputNumberFormat = getComputationModel().getNumberFormat(inputDataType);
			appendable.append("analogWrite(").append(Integer.toString(pin)).append(", ");
			NumericExpressionCaster.INSTANCE.cast(appendable, targetNumberFormat, NumericExpressionInfo.create(inputNumberFormat, new IWriter() {
				
				public void write(Appendable appendable) throws IOException {
					NumericExpressionInfo leftOperand = NumericExpressionInfo.create(inputNumberFormat, new IWriter() {
						
						public void write(Appendable appendable) throws IOException {
							appendable.append(inputVariable);
						}
						
					});
					NumericExpressionInfo rightOperand = NumericExpressionInfo.create(PredefinedFixedPointFormatKind.UINT16, new IWriter() {
						
						public void write(Appendable appendable) throws IOException {
							appendable.append(Integer.toString(getAnalogRange()));
						}
						
					});
					multiplicativeExpressionWriter.write(appendable, getContext().getCodeFragmentCollector(), MultiplicativeOperator.MULTIPLY, inputNumberFormat, leftOperand, rightOperand);
				}
				
			}));
			appendable.append(");\n");
		}
	}

	protected int getAnalogRange() {
		return 255;
	}
	
}
