/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.sexec.interpreter.impl

import com.google.inject.Inject
import org.yakindu.sct.model.sexec.interpreter.IStatementInterpreter
import org.yakindu.sct.simulation.core.IExecutionContext
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.simulation.runtime.sgraph.ExecutionScopeAdapter
import org.yakindu.sct.simulation.runtime.stext.RTScope
import org.yakindu.sct.model.sgraph.Declaration
import org.yakindu.sct.model.sexec.Call
import org.yakindu.sct.model.sexec.Check
import org.yakindu.sct.model.stext.stext.VariableDefinition
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.simulation.runtime.ExecutionScope
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.Cycle
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.simulation.core.ScopeVariable
import org.yakindu.sct.simulation.core.ScopeEvent
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.Sequence
import org.yakindu.sct.model.sexec.EnterState
import org.yakindu.sct.model.sexec.Execution
import org.yakindu.sct.model.sexec.ExitState
import org.yakindu.sct.model.sexec.If
import org.yakindu.sct.model.sexec.ScheduleTimeEvent
import org.yakindu.sct.model.sexec.StateSwitch
import org.yakindu.sct.model.sexec.UnscheduleTimeEvent
import java.util.List
import org.yakindu.sct.model.stext.stext.Type
import org.yakindu.sct.simulation.core.ISGraphExecutionScope
import org.yakindu.sct.model.sexec.StateCase
import org.yakindu.sct.model.sexec.TimeEvent
import org.yakindu.sct.model.sexec.ReactionFired
import org.yakindu.sct.simulation.core.runtime.IExecutionContext
import ScopeVariable
import ScopeEvent
import org.yakindu.sct.model.sgraph.naming.SGraphNameProvider
import org.yakindu.sct.simulation.core.runtime.impl.ExecutionVariable
import org.yakindu.sct.simulation.core.runtime.impl.ExecutionEvent
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.InternalScope
import org.yakindu.sct.model.stext.naming.StextNameProvider
import org.yakindu.sct.model.sexec.interpreter.ITimingService
import com.google.inject.name.Named
import org.yakindu.sct.model.sexec.interpreter.InterpreterModule
import org.yakindu.sct.model.sexec.TraceStateEntered
import org.yakindu.sct.model.sexec.TraceStateExited
import org.yakindu.sct.model.sexec.TraceNodeExecuted
import org.yakindu.base.types.Type
/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
class ExecutionFlowInterpreter extends AbstractExecutionFlowInterpreter {
	
	@Inject
	IStatementInterpreter interpreter
	@Inject
	IExecutionContext executionContext
	@Inject
	StextNameProvider provider
	@Inject 
	ITimingService timingService 
	@Inject
	@Named("InterpreterName")
	String interpreterName
	
	ExecutionFlow flow

	override initialize(ExecutionFlow flow) {
		this.flow = flow;
		for(scope : flow.scopes){
			scope.declareContents
		} 
	}
	
	override tearDown(){
		timingService.stop
	}
	
	override getName(){
		interpreterName
	}
	
	override getExecutionContext(){
		return executionContext
	}
	
	def dispatch declareContents(InternalScope scope) {
		for(declaration : scope.declarations){
				declaration.addToScope
		}
	} 
	
	def dispatch declareContents(Scope scope){
		for(declaration : scope.declarations){
				declaration.addToScope
		}
	}
	
	def dispatch declareContents(InterfaceScope scope){
		for(declaration : scope.declarations){
				declaration.addToScope
		}
	}
	
	override runCycle() {
		executionContext.stateConfiguration.toList.forEach(state | state.reactSequence.execute)
		executionContext.resetRaisedEvents
	} 

// begin TODO: this should be externalized
	def isBoolean(Type type){
		return type != null && type.name == "boolean"
	}
	
	def isInteger(Type type){
		return type != null && type.name == "integer"
	}
	
	def isReal(Type type){
		return type != null && type.name == "real"
	}
	
	def isVoid(Type type){
		return type == null || type.name == "void"
	}
// end TODO

	def dispatch addToScope(VariableDefinition variable){
		var fqName = provider.qualifiedName(variable).toString
		if(isBoolean(variable.type)){
			executionContext.declareVariable(new ExecutionVariable(fqName ,typeof(Boolean),false))
		}
		else if (isInteger(variable.type)){
			executionContext.declareVariable(new ExecutionVariable(fqName,typeof(Integer),0))
		}
		else if(isReal(variable.type)){
			executionContext.declareVariable(new ExecutionVariable(fqName,typeof(Float),Float::parseFloat("0.0")))
		}
		null 
	}  
	
	def dispatch addToScope(EventDefinition event){
		var fqName = provider.qualifiedName(event).toString
		if(isBoolean(event.type)){
				executionContext.declareEvent(new ExecutionEvent(fqName,typeof(Boolean),null))
		}
		else if(isInteger(event.type)){
			executionContext.declareEvent(new ExecutionEvent(fqName,typeof(Integer),null))
		}
		else if(isReal(event.type)){
			executionContext.declareEvent(new ExecutionEvent(fqName,typeof(Float),null))
		}
		else if(isVoid(event.type)){
				executionContext.declareEvent(new ExecutionEvent(fqName,typeof(Void)))
		}
		null 
	} 
	
	def dispatch addToScope(TimeEvent event){
		executionContext.declareEvent(new ExecutionEvent(event.name, typeof(Long)))
		null 
	}
	
	
	override enter() {
		for(step : flow.enterSequence.steps){
			step.execute
		} 
	}
	
	def dispatch execute(Step step){
		println("Missing dispatch function for " + step)
	}
	def dispatch execute(Call call){
		call.step.execute
		null
	}
	
	def dispatch execute(ReactionFired reactionFired){
		notifyTransitionFired(reactionFired)
		null
	}
	
	def dispatch execute(TraceStateEntered entered){
		notifyStateEntered(entered.state)
		null
	}
	
	def dispatch execute(TraceStateExited exited){
		notifyStateExited(exited.state)
		null
	}
	
	def dispatch execute(TraceNodeExecuted executed){
		notifyStateExited(executed.node)
		null
	}
	
	def dispatch execute(Check check){
		if(check.condition == null)
			return true
		var interpreterResult =  interpreter.evaluateStatement(check.condition, executionContext)
		return interpreterResult
		
	}
	def dispatch execute(EnterState enterState){
		executionContext.stateConfiguration.add(enterState.state)
//		notifyStateEntered(enterState.state)
		null
	}
	def dispatch execute(Execution execution){ 
		interpreter.evaluateStatement(execution.statement, executionContext)
	}
	
	def dispatch execute(ExitState exitState){
		executionContext.stateConfiguration.remove(exitState.state)
//		notifyStateExited(exitState.state)
		null
	}
	def dispatch execute(If ifStep){
		var check  = execute(ifStep.check)
		if(check as Boolean){
			execute(ifStep.thenStep)
		}
		else if(ifStep.elseStep != null){
			execute(ifStep.elseStep)
		}
		null
	}
	
	def dispatch execute(Sequence sequence){
		for(step : sequence.steps){
			step.execute
		}
		null
	}
	
	def dispatch execute(StateSwitch stateSwitch){
		for(stateCase : stateSwitch.cases)
			stateCase.execute 
		null 
	}
	
	def dispatch execute(StateCase stateCase){
		if(executionContext.stateConfiguration.contains(stateCase.state)){
			stateCase.step.execute
		}
		null
	}
	def dispatch execute(ScheduleTimeEvent scheduleTimeEvent){
		var timeEvent = scheduleTimeEvent.timeEvent
		var duration = interpreter.evaluateStatement(scheduleTimeEvent.timeValue, executionContext)
		timingService.scheduleTimeEvent(executionContext,timeEvent.name,timeEvent.periodic, duration as Integer)
		null
	}
	
	def dispatch execute(UnscheduleTimeEvent timeEvent){
		timingService.unscheduleTimeEvent(timeEvent.timeEvent.name)
		null
	}
}