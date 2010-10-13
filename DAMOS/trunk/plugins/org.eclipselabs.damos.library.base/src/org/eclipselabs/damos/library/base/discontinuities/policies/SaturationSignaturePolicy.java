package org.eclipselabs.damos.library.base.discontinuities.policies;

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
import org.eclipselabs.damos.library.base.discontinuities.util.SaturationConstants;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.NumericType;

/**
 * @author Andreas Unger
 *
 */
public class SaturationSignaturePolicy extends AbstractBlockSignaturePolicy {
	
	public IComponentSignatureEvaluationResult evaluateSignature(IEvaluationContext context, Block block, Map<InputPort, DataType> incomingDataTypes) {		
		MultiStatus status = new MultiStatus(LibraryBasePlugin.PLUGIN_ID, 0, "", null);
		
		NumericType upperLimitDataType = null;
		try {
			upperLimitDataType = EvaluationUtil.evaluateArgumentNumericType(context, block, SaturationConstants.PARAMETER__UPPER_LIMIT);
		} catch (CoreException e) {
			status.add(e.getStatus());
		}
		
		NumericType lowerLimitDataType = null;
		try {
			lowerLimitDataType = EvaluationUtil.evaluateArgumentNumericType(context, block, SaturationConstants.PARAMETER__LOWER_LIMIT);
		} catch (CoreException e) {
			status.add(e.getStatus());
		}
		
		if (upperLimitDataType == null || lowerLimitDataType == null) {
			return new ComponentSignatureEvaluationResult(status);
		}

		if (!EcoreUtil.equals(upperLimitDataType.getUnit(), lowerLimitDataType.getUnit())) {
			status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Upper Limit and Lower Limit must have same unit"));
		}
		
		if (!status.isOK()) {
			return new ComponentSignatureEvaluationResult(status);
		}
		
		DataType incomingDataType = incomingDataTypes.get(block.getFirstInputPort());
		if (incomingDataType == null) {
			return new ComponentSignatureEvaluationResult(status);
		}

		if (!(incomingDataType instanceof NumericType)) {
			status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Input value must be numeric"));
		}
		
		if (!status.isOK()) {
			return new ComponentSignatureEvaluationResult(status);
		}

		if (!EcoreUtil.equals(((NumericType) incomingDataType).getUnit(), upperLimitDataType.getUnit())) {
			status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Upper Limit and Lower Limit must have same unit as input value"));
		}

		if (!status.isOK()) {
			return new ComponentSignatureEvaluationResult(status);
		}

		ComponentSignature signature = new ComponentSignature();
		signature.getOutputDataTypes().put(block.getFirstOutputPort(), (DataType) EcoreUtil.copy(incomingDataType));
		return new ComponentSignatureEvaluationResult(signature);
	}

}
