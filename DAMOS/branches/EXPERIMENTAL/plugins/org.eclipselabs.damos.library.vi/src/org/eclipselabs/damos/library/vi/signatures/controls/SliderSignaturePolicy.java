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

package org.eclipselabs.damos.library.vi.signatures.controls;

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
import org.eclipselabs.damos.library.vi.LibraryVIPlugin;
import org.eclipselabs.damos.library.vi.util.controls.SliderConstants;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.NumericType;
import org.eclipselabs.damos.mscript.Unit;

/**
 * @author Andreas Unger
 *
 */
public class SliderSignaturePolicy extends AbstractComponentSignaturePolicy {
	
	@Override
	public IComponentSignatureEvaluationResult evaluateSignature(Component component, Map<InputPort, Type> incomingDataTypes) {
		Block block = (Block) component;
		
		MultiStatus status = new MultiStatus(LibraryVIPlugin.PLUGIN_ID, 0, "", null);
		
		NumericType minimumValueDataType = null;
		try {
			minimumValueDataType = ExpressionUtil.evaluateSimpleNumericArgument(block, SliderConstants.PARAMETER__MINIMUM_VALUE).getDataType();
		} catch (CoreException e) {
			status.add(e.getStatus());
		}
		
		NumericType maximumValueDataType = null;
		try {
			maximumValueDataType = ExpressionUtil.evaluateSimpleNumericArgument(block, SliderConstants.PARAMETER__MAXIMUM_VALUE).getDataType();
		} catch (CoreException e) {
			status.add(e.getStatus());
		}
		
		if (minimumValueDataType == null || maximumValueDataType == null) {
			return new ComponentSignatureEvaluationResult(status);
		}

		if (!minimumValueDataType.getUnit().isEquivalentTo(maximumValueDataType.getUnit(), false)) {
			status.add(new Status(IStatus.ERROR, LibraryVIPlugin.PLUGIN_ID, "Minimum Value and Maximum Value must have same unit"));
		}
		
		if (status.getSeverity() > IStatus.WARNING) {
			return new ComponentSignatureEvaluationResult(status);
		}
		
		Unit unit = minimumValueDataType.getUnit();
		ComponentSignature signature = new ComponentSignature(incomingDataTypes);

		NumericType outputDataType;
		outputDataType = MscriptFactory.eINSTANCE.createRealType();
		outputDataType.setUnit(EcoreUtil.copy(unit));
		signature.getOutputDataTypes().put(component.getFirstOutputPort(), outputDataType);
		
		return new ComponentSignatureEvaluationResult(signature, status);
	}

}
