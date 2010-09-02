package org.eclipselabs.damos.library.base.continuous.policies;

import java.util.List;
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
import org.eclipselabs.damos.library.base.continuous.util.TransferFunctionConstants;
import org.eclipselabs.damos.typesystem.DataType;
import org.eclipselabs.damos.typesystem.NumericalType;
import org.eclipselabs.damos.typesystem.Unit;
import org.eclipselabs.damos.typesystem.util.TypeSystemUtil;

/**
 * @author Andreas Unger
 *
 */
public class TransferFunctionSignaturePolicy extends AbstractBlockSignaturePolicy {
	
	public IComponentSignatureEvaluationResult evaluateSignature(IEvaluationContext context, Block block, Map<InputPort, DataType> incomingDataTypes) {		
		MultiStatus status = new MultiStatus(LibraryBasePlugin.PLUGIN_ID, 0, "", null);
		
		List<DataType> numeratorTypes = null;
		try {
			numeratorTypes = EvaluationUtil.evaluateArgumentExpressionListDataTypes(context, block, TransferFunctionConstants.PARAMETER__NUMERATOR_COEFFICIENTS);
		} catch (CoreException e) {
			status.add(e.getStatus());
		}
		
		List<DataType> denominatorTypes = null;
		try {
			denominatorTypes = EvaluationUtil.evaluateArgumentExpressionListDataTypes(context, block, TransferFunctionConstants.PARAMETER__DENOMINATOR_COEFFICIENTS);
		} catch (CoreException e) {
			status.add(e.getStatus());
		}
		
		if (numeratorTypes == null || denominatorTypes == null) {
			return new ComponentSignatureEvaluationResult(status);
		}
		
		Unit dimensionlessUnit = TypeSystemUtil.createUnit();
		
		for (DataType numeratorType : numeratorTypes) {
			if (numeratorType instanceof NumericalType) {
				if (!dimensionlessUnit.isSameAs(((NumericalType) numeratorType).getUnit(), false)) {
					status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Numerator Coefficients must be dimensionless"));
				}
			} else {
				status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Numerator Coefficients must be numerical"));
			}
		}

		for (DataType denominatorType : denominatorTypes) {
			if (denominatorType instanceof NumericalType) {
				if (!dimensionlessUnit.isSameAs(((NumericalType) denominatorType).getUnit(), false)) {
					status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Denominator Coefficients must be dimensionless"));
				}
			} else {
				status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Denominator Coefficients must be numerical"));
			}
		}
		
		DataType incomingDataType = incomingDataTypes.get(block.getFirstInputPort());
		if (incomingDataType == null) {
			return new ComponentSignatureEvaluationResult(status);
		}
		
		if (incomingDataType instanceof NumericalType) {
			if (!dimensionlessUnit.isSameAs(((NumericalType) incomingDataType).getUnit(), false)) {
				status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Input value must be dimensionless"));
			}
		} else {
			status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Input value must be numerical"));
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
