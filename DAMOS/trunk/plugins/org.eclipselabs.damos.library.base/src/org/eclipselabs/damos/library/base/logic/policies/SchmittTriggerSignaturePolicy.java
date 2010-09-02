package org.eclipselabs.damos.library.base.logic.policies;

import java.util.Map;

import org.eclipse.core.runtime.CoreException;
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
import org.eclipselabs.damos.evaluation.util.EvaluationUtil;
import org.eclipselabs.damos.library.base.LibraryBasePlugin;
import org.eclipselabs.damos.library.base.logic.util.SchmittTriggerConstants;
import org.eclipselabs.damos.typesystem.BooleanType;
import org.eclipselabs.damos.typesystem.DataType;
import org.eclipselabs.damos.typesystem.NumericalType;
import org.eclipselabs.damos.typesystem.TypeSystemFactory;

/**
 * @author Andreas Unger
 *
 */
public class SchmittTriggerSignaturePolicy extends AbstractBlockSignaturePolicy {
	
	public IComponentSignatureEvaluationResult evaluateSignature(IEvaluationContext context, Block block, Map<InputPort, DataType> incomingDataTypes) {		
		MultiStatus status = new MultiStatus(LibraryBasePlugin.PLUGIN_ID, 0, "", null);
		
		BooleanType initialOutputDataType = null;
		try {
			initialOutputDataType = EvaluationUtil.evaluateArgumentBooleanType(context, block, SchmittTriggerConstants.PARAMETER__INITIAL_OUTPUT);
		} catch (CoreException e) {
			status.add(e.getStatus());
		}

		NumericalType upperThresholdDataType = null;
		try {
			upperThresholdDataType = EvaluationUtil.evaluateArgumentNumericalType(context, block, SchmittTriggerConstants.PARAMETER__UPPER_THRESHOLD);
		} catch (CoreException e) {
			status.add(e.getStatus());
		}
		
		NumericalType lowerThresholdDataType = null;
		try {
			lowerThresholdDataType = EvaluationUtil.evaluateArgumentNumericalType(context, block, SchmittTriggerConstants.PARAMETER__LOWER_THRESHOLD);
		} catch (CoreException e) {
			status.add(e.getStatus());
		}
		
		if (initialOutputDataType == null || upperThresholdDataType == null || lowerThresholdDataType == null) {
			return new ComponentSignatureEvaluationResult(status);
		}

		if (!EcoreUtil.equals(upperThresholdDataType.getUnit(), lowerThresholdDataType.getUnit())) {
			status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Upper Threshold and Lower Threshold must have same unit"));
		}
		
		if (!status.isOK()) {
			return new ComponentSignatureEvaluationResult(status);
		}
		
		DataType incomingDataType = incomingDataTypes.get(block.getFirstInputPort());
		if (incomingDataType != null && !(incomingDataType instanceof NumericalType)) {
			status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Input value must be numerical"));
		}
		
		if (!status.isOK()) {
			return new ComponentSignatureEvaluationResult(status);
		}

		if (incomingDataType != null && !EcoreUtil.equals(((NumericalType) incomingDataType).getUnit(), upperThresholdDataType.getUnit())) {
			status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Upper Threshold and Lower Threshold must have same unit as input value"));
		}

		if (!status.isOK()) {
			return new ComponentSignatureEvaluationResult(status);
		}

		ComponentSignature signature = new ComponentSignature();
		if (incomingDataType != null) {
			signature.getInputDataTypes().put(block.getFirstInputPort(), (DataType) EcoreUtil.copy(incomingDataType));
		}
		signature.getOutputDataTypes().put(block.getFirstOutputPort(), TypeSystemFactory.eINSTANCE.createBooleanType());
		
		return new ComponentSignatureEvaluationResult(signature);
	}

}
