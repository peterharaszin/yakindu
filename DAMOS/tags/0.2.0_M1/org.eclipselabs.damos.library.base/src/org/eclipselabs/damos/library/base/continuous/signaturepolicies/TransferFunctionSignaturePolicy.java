package org.eclipselabs.damos.library.base.continuous.signaturepolicies;

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
import org.eclipselabs.mscript.typesystem.RealType;
import org.eclipselabs.mscript.typesystem.TensorType;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;
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
		
		IValue numerator = null;
		try {
			numerator = ExpressionUtil.evaluateArgumentExpression(block, TransferFunctionConstants.PARAMETER__NUMERATOR_COEFFICIENTS);
		} catch (CoreException e) {
			status.add(e.getStatus());
		}
		
		IValue denominator = null;
		try {
			denominator = ExpressionUtil.evaluateArgumentExpression(block, TransferFunctionConstants.PARAMETER__DENOMINATOR_COEFFICIENTS);
		} catch (CoreException e) {
			status.add(e.getStatus());
		}
		
		if (numerator == null || denominator == null) {
			return new ComponentSignatureEvaluationResult(status);
		}
		
		if (!TypeSystemUtil.isVector(numerator.getDataType())) {
			status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Numerator must be be vector"));
		}
		
		if (!TypeSystemUtil.isVector(denominator.getDataType())) {
			status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Denominator must be be vector"));
		}

		if (!status.isOK()) {
			return new ComponentSignatureEvaluationResult(status);
		}

		Unit dimensionlessUnit = TypeSystemUtil.createUnit();
		
		TensorType numeratorType = (TensorType) numerator.getDataType();
		TensorType denominatorType = (TensorType) denominator.getDataType();
		
		if (numeratorType.getElementType().getUnit() == null || !numeratorType.getElementType().getUnit().isSameAs(dimensionlessUnit, false)) {
			status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Numerator coefficients must be dimensionless"));
		}
		
		if (denominatorType.getElementType().getUnit() == null || !denominatorType.getElementType().getUnit().isSameAs(dimensionlessUnit, false)) {
			status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Denominator coefficients must be dimensionless"));
		}

		if (!status.isOK()) {
			return new ComponentSignatureEvaluationResult(status);
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
		
		RealType outputDataType;
		
		if (incomingDataType instanceof RealType) {
			outputDataType = EcoreUtil.copy((RealType) incomingDataType);
		} else {
			outputDataType = TypeSystemFactory.eINSTANCE.createRealType();
			outputDataType.setUnit(TypeSystemUtil.createUnit());
		}

		ComponentSignature signature = new ComponentSignature(incomingDataTypes);
		signature.getOutputDataTypes().put(component.getFirstOutputPort(), outputDataType);
		return new ComponentSignatureEvaluationResult(signature);
	}

}
