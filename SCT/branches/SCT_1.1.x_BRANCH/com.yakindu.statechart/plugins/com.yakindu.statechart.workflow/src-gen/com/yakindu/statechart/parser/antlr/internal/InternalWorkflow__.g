lexer grammar InternalWorkflow;
@header {
package com.yakindu.statechart.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'modelFile' ;
T12 : 'targetDir' ;
T13 : 'targetPlatform' ;
T14 : 'defensive' ;
T15 : 'c' ;
T16 : 'java' ;
T17 : 'javame' ;
T18 : 'lejos' ;

// $ANTLR src "../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g" 362
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g" 364
RULE_INT : ('0'..'9')+;

// $ANTLR src "../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g" 366
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g" 368
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g" 370
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g" 372
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g" 374
RULE_ANY_OTHER : .;


