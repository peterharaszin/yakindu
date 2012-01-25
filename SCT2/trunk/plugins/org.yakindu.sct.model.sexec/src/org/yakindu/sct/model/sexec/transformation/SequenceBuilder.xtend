package org.yakindu.sct.model.sexec.transformation

import static extension org.eclipse.xtext.xtend2.lib.EObjectExtensions.*
import static extension org.eclipse.emf.ecore.util.EcoreUtil.*
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.sgraph.Region
import org.yakindu.sct.model.sgraph.Vertex
import org.yakindu.sct.model.sgraph.FinalState
import org.yakindu.sct.model.sgraph.State
import com.google.inject.Inject
import com.google.inject.name.Named
import org.yakindu.sct.model.sexec.Sequence
import org.yakindu.sct.model.sexec.ExecutionRegion
import java.util.List
import org.yakindu.sct.model.sgraph.RegularState
import java.util.ArrayList
import org.yakindu.sct.model.sexec.StateSwitch
import org.yakindu.sct.model.stext.stext.VariableDefinition
import org.yakindu.sct.model.stext.stext.AssignmentOperator
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.ExecutionScope
import org.yakindu.sct.model.sgraph.Entry
import org.yakindu.sct.model.sgraph.EntryKind
import org.yakindu.sct.model.sexec.StateVectorType

class SequenceBuilder {
	
	@Inject extension SgraphExtensions sgraph
	@Inject extension StextExtensions stext
	@Inject extension SexecExtensions sexec
	@Inject extension SexecElementMapping mapping
	@Inject extension TraceExtensions trace
	
	@Inject @Named("ADD_TRACES") 
	boolean _addTraceSteps 
	
	
	def void defineDeepEnterSequences(ExecutionFlow flow, Statechart sc) {
		for ( r : sc.regions) {
			r.defineDeepEnterSequence
		}
	}
	def void defineDeepEnterSequence(State s) {
		for (r : s.regions) {
			r.defineDeepEnterSequence
		}
	}

	def void defineDeepEnterSequence(Region r) {
		for (s : r.vertices.filter(typeof(State))) {
			s.defineDeepEnterSequence
		}
		if (!r.requireHistory) {
			return
		}
		val execRegion = r.create
		val seq = sexec.factory.createSequence
		seq.name = "deepEnterSequence"
		seq.comment = "deep enterSequence with history in child " + r.name
		
		seq.steps += r.defineDeepHistorySwitch
		execRegion.deepEnterSequence = seq
	}

	def StateSwitch defineDeepHistorySwitch(Region r) {
		val execRegion = r.create
		
		val StateSwitch sSwitch = sexec.factory.createStateSwitch
		sSwitch.stateConfigurationIdx = execRegion.stateVector.offset
		sSwitch.comment = "Handle deep history entry of " +r.name
		sSwitch.historyRegion = execRegion
		
		for (child : r.vertices.filter(typeof(State))) {
			//TODO consider direct children
			for (childLeaf : child.collectLeafStates(newArrayList).filter(c|c.create.stateVector.offset == sSwitch.stateConfigurationIdx)) {
				val execChild = child.create
				val seq = sexec.factory.createSequence
				seq.name = "enterSequence"
				seq.comment = "enterSequence with history in child " + child.name+" for leaf "+childLeaf.name
				if ( execChild.leaf ) {
					seq.steps += execChild.enterSequence.newCall
				} else {
					if (execChild.entryAction != null ) seq.steps += execChild.entryAction.newCall
					if ( trace.addTraceSteps ) seq.steps += execChild.newTraceStateEntered
					for (childRegion : child.regions) {
						seq.steps += childRegion.create.deepEnterSequence.newCall
					}
				}
				sSwitch.cases += childLeaf.create.newCase(seq)
			}
		}
		
		return sSwitch
	}
	
	def void defineShallowEnterSequences(ExecutionFlow flow, Statechart sc) {
		for ( r : sc.allContentsIterable.filter(typeof(Region))) {
			if (r.requireHistory) {
				val execRegion = r.create
				val seq = sexec.factory.createSequence
				seq.name = "shallowEnterSequence"
				seq.comment = "shallow enterSequence with history in child " + r.name
				
				seq.steps += r.defineShallowHistorySwitch
				execRegion.shallowEnterSequence = seq
			}
		}
	}
	
	def StateSwitch defineShallowHistorySwitch(Region r) {
		val execRegion = r.create
		
		val StateSwitch sSwitch = sexec.factory.createStateSwitch
		sSwitch.stateConfigurationIdx = execRegion.stateVector.offset
		sSwitch.comment = "Handle shallow history entry of " +r.name
		sSwitch.historyRegion = r.create
		
		for (child : r.vertices.filter(typeof(State))) {
			val execChild = child.create
			//TODO consider direct children
			for (childLeaf : child.collectLeafStates(newArrayList).filter(c|c.create.stateVector.offset == sSwitch.stateConfigurationIdx)) {
				sSwitch.cases += childLeaf.create.newCase(execChild.enterSequence.newCall)
			}
		}
		
		return sSwitch
	}
	
	/**
	 * Defines the enter sequences of all states
	 */
	def void defineStateEnterSequences(ExecutionFlow flow, Statechart sc) {
		
		// iterate over all regions
		for ( r : sc.regions) defineStateEnterSequence(r)
	}
	

	def dispatch void defineStateEnterSequence(Region r) {
		val execState = r.create
		val seq = sexec.factory.createSequence
		seq.name = "enterSequence"
		seq.comment = "Default enter sequence for region " + r.name

		// process all vertices of a region
		for ( s : r.vertices) defineStateEnterSequence(s)

		val entryNode = r.entry?.create
		if (entryNode != null && entryNode.reactSequence != null) {
			seq.steps.add(entryNode.reactSequence.newCall);
		}
// Was before
//		val entryState = r.entry?.target?.create
//		if (entryState != null && entryState.enterSequence != null) 
//				seq.steps.add(entryState.enterSequence.newCall);
		execState.enterSequence = seq
	}

	def dispatch void defineStateEnterSequence(Vertex v) {}	
	
	
	def dispatch void defineStateEnterSequence(FinalState state) {
		val execState = state.create
		val seq = sexec.factory.createSequence
		seq.name = "enterSequence"
		seq.comment = "Default enter sequence for state " + state.name
		if (execState.entryAction != null) seq.steps.add(execState.entryAction.newCall)
		
		if ( _addTraceSteps ) seq.steps += execState.newTraceStateEntered
		
		seq.steps += execState.newEnterStateStep
		execState.enterSequence = seq
	}	
	
	
	
	def dispatch void defineStateEnterSequence(State state) {
		
		val execState = state.create
		val seq = sexec.factory.createSequence
		seq.name = "enterSequence"
		seq.comment = "Default enter sequence for state " + state.name
		if (execState.entryAction != null) seq.steps.add(execState.entryAction.newCall)
		
		if ( _addTraceSteps ) seq.steps += execState.newTraceStateEntered
		
		if ( execState.leaf ) {
			
			seq.steps += execState.newEnterStateStep
					
		} else {
	
			for ( r : state.regions ) {
				defineStateEnterSequence(r)

				val execRegion = r.create
				if (execRegion.enterSequence != null) {
					seq.steps.add(execRegion.enterSequence.newCall)
				}
			} 
		}

		execState.enterSequence = seq
	}

	/**
	 * Defines the exit sequences of all states
	 */
	def void defineStateExitSequences(ExecutionFlow flow, Statechart sc) {
		
		// iterate over all regions
		for ( r : sc.regions) defineStateExitSequence(r)
	}
		

	def dispatch void defineStateExitSequence(Region r) {
		val execRegion = r.create
		val seq = sexec.factory.createSequence
		seq.name = "exitSequence"
		seq.comment = "Default exit sequence for region "+r.name
		
		// process all states of a region
		for ( s : r.vertices ) defineStateExitSequence(s)
		
		if (execRegion.historyVector != null) {
			seq.steps += execRegion.newSaveHistory()
		}
		
		// collect leaf states
		val Iterable<ExecutionState> leafStates = r.collectLeafStates(new ArrayList<RegularState>()).map(rs|rs.create)
		val sVector = execRegion.stateVector

		for ( i: sVector.offset .. sVector.offset + sVector.size - 1 ) {
					
			// create a state switch for each state configuration vector position
			val StateSwitch sSwitch = execRegion.defineExitSwitch(leafStates, i)
			seq.steps.add(sSwitch);
		}
		
		execRegion.exitSequence = seq
	
	}
	
	def dispatch void defineStateExitSequence(Vertex v) {}

	def dispatch void defineStateExitSequence(FinalState s) {
		val execState = s.create
		val seq = sexec.factory.createSequence
		seq.name = "exitSequence"
		seq.comment = "Default exit sequence for final state."
		seq.steps += execState.newExitStateStep
				
		if ( _addTraceSteps ) seq.steps += execState.newTraceStateExited
		
		execState.exitSequence = seq
	}
	
	// TODO : refactor
	def dispatch void defineStateExitSequence(State state) {
		
		val execState = state.create
		val seq = sexec.factory.createSequence
		seq.name = "exitSequence"
		seq.comment = "Default exit sequence for state " + state.name

		if ( execState.leaf ) {
			
			seq.steps += execState.newExitStateStep
					
		} else {

			for (r : state.regions) {
				// first enforce calculation of all child exit sequences
				r.defineStateExitSequence

				val execRegion = r.create
				if (execRegion.exitSequence != null) {
					seq.steps.add(execRegion.exitSequence.newCall)
				}
			}
		}

		if (execState.exitAction != null) seq.steps.add(execState.exitAction.newCall)
		
		if ( _addTraceSteps ) seq.steps += execState.newTraceStateExited
		
		execState.exitSequence = seq
	}

	def StateSwitch defineExitSwitch(ExecutionScope state, Iterable<ExecutionState> leafStates, int pos) {

		// create a state switch
		var StateSwitch sSwitch = sexec.factory.createStateSwitch
		sSwitch.stateConfigurationIdx = pos
		sSwitch.comment = "Handle exit of all possible states (of "+state.name+") at position " + sSwitch.stateConfigurationIdx + "..."
						
		val Iterable<ExecutionState> posStates = leafStates.filter( rs | rs.stateVector.size == 1 && rs.stateVector.offset == pos)					
		
		// create a case for each leaf state
		for ( s : posStates ) {

			val caseSeq = sexec.factory.createSequence
			if (s.exitSequence != null) {
				caseSeq.steps += s.exitSequence.newCall
			}
			
			val exitScopes = s.parentScopes
			exitScopes.removeAll(state.parentScopes)
			exitScopes.remove(s)
			
			// include exitAction calls up to the direct child level.
			exitScopes.fold(caseSeq , [ cs, exitScope | {
				if (exitScope instanceof ExecutionState && s.stateVector.last == exitScope.stateVector.last) {
					val execState = exitScope as ExecutionState
					if (execState.exitAction != null) cs.steps.add(execState.exitAction.newCall)
					if ( _addTraceSteps ) cs.steps.add(execState.newTraceStateExited)
				}
				cs
			}]) 
			
			if (!caseSeq.steps.empty) sSwitch.cases.add(s.newCase(caseSeq))
			
		}
		
		return sSwitch
	}
	
	
	
	def defineStatechartExitSequence(ExecutionFlow flow, Statechart sc) {
		val exitSequence = sexec.factory.createSequence
		exitSequence.name = "exit"
		exitSequence.comment = "Default exit sequence for statechart " + sc.name
		
		for ( r : sc.regions) {
			val execRegion = r.create
			if (execRegion.exitSequence != null) {
				exitSequence.steps.add(execRegion.exitSequence.newCall)
			}
		} 
		
		flow.exitSequence = exitSequence
		return exitSequence
	}
	
	def defineStatechartEnterSequence(ExecutionFlow flow, Statechart sc) {

		val enterSequence = sexec.factory.createSequence
		enterSequence.name = "enter"
		enterSequence.comment = "Default enter sequence for statechart " + sc.name
		
		for (VariableDefinition vd : sc.scopes.map(s|s.variables).flatten.filter(typeof(VariableDefinition))) {
			if (vd.initialValue != null) {
				enterSequence.steps.add(vd.createInitialization)
			}
		}
		
		for ( r : sc.regions) {
			val execRegion = r.create
			if (execRegion.enterSequence != null) {
				enterSequence.steps.add(execRegion.enterSequence.newCall)
			}
		} 
		
		flow.enterSequence = enterSequence
		return enterSequence
	}
	
	def createInitialization(VariableDefinition vd) {
		val execution = sexec.factory.createExecution
		val assignment = stext.factory.createAssignment
		assignment.varRef = vd
		assignment.operator = AssignmentOperator::ASSIGN
		assignment.expression = vd.initialValue.copy
		execution.statement = assignment
		return execution
	}
	
	
}