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

package org.eclipselabs.damos.codegen.c.codefragments

import com.google.inject.Inject
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipselabs.damos.codegen.c.IGeneratorContext
import org.eclipselabs.damos.codegen.c.codefragments.factories.IContextStructFactory

import static org.eclipselabs.damos.mscript.codegen.c.ICodeFragment.*

import static extension org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationExtensions.*

/**
 * @author Andreas Unger
 *
 */
class ContextVariable extends PrimaryCodeFragment {
	
	val IContextStructFactory contextStructFactory
	
	boolean unused
	
	String prefix
	
	@Inject
	new(IContextStructFactory contextStructFactory) {
		this.contextStructFactory = contextStructFactory
	}
	
	override void doInitialize(IGeneratorContext context, IProgressMonitor monitor) {
		addDependency(FORWARD_DECLARATION_DEPENDS_ON, [it instanceof ContextStruct])
		
		val contextStruct = context.addCodeFragment(contextStructFactory.create(), monitor) as ContextStruct
		
		unused = contextStruct.unused
		prefix = context.configuration.prefix
	}
	
	override boolean contributesInternalForwardDeclaration() {
		return false
	}
	
	override CharSequence generateForwardDeclaration(boolean internal) '''
		extern «generateImplementation(false)»
	'''

	override boolean contributesImplementation() {
		return !unused
	}
	
	override CharSequence generateImplementation(boolean internal) '''
		«IF internal»static «ENDIF»«prefix»Context «prefix»context;
	'''

}
