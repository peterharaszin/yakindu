package org.eclipselabs.damos.library.base.signal.policies;

import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.evaluation.IEvaluationContext;
import org.eclipselabs.damos.evaluation.componentsignature.AbstractBlockSignaturePolicy;
import org.eclipselabs.damos.evaluation.componentsignature.ComponentSignature;
import org.eclipselabs.damos.evaluation.componentsignature.ComponentSignatureEvaluationResult;
import org.eclipselabs.damos.evaluation.componentsignature.IComponentSignatureEvaluationResult;
import org.eclipselabs.damos.library.base.LibraryBasePlugin;
import org.eclipselabs.mscript.typesystem.BooleanType;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.NumericType;
import org.eclipselabs.mscript.typesystem.RealType;

/**
 * @author Andreas Unger
 *
 */
public class SwitchSignaturePolicy extends AbstractBlockSignaturePolicy {
	
	public IComponentSignatureEvaluationResult evaluateSignature(IEvaluationContext context, Block block, Map<InputPort, DataType> incomingDataTypes) {		
		MultiStatus status = new MultiStatus(LibraryBasePlugin.PLUGIN_ID, 0, "", null);
		
		InputPort onTrueInputPort = block.getInputs().get(0).getPorts().get(0);
		InputPort controlInputPort = block.getInputs().get(1).getPorts().get(0);
		InputPort onFalseInputPort = block.getInputs().get(2).getPorts().get(0);
		DataType onTrueIncomingDataType = incomingDataTypes.get(onTrueInputPort);
		DataType controlIncomingDataType = incomingDataTypes.get(controlInputPort);
		DataType onFalseIncomingDataType = incomingDataTypes.get(onFalseInputPort);

		if (controlIncomingDataType != null && !(controlIncomingDataType instanceof BooleanType)) {
			status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Control input value must be boolean"));
		}

		if (onTrueIncomingDataType != null && !(onTrueIncomingDataType instanceof NumericType) || onFalseIncomingDataType != null && !(onFalseIncomingDataType instanceof NumericType)) {
			status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Data input values must be numeric"));
		}
		
		if (!status.isOK()) {
			return new ComponentSignatureEvaluationResult(status);
		}

		if (onTrueIncomingDataType != null && onFalseIncomingDataType != null && !((NumericType) onTrueIncomingDataType).getUnit().isSameAs(((NumericType) onFalseIncomingDataType).getUnit(), false)) {
			status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Data input values must have same unit"));
		}

		if (!status.isOK()) {
			return new ComponentSignatureEvaluationResult(status);
		}

		ComponentSignature signature = new ComponentSignature();
		
		DataType outputDataType = onTrueIncomingDataType;
		if (onFalseIncomingDataType instanceof RealType) {
			outputDataType = onFalseIncomingDataType;
		}

		if (outputDataType != null) {
			signature.getOutputDataTypes().put(block.getFirstOutputPort(), EcoreUtil.copy(outputDataType));
		}
		
		return new ComponentSignatureEvaluationResult(signature);
	}

}
