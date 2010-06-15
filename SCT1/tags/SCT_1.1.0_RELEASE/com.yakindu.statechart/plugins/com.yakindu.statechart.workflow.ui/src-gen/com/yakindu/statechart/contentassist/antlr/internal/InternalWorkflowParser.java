package com.yakindu.statechart.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import com.yakindu.statechart.services.WorkflowGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalWorkflowParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'c'", "'java'", "'javame'", "'lejos'", "'modelFile'", "'targetDir'", "'targetPlatform'", "'defensive'"
    };
    public static final int RULE_ID=5;
    public static final int RULE_STRING=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

        public InternalWorkflowParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g"; }


     
     	private WorkflowGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(WorkflowGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start entryRuleWorkflow
    // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:60:1: entryRuleWorkflow : ruleWorkflow EOF ;
    public final void entryRuleWorkflow() throws RecognitionException {
        try {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:60:19: ( ruleWorkflow EOF )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:61:1: ruleWorkflow EOF
            {
             before(grammarAccess.getWorkflowRule()); 
            pushFollow(FOLLOW_ruleWorkflow_in_entryRuleWorkflow60);
            ruleWorkflow();
            _fsp--;

             after(grammarAccess.getWorkflowRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWorkflow67); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRuleWorkflow


    // $ANTLR start ruleWorkflow
    // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:68:1: ruleWorkflow : ( ( rule__Workflow__Group__0 ) ) ;
    public final void ruleWorkflow() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:72:2: ( ( ( rule__Workflow__Group__0 ) ) )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:73:1: ( ( rule__Workflow__Group__0 ) )
            {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:73:1: ( ( rule__Workflow__Group__0 ) )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:74:1: ( rule__Workflow__Group__0 )
            {
             before(grammarAccess.getWorkflowAccess().getGroup()); 
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:75:1: ( rule__Workflow__Group__0 )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:75:2: rule__Workflow__Group__0
            {
            pushFollow(FOLLOW_rule__Workflow__Group__0_in_ruleWorkflow94);
            rule__Workflow__Group__0();
            _fsp--;


            }

             after(grammarAccess.getWorkflowAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleWorkflow


    // $ANTLR start entryRuleModel
    // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:87:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:87:16: ( ruleModel EOF )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:88:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel120);
            ruleModel();
            _fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel127); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRuleModel


    // $ANTLR start ruleModel
    // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:95:1: ruleModel : ( ( rule__Model__Group__0 ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:99:2: ( ( ( rule__Model__Group__0 ) ) )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:100:1: ( ( rule__Model__Group__0 ) )
            {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:100:1: ( ( rule__Model__Group__0 ) )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:101:1: ( rule__Model__Group__0 )
            {
             before(grammarAccess.getModelAccess().getGroup()); 
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:102:1: ( rule__Model__Group__0 )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:102:2: rule__Model__Group__0
            {
            pushFollow(FOLLOW_rule__Model__Group__0_in_ruleModel154);
            rule__Model__Group__0();
            _fsp--;


            }

             after(grammarAccess.getModelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleTarget
    // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:114:1: entryRuleTarget : ruleTarget EOF ;
    public final void entryRuleTarget() throws RecognitionException {
        try {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:114:17: ( ruleTarget EOF )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:115:1: ruleTarget EOF
            {
             before(grammarAccess.getTargetRule()); 
            pushFollow(FOLLOW_ruleTarget_in_entryRuleTarget180);
            ruleTarget();
            _fsp--;

             after(grammarAccess.getTargetRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTarget187); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRuleTarget


    // $ANTLR start ruleTarget
    // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:122:1: ruleTarget : ( ( rule__Target__Group__0 ) ) ;
    public final void ruleTarget() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:126:2: ( ( ( rule__Target__Group__0 ) ) )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:127:1: ( ( rule__Target__Group__0 ) )
            {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:127:1: ( ( rule__Target__Group__0 ) )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:128:1: ( rule__Target__Group__0 )
            {
             before(grammarAccess.getTargetAccess().getGroup()); 
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:129:1: ( rule__Target__Group__0 )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:129:2: rule__Target__Group__0
            {
            pushFollow(FOLLOW_rule__Target__Group__0_in_ruleTarget214);
            rule__Target__Group__0();
            _fsp--;


            }

             after(grammarAccess.getTargetAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleTarget


    // $ANTLR start entryRuleTargetPlatform
    // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:141:1: entryRuleTargetPlatform : ruleTargetPlatform EOF ;
    public final void entryRuleTargetPlatform() throws RecognitionException {
        try {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:141:25: ( ruleTargetPlatform EOF )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:142:1: ruleTargetPlatform EOF
            {
             before(grammarAccess.getTargetPlatformRule()); 
            pushFollow(FOLLOW_ruleTargetPlatform_in_entryRuleTargetPlatform240);
            ruleTargetPlatform();
            _fsp--;

             after(grammarAccess.getTargetPlatformRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTargetPlatform247); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRuleTargetPlatform


    // $ANTLR start ruleTargetPlatform
    // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:149:1: ruleTargetPlatform : ( ( rule__TargetPlatform__Group__0 ) ) ;
    public final void ruleTargetPlatform() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:153:2: ( ( ( rule__TargetPlatform__Group__0 ) ) )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:154:1: ( ( rule__TargetPlatform__Group__0 ) )
            {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:154:1: ( ( rule__TargetPlatform__Group__0 ) )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:155:1: ( rule__TargetPlatform__Group__0 )
            {
             before(grammarAccess.getTargetPlatformAccess().getGroup()); 
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:156:1: ( rule__TargetPlatform__Group__0 )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:156:2: rule__TargetPlatform__Group__0
            {
            pushFollow(FOLLOW_rule__TargetPlatform__Group__0_in_ruleTargetPlatform274);
            rule__TargetPlatform__Group__0();
            _fsp--;


            }

             after(grammarAccess.getTargetPlatformAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleTargetPlatform


    // $ANTLR start entryRulePlatform
    // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:168:1: entryRulePlatform : rulePlatform EOF ;
    public final void entryRulePlatform() throws RecognitionException {
        try {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:168:19: ( rulePlatform EOF )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:169:1: rulePlatform EOF
            {
             before(grammarAccess.getPlatformRule()); 
            pushFollow(FOLLOW_rulePlatform_in_entryRulePlatform300);
            rulePlatform();
            _fsp--;

             after(grammarAccess.getPlatformRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePlatform307); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRulePlatform


    // $ANTLR start rulePlatform
    // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:176:1: rulePlatform : ( ( rule__Platform__Alternatives ) ) ;
    public final void rulePlatform() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:180:2: ( ( ( rule__Platform__Alternatives ) ) )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:181:1: ( ( rule__Platform__Alternatives ) )
            {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:181:1: ( ( rule__Platform__Alternatives ) )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:182:1: ( rule__Platform__Alternatives )
            {
             before(grammarAccess.getPlatformAccess().getAlternatives()); 
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:183:1: ( rule__Platform__Alternatives )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:183:2: rule__Platform__Alternatives
            {
            pushFollow(FOLLOW_rule__Platform__Alternatives_in_rulePlatform334);
            rule__Platform__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getPlatformAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rulePlatform


    // $ANTLR start rule__Platform__Alternatives
    // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:195:1: rule__Platform__Alternatives : ( ( 'c' ) | ( 'java' ) | ( 'javame' ) | ( 'lejos' ) );
    public final void rule__Platform__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:199:1: ( ( 'c' ) | ( 'java' ) | ( 'javame' ) | ( 'lejos' ) )
            int alt1=4;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt1=1;
                }
                break;
            case 12:
                {
                alt1=2;
                }
                break;
            case 13:
                {
                alt1=3;
                }
                break;
            case 14:
                {
                alt1=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("195:1: rule__Platform__Alternatives : ( ( 'c' ) | ( 'java' ) | ( 'javame' ) | ( 'lejos' ) );", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:200:1: ( 'c' )
                    {
                    // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:200:1: ( 'c' )
                    // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:201:1: 'c'
                    {
                     before(grammarAccess.getPlatformAccess().getCKeyword_0()); 
                    match(input,11,FOLLOW_11_in_rule__Platform__Alternatives371); 
                     after(grammarAccess.getPlatformAccess().getCKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:208:6: ( 'java' )
                    {
                    // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:208:6: ( 'java' )
                    // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:209:1: 'java'
                    {
                     before(grammarAccess.getPlatformAccess().getJavaKeyword_1()); 
                    match(input,12,FOLLOW_12_in_rule__Platform__Alternatives391); 
                     after(grammarAccess.getPlatformAccess().getJavaKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:216:6: ( 'javame' )
                    {
                    // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:216:6: ( 'javame' )
                    // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:217:1: 'javame'
                    {
                     before(grammarAccess.getPlatformAccess().getJavameKeyword_2()); 
                    match(input,13,FOLLOW_13_in_rule__Platform__Alternatives411); 
                     after(grammarAccess.getPlatformAccess().getJavameKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:224:6: ( 'lejos' )
                    {
                    // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:224:6: ( 'lejos' )
                    // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:225:1: 'lejos'
                    {
                     before(grammarAccess.getPlatformAccess().getLejosKeyword_3()); 
                    match(input,14,FOLLOW_14_in_rule__Platform__Alternatives431); 
                     after(grammarAccess.getPlatformAccess().getLejosKeyword_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Platform__Alternatives


    // $ANTLR start rule__Workflow__Group__0
    // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:239:1: rule__Workflow__Group__0 : ( ( ( rule__Workflow__ModelsAssignment_0 ) ) ( ( rule__Workflow__ModelsAssignment_0 )* ) ) rule__Workflow__Group__1 ;
    public final void rule__Workflow__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:243:1: ( ( ( ( rule__Workflow__ModelsAssignment_0 ) ) ( ( rule__Workflow__ModelsAssignment_0 )* ) ) rule__Workflow__Group__1 )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:244:1: ( ( ( rule__Workflow__ModelsAssignment_0 ) ) ( ( rule__Workflow__ModelsAssignment_0 )* ) ) rule__Workflow__Group__1
            {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:244:1: ( ( ( rule__Workflow__ModelsAssignment_0 ) ) ( ( rule__Workflow__ModelsAssignment_0 )* ) )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:245:1: ( ( rule__Workflow__ModelsAssignment_0 ) ) ( ( rule__Workflow__ModelsAssignment_0 )* )
            {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:245:1: ( ( rule__Workflow__ModelsAssignment_0 ) )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:246:1: ( rule__Workflow__ModelsAssignment_0 )
            {
             before(grammarAccess.getWorkflowAccess().getModelsAssignment_0()); 
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:247:1: ( rule__Workflow__ModelsAssignment_0 )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:247:2: rule__Workflow__ModelsAssignment_0
            {
            pushFollow(FOLLOW_rule__Workflow__ModelsAssignment_0_in_rule__Workflow__Group__0469);
            rule__Workflow__ModelsAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getWorkflowAccess().getModelsAssignment_0()); 

            }

            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:250:1: ( ( rule__Workflow__ModelsAssignment_0 )* )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:251:1: ( rule__Workflow__ModelsAssignment_0 )*
            {
             before(grammarAccess.getWorkflowAccess().getModelsAssignment_0()); 
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:252:1: ( rule__Workflow__ModelsAssignment_0 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==15) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:252:2: rule__Workflow__ModelsAssignment_0
            	    {
            	    pushFollow(FOLLOW_rule__Workflow__ModelsAssignment_0_in_rule__Workflow__Group__0481);
            	    rule__Workflow__ModelsAssignment_0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getWorkflowAccess().getModelsAssignment_0()); 

            }


            }

            pushFollow(FOLLOW_rule__Workflow__Group__1_in_rule__Workflow__Group__0493);
            rule__Workflow__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Workflow__Group__0


    // $ANTLR start rule__Workflow__Group__1
    // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:264:1: rule__Workflow__Group__1 : ( ( rule__Workflow__TargetAssignment_1 ) ) rule__Workflow__Group__2 ;
    public final void rule__Workflow__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:268:1: ( ( ( rule__Workflow__TargetAssignment_1 ) ) rule__Workflow__Group__2 )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:269:1: ( ( rule__Workflow__TargetAssignment_1 ) ) rule__Workflow__Group__2
            {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:269:1: ( ( rule__Workflow__TargetAssignment_1 ) )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:270:1: ( rule__Workflow__TargetAssignment_1 )
            {
             before(grammarAccess.getWorkflowAccess().getTargetAssignment_1()); 
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:271:1: ( rule__Workflow__TargetAssignment_1 )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:271:2: rule__Workflow__TargetAssignment_1
            {
            pushFollow(FOLLOW_rule__Workflow__TargetAssignment_1_in_rule__Workflow__Group__1521);
            rule__Workflow__TargetAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getWorkflowAccess().getTargetAssignment_1()); 

            }

            pushFollow(FOLLOW_rule__Workflow__Group__2_in_rule__Workflow__Group__1530);
            rule__Workflow__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Workflow__Group__1


    // $ANTLR start rule__Workflow__Group__2
    // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:282:1: rule__Workflow__Group__2 : ( ( rule__Workflow__PlatformAssignment_2 ) ) ;
    public final void rule__Workflow__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:286:1: ( ( ( rule__Workflow__PlatformAssignment_2 ) ) )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:287:1: ( ( rule__Workflow__PlatformAssignment_2 ) )
            {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:287:1: ( ( rule__Workflow__PlatformAssignment_2 ) )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:288:1: ( rule__Workflow__PlatformAssignment_2 )
            {
             before(grammarAccess.getWorkflowAccess().getPlatformAssignment_2()); 
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:289:1: ( rule__Workflow__PlatformAssignment_2 )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:289:2: rule__Workflow__PlatformAssignment_2
            {
            pushFollow(FOLLOW_rule__Workflow__PlatformAssignment_2_in_rule__Workflow__Group__2558);
            rule__Workflow__PlatformAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getWorkflowAccess().getPlatformAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Workflow__Group__2


    // $ANTLR start rule__Model__Group__0
    // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:305:1: rule__Model__Group__0 : ( 'modelFile' ) rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:309:1: ( ( 'modelFile' ) rule__Model__Group__1 )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:310:1: ( 'modelFile' ) rule__Model__Group__1
            {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:310:1: ( 'modelFile' )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:311:1: 'modelFile'
            {
             before(grammarAccess.getModelAccess().getModelFileKeyword_0()); 
            match(input,15,FOLLOW_15_in_rule__Model__Group__0599); 
             after(grammarAccess.getModelAccess().getModelFileKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__Model__Group__1_in_rule__Model__Group__0609);
            rule__Model__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__Group__0


    // $ANTLR start rule__Model__Group__1
    // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:325:1: rule__Model__Group__1 : ( ( rule__Model__ModelAssignment_1 ) ) ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:329:1: ( ( ( rule__Model__ModelAssignment_1 ) ) )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:330:1: ( ( rule__Model__ModelAssignment_1 ) )
            {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:330:1: ( ( rule__Model__ModelAssignment_1 ) )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:331:1: ( rule__Model__ModelAssignment_1 )
            {
             before(grammarAccess.getModelAccess().getModelAssignment_1()); 
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:332:1: ( rule__Model__ModelAssignment_1 )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:332:2: rule__Model__ModelAssignment_1
            {
            pushFollow(FOLLOW_rule__Model__ModelAssignment_1_in_rule__Model__Group__1637);
            rule__Model__ModelAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getModelAccess().getModelAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__Group__1


    // $ANTLR start rule__Target__Group__0
    // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:346:1: rule__Target__Group__0 : ( 'targetDir' ) rule__Target__Group__1 ;
    public final void rule__Target__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:350:1: ( ( 'targetDir' ) rule__Target__Group__1 )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:351:1: ( 'targetDir' ) rule__Target__Group__1
            {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:351:1: ( 'targetDir' )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:352:1: 'targetDir'
            {
             before(grammarAccess.getTargetAccess().getTargetDirKeyword_0()); 
            match(input,16,FOLLOW_16_in_rule__Target__Group__0676); 
             after(grammarAccess.getTargetAccess().getTargetDirKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__Target__Group__1_in_rule__Target__Group__0686);
            rule__Target__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Target__Group__0


    // $ANTLR start rule__Target__Group__1
    // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:366:1: rule__Target__Group__1 : ( ( rule__Target__TargetAssignment_1 ) ) ;
    public final void rule__Target__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:370:1: ( ( ( rule__Target__TargetAssignment_1 ) ) )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:371:1: ( ( rule__Target__TargetAssignment_1 ) )
            {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:371:1: ( ( rule__Target__TargetAssignment_1 ) )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:372:1: ( rule__Target__TargetAssignment_1 )
            {
             before(grammarAccess.getTargetAccess().getTargetAssignment_1()); 
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:373:1: ( rule__Target__TargetAssignment_1 )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:373:2: rule__Target__TargetAssignment_1
            {
            pushFollow(FOLLOW_rule__Target__TargetAssignment_1_in_rule__Target__Group__1714);
            rule__Target__TargetAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getTargetAccess().getTargetAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Target__Group__1


    // $ANTLR start rule__TargetPlatform__Group__0
    // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:387:1: rule__TargetPlatform__Group__0 : ( 'targetPlatform' ) rule__TargetPlatform__Group__1 ;
    public final void rule__TargetPlatform__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:391:1: ( ( 'targetPlatform' ) rule__TargetPlatform__Group__1 )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:392:1: ( 'targetPlatform' ) rule__TargetPlatform__Group__1
            {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:392:1: ( 'targetPlatform' )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:393:1: 'targetPlatform'
            {
             before(grammarAccess.getTargetPlatformAccess().getTargetPlatformKeyword_0()); 
            match(input,17,FOLLOW_17_in_rule__TargetPlatform__Group__0753); 
             after(grammarAccess.getTargetPlatformAccess().getTargetPlatformKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__TargetPlatform__Group__1_in_rule__TargetPlatform__Group__0763);
            rule__TargetPlatform__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TargetPlatform__Group__0


    // $ANTLR start rule__TargetPlatform__Group__1
    // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:407:1: rule__TargetPlatform__Group__1 : ( ( rule__TargetPlatform__TargetplatformAssignment_1 ) ) rule__TargetPlatform__Group__2 ;
    public final void rule__TargetPlatform__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:411:1: ( ( ( rule__TargetPlatform__TargetplatformAssignment_1 ) ) rule__TargetPlatform__Group__2 )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:412:1: ( ( rule__TargetPlatform__TargetplatformAssignment_1 ) ) rule__TargetPlatform__Group__2
            {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:412:1: ( ( rule__TargetPlatform__TargetplatformAssignment_1 ) )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:413:1: ( rule__TargetPlatform__TargetplatformAssignment_1 )
            {
             before(grammarAccess.getTargetPlatformAccess().getTargetplatformAssignment_1()); 
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:414:1: ( rule__TargetPlatform__TargetplatformAssignment_1 )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:414:2: rule__TargetPlatform__TargetplatformAssignment_1
            {
            pushFollow(FOLLOW_rule__TargetPlatform__TargetplatformAssignment_1_in_rule__TargetPlatform__Group__1791);
            rule__TargetPlatform__TargetplatformAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getTargetPlatformAccess().getTargetplatformAssignment_1()); 

            }

            pushFollow(FOLLOW_rule__TargetPlatform__Group__2_in_rule__TargetPlatform__Group__1800);
            rule__TargetPlatform__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TargetPlatform__Group__1


    // $ANTLR start rule__TargetPlatform__Group__2
    // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:425:1: rule__TargetPlatform__Group__2 : ( ( rule__TargetPlatform__DefensiveAssignment_2 )? ) ;
    public final void rule__TargetPlatform__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:429:1: ( ( ( rule__TargetPlatform__DefensiveAssignment_2 )? ) )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:430:1: ( ( rule__TargetPlatform__DefensiveAssignment_2 )? )
            {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:430:1: ( ( rule__TargetPlatform__DefensiveAssignment_2 )? )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:431:1: ( rule__TargetPlatform__DefensiveAssignment_2 )?
            {
             before(grammarAccess.getTargetPlatformAccess().getDefensiveAssignment_2()); 
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:432:1: ( rule__TargetPlatform__DefensiveAssignment_2 )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==18) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:432:2: rule__TargetPlatform__DefensiveAssignment_2
                    {
                    pushFollow(FOLLOW_rule__TargetPlatform__DefensiveAssignment_2_in_rule__TargetPlatform__Group__2828);
                    rule__TargetPlatform__DefensiveAssignment_2();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTargetPlatformAccess().getDefensiveAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TargetPlatform__Group__2


    // $ANTLR start rule__Workflow__ModelsAssignment_0
    // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:448:1: rule__Workflow__ModelsAssignment_0 : ( ruleModel ) ;
    public final void rule__Workflow__ModelsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:452:1: ( ( ruleModel ) )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:453:1: ( ruleModel )
            {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:453:1: ( ruleModel )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:454:1: ruleModel
            {
             before(grammarAccess.getWorkflowAccess().getModelsModelParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleModel_in_rule__Workflow__ModelsAssignment_0869);
            ruleModel();
            _fsp--;

             after(grammarAccess.getWorkflowAccess().getModelsModelParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Workflow__ModelsAssignment_0


    // $ANTLR start rule__Workflow__TargetAssignment_1
    // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:463:1: rule__Workflow__TargetAssignment_1 : ( ruleTarget ) ;
    public final void rule__Workflow__TargetAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:467:1: ( ( ruleTarget ) )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:468:1: ( ruleTarget )
            {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:468:1: ( ruleTarget )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:469:1: ruleTarget
            {
             before(grammarAccess.getWorkflowAccess().getTargetTargetParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleTarget_in_rule__Workflow__TargetAssignment_1900);
            ruleTarget();
            _fsp--;

             after(grammarAccess.getWorkflowAccess().getTargetTargetParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Workflow__TargetAssignment_1


    // $ANTLR start rule__Workflow__PlatformAssignment_2
    // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:478:1: rule__Workflow__PlatformAssignment_2 : ( ruleTargetPlatform ) ;
    public final void rule__Workflow__PlatformAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:482:1: ( ( ruleTargetPlatform ) )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:483:1: ( ruleTargetPlatform )
            {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:483:1: ( ruleTargetPlatform )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:484:1: ruleTargetPlatform
            {
             before(grammarAccess.getWorkflowAccess().getPlatformTargetPlatformParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleTargetPlatform_in_rule__Workflow__PlatformAssignment_2931);
            ruleTargetPlatform();
            _fsp--;

             after(grammarAccess.getWorkflowAccess().getPlatformTargetPlatformParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Workflow__PlatformAssignment_2


    // $ANTLR start rule__Model__ModelAssignment_1
    // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:493:1: rule__Model__ModelAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Model__ModelAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:497:1: ( ( RULE_STRING ) )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:498:1: ( RULE_STRING )
            {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:498:1: ( RULE_STRING )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:499:1: RULE_STRING
            {
             before(grammarAccess.getModelAccess().getModelSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Model__ModelAssignment_1962); 
             after(grammarAccess.getModelAccess().getModelSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__ModelAssignment_1


    // $ANTLR start rule__Target__TargetAssignment_1
    // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:508:1: rule__Target__TargetAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Target__TargetAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:512:1: ( ( RULE_STRING ) )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:513:1: ( RULE_STRING )
            {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:513:1: ( RULE_STRING )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:514:1: RULE_STRING
            {
             before(grammarAccess.getTargetAccess().getTargetSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Target__TargetAssignment_1993); 
             after(grammarAccess.getTargetAccess().getTargetSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Target__TargetAssignment_1


    // $ANTLR start rule__TargetPlatform__TargetplatformAssignment_1
    // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:523:1: rule__TargetPlatform__TargetplatformAssignment_1 : ( rulePlatform ) ;
    public final void rule__TargetPlatform__TargetplatformAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:527:1: ( ( rulePlatform ) )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:528:1: ( rulePlatform )
            {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:528:1: ( rulePlatform )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:529:1: rulePlatform
            {
             before(grammarAccess.getTargetPlatformAccess().getTargetplatformPlatformParserRuleCall_1_0()); 
            pushFollow(FOLLOW_rulePlatform_in_rule__TargetPlatform__TargetplatformAssignment_11024);
            rulePlatform();
            _fsp--;

             after(grammarAccess.getTargetPlatformAccess().getTargetplatformPlatformParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TargetPlatform__TargetplatformAssignment_1


    // $ANTLR start rule__TargetPlatform__DefensiveAssignment_2
    // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:538:1: rule__TargetPlatform__DefensiveAssignment_2 : ( ( 'defensive' ) ) ;
    public final void rule__TargetPlatform__DefensiveAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:542:1: ( ( ( 'defensive' ) ) )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:543:1: ( ( 'defensive' ) )
            {
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:543:1: ( ( 'defensive' ) )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:544:1: ( 'defensive' )
            {
             before(grammarAccess.getTargetPlatformAccess().getDefensiveDefensiveKeyword_2_0()); 
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:545:1: ( 'defensive' )
            // ../com.yakindu.statechart.workflow.ui/src-gen/com/yakindu/statechart/contentassist/antlr/internal/InternalWorkflow.g:546:1: 'defensive'
            {
             before(grammarAccess.getTargetPlatformAccess().getDefensiveDefensiveKeyword_2_0()); 
            match(input,18,FOLLOW_18_in_rule__TargetPlatform__DefensiveAssignment_21060); 
             after(grammarAccess.getTargetPlatformAccess().getDefensiveDefensiveKeyword_2_0()); 

            }

             after(grammarAccess.getTargetPlatformAccess().getDefensiveDefensiveKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TargetPlatform__DefensiveAssignment_2


 

    public static final BitSet FOLLOW_ruleWorkflow_in_entryRuleWorkflow60 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWorkflow67 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Workflow__Group__0_in_ruleWorkflow94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel120 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__0_in_ruleModel154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTarget_in_entryRuleTarget180 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTarget187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Target__Group__0_in_ruleTarget214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTargetPlatform_in_entryRuleTargetPlatform240 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTargetPlatform247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group__0_in_ruleTargetPlatform274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePlatform_in_entryRulePlatform300 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePlatform307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Platform__Alternatives_in_rulePlatform334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Platform__Alternatives371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Platform__Alternatives391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Platform__Alternatives411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Platform__Alternatives431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Workflow__ModelsAssignment_0_in_rule__Workflow__Group__0469 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_rule__Workflow__ModelsAssignment_0_in_rule__Workflow__Group__0481 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_rule__Workflow__Group__1_in_rule__Workflow__Group__0493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Workflow__TargetAssignment_1_in_rule__Workflow__Group__1521 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__Workflow__Group__2_in_rule__Workflow__Group__1530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Workflow__PlatformAssignment_2_in_rule__Workflow__Group__2558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Model__Group__0599 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Model__Group__1_in_rule__Model__Group__0609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__ModelAssignment_1_in_rule__Model__Group__1637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Target__Group__0676 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Target__Group__1_in_rule__Target__Group__0686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Target__TargetAssignment_1_in_rule__Target__Group__1714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__TargetPlatform__Group__0753 = new BitSet(new long[]{0x0000000000007800L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group__1_in_rule__TargetPlatform__Group__0763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__TargetplatformAssignment_1_in_rule__TargetPlatform__Group__1791 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group__2_in_rule__TargetPlatform__Group__1800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__DefensiveAssignment_2_in_rule__TargetPlatform__Group__2828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModel_in_rule__Workflow__ModelsAssignment_0869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTarget_in_rule__Workflow__TargetAssignment_1900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTargetPlatform_in_rule__Workflow__PlatformAssignment_2931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Model__ModelAssignment_1962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Target__TargetAssignment_1993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePlatform_in_rule__TargetPlatform__TargetplatformAssignment_11024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__TargetPlatform__DefensiveAssignment_21060 = new BitSet(new long[]{0x0000000000000002L});

}