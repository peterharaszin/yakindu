package org.eclipselabs.damos.mscript.codegen.c.internal;

import org.eclipselabs.damos.mscript.ParameterDeclaration;
import org.eclipselabs.damos.mscript.StateVariableDeclaration;
import org.eclipselabs.damos.mscript.TemplateParameterDeclaration;
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.VariableReference;
import org.eclipselabs.damos.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipselabs.damos.mscript.codegen.c.util.MscriptGeneratorUtil;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.util.MscriptSwitch;

public class VariableAccessGenerator extends MscriptSwitch<String> {

	private IMscriptGeneratorContext context;
	private VariableReference variableReference;
	
	public VariableAccessGenerator(IMscriptGeneratorContext context, VariableReference variableReference) {
		this.context = context;
		this.variableReference = variableReference;
	}

	public String generate() {
		return doSwitch(variableReference.getFeature());
	}
	
	@Override
	public String caseTemplateParameterDeclaration(TemplateParameterDeclaration templateParameterDeclaration) {
		IValue templateArgument = context.getStaticEvaluationContext().getValue(templateParameterDeclaration);
		return MscriptGeneratorUtil.getLiteralString(context, templateArgument);
	}
		
	@Override
	public String caseParameterDeclaration(ParameterDeclaration parameterDeclaration) {
		return context.getVariableAccessStrategy().getVariableAccessString(variableReference);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.util.MscriptSwitch#caseStateVariableDeclaration(org.eclipselabs.damos.mscript.StateVariableDeclaration)
	 */
	@Override
	public String caseStateVariableDeclaration(StateVariableDeclaration stateVariableDeclaration) {
		return context.getVariableAccessStrategy().getVariableAccessString(variableReference);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.util.MscriptSwitch#caseVariableDeclaration(org.eclipselabs.damos.mscript.VariableDeclaration)
	 */
	@Override
	public String caseVariableDeclaration(VariableDeclaration variableDeclaration) {
		return variableDeclaration.getName();
	}

}
