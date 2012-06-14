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
import org.eclipselabs.damos.mscript.codegen.c.IMultiplicativeExpressionGenerator;
import org.eclipselabs.damos.mscript.codegen.c.InlineMultiplicativeExpressionGenerator;
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

	private final IMultiplicativeExpressionGenerator multiplicativeExpressionGenerator = new InlineMultiplicativeExpressionGenerator();

	/**
	 * @param pinIndex
	 */
	public DataOutComponentGenerator(int pinIndex) {
		super(pinIndex);
	}

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
	
	@Override
	public CharSequence generateInitializationCode(IProgressMonitor monitor) {
		return new StringBuilder().append("pinMode(").append(getPinIndex()).append(", OUTPUT);\n");
	}
	
	@Override
	public CharSequence generateComputeOutputsCode(IProgressMonitor monitor) {
		StringBuilder sb = new StringBuilder();
		final String inputVariable = getContext().getVariableAccessor().generateInputVariableReference(getContext().getNode().getComponent().getFirstInputPort(), false);
		int pin = getPinIndex();
		DataType inputDataType = getContext().getComponentSignature().getInputDataType(getComponent().getFirstInputPort());
		if (inputDataType instanceof BooleanType) {
			sb.append("digitalWrite(").append(Integer.toString(pin)).append(", ").append(inputVariable).append(");\n");
		} else {
			FixedPointFormat targetNumberFormat = ComputationModelFactory.eINSTANCE.createFixedPointFormat();
			targetNumberFormat.setPredefinedKind(PredefinedFixedPointFormatKind.UINT16);
			final NumberFormat inputNumberFormat = getComputationModel().getNumberFormat(inputDataType);
			sb.append("analogWrite(").append(Integer.toString(pin)).append(", ");

			NumericExpressionInfo leftOperand = NumericExpressionInfo.create(inputNumberFormat, inputVariable);
			NumericExpressionInfo rightOperand = NumericExpressionInfo.create(PredefinedFixedPointFormatKind.UINT16, Integer.toString(getAnalogRange()));
			CharSequence product = multiplicativeExpressionGenerator.generate(getContext().getCodeFragmentCollector(), MultiplicativeOperator.MULTIPLY, inputNumberFormat, leftOperand, rightOperand);
			sb.append(NumericExpressionCaster.INSTANCE.cast(targetNumberFormat, NumericExpressionInfo.create(inputNumberFormat, product)));

			sb.append(");\n");
		}
		return sb;
	}

	protected int getAnalogRange() {
		return 255;
	}
	
}
