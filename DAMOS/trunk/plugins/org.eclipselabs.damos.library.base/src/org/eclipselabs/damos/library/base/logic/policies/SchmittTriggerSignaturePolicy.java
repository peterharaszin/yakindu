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
import org.eclipselabs.mscript.typesystem.BooleanType;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.NumericType;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;

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

		NumericType upperThresholdDataType = null;
		try {
			upperThresholdDataType = EvaluationUtil.evaluateArgumentNumericType(context, block, SchmittTriggerConstants.PARAMETER__UPPER_THRESHOLD);
		} catch (CoreException e) {
			status.add(e.getStatus());
		}
		
		NumericType lowerThresholdDataType = null;
		try {
			lowerThresholdDataType = EvaluationUtil.evaluateArgumentNumericType(context, block, SchmittTriggerConstants.PARAMETER__LOWER_THRESHOLD);
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
		if (incomingDataType != null && !(incomingDataType instanceof NumericType)) {
			status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Input value must be numeric"));
		}
		
		if (!status.isOK()) {
			return new ComponentSignatureEvaluationResult(status);
		}

		if (incomingDataType != null && !EcoreUtil.equals(((NumericType) incomingDataType).getUnit(), upperThresholdDataType.getUnit())) {
			status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Upper Threshold and Lower Threshold must have same unit as input value"));
		}

		if (!status.isOK()) {
			return new ComponentSignatureEvaluationResult(status);
		}

		ComponentSignature signature = new ComponentSignature();
		signature.getOutputDataTypes().put(block.getFirstOutputPort(), TypeSystemFactory.eINSTANCE.createBooleanType());
		return new ComponentSignatureEvaluationResult(signature);
	}

}
