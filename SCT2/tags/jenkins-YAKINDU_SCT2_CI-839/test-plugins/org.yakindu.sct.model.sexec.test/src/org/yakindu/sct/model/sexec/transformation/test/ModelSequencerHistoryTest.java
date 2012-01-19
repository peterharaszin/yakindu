package org.yakindu.sct.model.sexec.transformation.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.TYPE_INTEGER;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createEntry;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createEntryAssignment;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createInterfaceScope;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createRegion;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createState;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createStatechart;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createTransition;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createVariableDefinition;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.findState;

import org.eclipse.emf.common.util.EList;
import org.junit.Test;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionNode;
import org.yakindu.sct.model.sexec.ExecutionRegion;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.Reaction;
import org.yakindu.sct.model.sexec.SaveHistory;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.Step;
import org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.MinimalTSC;
import org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.InitializingTSC;
import org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.OrthogonalFlatTSC;
import org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.SimpleFlatTSC;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.EntryKind;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.stext.stext.AssignmentOperator;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

public class ModelSequencerHistoryTest extends ModelSequencerTest {

	@Test
	public void testFlowName() {
		Statechart sc = _createStatechart("sc");
		{

			InterfaceScope s_scope = _createInterfaceScope("Interface", sc);
			VariableDefinition v1 = _createVariableDefinition("v1",
					TYPE_INTEGER, s_scope);

			Region r = _createRegion("r", sc);
			{
				Entry r_entry = _createEntry(EntryKind.INITIAL, null, r);
				State s1 = _createState("s1", r);
				State s2 = _createState("s2", r);
				{

					Region r2 = _createRegion("r2", s2);
					{
						Entry r2_entry1 = _createEntry(
								EntryKind.SHALLOW_HISTORY, null, r2);
						Entry r2_entry2 = _createEntry(EntryKind.INITIAL,
								"Unused_Backup", r2);
						State s3 = _createState("s3", r2);
						State s4 = _createState("s4", r2);
						_createTransition(r2_entry1, s3);
						_createTransition(r2_entry2, s4);
						_createTransition(s1, r2_entry1);
					}

				}
				_createTransition(s1, s2);
				Transition _t = _createTransition(s1, s2);
				_createTransition(r_entry, s1);
			}
		}

		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionState _s1 = flow.getStates().get(0);
		assertEquals("sc.r.s1", _s1.getName());
		ExecutionState _s2 = flow.getStates().get(1);
		assertEquals("sc.r.s2", _s2.getName());
		ExecutionState _s3 = flow.getStates().get(2);
		assertEquals("sc.r.s2.r2.s3", _s3.getName());
		ExecutionState _s4 = flow.getStates().get(3);
		assertEquals("sc.r.s2.r2.s4", _s4.getName());
		ExecutionNode r2_history_entry = flow.getNodes().get(1);

		EList<Reaction> _t1 = _s1.getReactions();
		Sequence reactSequence_history = flow.getNodes().get(1)
				.getReactSequence();
		assertCall(reactSequence_history, 0, _s3.getEnterSequence());
		Reaction reaction_history = _t1.get(0);
		assertCall(assertedSequence(reaction_history.getEffect()), 1,
				reactSequence_history);

		Sequence reactSequence_initial = flow.getNodes().get(2)
				.getReactSequence();
		assertCall(reactSequence_initial, 0, _s4.getEnterSequence());
		Reaction reaction = _t1.get(1);
		assertCall(assertedSequence(reaction.getEffect()), 1,
				_s2.getEnterSequence());

		assertCall(_s3.getSuperScope().getEnterSequence(), 0,
				r2_history_entry.getReactSequence());

		Step saveStep = _s3.getSuperScope().getExitSequence().getSteps().get(0);
		assertTrue(saveStep.eClass().toString(),
				saveStep instanceof SaveHistory);
	}
}
