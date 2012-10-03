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

package org.eclipse.damos.library.base.signaturepolicies;

import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.damos.dml.Block;
import org.eclipse.damos.dml.Component;
import org.eclipse.damos.dml.InputPort;
import org.eclipse.damos.execution.datatype.AbstractComponentSignaturePolicy;
import org.eclipse.damos.execution.datatype.ComponentSignature;
import org.eclipse.damos.execution.datatype.ComponentSignatureEvaluationResult;
import org.eclipse.damos.execution.datatype.IComponentSignatureEvaluationResult;
import org.eclipse.damos.execution.util.ExpressionUtil;
import org.eclipse.damos.library.base.LibraryBasePlugin;
import org.eclipse.damos.library.base.util.NumericDataInConstants;
import org.eclipse.damos.mscript.IntegerType;
import org.eclipse.damos.mscript.MscriptFactory;
import org.eclipse.damos.mscript.NumericType;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.Unit;
import org.eclipse.damos.mscript.interpreter.value.IBooleanValue;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * @author Andreas Unger
 *
 */
public class NumericDataInSignaturePolicy extends AbstractComponentSignaturePolicy {
	
	@Override
	public IComponentSignatureEvaluationResult evaluateSignature(Component component, Map<InputPort, Type> incomingDataTypes) {
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
