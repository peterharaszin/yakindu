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
import org.eclipselabs.damos.execution.AbstractComponentSignaturePolicy;
import org.eclipselabs.damos.execution.ComponentSignature;
import org.eclipselabs.damos.execution.ComponentSignatureEvaluationResult;
import org.eclipselabs.damos.execution.IComponentSignatureEvaluationResult;
import org.eclipselabs.damos.execution.util.ExpressionUtil;
import org.eclipselabs.damos.library.base.LibraryBasePlugin;
import org.eclipselabs.damos.library.base.util.sources.SineWaveConstants;
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
public class SineWaveSignaturePolicy extends AbstractComponentSignaturePolicy {
	
	@Override
	public IComponentSignatureEvaluationResult evaluateSignature(Component component, Map<InputPort, DataType> incomingDataTypes) {
		Block block = (Block) component;
		
		MultiStatus status = new MultiStatus(LibraryBasePlugin.PLUGIN_ID, 0, "", null);
		
		NumericType amplitudeDataType = null;
		try {
			amplitudeDataType = ExpressionUtil.evaluateSimpleNumericArgument(block, SineWaveConstants.PARAMETER__AMPLITUDE).getDataType();
		} catch (CoreException e) {
			status.add(e.getStatus());
		}
		
		NumericType biasDataType = null;
		try {
			biasDataType = ExpressionUtil.evaluateSimpleNumericArgument(block, SineWaveConstants.PARAMETER__BIAS).getDataType();
		} catch (CoreException e) {
			status.add(e.getStatus());
		}
		
		NumericType frequencyDataType = null;
		try {
			frequencyDataType = ExpressionUtil.evaluateSimpleNumericArgument(block, SineWaveConstants.PARAMETER__FREQUENCY).getDataType();
		} catch (CoreException e) {
			status.add(e.getStatus());
		}
		
		NumericType phaseDataType = null;
		try {
			phaseDataType = ExpressionUtil.evaluateSimpleNumericArgument(block, SineWaveConstants.PARAMETER__PHASE).getDataType();
		} catch (CoreException e) {
			status.add(e.getStatus());
		}

		if (amplitudeDataType == null || biasDataType == null || frequencyDataType == null || phaseDataType == null) {
			return new ComponentSignatureEvaluationResult(status);
		}

		if (!amplitudeDataType.getUnit().isEquivalentTo(biasDataType.getUnit(), false)) {
			status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Amplitude and Bias must have same unit"));
		}
		
		if (!frequencyDataType.getUnit().isEquivalentTo(TypeUtil.createUnit().evaluate(OperatorKind.DIVIDE, TypeUtil.createUnit(UnitSymbol.SECOND)), true)) {
			status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Frequency unit must be 1/s"));
		}

		if (!phaseDataType.getUnit().isEquivalentTo(TypeUtil.createUnit(), true)) {
			status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Phase unit must be dimensionless"));
		}

		if (status.getSeverity() > IStatus.WARNING) {
			return new ComponentSignatureEvaluationResult(status);
		}
		
		Unit unit = amplitudeDataType.getUnit();
		ComponentSignature signature = new ComponentSignature(incomingDataTypes);

		NumericType outputDataType;
		outputDataType = MscriptFactory.eINSTANCE.createRealType();
		outputDataType.setUnit(EcoreUtil.copy(unit));
		signature.getOutputDataTypes().put(component.getFirstOutputPort(), outputDataType);
		
		return new ComponentSignatureEvaluationResult(signature, status);
	}

}
