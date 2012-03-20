package org.eclipselabs.damos.library.vi.signatures.indicators;

import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.execution.datatype.AbstractComponentSignaturePolicy;
import org.eclipselabs.damos.execution.datatype.ComponentSignature;
import org.eclipselabs.damos.execution.datatype.ComponentSignatureEvaluationResult;
import org.eclipselabs.damos.execution.datatype.IComponentSignatureEvaluationResult;
import org.eclipselabs.damos.library.vi.LibraryVIPlugin;
import org.eclipselabs.damos.mscript.BooleanType;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.NumericType;

/**
 * @author Andreas Unger
 *
 */
public class DisplaySignaturePolicy extends AbstractComponentSignaturePolicy {
	
	@Override
	public IComponentSignatureEvaluationResult evaluateSignature(Component component, Map<InputPort, DataType> incomingDataTypes) {
		MultiStatus status = new MultiStatus(LibraryVIPlugin.PLUGIN_ID, 0, "", null);
		
		ComponentSignature signature = new ComponentSignature(incomingDataTypes);

		for (DataType incomingDataType : incomingDataTypes.values()) {
			if (incomingDataType != null && !(incomingDataType instanceof NumericType || incomingDataType instanceof BooleanType)) {
				status.add(new Status(IStatus.ERROR, LibraryVIPlugin.PLUGIN_ID, "Input value must be numeric or boolean"));
			}
		}

		if (status.getSeverity() > IStatus.WARNING) {
			return new ComponentSignatureEvaluationResult(status);
		}
		return new ComponentSignatureEvaluationResult(signature, status);
	}

}
