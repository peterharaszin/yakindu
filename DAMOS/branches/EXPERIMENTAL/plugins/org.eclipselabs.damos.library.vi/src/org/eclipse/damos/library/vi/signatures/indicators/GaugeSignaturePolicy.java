package org.eclipse.damos.library.vi.signatures.indicators;

import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.damos.dml.Component;
import org.eclipse.damos.dml.InputPort;
import org.eclipse.damos.execution.datatype.AbstractComponentSignaturePolicy;
import org.eclipse.damos.execution.datatype.ComponentSignature;
import org.eclipse.damos.execution.datatype.ComponentSignatureEvaluationResult;
import org.eclipse.damos.execution.datatype.IComponentSignatureEvaluationResult;
import org.eclipse.damos.library.vi.LibraryVIPlugin;
import org.eclipse.damos.mscript.NumericType;
import org.eclipse.damos.mscript.Type;

/**
 * @author Andreas Unger
 *
 */
public class GaugeSignaturePolicy extends AbstractComponentSignaturePolicy {
	
	@Override
	public IComponentSignatureEvaluationResult evaluateSignature(Component component, Map<InputPort, Type> incomingDataTypes) {		
		MultiStatus status = new MultiStatus(LibraryVIPlugin.PLUGIN_ID, 0, "", null);
		
		ComponentSignature signature = new ComponentSignature(incomingDataTypes);

		Type incomingDataType = incomingDataTypes.get(component.getFirstInputPort());
		if (incomingDataType != null && !(incomingDataType instanceof NumericType)) {
			status.add(new Status(IStatus.ERROR, LibraryVIPlugin.PLUGIN_ID, "Input value must be numeric"));
		}
		
		if (status.getSeverity() > IStatus.WARNING) {
			return new ComponentSignatureEvaluationResult(status);
		}
		return new ComponentSignatureEvaluationResult(signature, status);
	}

}
