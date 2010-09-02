package org.eclipselabs.damos.library.base.math.policies;

import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.evaluation.IEvaluationContext;
import org.eclipselabs.damos.evaluation.componentsignature.AbstractBlockSignaturePolicy;
import org.eclipselabs.damos.evaluation.componentsignature.ComponentSignature;
import org.eclipselabs.damos.evaluation.componentsignature.ComponentSignatureEvaluationResult;
import org.eclipselabs.damos.evaluation.componentsignature.IComponentSignatureEvaluationResult;
import org.eclipselabs.damos.library.base.LibraryBasePlugin;
import org.eclipselabs.damos.typesystem.DataType;
import org.eclipselabs.damos.typesystem.IntegerType;
import org.eclipselabs.damos.typesystem.NumericalType;
import org.eclipselabs.damos.typesystem.RealType;
import org.eclipselabs.damos.typesystem.TypeSystemFactory;
import org.eclipselabs.damos.typesystem.Unit;

/**
 * @author Andreas Unger
 *
 */
public class SumSignaturePolicy extends AbstractBlockSignaturePolicy {
	
	public IComponentSignatureEvaluationResult evaluateSignature(IEvaluationContext context, Block block, Map<InputPort, DataType> incomingDataTypes) {
		MultiStatus status = new MultiStatus(LibraryBasePlugin.PLUGIN_ID, 0, "", null);
		
		Unit unit = null;
		boolean real = false;
		for (Entry<InputPort, DataType> entry : incomingDataTypes.entrySet()) {
			if (!(entry.getValue() instanceof NumericalType)) {
				status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Input values must be numerical"));
				return new ComponentSignatureEvaluationResult(status);
			}
			NumericalType dataType = (NumericalType) entry.getValue();
			if (unit == null) {
				unit = dataType.getUnit();
			} else if (!unit.isSameAs(dataType.getUnit(), false)) {
				status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Input values must have same unit"));
				return new ComponentSignatureEvaluationResult(status);
			}
			if (dataType instanceof RealType) {
				real = true;
			}
		}

		if (unit == null) {
			return new ComponentSignatureEvaluationResult(status);
		}

		ComponentSignature signature = new ComponentSignature();
		
		if (real) {
			RealType realType = TypeSystemFactory.eINSTANCE.createRealType();
			realType.setUnit((Unit) EcoreUtil.copy(unit));
			signature.getInputDataTypes().put(block.getFirstInputPort(), realType);
			for (OutputPort outputPort : block.getOutputPorts()) {
				realType = TypeSystemFactory.eINSTANCE.createRealType();
				realType.setUnit((Unit) EcoreUtil.copy(unit));
				signature.getOutputDataTypes().put(outputPort, realType);
			}
		} else {
			IntegerType integerType = TypeSystemFactory.eINSTANCE.createIntegerType();
			integerType.setUnit((Unit) EcoreUtil.copy(unit));
			signature.getInputDataTypes().put(block.getFirstInputPort(), integerType);
			for (OutputPort outputPort : block.getOutputPorts()) {
				integerType = TypeSystemFactory.eINSTANCE.createIntegerType();
				integerType.setUnit((Unit) EcoreUtil.copy(unit));
				signature.getOutputDataTypes().put(outputPort, integerType);
			}
		}
		
		return new ComponentSignatureEvaluationResult(signature);
	}

}
