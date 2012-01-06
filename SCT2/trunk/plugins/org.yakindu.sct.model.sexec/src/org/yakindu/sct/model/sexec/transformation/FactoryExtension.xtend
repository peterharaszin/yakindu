package org.yakindu.sct.model.sexec.transformation

/**
 * This extension class defines all factory (create) functions that are required 
 * for creating a flow element based on a statechrt source element. Thus most create functions are parametrized 
 * by elements from the source statechart. 
 * 
 * @author axel terfloth
 */ 

import com.google.inject.Inject
import org.eclipse.xtext.naming.IQualifiedNameProvider

import org.yakindu.sct.model.sexec.SexecFactory
import org.yakindu.sct.model.stext.stext.StextFactory
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.sgraph.Scope
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.InternalScope
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.VariableDefinition
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.sexec.Check
import org.yakindu.sct.model.stext.stext.ReactionTrigger
import org.yakindu.sct.model.sexec.Reaction
import org.yakindu.sct.model.sgraph.Transition
import org.yakindu.sct.model.sexec.CheckRef
import org.yakindu.sct.model.sexec.Call
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.TimeEvent
import org.yakindu.sct.model.sexec.ScheduleTimeEvent
import org.yakindu.sct.model.sgraph.Statement
import org.yakindu.sct.model.sexec.UnscheduleTimeEvent
import org.yakindu.sct.model.stext.stext.LocalReaction
import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.model.sgraph.FinalState
import org.yakindu.sct.model.sgraph.Choice
import org.yakindu.sct.model.sexec.ExecutionChoice
import org.yakindu.sct.model.sexec.ExecutionRegion
import org.yakindu.sct.model.sgraph.Region

class FactoryExtension {
	
	
	@Inject extension IQualifiedNameProvider qfnProvider
	@Inject extension StatechartExtensions sce
	

	def ExecutionFlow create r : sexecFactory.createExecutionFlow create(Statechart statechart){
		r.name = statechart.name
	}

	def dispatch Scope create r : stextFactory.createInterfaceScope  create(InterfaceScope scope) {
		r.name = scope.name
	}
	
	def dispatch Scope create r : stextFactory.createInternalScope  create(InternalScope scope) {}
	
	
	def EventDefinition create r : EcoreUtil::copy(event) create(EventDefinition event) {}
	
	def VariableDefinition create r : EcoreUtil::copy(v) create(VariableDefinition v) {}
	
	
	def ExecutionState create r : sexecFactory.createExecutionState create(RegularState state){
		if (state != null) {
			r.simpleName = if (state instanceof FinalState) "_final_" else state.name
			r.name = state.fullyQualifiedName.toString.replaceAll(" ", "")	
			r.sourceElement = state	
		}
	}
	
	def ExecutionChoice create r : sexecFactory.createExecutionChoice create(Choice choice){
		if (choice != null) {
			val n = choice.parentRegion.vertices.filter( typeof ( Choice) ).toList.indexOf(choice)
			r.simpleName =   "_choice" + n + "_"
			r.name = choice.fullyQualifiedName.toString.replaceAll(" ", "")	
			r.sourceElement = choice	
			r.reactSequence = sexecFactory.createSequence
		}
	}
	
	
	def ExecutionRegion create r : sexecFactory.createExecutionRegion create(Region region){
		if (region != null) {
			r.name =  region.name
			r.sourceElement = region	
		}
	}
	
	
	def Check create r : sexecFactory.createCheck createCheck(ReactionTrigger tr){
		r.name = tr.reaction.id
	}
	
	def Reaction create r : sexecFactory.createReaction create(Transition tr){
		r.name = tr.id
		r.transition = true
		r.sourceElement = tr
	}
	
	def Reaction create r : sexecFactory.createReaction create(LocalReaction lr){
		r.name = lr.id
		r.transition = false
	}
	
	def CheckRef newRef(Check check) {
		val r = sexecFactory.createCheckRef
		r.check = check
		r
	} 

	def Call newCall(Step step) {
		val r = sexecFactory.createCall
		r.step = step
		r
	}
	
	def ScheduleTimeEvent newScheduleTimeEvent(TimeEvent te, Statement timeValue) {
		val r = sexecFactory.createScheduleTimeEvent
		r.timeEvent = te
		r.timeValue = timeValue
		r
	}

	def UnscheduleTimeEvent newUnscheduleTimeEvent(TimeEvent te) {
		val r = sexecFactory.createUnscheduleTimeEvent
		r.timeEvent = te
		r
	}

	//--------- UTILS ---------------
	def sexecFactory() { SexecFactory::eINSTANCE }
	def stextFactory() { StextFactory::eINSTANCE }
	
}