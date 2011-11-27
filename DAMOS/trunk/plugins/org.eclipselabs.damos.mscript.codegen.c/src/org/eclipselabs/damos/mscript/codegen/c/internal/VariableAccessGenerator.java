package org.eclipselabs.damos.mscript.codegen.c.internal;

import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.damos.mscript.IntegerType;
import org.eclipselabs.damos.mscript.RealType;
import org.eclipselabs.damos.mscript.VariableAccess;
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipselabs.damos.mscript.codegen.c.util.MscriptGeneratorUtil;
import org.eclipselabs.damos.mscript.il.StatefulVariableDeclaration;
import org.eclipselabs.damos.mscript.il.TemplateVariableDeclaration;
import org.eclipselabs.damos.mscript.il.util.ILSwitch;
import org.eclipselabs.damos.mscript.interpreter.value.IBooleanValue;
import org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;

public class VariableAccessGenerator extends ILSwitch<String> {

	private IMscriptGeneratorContext context;
	private VariableAccess variableAccess;
	
	public VariableAccessGenerator(IMscriptGeneratorContext context, VariableAccess variableAccess) {
		this.context = context;
		this.variableAccess = variableAccess;
	}

	public String generate() {
		return doSwitch(variableAccess.getFeature());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#caseTemplateVariableDeclaration(org.eclipselabs.mscript.language.il.TemplateVariableDeclaration)
	 */
	@Override
	public String caseTemplateVariableDeclaration(TemplateVariableDeclaration templateVariableDeclaration) {
		IValue templateArgument = context.getStaticEvaluationContext().getValue(templateVariableDeclaration);
		return writeLiteral(templateArgument);
	}
	
	private String writeLiteral(IValue value) {
		if (value instanceof ISimpleNumericValue) {
			ISimpleNumericValue numericTemplateArgument = (ISimpleNumericValue) value;
			if (value.getDataType() instanceof RealType) {
				return MscriptGeneratorUtil.getLiteralString(context.getComputationModel(), numericTemplateArgument.getDataType(), numericTemplateArgument.doubleValue());
			} else if (value.getDataType() instanceof IntegerType) {
				return MscriptGeneratorUtil.getLiteralString(context.getComputationModel(), numericTemplateArgument.getDataType(), numericTemplateArgument.longValue());
			}
		} else if (value instanceof IBooleanValue) {
			IBooleanValue booleanTemplateArgument = (IBooleanValue) value;
			return booleanTemplateArgument.booleanValue() ? "1" : "0";
		}
		throw new IllegalArgumentException();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#caseStatefulVariableDeclaration(org.eclipselabs.mscript.language.il.StatefulVariableDeclaration)
	 */
	@Override
	public String caseStatefulVariableDeclaration(StatefulVariableDeclaration statefulVariableDeclaration) {
		return context.getVariableAccessStrategy().getVariableAccessString(variableAccess);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.il.util.ILSwitch#defaultCase(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public String defaultCase(EObject object) {
		if (object instanceof VariableDeclaration) {
			return ((VariableDeclaration) object).getName();
		}
		return super.defaultCase(object);
	}
	
}
