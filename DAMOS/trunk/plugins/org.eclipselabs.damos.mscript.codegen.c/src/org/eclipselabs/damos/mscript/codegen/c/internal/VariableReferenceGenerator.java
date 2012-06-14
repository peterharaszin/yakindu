package org.eclipselabs.damos.mscript.codegen.c.internal;

import org.eclipselabs.damos.mscript.ParameterDeclaration;
import org.eclipselabs.damos.mscript.StateVariableDeclaration;
import org.eclipselabs.damos.mscript.TemplateParameterDeclaration;
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.VariableReference;
import org.eclipselabs.damos.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipselabs.damos.mscript.codegen.c.LiteralGenerator;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.util.MscriptSwitch;

import com.google.inject.Inject;

public class VariableReferenceGenerator {

	private final LiteralGenerator literalGenerator;
	
	@Inject
	public VariableReferenceGenerator(LiteralGenerator literalGenerator) {
		this.literalGenerator = literalGenerator;
	}

	public CharSequence generate(IMscriptGeneratorContext context, VariableReference variableReference) {
		return new VariableAccessGeneratorSwitch(context, variableReference).doSwitch(variableReference.getFeature());
	}
	
	private class VariableAccessGeneratorSwitch extends MscriptSwitch<CharSequence> {
	
		private final IMscriptGeneratorContext context;
		private final VariableReference variableReference;
		
		/**
		 * 
		 */
		public VariableAccessGeneratorSwitch(IMscriptGeneratorContext context, VariableReference variableReference) {
			this.context = context;
			this.variableReference = variableReference;
		}
		
		@Override
		public CharSequence caseTemplateParameterDeclaration(TemplateParameterDeclaration templateParameterDeclaration) {
			IValue templateArgument = context.getStaticEvaluationContext().getValue(templateParameterDeclaration);
			return literalGenerator.generateLiteral(context.getComputationModel(), context.getCodeFragmentCollector(), templateArgument);
		}
			
		@Override
		public CharSequence caseParameterDeclaration(ParameterDeclaration parameterDeclaration) {
			return context.getVariableAccessStrategy().generateVariableReference(variableReference);
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.mscript.util.MscriptSwitch#caseStateVariableDeclaration(org.eclipselabs.damos.mscript.StateVariableDeclaration)
		 */
		@Override
		public CharSequence caseStateVariableDeclaration(StateVariableDeclaration stateVariableDeclaration) {
			return context.getVariableAccessStrategy().generateVariableReference(variableReference);
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.mscript.util.MscriptSwitch#caseVariableDeclaration(org.eclipselabs.damos.mscript.VariableDeclaration)
		 */
		@Override
		public CharSequence caseVariableDeclaration(VariableDeclaration variableDeclaration) {
			return variableDeclaration.getName();
		}
	
	}

}
