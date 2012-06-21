package org.yakindu.sct.generator.java.runtime.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.yakindu.sct.generator.java.runtime.cyclebased.test_hierarchy.Test_HierarchyStatemachine;
import org.yakindu.sct.generator.java.runtime.cyclebased.test_parallelregions.Test_ParallelRegionsStatemachine;

public class StatemachinePerformanceTest {

	// @Test public void testPerformance_ParallelRegions() throws Exception{
	//
	// final Test_ParallelRegionsCycleBasedStatemachine sm_1 = new
	// Test_ParallelRegionsCycleBasedStatemachine();
	// final DefaultInterface di = sm_1.getDefaultInterface();
	// sm_1.init();
	// sm_1.enter();
	//
	// class TestRunnable implements Runnable {
	// public boolean stop = false;
	// public boolean stopped = false;
	// public long cycles = 0;
	//
	// public void run() {
	// while (!stop) {
	//
	// di.raiseEvent1();
	// sm_1.runCycle();
	// cycles ++;
	// assertTrue(sm_1.isStateActive(Test_ParallelRegionsCycleBasedStatemachine.State.State3));
	// assertTrue(sm_1.isStateActive(Test_ParallelRegionsCycleBasedStatemachine.State.State7));
	//
	// di.raiseEvent10();
	// sm_1.runCycle();
	// cycles ++;
	// assertTrue(sm_1.isStateActive(Test_ParallelRegionsCycleBasedStatemachine.State.State1));
	//
	// di.raiseEvent12();
	// sm_1.runCycle();
	// cycles ++;
	// assertTrue(sm_1.isStateActive(Test_ParallelRegionsCycleBasedStatemachine.State.State8));
	//
	// di.raiseEvent2();
	// sm_1.runCycle();
	// cycles ++;
	//
	// di.raiseEvent6();
	// sm_1.runCycle();
	// cycles ++;
	//
	// di.raiseEvent7();
	// sm_1.runCycle();
	// cycles ++;
	// assertTrue(sm_1.isStateActive(Test_ParallelRegionsCycleBasedStatemachine.State.State1));
	//
	// }
	// stopped = true;
	// }
	//
	// };
	//
	// TestRunnable run = new TestRunnable();
	// Thread thread = new Thread(run);
	//
	// System.out.println( ">>  " + run.cycles );
	//
	// long start = System.currentTimeMillis();
	// thread.start();
	// Thread.sleep(20000);
	// run.stop = true;
	// while (!run.stopped) { Thread.sleep(10); }
	// long stop = System.currentTimeMillis();
	//
	// System.out.println( "executed " + run.cycles + " in " + (stop - start) +
	// "ms .");
	// }

	@Test
	public void testPerformance_ParallelRegions_() throws Exception {

		final Test_ParallelRegionsStatemachine sm_1 = new Test_ParallelRegionsStatemachine();
		sm_1.init();
		sm_1.enter();

		class CycleRunner extends SMRunner {

			public void runCycles() {

				sm_1.raiseEvent1();
				sm_1.runCycle();
				cycles++;
				assertTrue(sm_1
						.isStateActive(Test_ParallelRegionsStatemachine.State.MainRegion_State2_Region1_State3));
				assertTrue(sm_1
						.isStateActive(Test_ParallelRegionsStatemachine.State.MainRegion_State2_Region3_State7));

				sm_1.raiseEvent10();
				sm_1.runCycle();
				cycles++;
				assertTrue(sm_1
						.isStateActive(Test_ParallelRegionsStatemachine.State.MainRegion_State1));

				sm_1.raiseEvent12();
				sm_1.runCycle();
				cycles++;
				assertTrue(sm_1
						.isStateActive(Test_ParallelRegionsStatemachine.State.MainRegion_State2_Region3_State8));

				sm_1.raiseEvent2();
				sm_1.runCycle();
				cycles++;

				sm_1.raiseEvent6();
				sm_1.runCycle();
				cycles++;

				sm_1.raiseEvent7();
				sm_1.runCycle();
				cycles++;
				assertTrue(sm_1
						.isStateActive(Test_ParallelRegionsStatemachine.State.MainRegion_State1));
			}

		}
		;

		CycleRunner run = new CycleRunner();
		run.test("ParallelRegions", 1);
		run.test("ParallelRegions", 10);
		run.test("ParallelRegions", 100);
		run.test("ParallelRegions", 1000);
		run.test("ParallelRegions", 10000);
	}

//	@Test
//	public void testPerformance_Mix() throws Exception {
//
//		final Test_HierarchyCycleBasedStatemachine sm = new Test_HierarchyCycleBasedStatemachine();
//		final Test_ParallelRegionsCycleBasedStatemachine sm_1 = new Test_ParallelRegionsCycleBasedStatemachine();
//		sm_1.init();
//		sm_1.enter();
//		final DefaultInterface di_1 = sm_1.getDefaultInterface();
//
//		sm.init();
//		sm.enter();
//		final org.yakindu.sct.runtime.java.test_hierarchy.DefaultInterface di = sm
//				.getDefaultInterface();
//
//		class TestRunner extends SMRunner {
//
//			public void runCycles() {
//
//				di.raiseEvent1();
//				sm.runCycle();
//				cycles++;
//				assertTrue(sm.isStateActive(State.State3));
//
//				di.raiseEvent2();
//				sm.runCycle();
//				cycles++;
//				assertTrue(sm.isStateActive(State.State5));
//
//				di.raiseEvent3();
//				sm.runCycle();
//				cycles++;
//				assertTrue(sm.isStateActive(State.State7));
//
//				di.raiseEvent4();
//				sm.runCycle();
//				assertTrue(sm.isStateActive(State.State8));
//				cycles++;
//
//				di.raiseEvent5();
//				sm.runCycle();
//				assertTrue(sm.isStateActive(State.State7));
//				cycles++;
//
//				di.raiseEvent6();
//				sm.runCycle();
//				cycles++;
//				assertTrue(sm.isStateActive(State.State9));
//
//			}
//
//		}
//		;
//
//		class CycleRunner extends SMRunner {
//
//			public void runCycles() {
//
//				di_1.raiseEvent1();
//				sm_1.runCycle();
//				cycles++;
////				assertTrue(sm_1
////						.isStateActive(Test_ParallelRegionsCycleBasedStatemachine.State.State3));
////				assertTrue(sm_1
////						.isStateActive(Test_ParallelRegionsCycleBasedStatemachine.State.State7));
//
//				di_1.raiseEvent10();
//				sm_1.runCycle();
//				cycles++;
////				assertTrue(sm_1
////						.isStateActive(Test_ParallelRegionsCycleBasedStatemachine.State.State1));
//
//				di_1.raiseEvent12();
//				sm_1.runCycle();
//				cycles++;
////				assertTrue(sm_1
////						.isStateActive(Test_ParallelRegionsCycleBasedStatemachine.State.State8));
//
//				di_1.raiseEvent2();
//				sm_1.runCycle();
//				cycles++;
//
//				di_1.raiseEvent6();
//				sm_1.runCycle();
//				cycles++;
//
//				di_1.raiseEvent7();
//				sm_1.runCycle();
//				cycles++;
////				assertTrue(sm_1
////						.isStateActive(Test_ParallelRegionsCycleBasedStatemachine.State.State1));
//			}
//
//		}
//		;
//
//		TestRunner runner = new TestRunner();
//		CycleRunner runner_2 = new CycleRunner();
//		
//		runner.test("Test_Hierarchy..", 1);
//		runner_2.test("ParallelRegions", 1);
//		runner.test("Test_Hierarchy..", 10);
//		runner_2.test("ParallelRegions", 10);
//		runner.test("Test_Hierarchy..", 100);
//		runner_2.test("ParallelRegions", 100);
//		runner.test("Test_Hierarchy..", 1000);
//		runner_2.test("ParallelRegions", 1000);
//		runner.test("Test_Hierarchy..", 10000);
//		runner_2.test("ParallelRegions", 10000);
//	}

	@Test
	public void testPerformance_Hierarchy() throws Exception {

		final Test_HierarchyStatemachine sm = new Test_HierarchyStatemachine();

		sm.init();
		sm.enter();

		class TestRunner extends SMRunner {

			public void runCycles() {

				sm.raiseEvent1();
				sm.runCycle();
				cycles++;
				assertTrue(sm.isStateActive(Test_HierarchyStatemachine.State.MainRegion_State2_Region2_State3));

				sm.raiseEvent2();
				sm.runCycle();
				cycles++;
				assertTrue(sm.isStateActive(Test_HierarchyStatemachine.State.MainRegion_State2_Region2_State4_Region4_State5));

				sm.raiseEvent3();
				sm.runCycle();
				cycles++;
				assertTrue(sm.isStateActive(Test_HierarchyStatemachine.State.MainRegion_State2_Region2_State4_Region4_State6_Region6_State7));

				sm.raiseEvent4();
				sm.runCycle();
				assertTrue(sm.isStateActive(Test_HierarchyStatemachine.State.MainRegion_State2_Region2_State4_Region4_State6_Region6_State8));
				cycles++;

				sm.raiseEvent5();
				sm.runCycle();
				assertTrue(sm.isStateActive(Test_HierarchyStatemachine.State.MainRegion_State2_Region2_State4_Region4_State6_Region6_State7));
				cycles++;

				sm.raiseEvent6();
				sm.runCycle();
				cycles++;
				assertTrue(sm.isStateActive(Test_HierarchyStatemachine.State.MainRegion_State1_Region1_State9));

			}

		}
		;

		TestRunner runner = new TestRunner();
		runner.test("Test_Hierarchy..", 1);
		runner.test("Test_Hierarchy..", 10);
		runner.test("Test_Hierarchy..", 100);
		runner.test("Test_Hierarchy..", 1000);
		runner.test("Test_Hierarchy..", 10000);
	}

	static abstract class SMRunner implements Runnable {
		public boolean stop;
		public boolean started;
		public boolean stopped;
		public long cycles;
		public long t_start;
		public long t_stop;

		public void run() {
			cycles = 0;
			t_start = System.nanoTime();
			t_stop = 0;

			while (!stop) {
				started = true;
				runCycles();
			}

			stopped = true;
			t_stop = System.nanoTime();
		}

		public abstract void runCycles();

		public void test(String name, long millis) throws Exception {
			Thread thread = new Thread(this);

			System.out.print("run " + name + " for " + millis + "ms > ");

			stop = false;
			stopped = false;
			started = false;

			thread.start();
			while (!thread.isAlive() && started) {
				Thread.sleep(1);
			}

			Thread.sleep(millis);
			stop = true;

			while (thread.isAlive()) {
				Thread.sleep(10);
			}

			long t = t_stop - t_start;
			System.out.println("processd " + cycles + " cycles in "
					+ (t / 1000000) + "." + (t % 1000000) + "ms >> "
					+ (t / cycles) + "ns/cycle >> "
					+ ((long) (((double) cycles) / ((double) t / 1000000)))
					+ " cycles/ms");

		}
	};
}
