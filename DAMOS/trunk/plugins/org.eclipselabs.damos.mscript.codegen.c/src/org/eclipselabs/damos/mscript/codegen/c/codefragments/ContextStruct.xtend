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

package org.eclipselabs.damos.mscript.codegen.c.codefragments

import java.util.ArrayList
import java.util.Collection
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentContext
import org.eclipselabs.damos.mscript.codegen.c.IGlobalNameProvider
import org.eclipselabs.damos.mscript.codegen.c.Include
import org.eclipselabs.damos.mscript.interpreter.StaticFunctionInfo
import java.util.List
import org.eclipselabs.damos.mscript.codegen.c.codefragments.IContextStructMember

import static org.eclipselabs.damos.mscript.codegen.c.ICodeFragment.*

/**
 * @author Andreas Unger
 *
 */
class ContextStruct extends AbstractCodeFragment {

	val Collection<IContextStructMember> members = new ArrayList<IContextStructMember>()
	val Collection<Include> forwardDeclarationIncludes = new ArrayList<Include>()
	
	val StaticFunctionInfo functionInfo
	val boolean singleton
	
	val List<CharSequence> initializeCalls = new ArrayList()
	val List<CharSequence> updateCalls = new ArrayList()

	IGlobalNameProvider globalNameProvider
	
	String name
	
	new(boolean singleton) {
		this.functionInfo = null
		this.singleton = singleton
	}

	new(StaticFunctionInfo functionInfo, boolean singleton) {
		this.functionInfo = functionInfo
		this.singleton = singleton
	}
	
	new(StaticFunctionInfo functionInfo, String name, boolean singleton) {
		this.functionInfo = functionInfo
		this.singleton = singleton
		this.name = name
	}

	def void addInitializeCall(CharSequence initializeCall) {
		initializeCalls.add(initializeCall)
	}
	
	def Collection<CharSequence> getInitializeCalls() {
		initializeCalls
	}

	def void addUpdateCall(CharSequence updateCall) {
		updateCalls.add(updateCall)
	}
	
	def Collection<CharSequence> getUpdateCalls() {
		updateCalls
	}
	
	def String getName() {
		name
	}
	
	override void initialize(ICodeFragmentContext context, IProgressMonitor monitor) {
		addDependency(FORWARD_DECLARATION_DEPENDS_ON, [it instanceof UnionTypeDeclaration])
		
		globalNameProvider = context.globalNameProvider
		if (name == null) {
			val preferredName = if (functionInfo != null) {
				functionInfo.functionDescription.declaration.name + "_Context"
			} else {
				"Context"
			}
			name = globalNameProvider.newGlobalName(preferredName)
		}
	}
	
	override contributesInternalForwardDeclaration() {
		return !singleton || !members.empty
	}

	override Collection<Include> getForwardDeclarationIncludes() {
		return forwardDeclarationIncludes
	}
	
	override CharSequence generateForwardDeclaration(boolean internal) '''
		typedef struct {
			«IF members.empty»
				char dummy;
			«ELSE»
				«FOR part : members»
					«part.generate()»
				«ENDFOR»
			«ENDIF»
		} «name»;
	'''

	def newUniqueName(String preferredName) {
		globalNameProvider.newGlobalName(preferredName)
	}
	
	def addMember(IContextStructMember member) {
		for (declarationCodeFragment : member.getDeclarationCodeFragments) {
			addDependency(FORWARD_DECLARATION_DEPENDS_ON, [it == declarationCodeFragment])
		}
		forwardDeclarationIncludes += member.getForwardDeclarationIncludes
		members += member
	}

	override hashCode() {
		var hashCode = ^class.hashCode
		if (functionInfo != null) {
			hashCode = hashCode.bitwiseXor(functionInfo.hashCode)
		}
		hashCode
	}

	override equals(Object obj) {
		if (obj instanceof ContextStruct) {
			val other = obj as ContextStruct
			return other.functionInfo == functionInfo
		}
		return false
	}
	
}
