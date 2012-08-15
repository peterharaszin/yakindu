package org.eclipselabs.damos.mscript.codegen.c.internal;

import org.eclipselabs.damos.mscript.ConstantDeclaration;
import org.eclipselabs.damos.mscript.FeatureReference;
import org.eclipselabs.damos.mscript.InspectWhenClause;
import org.eclipselabs.damos.mscript.ParameterDeclaration;
import org.eclipselabs.damos.mscript.StateVariableDeclaration;
import org.eclipselabs.damos.mscript.StaticParameterDeclaration;
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.codegen.c.IExpressionGenerator;
import org.eclipselabs.damos.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipselabs.damos.mscript.codegen.c.LiteralGenerator;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.util.MscriptSwitch;

import com.google.inject.Inject;

public class VariableReferenceGenerator {

	private final LiteralGenerator literalGenerator;
	private final IExpressionGenerator expressionGenerator;
	
	@Inject
	public VariableReferenceGenerator(IExpressionGenerator expressionGenerator, LiteralGenerator literalGenerator) {
		this.expressionGenerator = expressionGenerator;
		this.literalGenerator = literalGenerator;
	}

	public CharSequence generate(IMscriptGeneratorContext context, FeatureReference variableReference) {
		return new VariableAccessGeneratorSwitch(context, variableReference).doSwitch(variableReference.getFeature());
	}
	
	private class VariableAccessGeneratorSwitch extends MscriptSwitch<CharSequence> {
	
		private final IMscriptGeneratorContext context;
		private final FeatureReference variableReference;
		
		/**
		 * 
		 */
		public VariableAccessGeneratorSwitch(IMscriptGeneratorContext context, FeatureReference variableReference) {
			this.context = context;
			this.variableReference = variableReference;
		}
		
		@Override
		public CharSequence caseStaticParameterDeclaration(StaticParameterDeclaration staticParameterDeclaration) {
			IValue staticArgument = context.getStaticEvaluationResult().getValue(staticParameterDeclaration);
			return literalGenerator.generateLiteral(context.getConfiguration(), context.getCodeFragmentCollector(), staticArgument);
		}
			
		@Override
		public CharSequence caseConstantDeclaration(ConstantDeclaration constantDeclaration) {
			IValue constantValue = context.getStaticEvaluationResult().getValue(constantDeclaration);
			return literalGenerator.generateLiteral(context.getConfiguration(), context.getCodeFragmentCollector(), constantValue);
		}

		@Override
		public CharSequence caseParameterDeclaration(ParameterDeclaration parameterDeclaration) {
			return context.getVariableAccessStrategy().generateVariableReference(variableReference);
		}
		
		@Override
		public CharSequence caseStateVariableDeclaration(StateVariableDeclaration stateVariableDeclaration) {
			return context.getVariableAccessStrategy().generateVariableReference(variableReference);
		}
		
		@Override
		public CharSequence caseInspectWhenClause(InspectWhenClause inspectWhenClause) {
			return expressionGenerator.generate(context, inspectWhenClause.getOwner().getUnionExpression()) + ".value." + inspectWhenClause.getName();
		}
		
		@Override
		public CharSequence caseVariableDeclaration(VariableDeclaration variableDeclaration) {
			return variableDeclaration.getName();
		}
	
	}

}
