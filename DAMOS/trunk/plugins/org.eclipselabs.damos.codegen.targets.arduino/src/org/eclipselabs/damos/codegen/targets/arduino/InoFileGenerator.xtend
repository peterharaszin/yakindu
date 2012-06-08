package org.eclipselabs.damos.codegen.targets.arduino

import org.eclipse.core.runtime.IProgressMonitor
import org.eclipselabs.damos.codegen.c.IGeneratorContext
import org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationUtil

class InoFileGenerator {
	
	def generate(IGeneratorContext context, IProgressMonitor monitor) {
		val prefix = GeneratorConfigurationUtil::getPrefix(context.configuration)
		val systemHeaderFile = GeneratorConfigurationUtil::getSystemHeaderFile(context.configuration)
		
		val fundamentalSampleTime = context.executionFlow.fundamentalSampleTime
		val micro = fundamentalSampleTime <= 0.01
		val stepSize = Math::round(fundamentalSampleTime * (if (micro) 1000000 else 1000))
		
		'''
			#include "«systemHeaderFile»"
			
			unsigned long Damos_time;
			
			void setup() {
				«prefix»initialize();
				Damos_time = «IF micro»micros«ELSE»millis«ENDIF»();
			}
			
			void loop() {
				«prefix»execute();
				
				Damos_time += «stepSize»UL;
				
				// Delay system, if necessary
				unsigned long delayTime = Damos_time - «IF micro»micros«ELSE»millis«ENDIF»();
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
