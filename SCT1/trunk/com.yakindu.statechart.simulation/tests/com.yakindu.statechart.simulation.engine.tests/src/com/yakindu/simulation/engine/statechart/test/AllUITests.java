/**
 * Copyright (c) 2009 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package com.yakindu.simulation.engine.statechart.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.yakindu.simulation.engine.statechart.test.testclasses.Test_Heater_controlled;
import com.yakindu.simulation.engine.statechart.test.testclasses.Test_House;
import com.yakindu.simulation.engine.statechart.test.testclasses.Test_SendAfter;
import com.yakindu.simulation.engine.statechart.test.testclasses.Test_StatechartSimulator;
import com.yakindu.simulation.engine.statechart.test.testclasses.engine.Test_SCEngine;
import com.yakindu.simulation.engine.statechart.test.testclasses.engine.Test_SCSimulator;
import com.yakindu.simulation.engine.statechart.test.testclasses.engine.Test_SCSimulatorController;
import com.yakindu.simulation.engine.statechart.test.testclasses.engine.Test_SCSimulator_ChangeStateConfiguration;
import com.yakindu.simulation.engine.statechart.test.testclasses.engine.Test_SCSimulator_Initialization;
import com.yakindu.simulation.engine.statechart.test.testclasses.engine.Test_SCSupportVerifier;
import com.yakindu.simulation.engine.statechart.test.testclasses.engine.utilities.Test_TransitionExt;
import com.yakindu.simulation.engine.statechart.test.testclasses.engine.utilities.calculation.Test_MathFunctionCalculator;
import com.yakindu.simulation.engine.statechart.test.testclasses.engine.utilities.calculation.Test_Parser;
import com.yakindu.simulation.engine.statechart.test.testclasses.engine.utilities.scheduling.Test_TimeEventScheduler;

@RunWith(value=Suite.class)
@SuiteClasses(value={
		Test_Heater_controlled.class,
		Test_House.class,
		Test_MathFunctionCalculator.class,
		Test_Parser.class,
		Test_SCEngine.class,
		Test_SCSimulator.class,
		Test_SCSimulator_ChangeStateConfiguration.class,
		Test_SCSimulator_Initialization.class,
		Test_SCSimulatorController.class,
		Test_SCSupportVerifier.class,
		Test_SendAfter.class,
		Test_StatechartSimulator.class,
		Test_TimeEventScheduler.class,
		Test_TransitionExt.class,
})
public class AllUITests {

}
