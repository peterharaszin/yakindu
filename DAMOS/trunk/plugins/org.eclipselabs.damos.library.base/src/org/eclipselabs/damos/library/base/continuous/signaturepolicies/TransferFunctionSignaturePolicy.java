package org.eclipselabs.damos.library.base.continuous.signaturepolicies;

import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.execution.engine.AbstractComponentSignaturePolicy;
import org.eclipselabs.damos.execution.engine.ComponentSignature;
import org.eclipselabs.damos.execution.engine.ComponentSignatureEvaluationResult;
import org.eclipselabs.damos.execution.engine.IComponentSignatureEvaluationResult;
import org.eclipselabs.damos.execution.engine.util.ExpressionUtil;
import org.eclipselabs.damos.library.base.LibraryBasePlugin;
import org.eclipselabs.damos.library.base.continuous.util.TransferFunctionConstants;
import org.eclipselabs.mscript.computation.engine.value.IValue;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.NumericType;
import org.eclipselabs.mscript.typesystem.Unit;
import org.eclipselabs.mscript.typesystem.util.TypeSystemUtil;

/**
 * @author Andreas Unger
 *
 */
public class TransferFunctionSignaturePolicy extends AbstractComponentSignaturePolicy {
	
	@Override
	public IComponentSignatureEvaluationResult evaluateSignature(Component component, Map<InputPort, DataType> incomingDataTypes) {
		Block block = (Block) component;
		
		MultiStatus status = new MultiStatus(LibraryBasePlugin.PLUGIN_ID, 0, "", null);
		
		List<IValue> numeratorTypes = null;
		try {
			numeratorTypes = ExpressionUtil.evaluateArgumentExpressionList(block, TransferFunctionConstants.PARAMETER__NUMERATOR_COEFFICIENTS);
		} catch (CoreException e) {
			status.add(e.getStatus());
		}
		
		List<IValue> denominatorTypes = null;
		try {
			denominatorTypes = ExpressionUtil.evaluateArgumentExpressionList(block, TransferFunctionConstants.PARAMETER__DENOMINATOR_COEFFICIENTS);
		} catch (CoreException e) {
			status.add(e.getStatus());
		}
		
		if (numeratorTypes == null || denominatorTypes == null) {
			return new ComponentSignatureEvaluationResult(status);
		}
		
		Unit dimensionlessUnit = TypeSystemUtil.createUnit();
		
		for (IValue numeratorValue : numeratorTypes) {
			if (numeratorValue.getDataType() instanceof NumericType) {
				NumericType numericType = (NumericType) numeratorValue.getDataType();
				if (!dimensionlessUnit.isSameAs(numericType.getUnit(), false)) {
					status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Numerator Coefficients must be dimensionless"));
				}
			} else {
				status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Numerator Coefficients must be numeric"));
			}
		}

		for (IValue denominatorValue : denominatorTypes) {
			if (denominatorValue instanceof NumericType) {
				NumericType numericType = (NumericType) denominatorValue.getDataType();
				if (!dimensionlessUnit.isSameAs(numericType.getUnit(), false)) {
					status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Denominator Coefficients must be dimensionless"));
				}
			} else {
				status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Denominator Coefficients must be numeric"));
			}
		}
		
		DataType incomingDataType = incomingDataTypes.get(component.getFirstInputPort());
		if (incomingDataType == null) {
			return new ComponentSignatureEvaluationResult(status);
		}
		
		if (incomingDataType instanceof NumericType) {
			if (!dimensionlessUnit.isSameAs(((NumericType) incomingDataType).getUnit(), false)) {
				status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Input value must be dimensionless"));
			}
		} else {
			status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Input value must be numeric"));
		}
		
		if (!status.isOK()) {
			return new ComponentSignatureEvaluationResult(status);
		}

		ComponentSignature signature = new ComponentSignature(incomingDataTypes);
		signature.getOutputDataTypes().put(component.getFirstOutputPort(), EcoreUtil.copy(incomingDataType));
		return new ComponentSignatureEvaluationResult(signature);
	}

}
