package org.eclipselabs.damos.mscript.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMscriptLexer extends Lexer {
    public static final int RULE_ID=7;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=8;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_ONE=9;
    public static final int EOF=-1;
    public static final int T__93=93;
    public static final int T__19=19;
    public static final int T__94=94;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__90=90;
    public static final int RULE_E=12;
    public static final int T__18=18;
    public static final int RULE_N=11;
    public static final int T__99=99;
    public static final int T__98=98;
    public static final int T__97=97;
    public static final int T__96=96;
    public static final int T__95=95;
    public static final int RULE_EXPIJ=5;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int T__88=88;
    public static final int RULE_ML_COMMENT=15;
    public static final int RULE_STRING=14;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__70=70;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int T__77=77;
    public static final int RULE_IJ=4;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int RULE_EXP=13;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__59=59;
    public static final int T__103=103;
    public static final int RULE_INT=10;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__100=100;
    public static final int RULE_SL_COMMENT=16;
    public static final int T__30=30;
    public static final int RULE_CONSTANT_STRING=6;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=17;

    // delegates
    // delegators

    public InternalMscriptLexer() {;} 
    public InternalMscriptLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalMscriptLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g"; }

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:11:7: ( '=>' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:11:9: '=>'
            {
            match("=>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:12:7: ( '||' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:12:9: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:13:7: ( '&&' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:13:9: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:14:7: ( '\\'' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:14:9: '\\''
            {
            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:15:7: ( '+' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:15:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:16:7: ( '-' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:16:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:17:7: ( 'false' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:17:9: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:18:7: ( '.*' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:18:9: '.*'
            {
            match(".*"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:19:7: ( 'stateful' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:19:9: 'stateful'
            {
            match("stateful"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:20:7: ( 'continuous' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:20:9: 'continuous'
            {
            match("continuous"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:21:7: ( 'info' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:21:9: 'info'
            {
            match("info"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:22:7: ( 'warning' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:22:9: 'warning'
            {
            match("warning"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23:7: ( 'error' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23:9: 'error'
            {
            match("error"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:24:7: ( 'fatal' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:24:9: 'fatal'
            {
            match("fatal"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:25:7: ( '==' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:25:9: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:26:7: ( '!=' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:26:9: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:27:7: ( '<' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:27:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:28:7: ( '<=' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:28:9: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:29:7: ( '>' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:29:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:30:7: ( '>=' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:30:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:31:7: ( '.+' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:31:9: '.+'
            {
            match(".+"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:32:7: ( '.-' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:32:9: '.-'
            {
            match(".-"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:33:7: ( '*' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:33:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:34:7: ( '/' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:34:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:35:7: ( '%' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:35:9: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:36:7: ( './' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:36:9: './'
            {
            match("./"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:37:7: ( '.%' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:37:9: '.%'
            {
            match(".%"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:38:7: ( '^' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:38:9: '^'
            {
            match('^'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:39:7: ( '.^' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:39:9: '.^'
            {
            match(".^"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:40:7: ( '!' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:40:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:41:7: ( 'package' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:41:9: 'package'
            {
            match("package"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:42:7: ( 'import' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:42:9: 'import'
            {
            match("import"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:43:7: ( 'type' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:43:9: 'type'
            {
            match("type"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:44:7: ( '=' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:44:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:45:7: ( 'struct' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:45:9: 'struct'
            {
            match("struct"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:46:7: ( '{' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:46:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:47:7: ( ';' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:47:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:48:7: ( '}' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:48:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:49:7: ( 'enum' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:49:9: 'enum'
            {
            match("enum"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:50:7: ( ',' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:50:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:51:7: ( 'function' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:51:9: 'function'
            {
            match("function"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:52:7: ( '(' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:52:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:53:7: ( ')' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:53:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:54:7: ( '->' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:54:9: '->'
            {
            match("->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:55:7: ( 'check' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:55:9: 'check'
            {
            match("check"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:56:7: ( 'assert' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:56:9: 'assert'
            {
            match("assert"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:57:7: ( ':' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:57:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:58:7: ( 'var' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:58:9: 'var'
            {
            match("var"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:59:7: ( 'const' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:59:9: 'const'
            {
            match("const"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:60:7: ( 'eq' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:60:9: 'eq'
            {
            match("eq"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:61:7: ( 'real' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:61:9: 'real'
            {
            match("real"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:62:7: ( 'int' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:62:9: 'int'
            {
            match("int"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:63:7: ( 'complex' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:63:9: 'complex'
            {
            match("complex"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:64:7: ( 'gaussian' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:64:9: 'gaussian'
            {
            match("gaussian"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__71"

    // $ANTLR start "T__72"
    public final void mT__72() throws RecognitionException {
        try {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:65:7: ( 'boolean' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:65:9: 'boolean'
            {
            match("boolean"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__72"

    // $ANTLR start "T__73"
    public final void mT__73() throws RecognitionException {
        try {
            int _type = T__73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:66:7: ( 'string' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:66:9: 'string'
            {
            match("string"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__73"

    // $ANTLR start "T__74"
    public final void mT__74() throws RecognitionException {
        try {
            int _type = T__74;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:67:7: ( '[' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:67:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__74"

    // $ANTLR start "T__75"
    public final void mT__75() throws RecognitionException {
        try {
            int _type = T__75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:68:7: ( ']' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:68:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__75"

    // $ANTLR start "T__76"
    public final void mT__76() throws RecognitionException {
        try {
            int _type = T__76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:69:7: ( 'let' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:69:9: 'let'
            {
            match("let"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__76"

    // $ANTLR start "T__77"
    public final void mT__77() throws RecognitionException {
        try {
            int _type = T__77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:70:7: ( 'in' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:70:9: 'in'
            {
            match("in"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__77"

    // $ANTLR start "T__78"
    public final void mT__78() throws RecognitionException {
        try {
            int _type = T__78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:71:7: ( 'if' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:71:9: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__78"

    // $ANTLR start "T__79"
    public final void mT__79() throws RecognitionException {
        try {
            int _type = T__79;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:72:7: ( 'then' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:72:9: 'then'
            {
            match("then"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__79"

    // $ANTLR start "T__80"
    public final void mT__80() throws RecognitionException {
        try {
            int _type = T__80;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:73:7: ( 'else' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:73:9: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__80"

    // $ANTLR start "T__81"
    public final void mT__81() throws RecognitionException {
        try {
            int _type = T__81;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:74:7: ( 'switch' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:74:9: 'switch'
            {
            match("switch"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__81"

    // $ANTLR start "T__82"
    public final void mT__82() throws RecognitionException {
        try {
            int _type = T__82;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:75:7: ( 'default' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:75:9: 'default'
            {
            match("default"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__82"

    // $ANTLR start "T__83"
    public final void mT__83() throws RecognitionException {
        try {
            int _type = T__83;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:76:7: ( 'case' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:76:9: 'case'
            {
            match("case"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__83"

    // $ANTLR start "T__84"
    public final void mT__84() throws RecognitionException {
        try {
            int _type = T__84;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:77:7: ( 'is' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:77:9: 'is'
            {
            match("is"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__84"

    // $ANTLR start "T__85"
    public final void mT__85() throws RecognitionException {
        try {
            int _type = T__85;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:78:7: ( '.' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:78:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__85"

    // $ANTLR start "T__86"
    public final void mT__86() throws RecognitionException {
        try {
            int _type = T__86;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:79:7: ( '|' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:79:9: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__86"

    // $ANTLR start "T__87"
    public final void mT__87() throws RecognitionException {
        try {
            int _type = T__87;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:80:7: ( '\"\"\"' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:80:9: '\"\"\"'
            {
            match("\"\"\""); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__87"

    // $ANTLR start "T__88"
    public final void mT__88() throws RecognitionException {
        try {
            int _type = T__88;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:81:7: ( '\\u00AB' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:81:9: '\\u00AB'
            {
            match('\u00AB'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__88"

    // $ANTLR start "T__89"
    public final void mT__89() throws RecognitionException {
        try {
            int _type = T__89;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:82:7: ( '\\u00BB' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:82:9: '\\u00BB'
            {
            match('\u00BB'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__89"

    // $ANTLR start "T__90"
    public final void mT__90() throws RecognitionException {
        try {
            int _type = T__90;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:83:7: ( '::' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:83:9: '::'
            {
            match("::"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__90"

    // $ANTLR start "T__91"
    public final void mT__91() throws RecognitionException {
        try {
            int _type = T__91;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:84:7: ( '..' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:84:9: '..'
            {
            match(".."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__91"

    // $ANTLR start "T__92"
    public final void mT__92() throws RecognitionException {
        try {
            int _type = T__92;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:85:7: ( 'for' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:85:9: 'for'
            {
            match("for"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__92"

    // $ANTLR start "T__93"
    public final void mT__93() throws RecognitionException {
        try {
            int _type = T__93;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:86:7: ( 'unitlit' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:86:9: 'unitlit'
            {
            match("unitlit"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__93"

    // $ANTLR start "T__94"
    public final void mT__94() throws RecognitionException {
        try {
            int _type = T__94;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:87:7: ( 'end' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:87:9: 'end'
            {
            match("end"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__94"

    // $ANTLR start "T__95"
    public final void mT__95() throws RecognitionException {
        try {
            int _type = T__95;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:88:7: ( 'algorithm' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:88:9: 'algorithm'
            {
            match("algorithm"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__95"

    // $ANTLR start "T__96"
    public final void mT__96() throws RecognitionException {
        try {
            int _type = T__96;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:89:7: ( 'while' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:89:9: 'while'
            {
            match("while"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__96"

    // $ANTLR start "T__97"
    public final void mT__97() throws RecognitionException {
        try {
            int _type = T__97;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:90:7: ( 'do' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:90:9: 'do'
            {
            match("do"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__97"

    // $ANTLR start "T__98"
    public final void mT__98() throws RecognitionException {
        try {
            int _type = T__98;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:91:7: ( 'continue' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:91:9: 'continue'
            {
            match("continue"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__98"

    // $ANTLR start "T__99"
    public final void mT__99() throws RecognitionException {
        try {
            int _type = T__99;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:92:7: ( 'break' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:92:9: 'break'
            {
            match("break"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__99"

    // $ANTLR start "T__100"
    public final void mT__100() throws RecognitionException {
        try {
            int _type = T__100;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:93:8: ( 'return' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:93:10: 'return'
            {
            match("return"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__100"

    // $ANTLR start "T__101"
    public final void mT__101() throws RecognitionException {
        try {
            int _type = T__101;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:94:8: ( 'static' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:94:10: 'static'
            {
            match("static"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__101"

    // $ANTLR start "T__102"
    public final void mT__102() throws RecognitionException {
        try {
            int _type = T__102;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:95:8: ( 'initial' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:95:10: 'initial'
            {
            match("initial"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__102"

    // $ANTLR start "T__103"
    public final void mT__103() throws RecognitionException {
        try {
            int _type = T__103;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:96:8: ( 'true' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:96:10: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__103"

    // $ANTLR start "RULE_N"
    public final void mRULE_N() throws RecognitionException {
        try {
            int _type = RULE_N;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23684:8: ( 'n' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23684:10: 'n'
            {
            match('n'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_N"

    // $ANTLR start "RULE_IJ"
    public final void mRULE_IJ() throws RecognitionException {
        try {
            int _type = RULE_IJ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23686:9: ( ( 'i' | 'j' ) )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23686:11: ( 'i' | 'j' )
            {
            if ( (input.LA(1)>='i' && input.LA(1)<='j') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_IJ"

    // $ANTLR start "RULE_E"
    public final void mRULE_E() throws RecognitionException {
        try {
            int _type = RULE_E;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23688:8: ( ( 'e' | 'E' ) )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23688:10: ( 'e' | 'E' )
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_E"

    // $ANTLR start "RULE_EXP"
    public final void mRULE_EXP() throws RecognitionException {
        try {
            int _type = RULE_EXP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23690:10: ( RULE_E ( '0' .. '9' )+ )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23690:12: RULE_E ( '0' .. '9' )+
            {
            mRULE_E(); 
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23690:19: ( '0' .. '9' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23690:20: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_EXP"

    // $ANTLR start "RULE_EXPIJ"
    public final void mRULE_EXPIJ() throws RecognitionException {
        try {
            int _type = RULE_EXPIJ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23692:12: ( RULE_EXP RULE_IJ )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23692:14: RULE_EXP RULE_IJ
            {
            mRULE_EXP(); 
            mRULE_IJ(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_EXPIJ"

    // $ANTLR start "RULE_ONE"
    public final void mRULE_ONE() throws RecognitionException {
        try {
            int _type = RULE_ONE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23694:10: ( '1' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23694:12: '1'
            {
            match('1'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ONE"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23696:10: ( ( '0' .. '9' )+ )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23696:12: ( '0' .. '9' )+
            {
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23696:12: ( '0' .. '9' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23696:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23698:9: ( ( '_' )? ( 'a' .. 'z' | 'A' .. 'Z' ) ( '0' .. '9' | '_' | 'a' .. 'z' | 'A' .. 'Z' )* )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23698:11: ( '_' )? ( 'a' .. 'z' | 'A' .. 'Z' ) ( '0' .. '9' | '_' | 'a' .. 'z' | 'A' .. 'Z' )*
            {
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23698:11: ( '_' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='_') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23698:11: '_'
                    {
                    match('_'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23698:36: ( '0' .. '9' | '_' | 'a' .. 'z' | 'A' .. 'Z' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23700:13: ( '\"' (~ ( ( '\\\\' | '\"' ) ) | '\\\\' ( '\\'' | '\"' | '?' | '\\\\' | 'a' | 'b' | 'f' | 'n' | 'r' | 't' | 'v' ) )* '\"' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23700:15: '\"' (~ ( ( '\\\\' | '\"' ) ) | '\\\\' ( '\\'' | '\"' | '?' | '\\\\' | 'a' | 'b' | 'f' | 'n' | 'r' | 't' | 'v' ) )* '\"'
            {
            match('\"'); 
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23700:19: (~ ( ( '\\\\' | '\"' ) ) | '\\\\' ( '\\'' | '\"' | '?' | '\\\\' | 'a' | 'b' | 'f' | 'n' | 'r' | 't' | 'v' ) )*
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='\u0000' && LA5_0<='!')||(LA5_0>='#' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFF')) ) {
                    alt5=1;
                }
                else if ( (LA5_0=='\\') ) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23700:20: ~ ( ( '\\\\' | '\"' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23700:34: '\\\\' ( '\\'' | '\"' | '?' | '\\\\' | 'a' | 'b' | 'f' | 'n' | 'r' | 't' | 'v' )
            	    {
            	    match('\\'); 
            	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='?'||input.LA(1)=='\\'||(input.LA(1)>='a' && input.LA(1)<='b')||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t'||input.LA(1)=='v' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_CONSTANT_STRING"
    public final void mRULE_CONSTANT_STRING() throws RecognitionException {
        try {
            int _type = RULE_CONSTANT_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23702:22: ( '\\u00AD' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23702:24: '\\u00AD'
            {
            match('\u00AD'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_CONSTANT_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23704:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23704:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23704:24: ( options {greedy=false; } : . )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='*') ) {
                    int LA6_1 = input.LA(2);

                    if ( (LA6_1=='/') ) {
                        alt6=2;
                    }
                    else if ( ((LA6_1>='\u0000' && LA6_1<='.')||(LA6_1>='0' && LA6_1<='\uFFFF')) ) {
                        alt6=1;
                    }


                }
                else if ( ((LA6_0>='\u0000' && LA6_0<=')')||(LA6_0>='+' && LA6_0<='\uFFFF')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23704:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23706:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23706:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23706:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='\u0000' && LA7_0<='\t')||(LA7_0>='\u000B' && LA7_0<='\f')||(LA7_0>='\u000E' && LA7_0<='\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23706:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23706:40: ( ( '\\r' )? '\\n' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='\n'||LA9_0=='\r') ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23706:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23706:41: ( '\\r' )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0=='\r') ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23706:41: '\\r'
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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23708:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23708:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23708:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\t' && LA10_0<='\n')||LA10_0=='\r'||LA10_0==' ') ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23710:16: ( . )
            // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:23710:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:8: ( T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | RULE_N | RULE_IJ | RULE_E | RULE_EXP | RULE_EXPIJ | RULE_ONE | RULE_INT | RULE_ID | RULE_STRING | RULE_CONSTANT_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt11=100;
        alt11 = dfa11.predict(input);
        switch (alt11) {
            case 1 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:10: T__18
                {
                mT__18(); 

                }
                break;
            case 2 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:16: T__19
                {
                mT__19(); 

                }
                break;
            case 3 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:22: T__20
                {
                mT__20(); 

                }
                break;
            case 4 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:28: T__21
                {
                mT__21(); 

                }
                break;
            case 5 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:34: T__22
                {
                mT__22(); 

                }
                break;
            case 6 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:40: T__23
                {
                mT__23(); 

                }
                break;
            case 7 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:46: T__24
                {
                mT__24(); 

                }
                break;
            case 8 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:52: T__25
                {
                mT__25(); 

                }
                break;
            case 9 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:58: T__26
                {
                mT__26(); 

                }
                break;
            case 10 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:64: T__27
                {
                mT__27(); 

                }
                break;
            case 11 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:70: T__28
                {
                mT__28(); 

                }
                break;
            case 12 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:76: T__29
                {
                mT__29(); 

                }
                break;
            case 13 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:82: T__30
                {
                mT__30(); 

                }
                break;
            case 14 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:88: T__31
                {
                mT__31(); 

                }
                break;
            case 15 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:94: T__32
                {
                mT__32(); 

                }
                break;
            case 16 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:100: T__33
                {
                mT__33(); 

                }
                break;
            case 17 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:106: T__34
                {
                mT__34(); 

                }
                break;
            case 18 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:112: T__35
                {
                mT__35(); 

                }
                break;
            case 19 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:118: T__36
                {
                mT__36(); 

                }
                break;
            case 20 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:124: T__37
                {
                mT__37(); 

                }
                break;
            case 21 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:130: T__38
                {
                mT__38(); 

                }
                break;
            case 22 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:136: T__39
                {
                mT__39(); 

                }
                break;
            case 23 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:142: T__40
                {
                mT__40(); 

                }
                break;
            case 24 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:148: T__41
                {
                mT__41(); 

                }
                break;
            case 25 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:154: T__42
                {
                mT__42(); 

                }
                break;
            case 26 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:160: T__43
                {
                mT__43(); 

                }
                break;
            case 27 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:166: T__44
                {
                mT__44(); 

                }
                break;
            case 28 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:172: T__45
                {
                mT__45(); 

                }
                break;
            case 29 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:178: T__46
                {
                mT__46(); 

                }
                break;
            case 30 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:184: T__47
                {
                mT__47(); 

                }
                break;
            case 31 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:190: T__48
                {
                mT__48(); 

                }
                break;
            case 32 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:196: T__49
                {
                mT__49(); 

                }
                break;
            case 33 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:202: T__50
                {
                mT__50(); 

                }
                break;
            case 34 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:208: T__51
                {
                mT__51(); 

                }
                break;
            case 35 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:214: T__52
                {
                mT__52(); 

                }
                break;
            case 36 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:220: T__53
                {
                mT__53(); 

                }
                break;
            case 37 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:226: T__54
                {
                mT__54(); 

                }
                break;
            case 38 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:232: T__55
                {
                mT__55(); 

                }
                break;
            case 39 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:238: T__56
                {
                mT__56(); 

                }
                break;
            case 40 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:244: T__57
                {
                mT__57(); 

                }
                break;
            case 41 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:250: T__58
                {
                mT__58(); 

                }
                break;
            case 42 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:256: T__59
                {
                mT__59(); 

                }
                break;
            case 43 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:262: T__60
                {
                mT__60(); 

                }
                break;
            case 44 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:268: T__61
                {
                mT__61(); 

                }
                break;
            case 45 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:274: T__62
                {
                mT__62(); 

                }
                break;
            case 46 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:280: T__63
                {
                mT__63(); 

                }
                break;
            case 47 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:286: T__64
                {
                mT__64(); 

                }
                break;
            case 48 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:292: T__65
                {
                mT__65(); 

                }
                break;
            case 49 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:298: T__66
                {
                mT__66(); 

                }
                break;
            case 50 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:304: T__67
                {
                mT__67(); 

                }
                break;
            case 51 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:310: T__68
                {
                mT__68(); 

                }
                break;
            case 52 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:316: T__69
                {
                mT__69(); 

                }
                break;
            case 53 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:322: T__70
                {
                mT__70(); 

                }
                break;
            case 54 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:328: T__71
                {
                mT__71(); 

                }
                break;
            case 55 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:334: T__72
                {
                mT__72(); 

                }
                break;
            case 56 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:340: T__73
                {
                mT__73(); 

                }
                break;
            case 57 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:346: T__74
                {
                mT__74(); 

                }
                break;
            case 58 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:352: T__75
                {
                mT__75(); 

                }
                break;
            case 59 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:358: T__76
                {
                mT__76(); 

                }
                break;
            case 60 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:364: T__77
                {
                mT__77(); 

                }
                break;
            case 61 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:370: T__78
                {
                mT__78(); 

                }
                break;
            case 62 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:376: T__79
                {
                mT__79(); 

                }
                break;
            case 63 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:382: T__80
                {
                mT__80(); 

                }
                break;
            case 64 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:388: T__81
                {
                mT__81(); 

                }
                break;
            case 65 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:394: T__82
                {
                mT__82(); 

                }
                break;
            case 66 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:400: T__83
                {
                mT__83(); 

                }
                break;
            case 67 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:406: T__84
                {
                mT__84(); 

                }
                break;
            case 68 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:412: T__85
                {
                mT__85(); 

                }
                break;
            case 69 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:418: T__86
                {
                mT__86(); 

                }
                break;
            case 70 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:424: T__87
                {
                mT__87(); 

                }
                break;
            case 71 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:430: T__88
                {
                mT__88(); 

                }
                break;
            case 72 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:436: T__89
                {
                mT__89(); 

                }
                break;
            case 73 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:442: T__90
                {
                mT__90(); 

                }
                break;
            case 74 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:448: T__91
                {
                mT__91(); 

                }
                break;
            case 75 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:454: T__92
                {
                mT__92(); 

                }
                break;
            case 76 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:460: T__93
                {
                mT__93(); 

                }
                break;
            case 77 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:466: T__94
                {
                mT__94(); 

                }
                break;
            case 78 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:472: T__95
                {
                mT__95(); 

                }
                break;
            case 79 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:478: T__96
                {
                mT__96(); 

                }
                break;
            case 80 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:484: T__97
                {
                mT__97(); 

                }
                break;
            case 81 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:490: T__98
                {
                mT__98(); 

                }
                break;
            case 82 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:496: T__99
                {
                mT__99(); 

                }
                break;
            case 83 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:502: T__100
                {
                mT__100(); 

                }
                break;
            case 84 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:509: T__101
                {
                mT__101(); 

                }
                break;
            case 85 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:516: T__102
                {
                mT__102(); 

                }
                break;
            case 86 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:523: T__103
                {
                mT__103(); 

                }
                break;
            case 87 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:530: RULE_N
                {
                mRULE_N(); 

                }
                break;
            case 88 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:537: RULE_IJ
                {
                mRULE_IJ(); 

                }
                break;
            case 89 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:545: RULE_E
                {
                mRULE_E(); 

                }
                break;
            case 90 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:552: RULE_EXP
                {
                mRULE_EXP(); 

                }
                break;
            case 91 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:561: RULE_EXPIJ
                {
                mRULE_EXPIJ(); 

                }
                break;
            case 92 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:572: RULE_ONE
                {
                mRULE_ONE(); 

                }
                break;
            case 93 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:581: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 94 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:590: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 95 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:598: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 96 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:610: RULE_CONSTANT_STRING
                {
                mRULE_CONSTANT_STRING(); 

                }
                break;
            case 97 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:631: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 98 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:647: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 99 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:663: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 100 :
                // ../org.eclipselabs.damos.mscript.ui/src-gen/org/eclipselabs/damos/mscript/ui/contentassist/antlr/internal/InternalMscript.g:1:671: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA11 dfa11 = new DFA11(this);
    static final String DFA11_eotS =
        "\1\uffff\1\67\1\71\1\64\2\uffff\1\76\1\102\1\112\2\102\1\124\1\102"+
        "\1\133\1\136\1\140\1\142\1\uffff\1\146\2\uffff\2\102\6\uffff\1\102"+
        "\1\166\4\102\2\uffff\2\102\1\64\2\uffff\1\102\1\u0086\1\124\1\133"+
        "\1\u0087\1\uffff\1\64\16\uffff\3\102\11\uffff\5\102\1\u0099\1\102"+
        "\1\u009b\1\u009c\1\uffff\4\102\1\u00a2\1\102\1\uffff\1\u00a4\14"+
        "\uffff\4\102\6\uffff\2\102\2\uffff\5\102\2\uffff\2\102\1\u00b4\1"+
        "\u0082\3\uffff\1\102\5\uffff\3\102\1\u00ba\10\102\1\u00c5\1\102"+
        "\1\uffff\1\102\2\uffff\4\102\1\u00cc\1\uffff\1\102\1\uffff\1\u00ce"+
        "\6\102\1\u00d5\5\102\1\u00db\1\102\2\uffff\4\102\1\uffff\10\102"+
        "\1\u00ea\1\u00eb\1\uffff\5\102\1\u00f1\1\uffff\1\u00f2\1\uffff\1"+
        "\102\1\u00f4\1\u00f5\1\u00f6\2\102\1\uffff\1\u00f9\4\102\1\uffff"+
        "\2\102\1\u0100\1\u0101\7\102\1\u0109\1\102\1\u010b\2\uffff\3\102"+
        "\1\u010f\1\u0110\2\uffff\1\102\3\uffff\2\102\1\uffff\3\102\1\u0117"+
        "\2\102\2\uffff\2\102\1\u011c\1\u011d\1\u011e\1\u011f\1\102\1\uffff"+
        "\1\102\1\uffff\1\102\1\u0123\1\102\2\uffff\1\102\1\u0126\1\102\1"+
        "\u0128\2\102\1\uffff\4\102\4\uffff\1\102\1\u0131\1\u0132\1\uffff"+
        "\1\u0133\1\u0134\1\uffff\1\102\1\uffff\1\102\1\u0137\1\u0138\1\u0139"+
        "\1\u013a\1\u013b\1\102\1\u013d\4\uffff\1\102\1\u013f\5\uffff\1\102"+
        "\1\uffff\1\u0141\1\uffff\1\u0142\2\uffff";
    static final String DFA11_eofS =
        "\u0143\uffff";
    static final String DFA11_minS =
        "\1\0\1\75\1\174\1\46\2\uffff\1\76\1\141\1\45\1\164\1\141\1\60\1"+
        "\141\1\60\3\75\1\uffff\1\52\2\uffff\1\141\1\150\6\uffff\1\154\1"+
        "\72\1\141\1\145\1\141\1\157\2\uffff\2\145\1\0\2\uffff\1\156\4\60"+
        "\1\uffff\1\101\16\uffff\1\154\1\156\1\162\11\uffff\1\141\1\151\1"+
        "\155\1\145\1\163\1\60\1\160\2\60\1\uffff\1\162\1\151\1\162\1\144"+
        "\1\60\1\163\1\uffff\1\60\14\uffff\1\143\1\160\1\145\1\165\6\uffff"+
        "\1\163\1\147\2\uffff\1\162\1\141\1\165\1\157\1\145\2\uffff\1\164"+
        "\1\146\1\60\1\42\3\uffff\1\151\5\uffff\1\163\1\141\1\143\1\60\1"+
        "\164\1\151\1\164\1\163\1\160\1\143\1\145\1\157\1\60\1\164\1\uffff"+
        "\1\157\2\uffff\1\156\1\154\1\157\1\155\1\60\1\uffff\1\145\1\uffff"+
        "\1\60\1\153\1\145\1\156\2\145\1\157\1\60\1\154\1\165\1\163\1\154"+
        "\1\141\1\60\1\141\2\uffff\1\164\1\145\1\154\1\164\1\uffff\1\145"+
        "\1\143\1\156\1\143\1\151\1\164\1\154\1\153\2\60\1\uffff\1\151\1"+
        "\162\1\151\1\145\1\162\1\60\1\uffff\1\60\1\uffff\1\141\3\60\2\162"+
        "\1\uffff\1\60\1\162\1\163\1\145\1\153\1\uffff\1\165\1\154\2\60\1"+
        "\151\1\146\1\143\1\164\1\147\1\150\1\156\1\60\1\145\1\60\2\uffff"+
        "\1\141\1\164\1\156\2\60\2\uffff\1\147\3\uffff\1\164\1\151\1\uffff"+
        "\1\156\1\151\1\141\1\60\1\154\1\151\2\uffff\1\157\1\165\4\60\1\165"+
        "\1\uffff\1\170\1\uffff\1\154\1\60\1\147\2\uffff\1\145\1\60\1\164"+
        "\1\60\1\141\1\156\1\uffff\2\164\1\156\1\154\4\uffff\1\145\2\60\1"+
        "\uffff\2\60\1\uffff\1\150\1\uffff\1\156\5\60\1\165\1\60\4\uffff"+
        "\1\155\1\60\5\uffff\1\163\1\uffff\1\60\1\uffff\1\60\2\uffff";
    static final String DFA11_maxS =
        "\1\uffff\1\76\1\174\1\46\2\uffff\1\76\1\165\1\136\1\167\1\157\1"+
        "\172\1\150\1\172\3\75\1\uffff\1\57\2\uffff\1\141\1\171\6\uffff\1"+
        "\163\1\72\1\141\1\145\1\141\1\162\2\uffff\1\145\1\157\1\uffff\2"+
        "\uffff\1\156\3\172\1\71\1\uffff\1\172\16\uffff\1\164\1\156\1\162"+
        "\11\uffff\1\162\1\151\1\156\1\145\1\163\1\172\1\160\2\172\1\uffff"+
        "\1\162\1\151\1\162\1\165\1\172\1\163\1\uffff\1\172\14\uffff\1\143"+
        "\1\160\1\145\1\165\6\uffff\1\163\1\147\2\uffff\1\162\1\164\1\165"+
        "\1\157\1\145\2\uffff\1\164\1\146\1\172\1\42\3\uffff\1\151\5\uffff"+
        "\1\163\1\141\1\143\1\172\1\164\1\165\2\164\1\160\1\143\1\145\1\157"+
        "\1\172\1\164\1\uffff\1\157\2\uffff\1\156\1\154\1\157\1\155\1\172"+
        "\1\uffff\1\145\1\uffff\1\172\1\153\1\145\1\156\2\145\1\157\1\172"+
        "\1\154\1\165\1\163\1\154\1\141\1\172\1\141\2\uffff\1\164\1\145\1"+
        "\154\1\164\1\uffff\1\151\1\143\1\156\1\143\1\151\1\164\1\154\1\153"+
        "\2\172\1\uffff\1\151\1\162\1\151\1\145\1\162\1\172\1\uffff\1\172"+
        "\1\uffff\1\141\3\172\2\162\1\uffff\1\172\1\162\1\163\1\145\1\153"+
        "\1\uffff\1\165\1\154\2\172\1\151\1\146\1\143\1\164\1\147\1\150\1"+
        "\156\1\172\1\145\1\172\2\uffff\1\141\1\164\1\156\2\172\2\uffff\1"+
        "\147\3\uffff\1\164\1\151\1\uffff\1\156\1\151\1\141\1\172\1\154\1"+
        "\151\2\uffff\1\157\1\165\4\172\1\165\1\uffff\1\170\1\uffff\1\154"+
        "\1\172\1\147\2\uffff\1\145\1\172\1\164\1\172\1\141\1\156\1\uffff"+
        "\2\164\1\156\1\154\4\uffff\1\157\2\172\1\uffff\2\172\1\uffff\1\150"+
        "\1\uffff\1\156\5\172\1\165\1\172\4\uffff\1\155\1\172\5\uffff\1\163"+
        "\1\uffff\1\172\1\uffff\1\172\2\uffff";
    static final String DFA11_acceptS =
        "\4\uffff\1\4\1\5\13\uffff\1\27\1\uffff\1\31\1\34\2\uffff\1\44\1"+
        "\45\1\46\1\50\1\52\1\53\6\uffff\1\71\1\72\3\uffff\1\107\1\110\5"+
        "\uffff\1\135\1\uffff\1\136\1\140\1\143\1\144\1\1\1\17\1\42\1\2\1"+
        "\105\1\3\1\4\1\5\1\54\1\6\3\uffff\1\136\1\10\1\25\1\26\1\32\1\33"+
        "\1\35\1\112\1\104\11\uffff\1\130\6\uffff\1\131\1\uffff\1\20\1\36"+
        "\1\22\1\21\1\24\1\23\1\27\1\141\1\142\1\30\1\31\1\34\4\uffff\1\44"+
        "\1\45\1\46\1\50\1\52\1\53\2\uffff\1\111\1\57\5\uffff\1\71\1\72\4"+
        "\uffff\1\137\1\107\1\110\1\uffff\1\127\1\134\1\135\1\140\1\143\16"+
        "\uffff\1\74\1\uffff\1\75\1\103\5\uffff\1\62\1\uffff\1\132\17\uffff"+
        "\1\120\1\106\4\uffff\1\113\12\uffff\1\64\6\uffff\1\115\1\uffff\1"+
        "\133\6\uffff\1\60\5\uffff\1\73\16\uffff\1\102\1\13\5\uffff\1\47"+
        "\1\77\1\uffff\1\41\1\76\1\126\2\uffff\1\63\6\uffff\1\7\1\16\7\uffff"+
        "\1\61\1\uffff\1\55\3\uffff\1\117\1\15\6\uffff\1\122\4\uffff\1\124"+
        "\1\43\1\70\1\100\3\uffff\1\40\2\uffff\1\56\1\uffff\1\123\10\uffff"+
        "\1\65\1\125\1\14\1\37\2\uffff\1\67\1\101\1\114\1\51\1\11\1\uffff"+
        "\1\121\1\uffff\1\66\1\uffff\1\116\1\12";
    static final String DFA11_specialS =
        "\1\1\46\uffff\1\0\u011b\uffff}>";
    static final String[] DFA11_transitionS = {
            "\11\64\2\63\2\64\1\63\22\64\1\63\1\16\1\47\2\64\1\23\1\3\1\4"+
            "\1\33\1\34\1\21\1\5\1\32\1\6\1\10\1\22\1\57\1\56\10\57\1\36"+
            "\1\30\1\17\1\1\1\20\2\64\4\61\1\55\25\61\1\43\1\64\1\44\1\24"+
            "\1\60\1\64\1\35\1\42\1\12\1\46\1\15\1\7\1\41\1\61\1\13\1\54"+
            "\1\61\1\45\1\61\1\53\1\61\1\25\1\61\1\40\1\11\1\26\1\52\1\37"+
            "\1\14\3\61\1\27\1\2\1\31\55\64\1\50\1\64\1\62\15\64\1\51\uff44"+
            "\64",
            "\1\66\1\65",
            "\1\70",
            "\1\72",
            "",
            "",
            "\1\75",
            "\1\77\15\uffff\1\101\5\uffff\1\100",
            "\1\107\4\uffff\1\103\1\104\1\uffff\1\105\1\111\1\106\56\uffff"+
            "\1\110",
            "\1\113\2\uffff\1\114",
            "\1\117\6\uffff\1\116\6\uffff\1\115",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\5\102\1\122\6"+
            "\102\1\121\1\120\4\102\1\123\7\102",
            "\1\125\6\uffff\1\126",
            "\12\134\7\uffff\32\102\4\uffff\1\102\1\uffff\13\102\1\132\1"+
            "\102\1\130\2\102\1\131\1\127\10\102",
            "\1\135",
            "\1\137",
            "\1\141",
            "",
            "\1\144\4\uffff\1\145",
            "",
            "",
            "\1\151",
            "\1\153\11\uffff\1\154\6\uffff\1\152",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\164\6\uffff\1\163",
            "\1\165",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\172\2\uffff\1\173",
            "",
            "",
            "\1\176",
            "\1\177\11\uffff\1\u0080",
            "\42\u0082\1\u0081\uffdd\u0082",
            "",
            "",
            "\1\u0085",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\12\134\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\12\u0088",
            "",
            "\32\102\6\uffff\32\102",
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
            "\1\u008b\7\uffff\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u008f\20\uffff\1\u0090",
            "\1\u0091",
            "\1\u0093\1\u0092",
            "\1\u0094",
            "\1\u0095",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\5\102\1\u0096"+
            "\2\102\1\u0098\12\102\1\u0097\6\102",
            "\1\u009a",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "",
            "\1\u009d",
            "\1\u009e",
            "\1\u009f",
            "\1\u00a1\20\uffff\1\u00a0",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\1\u00a3",
            "",
            "\12\134\7\uffff\32\102\4\uffff\1\102\1\uffff\10\102\2\u00a5"+
            "\20\102",
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
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "\1\u00a9",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00aa",
            "\1\u00ab",
            "",
            "",
            "\1\u00ac",
            "\1\u00ad\22\uffff\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b1",
            "",
            "",
            "\1\u00b2",
            "\1\u00b3",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\1\u00b5",
            "",
            "",
            "",
            "\1\u00b6",
            "",
            "",
            "",
            "",
            "",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00b9",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\1\u00bb",
            "\1\u00bd\13\uffff\1\u00bc",
            "\1\u00be",
            "\1\u00c0\1\u00bf",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\1\u00c6",
            "",
            "\1\u00c7",
            "",
            "",
            "\1\u00c8",
            "\1\u00c9",
            "\1\u00ca",
            "\1\u00cb",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "",
            "\1\u00cd",
            "",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "\1\u00d2",
            "\1\u00d3",
            "\1\u00d4",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "\1\u00da",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\1\u00dc",
            "",
            "",
            "\1\u00dd",
            "\1\u00de",
            "\1\u00df",
            "\1\u00e0",
            "",
            "\1\u00e1\3\uffff\1\u00e2",
            "\1\u00e3",
            "\1\u00e4",
            "\1\u00e5",
            "\1\u00e6",
            "\1\u00e7",
            "\1\u00e8",
            "\1\u00e9",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "",
            "\1\u00ec",
            "\1\u00ed",
            "\1\u00ee",
            "\1\u00ef",
            "\1\u00f0",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "",
            "\1\u00f3",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\1\u00f7",
            "\1\u00f8",
            "",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\1\u00fa",
            "\1\u00fb",
            "\1\u00fc",
            "\1\u00fd",
            "",
            "\1\u00fe",
            "\1\u00ff",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\1\u0102",
            "\1\u0103",
            "\1\u0104",
            "\1\u0105",
            "\1\u0106",
            "\1\u0107",
            "\1\u0108",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\1\u010a",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "",
            "",
            "\1\u010c",
            "\1\u010d",
            "\1\u010e",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "",
            "",
            "\1\u0111",
            "",
            "",
            "",
            "\1\u0112",
            "\1\u0113",
            "",
            "\1\u0114",
            "\1\u0115",
            "\1\u0116",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\1\u0118",
            "\1\u0119",
            "",
            "",
            "\1\u011a",
            "\1\u011b",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\1\u0120",
            "",
            "\1\u0121",
            "",
            "\1\u0122",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\1\u0124",
            "",
            "",
            "\1\u0125",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\1\u0127",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\1\u0129",
            "\1\u012a",
            "",
            "\1\u012b",
            "\1\u012c",
            "\1\u012d",
            "\1\u012e",
            "",
            "",
            "",
            "",
            "\1\u0130\11\uffff\1\u012f",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "",
            "\1\u0135",
            "",
            "\1\u0136",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\1\u013c",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "",
            "",
            "",
            "",
            "\1\u013e",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "",
            "",
            "",
            "",
            "",
            "\1\u0140",
            "",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "",
            ""
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | RULE_N | RULE_IJ | RULE_E | RULE_EXP | RULE_EXPIJ | RULE_ONE | RULE_INT | RULE_ID | RULE_STRING | RULE_CONSTANT_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA11_39 = input.LA(1);

                        s = -1;
                        if ( (LA11_39=='\"') ) {s = 129;}

                        else if ( ((LA11_39>='\u0000' && LA11_39<='!')||(LA11_39>='#' && LA11_39<='\uFFFF')) ) {s = 130;}

                        else s = 52;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA11_0 = input.LA(1);

                        s = -1;
                        if ( (LA11_0=='=') ) {s = 1;}

                        else if ( (LA11_0=='|') ) {s = 2;}

                        else if ( (LA11_0=='&') ) {s = 3;}

                        else if ( (LA11_0=='\'') ) {s = 4;}

                        else if ( (LA11_0=='+') ) {s = 5;}

                        else if ( (LA11_0=='-') ) {s = 6;}

                        else if ( (LA11_0=='f') ) {s = 7;}

                        else if ( (LA11_0=='.') ) {s = 8;}

                        else if ( (LA11_0=='s') ) {s = 9;}

                        else if ( (LA11_0=='c') ) {s = 10;}

                        else if ( (LA11_0=='i') ) {s = 11;}

                        else if ( (LA11_0=='w') ) {s = 12;}

                        else if ( (LA11_0=='e') ) {s = 13;}

                        else if ( (LA11_0=='!') ) {s = 14;}

                        else if ( (LA11_0=='<') ) {s = 15;}

                        else if ( (LA11_0=='>') ) {s = 16;}

                        else if ( (LA11_0=='*') ) {s = 17;}

                        else if ( (LA11_0=='/') ) {s = 18;}

                        else if ( (LA11_0=='%') ) {s = 19;}

                        else if ( (LA11_0=='^') ) {s = 20;}

                        else if ( (LA11_0=='p') ) {s = 21;}

                        else if ( (LA11_0=='t') ) {s = 22;}

                        else if ( (LA11_0=='{') ) {s = 23;}

                        else if ( (LA11_0==';') ) {s = 24;}

                        else if ( (LA11_0=='}') ) {s = 25;}

                        else if ( (LA11_0==',') ) {s = 26;}

                        else if ( (LA11_0=='(') ) {s = 27;}

                        else if ( (LA11_0==')') ) {s = 28;}

                        else if ( (LA11_0=='a') ) {s = 29;}

                        else if ( (LA11_0==':') ) {s = 30;}

                        else if ( (LA11_0=='v') ) {s = 31;}

                        else if ( (LA11_0=='r') ) {s = 32;}

                        else if ( (LA11_0=='g') ) {s = 33;}

                        else if ( (LA11_0=='b') ) {s = 34;}

                        else if ( (LA11_0=='[') ) {s = 35;}

                        else if ( (LA11_0==']') ) {s = 36;}

                        else if ( (LA11_0=='l') ) {s = 37;}

                        else if ( (LA11_0=='d') ) {s = 38;}

                        else if ( (LA11_0=='\"') ) {s = 39;}

                        else if ( (LA11_0=='\u00AB') ) {s = 40;}

                        else if ( (LA11_0=='\u00BB') ) {s = 41;}

                        else if ( (LA11_0=='u') ) {s = 42;}

                        else if ( (LA11_0=='n') ) {s = 43;}

                        else if ( (LA11_0=='j') ) {s = 44;}

                        else if ( (LA11_0=='E') ) {s = 45;}

                        else if ( (LA11_0=='1') ) {s = 46;}

                        else if ( (LA11_0=='0'||(LA11_0>='2' && LA11_0<='9')) ) {s = 47;}

                        else if ( (LA11_0=='_') ) {s = 48;}

                        else if ( ((LA11_0>='A' && LA11_0<='D')||(LA11_0>='F' && LA11_0<='Z')||LA11_0=='h'||LA11_0=='k'||LA11_0=='m'||LA11_0=='o'||LA11_0=='q'||(LA11_0>='x' && LA11_0<='z')) ) {s = 49;}

                        else if ( (LA11_0=='\u00AD') ) {s = 50;}

                        else if ( ((LA11_0>='\t' && LA11_0<='\n')||LA11_0=='\r'||LA11_0==' ') ) {s = 51;}

                        else if ( ((LA11_0>='\u0000' && LA11_0<='\b')||(LA11_0>='\u000B' && LA11_0<='\f')||(LA11_0>='\u000E' && LA11_0<='\u001F')||(LA11_0>='#' && LA11_0<='$')||(LA11_0>='?' && LA11_0<='@')||LA11_0=='\\'||LA11_0=='`'||(LA11_0>='~' && LA11_0<='\u00AA')||LA11_0=='\u00AC'||(LA11_0>='\u00AE' && LA11_0<='\u00BA')||(LA11_0>='\u00BC' && LA11_0<='\uFFFF')) ) {s = 52;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 11, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}