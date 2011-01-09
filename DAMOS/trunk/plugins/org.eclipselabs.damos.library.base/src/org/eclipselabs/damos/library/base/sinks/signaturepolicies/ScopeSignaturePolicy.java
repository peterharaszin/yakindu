package org.eclipselabs.damos.library.base.sinks.signaturepolicies;

import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.execution.engine.ComponentSignature;
import org.eclipselabs.damos.execution.engine.ComponentSignatureEvaluationResult;
import org.eclipselabs.damos.execution.engine.IComponentSignatureEvaluationResult;
import org.eclipselabs.damos.execution.engine.IComponentSignaturePolicy;
import org.eclipselabs.damos.library.base.LibraryBasePlugin;
import org.eclipselabs.mscript.typesystem.BooleanType;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.NumericType;

/**
 * @author Andreas Unger
 *
 */
public class ScopeSignaturePolicy implements IComponentSignaturePolicy {
	
	public IComponentSignatureEvaluationResult evaluateSignature(Component component, Map<InputPort, DataType> incomingDataTypes) {		
		MultiStatus status = new MultiStatus(LibraryBasePlugin.PLUGIN_ID, 0, "", null);
		
		ComponentSignature signature = new ComponentSignature(incomingDataTypes);

		for (InputPort inputPort : component.getInputs().get(0).getPorts()) {
			DataType incomingDataType = incomingDataTypes.get(inputPort);
			if (incomingDataType != null && !(incomingDataType instanceof BooleanType || incomingDataType instanceof NumericType)) {
				status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Input values must be boolean or integer"));
			}
		}
		
		if (!status.isOK()) {
			return new ComponentSignatureEvaluationResult(status);
		}
		return new ComponentSignatureEvaluationResult(signature);
	}

}
