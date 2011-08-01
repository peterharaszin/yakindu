package org.eclipselabs.damos.library.base.continuous.signaturepolicies;

import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.execution.core.AbstractComponentSignaturePolicy;
import org.eclipselabs.damos.execution.core.ComponentSignature;
import org.eclipselabs.damos.execution.core.ComponentSignatureEvaluationResult;
import org.eclipselabs.damos.execution.core.IComponentSignatureEvaluationResult;
import org.eclipselabs.damos.execution.core.util.ExpressionUtil;
import org.eclipselabs.damos.library.base.LibraryBasePlugin;
import org.eclipselabs.damos.library.base.continuous.util.DerivativeConstants;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.NumericType;
import org.eclipselabs.mscript.typesystem.OperatorKind;
import org.eclipselabs.mscript.typesystem.RealType;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;
import org.eclipselabs.mscript.typesystem.UnitSymbol;
import org.eclipselabs.mscript.typesystem.util.TypeSystemUtil;

/**
 * @author Andreas Unger
 *
 */
public class DerivativeSignaturePolicy extends AbstractComponentSignaturePolicy {
	
	@Override
	public IComponentSignatureEvaluationResult evaluateSignature(Component component, Map<InputPort, DataType> incomingDataTypes) {
		Block block = (Block) component;
		
		MultiStatus status = new MultiStatus(LibraryBasePlugin.PLUGIN_ID, 0, "", null);
		
		NumericType gainDataType = null;
		try {
			gainDataType = ExpressionUtil.evaluateSimpleNumericArgument(block, DerivativeConstants.PARAMETER__GAIN).getDataType();
		} catch (CoreException e) {
			status.add(e.getStatus());
		}

		if (status.getSeverity() > IStatus.WARNING) {
			return new ComponentSignatureEvaluationResult(status);
		}
		
		DataType incomingDataType = incomingDataTypes.get(component.getFirstInputPort());
		if (incomingDataType == null) {
			return new ComponentSignatureEvaluationResult();
		}
		
		if (!(incomingDataType instanceof NumericType)) {
			status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Input value must be numeric"));
		}
		
		if (status.getSeverity() > IStatus.WARNING) {
			return new ComponentSignatureEvaluationResult(status);
		}
		
		NumericType incomingNumericType = (NumericType) incomingDataType;
		
		if (status.getSeverity() > IStatus.WARNING) {
			return new ComponentSignatureEvaluationResult(status);
		}

		RealType outputDataType = TypeSystemFactory.eINSTANCE.createRealType();
		outputDataType.setUnit(incomingNumericType.getUnit().evaluate(OperatorKind.MULTIPLY, gainDataType.getUnit()).evaluate(OperatorKind.DIVIDE, TypeSystemUtil.createUnit(UnitSymbol.SECOND)));
		
		ComponentSignature signature = new ComponentSignature(incomingDataTypes);
		signature.getOutputDataTypes().put(component.getFirstOutputPort(), outputDataType);
		return new ComponentSignatureEvaluationResult(signature, status);
	}

}
