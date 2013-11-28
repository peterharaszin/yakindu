lexer grammar InternalStatechartExpressions;
@header {
package com.yakindu.statechart.model.expressions.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T14 : 's' ;
T15 : 'ms' ;
T16 : 'ns' ;
T17 : '=' ;
T18 : '*=' ;
T19 : '/=' ;
T20 : '%=' ;
T21 : '+=' ;
T22 : '-=' ;
T23 : '<<=' ;
T24 : '>>=' ;
T25 : '&=' ;
T26 : '^=' ;
T27 : '|=' ;
T28 : '==' ;
T29 : '!=' ;
T30 : '<' ;
T31 : '>' ;
T32 : '<=' ;
T33 : '>=' ;
T34 : '<<' ;
T35 : '>>' ;
T36 : '+' ;
T37 : '-' ;
T38 : '*' ;
T39 : '/' ;
T40 : '%' ;
T41 : '~' ;
T42 : '!' ;
T43 : ',' ;
T44 : 'after' ;
T45 : '(' ;
T46 : ')' ;
T47 : 'var' ;
T48 : ';' ;
T49 : 'raise' ;
T50 : '||' ;
T51 : '&&' ;
T52 : '^' ;
T53 : '|' ;
T54 : '&' ;
T55 : '?' ;
T56 : ':' ;

// $ANTLR src "../com.yakindu.statechart.model.expressions.ui/src-gen/com/yakindu/statechart/model/expressions/ui/contentassist/antlr/internal/InternalStatechartExpressions.g" 4783
RULE_BOOLEAN_LITERAL : ('true'|'false');

// $ANTLR src "../com.yakindu.statechart.model.expressions.ui/src-gen/com/yakindu/statechart/model/expressions/ui/contentassist/antlr/internal/InternalStatechartExpressions.g" 4785
RULE_HEX_LITERAL : '0' ('x'|'X') ('0'..'9'|'a'..'f'|'A'..'F')+;

// $ANTLR src "../com.yakindu.statechart.model.expressions.ui/src-gen/com/yakindu/statechart/model/expressions/ui/contentassist/antlr/internal/InternalStatechartExpressions.g" 4787
RULE_FLOATING_POINT_LITERAL : ('0'..'9')* '.' ('0'..'9')* (('e'|'E') ('+'|'-')? ('0'..'9')+)? ('f'|'F'|'d'|'D')?;

// $ANTLR src "../com.yakindu.statechart.model.expressions.ui/src-gen/com/yakindu/statechart/model/expressions/ui/contentassist/antlr/internal/InternalStatechartExpressions.g" 4789
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../com.yakindu.statechart.model.expressions.ui/src-gen/com/yakindu/statechart/model/expressions/ui/contentassist/antlr/internal/InternalStatechartExpressions.g" 4791
RULE_INT : ('0'..'9')+;

// $ANTLR src "../com.yakindu.statechart.model.expressions.ui/src-gen/com/yakindu/statechart/model/expressions/ui/contentassist/antlr/internal/InternalStatechartExpressions.g" 4793
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../com.yakindu.statechart.model.expressions.ui/src-gen/com/yakindu/statechart/model/expressions/ui/contentassist/antlr/internal/InternalStatechartExpressions.g" 4795
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../com.yakindu.statechart.model.expressions.ui/src-gen/com/yakindu/statechart/model/expressions/ui/contentassist/antlr/internal/InternalStatechartExpressions.g" 4797
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../com.yakindu.statechart.model.expressions.ui/src-gen/com/yakindu/statechart/model/expressions/ui/contentassist/antlr/internal/InternalStatechartExpressions.g" 4799
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../com.yakindu.statechart.model.expressions.ui/src-gen/com/yakindu/statechart/model/expressions/ui/contentassist/antlr/internal/InternalStatechartExpressions.g" 4801
RULE_ANY_OTHER : .;


