/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.mscript.codegen.c.internal;

import org.eclipse.damos.mscript.FeatureReference;
import org.eclipse.damos.mscript.ImplicitVariableDeclaration;
import org.eclipse.damos.mscript.InputParameterDeclaration;
import org.eclipse.damos.mscript.OutputParameterDeclaration;
import org.eclipse.damos.mscript.RealType;
import org.eclipse.damos.mscript.StateVariableDeclaration;
import org.eclipse.damos.mscript.VariableDeclaration;
import org.eclipse.damos.mscript.codegen.c.IMscriptGeneratorConfiguration;
import org.eclipse.damos.mscript.codegen.c.IVariableAccessStrategy;
import org.eclipse.damos.mscript.codegen.c.LiteralGenerator;
import org.eclipse.damos.mscript.interpreter.StaticFunctionInfo;
import org.eclipse.damos.mscript.util.ISampleInterval;
import org.eclipse.damos.mscript.util.MscriptSwitch;
import org.eclipse.damos.mscript.util.SampleRate;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class DefaultVariableAccessStrategy implements IVariableAccessStrategy {

	@Inject
	private LiteralGenerator literalGenerator;

	private final IMscriptGeneratorConfiguration configuration;
	private final StaticFunctionInfo functionInfo;
	private final ISampleInterval sampleInterval;
	
	/**
	 * 
	 */
	public DefaultVariableAccessStrategy(IMscriptGeneratorConfiguration configuration, StaticFunctionInfo functionInfo, ISampleInterval sampleInterval) {
		this.configuration = configuration;
		this.functionInfo = functionInfo;
		this.sampleInterval = sampleInterval;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.codegen.c.IVariableAccessStrategy#generateContextMemberAccess(boolean, java.lang.String)
	 */
	public CharSequence generateContextMemberAccess(boolean pointer, String memberName) {
		StringBuilder sb = new StringBuilder();
		if (pointer) {
			sb.append("&");
		}
		return sb.append("context->").append(memberName);
	}
	
	public CharSequence generateVariableReference(FeatureReference variableReference) {
		return new VariableAccessSwitch(variableReference).doSwitch(variableReference.getFeature());
	}

	public class VariableAccessSwitch extends MscriptSwitch<CharSequence> {

		private FeatureReference variableReference;
		
		public VariableAccessSwitch(FeatureReference variableReference) {
			this.variableReference = variableReference;
		}
		
		@Override
		public CharSequence caseImplicitVariableDeclaration(ImplicitVariableDeclaration implicitVariableDeclaration) {
			RealType dataType = (RealType) functionInfo.getValue(implicitVariableDeclaration).getDataType();
			double value;
			if ("Ts".equals(implicitVariableDeclaration.getName())) {
				value = sampleInterval.sampleTime();
			} else if ("fs".equals(implicitVariableDeclaration.getName())) {
				if (sampleInterval instanceof SampleRate) {
					return literalGenerator.generateLiteral(configuration.getComputationModel(), dataType, ((SampleRate) sampleInterval).longValue());
				}
				value = 1.0 / sampleInterval.sampleTime();
			} else {
				value = 0.0;
			}
			return literalGenerator.generateLiteral(configuration.getComputationModel(), dataType, value);
		}

		@Override
		public CharSequence caseInputParameterDeclaration(InputParameterDeclaration inputParameterDeclaration) {
			int stepIndex = functionInfo.getStepIndex(variableReference);
			if (stepIndex == 0) {
				return inputParameterDeclaration.getName();
			}
			return getContextAccess();
		}
		
		@Override
		public CharSequence caseOutputParameterDeclaration(OutputParameterDeclaration outputParameterDeclaration) {
			int stepIndex = functionInfo.getStepIndex(variableReference);
			if (stepIndex == 0) {
				return outputParameterDeclaration.getName();
			}
			return getContextAccess();
		}
		
		@Override
		public CharSequence caseStateVariableDeclaration(StateVariableDeclaration stateVariableDeclaration) {
			return getContextAccess();
		}
		
		private CharSequence getContextAccess() {
			VariableDeclaration target = (VariableDeclaration) variableReference.getFeature();
			int stepIndex = functionInfo.getStepIndex(variableReference);

			String name = target.getName();
			int circularBufferSize = functionInfo.getCircularBufferSize(target);
			if (circularBufferSize > 1) {
				if (stepIndex < 0) {
					stepIndex = (stepIndex + circularBufferSize) % circularBufferSize;
				}
				if (stepIndex == 0) {
					return String.format("context->%s[context->%s_index]", name, name, stepIndex, circularBufferSize);
				}
				return String.format("context->%s[(context->%s_index + %d) %% %d]", name, name, stepIndex,
						circularBufferSize);
			}
			return String.format("context->%s", name);
		}
		
	}

}
