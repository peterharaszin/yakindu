package org.eclipselabs.damos.mscript.codegen.c.internal;

import org.eclipselabs.damos.mscript.CallableElement;
import org.eclipselabs.damos.mscript.ConstantDeclaration;
import org.eclipselabs.damos.mscript.FeatureReference;
import org.eclipselabs.damos.mscript.ImplicitVariableDeclaration;
import org.eclipselabs.damos.mscript.InputParameterDeclaration;
import org.eclipselabs.damos.mscript.InspectWhenClause;
import org.eclipselabs.damos.mscript.ParameterDeclaration;
import org.eclipselabs.damos.mscript.StateVariableDeclaration;
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.codegen.c.IExpressionGenerator;
import org.eclipselabs.damos.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipselabs.damos.mscript.codegen.c.LiteralGenerator;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;

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
		CallableElement feature = variableReference.getFeature();
		if (feature instanceof InputParameterDeclaration) {
			InputParameterDeclaration inputParameterDeclaration = (InputParameterDeclaration) feature;
			if (inputParameterDeclaration.isConstant()) {
				IValue staticArgument = context.getFunctionInfo().getValue(inputParameterDeclaration);
				return literalGenerator.generateLiteral(context.getConfiguration(), context.getCodeFragmentCollector(), staticArgument);
			}
			// Fall-through
		}
		if (feature instanceof ParameterDeclaration || feature instanceof StateVariableDeclaration || feature instanceof ImplicitVariableDeclaration) {
			return context.getVariableAccessStrategy().generateVariableReference(variableReference);
		}
		if (feature instanceof ConstantDeclaration) {
			IValue constantValue = context.getFunctionInfo().getValue(feature);
			return literalGenerator.generateLiteral(context.getConfiguration(), context.getCodeFragmentCollector(), constantValue);
		}
		if (feature instanceof InspectWhenClause) {
			InspectWhenClause inspectWhenClause = (InspectWhenClause) feature;
			return expressionGenerator.generate(context, inspectWhenClause.getOwner().getUnionExpression()) + ".value." + inspectWhenClause.getName();
		}
		if (feature instanceof VariableDeclaration) {
			return feature.getName();
		}
		throw new IllegalArgumentException("Unknown variable declaration " + feature.getClass().getCanonicalName());
	}
	
}
