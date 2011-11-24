package org.yakindu.sct.model.sexec.transformation.test;

import static org.junit.Assert.*;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.*;

import org.junit.Test;
import org.yakindu.sct.model.sexec.Call;
import org.yakindu.sct.model.sexec.EnterState;
import org.yakindu.sct.model.sexec.Execution;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.ExitState;
import org.yakindu.sct.model.sexec.If;
import org.yakindu.sct.model.sexec.Reaction;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.MinimalTSC;
import org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.OrthogonalFlatTSC;
import org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.SimpleFlatTSC;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.EntryKind;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.stext.stext.Assignment;
import org.yakindu.sct.model.stext.stext.AssignmentOperator;
import org.yakindu.sct.model.stext.stext.ElementReferenceExpression;
import org.yakindu.sct.model.stext.stext.LocalReaction;
import org.yakindu.sct.model.stext.stext.LogicalAndExpression;
import org.yakindu.sct.model.stext.stext.LogicalRelationExpression;
import org.yakindu.sct.model.stext.stext.PrimitiveValueExpression;
import org.yakindu.sct.model.stext.stext.ReactionEffect;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.stext.RelationalOperator;
import org.yakindu.sct.model.stext.stext.StextFactory;
import org.yakindu.sct.model.stext.stext.Type;
import org.yakindu.sct.model.stext.stext.VariableDefinition;


public class ModelSequencerStateTest extends ModelSequencerTest {

	

	/**
	 * if a state defines a entry action then the execution state must have a entryAction.
	 */
	@Test public void testStateEntryAction() {
		Statechart sc = _createStatechart("test");
		Scope scope = _createInterfaceScope("interface", sc);
		VariableDefinition v1 = _createVariableDefinition("v1", Type.INTEGER, scope);
		Region r = _createRegion("main", sc);
		Entry e = _createEntry(EntryKind.INITIAL, null, r);
		State s1 = _createState("s1", r);
		State s2 = _createState("s2", r);
		_createTransition(e, s1);
		_createTransition(s1, s2);
		LocalReaction entryAction = _createEntryAction(s2);
		_createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue("42"), (ReactionEffect) entryAction.getEffect());
		
		ExecutionFlow flow = sequencer.transform(sc);
		
		ExecutionState _s1 = flow.getStates().get(0);
		ExecutionState _s2 = flow.getStates().get(1);
		assertEquals(s1.getName(), _s1.getSimpleName());
		assertEquals(s2.getName(), _s2.getSimpleName());
		
		assertNotNull(_s2.getEntryAction());
		assertNull(_s1.getEntryAction());
	}

	
	/**
	 * entry actions of a substate must not be included in a states entry action list
	 */
	@Test public void testSubStateEntryActionExclusion() {
		Statechart sc = _createStatechart("test");
		Scope scope = _createInterfaceScope("interface", sc);
		VariableDefinition v1 = _createVariableDefinition("v1", Type.INTEGER, scope);
		Region r = _createRegion("main", sc);
//		Entry e = _createEntry(EntryKind.INITIAL, null, r);
		State s2 = _createState("s2", r);
		
		Region s2_r = _createRegion("sub", s2);
		State s2_1 = _createState("s2_1", s2_r);
		LocalReaction entryAction = _createEntryAction(s2_1);
		_createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue("42"), (ReactionEffect) entryAction.getEffect());
		LocalReaction exitAction = _createExitAction(s2_1);
		_createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue("43"), (ReactionEffect) exitAction.getEffect());
		
		ExecutionFlow flow = sequencer.transform(sc);
		
		ExecutionState _s2 = flow.getStates().get(0);
		ExecutionState _s2_1 = flow.getStates().get(1);
		assertEquals(s2.getName(), _s2.getSimpleName());
		assertEquals(s2_1.getName(), _s2_1.getSimpleName());
		
		assertNull(_s2.getEntryAction());
		assertNotNull(_s2_1.getEntryAction());

		assertNull(_s2.getExitAction());
		assertNotNull(_s2_1.getExitAction());
}
	
	
	/**
	 * if a state defines a exit action then the execution state must have a exitAction.
	 */
	@Test public void testStateExitAction() {
		Statechart sc = _createStatechart("test");
		Scope scope = _createInterfaceScope("interface", sc);
		VariableDefinition v1 = _createVariableDefinition("v1", Type.INTEGER, scope);
		Region r = _createRegion("main", sc);
		Entry e = _createEntry(EntryKind.INITIAL, null, r);
		State s1 = _createState("s1", r);
		State s2 = _createState("s2", r);
		_createTransition(e, s1);
		_createTransition(s1, s2);
		LocalReaction exitAction = _createExitAction(s1);
		_createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue("21"), (ReactionEffect) exitAction.getEffect());
		
		ExecutionFlow flow = sequencer.transform(sc);
		
		ExecutionState _s1 = flow.getStates().get(0);
		ExecutionState _s2 = flow.getStates().get(1);
		assertEquals(s1.getName(), _s1.getSimpleName());
		assertEquals(s2.getName(), _s2.getSimpleName());
		
		assertNotNull(_s1.getExitAction());
		assertNull(_s2.getExitAction());
	}
	

	
	/**
	 * A leaf state must have a enter sequence. 
	 * This enter sequence consists of an entry action call and a state enter step.
	 */
	@Test public void testLeafStateEnterSequence() {
		Statechart sc = _createStatechart("cs");
		Scope scope = _createInterfaceScope("interface", sc);
		VariableDefinition v1 = _createVariableDefinition("v1", Type.INTEGER, scope);
		Region r = _createRegion("r", sc);
		State s1 = _createState("s1", r);
		LocalReaction entryAction = _createEntryAction(s1);
		_createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue("42"), (ReactionEffect) entryAction.getEffect());
		
		ExecutionFlow flow = sequencer.transform(sc);
		
		ExecutionState _s1 = flow.getStates().get(0);
		assertEquals(s1.getName(), _s1.getSimpleName());
		
		assertNotNull(_s1.getEntryAction());
		assertNotNull(_s1.getEnterSequence());
		assertEquals(2, _s1.getEnterSequence().getSteps().size());
		
		assertCall(_s1.getEnterSequence(), 0, _s1.getEntryAction());
				
		assertTrue(_s1.getEnterSequence().getSteps().get(1) instanceof EnterState);
	}

	
	/**
	 * A composite state must have a enter sequence. 
	 * This enter sequence consists of an entry action call and a enter sequence call for each sub region.
	 */
	@Test public void testCompositeStateEnterSequence() {
		Statechart sc = _createStatechart("cs"); {
			Scope scope = _createInterfaceScope("interface", sc);
			VariableDefinition v1 = _createVariableDefinition("v1", Type.INTEGER, scope);

			Region r = _createRegion("r", sc); {
				State s1 = _createState("s1", r); {
					_createEntryAssignment(v1, s1, "1");
					Region r1_s1 = _createRegion("r1", s1); {
						Entry e = _createEntry(EntryKind.INITIAL, null, r1_s1);
						State s2 = _createState("s2", r1_s1);
						_createTransition(e, s2);
					}
					Region r2_s1 = _createRegion("r2", s1); {
						Entry e = _createEntry(EntryKind.INITIAL, null, r2_s1);
						State s3 = _createState("s3", r2_s1);
						_createTransition(e, s3);
					}
				}
			}
		}
		
	
		ExecutionFlow flow = sequencer.transform(sc);
		
		ExecutionState _s1 = flow.getStates().get(0);
		assertEquals("s1", _s1.getSimpleName());
		
		ExecutionState _s2 = flow.getStates().get(1);
		assertEquals("s2", _s2.getSimpleName());
		
		ExecutionState _s3 = flow.getStates().get(2);
		assertEquals("s3", _s3.getSimpleName());
		
		assertNotNull(_s1.getEntryAction());
		assertNotNull(_s1.getEnterSequence());
		assertEquals(3, _s1.getEnterSequence().getSteps().size());
		
		assertCall(_s1.getEnterSequence(), 0, _s1.getEntryAction());
		assertCall(_s1.getEnterSequence(), 1, _s2.getEnterSequence());
		assertCall(_s1.getEnterSequence(), 2, _s3.getEnterSequence());
	}


	
	
	/**
	 * A leaf state must have a exit sequence. 
	 * This exit sequence consists of an exit action call and a state exit step.
	 */
	@Test public void testLeafStateExitSequence() {
		Statechart sc = _createStatechart("cs");
		Scope scope = _createInterfaceScope("interface", sc);
		VariableDefinition v1 = _createVariableDefinition("v1", Type.INTEGER, scope);
		Region r = _createRegion("r", sc);
		State s1 = _createState("s1", r);
		LocalReaction entryAction = _createExitAction(s1);
		_createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue("42"), (ReactionEffect) entryAction.getEffect());
		
		ExecutionFlow flow = sequencer.transform(sc);
		
		ExecutionState _s1 = flow.getStates().get(0);
		assertEquals(s1.getName(), _s1.getSimpleName());
		
		assertNotNull(_s1.getExitAction());
		assertNotNull(_s1.getExitSequence());
		assertEquals(2, _s1.getExitSequence().getSteps().size());

		assertTrue(_s1.getExitSequence().getSteps().get(0) instanceof ExitState);

		assertCall(_s1.getExitSequence(), 1, _s1.getExitAction());
				
	}

	
	/**
	 * A composite state must have a exit sequence. 
	 * This exit sequence consists of an exit action call and a exit sequence call for each sub region.
	 */
	@Test public void testCompositeStateExitSequence() {
		Statechart sc = _createStatechart("cs"); {
			Scope scope = _createInterfaceScope("interface", sc);
			VariableDefinition v1 = _createVariableDefinition("v1", Type.INTEGER, scope);

			Region r = _createRegion("r", sc); {
				State s1 = _createState("s1", r); {
					_createExitAssignment(v1, s1, "1");
					Region r1_s1 = _createRegion("r1", s1); {
						Entry e = _createEntry(EntryKind.INITIAL, null, r1_s1);
						State s2 = _createState("s2", r1_s1);
						State s3 = _createState("s3", r1_s1);
						_createTransition(e, s2);
						_createTransition(s2, s3);
					}
					Region r2_s1 = _createRegion("r2", s1); {
						Entry e = _createEntry(EntryKind.INITIAL, null, r2_s1);
						State s4 = _createState("s4", r2_s1);
						State s5 = _createState("s5", r2_s1);
						State s6 = _createState("s6", r2_s1);
						_createTransition(e, s4);
					}
				}
			}
		}
		
	
		ExecutionFlow flow = sequencer.transform(sc);
		
		ExecutionState _s1 = flow.getStates().get(0);
		assertEquals("s1", _s1.getSimpleName());
		
		ExecutionState _s2 = flow.getStates().get(1);
		assertEquals("s2", _s2.getSimpleName());
		
		ExecutionState _s3 = flow.getStates().get(2);
		assertEquals("s3", _s3.getSimpleName());
		
		ExecutionState _s4 = flow.getStates().get(3);
		assertEquals("s4", _s4.getSimpleName());
		
		ExecutionState _s5 = flow.getStates().get(4);
		assertEquals("s5", _s5.getSimpleName());
		
		ExecutionState _s6 = flow.getStates().get(5);
		assertEquals("s6", _s6.getSimpleName());
		
		assertNotNull(_s1.getExitAction());
		assertNotNull(_s1.getExitSequence());
		assertEquals(3, _s1.getExitSequence().getSteps().size());
		
		assertStateSwitch(_s1.getExitSequence().getSteps().get(0), _s2, _s3);
		assertCall( assertedStateCase(_s1.getExitSequence().getSteps().get(0), _s2).getStep(), _s2.getExitSequence());
		assertCall( assertedStateCase(_s1.getExitSequence().getSteps().get(0), _s3).getStep(), _s3.getExitSequence());
		
		assertStateSwitch(_s1.getExitSequence().getSteps().get(1), _s4, _s5, _s6);
		assertCall( assertedStateCase(_s1.getExitSequence().getSteps().get(1), _s4).getStep(), _s4.getExitSequence());
		assertCall( assertedStateCase(_s1.getExitSequence().getSteps().get(1), _s5).getStep(), _s5.getExitSequence());
		assertCall( assertedStateCase(_s1.getExitSequence().getSteps().get(1), _s6).getStep(), _s6.getExitSequence());

		assertCall(_s1.getExitSequence(), 2, _s1.getExitAction());

	}


	

	@Test public void testStateReaction_SimpleFlatTSC() {
		SimpleFlatTSC tsc = new SimpleFlatTSC();
		
		ExecutionFlow flow = sequencer.transform(tsc.sc);

		// test state with one outgoing transition
		ExecutionState s1 = flow.getStates().get(0);
		ExecutionState s2 = flow.getStates().get(1);
		assertEquals(tsc.s1.getName(), s1.getSimpleName());
		assertEquals(tsc.s2.getName(), s2.getSimpleName());

		assertEquals(1, s1.getReactions().size());
		Reaction reaction = s1.getReactions().get(0);

		assertNotNull(reaction.getCheck());
		
		assertNotNull(reaction.getEffect());
		Sequence seq = (Sequence) reaction.getEffect();

		assertCall( seq, 0, s1.getExitSequence());
		assertCall( seq, 1, s2.getEnterSequence());		
	}
	
	
	/**
	 * The transition action must be part of the reaction effect sequence
	 */
	@Test public void testStateReaction_WithTransitionAction() {
		SimpleFlatTSC tsc = new SimpleFlatTSC();
		VariableDefinition v1 = _createVariableDefinition("v1", Type.INTEGER, tsc.s_scope);
		ReactionEffect effect = _createReactionEffect(tsc.t1);
		Assignment assign = _createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue("42"), effect); 
		
		ExecutionFlow flow = sequencer.transform(tsc.sc);

		// test state with one outgoing transition
		ExecutionState s1 = flow.getStates().get(0);
		ExecutionState s2 = flow.getStates().get(1);
		assertEquals(tsc.s1.getName(), s1.getSimpleName());
		assertEquals(tsc.s2.getName(), s2.getSimpleName());

		assertEquals(1, s1.getReactions().size());
		Reaction reaction = s1.getReactions().get(0);

		assertNotNull(reaction.getCheck());
		
		assertNotNull(reaction.getEffect());
		Sequence seq = (Sequence) reaction.getEffect();
		
		assertCall(seq, 0, s1.getExitSequence());
		
		assertTrue(seq.getSteps().get(1) instanceof Sequence);		
		Execution _exec = (Execution) ((Sequence)seq.getSteps().get(1)).getSteps().get(0);
		Assignment _assign = (Assignment) _exec.getStatement();
		assertNotSame(_assign, assign);
		assertNotSame(_assign.getVarRef(), assign.getVarRef());
		assertNotSame(_assign.getVarRef(), v1);
		
		assertCall( seq, 2, s2.getEnterSequence());
	}

		
	
	/**
	 * The exit action must be part of the reaction effect sequence
	 */
	@Test public void testStateReaction_WithExitAction() {
		SimpleFlatTSC tsc = new SimpleFlatTSC();

		VariableDefinition v1 = _createVariableDefinition("v1", Type.INTEGER, tsc.s_scope);
		LocalReaction exitAction = _createExitAction(tsc.s1);
		Assignment assign = _createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue("21"), (ReactionEffect) exitAction.getEffect());

		ExecutionFlow flow = sequencer.transform(tsc.sc);
		
		
		// test state with one outgoing transition
		ExecutionState _s1 = flow.getStates().get(0);
		ExecutionState _s2 = flow.getStates().get(1);
		assertEquals(tsc.s1.getName(), _s1.getSimpleName());
		assertEquals(tsc.s2.getName(), _s2.getSimpleName());

		assertEquals(1, _s1.getReactions().size());
		Reaction reaction = _s1.getReactions().get(0);

		assertNotNull(reaction.getCheck());
		
		assertNotNull(reaction.getEffect());
		Sequence seq = (Sequence) reaction.getEffect();

		assertCall(seq, 0, _s1.getExitSequence());
		assertCall(_s1.getExitSequence(), 1, _s1.getExitAction());			
	}
	
	
	/**
	 * The exit action must be part of the reaction effect sequence
	 */
	@Test public void testStateReaction_WithEntryAction() {
		SimpleFlatTSC tsc = new SimpleFlatTSC();

		VariableDefinition v1 = _createVariableDefinition("v1", Type.INTEGER, tsc.s_scope);
		LocalReaction entryAction = _createEntryAction(tsc.s2);
		Assignment assign = _createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue("21"), (ReactionEffect) entryAction.getEffect());

		
		ExecutionFlow flow = sequencer.transform(tsc.sc);
		
		
		// test state with one outgoing transition
		ExecutionState _s1 = flow.getStates().get(0);
		ExecutionState _s2 = flow.getStates().get(1);
		assertEquals(tsc.s1.getName(), _s1.getSimpleName());
		assertEquals(tsc.s2.getName(), _s2.getSimpleName());

		assertEquals(1, _s1.getReactions().size());
		Reaction reaction = _s1.getReactions().get(0);

		assertNotNull(reaction.getCheck());
		
		assertNotNull(reaction.getEffect());
		Sequence seq = (Sequence) reaction.getEffect();
		assertEquals(2,	seq.getSteps().size());


		assertCall(seq, 0, _s1.getExitSequence());
		assertCall(seq, 1, _s2.getEnterSequence());
		assertCall(_s2.getEnterSequence(), 0, _s2.getEntryAction());
	}
	

	@Test public void testStateCycle() {
		OrthogonalFlatTSC tsc = new OrthogonalFlatTSC();
		
		ExecutionFlow flow = sequencer.transform(tsc.sc);

		// test state with one outgoing transition
		ExecutionState s1 = flow.getStates().get(0);
		ExecutionState s2 = flow.getStates().get(1);
		assertEquals(tsc.s1.getName(), s1.getSimpleName());
		assertEquals(tsc.s2.getName(), s2.getSimpleName());
		assertNotNull(s1.getCycle());
		
		If _if = (If) s1.getCycle().getSteps().get(0);
		assertNotNull(_if.getThenStep());
		assertTrue(_if.getThenStep() instanceof Call);
		assertNull(_if.getElseStep());

		Call seq = (Call) _if.getThenStep();
		assertEquals(s1.getReactions().get(0).getEffect(), seq.getStep());
		
//		assertTrue(seq.getSteps().get(0) instanceof ExitState);
//		assertEquals(s1, ((ExitState)seq.getSteps().get(0)).getState());
//		assertTrue(seq.getSteps().get(1) instanceof EnterState);
//		assertEquals(s2, ((EnterState)seq.getSteps().get(1)).getState());
//
		
		// test state with two outgoing transitions
		ExecutionState s3 = flow.getStates().get(2);
		assertEquals(tsc.s3.getName(), s3.getSimpleName());
		assertNotNull(s3.getCycle());
		
		_if = (If) s3.getCycle().getSteps().get(0);
		assertNotNull(_if.getThenStep());
		assertTrue(_if.getThenStep() instanceof Call);
		assertNotNull(_if.getElseStep());
		assertTrue(_if.getElseStep() instanceof If);


	}
	

	@Test public void testStateCycle_WithLocalReactions() {
		SimpleFlatTSC tsc = new SimpleFlatTSC();

		VariableDefinition v1 = _createVariableDefinition("v1", Type.INTEGER, tsc.s_scope);

		// the first local reaction conforms to "e1 / x=42;" 
		LocalReaction lr1 = _createLocalReaction(tsc.s1, null);
		_createRegularEventSpec(tsc.e1, (ReactionTrigger) lr1.getTrigger());
		ReactionEffect lr1_eff = _createReactionEffect(lr1);
		Assignment assign1 = _createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue("42"), lr1_eff); 

		// the secont local reaction conforms to "e1 [x==42] / x=0;" 
		LocalReaction lr2 = _createLocalReaction(tsc.s1, null);
		_createRegularEventSpec(tsc.e1, (ReactionTrigger) lr2.getTrigger());
		LogicalRelationExpression lr2_equals = StextFactory.eINSTANCE.createLogicalRelationExpression();
		lr2_equals.setOperator(RelationalOperator.EQUALS);
		ElementReferenceExpression lr2_varRef = StextFactory.eINSTANCE.createElementReferenceExpression();
		lr2_varRef.setValue(v1);
		PrimitiveValueExpression lr2_value = _createValue("42");
		lr2_equals.setLeftOperand(lr2_varRef);
		lr2_equals.setRightOperand(lr2_value);
		((ReactionTrigger) lr2.getTrigger()).setGuardExpression(lr2_equals);
		ReactionEffect lr2_eff = _createReactionEffect(lr2);
		Assignment assign2 = _createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue("0"), lr2_eff); 

		// the third local reaction conforms to: "[x==0] / x=1;"
		LocalReaction lr3 = _createLocalReaction(tsc.s1, null);
		LogicalRelationExpression lr3_equals = StextFactory.eINSTANCE.createLogicalRelationExpression();
		lr3_equals.setOperator(RelationalOperator.EQUALS);
		ElementReferenceExpression lr3_varRef = StextFactory.eINSTANCE.createElementReferenceExpression();
		lr3_varRef.setValue(v1);
		PrimitiveValueExpression lr3_value = _createValue("0");
		lr3_equals.setLeftOperand(lr3_varRef);
		lr3_equals.setRightOperand(lr3_value);
		((ReactionTrigger) lr3.getTrigger()).setGuardExpression(lr3_equals);
		ReactionEffect lr3_eff = _createReactionEffect(lr3);
		Assignment assign3 = _createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue("1"), lr3_eff); 
		
		
		ExecutionFlow flow = sequencer.transform(tsc.sc);

		// test state with one outgoing transition
		ExecutionState s1 = flow.getStates().get(0);
		ExecutionState s2 = flow.getStates().get(1);
		assertEquals(tsc.s1.getName(), s1.getSimpleName());
		assertEquals(tsc.s2.getName(), s2.getSimpleName());
		
		assertEquals(4, s1.getReactions().size());
		
		assertNotNull(s1.getCycle());
		
		If _if = (If) s1.getCycle().getSteps().get(0);
		assertNotNull(_if.getThenStep());
		assertTrue(_if.getThenStep() instanceof Call);
		assertNotNull(_if.getElseStep());

		Sequence _seq = (Sequence) _if.getElseStep();
		assertEquals(3, _seq.getSteps().size());
		
		// check first local reaction
		If _lr1 = (If) _seq.getSteps().get(0);
		assertTrue(_lr1.getCheck().getCondition() instanceof ElementReferenceExpression);
		assertSame(s1.getReactions().get(1).getCheck().getCondition(), _lr1.getCheck().getCondition() );
		Call _lr1_eff_call = (Call) _lr1.getThenStep();
		assertSame(s1.getReactions().get(1).getEffect(), _lr1_eff_call.getStep() );
		
		// check second local reaction
		If _lr2 = (If) _seq.getSteps().get(1);
		assertTrue(_lr2.getCheck().getCondition() instanceof LogicalAndExpression);
		assertSame(s1.getReactions().get(2).getCheck().getCondition(), _lr2.getCheck().getCondition() );
		Call _lr2_eff_call = (Call) _lr2.getThenStep();
		assertSame(s1.getReactions().get(2).getEffect(), _lr2_eff_call.getStep() );

		// check the third local reaction
		If _lr3 = (If) _seq.getSteps().get(2);
		assertTrue(_lr3.getCheck().getCondition() instanceof LogicalRelationExpression);
		assertSame(s1.getReactions().get(3).getCheck().getCondition(), _lr3.getCheck().getCondition() );
		Call _lr3_eff_call = (Call) _lr3.getThenStep();
		assertSame(s1.getReactions().get(3).getEffect(), _lr3_eff_call.getStep() );
						
	}
	
	
	/**
	 * The cycle sequence of a state that only consists of local reactions includes sequential processing of the 
	 * local reactions.
	 */
	@Test public void testStateCycle_WithLocalReactionsOnly() {
		MinimalTSC tsc = new MinimalTSC();

		VariableDefinition v1 = _createVariableDefinition("v1", Type.INTEGER, tsc.s_scope);

		// the first local reaction conforms to "e1 / x=42;" 
		LocalReaction lr1 = _createLocalReaction(tsc.s1, null);
		_createRegularEventSpec(tsc.e1, (ReactionTrigger) lr1.getTrigger());
		ReactionEffect lr1_eff = _createReactionEffect(lr1);
		Assignment assign1 = _createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue("42"), lr1_eff); 

		// the secont local reaction conforms to "e1 [x==42] / x=0;" 
		LocalReaction lr2 = _createLocalReaction(tsc.s1, null);
		_createRegularEventSpec(tsc.e1, (ReactionTrigger) lr2.getTrigger());
		LogicalRelationExpression lr2_equals = StextFactory.eINSTANCE.createLogicalRelationExpression();
		lr2_equals.setOperator(RelationalOperator.EQUALS);
		ElementReferenceExpression lr2_varRef = StextFactory.eINSTANCE.createElementReferenceExpression();
		lr2_varRef.setValue(v1);
		PrimitiveValueExpression lr2_value = _createValue("42");
		lr2_equals.setLeftOperand(lr2_varRef);
		lr2_equals.setRightOperand(lr2_value);
		((ReactionTrigger) lr2.getTrigger()).setGuardExpression(lr2_equals);
		ReactionEffect lr2_eff = _createReactionEffect(lr2);
		Assignment assign2 = _createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue("0"), lr2_eff); 

		// the third local reaction conforms to: "[x==0] / x=1;"
		LocalReaction lr3 = _createLocalReaction(tsc.s1, null);
		LogicalRelationExpression lr3_equals = StextFactory.eINSTANCE.createLogicalRelationExpression();
		lr3_equals.setOperator(RelationalOperator.EQUALS);
		ElementReferenceExpression lr3_varRef = StextFactory.eINSTANCE.createElementReferenceExpression();
		lr3_varRef.setValue(v1);
		PrimitiveValueExpression lr3_value = _createValue("0");
		lr3_equals.setLeftOperand(lr3_varRef);
		lr3_equals.setRightOperand(lr3_value);
		((ReactionTrigger) lr3.getTrigger()).setGuardExpression(lr3_equals);
		ReactionEffect lr3_eff = _createReactionEffect(lr3);
		Assignment assign3 = _createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue("1"), lr3_eff); 
		
		
		ExecutionFlow flow = sequencer.transform(tsc.sc);

		// test state with one outgoing transition
		ExecutionState s1 = flow.getStates().get(0);
		assertEquals(tsc.s1.getName(), s1.getSimpleName());
		
		assertEquals(3, s1.getReactions().size());
		
		assertNotNull(s1.getCycle());
		

		Sequence _seq = (Sequence) s1.getCycle().getSteps().get(0);
		assertEquals(3, _seq.getSteps().size());
		
		// check first local reaction
		If _lr1 = (If) _seq.getSteps().get(0);
		assertTrue(_lr1.getCheck().getCondition() instanceof ElementReferenceExpression);
		assertSame(s1.getReactions().get(0).getCheck().getCondition(), _lr1.getCheck().getCondition() );
		Call _lr1_eff_call = (Call) _lr1.getThenStep();
		assertSame(s1.getReactions().get(0).getEffect(), _lr1_eff_call.getStep() );
		
		// check second local reaction
		If _lr2 = (If) _seq.getSteps().get(1);
		assertTrue(_lr2.getCheck().getCondition() instanceof LogicalAndExpression);
		assertSame(s1.getReactions().get(1).getCheck().getCondition(), _lr2.getCheck().getCondition() );
		Call _lr2_eff_call = (Call) _lr2.getThenStep();
		assertSame(s1.getReactions().get(1).getEffect(), _lr2_eff_call.getStep() );

		// check the third local reaction
		If _lr3 = (If) _seq.getSteps().get(2);
		assertTrue(_lr3.getCheck().getCondition() instanceof LogicalRelationExpression);
		assertSame(s1.getReactions().get(2).getCheck().getCondition(), _lr3.getCheck().getCondition() );
		Call _lr3_eff_call = (Call) _lr3.getThenStep();
		assertSame(s1.getReactions().get(2).getEffect(), _lr3_eff_call.getStep() );
		
					
	}

	/** Entry action behaviors are not directly part of the states cycle steps */
	@Test public void testStateCycle_EntryActionExclusion() {
		MinimalTSC tsc = new MinimalTSC();

		VariableDefinition v1 = _createVariableDefinition("v1", Type.INTEGER, tsc.s_scope);

		// add a simple entry action: "entry / x=42;" 
		LocalReaction lr = _createEntryAction(tsc.s1);
		ReactionEffect lr_eff = _createReactionEffect(lr);
		Assignment assign1 = _createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue("42"), lr_eff); 

		
		// TRANSFORM
		ExecutionFlow flow = sequencer.transform(tsc.sc);

		
		// test state with one outgoing transition
		ExecutionState s1 = flow.getStates().get(0);
		
		assertEquals(0, s1.getReactions().size());		
		assertNotNull(s1.getCycle());
		assertEquals(0, s1.getCycle().getSteps().size());		
	}

	
	/** Exit action behaviors are not directly part of the states cycle steps */
	@Test public void testStateCycle_ExitActionExclusion() {
		MinimalTSC tsc = new MinimalTSC();

		VariableDefinition v1 = _createVariableDefinition("v1", Type.INTEGER, tsc.s_scope);

		// add a simple entry action: "entry / x=42;" 
		LocalReaction lr = _createExitAction(tsc.s1);
		ReactionEffect lr_eff = _createReactionEffect(lr);
		Assignment assign1 = _createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue("42"), lr_eff); 

		
		// TRANSFORM
		ExecutionFlow flow = sequencer.transform(tsc.sc);

		
		// test state with one outgoing transition
		ExecutionState s1 = flow.getStates().get(0);
		
		assertEquals(0, s1.getReactions().size());		
		assertNotNull(s1.getCycle());
		assertEquals(0, s1.getCycle().getSteps().size());		
	}


	/** Local reactions that define regular and entry triggers side by side must also be part of the cycle steps. */
	@Test public void testStateCycle_LocalReactionWithMixedRegularAndEntryTrigger() {
		MinimalTSC tsc = new MinimalTSC();

		VariableDefinition v1 = _createVariableDefinition("v1", Type.INTEGER, tsc.s_scope);

		// add a simple entry action: "entry / x=42;" 
		LocalReaction lr = _createEntryAction(tsc.s1);
		_createRegularEventSpec(tsc.e1, (ReactionTrigger) lr.getTrigger());
		ReactionEffect lr_eff = _createReactionEffect(lr);
		Assignment assign1 = _createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue("42"), lr_eff); 

		
		// TRANSFORM
		ExecutionFlow flow = sequencer.transform(tsc.sc);

		
		// test state with one outgoing transition
		ExecutionState s1 = flow.getStates().get(0);
		
		assertEquals(1, s1.getReactions().size());		
		assertNotNull(s1.getCycle());
		assertEquals(1, s1.getCycle().getSteps().size());	
	
		Sequence _seq = (Sequence) s1.getCycle().getSteps().get(0);
		
		If _lr1 = (If) _seq.getSteps().get(0);
		assertTrue(_lr1.getCheck().getCondition() instanceof ElementReferenceExpression);
		assertSame(s1.getReactions().get(0).getCheck().getCondition(), _lr1.getCheck().getCondition() );
		Call _lr1_eff_call = (Call) _lr1.getThenStep();
		assertSame(s1.getReactions().get(0).getEffect(), _lr1_eff_call.getStep() );

	}

	
}
