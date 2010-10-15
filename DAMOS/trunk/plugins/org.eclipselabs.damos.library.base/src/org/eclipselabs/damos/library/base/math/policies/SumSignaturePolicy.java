package org.eclipselabs.damos.library.base.math.policies;

import java.util.Map;
import java.util.Map.Entry;

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
import org.eclipselabs.damos.library.base.LibraryBasePlugin;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.IntegerType;
import org.eclipselabs.mscript.typesystem.NumericType;
import org.eclipselabs.mscript.typesystem.RealType;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;
import org.eclipselabs.mscript.typesystem.Unit;

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
			if (!(entry.getValue() instanceof NumericType)) {
				status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Input values must be numeric"));
				return new ComponentSignatureEvaluationResult(status);
			}
			NumericType dataType = (NumericType) entry.getValue();
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
			realType.setUnit(EcoreUtil.copy(unit));
			signature.getOutputDataTypes().put(block.getFirstOutputPort(), realType);
		} else {
			IntegerType integerType = TypeSystemFactory.eINSTANCE.createIntegerType();
			integerType.setUnit(EcoreUtil.copy(unit));
			signature.getOutputDataTypes().put(block.getFirstOutputPort(), integerType);
		}
		
		return new ComponentSignatureEvaluationResult(signature);
	}

}
