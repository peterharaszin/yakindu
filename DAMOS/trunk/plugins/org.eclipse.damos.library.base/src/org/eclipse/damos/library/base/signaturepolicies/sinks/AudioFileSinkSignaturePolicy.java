package org.eclipse.damos.library.base.signaturepolicies.sinks;

import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.damos.dml.Block;
import org.eclipse.damos.dml.Component;
import org.eclipse.damos.dml.InputPort;
import org.eclipse.damos.execution.datatype.AbstractComponentSignaturePolicy;
import org.eclipse.damos.execution.datatype.ComponentSignature;
import org.eclipse.damos.execution.datatype.ComponentSignatureEvaluationResult;
import org.eclipse.damos.execution.datatype.IComponentSignatureEvaluationResult;
import org.eclipse.damos.library.base.LibraryBasePlugin;
import org.eclipse.damos.library.base.util.audio.AudioFileUtil;
import org.eclipse.damos.mscript.NumericType;
import org.eclipse.damos.mscript.Type;

/**
 * @author Andreas Unger
 *
 */
public class AudioFileSinkSignaturePolicy extends AbstractComponentSignaturePolicy {
	
	@Override
	public IComponentSignatureEvaluationResult evaluateSignature(Component component, Map<InputPort, Type> incomingDataTypes) {
		Block block = (Block) component;
		
		MultiStatus status = new MultiStatus(LibraryBasePlugin.PLUGIN_ID, 0, "", null);
		
		IStatus fileURIStatus = AudioFileUtil.checkFileURI(block);
		if (!fileURIStatus.isOK()) {
			status.add(fileURIStatus);
		}

		ComponentSignature signature = new ComponentSignature(incomingDataTypes);

		for (InputPort inputPort : component.getPrimaryInputPorts()) {
			Type incomingDataType = incomingDataTypes.get(inputPort);
			if (incomingDataType != null && !(incomingDataType instanceof NumericType)) {
				status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Input values must be numeric"));
			}
		}
		
		if (status.getSeverity() > IStatus.WARNING) {
			return new ComponentSignatureEvaluationResult(status);
		}
		return new ComponentSignatureEvaluationResult(signature, status);
	}

}
