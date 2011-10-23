package org.eclipselabs.damos.library.base.sinks.signaturepolicies;

import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.execution.core.AbstractComponentSignaturePolicy;
import org.eclipselabs.damos.execution.core.ComponentSignature;
import org.eclipselabs.damos.execution.core.ComponentSignatureEvaluationResult;
import org.eclipselabs.damos.execution.core.IComponentSignatureEvaluationResult;
import org.eclipselabs.damos.library.base.LibraryBasePlugin;
import org.eclipselabs.damos.mscript.BooleanType;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.NumericType;

/**
 * @author Andreas Unger
 *
 */
public class ScopeSignaturePolicy extends AbstractComponentSignaturePolicy {
	
	@Override
	public IComponentSignatureEvaluationResult evaluateSignature(Component component, Map<InputPort, DataType> incomingDataTypes) {		
		MultiStatus status = new MultiStatus(LibraryBasePlugin.PLUGIN_ID, 0, "", null);
		
		ComponentSignature signature = new ComponentSignature(incomingDataTypes);

		for (InputPort inputPort : component.getInputs().get(0).getPorts()) {
			DataType incomingDataType = incomingDataTypes.get(inputPort);
			if (incomingDataType != null && !(incomingDataType instanceof BooleanType || incomingDataType instanceof NumericType)) {
				status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Input values must be boolean or numeric"));
			}
		}
		
		if (status.getSeverity() > IStatus.WARNING) {
			return new ComponentSignatureEvaluationResult(status);
		}
		return new ComponentSignatureEvaluationResult(signature, status);
	}

}
