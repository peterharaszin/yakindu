package org.yakindu.sct.model.stext.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSTextLexer extends Lexer {
    public static final int T__42=42;
    public static final int T__28=28;
    public static final int T__57=57;
    public static final int T__23=23;
    public static final int T__51=51;
    public static final int T__13=13;
    public static final int T__47=47;
    public static final int RULE_STRING=6;
    public static final int T__50=50;
    public static final int T__21=21;
    public static final int T__19=19;
    public static final int T__65=65;
    public static final int RULE_FLOAT=7;
    public static final int T__39=39;
    public static final int T__30=30;
    public static final int T__46=46;
    public static final int T__52=52;
    public static final int T__17=17;
    public static final int T__62=62;
    public static final int RULE_INT=5;
    public static final int T__27=27;
    public static final int T__24=24;
    public static final int T__49=49;
    public static final int T__61=61;
    public static final int T__59=59;
    public static final int T__54=54;
    public static final int T__48=48;
    public static final int T__34=34;
    public static final int T__56=56;
    public static final int T__15=15;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__35=35;
    public static final int RULE_ID=8;
    public static final int T__36=36;
    public static final int T__20=20;
    public static final int T__58=58;
    public static final int T__64=64;
    public static final int T__44=44;
    public static final int T__14=14;
    public static final int T__33=33;
    public static final int T__22=22;
    public static final int T__45=45;
    public static final int T__29=29;
    public static final int T__55=55;
    public static final int T__63=63;
    public static final int RULE_WS=11;
    public static final int T__43=43;
    public static final int T__31=31;
    public static final int T__40=40;
    public static final int EOF=-1;
    public static final int T__53=53;
    public static final int T__32=32;
    public static final int T__16=16;
    public static final int T__38=38;
    public static final int T__37=37;
    public static final int RULE_BOOL=4;
    public static final int T__26=26;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__25=25;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__60=60;
    public static final int T__41=41;
    public static final int T__18=18;

    // delegates
    // delegators

    public InternalSTextLexer() {;} 
    public InternalSTextLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalSTextLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11:7: ( 'in' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11:9: 'in'
            {
            match("in"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:12:7: ( 'out' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:12:9: 'out'
            {
            match("out"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:13:7: ( '+' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:13:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:14:7: ( '-' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:14:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:15:7: ( '*' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:15:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:16:7: ( '/' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:16:9: '/'
            {
            match('/'); 

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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:17:7: ( '%' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:17:9: '%'
            {
            match('%'); 

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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:18:7: ( '~' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:18:9: '~'
            {
            match('~'); 

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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:19:7: ( '<' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:19:9: '<'
            {
            match('<'); 

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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:20:7: ( '<=' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:20:9: '<='
            {
            match("<="); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:21:7: ( '>' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:21:9: '>'
            {
            match('>'); 

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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:22:7: ( '>=' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:22:9: '>='
            {
            match(">="); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:23:7: ( '==' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:23:9: '=='
            {
            match("=="); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:24:7: ( '!=' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:24:9: '!='
            {
            match("!="); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:25:7: ( 's' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:25:9: 's'
            {
            match('s'); 

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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:26:7: ( 'ms' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:26:9: 'ms'
            {
            match("ms"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:27:7: ( 'ns' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:27:9: 'ns'
            {
            match("ns"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:28:7: ( 'void' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:28:9: 'void'
            {
            match("void"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:29:7: ( 'integer' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:29:9: 'integer'
            {
            match("integer"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:30:7: ( 'real' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:30:9: 'real'
            {
            match("real"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:31:7: ( 'boolean' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:31:9: 'boolean'
            {
            match("boolean"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:32:7: ( 'string' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:32:9: 'string'
            {
            match("string"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:33:7: ( '@@statechart@@' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:33:9: '@@statechart@@'
            {
            match("@@statechart@@"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:34:7: ( '@@state@@' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:34:9: '@@state@@'
            {
            match("@@state@@"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:35:7: ( '@@transition@@' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:35:9: '@@transition@@'
            {
            match("@@transition@@"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:36:7: ( 'interface' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:36:9: 'interface'
            {
            match("interface"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:37:7: ( ':' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:37:9: ':'
            {
            match(':'); 

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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:38:7: ( 'internal' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:38:9: 'internal'
            {
            match("internal"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:39:7: ( 'event' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:39:9: 'event'
            {
            match("event"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:40:7: ( '=' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:40:9: '='
            {
            match('='); 

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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:41:7: ( 'var' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:41:9: 'var'
            {
            match("var"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:42:7: ( 'clock' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:42:9: 'clock'
            {
            match("clock"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:43:7: ( 'operation' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:43:9: 'operation'
            {
            match("operation"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:44:7: ( '(' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:44:9: '('
            {
            match('('); 

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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:45:7: ( ')' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:45:9: ')'
            {
            match(')'); 

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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:46:7: ( ',' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:46:9: ','
            {
            match(','); 

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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:47:7: ( 'entrypoint' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:47:9: 'entrypoint'
            {
            match("entrypoint"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:48:7: ( 'exitpoint' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:48:9: 'exitpoint'
            {
            match("exitpoint"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:49:7: ( '#' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:49:9: '#'
            {
            match('#'); 

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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:50:7: ( '[' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:50:9: '['
            {
            match('['); 

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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:51:7: ( ']' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:51:9: ']'
            {
            match(']'); 

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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:52:7: ( ';' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:52:9: ';'
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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:53:7: ( 'after' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:53:9: 'after'
            {
            match("after"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:54:7: ( 'entry' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:54:9: 'entry'
            {
            match("entry"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:55:7: ( 'exit' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:55:9: 'exit'
            {
            match("exit"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:56:7: ( 'oncycle' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:56:9: 'oncycle'
            {
            match("oncycle"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:57:7: ( 'always' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:57:9: 'always'
            {
            match("always"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:58:7: ( 'raise' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:58:9: 'raise'
            {
            match("raise"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:59:7: ( '||' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:59:9: '||'
            {
            match("||"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:60:7: ( '&&' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:60:9: '&&'
            {
            match("&&"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:61:7: ( '!' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:61:9: '!'
            {
            match('!'); 

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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:62:7: ( 'readonly' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:62:9: 'readonly'
            {
            match("readonly"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:63:7: ( 'external' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:63:9: 'external'
            {
            match("external"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "RULE_BOOL"
    public final void mRULE_BOOL() throws RecognitionException {
        try {
            int _type = RULE_BOOL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8733:11: ( ( 'true' | 'false' ) )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8733:13: ( 'true' | 'false' )
            {
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8733:13: ( 'true' | 'false' )
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
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8733:14: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8733:21: 'false'
                    {
                    match("false"); 


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
    // $ANTLR end "RULE_BOOL"

    // $ANTLR start "RULE_FLOAT"
    public final void mRULE_FLOAT() throws RecognitionException {
        try {
            int _type = RULE_FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8735:12: ( ( '-' | '+' )? RULE_INT '.' RULE_INT ( 'e' ( '-' | '+' ) RULE_INT )? ( 'f' | 'F' | 'd' | 'D' )? )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8735:14: ( '-' | '+' )? RULE_INT '.' RULE_INT ( 'e' ( '-' | '+' ) RULE_INT )? ( 'f' | 'F' | 'd' | 'D' )?
            {
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8735:14: ( '-' | '+' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='+'||LA2_0=='-') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            mRULE_INT(); 
            match('.'); 
            mRULE_INT(); 
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8735:47: ( 'e' ( '-' | '+' ) RULE_INT )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='e') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8735:48: 'e' ( '-' | '+' ) RULE_INT
                    {
                    match('e'); 
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    mRULE_INT(); 

                    }
                    break;

            }

            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8735:73: ( 'f' | 'F' | 'd' | 'D' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='D'||LA4_0=='F'||LA4_0=='d'||LA4_0=='f') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:
                    {
                    if ( input.LA(1)=='D'||input.LA(1)=='F'||input.LA(1)=='d'||input.LA(1)=='f' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


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
    // $ANTLR end "RULE_FLOAT"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8737:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8737:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8737:11: ( '^' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='^') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8737:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8737:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')||(LA6_0>='A' && LA6_0<='Z')||LA6_0=='_'||(LA6_0>='a' && LA6_0<='z')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:
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
            	    break loop6;
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

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8739:10: ( ( '0' .. '9' )+ )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8739:12: ( '0' .. '9' )+
            {
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8739:12: ( '0' .. '9' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8739:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8741:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8741:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8741:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\"') ) {
                alt10=1;
            }
            else if ( (LA10_0=='\'') ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8741:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8741:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop8:
                    do {
                        int alt8=3;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0=='\\') ) {
                            alt8=1;
                        }
                        else if ( ((LA8_0>='\u0000' && LA8_0<='!')||(LA8_0>='#' && LA8_0<='[')||(LA8_0>=']' && LA8_0<='\uFFFF')) ) {
                            alt8=2;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8741:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8741:66: ~ ( ( '\\\\' | '\"' ) )
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

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8741:86: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8741:91: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop9:
                    do {
                        int alt9=3;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0=='\\') ) {
                            alt9=1;
                        }
                        else if ( ((LA9_0>='\u0000' && LA9_0<='&')||(LA9_0>='(' && LA9_0<='[')||(LA9_0>=']' && LA9_0<='\uFFFF')) ) {
                            alt9=2;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8741:92: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8741:137: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    match('\''); 

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
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8743:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8743:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8743:24: ( options {greedy=false; } : . )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='*') ) {
                    int LA11_1 = input.LA(2);

                    if ( (LA11_1=='/') ) {
                        alt11=2;
                    }
                    else if ( ((LA11_1>='\u0000' && LA11_1<='.')||(LA11_1>='0' && LA11_1<='\uFFFF')) ) {
                        alt11=1;
                    }


                }
                else if ( ((LA11_0>='\u0000' && LA11_0<=')')||(LA11_0>='+' && LA11_0<='\uFFFF')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8743:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop11;
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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8745:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8745:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8745:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='\u0000' && LA12_0<='\t')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\uFFFF')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8745:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop12;
                }
            } while (true);

            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8745:40: ( ( '\\r' )? '\\n' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='\n'||LA14_0=='\r') ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8745:41: ( '\\r' )? '\\n'
                    {
                    // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8745:41: ( '\\r' )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0=='\r') ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8745:41: '\\r'
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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8747:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8747:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8747:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>='\t' && LA15_0<='\n')||LA15_0=='\r'||LA15_0==' ') ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:
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
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8749:16: ( . )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:8749:18: .
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
        // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | RULE_BOOL | RULE_FLOAT | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt16=62;
        alt16 = dfa16.predict(input);
        switch (alt16) {
            case 1 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:10: T__13
                {
                mT__13(); 

                }
                break;
            case 2 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:16: T__14
                {
                mT__14(); 

                }
                break;
            case 3 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:22: T__15
                {
                mT__15(); 

                }
                break;
            case 4 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:28: T__16
                {
                mT__16(); 

                }
                break;
            case 5 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:34: T__17
                {
                mT__17(); 

                }
                break;
            case 6 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:40: T__18
                {
                mT__18(); 

                }
                break;
            case 7 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:46: T__19
                {
                mT__19(); 

                }
                break;
            case 8 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:52: T__20
                {
                mT__20(); 

                }
                break;
            case 9 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:58: T__21
                {
                mT__21(); 

                }
                break;
            case 10 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:64: T__22
                {
                mT__22(); 

                }
                break;
            case 11 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:70: T__23
                {
                mT__23(); 

                }
                break;
            case 12 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:76: T__24
                {
                mT__24(); 

                }
                break;
            case 13 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:82: T__25
                {
                mT__25(); 

                }
                break;
            case 14 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:88: T__26
                {
                mT__26(); 

                }
                break;
            case 15 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:94: T__27
                {
                mT__27(); 

                }
                break;
            case 16 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:100: T__28
                {
                mT__28(); 

                }
                break;
            case 17 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:106: T__29
                {
                mT__29(); 

                }
                break;
            case 18 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:112: T__30
                {
                mT__30(); 

                }
                break;
            case 19 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:118: T__31
                {
                mT__31(); 

                }
                break;
            case 20 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:124: T__32
                {
                mT__32(); 

                }
                break;
            case 21 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:130: T__33
                {
                mT__33(); 

                }
                break;
            case 22 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:136: T__34
                {
                mT__34(); 

                }
                break;
            case 23 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:142: T__35
                {
                mT__35(); 

                }
                break;
            case 24 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:148: T__36
                {
                mT__36(); 

                }
                break;
            case 25 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:154: T__37
                {
                mT__37(); 

                }
                break;
            case 26 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:160: T__38
                {
                mT__38(); 

                }
                break;
            case 27 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:166: T__39
                {
                mT__39(); 

                }
                break;
            case 28 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:172: T__40
                {
                mT__40(); 

                }
                break;
            case 29 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:178: T__41
                {
                mT__41(); 

                }
                break;
            case 30 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:184: T__42
                {
                mT__42(); 

                }
                break;
            case 31 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:190: T__43
                {
                mT__43(); 

                }
                break;
            case 32 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:196: T__44
                {
                mT__44(); 

                }
                break;
            case 33 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:202: T__45
                {
                mT__45(); 

                }
                break;
            case 34 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:208: T__46
                {
                mT__46(); 

                }
                break;
            case 35 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:214: T__47
                {
                mT__47(); 

                }
                break;
            case 36 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:220: T__48
                {
                mT__48(); 

                }
                break;
            case 37 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:226: T__49
                {
                mT__49(); 

                }
                break;
            case 38 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:232: T__50
                {
                mT__50(); 

                }
                break;
            case 39 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:238: T__51
                {
                mT__51(); 

                }
                break;
            case 40 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:244: T__52
                {
                mT__52(); 

                }
                break;
            case 41 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:250: T__53
                {
                mT__53(); 

                }
                break;
            case 42 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:256: T__54
                {
                mT__54(); 

                }
                break;
            case 43 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:262: T__55
                {
                mT__55(); 

                }
                break;
            case 44 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:268: T__56
                {
                mT__56(); 

                }
                break;
            case 45 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:274: T__57
                {
                mT__57(); 

                }
                break;
            case 46 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:280: T__58
                {
                mT__58(); 

                }
                break;
            case 47 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:286: T__59
                {
                mT__59(); 

                }
                break;
            case 48 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:292: T__60
                {
                mT__60(); 

                }
                break;
            case 49 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:298: T__61
                {
                mT__61(); 

                }
                break;
            case 50 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:304: T__62
                {
                mT__62(); 

                }
                break;
            case 51 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:310: T__63
                {
                mT__63(); 

                }
                break;
            case 52 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:316: T__64
                {
                mT__64(); 

                }
                break;
            case 53 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:322: T__65
                {
                mT__65(); 

                }
                break;
            case 54 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:328: RULE_BOOL
                {
                mRULE_BOOL(); 

                }
                break;
            case 55 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:338: RULE_FLOAT
                {
                mRULE_FLOAT(); 

                }
                break;
            case 56 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:349: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 57 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:357: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 58 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:366: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 59 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:378: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 60 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:394: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 61 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:410: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 62 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:418: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA16 dfa16 = new DFA16(this);
    static final String DFA16_eotS =
        "\1\uffff\2\53\1\57\1\61\1\uffff\1\65\2\uffff\1\71\1\73\1\75\1\77"+
        "\1\101\5\53\1\51\1\uffff\2\53\7\uffff\1\53\2\51\2\53\1\134\1\51"+
        "\1\uffff\2\51\2\uffff\1\141\1\uffff\3\53\21\uffff\1\53\1\uffff\1"+
        "\146\1\147\5\53\2\uffff\4\53\7\uffff\2\53\2\uffff\2\53\1\uffff\1"+
        "\134\2\uffff\1\53\1\uffff\1\171\3\53\2\uffff\1\53\1\176\3\53\2\uffff"+
        "\12\53\1\uffff\3\53\1\u0092\1\uffff\1\u0093\3\53\1\uffff\2\53\1"+
        "\u009b\4\53\1\u00a0\6\53\2\uffff\1\53\1\u00a9\1\53\1\uffff\1\u00ac"+
        "\1\u00ae\1\53\1\uffff\1\53\1\u00b1\1\u00b2\1\53\1\uffff\1\u00a0"+
        "\5\53\1\u00b9\1\53\1\uffff\1\53\2\uffff\1\53\1\uffff\2\53\2\uffff"+
        "\1\u00c0\1\u00c1\3\53\1\u00c5\1\uffff\1\53\1\u00c7\1\uffff\3\53"+
        "\2\uffff\1\53\1\u00ce\1\53\1\uffff\1\u00d0\3\uffff\2\53\1\u00d3"+
        "\1\u00d4\1\uffff\1\u00d5\1\uffff\1\53\1\u00d7\3\uffff\1\u00d8\2"+
        "\uffff";
    static final String DFA16_eofS =
        "\u00d9\uffff";
    static final String DFA16_minS =
        "\1\0\2\156\2\60\1\uffff\1\52\2\uffff\4\75\1\60\2\163\2\141\1\157"+
        "\1\100\1\uffff\1\156\1\154\7\uffff\1\146\1\174\1\46\1\162\1\141"+
        "\1\56\1\101\1\uffff\2\0\2\uffff\1\60\1\uffff\1\164\1\145\1\143\21"+
        "\uffff\1\162\1\uffff\2\60\1\151\1\162\1\141\1\151\1\157\1\163\1"+
        "\uffff\1\145\1\164\1\151\1\157\7\uffff\1\164\1\167\2\uffff\1\165"+
        "\1\154\1\uffff\1\56\2\uffff\1\145\1\uffff\1\60\1\162\1\171\1\151"+
        "\2\uffff\1\144\1\60\1\144\1\163\1\154\1\164\1\uffff\1\156\1\162"+
        "\1\164\1\145\1\143\1\145\1\141\1\145\1\163\1\147\1\uffff\1\141\1"+
        "\143\1\156\1\60\1\uffff\1\60\1\157\2\145\1\141\1\164\1\171\1\60"+
        "\1\162\1\153\1\162\1\171\1\60\2\145\1\146\1\164\1\154\1\147\2\uffff"+
        "\1\156\1\60\1\141\1\164\2\60\1\157\1\uffff\1\156\2\60\1\163\1\uffff"+
        "\1\60\1\162\2\141\1\151\1\145\1\60\1\154\1\uffff\1\156\1\145\1\uffff"+
        "\1\157\1\uffff\1\151\1\141\2\uffff\2\60\1\143\1\154\1\157\1\60\1"+
        "\uffff\1\171\1\60\1\100\1\151\1\156\1\154\2\uffff\1\145\1\60\1\156"+
        "\1\uffff\1\60\3\uffff\1\156\1\164\2\60\1\uffff\1\60\1\uffff\1\164"+
        "\1\60\3\uffff\1\60\2\uffff";
    static final String DFA16_maxS =
        "\1\uffff\1\156\1\165\2\71\1\uffff\1\57\2\uffff\4\75\1\172\2\163"+
        "\1\157\1\145\1\157\1\100\1\uffff\1\170\1\154\7\uffff\1\154\1\174"+
        "\1\46\1\162\1\141\1\71\1\172\1\uffff\2\uffff\2\uffff\1\172\1\uffff"+
        "\1\164\1\145\1\143\21\uffff\1\162\1\uffff\2\172\1\151\1\162\1\141"+
        "\1\151\1\157\1\164\1\uffff\1\145\2\164\1\157\7\uffff\1\164\1\167"+
        "\2\uffff\1\165\1\154\1\uffff\1\71\2\uffff\1\145\1\uffff\1\172\1"+
        "\162\1\171\1\151\2\uffff\1\144\1\172\1\154\1\163\1\154\1\164\1\uffff"+
        "\1\156\1\162\1\164\1\145\1\143\1\145\1\141\1\145\1\163\1\162\1\uffff"+
        "\1\141\1\143\1\156\1\172\1\uffff\1\172\1\157\2\145\1\141\1\164\1"+
        "\171\1\172\1\162\1\153\1\162\1\171\1\172\2\145\1\156\1\164\1\154"+
        "\1\147\2\uffff\1\156\1\172\1\141\1\164\2\172\1\157\1\uffff\1\156"+
        "\2\172\1\163\1\uffff\1\172\1\162\2\141\1\151\1\145\1\172\1\154\1"+
        "\uffff\1\156\1\145\1\uffff\1\157\1\uffff\1\151\1\141\2\uffff\2\172"+
        "\1\143\1\154\1\157\1\172\1\uffff\1\171\1\172\1\143\1\151\1\156\1"+
        "\154\2\uffff\1\145\1\172\1\156\1\uffff\1\172\3\uffff\1\156\1\164"+
        "\2\172\1\uffff\1\172\1\uffff\1\164\1\172\3\uffff\1\172\2\uffff";
    static final String DFA16_acceptS =
        "\5\uffff\1\5\1\uffff\1\7\1\10\13\uffff\1\33\2\uffff\1\42\1\43\1"+
        "\44\1\47\1\50\1\51\1\52\7\uffff\1\70\2\uffff\1\75\1\76\1\uffff\1"+
        "\70\3\uffff\1\3\1\67\1\4\1\5\1\73\1\74\1\6\1\7\1\10\1\12\1\11\1"+
        "\14\1\13\1\15\1\36\1\16\1\63\1\uffff\1\17\10\uffff\1\33\4\uffff"+
        "\1\42\1\43\1\44\1\47\1\50\1\51\1\52\2\uffff\1\61\1\62\2\uffff\1"+
        "\71\1\uffff\1\72\1\75\1\uffff\1\1\4\uffff\1\20\1\21\6\uffff\1\31"+
        "\12\uffff\1\2\4\uffff\1\37\23\uffff\1\22\1\24\7\uffff\1\55\4\uffff"+
        "\1\66\10\uffff\1\60\2\uffff\1\35\1\uffff\1\54\2\uffff\1\40\1\53"+
        "\6\uffff\1\26\6\uffff\1\57\1\23\3\uffff\1\56\1\uffff\1\25\1\27\1"+
        "\30\4\uffff\1\34\1\uffff\1\64\2\uffff\1\65\1\32\1\41\1\uffff\1\46"+
        "\1\45";
    static final String DFA16_specialS =
        "\1\1\45\uffff\1\0\1\2\u00b1\uffff}>";
    static final String[] DFA16_transitionS = {
            "\11\51\2\50\2\51\1\50\22\51\1\50\1\14\1\46\1\32\1\51\1\7\1\40"+
            "\1\47\1\27\1\30\1\5\1\3\1\31\1\4\1\51\1\6\12\43\1\24\1\35\1"+
            "\11\1\13\1\12\1\51\1\23\32\45\1\33\1\51\1\34\1\44\1\45\1\51"+
            "\1\36\1\22\1\26\1\45\1\25\1\42\2\45\1\1\3\45\1\16\1\17\1\2\2"+
            "\45\1\21\1\15\1\41\1\45\1\20\4\45\1\51\1\37\1\51\1\10\uff81"+
            "\51",
            "\1\52",
            "\1\56\1\uffff\1\55\4\uffff\1\54",
            "\12\60",
            "\12\60",
            "",
            "\1\63\4\uffff\1\64",
            "",
            "",
            "\1\70",
            "\1\72",
            "\1\74",
            "\1\76",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\23\53\1\100\6\53",
            "\1\102",
            "\1\103",
            "\1\105\15\uffff\1\104",
            "\1\107\3\uffff\1\106",
            "\1\110",
            "\1\111",
            "",
            "\1\114\7\uffff\1\113\1\uffff\1\115",
            "\1\116",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\126\5\uffff\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\60\1\uffff\12\135",
            "\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\0\136",
            "\0\136",
            "",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\23\53\1\140\6\53",
            "",
            "\1\142",
            "\1\143",
            "\1\144",
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
            "",
            "",
            "",
            "\1\145",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\150",
            "\1\151",
            "\1\152",
            "\1\153",
            "\1\154",
            "\1\155\1\156",
            "",
            "\1\157",
            "\1\160",
            "\1\161\12\uffff\1\162",
            "\1\163",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\164",
            "\1\165",
            "",
            "",
            "\1\166",
            "\1\167",
            "",
            "\1\60\1\uffff\12\135",
            "",
            "",
            "\1\170",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\172",
            "\1\173",
            "\1\174",
            "",
            "",
            "\1\175",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0080\7\uffff\1\177",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "\1\u008d\12\uffff\1\u008e",
            "",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\17\53\1\u009a\12"+
            "\53",
            "\1\u009c",
            "\1\u009d",
            "\1\u009e",
            "\1\u009f",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u00a1",
            "\1\u00a2",
            "\1\u00a3\7\uffff\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "",
            "",
            "\1\u00a8",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u00aa",
            "\1\u00ab",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\17\53\1\u00ad\12"+
            "\53",
            "\1\u00af",
            "",
            "\1\u00b0",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u00b3",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u00ba",
            "",
            "\1\u00bb",
            "\1\u00bc",
            "",
            "\1\u00bd",
            "",
            "\1\u00be",
            "\1\u00bf",
            "",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\1\u00c6",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u00c9\42\uffff\1\u00c8",
            "\1\u00ca",
            "\1\u00cb",
            "\1\u00cc",
            "",
            "",
            "\1\u00cd",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u00cf",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "",
            "",
            "\1\u00d1",
            "\1\u00d2",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\1\u00d6",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            ""
    };

    static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
    static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
    static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
    static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
    static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
    static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
    static final short[][] DFA16_transition;

    static {
        int numStates = DFA16_transitionS.length;
        DFA16_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
        }
    }

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = DFA16_eot;
            this.eof = DFA16_eof;
            this.min = DFA16_min;
            this.max = DFA16_max;
            this.accept = DFA16_accept;
            this.special = DFA16_special;
            this.transition = DFA16_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | RULE_BOOL | RULE_FLOAT | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA16_38 = input.LA(1);

                        s = -1;
                        if ( ((LA16_38>='\u0000' && LA16_38<='\uFFFF')) ) {s = 94;}

                        else s = 41;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA16_0 = input.LA(1);

                        s = -1;
                        if ( (LA16_0=='i') ) {s = 1;}

                        else if ( (LA16_0=='o') ) {s = 2;}

                        else if ( (LA16_0=='+') ) {s = 3;}

                        else if ( (LA16_0=='-') ) {s = 4;}

                        else if ( (LA16_0=='*') ) {s = 5;}

                        else if ( (LA16_0=='/') ) {s = 6;}

                        else if ( (LA16_0=='%') ) {s = 7;}

                        else if ( (LA16_0=='~') ) {s = 8;}

                        else if ( (LA16_0=='<') ) {s = 9;}

                        else if ( (LA16_0=='>') ) {s = 10;}

                        else if ( (LA16_0=='=') ) {s = 11;}

                        else if ( (LA16_0=='!') ) {s = 12;}

                        else if ( (LA16_0=='s') ) {s = 13;}

                        else if ( (LA16_0=='m') ) {s = 14;}

                        else if ( (LA16_0=='n') ) {s = 15;}

                        else if ( (LA16_0=='v') ) {s = 16;}

                        else if ( (LA16_0=='r') ) {s = 17;}

                        else if ( (LA16_0=='b') ) {s = 18;}

                        else if ( (LA16_0=='@') ) {s = 19;}

                        else if ( (LA16_0==':') ) {s = 20;}

                        else if ( (LA16_0=='e') ) {s = 21;}

                        else if ( (LA16_0=='c') ) {s = 22;}

                        else if ( (LA16_0=='(') ) {s = 23;}

                        else if ( (LA16_0==')') ) {s = 24;}

                        else if ( (LA16_0==',') ) {s = 25;}

                        else if ( (LA16_0=='#') ) {s = 26;}

                        else if ( (LA16_0=='[') ) {s = 27;}

                        else if ( (LA16_0==']') ) {s = 28;}

                        else if ( (LA16_0==';') ) {s = 29;}

                        else if ( (LA16_0=='a') ) {s = 30;}

                        else if ( (LA16_0=='|') ) {s = 31;}

                        else if ( (LA16_0=='&') ) {s = 32;}

                        else if ( (LA16_0=='t') ) {s = 33;}

                        else if ( (LA16_0=='f') ) {s = 34;}

                        else if ( ((LA16_0>='0' && LA16_0<='9')) ) {s = 35;}

                        else if ( (LA16_0=='^') ) {s = 36;}

                        else if ( ((LA16_0>='A' && LA16_0<='Z')||LA16_0=='_'||LA16_0=='d'||(LA16_0>='g' && LA16_0<='h')||(LA16_0>='j' && LA16_0<='l')||(LA16_0>='p' && LA16_0<='q')||LA16_0=='u'||(LA16_0>='w' && LA16_0<='z')) ) {s = 37;}

                        else if ( (LA16_0=='\"') ) {s = 38;}

                        else if ( (LA16_0=='\'') ) {s = 39;}

                        else if ( ((LA16_0>='\t' && LA16_0<='\n')||LA16_0=='\r'||LA16_0==' ') ) {s = 40;}

                        else if ( ((LA16_0>='\u0000' && LA16_0<='\b')||(LA16_0>='\u000B' && LA16_0<='\f')||(LA16_0>='\u000E' && LA16_0<='\u001F')||LA16_0=='$'||LA16_0=='.'||LA16_0=='?'||LA16_0=='\\'||LA16_0=='`'||LA16_0=='{'||LA16_0=='}'||(LA16_0>='\u007F' && LA16_0<='\uFFFF')) ) {s = 41;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA16_39 = input.LA(1);

                        s = -1;
                        if ( ((LA16_39>='\u0000' && LA16_39<='\uFFFF')) ) {s = 94;}

                        else s = 41;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 16, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}