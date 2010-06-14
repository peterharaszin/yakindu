/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package com.yakindu.statechart.model.expressions.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalStatechartExpressionsLexer extends Lexer {
    public static final int T14=14;
    public static final int T29=29;
    public static final int T36=36;
    public static final int RULE_STRING=8;
    public static final int T35=35;
    public static final int T45=45;
    public static final int T20=20;
    public static final int T34=34;
    public static final int T25=25;
    public static final int T18=18;
    public static final int T37=37;
    public static final int T26=26;
    public static final int RULE_INT=5;
    public static final int RULE_BOOLEAN_LITERAL=7;
    public static final int T32=32;
    public static final int T17=17;
    public static final int T51=51;
    public static final int T46=46;
    public static final int T16=16;
    public static final int T38=38;
    public static final int T41=41;
    public static final int T24=24;
    public static final int T19=19;
    public static final int RULE_FLOATING_POINT_LITERAL=9;
    public static final int T39=39;
    public static final int T21=21;
    public static final int T44=44;
    public static final int T55=55;
    public static final int RULE_ML_COMMENT=10;
    public static final int RULE_ID=4;
    public static final int T33=33;
    public static final int T22=22;
    public static final int T50=50;
    public static final int T43=43;
    public static final int T23=23;
    public static final int T28=28;
    public static final int T42=42;
    public static final int T40=40;
    public static final int T56=56;
    public static final int RULE_HEX_LITERAL=6;
    public static final int RULE_WS=12;
    public static final int T48=48;
    public static final int T15=15;
    public static final int T54=54;
    public static final int EOF=-1;
    public static final int T47=47;
    public static final int Tokens=57;
    public static final int T53=53;
    public static final int RULE_ANY_OTHER=13;
    public static final int T31=31;
    public static final int T49=49;
    public static final int RULE_SL_COMMENT=11;
    public static final int T27=27;
    public static final int T52=52;
    public static final int T30=30;
    public InternalStatechartExpressionsLexer() {;} 
    public InternalStatechartExpressionsLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g"; }

    // $ANTLR start T14
    public final void mT14() throws RecognitionException {
        try {
            int _type = T14;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:10:5: ( ',' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:10:7: ','
            {
            match(','); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T14

    // $ANTLR start T15
    public final void mT15() throws RecognitionException {
        try {
            int _type = T15;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:11:5: ( 'after' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:11:7: 'after'
            {
            match("after"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T15

    // $ANTLR start T16
    public final void mT16() throws RecognitionException {
        try {
            int _type = T16;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:12:5: ( '(' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:12:7: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T16

    // $ANTLR start T17
    public final void mT17() throws RecognitionException {
        try {
            int _type = T17;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:13:5: ( ')' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:13:7: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T17

    // $ANTLR start T18
    public final void mT18() throws RecognitionException {
        try {
            int _type = T18;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:14:5: ( 'var' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:14:7: 'var'
            {
            match("var"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T18

    // $ANTLR start T19
    public final void mT19() throws RecognitionException {
        try {
            int _type = T19;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:15:5: ( ';' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:15:7: ';'
            {
            match(';'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T19

    // $ANTLR start T20
    public final void mT20() throws RecognitionException {
        try {
            int _type = T20;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:16:5: ( 'raise' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:16:7: 'raise'
            {
            match("raise"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T20

    // $ANTLR start T21
    public final void mT21() throws RecognitionException {
        try {
            int _type = T21;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:17:5: ( '||' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:17:7: '||'
            {
            match("||"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T21

    // $ANTLR start T22
    public final void mT22() throws RecognitionException {
        try {
            int _type = T22;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:18:5: ( '&&' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:18:7: '&&'
            {
            match("&&"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T22

    // $ANTLR start T23
    public final void mT23() throws RecognitionException {
        try {
            int _type = T23;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:19:5: ( '^' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:19:7: '^'
            {
            match('^'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T23

    // $ANTLR start T24
    public final void mT24() throws RecognitionException {
        try {
            int _type = T24;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:20:5: ( '|' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:20:7: '|'
            {
            match('|'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T24

    // $ANTLR start T25
    public final void mT25() throws RecognitionException {
        try {
            int _type = T25;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:21:5: ( '&' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:21:7: '&'
            {
            match('&'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T25

    // $ANTLR start T26
    public final void mT26() throws RecognitionException {
        try {
            int _type = T26;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:22:5: ( '?' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:22:7: '?'
            {
            match('?'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T26

    // $ANTLR start T27
    public final void mT27() throws RecognitionException {
        try {
            int _type = T27;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:23:5: ( ':' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:23:7: ':'
            {
            match(':'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T27

    // $ANTLR start T28
    public final void mT28() throws RecognitionException {
        try {
            int _type = T28;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:24:5: ( 's' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:24:7: 's'
            {
            match('s'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T28

    // $ANTLR start T29
    public final void mT29() throws RecognitionException {
        try {
            int _type = T29;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:25:5: ( 'ms' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:25:7: 'ms'
            {
            match("ms"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T29

    // $ANTLR start T30
    public final void mT30() throws RecognitionException {
        try {
            int _type = T30;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:26:5: ( 'ns' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:26:7: 'ns'
            {
            match("ns"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T30

    // $ANTLR start T31
    public final void mT31() throws RecognitionException {
        try {
            int _type = T31;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:27:5: ( '=' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:27:7: '='
            {
            match('='); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T31

    // $ANTLR start T32
    public final void mT32() throws RecognitionException {
        try {
            int _type = T32;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:28:5: ( '*=' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:28:7: '*='
            {
            match("*="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T32

    // $ANTLR start T33
    public final void mT33() throws RecognitionException {
        try {
            int _type = T33;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:29:5: ( '/=' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:29:7: '/='
            {
            match("/="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T33

    // $ANTLR start T34
    public final void mT34() throws RecognitionException {
        try {
            int _type = T34;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:30:5: ( '%=' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:30:7: '%='
            {
            match("%="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T34

    // $ANTLR start T35
    public final void mT35() throws RecognitionException {
        try {
            int _type = T35;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:31:5: ( '+=' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:31:7: '+='
            {
            match("+="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T35

    // $ANTLR start T36
    public final void mT36() throws RecognitionException {
        try {
            int _type = T36;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:32:5: ( '-=' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:32:7: '-='
            {
            match("-="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T36

    // $ANTLR start T37
    public final void mT37() throws RecognitionException {
        try {
            int _type = T37;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:33:5: ( '<<=' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:33:7: '<<='
            {
            match("<<="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T37

    // $ANTLR start T38
    public final void mT38() throws RecognitionException {
        try {
            int _type = T38;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:34:5: ( '>>=' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:34:7: '>>='
            {
            match(">>="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T38

    // $ANTLR start T39
    public final void mT39() throws RecognitionException {
        try {
            int _type = T39;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:35:5: ( '&=' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:35:7: '&='
            {
            match("&="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T39

    // $ANTLR start T40
    public final void mT40() throws RecognitionException {
        try {
            int _type = T40;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:36:5: ( '^=' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:36:7: '^='
            {
            match("^="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T40

    // $ANTLR start T41
    public final void mT41() throws RecognitionException {
        try {
            int _type = T41;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:37:5: ( '|=' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:37:7: '|='
            {
            match("|="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T41

    // $ANTLR start T42
    public final void mT42() throws RecognitionException {
        try {
            int _type = T42;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:38:5: ( '==' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:38:7: '=='
            {
            match("=="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T42

    // $ANTLR start T43
    public final void mT43() throws RecognitionException {
        try {
            int _type = T43;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:39:5: ( '!=' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:39:7: '!='
            {
            match("!="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T43

    // $ANTLR start T44
    public final void mT44() throws RecognitionException {
        try {
            int _type = T44;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:40:5: ( '<' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:40:7: '<'
            {
            match('<'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T44

    // $ANTLR start T45
    public final void mT45() throws RecognitionException {
        try {
            int _type = T45;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:41:5: ( '>' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:41:7: '>'
            {
            match('>'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T45

    // $ANTLR start T46
    public final void mT46() throws RecognitionException {
        try {
            int _type = T46;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:42:5: ( '<=' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:42:7: '<='
            {
            match("<="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T46

    // $ANTLR start T47
    public final void mT47() throws RecognitionException {
        try {
            int _type = T47;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:43:5: ( '>=' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:43:7: '>='
            {
            match(">="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T47

    // $ANTLR start T48
    public final void mT48() throws RecognitionException {
        try {
            int _type = T48;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:44:5: ( '<<' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:44:7: '<<'
            {
            match("<<"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T48

    // $ANTLR start T49
    public final void mT49() throws RecognitionException {
        try {
            int _type = T49;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:45:5: ( '>>' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:45:7: '>>'
            {
            match(">>"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T49

    // $ANTLR start T50
    public final void mT50() throws RecognitionException {
        try {
            int _type = T50;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:46:5: ( '+' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:46:7: '+'
            {
            match('+'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T50

    // $ANTLR start T51
    public final void mT51() throws RecognitionException {
        try {
            int _type = T51;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:47:5: ( '-' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:47:7: '-'
            {
            match('-'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T51

    // $ANTLR start T52
    public final void mT52() throws RecognitionException {
        try {
            int _type = T52;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:48:5: ( '*' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:48:7: '*'
            {
            match('*'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T52

    // $ANTLR start T53
    public final void mT53() throws RecognitionException {
        try {
            int _type = T53;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:49:5: ( '/' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:49:7: '/'
            {
            match('/'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T53

    // $ANTLR start T54
    public final void mT54() throws RecognitionException {
        try {
            int _type = T54;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:50:5: ( '%' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:50:7: '%'
            {
            match('%'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T54

    // $ANTLR start T55
    public final void mT55() throws RecognitionException {
        try {
            int _type = T55;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:51:5: ( '~' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:51:7: '~'
            {
            match('~'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T55

    // $ANTLR start T56
    public final void mT56() throws RecognitionException {
        try {
            int _type = T56;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:52:5: ( '!' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:52:7: '!'
            {
            match('!'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T56

    // $ANTLR start RULE_BOOLEAN_LITERAL
    public final void mRULE_BOOLEAN_LITERAL() throws RecognitionException {
        try {
            int _type = RULE_BOOLEAN_LITERAL;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2324:22: ( ( 'true' | 'false' ) )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2324:24: ( 'true' | 'false' )
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2324:24: ( 'true' | 'false' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='t') ) {
                alt1=1;
            }
            else if ( (LA1_0=='f') ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2324:24: ( 'true' | 'false' )", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2324:25: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2324:32: 'false'
                    {
                    match("false"); 


                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_BOOLEAN_LITERAL

    // $ANTLR start RULE_HEX_LITERAL
    public final void mRULE_HEX_LITERAL() throws RecognitionException {
        try {
            int _type = RULE_HEX_LITERAL;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2326:18: ( '0' ( 'x' | 'X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2326:20: '0' ( 'x' | 'X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
            {
            match('0'); 
            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2326:34: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='F')||(LA2_0>='a' && LA2_0<='f')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_HEX_LITERAL

    // $ANTLR start RULE_FLOATING_POINT_LITERAL
    public final void mRULE_FLOATING_POINT_LITERAL() throws RecognitionException {
        try {
            int _type = RULE_FLOATING_POINT_LITERAL;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2328:29: ( ( '0' .. '9' )* '.' ( '0' .. '9' )* ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )? ( 'f' | 'F' | 'd' | 'D' )? )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2328:31: ( '0' .. '9' )* '.' ( '0' .. '9' )* ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )? ( 'f' | 'F' | 'd' | 'D' )?
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2328:31: ( '0' .. '9' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2328:32: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match('.'); 
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2328:47: ( '0' .. '9' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2328:48: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2328:59: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='E'||LA7_0=='e') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2328:60: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
                    {
                    if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }

                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2328:70: ( '+' | '-' )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0=='+'||LA5_0=='-') ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:
                            {
                            if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse =
                                    new MismatchedSetException(null,input);
                                recover(mse);    throw mse;
                            }


                            }
                            break;

                    }

                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2328:81: ( '0' .. '9' )+
                    int cnt6=0;
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2328:82: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt6 >= 1 ) break loop6;
                                EarlyExitException eee =
                                    new EarlyExitException(6, input);
                                throw eee;
                        }
                        cnt6++;
                    } while (true);


                    }
                    break;

            }

            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2328:95: ( 'f' | 'F' | 'd' | 'D' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='D'||LA8_0=='F'||LA8_0=='d'||LA8_0=='f') ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:
                    {
                    if ( input.LA(1)=='D'||input.LA(1)=='F'||input.LA(1)=='d'||input.LA(1)=='f' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }


                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_FLOATING_POINT_LITERAL

    // $ANTLR start RULE_ID
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2330:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2330:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2330:11: ( '^' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='^') ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2330:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2330:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='0' && LA10_0<='9')||(LA10_0>='A' && LA10_0<='Z')||LA10_0=='_'||(LA10_0>='a' && LA10_0<='z')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_ID

    // $ANTLR start RULE_INT
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2332:10: ( ( '0' .. '9' )+ )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2332:12: ( '0' .. '9' )+
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2332:12: ( '0' .. '9' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='0' && LA11_0<='9')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2332:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_INT

    // $ANTLR start RULE_STRING
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2334:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2334:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2334:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='\"') ) {
                alt14=1;
            }
            else if ( (LA14_0=='\'') ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2334:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2334:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2334:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop12:
                    do {
                        int alt12=3;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0=='\\') ) {
                            alt12=1;
                        }
                        else if ( ((LA12_0>='\u0000' && LA12_0<='!')||(LA12_0>='#' && LA12_0<='[')||(LA12_0>=']' && LA12_0<='\uFFFE')) ) {
                            alt12=2;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2334:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2334:62: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2334:82: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2334:87: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop13:
                    do {
                        int alt13=3;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0=='\\') ) {
                            alt13=1;
                        }
                        else if ( ((LA13_0>='\u0000' && LA13_0<='&')||(LA13_0>='(' && LA13_0<='[')||(LA13_0>=']' && LA13_0<='\uFFFE')) ) {
                            alt13=2;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2334:88: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2334:129: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_STRING

    // $ANTLR start RULE_ML_COMMENT
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2336:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2336:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2336:24: ( options {greedy=false; } : . )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0=='*') ) {
                    int LA15_1 = input.LA(2);

                    if ( (LA15_1=='/') ) {
                        alt15=2;
                    }
                    else if ( ((LA15_1>='\u0000' && LA15_1<='.')||(LA15_1>='0' && LA15_1<='\uFFFE')) ) {
                        alt15=1;
                    }


                }
                else if ( ((LA15_0>='\u0000' && LA15_0<=')')||(LA15_0>='+' && LA15_0<='\uFFFE')) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2336:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            match("*/"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_ML_COMMENT

    // $ANTLR start RULE_SL_COMMENT
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2338:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2338:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2338:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>='\u0000' && LA16_0<='\t')||(LA16_0>='\u000B' && LA16_0<='\f')||(LA16_0>='\u000E' && LA16_0<='\uFFFE')) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2338:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2338:40: ( ( '\\r' )? '\\n' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0=='\n'||LA18_0=='\r') ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2338:41: ( '\\r' )? '\\n'
                    {
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2338:41: ( '\\r' )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0=='\r') ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2338:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_SL_COMMENT

    // $ANTLR start RULE_WS
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2340:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2340:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2340:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>='\t' && LA19_0<='\n')||LA19_0=='\r'||LA19_0==' ') ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt19 >= 1 ) break loop19;
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_WS

    // $ANTLR start RULE_ANY_OTHER
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2342:16: ( . )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2342:18: .
            {
            matchAny(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_ANY_OTHER

    public void mTokens() throws RecognitionException {
        // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:8: ( T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | RULE_BOOLEAN_LITERAL | RULE_HEX_LITERAL | RULE_FLOATING_POINT_LITERAL | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt20=53;
        alt20 = dfa20.predict(input);
        switch (alt20) {
            case 1 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:10: T14
                {
                mT14(); 

                }
                break;
            case 2 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:14: T15
                {
                mT15(); 

                }
                break;
            case 3 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:18: T16
                {
                mT16(); 

                }
                break;
            case 4 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:22: T17
                {
                mT17(); 

                }
                break;
            case 5 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:26: T18
                {
                mT18(); 

                }
                break;
            case 6 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:30: T19
                {
                mT19(); 

                }
                break;
            case 7 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:34: T20
                {
                mT20(); 

                }
                break;
            case 8 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:38: T21
                {
                mT21(); 

                }
                break;
            case 9 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:42: T22
                {
                mT22(); 

                }
                break;
            case 10 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:46: T23
                {
                mT23(); 

                }
                break;
            case 11 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:50: T24
                {
                mT24(); 

                }
                break;
            case 12 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:54: T25
                {
                mT25(); 

                }
                break;
            case 13 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:58: T26
                {
                mT26(); 

                }
                break;
            case 14 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:62: T27
                {
                mT27(); 

                }
                break;
            case 15 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:66: T28
                {
                mT28(); 

                }
                break;
            case 16 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:70: T29
                {
                mT29(); 

                }
                break;
            case 17 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:74: T30
                {
                mT30(); 

                }
                break;
            case 18 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:78: T31
                {
                mT31(); 

                }
                break;
            case 19 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:82: T32
                {
                mT32(); 

                }
                break;
            case 20 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:86: T33
                {
                mT33(); 

                }
                break;
            case 21 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:90: T34
                {
                mT34(); 

                }
                break;
            case 22 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:94: T35
                {
                mT35(); 

                }
                break;
            case 23 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:98: T36
                {
                mT36(); 

                }
                break;
            case 24 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:102: T37
                {
                mT37(); 

                }
                break;
            case 25 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:106: T38
                {
                mT38(); 

                }
                break;
            case 26 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:110: T39
                {
                mT39(); 

                }
                break;
            case 27 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:114: T40
                {
                mT40(); 

                }
                break;
            case 28 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:118: T41
                {
                mT41(); 

                }
                break;
            case 29 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:122: T42
                {
                mT42(); 

                }
                break;
            case 30 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:126: T43
                {
                mT43(); 

                }
                break;
            case 31 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:130: T44
                {
                mT44(); 

                }
                break;
            case 32 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:134: T45
                {
                mT45(); 

                }
                break;
            case 33 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:138: T46
                {
                mT46(); 

                }
                break;
            case 34 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:142: T47
                {
                mT47(); 

                }
                break;
            case 35 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:146: T48
                {
                mT48(); 

                }
                break;
            case 36 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:150: T49
                {
                mT49(); 

                }
                break;
            case 37 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:154: T50
                {
                mT50(); 

                }
                break;
            case 38 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:158: T51
                {
                mT51(); 

                }
                break;
            case 39 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:162: T52
                {
                mT52(); 

                }
                break;
            case 40 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:166: T53
                {
                mT53(); 

                }
                break;
            case 41 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:170: T54
                {
                mT54(); 

                }
                break;
            case 42 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:174: T55
                {
                mT55(); 

                }
                break;
            case 43 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:178: T56
                {
                mT56(); 

                }
                break;
            case 44 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:182: RULE_BOOLEAN_LITERAL
                {
                mRULE_BOOLEAN_LITERAL(); 

                }
                break;
            case 45 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:203: RULE_HEX_LITERAL
                {
                mRULE_HEX_LITERAL(); 

                }
                break;
            case 46 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:220: RULE_FLOATING_POINT_LITERAL
                {
                mRULE_FLOATING_POINT_LITERAL(); 

                }
                break;
            case 47 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:248: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 48 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:256: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 49 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:265: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 50 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:277: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 51 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:293: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 52 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:309: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 53 :
                // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1:317: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA20 dfa20 = new DFA20(this);
    static final String DFA20_eotS =
        "\2\uffff\1\46\2\uffff\1\46\1\uffff\1\46\1\56\1\61\1\63\2\uffff\1"+
        "\66\2\46\1\72\1\74\1\100\1\102\1\104\1\106\1\111\1\114\1\116\1\uffff"+
        "\2\46\2\123\2\uffff\2\43\3\uffff\1\46\3\uffff\1\46\1\uffff\1\46"+
        "\13\uffff\1\133\1\134\16\uffff\1\136\2\uffff\1\140\5\uffff\2\46"+
        "\2\uffff\1\123\3\uffff\1\46\1\144\1\46\6\uffff\3\46\1\uffff\1\46"+
        "\1\152\1\46\1\154\1\155\1\uffff\1\152\2\uffff";
    static final String DFA20_eofS =
        "\156\uffff";
    static final String DFA20_minS =
        "\1\0\1\uffff\1\146\2\uffff\1\141\1\uffff\1\141\1\75\1\46\1\75\2"+
        "\uffff\1\60\2\163\2\75\1\52\3\75\1\74\2\75\1\uffff\1\162\1\141\2"+
        "\56\2\uffff\2\0\3\uffff\1\164\3\uffff\1\162\1\uffff\1\151\13\uffff"+
        "\2\60\16\uffff\1\75\2\uffff\1\75\5\uffff\1\165\1\154\2\uffff\1\56"+
        "\3\uffff\1\145\1\60\1\163\6\uffff\1\145\1\163\1\162\1\uffff\1\145"+
        "\1\60\1\145\2\60\1\uffff\1\60\2\uffff";
    static final String DFA20_maxS =
        "\1\ufffe\1\uffff\1\146\2\uffff\1\141\1\uffff\1\141\1\174\1\75\1"+
        "\172\2\uffff\1\172\2\163\7\75\1\76\1\75\1\uffff\1\162\1\141\1\170"+
        "\1\71\2\uffff\2\ufffe\3\uffff\1\164\3\uffff\1\162\1\uffff\1\151"+
        "\13\uffff\2\172\16\uffff\1\75\2\uffff\1\75\5\uffff\1\165\1\154\2"+
        "\uffff\1\71\3\uffff\1\145\1\172\1\163\6\uffff\1\145\1\163\1\162"+
        "\1\uffff\1\145\1\172\1\145\2\172\1\uffff\1\172\2\uffff";
    static final String DFA20_acceptS =
        "\1\uffff\1\1\1\uffff\1\3\1\4\1\uffff\1\6\4\uffff\1\15\1\16\14\uffff"+
        "\1\52\4\uffff\1\56\1\57\2\uffff\1\64\1\65\1\1\1\uffff\1\57\1\3\1"+
        "\4\1\uffff\1\6\1\uffff\1\34\1\10\1\13\1\11\1\32\1\14\1\33\1\12\1"+
        "\15\1\16\1\17\2\uffff\1\35\1\22\1\23\1\47\1\24\1\63\1\62\1\50\1"+
        "\25\1\51\1\26\1\45\1\27\1\46\1\uffff\1\41\1\37\1\uffff\1\42\1\40"+
        "\1\36\1\53\1\52\2\uffff\1\55\1\60\1\uffff\1\56\1\61\1\64\3\uffff"+
        "\1\20\1\21\1\30\1\43\1\31\1\44\3\uffff\1\5\5\uffff\1\54\1\uffff"+
        "\1\2\1\7";
    static final String DFA20_specialS =
        "\156\uffff}>";
    static final String[] DFA20_transitionS = {
            "\11\43\2\42\2\43\1\42\22\43\1\42\1\30\1\40\2\43\1\23\1\11\1"+
            "\41\1\3\1\4\1\21\1\24\1\1\1\25\1\36\1\22\1\34\11\35\1\14\1\6"+
            "\1\26\1\20\1\27\1\13\1\43\32\37\3\43\1\12\1\37\1\43\1\2\4\37"+
            "\1\33\6\37\1\16\1\17\3\37\1\7\1\15\1\32\1\37\1\5\4\37\1\43\1"+
            "\10\1\43\1\31\uff80\43",
            "",
            "\1\45",
            "",
            "",
            "\1\51",
            "",
            "\1\53",
            "\1\54\76\uffff\1\55",
            "\1\57\26\uffff\1\60",
            "\1\62\3\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\73",
            "\1\77\4\uffff\1\76\15\uffff\1\75",
            "\1\101",
            "\1\103",
            "\1\105",
            "\1\107\1\110",
            "\1\113\1\112",
            "\1\115",
            "",
            "\1\120",
            "\1\121",
            "\1\125\1\uffff\12\124\36\uffff\1\122\37\uffff\1\122",
            "\1\125\1\uffff\12\124",
            "",
            "",
            "\uffff\126",
            "\uffff\126",
            "",
            "",
            "",
            "\1\130",
            "",
            "",
            "",
            "\1\131",
            "",
            "\1\132",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\135",
            "",
            "",
            "\1\137",
            "",
            "",
            "",
            "",
            "",
            "\1\141",
            "\1\142",
            "",
            "",
            "\1\125\1\uffff\12\124",
            "",
            "",
            "",
            "\1\143",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\145",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\146",
            "\1\147",
            "\1\150",
            "",
            "\1\151",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\153",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "",
            ""
    };

    static final short[] DFA20_eot = DFA.unpackEncodedString(DFA20_eotS);
    static final short[] DFA20_eof = DFA.unpackEncodedString(DFA20_eofS);
    static final char[] DFA20_min = DFA.unpackEncodedStringToUnsignedChars(DFA20_minS);
    static final char[] DFA20_max = DFA.unpackEncodedStringToUnsignedChars(DFA20_maxS);
    static final short[] DFA20_accept = DFA.unpackEncodedString(DFA20_acceptS);
    static final short[] DFA20_special = DFA.unpackEncodedString(DFA20_specialS);
    static final short[][] DFA20_transition;

    static {
        int numStates = DFA20_transitionS.length;
        DFA20_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA20_transition[i] = DFA.unpackEncodedString(DFA20_transitionS[i]);
        }
    }

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = DFA20_eot;
            this.eof = DFA20_eof;
            this.min = DFA20_min;
            this.max = DFA20_max;
            this.accept = DFA20_accept;
            this.special = DFA20_special;
            this.transition = DFA20_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | RULE_BOOLEAN_LITERAL | RULE_HEX_LITERAL | RULE_FLOATING_POINT_LITERAL | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
    }
 

}