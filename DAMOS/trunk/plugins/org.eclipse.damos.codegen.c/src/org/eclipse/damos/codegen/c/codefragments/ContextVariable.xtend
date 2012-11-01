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

package org.eclipse.damos.codegen.c.codefragments

import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.damos.codegen.c.IGeneratorContext
import org.eclipse.damos.mscript.codegen.c.codefragments.ContextStruct

import static org.eclipse.damos.mscript.codegen.c.ICodeFragment.*

import static extension org.eclipse.damos.codegen.c.util.GeneratorConfigurationExtensions.*
import org.eclipse.damos.mscript.codegen.c.codefragments.factories.IContextStructFactory
import com.google.inject.Inject

/**
 * @author Andreas Unger
 *
 */
class ContextVariable extends PrimaryCodeFragment {
	
	@Inject
	IContextStructFactory contextStructFactory
	
	ContextStruct contextStruct
	
	String prefix
	
	override void doInitialize(IGeneratorContext context, IProgressMonitor monitor) {
		addDependency(FORWARD_DECLARATION_DEPENDS_ON, [it instanceof ContextStruct])
		
		contextStruct = context.addCodeFragment(contextStructFactory.create(null, null, context.configuration.singleton), monitor) as ContextStruct
		
		prefix = context.configuration.prefix
	}
	
	override boolean contributesInternalForwardDeclaration() {
		return false
	}
	
	override CharSequence generateForwardDeclaration(boolean internal) '''
		extern «generateImplementation(false)»
	'''

	override boolean contributesImplementation() {
		return contextStruct.contributesInternalForwardDeclaration
	}
	
	override CharSequence generateImplementation(boolean internal) '''
		«IF internal»static «ENDIF»«prefix»Context «prefix»context;
	'''

}
