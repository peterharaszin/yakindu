package org.eclipselabs.damos.library.base.signaturepolicies.continuous;

import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.execution.datatype.AbstractComponentSignaturePolicy;
import org.eclipselabs.damos.execution.datatype.ComponentSignature;
import org.eclipselabs.damos.execution.datatype.ComponentSignatureEvaluationResult;
import org.eclipselabs.damos.execution.datatype.IComponentSignatureEvaluationResult;
import org.eclipselabs.damos.execution.util.ExpressionUtil;
import org.eclipselabs.damos.library.base.LibraryBasePlugin;
import org.eclipselabs.damos.library.base.util.continuous.TransferFunctionConstants;
import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.NumericType;
import org.eclipselabs.damos.mscript.RealType;
import org.eclipselabs.damos.mscript.Unit;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.util.TypeUtil;

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
		
		if (!TypeUtil.isNumericVector(numerator.getDataType())) {
			status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Numerator must be be vector"));
		}
		
		if (!TypeUtil.isNumericVector(denominator.getDataType())) {
			status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Denominator must be be vector"));
		}

		if (status.getSeverity() > IStatus.WARNING) {
			return new ComponentSignatureEvaluationResult(status);
		}

		Unit dimensionlessUnit = TypeUtil.createUnit();
		
		ArrayType numeratorType = (ArrayType) numerator.getDataType();
		ArrayType denominatorType = (ArrayType) denominator.getDataType();
		
		NumericType numeratorElementType = (NumericType) numeratorType.getElementType();
		if (numeratorElementType.getUnit() == null || !numeratorElementType.getUnit().isEquivalentTo(dimensionlessUnit, false)) {
			status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Numerator coefficients must be dimensionless"));
		}
		
		NumericType denominatorElementType = (NumericType) denominatorType.getElementType();
		if (denominatorElementType.getUnit() == null || !denominatorElementType.getUnit().isEquivalentTo(dimensionlessUnit, false)) {
			status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Denominator coefficients must be dimensionless"));
		}

		if (status.getSeverity() > IStatus.WARNING) {
			return new ComponentSignatureEvaluationResult(status);
		}
		
		DataType incomingDataType = incomingDataTypes.get(component.getFirstInputPort());
		if (incomingDataType == null) {
			return new ComponentSignatureEvaluationResult(status);
		}
		
		if (incomingDataType instanceof NumericType) {
			if (!dimensionlessUnit.isEquivalentTo(((NumericType) incomingDataType).getUnit(), false)) {
				status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Input value must be dimensionless"));
			}
		} else {
			status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Input value must be numeric"));
		}
		
		if (status.getSeverity() > IStatus.WARNING) {
			return new ComponentSignatureEvaluationResult(status);
		}
		
		RealType outputDataType;
		
		if (incomingDataType instanceof RealType) {
			outputDataType = EcoreUtil.copy((RealType) incomingDataType);
		} else {
			outputDataType = MscriptFactory.eINSTANCE.createRealType();
			outputDataType.setUnit(TypeUtil.createUnit());
		}

		ComponentSignature signature = new ComponentSignature(incomingDataTypes);
		signature.getOutputDataTypes().put(component.getFirstOutputPort(), outputDataType);
		return new ComponentSignatureEvaluationResult(signature, status);
	}

}
