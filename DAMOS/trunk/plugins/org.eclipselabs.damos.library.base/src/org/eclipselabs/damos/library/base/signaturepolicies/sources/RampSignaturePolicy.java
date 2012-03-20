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

package org.eclipselabs.damos.library.base.signaturepolicies.sources;

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
import org.eclipselabs.damos.library.base.util.sources.RampConstants;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.NumericType;
import org.eclipselabs.damos.mscript.OperatorKind;
import org.eclipselabs.damos.mscript.Unit;
import org.eclipselabs.damos.mscript.UnitSymbol;
import org.eclipselabs.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 *
 */
public class RampSignaturePolicy extends AbstractComponentSignaturePolicy {
	
	@Override
	public IComponentSignatureEvaluationResult evaluateSignature(Component component, Map<InputPort, DataType> incomingDataTypes) {
		Block block = (Block) component;
		
		MultiStatus status = new MultiStatus(LibraryBasePlugin.PLUGIN_ID, 0, "", null);
		
		NumericType initialValueDataType = null;
		try {
			initialValueDataType = ExpressionUtil.evaluateSimpleNumericArgument(block, RampConstants.PARAMETER__INITIAL_VALUE).getDataType();
		} catch (CoreException e) {
			status.add(e.getStatus());
		}
		
		NumericType startTimeDataType = null;
		try {
			startTimeDataType = ExpressionUtil.evaluateSimpleNumericArgument(block, RampConstants.PARAMETER__START_TIME).getDataType();
		} catch (CoreException e) {
			status.add(e.getStatus());
		}

		NumericType slopeDataType = null;
		try {
			slopeDataType = ExpressionUtil.evaluateSimpleNumericArgument(block, RampConstants.PARAMETER__SLOPE).getDataType();
		} catch (CoreException e) {
			status.add(e.getStatus());
		}
		
		if (initialValueDataType == null || startTimeDataType == null || slopeDataType == null) {
			return new ComponentSignatureEvaluationResult(status);
		}

		if (!startTimeDataType.getUnit().isEquivalentTo(TypeUtil.createUnit(UnitSymbol.SECOND), true)) {
			status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Start Time unit must be second"));
		}

		if (!slopeDataType.getUnit().isEquivalentTo(initialValueDataType.getUnit().evaluate(OperatorKind.DIVIDE, TypeUtil.createUnit(UnitSymbol.SECOND)), true)) {
			status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Slope unit must be Initial Value unit divided by seconds"));
		}

		if (status.getSeverity() > IStatus.WARNING) {
			return new ComponentSignatureEvaluationResult(status);
		}
		
		Unit unit = initialValueDataType.getUnit();
		ComponentSignature signature = new ComponentSignature(incomingDataTypes);

		NumericType outputDataType;
		outputDataType = MscriptFactory.eINSTANCE.createRealType();
		outputDataType.setUnit(EcoreUtil.copy(unit));
		signature.getOutputDataTypes().put(component.getFirstOutputPort(), outputDataType);
		
		return new ComponentSignatureEvaluationResult(signature, status);
	}

}
