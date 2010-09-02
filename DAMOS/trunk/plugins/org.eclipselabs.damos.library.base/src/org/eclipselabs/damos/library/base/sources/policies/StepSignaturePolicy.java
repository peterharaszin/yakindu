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
import org.eclipselabs.damos.library.base.sources.util.StepConstants;
import org.eclipselabs.damos.typesystem.DataType;
import org.eclipselabs.damos.typesystem.NumericalType;
import org.eclipselabs.damos.typesystem.RealType;
import org.eclipselabs.damos.typesystem.TypeSystemFactory;
import org.eclipselabs.damos.typesystem.Unit;
import org.eclipselabs.damos.typesystem.UnitSymbol;
import org.eclipselabs.damos.typesystem.util.TypeSystemUtil;

/**
 * @author Andreas Unger
 *
 */
public class StepSignaturePolicy extends AbstractBlockSignaturePolicy {
	
	public IComponentSignatureEvaluationResult evaluateSignature(IEvaluationContext context, Block block, Map<InputPort, DataType> incomingDataTypes) {
		MultiStatus status = new MultiStatus(LibraryBasePlugin.PLUGIN_ID, 0, "", null);
		
		NumericalType initialValueDataType = null;
		try {
			initialValueDataType = EvaluationUtil.evaluateArgumentNumericalType(context, block, StepConstants.PARAMETER__INITIAL_VALUE);
		} catch (CoreException e) {
			status.add(e.getStatus());
		}
		
		NumericalType finalValueDataType = null;
		try {
			finalValueDataType = EvaluationUtil.evaluateArgumentNumericalType(context, block, StepConstants.PARAMETER__FINAL_VALUE);
		} catch (CoreException e) {
			status.add(e.getStatus());
		}
		
		NumericalType stepTimeDataType = null;
		try {
			stepTimeDataType = EvaluationUtil.evaluateArgumentNumericalType(context, block, StepConstants.PARAMETER__STEP_TIME);
		} catch (CoreException e) {
			status.add(e.getStatus());
		}
		
		if (initialValueDataType == null || finalValueDataType == null || stepTimeDataType == null) {
			return new ComponentSignatureEvaluationResult(status);
		}

		if (!EcoreUtil.equals(initialValueDataType.getUnit(), finalValueDataType.getUnit())) {
			status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Initial Value and Final Value must have same unit"));
		}
		
		if (stepTimeDataType.isSetUnit() 
				&& !stepTimeDataType.getUnit().isSameAs(TypeSystemUtil.createUnit(UnitSymbol.SECOND), true)) {
			status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Step Time unit must be second"));
		}

		if (!status.isOK()) {
			return new ComponentSignatureEvaluationResult(status);
		}
		
		Unit unit = initialValueDataType.getUnit();
		ComponentSignature signature = new ComponentSignature();

		NumericalType outputDataType;
		if (initialValueDataType instanceof RealType || finalValueDataType instanceof RealType) {
			outputDataType = TypeSystemFactory.eINSTANCE.createRealType();
		} else {
			outputDataType = TypeSystemFactory.eINSTANCE.createIntegerType();
		}
		outputDataType.setUnit((Unit) EcoreUtil.copy(unit));
		signature.getOutputDataTypes().put(block.getFirstOutputPort(), outputDataType);
		
		return new ComponentSignatureEvaluationResult(signature);
	}

}
