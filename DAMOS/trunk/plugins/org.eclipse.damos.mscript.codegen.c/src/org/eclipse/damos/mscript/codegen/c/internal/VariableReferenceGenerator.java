package org.eclipse.damos.mscript.codegen.c.internal;

import org.eclipse.damos.mscript.CallableElement;
import org.eclipse.damos.mscript.ConstantDeclaration;
import org.eclipse.damos.mscript.FeatureReference;
import org.eclipse.damos.mscript.ImplicitVariableDeclaration;
import org.eclipse.damos.mscript.InputParameterDeclaration;
import org.eclipse.damos.mscript.InspectWhenClause;
import org.eclipse.damos.mscript.ParameterDeclaration;
import org.eclipse.damos.mscript.StateVariableDeclaration;
import org.eclipse.damos.mscript.VariableDeclaration;
import org.eclipse.damos.mscript.codegen.c.IExpressionGenerator;
import org.eclipse.damos.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipse.damos.mscript.codegen.c.LiteralGenerator;
import org.eclipse.damos.mscript.interpreter.value.IValue;

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
