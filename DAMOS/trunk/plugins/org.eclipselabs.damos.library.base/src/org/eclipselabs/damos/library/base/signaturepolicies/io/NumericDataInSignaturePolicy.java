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

package org.eclipselabs.damos.library.base.signaturepolicies.io;

import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.execution.AbstractComponentSignaturePolicy;
import org.eclipselabs.damos.execution.ComponentSignature;
import org.eclipselabs.damos.execution.ComponentSignatureEvaluationResult;
import org.eclipselabs.damos.execution.IComponentSignatureEvaluationResult;
import org.eclipselabs.damos.execution.util.ExpressionUtil;
import org.eclipselabs.damos.library.base.LibraryBasePlugin;
import org.eclipselabs.damos.library.base.util.io.NumericDataInConstants;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.IntegerType;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.NumericType;
import org.eclipselabs.damos.mscript.Unit;
import org.eclipselabs.damos.mscript.interpreter.value.IBooleanValue;

/**
 * @author Andreas Unger
 *
 */
public class NumericDataInSignaturePolicy extends AbstractComponentSignaturePolicy {
	
	@Override
	public IComponentSignatureEvaluationResult evaluateSignature(Component component, Map<InputPort, DataType> incomingDataTypes) {
		Block block = (Block) component;
		
		MultiStatus status = new MultiStatus(LibraryBasePlugin.PLUGIN_ID, 0, "", null);
		
		NumericType minimumValueDataType = null;
		try {
			minimumValueDataType = ExpressionUtil.evaluateSimpleNumericArgument(block, NumericDataInConstants.PARAMETER__MINIMUM_VALUE).getDataType();
		} catch (CoreException e) {
			status.add(e.getStatus());
		}
		
		NumericType maximumValueDataType = null;
		try {
			maximumValueDataType = ExpressionUtil.evaluateSimpleNumericArgument(block, NumericDataInConstants.PARAMETER__MAXIMUM_VALUE).getDataType();
		} catch (CoreException e) {
			status.add(e.getStatus());
		}
		
		IBooleanValue integer = null;
		try {
			integer = ExpressionUtil.evaluateBooleanArgument(block, NumericDataInConstants.PARAMETER__INTEGER);
		} catch (CoreException e) {
			status.add(e.getStatus());
		}

		if (minimumValueDataType == null || maximumValueDataType == null || integer == null) {
			return new ComponentSignatureEvaluationResult(status);
		}
		
		if (integer.booleanValue()) {
			if (!(minimumValueDataType instanceof IntegerType)) {
				status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Minimum Value must be integer value"));
			}
			if (!(maximumValueDataType instanceof IntegerType)) {
				status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Maximum Value must be integer value"));
			}
		}
		
		if (!minimumValueDataType.getUnit().isEquivalentTo(maximumValueDataType.getUnit(), false)) {
			status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Minimum Value and Maximum Value must have same unit"));
		}
		
		if (status.getSeverity() > IStatus.WARNING) {
			return new ComponentSignatureEvaluationResult(status);
		}
		
		Unit unit = minimumValueDataType.getUnit();
		ComponentSignature signature = new ComponentSignature(incomingDataTypes);

		NumericType outputDataType;
		if (integer.booleanValue()) {
			outputDataType = MscriptFactory.eINSTANCE.createIntegerType();
		} else {
			outputDataType = MscriptFactory.eINSTANCE.createRealType();
		}
		outputDataType.setUnit(EcoreUtil.copy(unit));
		signature.getOutputDataTypes().put(component.getFirstOutputPort(), outputDataType);
		
		return new ComponentSignatureEvaluationResult(signature, status);
	}

}
