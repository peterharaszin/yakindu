package org.eclipselabs.damos.library.base.logic.policies;

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
import org.eclipselabs.damos.typesystem.DataType;
import org.eclipselabs.damos.typesystem.NumericalType;
import org.eclipselabs.damos.typesystem.TypeSystemFactory;

/**
 * @author Andreas Unger
 *
 */
public class CompareSignaturePolicy extends AbstractBlockSignaturePolicy {
	
	public IComponentSignatureEvaluationResult evaluateSignature(IEvaluationContext context, Block block, Map<InputPort, DataType> incomingDataTypes) {		
		MultiStatus status = new MultiStatus(LibraryBasePlugin.PLUGIN_ID, 0, "", null);
		
		// TODO check operator type

		InputPort inputPort1 = block.getInputs().get(0).getPorts().get(0);
		InputPort inputPort2 = block.getInputs().get(1).getPorts().get(0);
		DataType incomingDataType1 = incomingDataTypes.get(inputPort1);
		DataType incomingDataType2 = incomingDataTypes.get(inputPort2);

		if (incomingDataType1 != null && !(incomingDataType1 instanceof NumericalType) || incomingDataType2 != null && !(incomingDataType2 instanceof NumericalType)) {
			status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Input values must be numerical"));
		}
		
		if (!status.isOK()) {
			return new ComponentSignatureEvaluationResult(status);
		}

		if (incomingDataType1 != null && incomingDataType2 != null && !((NumericalType) incomingDataType1).getUnit().isSameAs(((NumericalType) incomingDataType2).getUnit(), false)) {
			status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Input values must have same unit"));
		}

		if (!status.isOK()) {
			return new ComponentSignatureEvaluationResult(status);
		}

		ComponentSignature signature = new ComponentSignature();
		if (incomingDataType1 != null) {
			signature.getInputDataTypes().put(inputPort1, (DataType) EcoreUtil.copy(incomingDataType1));
		}
		if (incomingDataType2 != null) {
			signature.getInputDataTypes().put(inputPort2, (DataType) EcoreUtil.copy(incomingDataType2));
		}
		signature.getOutputDataTypes().put(block.getFirstOutputPort(), TypeSystemFactory.eINSTANCE.createBooleanType());
		
		return new ComponentSignatureEvaluationResult(signature);
	}

}
