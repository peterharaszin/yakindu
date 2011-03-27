lexer grammar InternalExpressions;
@header {
package org.yakindu.sct.statechart.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T13 : '@@statechart@@' ;
T14 : '@@state@@' ;
T15 : '@@transition@@' ;
T16 : 'interface' ;
T17 : ':' ;
T18 : 'internal' ;
T19 : 'event' ;
T20 : '=' ;
T21 : 'var' ;
T22 : 'readonly' ;
T23 : 'external' ;
T24 : 'clock' ;
T25 : 'operation' ;
T26 : '(' ;
T27 : ',' ;
T28 : ')' ;
T29 : 'entrypoint' ;
T30 : 'exitpoint' ;
T31 : '/' ;
T32 : '#' ;
T33 : '[' ;
T34 : ']' ;
T35 : '>' ;
T36 : 'after' ;
T37 : 'enter' ;
T38 : 'exit' ;
T39 : 'oncycle' ;
T40 : 'entry:' ;
T41 : 'exit:' ;
T42 : 'do:' ;
T43 : 'raise' ;
T44 : '||' ;
T45 : '&&' ;
T46 : '!' ;
T47 : 'in' ;
T48 : 'out' ;
T49 : '+' ;
T50 : '-' ;
T51 : '*' ;
T52 : '%' ;
T53 : '~' ;
T54 : '<' ;
T55 : '<=' ;
T56 : '>=' ;
T57 : '==' ;
T58 : '!=' ;
T59 : 's' ;
T60 : 'ms' ;
T61 : 'ns' ;
T62 : 'void' ;
T63 : 'integer' ;
T64 : 'real' ;
T65 : 'boolean' ;
T66 : 'string' ;

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 3650
RULE_BOOL : ('true'|'false');

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 3652
RULE_FLOAT : ('-'|'+')? RULE_INT '.' RULE_INT ('e' ('-'|'+') RULE_INT)?;

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 3654
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 3656
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 3658
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 3660
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 3662
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 3664
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 3666
RULE_ANY_OTHER : .;


