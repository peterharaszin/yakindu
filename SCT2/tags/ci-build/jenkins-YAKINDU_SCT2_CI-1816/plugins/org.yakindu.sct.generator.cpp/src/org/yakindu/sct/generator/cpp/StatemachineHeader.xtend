/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.cpp

import com.google.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess
import org.yakindu.base.types.Parameter
import org.yakindu.sct.generator.c.GenmodelEntries
import org.yakindu.sct.generator.c.Statemachine
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.stext.stext.Direction
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.InternalScope
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.sct.model.stext.stext.VariableDefinition

class StatemachineHeader extends Statemachine {
	
	@Inject extension Naming cNaming
	@Inject extension Navigation
	@Inject extension ICodegenTypeSystemAccess
	@Inject extension GenmodelEntries
	
	def generateStatemachineHeader(ExecutionFlow flow, Statechart sc, IFileSystemAccess fsa, GeneratorEntry entry) {
		 fsa.generateFile(flow.module.hpp, flow.statemachineHContent(entry) )
	}
	
	override statemachineHContent(ExecutionFlow it,  GeneratorEntry entry) '''
		«entry.licenseText»
		
		#ifndef «module.define»_H_
		#define «module.define»_H_

		#include "«typesModule.hpp»"
		#include "«iStatemachine.hpp»"
		«IF timed»
			#include "«iTimedStatemachine.hpp»"
		«ENDIF»

		/*! \file Header of the state machine '«name»'.
		*/
		
		class «module» : «interfaceExtensions» {
			
			public:
			
				«statesEnumDecl»
				
				«FOR s : it.scopes»«s.createScope(entry)»«ENDFOR»
				
				«FOR s : it.scopes.filter( typeof(InternalScope) )»
					«s.scopeFunctionPrototypes»
				«ENDFOR»
				
				/*! Checks if the specified state is active. */
				sc_boolean «nameOfIsActiveFunction»(«statesEnumType» state);
			
			private:
			
				«statemachineTypeDecl»
		};
		
		#endif /* «module.define»_H_ */
	'''
	
	def getInterfaceExtensions(ExecutionFlow flow) {

		var String interfaces = "";

		if (flow.timed) {
			interfaces = interfaces + "public " +iTimedStatemachine+", "
		}

		interfaces = interfaces + "public " + iStatemachine
		
		return interfaces;
	}
	
	def private createScope(Scope scope, GeneratorEntry entry) {
		switch scope {
			InterfaceScope: scope.createScope(entry)
			InternalScope: scope.createScope
		}
	}
	
	def private createScope(InterfaceScope scope, GeneratorEntry entry)
	'''
		«scope.createInterface(entry)»
«««		«scope.createListenerInterface(entry)»
		«scope.createOperationCallbackInterface»
		
		«scope.interfaceName»* get«scope.interfaceName»();
		
	'''
	
	def private createInterface(InterfaceScope scope, GeneratorEntry entry)
	'''
		//! Inner class for statechart «scope.interfaceName» interface scope.
		class «scope.interfaceName» {
			
			public:
				«FOR d : scope.declarations»
					«d.functionPrototypes»
				«ENDFOR»
				
			private:
				«FOR d : scope.declarations»
				 «d.structDeclaration»
				«ENDFOR»
		};
	'''
	
	def private createScope(InternalScope scope) {
		'''
		«IF scope.hasOperations()»
			class «internalOperationCallbackName» {
				«FOR operation : scope.operations»
					virtual «operation.asFunction»() = 0;
				«ENDFOR»
			}
			
			virtual void set«internalOperationCallbackName»(«internalOperationCallbackName»* operationCallback) = 0;
		«ENDIF»
		'''
	}
	
	def createOperationCallbackInterface(InterfaceScope scope) {
		'''
		«IF scope.hasOperations»
			
			public interface «scope.getInterfaceOperationCallbackName()» {
			«FOR operation : scope.operations»
				virtual «operation.signature» = 0;
			«ENDFOR»
			}
		«ENDIF»
		'''
	}
	
	def private signature(OperationDefinition it)
	'''
		«type.targetLanguageName» «name.asEscapedIdentifier»(«FOR parameter : parameters SEPARATOR ', '»«parameter.type.targetLanguageName» «parameter.identifier»«ENDFOR»)
	'''
	
	def private identifier(Parameter parameter) {
		if (parameter.name.isCKeyword()) {
			return parameter.name + "Arg"
		}
		else {
			parameter.name
		}
	}

	override statemachineTypeDecl(ExecutionFlow it) '''
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		#define «type.toUpperCase»_MAX_ORTHOGONAL_STATES «stateVector.size»
		«IF hasHistory»
		//! dimension of the state configuration vector for history states
		#define «type.toUpperCase»_MAX_HISTORY_STATES «historyVector.size»«ENDIF»
		
		«IF timed»sc_boolean timeEvents[«timeEvents.size»];«ENDIF»
		«statesEnumType» stateConfVector[«type.toUpperCase»_MAX_ORTHOGONAL_STATES];
		«IF hasHistory»«statesEnumType» historyVector[«type.toUpperCase»_MAX_HISTORY_STATES];«ENDIF»
		sc_ushort stateConfVectorPosition;
	'''

	override dispatch functionPrototypes(EventDefinition it) '''
		«IF direction == Direction::IN»
		/*! Raises the in event '«name»' that is defined in the «scope.scopeDescription». */ 
		void «asRaiser»(«valueParams»);
		
		«ELSE»
			/*! Checks if the out event '«name»' that is defined in the «scope.scopeDescription» has been raised. */ 
			sc_boolean «asRaised»();
			
			«IF hasValue»
				/*! Gets the value of the out event '«name»' that is defined in the «scope.scopeDescription». */ 
				«type.targetLanguageName» «asGetter»();
				
			«ENDIF»
		«ENDIF»
	'''

	override dispatch functionPrototypes(VariableDefinition it) '''
		/*! Gets the value of the variable '«name»' that is defined in the «scope.scopeDescription». */ 
		«type.targetLanguageName» «it.asGetter»();
		«IF ! readonly »
			/*! Sets the value of the variable '«name»' that is defined in the «scope.scopeDescription». */ 
			void «asSetter»(«type.targetLanguageName» value);
		«ENDIF»
	'''
}