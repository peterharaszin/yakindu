package org.eclipselabs.damos.library.base.signaturepolicies.continuous;

import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.execution.datatype.AbstractComponentSignaturePolicy;
import org.eclipselabs.damos.execution.datatype.ComponentSignature;
import org.eclipselabs.damos.execution.datatype.ComponentSignatureEvaluationResult;
import org.eclipselabs.damos.execution.datatype.IComponentSignatureEvaluationResult;
import org.eclipselabs.damos.execution.util.ExpressionUtil;
import org.eclipselabs.damos.library.base.LibraryBasePlugin;
import org.eclipselabs.damos.library.base.util.continuous.IntegratorConstants;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.NumericType;
import org.eclipselabs.damos.mscript.OperatorKind;
import org.eclipselabs.damos.mscript.RealType;
import org.eclipselabs.damos.mscript.UnitSymbol;
import org.eclipselabs.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 *
 */
public class IntegratorSignaturePolicy extends AbstractComponentSignaturePolicy {
	
	@Override
	public IComponentSignatureEvaluationResult evaluateSignature(Component component, Map<InputPort, DataType> incomingDataTypes) {
		Block block = (Block) component;
		
		MultiStatus status = new MultiStatus(LibraryBasePlugin.PLUGIN_ID, 0, "", null);
		
		NumericType initialConditionDataType = null;
		try {
			initialConditionDataType = ExpressionUtil.evaluateSimpleNumericArgument(block, IntegratorConstants.PARAMETER__INITIAL_CONDITION).getDataType();
		} catch (CoreException e) {
			status.add(e.getStatus());
		}

		NumericType gainDataType = null;
		try {
			gainDataType = ExpressionUtil.evaluateSimpleNumericArgument(block, IntegratorConstants.PARAMETER__GAIN).getDataType();
		} catch (CoreException e) {
			status.add(e.getStatus());
		}

		if (status.getSeverity() > IStatus.WARNING) {
			return new ComponentSignatureEvaluationResult(status);
		}
		
		DataType incomingDataType = incomingDataTypes.get(component.getFirstInputPort());
		if (incomingDataType == null) {
			return new ComponentSignatureEvaluationResult();
		}
		
		if (!(incomingDataType instanceof NumericType)) {
			status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Input value must be numeric"));
		}
		
		if (status.getSeverity() > IStatus.WARNING) {
			return new ComponentSignatureEvaluationResult(status);
		}
		
		NumericType incomingNumericType = (NumericType) incomingDataType;
		
		if (!initialConditionDataType.getUnit().isEquivalentTo(incomingNumericType.getUnit(), false)) {
			status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Initial Condition and input value must have same unit"));
		}
		
		if (status.getSeverity() > IStatus.WARNING) {
			return new ComponentSignatureEvaluationResult(status);
		}

		RealType outputDataType = MscriptFactory.eINSTANCE.createRealType();
		outputDataType.setUnit(TypeUtil.createUnit(UnitSymbol.SECOND).evaluate(OperatorKind.MULTIPLY, incomingNumericType.getUnit()).evaluate(OperatorKind.MULTIPLY, gainDataType.getUnit()));
		
		ComponentSignature signature = new ComponentSignature(incomingDataTypes);
		signature.getOutputDataTypes().put(component.getFirstOutputPort(), outputDataType);
		return new ComponentSignatureEvaluationResult(signature, status);
	}

}
