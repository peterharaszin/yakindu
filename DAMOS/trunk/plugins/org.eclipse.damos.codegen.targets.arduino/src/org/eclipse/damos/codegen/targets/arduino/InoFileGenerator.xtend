package org.eclipse.damos.codegen.targets.arduino

import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.damos.codegen.c.IGeneratorContext
import static extension org.eclipse.damos.codegen.c.util.GeneratorConfigurationExtensions.*

class InoFileGenerator {
	
	def generate(IGeneratorContext context, IProgressMonitor monitor) {
		val prefix = context.configuration.prefix
		val systemHeaderFile = context.configuration.systemHeaderFile
		val singleton = context.configuration.singleton
		
		val fundamentalSampleTime = context.executionFlow.fundamentalSampleTime
		val micro = fundamentalSampleTime <= 0.01
		val stepSize = Math::round(fundamentalSampleTime * (if (micro) 1000000 else 1000))
		
		'''
			#include "«systemHeaderFile»"
			
			«IF !singleton»
				static «prefix»Context «prefix»context;
			«ENDIF»
			static unsigned long «prefix»time;
			
			void setup() {
				«prefix»initialize(«IF !singleton»&«prefix»context«ENDIF»);
				«prefix»time = «IF micro»micros«ELSE»millis«ENDIF»();
			}
			
			void loop() {
				«prefix»execute(«IF !singleton»&«prefix»context«ENDIF»);
				
				«prefix»time += «stepSize»UL;
				
				// Delay system, if necessary
				unsigned long delayTime = «prefix»time - «IF micro»micros«ELSE»millis«ENDIF»();
				if (delayTime > «stepSize»UL) {
					delayTime += ~(0UL);
				}
				if (delayTime <= «stepSize»UL) {
					«IF micro»delayMicroseconds«ELSE»delay«ENDIF»(delayTime);
				}
			}
		'''
	}
	
}
