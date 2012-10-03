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
import org.eclipse.damos.mscript.codegen.c.InlineMultiplicativeExpressionGenerator;
import org.eclipse.damos.mscript.codegen.c.NumericExpressionCaster;
import org.eclipse.damos.mscript.codegen.c.TextualNumericExpressionOperand;
import org.eclipse.damos.mscript.computation.ComputationFactory;
import org.eclipse.damos.mscript.computation.FixedPointFormat;
import org.eclipse.damos.mscript.computation.NumberFormat;
import org.eclipse.damos.mscript.computation.PredefinedFixedPointFormatKind;
import org.eclipse.damos.mscript.computation.util.ComputationModelUtil;

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
	 * @see org.eclipse.damos.codegen.c.AbstractComponentGenerator#initialize(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected void initialize(IProgressMonitor monitor) throws CoreException {
		super.initialize(monitor);
		if (getComponent().getFirstInputPort() == null) {
			throw new CoreException(new Status(IStatus.ERROR, ArduinoPlugin.PLUGIN_ID, "No input port found on component " + getComponent().getName()));
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.codegen.c.AbstractComponentGenerator#contributesInitializationCode()
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
		Type inputDataType = getContext().getComponentSignature().getInputDataType(getComponent().getFirstInputPort());
		if (inputDataType instanceof BooleanType) {
			sb.append("digitalWrite(").append(Integer.toString(pin)).append(", ").append(inputVariable).append(");\n");
		} else {
			FixedPointFormat targetNumberFormat = ComputationFactory.eINSTANCE.createFixedPointFormat();
			targetNumberFormat.setPredefinedKind(PredefinedFixedPointFormatKind.UINT16);
			final NumberFormat inputNumberFormat = getComputationModel().getNumberFormat(inputDataType);
			sb.append("analogWrite(").append(Integer.toString(pin)).append(", ");

			INumericExpressionOperand leftOperand = new TextualNumericExpressionOperand(inputVariable, inputNumberFormat);
			INumericExpressionOperand rightOperand = new TextualNumericExpressionOperand(Integer.toString(getAnalogRange()), ComputationModelUtil.createFixedPointFormat(PredefinedFixedPointFormatKind.UINT16));
			CharSequence product = multiplicativeExpressionGenerator.generate(getContext().getCodeFragmentCollector(), OperatorKind.MULTIPLY, inputNumberFormat, leftOperand, rightOperand);
			sb.append(NumericExpressionCaster.INSTANCE.cast(product, inputNumberFormat, targetNumberFormat));

			sb.append(");\n");
		}
		return sb;
	}

	protected int getAnalogRange() {
		return 255;
	}
	
}
