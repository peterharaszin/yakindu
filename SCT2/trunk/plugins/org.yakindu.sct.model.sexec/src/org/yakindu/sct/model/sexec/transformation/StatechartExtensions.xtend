package org.yakindu.sct.model.sexec.transformation

import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.sgraph.Region
import org.yakindu.sct.model.sgraph.Vertex
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.sgraph.Trigger
import org.yakindu.sct.model.sgraph.Reaction
import org.yakindu.sct.model.sgraph.Transition
import java.util.List
import java.util.ArrayList
import org.yakindu.sct.model.stext.stext.TimeEventSpec
import org.eclipse.xtext.EcoreUtil2
import org.yakindu.sct.model.stext.stext.LocalReaction
import org.yakindu.sct.model.sgraph.ReactiveElement
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.model.sgraph.Choice

class StatechartExtensions {
	
	
	/** calculates the maximum orthogonality (maximum number of possible active leaf states) of the statechart */
	def int maxOrthogonality(Statechart sc) {
		sc.regions.fold(0, [o, r | r.maxOrthogonality + o])
	}

	/** calculates the maximum orthogonality (maximum number of possible active leaf states) of a region */
	def int maxOrthogonality(Region r) {
		r.vertices.fold(0, [s, v | {
			val mo = v.maxOrthogonality
			if (mo > s) mo else s }])
	}

	/** the maximum orthogonality of all  pseudo states is 0 */
	def dispatch int maxOrthogonality(Vertex v) { 0 }
	
	/** calculates the maximum orthogonality (maximum number of possible active leaf states) of a state */
	def dispatch int maxOrthogonality(State s) { 
		if ( s.regions.size > 0 ) {
			s.regions.fold(0, [o, r | r.maxOrthogonality + o])		
		} else 1
	}



	//=================================================================
	// navigation and query util extensions
	//
		
	def reaction(Trigger tr) { tr.eContainer as Reaction }


	def Statechart statechart(State state) { state.parentRegion.statechart }
	
	def Statechart statechart(Region region) { 
		if (region.eContainer instanceof Statechart) 
			region.eContainer as Statechart
			else (region.eContainer as State).statechart		
	}
	
	
	/** 
	 * Provides a list of all TimeEventSpecs that are defined in the context of 'state'.
	 */
	def List<TimeEventSpec> timeEventSpecs(State state) { 
		// TODO: also query local reactions
		var tesList = new ArrayList<TimeEventSpec>()
		
		state.outgoingTransitions.fold(tesList, 
			[s, r | {
				EcoreUtil2::eAllContentsAsList(r).filter(typeof (TimeEventSpec)).forEach(tes | s.add(tes))
				s
			}]
		)

		state.localReactions.fold(tesList, 
			[s, r | {
				EcoreUtil2::eAllContentsAsList(r).filter(typeof (TimeEventSpec)).forEach(tes | s.add(tes))
				s
			}]
		)
				
		return tesList
	}


	def dispatch ReactiveElement reactiveElement(Reaction r) {
		r.scope.reactiveElement		
	}

	def dispatch ReactiveElement reactiveElement(Transition tr) {
		if (tr.source instanceof State) tr as State
		else null
	}
	
	
	def Scope scope(Reaction r) {
		if (r.eContainer instanceof Scope) r.eContainer as Scope
	} 

	def ReactiveElement reactiveElement(Scope s) {
		if (s.eContainer instanceof ReactiveElement) s.eContainer as ReactiveElement
	}	
	
	def List<RegularState> allRegularStates(Statechart sc) {
		var content = EcoreUtil2::eAllContentsAsList(sc)
		val allStates = content.filter( typeof(RegularState) )
		
		return allStates.toList
	}
	
	
	
	def List<Region> allRegions(Statechart sc) {
		var content = EcoreUtil2::eAllContentsAsList(sc)
		val allRegions = content.filter( typeof(Region) )
		
		return allRegions.toList
	}
	
	
	
	def List<Choice> allChoices(Statechart sc) {
		var content = EcoreUtil2::eAllContentsAsList(sc)
		val allChoices = content.filter( typeof(Choice) )
		
		return allChoices.toList
	}
	
	
	
	//=================================================================
	// naming util extensions
	//

	def dispatch String id(Object obj) { null }
		
		
	/**
	 * The id of a transition is unique within the context of its source vertex.
	 */	
	def dispatch String id(Transition t) {
		"tr" + if (t.source != null) t.source.outgoingTransitions.indexOf(t) else ""
	}
	
	/**
	 * The id of a local reaction is unique within the context of its source vertex.
	 */	
	def dispatch String id(LocalReaction t) {
		"lr" + if (t.reactiveElement != null) t.reactiveElement.localReactions.indexOf(t) else ""
	}
	
	
	
}
