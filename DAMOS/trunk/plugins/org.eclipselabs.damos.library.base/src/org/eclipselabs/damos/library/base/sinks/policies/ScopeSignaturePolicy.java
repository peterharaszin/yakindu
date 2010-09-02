package org.eclipselabs.damos.library.base.sinks.policies;

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
import org.eclipselabs.damos.typesystem.BooleanType;
import org.eclipselabs.damos.typesystem.DataType;
import org.eclipselabs.damos.typesystem.NumericalType;

/**
 * @author Andreas Unger
 *
 */
public class ScopeSignaturePolicy extends AbstractBlockSignaturePolicy {
	
	public IComponentSignatureEvaluationResult evaluateSignature(IEvaluationContext context, Block block, Map<InputPort, DataType> incomingDataTypes) {		
		MultiStatus status = new MultiStatus(LibraryBasePlugin.PLUGIN_ID, 0, "", null);
		
		ComponentSignature signature = new ComponentSignature();

		for (InputPort inputPort : block.getInputs().get(0).getPorts()) {
			DataType incomingDataType = incomingDataTypes.get(inputPort);
			if (incomingDataType != null) {
				if (incomingDataType instanceof BooleanType || incomingDataType instanceof NumericalType) {
					signature.getInputDataTypes().put(inputPort, (DataType) EcoreUtil.copy(incomingDataType));
				} else {
					status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Input values must be boolean or integer"));
				}
			}
		}
		
		if (!status.isOK()) {
			return new ComponentSignatureEvaluationResult(status);
		}

		return new ComponentSignatureEvaluationResult(signature);
	}

}
