package com.yakindu.statechart.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import com.yakindu.statechart.services.WorkflowGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalWorkflowParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'modelFile'", "'targetDir'", "'targetPlatform'", "'defensive'", "'c'", "'java'", "'javame'", "'lejos'"
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
    public String getGrammarFileName() { return "../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g"; }


     
     	private WorkflowGrammarAccess grammarAccess;
     	
        public InternalWorkflowParser(TokenStream input, IAstFactory factory, WorkflowGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Workflow";	
       	} 



    // $ANTLR start entryRuleWorkflow
    // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:72:1: entryRuleWorkflow returns [EObject current=null] : iv_ruleWorkflow= ruleWorkflow EOF ;
    public final EObject entryRuleWorkflow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWorkflow = null;


        try {
            // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:72:50: (iv_ruleWorkflow= ruleWorkflow EOF )
            // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:73:2: iv_ruleWorkflow= ruleWorkflow EOF
            {
             currentNode = createCompositeNode(grammarAccess.getWorkflowRule(), currentNode); 
            pushFollow(FOLLOW_ruleWorkflow_in_entryRuleWorkflow73);
            iv_ruleWorkflow=ruleWorkflow();
            _fsp--;

             current =iv_ruleWorkflow; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWorkflow83); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleWorkflow


    // $ANTLR start ruleWorkflow
    // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:80:1: ruleWorkflow returns [EObject current=null] : ( (lv_models_0= ruleModel )+ (lv_target_1= ruleTarget ) (lv_platform_2= ruleTargetPlatform ) ) ;
    public final EObject ruleWorkflow() throws RecognitionException {
        EObject current = null;

        EObject lv_models_0 = null;

        EObject lv_target_1 = null;

        EObject lv_platform_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:85:6: ( ( (lv_models_0= ruleModel )+ (lv_target_1= ruleTarget ) (lv_platform_2= ruleTargetPlatform ) ) )
            // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:86:1: ( (lv_models_0= ruleModel )+ (lv_target_1= ruleTarget ) (lv_platform_2= ruleTargetPlatform ) )
            {
            // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:86:1: ( (lv_models_0= ruleModel )+ (lv_target_1= ruleTarget ) (lv_platform_2= ruleTargetPlatform ) )
            // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:86:2: (lv_models_0= ruleModel )+ (lv_target_1= ruleTarget ) (lv_platform_2= ruleTargetPlatform )
            {
            // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:86:2: (lv_models_0= ruleModel )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:89:6: lv_models_0= ruleModel
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getWorkflowAccess().getModelsModelParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleModel_in_ruleWorkflow142);
            	    lv_models_0=ruleModel();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getWorkflowRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "models", lv_models_0, "Model", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

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

            // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:107:3: (lv_target_1= ruleTarget )
            // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:110:6: lv_target_1= ruleTarget
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getWorkflowAccess().getTargetTargetParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTarget_in_ruleWorkflow181);
            lv_target_1=ruleTarget();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getWorkflowRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "target", lv_target_1, "Target", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:128:2: (lv_platform_2= ruleTargetPlatform )
            // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:131:6: lv_platform_2= ruleTargetPlatform
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getWorkflowAccess().getPlatformTargetPlatformParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTargetPlatform_in_ruleWorkflow219);
            lv_platform_2=ruleTargetPlatform();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getWorkflowRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "platform", lv_platform_2, "TargetPlatform", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleWorkflow


    // $ANTLR start entryRuleModel
    // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:156:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:156:47: (iv_ruleModel= ruleModel EOF )
            // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:157:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel256);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel266); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleModel


    // $ANTLR start ruleModel
    // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:164:1: ruleModel returns [EObject current=null] : ( 'modelFile' (lv_model_1= RULE_STRING ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token lv_model_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:169:6: ( ( 'modelFile' (lv_model_1= RULE_STRING ) ) )
            // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:170:1: ( 'modelFile' (lv_model_1= RULE_STRING ) )
            {
            // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:170:1: ( 'modelFile' (lv_model_1= RULE_STRING ) )
            // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:170:2: 'modelFile' (lv_model_1= RULE_STRING )
            {
            match(input,11,FOLLOW_11_in_ruleModel300); 

                    createLeafNode(grammarAccess.getModelAccess().getModelFileKeyword_0(), null); 
                
            // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:174:1: (lv_model_1= RULE_STRING )
            // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:176:6: lv_model_1= RULE_STRING
            {
            lv_model_1=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleModel322); 

            		createLeafNode(grammarAccess.getModelAccess().getModelSTRINGTerminalRuleCall_1_0(), "model"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "model", lv_model_1, "STRING", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleTarget
    // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:201:1: entryRuleTarget returns [EObject current=null] : iv_ruleTarget= ruleTarget EOF ;
    public final EObject entryRuleTarget() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTarget = null;


        try {
            // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:201:48: (iv_ruleTarget= ruleTarget EOF )
            // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:202:2: iv_ruleTarget= ruleTarget EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTargetRule(), currentNode); 
            pushFollow(FOLLOW_ruleTarget_in_entryRuleTarget363);
            iv_ruleTarget=ruleTarget();
            _fsp--;

             current =iv_ruleTarget; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTarget373); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleTarget


    // $ANTLR start ruleTarget
    // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:209:1: ruleTarget returns [EObject current=null] : ( 'targetDir' (lv_target_1= RULE_STRING ) ) ;
    public final EObject ruleTarget() throws RecognitionException {
        EObject current = null;

        Token lv_target_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:214:6: ( ( 'targetDir' (lv_target_1= RULE_STRING ) ) )
            // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:215:1: ( 'targetDir' (lv_target_1= RULE_STRING ) )
            {
            // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:215:1: ( 'targetDir' (lv_target_1= RULE_STRING ) )
            // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:215:2: 'targetDir' (lv_target_1= RULE_STRING )
            {
            match(input,12,FOLLOW_12_in_ruleTarget407); 

                    createLeafNode(grammarAccess.getTargetAccess().getTargetDirKeyword_0(), null); 
                
            // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:219:1: (lv_target_1= RULE_STRING )
            // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:221:6: lv_target_1= RULE_STRING
            {
            lv_target_1=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleTarget429); 

            		createLeafNode(grammarAccess.getTargetAccess().getTargetSTRINGTerminalRuleCall_1_0(), "target"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTargetRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "target", lv_target_1, "STRING", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleTarget


    // $ANTLR start entryRuleTargetPlatform
    // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:246:1: entryRuleTargetPlatform returns [EObject current=null] : iv_ruleTargetPlatform= ruleTargetPlatform EOF ;
    public final EObject entryRuleTargetPlatform() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTargetPlatform = null;


        try {
            // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:246:56: (iv_ruleTargetPlatform= ruleTargetPlatform EOF )
            // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:247:2: iv_ruleTargetPlatform= ruleTargetPlatform EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTargetPlatformRule(), currentNode); 
            pushFollow(FOLLOW_ruleTargetPlatform_in_entryRuleTargetPlatform470);
            iv_ruleTargetPlatform=ruleTargetPlatform();
            _fsp--;

             current =iv_ruleTargetPlatform; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTargetPlatform480); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleTargetPlatform


    // $ANTLR start ruleTargetPlatform
    // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:254:1: ruleTargetPlatform returns [EObject current=null] : ( 'targetPlatform' (lv_targetplatform_1= rulePlatform ) (lv_defensive_2= 'defensive' )? ) ;
    public final EObject ruleTargetPlatform() throws RecognitionException {
        EObject current = null;

        Token lv_defensive_2=null;
        AntlrDatatypeRuleToken lv_targetplatform_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:259:6: ( ( 'targetPlatform' (lv_targetplatform_1= rulePlatform ) (lv_defensive_2= 'defensive' )? ) )
            // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:260:1: ( 'targetPlatform' (lv_targetplatform_1= rulePlatform ) (lv_defensive_2= 'defensive' )? )
            {
            // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:260:1: ( 'targetPlatform' (lv_targetplatform_1= rulePlatform ) (lv_defensive_2= 'defensive' )? )
            // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:260:2: 'targetPlatform' (lv_targetplatform_1= rulePlatform ) (lv_defensive_2= 'defensive' )?
            {
            match(input,13,FOLLOW_13_in_ruleTargetPlatform514); 

                    createLeafNode(grammarAccess.getTargetPlatformAccess().getTargetPlatformKeyword_0(), null); 
                
            // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:264:1: (lv_targetplatform_1= rulePlatform )
            // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:267:6: lv_targetplatform_1= rulePlatform
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getTargetPlatformAccess().getTargetplatformPlatformParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_rulePlatform_in_ruleTargetPlatform548);
            lv_targetplatform_1=rulePlatform();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTargetPlatformRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "targetplatform", lv_targetplatform_1, "Platform", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:285:2: (lv_defensive_2= 'defensive' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==14) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:287:6: lv_defensive_2= 'defensive'
                    {
                    lv_defensive_2=(Token)input.LT(1);
                    match(input,14,FOLLOW_14_in_ruleTargetPlatform573); 

                            createLeafNode(grammarAccess.getTargetPlatformAccess().getDefensiveDefensiveKeyword_2_0(), "defensive"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTargetPlatformRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "defensive", true, "defensive", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleTargetPlatform


    // $ANTLR start entryRulePlatform
    // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:313:1: entryRulePlatform returns [String current=null] : iv_rulePlatform= rulePlatform EOF ;
    public final String entryRulePlatform() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePlatform = null;


        try {
            // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:313:49: (iv_rulePlatform= rulePlatform EOF )
            // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:314:2: iv_rulePlatform= rulePlatform EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPlatformRule(), currentNode); 
            pushFollow(FOLLOW_rulePlatform_in_entryRulePlatform621);
            iv_rulePlatform=rulePlatform();
            _fsp--;

             current =iv_rulePlatform.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePlatform632); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRulePlatform


    // $ANTLR start rulePlatform
    // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:321:1: rulePlatform returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'c' | kw= 'java' | kw= 'javame' | kw= 'lejos' ) ;
    public final AntlrDatatypeRuleToken rulePlatform() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:327:6: ( (kw= 'c' | kw= 'java' | kw= 'javame' | kw= 'lejos' ) )
            // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:328:1: (kw= 'c' | kw= 'java' | kw= 'javame' | kw= 'lejos' )
            {
            // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:328:1: (kw= 'c' | kw= 'java' | kw= 'javame' | kw= 'lejos' )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt3=1;
                }
                break;
            case 16:
                {
                alt3=2;
                }
                break;
            case 17:
                {
                alt3=3;
                }
                break;
            case 18:
                {
                alt3=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("328:1: (kw= 'c' | kw= 'java' | kw= 'javame' | kw= 'lejos' )", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:329:2: kw= 'c'
                    {
                    kw=(Token)input.LT(1);
                    match(input,15,FOLLOW_15_in_rulePlatform670); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getPlatformAccess().getCKeyword_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:336:2: kw= 'java'
                    {
                    kw=(Token)input.LT(1);
                    match(input,16,FOLLOW_16_in_rulePlatform689); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getPlatformAccess().getJavaKeyword_1(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:343:2: kw= 'javame'
                    {
                    kw=(Token)input.LT(1);
                    match(input,17,FOLLOW_17_in_rulePlatform708); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getPlatformAccess().getJavameKeyword_2(), null); 
                        

                    }
                    break;
                case 4 :
                    // ../com.yakindu.statechart.workflow/src-gen/com/yakindu/statechart/parser/antlr/internal/InternalWorkflow.g:350:2: kw= 'lejos'
                    {
                    kw=(Token)input.LT(1);
                    match(input,18,FOLLOW_18_in_rulePlatform727); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getPlatformAccess().getLejosKeyword_3(), null); 
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
            	    lastConsumedDatatypeToken = current;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end rulePlatform


 

    public static final BitSet FOLLOW_ruleWorkflow_in_entryRuleWorkflow73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWorkflow83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModel_in_ruleWorkflow142 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_ruleTarget_in_ruleWorkflow181 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleTargetPlatform_in_ruleWorkflow219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel256 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleModel300 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleModel322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTarget_in_entryRuleTarget363 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTarget373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleTarget407 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleTarget429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTargetPlatform_in_entryRuleTargetPlatform470 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTargetPlatform480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleTargetPlatform514 = new BitSet(new long[]{0x0000000000078000L});
    public static final BitSet FOLLOW_rulePlatform_in_ruleTargetPlatform548 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleTargetPlatform573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePlatform_in_entryRulePlatform621 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePlatform632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rulePlatform670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rulePlatform689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rulePlatform708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rulePlatform727 = new BitSet(new long[]{0x0000000000000002L});

}