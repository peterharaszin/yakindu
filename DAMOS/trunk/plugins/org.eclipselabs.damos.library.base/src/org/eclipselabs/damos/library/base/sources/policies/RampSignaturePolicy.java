/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.library.base.sources.policies;

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
import org.eclipselabs.damos.library.base.sources.util.RampConstants;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.NumericType;
import org.eclipselabs.mscript.typesystem.RealType;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;
import org.eclipselabs.mscript.typesystem.Unit;
import org.eclipselabs.mscript.typesystem.UnitSymbol;
import org.eclipselabs.mscript.typesystem.util.TypeSystemUtil;

/**
 * @author Andreas Unger
 *
 */
public class RampSignaturePolicy extends AbstractBlockSignaturePolicy {
	
	public IComponentSignatureEvaluationResult evaluateSignature(IEvaluationContext context, Block block, Map<InputPort, DataType> incomingDataTypes) {
		MultiStatus status = new MultiStatus(LibraryBasePlugin.PLUGIN_ID, 0, "", null);
		
		NumericType initialValueDataType = null;
		try {
			initialValueDataType = EvaluationUtil.evaluateArgumentNumericType(context, block, RampConstants.PARAMETER__INITIAL_VALUE);
		} catch (CoreException e) {
			status.add(e.getStatus());
		}
		
		NumericType startTimeDataType = null;
		try {
			startTimeDataType = EvaluationUtil.evaluateArgumentNumericType(context, block, RampConstants.PARAMETER__START_TIME);
		} catch (CoreException e) {
			status.add(e.getStatus());
		}

		NumericType slopeDataType = null;
		try {
			slopeDataType = EvaluationUtil.evaluateArgumentNumericType(context, block, RampConstants.PARAMETER__SLOPE);
		} catch (CoreException e) {
			status.add(e.getStatus());
		}
		
		if (initialValueDataType == null || startTimeDataType == null || slopeDataType == null) {
			return new ComponentSignatureEvaluationResult(status);
		}

		if (startTimeDataType.isSetUnit() 
				&& !startTimeDataType.getUnit().isSameAs(TypeSystemUtil.createUnit(UnitSymbol.SECOND), true)) {
			status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Start Time unit must be second"));
		}

		if (slopeDataType.isSetUnit() 
				&& !slopeDataType.getUnit().isSameAs(initialValueDataType.getUnit().divide(TypeSystemUtil.createUnit(UnitSymbol.SECOND)), true)) {
			status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Slope unit must be Initial Value unit divided by seconds"));
		}

		if (!status.isOK()) {
			return new ComponentSignatureEvaluationResult(status);
		}
		
		Unit unit = initialValueDataType.getUnit();
		ComponentSignature signature = new ComponentSignature();

		NumericType outputDataType;
		if (initialValueDataType instanceof RealType) {
			outputDataType = TypeSystemFactory.eINSTANCE.createRealType();
		} else {
			outputDataType = TypeSystemFactory.eINSTANCE.createIntegerType();
		}
		outputDataType.setUnit((Unit) EcoreUtil.copy(unit));
		signature.getOutputDataTypes().put(block.getFirstOutputPort(), outputDataType);
		
		return new ComponentSignatureEvaluationResult(signature);
	}

}
