package org.yakindu.sct.model.sexec.transformation.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
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

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.junit.Test;
import org.yakindu.sct.model.sexec.ExecutionEntry;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionNode;
import org.yakindu.sct.model.sexec.ExecutionRegion;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.HistoryEntry;
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

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class HistoryTest extends ModelSequencerTest {

	@Test
	public void testTransitionSave() {
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
					_createEntryAssignment(v1, s2, 3);
					Region r2 = _createRegion("r2", s2);
					{
						Entry e = _createEntry(EntryKind.INITIAL, null, r2);
						Entry history = _createEntry(EntryKind.SHALLOW_HISTORY,
								"history", r2);

						State s3 = _createState("s3", r2);
						{
							_createEntryAssignment(v1, s3, 4);
						}
						State s4 = _createState("s4", r2);
						{
							Region r4 = _createRegion("r4", s4);
							{
								Entry e4 = _createEntry(EntryKind.INITIAL,
										null, r2);
								State s5 = _createState("s5", r4);
								_createTransition(e4, s5);
								_createTransition(s5, s1);
							}
						}
						_createTransition(e, s3);
						_createTransition(history, s3);
						_createTransition(s3, s4);
						_createTransition(s1, history);
					}
				}
				_createTransition(r_entry, s1);
				_createTransition(s1, s2);
			}
		}

		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionState _s2 = flow.getStates().get(1);
		assertEquals("sc.r.s2", _s2.getName());
		ExecutionState _s3 = flow.getStates().get(2);
		assertEquals("sc.r.s2.r2.s3", _s3.getName());
		ExecutionState _s4 = flow.getStates().get(3);
		assertEquals("sc.r.s2.r2.s4", _s4.getName());
		ExecutionState _s5 = flow.getStates().get(4);
		assertEquals("sc.r.s2.r2.s4.r4.s5", _s5.getName());
		ExecutionNode e = flow.getNodes().get(2);
		assertTrue(e.eClass().getName(), e instanceof ExecutionEntry);
		Reaction regionLeave = _s5.getReactions().get(0);
		Sequence sequence = assertedSequence(regionLeave.getEffect());
		assertCall(sequence, 0, _s2.getExitSequence());
		assertClass(SaveHistory.class, _s3.getSuperScope().getExitSequence()
				.getSteps().get(0));

	}

	@Test
	public void testShallowHistory() {
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
					_createEntryAssignment(v1, s2, 3);
					Region r2 = _createRegion("r2", s2);
					{
						Entry e = _createEntry(EntryKind.INITIAL, null, r2);
						Entry history = _createEntry(EntryKind.SHALLOW_HISTORY,
								"history", r2);

						State s3 = _createState("s3", r2);
						{
							_createEntryAssignment(v1, s3, 4);
						}
						State s4 = _createState("s4", r2);
						{
							Region r4 = _createRegion("r4", s4);
							{
								Entry e4 = _createEntry(EntryKind.INITIAL,
										null, r2);
								State s5 = _createState("s5", r4);
								_createTransition(e4, s5);
								_createTransition(s5, s1);
							}
						}
						_createTransition(e, s3);
						_createTransition(history, s3);
						_createTransition(s3, s4);
						_createTransition(s1, history);
					}
				}
				_createTransition(r_entry, s1);
				_createTransition(s1, s2);
			}
		}

		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionState _s3 = flow.getStates().get(2);
		assertEquals("sc.r.s2.r2.s3", _s3.getName());
		ExecutionState _s4 = flow.getStates().get(3);
		assertEquals("sc.r.s2.r2.s4", _s4.getName());
		ExecutionState _s5 = flow.getStates().get(4);
		assertEquals("sc.r.s2.r2.s4.r4.s5", _s5.getName());
		ExecutionNode e = flow.getNodes().get(2);
		assertTrue(e.eClass().getName(), e instanceof ExecutionEntry);

		Sequence reactSequence = e.getReactSequence();

		assertEquals(
				"Default react sequence for shallow history entry history",
				reactSequence.getComment());
		Step historyEntry = reactSequence.getSteps().get(0);
		assertTrue(historyEntry.eClass().getName(),
				historyEntry instanceof HistoryEntry);

		assertedOrder(reactSequence, Sets.newHashSet(_s3), Lists.newArrayList(//
				new StepHistory(historyEntry, false), //
				new StepLeaf(_s3.getEnterSequence()) //
				));
		assertedOrder(reactSequence, Sets.newHashSet(_s3), Lists.newArrayList(//
				new StepHistory(historyEntry, true), //
				new StepLeaf(_s3.getEnterSequence()) //
				));
		assertedOrder(reactSequence, Sets.newHashSet(_s5), Lists.newArrayList(//
				new StepHistory(historyEntry, true), //
				new StepLeaf(_s4.getEnterSequence()) //
				));
	}

	@Test
	public void testDeepHistory() {
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
					_createEntryAssignment(v1, s2, 3);
					Region r2 = _createRegion("r2", s2);
					{
						Entry e = _createEntry(EntryKind.INITIAL, null, r2);
						Entry history = _createEntry(EntryKind.DEEP_HISTORY,
								"history", r2);

						State s3 = _createState("s3", r2);
						{
							_createEntryAssignment(v1, s3, 4);
						}
						State s4 = _createState("s4", r2);
						{
							_createEntryAssignment(v1, s4, 6);
							Region r4 = _createRegion("r4", s4);
							{
								Entry e4 = _createEntry(EntryKind.INITIAL,
										null, r2);
								State s5 = _createState("s5", r4);
								_createTransition(e4, s5);
							}
						}
						_createTransition(e, s3);
						_createTransition(history, s3);
						_createTransition(s3, s4);
						_createTransition(s1, history);
					}
				}
				_createTransition(r_entry, s1);
				_createTransition(s1, s2);
			}
		}

		ExecutionFlow flow = sequencer.transform(sc);

		ExecutionState _s3 = flow.getStates().get(2);
		assertEquals("sc.r.s2.r2.s3", _s3.getName());
		ExecutionState _s4 = flow.getStates().get(3);
		assertEquals("sc.r.s2.r2.s4", _s4.getName());
		ExecutionState _s5 = flow.getStates().get(4);
		assertEquals("sc.r.s2.r2.s4.r4.s5", _s5.getName());
		ExecutionNode e = flow.getNodes().get(2);
		assertTrue(e.eClass().getName(), e instanceof ExecutionEntry);

		Sequence reactSequence = e.getReactSequence();

		assertEquals("Default react sequence for deep history entry history",
				reactSequence.getComment());
		Step historyEntry = reactSequence.getSteps().get(0);
		assertTrue(historyEntry.eClass().getName(),
				historyEntry instanceof HistoryEntry);

		assertedOrder(reactSequence, Sets.newHashSet(_s3), Lists.newArrayList(//
				new StepHistory(historyEntry, false), //
				new StepLeaf(_s3.getEnterSequence()) //
				));
		assertedOrder(reactSequence, Sets.newHashSet(_s3), Lists.newArrayList(//
				new StepHistory(historyEntry, true), //
				new StepLeaf(_s3.getEnterSequence()) //
				));
		assertedOrder(reactSequence, Sets.newHashSet(_s5), Lists.newArrayList(//
				new StepHistory(historyEntry, true), //
				new StepLeaf(_s4.getEntryAction()),//
				new StepLeaf(_s5.getEnterSequence()) //
				));
		// assertCall(assertedSequence(tr0.getEffect()), 0,
		// _s2.getEnterSequence());
	}

	public void testNoHistory() {
		SimpleFlatTSC sc = new SCTTestUtil.SimpleFlatTSC();
		ExecutionFlow flow = sequencer.transform(sc.sc);
		assertNull(flow.getHistoryVector());
	}
}
