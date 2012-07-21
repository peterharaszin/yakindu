package org.eclipselabs.damos.library.base.signaturepolicies.sinks;

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
import org.eclipselabs.damos.library.base.util.sinks.ScopeConstants;
import org.eclipselabs.damos.mscript.BooleanType;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.NumericType;
import org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue;

/**
 * @author Andreas Unger
 *
 */
abstract class AbstractScopeSignaturePolicy extends AbstractComponentSignaturePolicy {
	
	@Override
	public IComponentSignatureEvaluationResult evaluateSignature(Component component, Map<InputPort, Type> incomingDataTypes) {		
		Block block = (Block) component;

		MultiStatus status = new MultiStatus(LibraryBasePlugin.PLUGIN_ID, 0, "", null);
		
		ComponentSignature signature = new ComponentSignature(incomingDataTypes);
		
		if (block.getArgument(ScopeConstants.PARAMETER__DATA_POINT_LIMIT) != null) { // Check for backward-compatibility
			try {
				ISimpleNumericValue dataPointLimitValue = ExpressionUtil.evaluateIntegerArgument(block, ScopeConstants.PARAMETER__DATA_POINT_LIMIT);
				long dataPointLimit = dataPointLimitValue.longValue();
				if (!(dataPointLimit > 0 && dataPointLimit < Integer.MAX_VALUE)) {
					status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Data point limit must be greater than 0 and less than " + Integer.MAX_VALUE));
				}
			} catch (CoreException e) {
				status.add(e.getStatus());
			}
		}

		for (InputPort inputPort : component.getInputPorts()) {
			Type incomingDataType = incomingDataTypes.get(inputPort);
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
