package org.eclipselabs.damos.library.base.discrete.policies;

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
import org.eclipselabs.damos.library.base.discrete.util.DelayConstants;
import org.eclipselabs.damos.typesystem.DataType;
import org.eclipselabs.damos.typesystem.IntegerType;
import org.eclipselabs.damos.typesystem.NumericalType;
import org.eclipselabs.damos.typesystem.RealType;
import org.eclipselabs.damos.typesystem.util.TypeSystemUtil;

/**
 * @author Andreas Unger
 *
 */
public class DelaySignaturePolicy extends AbstractBlockSignaturePolicy {
	
	public IComponentSignatureEvaluationResult evaluateSignature(IEvaluationContext context, Block block, Map<InputPort, DataType> incomingDataTypes) {		
		MultiStatus status = new MultiStatus(LibraryBasePlugin.PLUGIN_ID, 0, "", null);
		
		NumericalType initialConditionDataType = null;
		try {
			initialConditionDataType = EvaluationUtil.evaluateArgumentNumericalType(context, block, DelayConstants.PARAMETER__INITIAL_CONDITION);
		} catch (CoreException e) {
			status.add(e.getStatus());
		}
		
		IntegerType delayDataType = null;
		try {
			delayDataType = EvaluationUtil.evaluateArgumentIntegerType(context, block, DelayConstants.PARAMETER__DELAY);
		} catch (CoreException e) {
			status.add(e.getStatus());
		}
		
		if (initialConditionDataType == null || delayDataType == null) {
			return new ComponentSignatureEvaluationResult(status);
		}

		if (!EcoreUtil.equals(delayDataType.getUnit(), TypeSystemUtil.createUnit())) {
			status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Delay must be dimensionless"));
		}
		
		if (!status.isOK()) {
			return new ComponentSignatureEvaluationResult(status);
		}
		
		DataType incomingDataType = incomingDataTypes.get(block.getFirstInputPort());
		if (incomingDataType == null) {
			return new ComponentSignatureEvaluationResult(status);
		}

		if (!(incomingDataType instanceof NumericalType)) {
			status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Input value must be numerical"));
		}
		
		if (!status.isOK()) {
			return new ComponentSignatureEvaluationResult(status);
		}

		if (incomingDataType instanceof IntegerType && initialConditionDataType instanceof RealType) {
			status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Input value is integer, thus Initial Condition must be integer"));
		}
		
		if (!EcoreUtil.equals(((NumericalType) incomingDataType).getUnit(), initialConditionDataType.getUnit())) {
			status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Initial Condition must have same unit as input value"));
		}

		if (!status.isOK()) {
			return new ComponentSignatureEvaluationResult(status);
		}

		ComponentSignature signature = new ComponentSignature();
		signature.getInputDataTypes().put(block.getFirstInputPort(), (DataType) EcoreUtil.copy(incomingDataType));
		signature.getOutputDataTypes().put(block.getFirstOutputPort(), (DataType) EcoreUtil.copy(incomingDataType));
		
		return new ComponentSignatureEvaluationResult(signature);
	}

}
