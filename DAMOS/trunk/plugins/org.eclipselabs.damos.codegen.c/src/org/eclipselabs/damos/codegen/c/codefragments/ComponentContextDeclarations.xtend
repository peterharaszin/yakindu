package org.eclipselabs.damos.codegen.c.codefragments

import org.eclipse.core.runtime.IProgressMonitor
import org.eclipselabs.damos.codegen.c.IGeneratorContext

class ComponentContextDeclarations extends PrimaryCodeFragment {

	val CharSequence content
	
	new(CharSequence content) {
		this.content = content
	}
		
	override protected doInitialize(IGeneratorContext context, IProgressMonitor monitor) {
	}
	
	override generateForwardDeclaration(boolean internal) {
		content
	}
	
}