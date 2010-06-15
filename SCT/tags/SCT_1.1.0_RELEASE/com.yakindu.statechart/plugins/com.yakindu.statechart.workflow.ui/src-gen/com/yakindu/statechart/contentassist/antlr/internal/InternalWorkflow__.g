lexer grammar InternalWorkflow;
@header {
package com.yakindu.statechart.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.Lexer;
}

T11 : 'c' ;
T12 : 'java' ;
T13 : 'javame' ;
T14 : 'lejos' ;
T15 : 'modelFile' ;
T16 : 'targetDir' ;
T17 : 'targetPlatform' ;
T18 : 'defensive' ;

// $ANTLR src "../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g" 562
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g" 564
RULE_INT : ('0'..'9')+;

// $ANTLR src "../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g" 566
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g" 568
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g" 570
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g" 572
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g" 574
RULE_ANY_OTHER : .;


