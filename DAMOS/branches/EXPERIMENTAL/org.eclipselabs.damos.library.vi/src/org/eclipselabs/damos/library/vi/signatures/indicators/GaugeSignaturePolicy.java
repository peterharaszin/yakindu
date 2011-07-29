package org.eclipselabs.damos.library.vi.signatures.indicators;

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
import org.eclipselabs.damos.library.vi.LibraryVIPlugin;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.NumericType;

/**
 * @author Andreas Unger
 *
 */
public class GaugeSignaturePolicy extends AbstractComponentSignaturePolicy {
	
	@Override
	public IComponentSignatureEvaluationResult evaluateSignature(Component component, Map<InputPort, DataType> incomingDataTypes) {		
		MultiStatus status = new MultiStatus(LibraryVIPlugin.PLUGIN_ID, 0, "", null);
		
		ComponentSignature signature = new ComponentSignature(incomingDataTypes);

		DataType incomingDataType = incomingDataTypes.get(component.getFirstInputPort());
		if (incomingDataType != null && !(incomingDataType instanceof NumericType)) {
			status.add(new Status(IStatus.ERROR, LibraryVIPlugin.PLUGIN_ID, "Input value must be numeric"));
		}
		
		if (!status.isOK()) {
			return new ComponentSignatureEvaluationResult(status);
		}
		return new ComponentSignatureEvaluationResult(signature);
	}

}
