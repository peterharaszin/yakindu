package org.yakindu.sct.generator.c

import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgraph.Statechart
import org.eclipse.xtext.generator.IFileSystemAccess
import com.google.inject.Inject

class Types {
	
	@Inject extension Naming
	 
	def generateTypesH(ExecutionFlow flow, Statechart sc, IFileSystemAccess fsa) {
		 fsa.generateFile(flow.typesModule.h, flow.typesHContent)
	}
	
	
	def typesHContent(ExecutionFlow it) '''
		#ifndef �typesModule.define�_H_
		#define �typesModule.define�_H_
		
		#ifdef __cplusplus
		extern "C" {
		#endif 
		
		#include <stdint.h>
		#include <stdbool.h>
		 				
		typedef int_fast16_t  sc_short;
		typedef uint_fast16_t sc_ushort;
		typedef int32_t       sc_integer; 
		typedef uint32_t      sc_uinteger; 
		typedef double        sc_real;
		typedef char*         sc_string;
		
		typedef void*         sc_eventid;
		
		#ifdef __cplusplus
		}
		#endif 
		#define sc_boolean bool
		#define bool_true true
		#define bool_false false

		#endif /* �typesModule.define�_H_ */
	'''
}