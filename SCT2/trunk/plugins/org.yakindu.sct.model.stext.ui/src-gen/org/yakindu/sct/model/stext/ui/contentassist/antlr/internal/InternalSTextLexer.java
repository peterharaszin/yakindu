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
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int RULE_ID=4;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__29=29;
    public static final int T__64=64;
    public static final int T__28=28;
    public static final int T__65=65;
    public static final int T__27=27;
    public static final int T__62=62;
    public static final int T__26=26;
    public static final int T__63=63;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=13;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_BOOL=6;
    public static final int T__61=61;
    public static final int EOF=-1;
    public static final int T__60=60;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__19=19;
    public static final int T__57=57;
    public static final int RULE_HEX=8;
    public static final int T__58=58;
    public static final int T__16=16;
    public static final int T__51=51;
    public static final int T__90=90;
    public static final int T__15=15;
    public static final int T__52=52;
    public static final int T__18=18;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int T__59=59;
    public static final int RULE_INT=5;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__80=80;
    public static final int T__47=47;
    public static final int T__81=81;
    public static final int T__44=44;
    public static final int T__82=82;
    public static final int T__45=45;
    public static final int T__83=83;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__85=85;
    public static final int RULE_FLOAT=7;
    public static final int T__84=84;
    public static final int RULE_SL_COMMENT=11;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int T__88=88;
    public static final int RULE_ML_COMMENT=10;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_STRING=9;
    public static final int T__33=33;
    public static final int T__71=71;
    public static final int T__34=34;
    public static final int T__72=72;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__70=70;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__76=76;
    public static final int RULE_WS=12;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int T__77=77;

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

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11:7: ( 'default' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11:9: 'default'
            {
            match("default"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:12:7: ( 'else' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:12:9: 'else'
            {
            match("else"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:13:7: ( 'local' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:13:9: 'local'
            {
            match("local"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:14:7: ( 'in' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:14:9: 'in'
            {
            match("in"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:15:7: ( 'out' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:15:9: 'out'
            {
            match("out"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:16:7: ( 'after' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:16:9: 'after'
            {
            match("after"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:17:7: ( 'every' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:17:9: 'every'
            {
            match("every"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:18:7: ( '=' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:18:9: '='
            {
            match('='); 

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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:19:7: ( '*=' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:19:9: '*='
            {
            match("*="); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:20:7: ( '/=' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:20:9: '/='
            {
            match("/="); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:21:7: ( '%=' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:21:9: '%='
            {
            match("%="); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:22:7: ( '+=' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:22:9: '+='
            {
            match("+="); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:23:7: ( '-=' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:23:9: '-='
            {
            match("-="); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:24:7: ( '<<=' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:24:9: '<<='
            {
            match("<<="); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:25:7: ( '>>=' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:25:9: '>>='
            {
            match(">>="); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:26:7: ( '&=' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:26:9: '&='
            {
            match("&="); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:27:7: ( '^=' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:27:9: '^='
            {
            match("^="); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:28:7: ( '|=' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:28:9: '|='
            {
            match("|="); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:29:7: ( '<<' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:29:9: '<<'
            {
            match("<<"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:30:7: ( '>>' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:30:9: '>>'
            {
            match(">>"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:31:7: ( '+' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:31:9: '+'
            {
            match('+'); 

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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:32:7: ( '-' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:32:9: '-'
            {
            match('-'); 

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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:33:7: ( '*' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:33:9: '*'
            {
            match('*'); 

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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:34:7: ( '/' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:34:9: '/'
            {
            match('/'); 

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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:35:7: ( '%' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:35:9: '%'
            {
            match('%'); 

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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:36:7: ( '~' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:36:9: '~'
            {
            match('~'); 

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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:37:7: ( '<' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:37:9: '<'
            {
            match('<'); 

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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:38:7: ( '<=' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:38:9: '<='
            {
            match("<="); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:39:7: ( '>' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:39:9: '>'
            {
            match('>'); 

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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:40:7: ( '>=' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:40:9: '>='
            {
            match(">="); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:41:7: ( '==' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:41:9: '=='
            {
            match("=="); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:42:7: ( '!=' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:42:9: '!='
            {
            match("!="); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:43:7: ( 's' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:43:9: 's'
            {
            match('s'); 

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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:44:7: ( 'ms' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:44:9: 'ms'
            {
            match("ms"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:45:7: ( 'ns' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:45:9: 'ns'
            {
            match("ns"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:46:7: ( 'void' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:46:9: 'void'
            {
            match("void"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:47:7: ( 'integer' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:47:9: 'integer'
            {
            match("integer"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:48:7: ( 'real' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:48:9: 'real'
            {
            match("real"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:49:7: ( 'boolean' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:49:9: 'boolean'
            {
            match("boolean"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:50:7: ( 'string' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:50:9: 'string'
            {
            match("string"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:51:7: ( '@@statechart@@' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:51:9: '@@statechart@@'
            {
            match("@@statechart@@"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:52:7: ( '@@state@@' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:52:9: '@@state@@'
            {
            match("@@state@@"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:53:7: ( '@@transition@@' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:53:9: '@@transition@@'
            {
            match("@@transition@@"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:54:7: ( 'namespace' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:54:9: 'namespace'
            {
            match("namespace"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:55:7: ( 'interface' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:55:9: 'interface'
            {
            match("interface"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:56:7: ( ':' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:56:9: ':'
            {
            match(':'); 

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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:57:7: ( 'internal' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:57:9: 'internal'
            {
            match("internal"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:58:7: ( 'event' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:58:9: 'event'
            {
            match("event"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:59:7: ( 'var' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:59:9: 'var'
            {
            match("var"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:60:7: ( 'operation' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:60:9: 'operation'
            {
            match("operation"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:61:7: ( '(' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:61:9: '('
            {
            match('('); 

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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:62:7: ( ')' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:62:9: ')'
            {
            match(')'); 

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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:63:7: ( ',' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:63:9: ','
            {
            match(','); 

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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:64:7: ( 'entrypoint' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:64:9: 'entrypoint'
            {
            match("entrypoint"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:65:7: ( 'exitpoint' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:65:9: 'exitpoint'
            {
            match("exitpoint"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:66:7: ( '.' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:66:9: '.'
            {
            match('.'); 

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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:67:7: ( '#' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:67:9: '#'
            {
            match('#'); 

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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:68:7: ( '[' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:68:9: '['
            {
            match('['); 

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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:69:7: ( ']' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:69:9: ']'
            {
            match(']'); 

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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:70:7: ( ';' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:70:9: ';'
            {
            match(';'); 

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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:71:7: ( 'entry' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:71:9: 'entry'
            {
            match("entry"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:72:7: ( 'exit' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:72:9: 'exit'
            {
            match("exit"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:73:7: ( 'oncycle' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:73:9: 'oncycle'
            {
            match("oncycle"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:74:7: ( 'always' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:74:9: 'always'
            {
            match("always"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:75:7: ( 'raise' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:75:9: 'raise'
            {
            match("raise"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:76:7: ( '?' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:76:9: '?'
            {
            match('?'); 

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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:77:7: ( '||' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:77:9: '||'
            {
            match("||"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:78:7: ( '&&' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:78:9: '&&'
            {
            match("&&"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:79:7: ( '!' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:79:9: '!'
            {
            match('!'); 

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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:80:7: ( '^' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:80:9: '^'
            {
            match('^'); 

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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:81:7: ( '|' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:81:9: '|'
            {
            match('|'); 

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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:82:7: ( '&' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:82:9: '&'
            {
            match('&'); 

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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:83:7: ( 'valueof' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:83:9: 'valueof'
            {
            match("valueof"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:84:7: ( 'raised' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:84:9: 'raised'
            {
            match("raised"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:85:7: ( 'active' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:85:9: 'active'
            {
            match("active"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:86:7: ( 'readonly' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:86:9: 'readonly'
            {
            match("readonly"); 


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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:87:7: ( 'external' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:87:9: 'external'
            {
            match("external"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__90"

    // $ANTLR start "RULE_BOOL"
    public final void mRULE_BOOL() throws RecognitionException {
        try {
            int _type = RULE_BOOL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11473:11: ( ( 'true' | 'false' | 'yes' | 'no' ) )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11473:13: ( 'true' | 'false' | 'yes' | 'no' )
            {
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11473:13: ( 'true' | 'false' | 'yes' | 'no' )
            int alt1=4;
            switch ( input.LA(1) ) {
            case 't':
                {
                alt1=1;
                }
                break;
            case 'f':
                {
                alt1=2;
                }
                break;
            case 'y':
                {
                alt1=3;
                }
                break;
            case 'n':
                {
                alt1=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11473:14: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11473:21: 'false'
                    {
                    match("false"); 


                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11473:29: 'yes'
                    {
                    match("yes"); 


                    }
                    break;
                case 4 :
                    // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11473:35: 'no'
                    {
                    match("no"); 


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

    // $ANTLR start "RULE_HEX"
    public final void mRULE_HEX() throws RecognitionException {
        try {
            int _type = RULE_HEX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11475:10: ( '0' ( 'x' | 'X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11475:12: '0' ( 'x' | 'X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
            {
            match('0'); 
            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11475:26: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
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
            	    // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


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
    // $ANTLR end "RULE_HEX"

    // $ANTLR start "RULE_FLOAT"
    public final void mRULE_FLOAT() throws RecognitionException {
        try {
            int _type = RULE_FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11477:12: ( RULE_INT '.' RULE_INT ( 'e' ( '-' | '+' ) RULE_INT )? ( 'f' | 'F' | 'd' | 'D' )? )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11477:14: RULE_INT '.' RULE_INT ( 'e' ( '-' | '+' ) RULE_INT )? ( 'f' | 'F' | 'd' | 'D' )?
            {
            mRULE_INT(); 
            match('.'); 
            mRULE_INT(); 
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11477:36: ( 'e' ( '-' | '+' ) RULE_INT )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='e') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11477:37: 'e' ( '-' | '+' ) RULE_INT
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

            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11477:62: ( 'f' | 'F' | 'd' | 'D' )?
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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11479:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11479:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11479:11: ( '^' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='^') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11479:11: '^'
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

            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11479:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11481:10: ( ( '0' .. '9' )+ )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11481:12: ( '0' .. '9' )+
            {
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11481:12: ( '0' .. '9' )+
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
            	    // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11481:13: '0' .. '9'
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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11483:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11483:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11483:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11483:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11483:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11483:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11483:66: ~ ( ( '\\\\' | '\"' ) )
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
                    // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11483:86: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11483:91: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11483:92: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11483:137: ~ ( ( '\\\\' | '\\'' ) )
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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11485:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11485:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11485:24: ( options {greedy=false; } : . )*
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
            	    // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11485:52: .
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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11487:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11487:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11487:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='\u0000' && LA12_0<='\t')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\uFFFF')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11487:24: ~ ( ( '\\n' | '\\r' ) )
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

            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11487:40: ( ( '\\r' )? '\\n' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='\n'||LA14_0=='\r') ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11487:41: ( '\\r' )? '\\n'
                    {
                    // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11487:41: ( '\\r' )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0=='\r') ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11487:41: '\\r'
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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11489:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11489:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11489:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11491:16: ( . )
            // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:11491:18: .
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
        // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:8: ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | RULE_BOOL | RULE_HEX | RULE_FLOAT | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt16=87;
        alt16 = dfa16.predict(input);
        switch (alt16) {
            case 1 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:10: T__14
                {
                mT__14(); 

                }
                break;
            case 2 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:16: T__15
                {
                mT__15(); 

                }
                break;
            case 3 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:22: T__16
                {
                mT__16(); 

                }
                break;
            case 4 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:28: T__17
                {
                mT__17(); 

                }
                break;
            case 5 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:34: T__18
                {
                mT__18(); 

                }
                break;
            case 6 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:40: T__19
                {
                mT__19(); 

                }
                break;
            case 7 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:46: T__20
                {
                mT__20(); 

                }
                break;
            case 8 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:52: T__21
                {
                mT__21(); 

                }
                break;
            case 9 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:58: T__22
                {
                mT__22(); 

                }
                break;
            case 10 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:64: T__23
                {
                mT__23(); 

                }
                break;
            case 11 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:70: T__24
                {
                mT__24(); 

                }
                break;
            case 12 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:76: T__25
                {
                mT__25(); 

                }
                break;
            case 13 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:82: T__26
                {
                mT__26(); 

                }
                break;
            case 14 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:88: T__27
                {
                mT__27(); 

                }
                break;
            case 15 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:94: T__28
                {
                mT__28(); 

                }
                break;
            case 16 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:100: T__29
                {
                mT__29(); 

                }
                break;
            case 17 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:106: T__30
                {
                mT__30(); 

                }
                break;
            case 18 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:112: T__31
                {
                mT__31(); 

                }
                break;
            case 19 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:118: T__32
                {
                mT__32(); 

                }
                break;
            case 20 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:124: T__33
                {
                mT__33(); 

                }
                break;
            case 21 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:130: T__34
                {
                mT__34(); 

                }
                break;
            case 22 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:136: T__35
                {
                mT__35(); 

                }
                break;
            case 23 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:142: T__36
                {
                mT__36(); 

                }
                break;
            case 24 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:148: T__37
                {
                mT__37(); 

                }
                break;
            case 25 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:154: T__38
                {
                mT__38(); 

                }
                break;
            case 26 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:160: T__39
                {
                mT__39(); 

                }
                break;
            case 27 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:166: T__40
                {
                mT__40(); 

                }
                break;
            case 28 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:172: T__41
                {
                mT__41(); 

                }
                break;
            case 29 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:178: T__42
                {
                mT__42(); 

                }
                break;
            case 30 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:184: T__43
                {
                mT__43(); 

                }
                break;
            case 31 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:190: T__44
                {
                mT__44(); 

                }
                break;
            case 32 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:196: T__45
                {
                mT__45(); 

                }
                break;
            case 33 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:202: T__46
                {
                mT__46(); 

                }
                break;
            case 34 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:208: T__47
                {
                mT__47(); 

                }
                break;
            case 35 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:214: T__48
                {
                mT__48(); 

                }
                break;
            case 36 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:220: T__49
                {
                mT__49(); 

                }
                break;
            case 37 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:226: T__50
                {
                mT__50(); 

                }
                break;
            case 38 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:232: T__51
                {
                mT__51(); 

                }
                break;
            case 39 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:238: T__52
                {
                mT__52(); 

                }
                break;
            case 40 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:244: T__53
                {
                mT__53(); 

                }
                break;
            case 41 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:250: T__54
                {
                mT__54(); 

                }
                break;
            case 42 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:256: T__55
                {
                mT__55(); 

                }
                break;
            case 43 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:262: T__56
                {
                mT__56(); 

                }
                break;
            case 44 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:268: T__57
                {
                mT__57(); 

                }
                break;
            case 45 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:274: T__58
                {
                mT__58(); 

                }
                break;
            case 46 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:280: T__59
                {
                mT__59(); 

                }
                break;
            case 47 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:286: T__60
                {
                mT__60(); 

                }
                break;
            case 48 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:292: T__61
                {
                mT__61(); 

                }
                break;
            case 49 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:298: T__62
                {
                mT__62(); 

                }
                break;
            case 50 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:304: T__63
                {
                mT__63(); 

                }
                break;
            case 51 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:310: T__64
                {
                mT__64(); 

                }
                break;
            case 52 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:316: T__65
                {
                mT__65(); 

                }
                break;
            case 53 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:322: T__66
                {
                mT__66(); 

                }
                break;
            case 54 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:328: T__67
                {
                mT__67(); 

                }
                break;
            case 55 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:334: T__68
                {
                mT__68(); 

                }
                break;
            case 56 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:340: T__69
                {
                mT__69(); 

                }
                break;
            case 57 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:346: T__70
                {
                mT__70(); 

                }
                break;
            case 58 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:352: T__71
                {
                mT__71(); 

                }
                break;
            case 59 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:358: T__72
                {
                mT__72(); 

                }
                break;
            case 60 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:364: T__73
                {
                mT__73(); 

                }
                break;
            case 61 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:370: T__74
                {
                mT__74(); 

                }
                break;
            case 62 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:376: T__75
                {
                mT__75(); 

                }
                break;
            case 63 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:382: T__76
                {
                mT__76(); 

                }
                break;
            case 64 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:388: T__77
                {
                mT__77(); 

                }
                break;
            case 65 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:394: T__78
                {
                mT__78(); 

                }
                break;
            case 66 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:400: T__79
                {
                mT__79(); 

                }
                break;
            case 67 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:406: T__80
                {
                mT__80(); 

                }
                break;
            case 68 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:412: T__81
                {
                mT__81(); 

                }
                break;
            case 69 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:418: T__82
                {
                mT__82(); 

                }
                break;
            case 70 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:424: T__83
                {
                mT__83(); 

                }
                break;
            case 71 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:430: T__84
                {
                mT__84(); 

                }
                break;
            case 72 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:436: T__85
                {
                mT__85(); 

                }
                break;
            case 73 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:442: T__86
                {
                mT__86(); 

                }
                break;
            case 74 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:448: T__87
                {
                mT__87(); 

                }
                break;
            case 75 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:454: T__88
                {
                mT__88(); 

                }
                break;
            case 76 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:460: T__89
                {
                mT__89(); 

                }
                break;
            case 77 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:466: T__90
                {
                mT__90(); 

                }
                break;
            case 78 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:472: RULE_BOOL
                {
                mRULE_BOOL(); 

                }
                break;
            case 79 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:482: RULE_HEX
                {
                mRULE_HEX(); 

                }
                break;
            case 80 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:491: RULE_FLOAT
                {
                mRULE_FLOAT(); 

                }
                break;
            case 81 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:502: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 82 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:510: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 83 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:519: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 84 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:531: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 85 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:547: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 86 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:563: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 87 :
                // ../org.yakindu.sct.model.stext.ui/src-gen/org/yakindu/sct/model/stext/ui/contentassist/antlr/internal/InternalSText.g:1:571: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA16 dfa16 = new DFA16(this);
    static final String DFA16_eotS =
        "\1\uffff\6\60\1\76\1\100\1\104\1\106\1\110\1\112\1\115\1\120\1\123"+
        "\1\125\1\130\1\uffff\1\133\1\135\5\60\1\56\12\uffff\3\60\2\166\1"+
        "\uffff\2\56\2\uffff\1\60\1\uffff\5\60\1\u0083\6\60\16\uffff\1\u008b"+
        "\2\uffff\1\u008d\15\uffff\1\60\1\uffff\1\u008f\1\u0090\1\60\1\u0092"+
        "\5\60\13\uffff\3\60\3\uffff\1\166\2\uffff\10\60\1\uffff\1\u00a7"+
        "\5\60\4\uffff\1\60\2\uffff\1\60\1\uffff\1\60\1\u00b0\4\60\2\uffff"+
        "\2\60\1\u0092\1\60\1\u00ba\3\60\1\u00bf\3\60\1\uffff\7\60\1\u00cb"+
        "\1\uffff\1\60\1\u00cd\3\60\1\uffff\1\u0092\2\60\1\uffff\1\u00d4"+
        "\1\u00d5\1\u00d7\1\60\1\uffff\1\60\1\u00da\4\60\1\u00e0\4\60\1\uffff"+
        "\1\60\1\uffff\1\60\1\u00e8\1\60\1\uffff\1\u0092\1\60\2\uffff\1\60"+
        "\1\uffff\2\60\1\uffff\5\60\1\uffff\1\u00f4\1\u00f5\1\u00f6\3\60"+
        "\1\u00fa\1\uffff\1\60\1\uffff\1\u00fd\3\60\1\u0101\3\60\1\u0105"+
        "\3\uffff\1\60\1\u0107\1\60\1\uffff\1\u0109\2\uffff\2\60\1\u010e"+
        "\1\uffff\1\60\1\u0110\1\60\1\uffff\1\60\1\uffff\1\u0113\3\uffff"+
        "\1\60\1\u0115\1\uffff\1\u0116\1\uffff\1\u0117\1\u0118\1\uffff\1"+
        "\u0119\5\uffff";
    static final String DFA16_eofS =
        "\u011a\uffff";
    static final String DFA16_minS =
        "\1\0\1\145\1\154\1\157\2\156\1\143\2\75\1\52\3\75\1\74\1\75\1\46"+
        "\2\75\1\uffff\1\75\1\60\1\163\3\141\1\157\1\100\12\uffff\1\162\1"+
        "\141\1\145\2\56\1\uffff\2\0\2\uffff\1\146\1\uffff\1\163\1\145\1"+
        "\164\1\151\1\143\1\60\1\164\1\145\1\143\1\164\1\167\1\164\16\uffff"+
        "\1\75\2\uffff\1\75\15\uffff\1\162\1\uffff\2\60\1\155\1\60\1\151"+
        "\1\154\1\141\1\151\1\157\1\163\12\uffff\1\165\1\154\1\163\3\uffff"+
        "\1\56\2\uffff\1\141\1\145\1\156\1\162\1\164\1\145\1\141\1\145\1"+
        "\uffff\1\60\1\162\1\171\1\145\1\141\1\151\4\uffff\1\151\2\uffff"+
        "\1\145\1\uffff\1\144\1\60\1\165\1\144\1\163\1\154\1\164\1\uffff"+
        "\1\145\1\163\1\60\1\165\1\60\1\171\1\164\1\171\1\60\1\162\1\154"+
        "\1\147\1\uffff\1\141\1\143\1\162\1\171\1\166\1\156\1\163\1\60\1"+
        "\uffff\1\145\1\60\1\157\2\145\1\141\1\60\1\145\1\154\1\uffff\3\60"+
        "\1\157\1\uffff\1\156\1\60\1\145\1\146\1\164\1\154\1\60\1\163\1\145"+
        "\1\147\1\160\1\uffff\1\157\1\uffff\1\156\1\60\1\141\1\164\1\60\1"+
        "\164\2\uffff\1\157\1\uffff\1\151\1\141\1\uffff\1\162\2\141\1\151"+
        "\1\145\1\uffff\3\60\1\141\1\146\1\154\1\60\1\uffff\1\156\1\145\1"+
        "\60\1\151\1\156\1\154\1\60\1\143\1\154\1\157\1\60\3\uffff\1\143"+
        "\1\60\1\171\1\uffff\1\60\1\100\1\uffff\1\156\1\164\1\60\1\uffff"+
        "\1\145\1\60\1\156\1\uffff\1\145\1\uffff\1\60\3\uffff\1\164\1\60"+
        "\1\uffff\1\60\1\uffff\2\60\1\uffff\1\60\5\uffff";
    static final String DFA16_maxS =
        "\1\uffff\1\145\1\170\1\157\1\156\1\165\1\154\7\75\1\76\1\75\1\172"+
        "\1\174\1\uffff\1\75\1\172\2\163\1\157\1\145\1\157\1\100\12\uffff"+
        "\1\162\1\141\1\145\1\170\1\71\1\uffff\2\uffff\2\uffff\1\146\1\uffff"+
        "\1\163\1\145\2\164\1\143\1\172\1\164\1\145\1\143\1\164\1\167\1\164"+
        "\16\uffff\1\75\2\uffff\1\75\15\uffff\1\162\1\uffff\2\172\1\155\1"+
        "\172\1\151\1\162\1\141\1\151\1\157\1\164\12\uffff\1\165\1\154\1"+
        "\163\3\uffff\1\71\2\uffff\1\141\1\145\2\162\1\164\1\145\1\141\1"+
        "\145\1\uffff\1\172\1\162\1\171\1\145\1\141\1\151\4\uffff\1\151\2"+
        "\uffff\1\145\1\uffff\1\144\1\172\1\165\1\154\1\163\1\154\1\164\1"+
        "\uffff\1\145\1\163\1\172\1\165\1\172\1\171\1\164\1\171\1\172\1\162"+
        "\1\154\1\162\1\uffff\1\141\1\143\1\162\1\171\1\166\1\156\1\163\1"+
        "\172\1\uffff\1\145\1\172\1\157\2\145\1\141\1\172\1\145\1\154\1\uffff"+
        "\3\172\1\157\1\uffff\1\156\1\172\1\145\1\156\1\164\1\154\1\172\1"+
        "\163\1\145\1\147\1\160\1\uffff\1\157\1\uffff\1\156\1\172\1\141\1"+
        "\164\1\172\1\164\2\uffff\1\157\1\uffff\1\151\1\141\1\uffff\1\162"+
        "\2\141\1\151\1\145\1\uffff\3\172\1\141\1\146\1\154\1\172\1\uffff"+
        "\1\156\1\145\1\172\1\151\1\156\1\154\1\172\1\143\1\154\1\157\1\172"+
        "\3\uffff\1\143\1\172\1\171\1\uffff\1\172\1\143\1\uffff\1\156\1\164"+
        "\1\172\1\uffff\1\145\1\172\1\156\1\uffff\1\145\1\uffff\1\172\3\uffff"+
        "\1\164\1\172\1\uffff\1\172\1\uffff\2\172\1\uffff\1\172\5\uffff";
    static final String DFA16_acceptS =
        "\22\uffff\1\32\10\uffff\1\56\1\63\1\64\1\65\1\70\1\71\1\72\1\73"+
        "\1\74\1\102\5\uffff\1\121\2\uffff\1\126\1\127\1\uffff\1\121\14\uffff"+
        "\1\37\1\10\1\11\1\27\1\12\1\124\1\125\1\30\1\13\1\31\1\14\1\25\1"+
        "\15\1\26\1\uffff\1\34\1\33\1\uffff\1\36\1\35\1\20\1\104\1\110\1"+
        "\21\1\106\1\22\1\103\1\107\1\32\1\40\1\105\1\uffff\1\41\12\uffff"+
        "\1\56\1\63\1\64\1\65\1\70\1\71\1\72\1\73\1\74\1\102\3\uffff\1\117"+
        "\1\122\1\120\1\uffff\1\123\1\126\10\uffff\1\4\6\uffff\1\16\1\23"+
        "\1\17\1\24\1\uffff\1\42\1\43\1\uffff\1\116\7\uffff\1\53\14\uffff"+
        "\1\5\10\uffff\1\61\11\uffff\1\2\4\uffff\1\76\13\uffff\1\44\1\uffff"+
        "\1\46\6\uffff\1\7\1\60\1\uffff\1\75\2\uffff\1\3\5\uffff\1\6\7\uffff"+
        "\1\101\13\uffff\1\100\1\113\1\50\3\uffff\1\112\2\uffff\1\1\3\uffff"+
        "\1\45\3\uffff\1\77\1\uffff\1\111\1\uffff\1\47\1\51\1\52\2\uffff"+
        "\1\115\1\uffff\1\57\2\uffff\1\114\1\uffff\1\67\1\55\1\62\1\54\1"+
        "\66";
    static final String DFA16_specialS =
        "\1\2\52\uffff\1\0\1\1\u00ed\uffff}>";
    static final String[] DFA16_transitionS = {
            "\11\56\2\55\2\56\1\55\22\56\1\55\1\23\1\53\1\40\1\56\1\12\1"+
            "\17\1\54\1\34\1\35\1\10\1\13\1\36\1\14\1\37\1\11\1\50\11\51"+
            "\1\33\1\43\1\15\1\7\1\16\1\44\1\32\32\52\1\41\1\56\1\42\1\20"+
            "\1\52\1\56\1\6\1\31\1\52\1\1\1\2\1\46\2\52\1\4\2\52\1\3\1\25"+
            "\1\26\1\5\2\52\1\30\1\24\1\45\1\52\1\27\2\52\1\47\1\52\1\56"+
            "\1\21\1\56\1\22\uff81\56",
            "\1\57",
            "\1\61\1\uffff\1\63\7\uffff\1\62\1\uffff\1\64",
            "\1\65",
            "\1\66",
            "\1\71\1\uffff\1\70\4\uffff\1\67",
            "\1\74\2\uffff\1\72\5\uffff\1\73",
            "\1\75",
            "\1\77",
            "\1\102\4\uffff\1\103\15\uffff\1\101",
            "\1\105",
            "\1\107",
            "\1\111",
            "\1\113\1\114",
            "\1\117\1\116",
            "\1\122\26\uffff\1\121",
            "\1\124\3\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\126\76\uffff\1\127",
            "",
            "\1\132",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\23\60\1\134\6\60",
            "\1\136",
            "\1\140\15\uffff\1\141\3\uffff\1\137",
            "\1\143\15\uffff\1\142",
            "\1\145\3\uffff\1\144",
            "\1\146",
            "\1\147",
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
            "\1\162",
            "\1\163",
            "\1\164",
            "\1\167\1\uffff\12\170\36\uffff\1\165\37\uffff\1\165",
            "\1\167\1\uffff\12\170",
            "",
            "\0\171",
            "\0\171",
            "",
            "",
            "\1\173",
            "",
            "\1\174",
            "\1\175",
            "\1\176",
            "\1\177\12\uffff\1\u0080",
            "\1\u0081",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\23\60\1\u0082\6\60",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089",
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
            "\1\u008a",
            "",
            "",
            "\1\u008c",
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
            "\1\u008e",
            "",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u0091",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u0093",
            "\1\u0095\5\uffff\1\u0094",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099\1\u009a",
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
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "",
            "",
            "",
            "\1\167\1\uffff\12\170",
            "",
            "",
            "\1\u009e",
            "\1\u009f",
            "\1\u00a1\3\uffff\1\u00a0",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u00a8",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "",
            "",
            "",
            "",
            "\1\u00ad",
            "",
            "",
            "\1\u00ae",
            "",
            "\1\u00af",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u00b1",
            "\1\u00b3\7\uffff\1\u00b2",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "",
            "\1\u00b7",
            "\1\u00b8",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u00b9",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u00bb",
            "\1\u00bc",
            "\1\u00bd",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\17\60\1\u00be\12"+
            "\60",
            "\1\u00c0",
            "\1\u00c1",
            "\1\u00c2\12\uffff\1\u00c3",
            "",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c6",
            "\1\u00c7",
            "\1\u00c8",
            "\1\u00c9",
            "\1\u00ca",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "\1\u00cc",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u00d2",
            "\1\u00d3",
            "",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\17\60\1\u00d6\12"+
            "\60",
            "\1\u00d8",
            "",
            "\1\u00d9",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u00db",
            "\1\u00dc\7\uffff\1\u00dd",
            "\1\u00de",
            "\1\u00df",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u00e1",
            "\1\u00e2",
            "\1\u00e3",
            "\1\u00e4",
            "",
            "\1\u00e5",
            "",
            "\1\u00e6",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\3\60\1\u00e7\26\60",
            "\1\u00e9",
            "\1\u00ea",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u00eb",
            "",
            "",
            "\1\u00ec",
            "",
            "\1\u00ed",
            "\1\u00ee",
            "",
            "\1\u00ef",
            "\1\u00f0",
            "\1\u00f1",
            "\1\u00f2",
            "\1\u00f3",
            "",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u00f7",
            "\1\u00f8",
            "\1\u00f9",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "\1\u00fb",
            "\1\u00fc",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u00fe",
            "\1\u00ff",
            "\1\u0100",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u0102",
            "\1\u0103",
            "\1\u0104",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "",
            "",
            "\1\u0106",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u0108",
            "",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u010b\42\uffff\1\u010a",
            "",
            "\1\u010c",
            "\1\u010d",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "\1\u010f",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u0111",
            "",
            "\1\u0112",
            "",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "",
            "",
            "\1\u0114",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "",
            "",
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
            return "1:1: Tokens : ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | RULE_BOOL | RULE_HEX | RULE_FLOAT | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA16_43 = input.LA(1);

                        s = -1;
                        if ( ((LA16_43>='\u0000' && LA16_43<='\uFFFF')) ) {s = 121;}

                        else s = 46;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA16_44 = input.LA(1);

                        s = -1;
                        if ( ((LA16_44>='\u0000' && LA16_44<='\uFFFF')) ) {s = 121;}

                        else s = 46;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA16_0 = input.LA(1);

                        s = -1;
                        if ( (LA16_0=='d') ) {s = 1;}

                        else if ( (LA16_0=='e') ) {s = 2;}

                        else if ( (LA16_0=='l') ) {s = 3;}

                        else if ( (LA16_0=='i') ) {s = 4;}

                        else if ( (LA16_0=='o') ) {s = 5;}

                        else if ( (LA16_0=='a') ) {s = 6;}

                        else if ( (LA16_0=='=') ) {s = 7;}

                        else if ( (LA16_0=='*') ) {s = 8;}

                        else if ( (LA16_0=='/') ) {s = 9;}

                        else if ( (LA16_0=='%') ) {s = 10;}

                        else if ( (LA16_0=='+') ) {s = 11;}

                        else if ( (LA16_0=='-') ) {s = 12;}

                        else if ( (LA16_0=='<') ) {s = 13;}

                        else if ( (LA16_0=='>') ) {s = 14;}

                        else if ( (LA16_0=='&') ) {s = 15;}

                        else if ( (LA16_0=='^') ) {s = 16;}

                        else if ( (LA16_0=='|') ) {s = 17;}

                        else if ( (LA16_0=='~') ) {s = 18;}

                        else if ( (LA16_0=='!') ) {s = 19;}

                        else if ( (LA16_0=='s') ) {s = 20;}

                        else if ( (LA16_0=='m') ) {s = 21;}

                        else if ( (LA16_0=='n') ) {s = 22;}

                        else if ( (LA16_0=='v') ) {s = 23;}

                        else if ( (LA16_0=='r') ) {s = 24;}

                        else if ( (LA16_0=='b') ) {s = 25;}

                        else if ( (LA16_0=='@') ) {s = 26;}

                        else if ( (LA16_0==':') ) {s = 27;}

                        else if ( (LA16_0=='(') ) {s = 28;}

                        else if ( (LA16_0==')') ) {s = 29;}

                        else if ( (LA16_0==',') ) {s = 30;}

                        else if ( (LA16_0=='.') ) {s = 31;}

                        else if ( (LA16_0=='#') ) {s = 32;}

                        else if ( (LA16_0=='[') ) {s = 33;}

                        else if ( (LA16_0==']') ) {s = 34;}

                        else if ( (LA16_0==';') ) {s = 35;}

                        else if ( (LA16_0=='?') ) {s = 36;}

                        else if ( (LA16_0=='t') ) {s = 37;}

                        else if ( (LA16_0=='f') ) {s = 38;}

                        else if ( (LA16_0=='y') ) {s = 39;}

                        else if ( (LA16_0=='0') ) {s = 40;}

                        else if ( ((LA16_0>='1' && LA16_0<='9')) ) {s = 41;}

                        else if ( ((LA16_0>='A' && LA16_0<='Z')||LA16_0=='_'||LA16_0=='c'||(LA16_0>='g' && LA16_0<='h')||(LA16_0>='j' && LA16_0<='k')||(LA16_0>='p' && LA16_0<='q')||LA16_0=='u'||(LA16_0>='w' && LA16_0<='x')||LA16_0=='z') ) {s = 42;}

                        else if ( (LA16_0=='\"') ) {s = 43;}

                        else if ( (LA16_0=='\'') ) {s = 44;}

                        else if ( ((LA16_0>='\t' && LA16_0<='\n')||LA16_0=='\r'||LA16_0==' ') ) {s = 45;}

                        else if ( ((LA16_0>='\u0000' && LA16_0<='\b')||(LA16_0>='\u000B' && LA16_0<='\f')||(LA16_0>='\u000E' && LA16_0<='\u001F')||LA16_0=='$'||LA16_0=='\\'||LA16_0=='`'||LA16_0=='{'||LA16_0=='}'||(LA16_0>='\u007F' && LA16_0<='\uFFFF')) ) {s = 46;}

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