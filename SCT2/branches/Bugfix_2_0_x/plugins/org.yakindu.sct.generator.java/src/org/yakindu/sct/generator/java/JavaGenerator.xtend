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
import org.yakindu.sct.generator.core.impl.IExecutionFlowGenerator
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry

/**
 * This is the Java code generators main class. 
 * 
 * @author Markus Mühlbrandt
 */
class JavaGenerator implements IExecutionFlowGenerator {

	@Inject extension Navigation
	@Inject extension IStatemachine
	@Inject extension ITimedStatemachine
	@Inject extension ITimerService
	@Inject extension TimeEventTemplate
	@Inject extension TimerService
	@Inject extension GenmodelEntries
	@Inject extension RuntimeService
	@Inject extension StatemachineInterface
	@Inject extension Statemachine
 	
	override generate(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa) {

		flow.generateIStatemachine(entry, fsa)
		
		if (flow.timed) {
			flow.generateITimedStatemachine(entry, fsa)
			flow.generateITimerService(entry, fsa)
			flow.generateTimeEvent(entry, fsa)
			if (entry.createTimerService) {
				flow.generateTimerService(entry, fsa);
			}
		}
		
		if (entry.createRuntimeService) {
			flow.generateRuntimeService(entry, fsa)
		}
		
		flow.generateStatemachineInterface(entry, fsa)
		flow.generateStatemachine(entry, fsa)
	}
}