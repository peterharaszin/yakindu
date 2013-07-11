/**
  Copyright (c) 2012 committers of YAKINDU and others.
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
  Contributors:
  	Markus Muehlbrandt - Initial contribution and API
*/
package org.yakindu.sct.generator.java

import com.google.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry
import java.util.List
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.Check
import org.yakindu.sct.model.stext.types.ISTextTypeSystem
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.Direction
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.sexec.extensions.SExecExtensions

class Statemachine {
	
	@Inject extension Naming
	@Inject extension GenmodelEntries
	@Inject extension Navigation
	@Inject extension ICodegenTypeSystemAccess
	@Inject extension ISTextTypeSystem
	@Inject extension FlowCode
	@Inject extension SExecExtensions
	
	
	@Inject Beautifier beautifier
	
	def generateStatemachine(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa) {
		var filename = flow.getImplementationPackagePath(entry) + '/' + flow.statemachineClassName.java
		var content = beautifier.format(filename, content(flow, entry))
		fsa.generateFile(filename, content)
	}
	
	def private content(ExecutionFlow flow, GeneratorEntry entry) '''
		«entry.licenseText»
		package «flow.getImplementationPackageName(entry)»;
		«flow.createImports(entry)»
		
		public class «flow.statemachineClassName» implements «flow.statemachineInterfaceName» {
			
			«flow.createFieldDeclarations(entry)»
			
			«flow.createConstructor»
			
			«flow.initFunction»
			
			«flow.enterFunction»
			
			«flow.exitFunction»
			
			«flow.clearInEventsFunction»
			
			«flow.clearOutEventsFunction»
			
			«flow.activeFunction»
			
			«flow.timingFunctions»
			
			«flow.interfaceAccessors»
			
			«flow.internalScopeFunctions»
			
			«flow.defaultInterfaceFunctions(entry)»
			
			«flow.functionImplementations»
			
			«flow.runCycleFunction»
		}
	'''
	
	def private createImports(ExecutionFlow flow, GeneratorEntry entry) '''
		«IF entry.createInterfaceObserver && flow.hasOutgoingEvents»
		import java.util.LinkedList;
		import java.util.List;
		«ENDIF»
		«IF flow.timed»
			import «entry.getBasePackageName()».TimeEvent;
			import «entry.getBasePackageName()».ITimerService;
		«ENDIF»
	'''
	
	def private createFieldDeclarations(ExecutionFlow flow, GeneratorEntry entry) '''
		«FOR event : flow.internalScopeEvents»
		private boolean «event.name.asEscapedIdentifier»;
		
		«IF event.type != null && !event.type.voidType»
			private «event.type.targetLanguageName» «event.valueIdentifier»;
		«ENDIF»
		«ENDFOR»
		«var timeEvents = flow.timeEvents»
		«FOR timeEvent: timeEvents»
			private final TimeEvent «timeEvent.name.asEscapedIdentifier» = new TimeEvent(«timeEvent.periodic», «timeEvents.indexOf(timeEvent)»); 
		«ENDFOR»
	
		«IF flow.timed»
			private final boolean[] timeEvents = new boolean[«timeEvents.size»];
		«ENDIF»
	
		«FOR scope : flow.interfaceScopes»
			«scope.toImplementation(entry)»
			
			private «scope.interfaceImplName» «scope.interfaceName.asEscapedIdentifier»;
		«ENDFOR»
	
		public enum State {
			«FOR state : flow.states»
				«state.stateName.asEscapedIdentifier»,
			«ENDFOR»
			«getNullStateName()»
		};
		
		«FOR variable : flow.internalScopeVariables»
		private «variable.type.targetLanguageName» «variable.name.asEscapedIdentifier»;
		«ENDFOR»
		
		«IF flow.hasHistory»
		private State[] historyVector = new State[«flow.historyVector.size»];
		«ENDIF»
		private final State[] stateVector = new State[«flow.stateVector.size»];
		
		private int nextStateIndex;
		
		«IF flow.timed»
		private ITimerService timerService;
		
		private long cycleStartTime;
		«ENDIF»
		
		«FOR internal : flow.internalScopes»
		«IF internal.hasOperations()»
			private «internal.getInternalOperationCallbackName()» operationCallback;
		«ENDIF»
		«ENDFOR»
	'''
	
	def private createConstructor(ExecutionFlow flow) '''
		public «flow.statemachineClassName»() {
			
			«FOR scope : flow.interfaceScopes»
			«scope.interfaceName.asEscapedIdentifier» = new «scope.getInterfaceImplName()»();
			«ENDFOR»
			
			«FOR timeEvent : flow.timeEvents»
				«timeEvent.name.asEscapedIdentifier».setStatemachine(this);
			«ENDFOR»
			}
	'''
	
	def private initFunction(ExecutionFlow flow) '''
		public void init() {
			«IF flow.timed»
			if (timerService == null) {
				throw new IllegalStateException("TimerService not set.");
			}
			«ENDIF»
			for (int i = 0; i < «flow.stateVector.size»; i++) {
				stateVector[i] = State.$NullState$;
			}
			
			«IF flow.hasHistory»
			for (int i = 0; i < «flow.historyVector.size»; i++) {
				historyVector[i] = State.$NullState$;
			}
			«ENDIF»
			clearEvents();
			clearOutEvents();
			
			«flow.initSequence.code»
		}
	'''
	
	def private clearInEventsFunction(ExecutionFlow flow) '''
		protected void clearEvents() {
			«FOR scope : flow.interfaceScopes»
				«IF scope.hasEvents»
					«scope.interfaceName.asEscapedIdentifier».clearEvents();
				«ENDIF»
			«ENDFOR»
			«FOR scope : flow.internalScopes»
				«FOR event : scope.eventDefinitions»
					«event.name.asEscapedIdentifier» = false;
				«ENDFOR»
			«ENDFOR»
			
			«IF flow.timed»
			for (int i=0; i<timeEvents.length; i++) {
				timeEvents[i] = false;
			}
			«ENDIF»
		}
	'''
	
	def private clearOutEventsFunction(ExecutionFlow flow) '''
		protected void clearOutEvents() {
			«FOR scope : flow.interfaceScopes»
				«IF scope.hasOutgoingEvents»
					«scope.interfaceName.asEscapedIdentifier».clearOutEvents();
				«ENDIF»
			«ENDFOR»
		}
	'''
	
	def private isActiveFunction(ExecutionFlow flow) '''
		public boolean isStateActive(State state){
			switch (state) {
				«FOR s : flow.states»
				case «s.stateName.asEscapedIdentifier» : 
					return «IF s.leaf»stateVector[«s.stateVector.offset»] == State.«s.stateName.asEscapedIdentifier»
					«ELSE»stateVector[«s.stateVector.offset»].ordinal() >= State.«s.stateName.asEscapedIdentifier».ordinal()
						&& stateVector[«s.stateVector.offset»].ordinal() <= State.«s.subStates.last.stateName.asEscapedIdentifier».ordinal()«ENDIF»;
				«ENDFOR»
				default: return false;
			}
		}
	'''
	
	def private timingFunctions(ExecutionFlow flow) '''
		«IF flow.timed»
			public void setTimerService(ITimerService timerService) {
				this.timerService = timerService;
			}
			
			public ITimerService getTimerService() {
				return timerService;
			}
			
			public void onTimeEventRaised(TimeEvent timeEvent) {
				timeEvents[timeEvent.getIndex()] = true;
			}
		«ENDIF»
	'''
	
	def private interfaceAccessors(ExecutionFlow flow) '''
		«FOR scope : flow.interfaceScopes»
			public «scope.interfaceName» get«scope.interfaceName»() {
				return «scope.interfaceName.toFirstLower()»;
			}
		«ENDFOR»
	'''
	
	def private toImplementation(InterfaceScope scope, GeneratorEntry entry) '''
		private final class «scope.getInterfaceImplName» implements «scope.getInterfaceName» {
		
		«IF entry.createInterfaceObserver && scope.hasOutgoingEvents»
			private List<«scope.getInterfaceListenerName»> listeners = new LinkedList<«scope.getInterfaceListenerName»>();
			
			public List<«scope.getInterfaceListenerName»> getListeners() {
				return listeners;
			}
		«ENDIF»
		
		«IF scope.hasOperations»
			private «scope.getInterfaceOperationCallbackName()» operationCallback;
			
			public void set«scope.getInterfaceOperationCallbackName»(
					«scope.getInterfaceOperationCallbackName» operationCallback) {
				this.operationCallback = operationCallback;
			}
		«ENDIF»
		
		«FOR event : scope.eventDefinitions»
			
			private boolean «event.name.asEscapedIdentifier»;
			
			«IF event.type != null && !event.type.voidType»
				private «event.type.targetLanguageName» «event.valueIdentifier»;
			«ENDIF»
			
			«IF event.direction == Direction::IN»
				«IF event.type != null && !event.type.voidType»
					public void raise«event.name.asName»(«event.type.targetLanguageName» value) {
						«event.name.asEscapedIdentifier» = true;
						«event.valueIdentifier» = value;
					}
					
					private «event.type.targetLanguageName» get«event.name.asName»Value() {
						«event.getIllegalAccessValidation()»
						return «event.valueIdentifier»;
					}
					
				«ELSE»
					public void raise«event.name.asName»() {
						«event.name.asEscapedIdentifier» = true;
					}
					
				«ENDIF»
			«ENDIF»
			
			«IF event.direction == Direction::OUT»
				
				public boolean isRaised«event.name.asName»() {
					return «event.name.asEscapedIdentifier»;
				}
				
				«IF event.type != null && !event.type.voidType»
					private void raise«event.name.asName»(«event.type.targetLanguageName» value) {
						«event.name.asEscapedIdentifier» = true;
						«event.valueIdentifier» = value;
						«IF entry.createInterfaceObserver»
						for («scope.interfaceListenerName» listener : listeners) {
							listener.on«event.name.asEscapedName»Raised(value);
						}
						«ENDIF»
					}
					
					public «event.type.targetLanguageName» get«event.name.asName»Value() {
						«event.getIllegalAccessValidation()»
						return «event.valueIdentifier»;
					}
				«ELSE»
					private void raise«event.name.asName»() {
						«event.name.asEscapedIdentifier» = true;
						«IF entry.createInterfaceObserver»
							for («scope.interfaceListenerName» listener : listeners) {
								listener.on«event.name.asEscapedName»Raised();
							}
						«ENDIF»
					}
				«ENDIF»
			«ENDIF»
		«ENDFOR»
		
		«FOR variable : scope.variableDefinitions»
				
				private «variable.type.targetLanguageName» «variable.name.asEscapedIdentifier»;
				
				public «variable.type.targetLanguageName» «variable.getter» {
					return «variable.name.asEscapedIdentifier»;
				}
				
				«IF  !variable.readonly»
					public void «variable.setter»(«variable.type.targetLanguageName» value) {
						this.«variable.name.asEscapedIdentifier» = value;
					}
				«ENDIF»
		«ENDFOR»
		
		«IF scope.hasEvents»
			public void clearEvents() {
			«FOR event : scope.eventDefinitions»
				«IF event.direction != Direction::OUT»
				«event.name.asEscapedIdentifier» = false;
				«ENDIF»
			«ENDFOR»
			}
			
		«ENDIF»
		
		«IF scope.hasOutgoingEvents()»
			public void clearOutEvents() {
			«FOR event : scope.eventDefinitions»
				«IF event.direction == Direction::OUT»
					«event.name.asEscapedIdentifier» = false;
				«ENDIF»
			«ENDFOR»
			}
		«ENDIF»
		}
	'''
	
	def private getIllegalAccessValidation(EventDefinition it) '''
		if (! «name.asEscapedIdentifier» ) 
			throw new IllegalStateException("Illegal event value acces. Event «name.asEscapedName» is not raised!");
	'''
	
	def private internalScopeFunctions (ExecutionFlow flow) '''
		«FOR event : flow.internalScopeEvents»
			«IF event.type != null && !event.type.voidType»
				private void raise«event.name.asEscapedName»(«event.type.targetLanguageName» value) {
					«event.valueIdentifier» = value;
					«event.name.asEscapedIdentifier» = true;
				}
				
				private «event.type.targetLanguageName» get«event.name.asEscapedName»Value() {
					«event.getIllegalAccessValidation()»
					return «event.valueIdentifier»;
				}
			«ELSE»
			
				private void raise«event.name.asEscapedName»() {
					«event.name.asEscapedIdentifier» = true;
				}
				
			«ENDIF»
		«ENDFOR»
«««		«FOR variable : flow.internalScopeVariables»
«««		private «variable.type.targetLanguageName» «variable.getter» {
«««			return «variable.name.asEscapedIdentifier»;
«««		}
«««		
«««		private void «variable.setter»(«variable.type.targetLanguageName» value) {
«««			«variable.name.asEscapedIdentifier» = value;
«««		}	
«««		«ENDFOR»
		
		«FOR internal : flow.internalScopes»
			«IF internal.hasOperations»
				public void set«internal.internalOperationCallbackName»(
						«internal.internalOperationCallbackName» operationCallback) {
					this.operationCallback = operationCallback;
				}
			«ENDIF»
		«ENDFOR»
	'''
	
	def private defaultInterfaceFunctions(ExecutionFlow flow, GeneratorEntry entry) '''
		«IF flow.defaultScope != null»
			«var InterfaceScope scope = flow.defaultScope»
			«FOR event : scope.eventDefinitions»
				«IF event.direction == Direction::IN»
					«IF event.type != null && !event.type.voidType»
					public void raise«event.name.asName»(«event.type.targetLanguageName» value) {
						«scope.interfaceName.asEscapedIdentifier».raise«event.name.asName»(value);
					}
					«ELSE»
					public void raise«event.name.asName»() {
						«scope.interfaceName.asEscapedIdentifier».raise«event.name.asName»();
					}
					«ENDIF»
				«ENDIF»
				«IF event.direction ==  Direction::OUT»
					public boolean isRaised«event.name.asName»() {
						return «scope.interfaceName.asEscapedIdentifier».isRaised«event.name.asName»();
					}
					«IF event.type != null && !event.type.voidType»
						public «event.type.targetLanguageName» get«event.name.asName»Value() {
							return «scope.interfaceName.asEscapedIdentifier».get«event.name.asName»Value();
						}
					«ENDIF»
				«ENDIF»
			«ENDFOR»
			
			«FOR variable : scope.variableDefinitions»
			public «variable.type.targetLanguageName» «variable.getter()» {
				return «scope.interfaceName.asEscapedIdentifier».«variable.getter()»;
			}
			
			public void «variable.setter»(«variable.type.targetLanguageName» value) {
				«scope.interfaceName.asEscapedIdentifier».«variable.setter»(value);
			}	
			«ENDFOR»
		«ENDIF»
		
	'''
	
	def private runCycleFunction(ExecutionFlow flow) '''
		public void runCycle() {
			
			«IF flow.timed»
			cycleStartTime = timerService.getSystemTimeMillis();
			
			«ENDIF»
			clearOutEvents();
			
			for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
				
				switch (stateVector[nextStateIndex]) {
				«FOR state : flow.states»
					«IF state.reactSequence!=null»
						case «state.stateName.asEscapedIdentifier»:
							«state.reactSequence.functionName»();
							break;
					«ENDIF»
				«ENDFOR»
				default:
					// «getNullStateName()»
				}
			}
			
			clearEvents();
		}
	'''
	
	def private enterFunction(ExecutionFlow it) '''
		public void enter() {
			«IF timed»
			if (timerService == null) {
				throw new IllegalStateException("TimerService not set.");
			}
			cycleStartTime = timerService.getSystemTimeMillis();
			«ENDIF»
			«enterSequences.defaultSequence.code»
		}
	'''
	
	def private exitFunction(ExecutionFlow it) '''
		public void exit(){
			«exitSequence.code»
		}
	'''
	
	def private functionImplementations(ExecutionFlow it) '''
		«checkFunctions.toImplementation»
		«effectFunctions.toImplementation»
		«entryActionFunctions.toImplementation»
		«exitActionFunctions.toImplementation»
		«enterSequenceFunctions.toImplementation»
		«exitSequenceFunctions.toImplementation»
		«reactFunctions.toImplementation»
	'''
	
	def toImplementation(List<Step> steps) '''
		«FOR s : steps»
			«s.functionImplementation»
		«ENDFOR»
	'''
	
	def dispatch functionImplementation(Check it) '''
		«stepComment»
		private boolean «asCheckFunction»() {
			return «code»;
		}
		
	'''
	
	def dispatch functionImplementation(Step it) '''
		«stepComment»
		private void «functionName»() {
			«code»
		}
		
	'''
}