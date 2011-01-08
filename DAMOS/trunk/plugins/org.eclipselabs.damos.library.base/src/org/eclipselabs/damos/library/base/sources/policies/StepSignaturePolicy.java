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
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.execution.engine.ComponentSignature;
import org.eclipselabs.damos.execution.engine.ComponentSignatureEvaluationResult;
import org.eclipselabs.damos.execution.engine.IComponentSignatureEvaluationResult;
import org.eclipselabs.damos.execution.engine.IComponentSignaturePolicy;
import org.eclipselabs.damos.execution.engine.util.ExpressionUtil;
import org.eclipselabs.damos.library.base.LibraryBasePlugin;
import org.eclipselabs.damos.library.base.sources.util.StepConstants;
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
public class StepSignaturePolicy implements IComponentSignaturePolicy {
	
	public IComponentSignatureEvaluationResult evaluateSignature(Component component, Map<InputPort, DataType> incomingDataTypes) {
		Block block = (Block) component;
		
		MultiStatus status = new MultiStatus(LibraryBasePlugin.PLUGIN_ID, 0, "", null);
		
		NumericType initialValueDataType = null;
		try {
			initialValueDataType = ExpressionUtil.evaluateSimpleNumericArgument(block, StepConstants.PARAMETER__INITIAL_VALUE).getDataType();
		} catch (CoreException e) {
			status.add(e.getStatus());
		}
		
		NumericType finalValueDataType = null;
		try {
			finalValueDataType = ExpressionUtil.evaluateSimpleNumericArgument(block, StepConstants.PARAMETER__FINAL_VALUE).getDataType();
		} catch (CoreException e) {
			status.add(e.getStatus());
		}
		
		NumericType stepTimeDataType = null;
		try {
			stepTimeDataType = ExpressionUtil.evaluateSimpleNumericArgument(block, StepConstants.PARAMETER__STEP_TIME).getDataType();
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

		NumericType outputDataType;
		if (initialValueDataType instanceof RealType || finalValueDataType instanceof RealType) {
			outputDataType = TypeSystemFactory.eINSTANCE.createRealType();
		} else {
			outputDataType = TypeSystemFactory.eINSTANCE.createIntegerType();
		}
		outputDataType.setUnit(EcoreUtil.copy(unit));
		signature.getOutputDataTypes().put(component.getFirstOutputPort(), outputDataType);
		
		return new ComponentSignatureEvaluationResult(signature);
	}

}
