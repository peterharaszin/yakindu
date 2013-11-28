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

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import com.yakindu.statechart.model.expressions.services.StatechartExpressionsGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalStatechartExpressionsParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_HEX_LITERAL", "RULE_BOOLEAN_LITERAL", "RULE_STRING", "RULE_FLOATING_POINT_LITERAL", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "','", "'after'", "'('", "')'", "'var'", "';'", "'raise'", "'||'", "'&&'", "'^'", "'|'", "'&'", "'?'", "':'", "'s'", "'ms'", "'ns'", "'='", "'*='", "'/='", "'%='", "'+='", "'-='", "'<<='", "'>>='", "'&='", "'^='", "'|='", "'=='", "'!='", "'<'", "'>'", "'<='", "'>='", "'<<'", "'>>'", "'+'", "'-'", "'*'", "'/'", "'%'", "'~'", "'!'"
    };
    public static final int RULE_ML_COMMENT=10;
    public static final int RULE_ID=4;
    public static final int RULE_HEX_LITERAL=6;
    public static final int RULE_WS=12;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=8;
    public static final int RULE_BOOLEAN_LITERAL=7;
    public static final int RULE_ANY_OTHER=13;
    public static final int RULE_SL_COMMENT=11;
    public static final int RULE_FLOATING_POINT_LITERAL=9;

        public InternalStatechartExpressionsParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g"; }


     
     	private StatechartExpressionsGrammarAccess grammarAccess;
     	
        public InternalStatechartExpressionsParser(TokenStream input, IAstFactory factory, StatechartExpressionsGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Expression";	
       	} 



    // $ANTLR start entryRuleExpression
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:73:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:73:52: (iv_ruleExpression= ruleExpression EOF )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:74:2: iv_ruleExpression= ruleExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression73);
            iv_ruleExpression=ruleExpression();
            _fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression83); 

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
    // $ANTLR end entryRuleExpression


    // $ANTLR start ruleExpression
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:81:1: ruleExpression returns [EObject current=null] : (this_TriggerExpression_0= ruleTriggerExpression | this_GuardExpression_1= ruleGuardExpression | this_ActionExpression_2= ruleActionExpression ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_TriggerExpression_0 = null;

        EObject this_GuardExpression_1 = null;

        EObject this_ActionExpression_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:86:6: ( (this_TriggerExpression_0= ruleTriggerExpression | this_GuardExpression_1= ruleGuardExpression | this_ActionExpression_2= ruleActionExpression ) )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:87:1: (this_TriggerExpression_0= ruleTriggerExpression | this_GuardExpression_1= ruleGuardExpression | this_ActionExpression_2= ruleActionExpression )
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:87:1: (this_TriggerExpression_0= ruleTriggerExpression | this_GuardExpression_1= ruleGuardExpression | this_ActionExpression_2= ruleActionExpression )
            int alt1=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==16||(LA1_1>=31 && LA1_1<=41)) ) {
                    alt1=3;
                }
                else if ( (LA1_1==EOF||LA1_1==14) ) {
                    alt1=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("87:1: (this_TriggerExpression_0= ruleTriggerExpression | this_GuardExpression_1= ruleGuardExpression | this_ActionExpression_2= ruleActionExpression )", 1, 1, input);

                    throw nvae;
                }
                }
                break;
            case 15:
                {
                alt1=1;
                }
                break;
            case RULE_INT:
            case RULE_HEX_LITERAL:
            case RULE_BOOLEAN_LITERAL:
            case RULE_STRING:
            case RULE_FLOATING_POINT_LITERAL:
            case 16:
            case 50:
            case 51:
            case 55:
            case 56:
                {
                alt1=2;
                }
                break;
            case 18:
                {
                int LA1_4 = input.LA(2);

                if ( (LA1_4==16) ) {
                    int LA1_6 = input.LA(3);

                    if ( (LA1_6==RULE_ID) ) {
                        int LA1_7 = input.LA(4);

                        if ( (LA1_7==17) ) {
                            int LA1_8 = input.LA(5);

                            if ( ((LA1_8>=31 && LA1_8<=41)) ) {
                                alt1=3;
                            }
                            else if ( (LA1_8==EOF||(LA1_8>=21 && LA1_8<=25)||(LA1_8>=42 && LA1_8<=54)) ) {
                                alt1=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("87:1: (this_TriggerExpression_0= ruleTriggerExpression | this_GuardExpression_1= ruleGuardExpression | this_ActionExpression_2= ruleActionExpression )", 1, 8, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("87:1: (this_TriggerExpression_0= ruleTriggerExpression | this_GuardExpression_1= ruleGuardExpression | this_ActionExpression_2= ruleActionExpression )", 1, 7, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("87:1: (this_TriggerExpression_0= ruleTriggerExpression | this_GuardExpression_1= ruleGuardExpression | this_ActionExpression_2= ruleActionExpression )", 1, 6, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("87:1: (this_TriggerExpression_0= ruleTriggerExpression | this_GuardExpression_1= ruleGuardExpression | this_ActionExpression_2= ruleActionExpression )", 1, 4, input);

                    throw nvae;
                }
                }
                break;
            case 20:
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("87:1: (this_TriggerExpression_0= ruleTriggerExpression | this_GuardExpression_1= ruleGuardExpression | this_ActionExpression_2= ruleActionExpression )", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:88:5: this_TriggerExpression_0= ruleTriggerExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getTriggerExpressionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTriggerExpression_in_ruleExpression130);
                    this_TriggerExpression_0=ruleTriggerExpression();
                    _fsp--;

                     
                            current = this_TriggerExpression_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:98:5: this_GuardExpression_1= ruleGuardExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getGuardExpressionParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleGuardExpression_in_ruleExpression157);
                    this_GuardExpression_1=ruleGuardExpression();
                    _fsp--;

                     
                            current = this_GuardExpression_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:108:5: this_ActionExpression_2= ruleActionExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getActionExpressionParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleActionExpression_in_ruleExpression184);
                    this_ActionExpression_2=ruleActionExpression();
                    _fsp--;

                     
                            current = this_ActionExpression_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

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
    // $ANTLR end ruleExpression


    // $ANTLR start entryRuleTriggerExpression
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:123:1: entryRuleTriggerExpression returns [EObject current=null] : iv_ruleTriggerExpression= ruleTriggerExpression EOF ;
    public final EObject entryRuleTriggerExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTriggerExpression = null;


        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:123:59: (iv_ruleTriggerExpression= ruleTriggerExpression EOF )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:124:2: iv_ruleTriggerExpression= ruleTriggerExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTriggerExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleTriggerExpression_in_entryRuleTriggerExpression216);
            iv_ruleTriggerExpression=ruleTriggerExpression();
            _fsp--;

             current =iv_ruleTriggerExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTriggerExpression226); 

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
    // $ANTLR end entryRuleTriggerExpression


    // $ANTLR start ruleTriggerExpression
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:131:1: ruleTriggerExpression returns [EObject current=null] : ( (lv_triggers_0= ruleTrigger ) ( ',' (lv_triggers_2= ruleTrigger ) )* ) ;
    public final EObject ruleTriggerExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_triggers_0 = null;

        EObject lv_triggers_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:136:6: ( ( (lv_triggers_0= ruleTrigger ) ( ',' (lv_triggers_2= ruleTrigger ) )* ) )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:137:1: ( (lv_triggers_0= ruleTrigger ) ( ',' (lv_triggers_2= ruleTrigger ) )* )
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:137:1: ( (lv_triggers_0= ruleTrigger ) ( ',' (lv_triggers_2= ruleTrigger ) )* )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:137:2: (lv_triggers_0= ruleTrigger ) ( ',' (lv_triggers_2= ruleTrigger ) )*
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:137:2: (lv_triggers_0= ruleTrigger )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:140:6: lv_triggers_0= ruleTrigger
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getTriggerExpressionAccess().getTriggersTriggerParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTrigger_in_ruleTriggerExpression285);
            lv_triggers_0=ruleTrigger();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTriggerExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		add(current, "triggers", lv_triggers_0, "Trigger", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:158:2: ( ',' (lv_triggers_2= ruleTrigger ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==14) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:158:3: ',' (lv_triggers_2= ruleTrigger )
            	    {
            	    match(input,14,FOLLOW_14_in_ruleTriggerExpression299); 

            	            createLeafNode(grammarAccess.getTriggerExpressionAccess().getCommaKeyword_1_0(), null); 
            	        
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:162:1: (lv_triggers_2= ruleTrigger )
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:165:6: lv_triggers_2= ruleTrigger
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getTriggerExpressionAccess().getTriggersTriggerParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTrigger_in_ruleTriggerExpression333);
            	    lv_triggers_2=ruleTrigger();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getTriggerExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "triggers", lv_triggers_2, "Trigger", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


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
    // $ANTLR end ruleTriggerExpression


    // $ANTLR start entryRuleGuardExpression
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:190:1: entryRuleGuardExpression returns [EObject current=null] : iv_ruleGuardExpression= ruleGuardExpression EOF ;
    public final EObject entryRuleGuardExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuardExpression = null;


        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:190:57: (iv_ruleGuardExpression= ruleGuardExpression EOF )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:191:2: iv_ruleGuardExpression= ruleGuardExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getGuardExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleGuardExpression_in_entryRuleGuardExpression372);
            iv_ruleGuardExpression=ruleGuardExpression();
            _fsp--;

             current =iv_ruleGuardExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGuardExpression382); 

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
    // $ANTLR end entryRuleGuardExpression


    // $ANTLR start ruleGuardExpression
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:198:1: ruleGuardExpression returns [EObject current=null] : (lv_expression_0= ruleBooleanOrExpression ) ;
    public final EObject ruleGuardExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:203:6: ( (lv_expression_0= ruleBooleanOrExpression ) )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:204:1: (lv_expression_0= ruleBooleanOrExpression )
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:204:1: (lv_expression_0= ruleBooleanOrExpression )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:207:6: lv_expression_0= ruleBooleanOrExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getGuardExpressionAccess().getExpressionBooleanOrExpressionParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBooleanOrExpression_in_ruleGuardExpression440);
            lv_expression_0=ruleBooleanOrExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getGuardExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "expression", lv_expression_0, "BooleanOrExpression", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // $ANTLR end ruleGuardExpression


    // $ANTLR start entryRuleActionExpression
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:232:1: entryRuleActionExpression returns [EObject current=null] : iv_ruleActionExpression= ruleActionExpression EOF ;
    public final EObject entryRuleActionExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActionExpression = null;


        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:232:58: (iv_ruleActionExpression= ruleActionExpression EOF )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:233:2: iv_ruleActionExpression= ruleActionExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getActionExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleActionExpression_in_entryRuleActionExpression476);
            iv_ruleActionExpression=ruleActionExpression();
            _fsp--;

             current =iv_ruleActionExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleActionExpression486); 

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
    // $ANTLR end entryRuleActionExpression


    // $ANTLR start ruleActionExpression
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:240:1: ruleActionExpression returns [EObject current=null] : (lv_statement_0= ruleStatement )+ ;
    public final EObject ruleActionExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_statement_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:245:6: ( (lv_statement_0= ruleStatement )+ )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:246:1: (lv_statement_0= ruleStatement )+
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:246:1: (lv_statement_0= ruleStatement )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID||LA3_0==18||LA3_0==20) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:249:6: lv_statement_0= ruleStatement
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getActionExpressionAccess().getStatementStatementParserRuleCall_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleStatement_in_ruleActionExpression544);
            	    lv_statement_0=ruleStatement();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getActionExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "statement", lv_statement_0, "Statement", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


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
    // $ANTLR end ruleActionExpression


    // $ANTLR start entryRuleTrigger
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:274:1: entryRuleTrigger returns [EObject current=null] : iv_ruleTrigger= ruleTrigger EOF ;
    public final EObject entryRuleTrigger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrigger = null;


        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:274:49: (iv_ruleTrigger= ruleTrigger EOF )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:275:2: iv_ruleTrigger= ruleTrigger EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTriggerRule(), currentNode); 
            pushFollow(FOLLOW_ruleTrigger_in_entryRuleTrigger581);
            iv_ruleTrigger=ruleTrigger();
            _fsp--;

             current =iv_ruleTrigger; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTrigger591); 

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
    // $ANTLR end entryRuleTrigger


    // $ANTLR start ruleTrigger
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:282:1: ruleTrigger returns [EObject current=null] : (lv_event_0= ruleEvent ) ;
    public final EObject ruleTrigger() throws RecognitionException {
        EObject current = null;

        EObject lv_event_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:287:6: ( (lv_event_0= ruleEvent ) )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:288:1: (lv_event_0= ruleEvent )
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:288:1: (lv_event_0= ruleEvent )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:291:6: lv_event_0= ruleEvent
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getTriggerAccess().getEventEventParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleEvent_in_ruleTrigger649);
            lv_event_0=ruleEvent();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTriggerRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "event", lv_event_0, "Event", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // $ANTLR end ruleTrigger


    // $ANTLR start entryRuleEvent
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:316:1: entryRuleEvent returns [EObject current=null] : iv_ruleEvent= ruleEvent EOF ;
    public final EObject entryRuleEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvent = null;


        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:316:47: (iv_ruleEvent= ruleEvent EOF )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:317:2: iv_ruleEvent= ruleEvent EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEventRule(), currentNode); 
            pushFollow(FOLLOW_ruleEvent_in_entryRuleEvent685);
            iv_ruleEvent=ruleEvent();
            _fsp--;

             current =iv_ruleEvent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEvent695); 

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
    // $ANTLR end entryRuleEvent


    // $ANTLR start ruleEvent
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:324:1: ruleEvent returns [EObject current=null] : (this_SignalEvent_0= ruleSignalEvent | this_TimeEvent_1= ruleTimeEvent ) ;
    public final EObject ruleEvent() throws RecognitionException {
        EObject current = null;

        EObject this_SignalEvent_0 = null;

        EObject this_TimeEvent_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:329:6: ( (this_SignalEvent_0= ruleSignalEvent | this_TimeEvent_1= ruleTimeEvent ) )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:330:1: (this_SignalEvent_0= ruleSignalEvent | this_TimeEvent_1= ruleTimeEvent )
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:330:1: (this_SignalEvent_0= ruleSignalEvent | this_TimeEvent_1= ruleTimeEvent )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                alt4=1;
            }
            else if ( (LA4_0==15) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("330:1: (this_SignalEvent_0= ruleSignalEvent | this_TimeEvent_1= ruleTimeEvent )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:331:5: this_SignalEvent_0= ruleSignalEvent
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getEventAccess().getSignalEventParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleSignalEvent_in_ruleEvent742);
                    this_SignalEvent_0=ruleSignalEvent();
                    _fsp--;

                     
                            current = this_SignalEvent_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:341:5: this_TimeEvent_1= ruleTimeEvent
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getEventAccess().getTimeEventParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTimeEvent_in_ruleEvent769);
                    this_TimeEvent_1=ruleTimeEvent();
                    _fsp--;

                     
                            current = this_TimeEvent_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

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
    // $ANTLR end ruleEvent


    // $ANTLR start entryRuleSignalEvent
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:356:1: entryRuleSignalEvent returns [EObject current=null] : iv_ruleSignalEvent= ruleSignalEvent EOF ;
    public final EObject entryRuleSignalEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSignalEvent = null;


        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:356:53: (iv_ruleSignalEvent= ruleSignalEvent EOF )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:357:2: iv_ruleSignalEvent= ruleSignalEvent EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSignalEventRule(), currentNode); 
            pushFollow(FOLLOW_ruleSignalEvent_in_entryRuleSignalEvent801);
            iv_ruleSignalEvent=ruleSignalEvent();
            _fsp--;

             current =iv_ruleSignalEvent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSignalEvent811); 

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
    // $ANTLR end entryRuleSignalEvent


    // $ANTLR start ruleSignalEvent
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:364:1: ruleSignalEvent returns [EObject current=null] : (lv_identifier_0= RULE_ID ) ;
    public final EObject ruleSignalEvent() throws RecognitionException {
        EObject current = null;

        Token lv_identifier_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:369:6: ( (lv_identifier_0= RULE_ID ) )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:370:1: (lv_identifier_0= RULE_ID )
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:370:1: (lv_identifier_0= RULE_ID )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:372:6: lv_identifier_0= RULE_ID
            {
            lv_identifier_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSignalEvent857); 

            		createLeafNode(grammarAccess.getSignalEventAccess().getIdentifierIDTerminalRuleCall_0(), "identifier"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSignalEventRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "identifier", lv_identifier_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
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
    // $ANTLR end ruleSignalEvent


    // $ANTLR start entryRuleTimeEvent
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:397:1: entryRuleTimeEvent returns [EObject current=null] : iv_ruleTimeEvent= ruleTimeEvent EOF ;
    public final EObject entryRuleTimeEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeEvent = null;


        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:397:51: (iv_ruleTimeEvent= ruleTimeEvent EOF )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:398:2: iv_ruleTimeEvent= ruleTimeEvent EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTimeEventRule(), currentNode); 
            pushFollow(FOLLOW_ruleTimeEvent_in_entryRuleTimeEvent897);
            iv_ruleTimeEvent=ruleTimeEvent();
            _fsp--;

             current =iv_ruleTimeEvent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTimeEvent907); 

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
    // $ANTLR end entryRuleTimeEvent


    // $ANTLR start ruleTimeEvent
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:405:1: ruleTimeEvent returns [EObject current=null] : ( 'after' '(' (lv_duration_2= ruleTimeExpression ) ')' ) ;
    public final EObject ruleTimeEvent() throws RecognitionException {
        EObject current = null;

        EObject lv_duration_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:410:6: ( ( 'after' '(' (lv_duration_2= ruleTimeExpression ) ')' ) )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:411:1: ( 'after' '(' (lv_duration_2= ruleTimeExpression ) ')' )
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:411:1: ( 'after' '(' (lv_duration_2= ruleTimeExpression ) ')' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:411:2: 'after' '(' (lv_duration_2= ruleTimeExpression ) ')'
            {
            match(input,15,FOLLOW_15_in_ruleTimeEvent941); 

                    createLeafNode(grammarAccess.getTimeEventAccess().getAfterKeyword_0(), null); 
                
            match(input,16,FOLLOW_16_in_ruleTimeEvent950); 

                    createLeafNode(grammarAccess.getTimeEventAccess().getLeftParenthesisKeyword_1(), null); 
                
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:419:1: (lv_duration_2= ruleTimeExpression )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:422:6: lv_duration_2= ruleTimeExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getTimeEventAccess().getDurationTimeExpressionParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTimeExpression_in_ruleTimeEvent984);
            lv_duration_2=ruleTimeExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTimeEventRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "duration", lv_duration_2, "TimeExpression", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            match(input,17,FOLLOW_17_in_ruleTimeEvent997); 

                    createLeafNode(grammarAccess.getTimeEventAccess().getRightParenthesisKeyword_3(), null); 
                

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
    // $ANTLR end ruleTimeEvent


    // $ANTLR start entryRuleTimeExpression
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:451:1: entryRuleTimeExpression returns [EObject current=null] : iv_ruleTimeExpression= ruleTimeExpression EOF ;
    public final EObject entryRuleTimeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeExpression = null;


        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:451:56: (iv_ruleTimeExpression= ruleTimeExpression EOF )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:452:2: iv_ruleTimeExpression= ruleTimeExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTimeExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleTimeExpression_in_entryRuleTimeExpression1030);
            iv_ruleTimeExpression=ruleTimeExpression();
            _fsp--;

             current =iv_ruleTimeExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTimeExpression1040); 

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
    // $ANTLR end entryRuleTimeExpression


    // $ANTLR start ruleTimeExpression
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:459:1: ruleTimeExpression returns [EObject current=null] : (this_TimeConstant_0= ruleTimeConstant | this_VariableReference_1= ruleVariableReference ) ;
    public final EObject ruleTimeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_TimeConstant_0 = null;

        EObject this_VariableReference_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:464:6: ( (this_TimeConstant_0= ruleTimeConstant | this_VariableReference_1= ruleVariableReference ) )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:465:1: (this_TimeConstant_0= ruleTimeConstant | this_VariableReference_1= ruleVariableReference )
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:465:1: (this_TimeConstant_0= ruleTimeConstant | this_VariableReference_1= ruleVariableReference )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_INT) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_ID||LA5_0==18) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("465:1: (this_TimeConstant_0= ruleTimeConstant | this_VariableReference_1= ruleVariableReference )", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:466:5: this_TimeConstant_0= ruleTimeConstant
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTimeExpressionAccess().getTimeConstantParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTimeConstant_in_ruleTimeExpression1087);
                    this_TimeConstant_0=ruleTimeConstant();
                    _fsp--;

                     
                            current = this_TimeConstant_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:476:5: this_VariableReference_1= ruleVariableReference
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTimeExpressionAccess().getVariableReferenceParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVariableReference_in_ruleTimeExpression1114);
                    this_VariableReference_1=ruleVariableReference();
                    _fsp--;

                     
                            current = this_VariableReference_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

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
    // $ANTLR end ruleTimeExpression


    // $ANTLR start entryRuleVariableReference
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:491:1: entryRuleVariableReference returns [EObject current=null] : iv_ruleVariableReference= ruleVariableReference EOF ;
    public final EObject entryRuleVariableReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableReference = null;


        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:491:59: (iv_ruleVariableReference= ruleVariableReference EOF )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:492:2: iv_ruleVariableReference= ruleVariableReference EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVariableReferenceRule(), currentNode); 
            pushFollow(FOLLOW_ruleVariableReference_in_entryRuleVariableReference1146);
            iv_ruleVariableReference=ruleVariableReference();
            _fsp--;

             current =iv_ruleVariableReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableReference1156); 

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
    // $ANTLR end entryRuleVariableReference


    // $ANTLR start ruleVariableReference
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:499:1: ruleVariableReference returns [EObject current=null] : ( (lv_variable_0= ruleVariable ) | ( 'var' '(' (lv_variable_3= ruleVariable ) ')' ) ) ;
    public final EObject ruleVariableReference() throws RecognitionException {
        EObject current = null;

        EObject lv_variable_0 = null;

        EObject lv_variable_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:504:6: ( ( (lv_variable_0= ruleVariable ) | ( 'var' '(' (lv_variable_3= ruleVariable ) ')' ) ) )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:505:1: ( (lv_variable_0= ruleVariable ) | ( 'var' '(' (lv_variable_3= ruleVariable ) ')' ) )
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:505:1: ( (lv_variable_0= ruleVariable ) | ( 'var' '(' (lv_variable_3= ruleVariable ) ')' ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            else if ( (LA6_0==18) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("505:1: ( (lv_variable_0= ruleVariable ) | ( 'var' '(' (lv_variable_3= ruleVariable ) ')' ) )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:505:2: (lv_variable_0= ruleVariable )
                    {
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:505:2: (lv_variable_0= ruleVariable )
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:508:6: lv_variable_0= ruleVariable
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVariableReferenceAccess().getVariableVariableParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleVariable_in_ruleVariableReference1215);
                    lv_variable_0=ruleVariable();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getVariableReferenceRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "variable", lv_variable_0, "Variable", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;
                case 2 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:527:6: ( 'var' '(' (lv_variable_3= ruleVariable ) ')' )
                    {
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:527:6: ( 'var' '(' (lv_variable_3= ruleVariable ) ')' )
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:527:7: 'var' '(' (lv_variable_3= ruleVariable ) ')'
                    {
                    match(input,18,FOLLOW_18_in_ruleVariableReference1235); 

                            createLeafNode(grammarAccess.getVariableReferenceAccess().getVarKeyword_1_0(), null); 
                        
                    match(input,16,FOLLOW_16_in_ruleVariableReference1244); 

                            createLeafNode(grammarAccess.getVariableReferenceAccess().getLeftParenthesisKeyword_1_1(), null); 
                        
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:535:1: (lv_variable_3= ruleVariable )
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:538:6: lv_variable_3= ruleVariable
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVariableReferenceAccess().getVariableVariableParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleVariable_in_ruleVariableReference1278);
                    lv_variable_3=ruleVariable();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getVariableReferenceRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "variable", lv_variable_3, "Variable", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }

                    match(input,17,FOLLOW_17_in_ruleVariableReference1291); 

                            createLeafNode(grammarAccess.getVariableReferenceAccess().getRightParenthesisKeyword_1_3(), null); 
                        

                    }


                    }
                    break;

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
    // $ANTLR end ruleVariableReference


    // $ANTLR start entryRuleVariable
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:567:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:567:50: (iv_ruleVariable= ruleVariable EOF )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:568:2: iv_ruleVariable= ruleVariable EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVariableRule(), currentNode); 
            pushFollow(FOLLOW_ruleVariable_in_entryRuleVariable1325);
            iv_ruleVariable=ruleVariable();
            _fsp--;

             current =iv_ruleVariable; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariable1335); 

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
    // $ANTLR end entryRuleVariable


    // $ANTLR start ruleVariable
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:575:1: ruleVariable returns [EObject current=null] : (lv_identifier_0= RULE_ID ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        Token lv_identifier_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:580:6: ( (lv_identifier_0= RULE_ID ) )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:581:1: (lv_identifier_0= RULE_ID )
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:581:1: (lv_identifier_0= RULE_ID )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:583:6: lv_identifier_0= RULE_ID
            {
            lv_identifier_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariable1381); 

            		createLeafNode(grammarAccess.getVariableAccess().getIdentifierIDTerminalRuleCall_0(), "identifier"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVariableRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "identifier", lv_identifier_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
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
    // $ANTLR end ruleVariable


    // $ANTLR start entryRuleTimeConstant
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:608:1: entryRuleTimeConstant returns [EObject current=null] : iv_ruleTimeConstant= ruleTimeConstant EOF ;
    public final EObject entryRuleTimeConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeConstant = null;


        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:608:54: (iv_ruleTimeConstant= ruleTimeConstant EOF )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:609:2: iv_ruleTimeConstant= ruleTimeConstant EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTimeConstantRule(), currentNode); 
            pushFollow(FOLLOW_ruleTimeConstant_in_entryRuleTimeConstant1421);
            iv_ruleTimeConstant=ruleTimeConstant();
            _fsp--;

             current =iv_ruleTimeConstant; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTimeConstant1431); 

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
    // $ANTLR end entryRuleTimeConstant


    // $ANTLR start ruleTimeConstant
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:616:1: ruleTimeConstant returns [EObject current=null] : ( (lv_value_0= RULE_INT ) (lv_unit_1= ruleTimeUnit )? ) ;
    public final EObject ruleTimeConstant() throws RecognitionException {
        EObject current = null;

        Token lv_value_0=null;
        Enumerator lv_unit_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:621:6: ( ( (lv_value_0= RULE_INT ) (lv_unit_1= ruleTimeUnit )? ) )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:622:1: ( (lv_value_0= RULE_INT ) (lv_unit_1= ruleTimeUnit )? )
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:622:1: ( (lv_value_0= RULE_INT ) (lv_unit_1= ruleTimeUnit )? )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:622:2: (lv_value_0= RULE_INT ) (lv_unit_1= ruleTimeUnit )?
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:622:2: (lv_value_0= RULE_INT )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:624:6: lv_value_0= RULE_INT
            {
            lv_value_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTimeConstant1478); 

            		createLeafNode(grammarAccess.getTimeConstantAccess().getValueINTTerminalRuleCall_0_0(), "value"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTimeConstantRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "value", lv_value_0, "INT", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:642:2: (lv_unit_1= ruleTimeUnit )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=28 && LA7_0<=30)) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:645:6: lv_unit_1= ruleTimeUnit
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getTimeConstantAccess().getUnitTimeUnitEnumRuleCall_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTimeUnit_in_ruleTimeConstant1520);
                    lv_unit_1=ruleTimeUnit();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTimeConstantRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "unit", lv_unit_1, "TimeUnit", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

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
    // $ANTLR end ruleTimeConstant


    // $ANTLR start entryRuleStatement
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:670:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:670:51: (iv_ruleStatement= ruleStatement EOF )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:671:2: iv_ruleStatement= ruleStatement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStatementRule(), currentNode); 
            pushFollow(FOLLOW_ruleStatement_in_entryRuleStatement1558);
            iv_ruleStatement=ruleStatement();
            _fsp--;

             current =iv_ruleStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatement1568); 

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
    // $ANTLR end entryRuleStatement


    // $ANTLR start ruleStatement
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:678:1: ruleStatement returns [EObject current=null] : ( (this_VariableAssignment_0= ruleVariableAssignment | this_EventRaising_1= ruleEventRaising | this_ProcedureCall_2= ruleProcedureCall ) ';' ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_VariableAssignment_0 = null;

        EObject this_EventRaising_1 = null;

        EObject this_ProcedureCall_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:683:6: ( ( (this_VariableAssignment_0= ruleVariableAssignment | this_EventRaising_1= ruleEventRaising | this_ProcedureCall_2= ruleProcedureCall ) ';' ) )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:684:1: ( (this_VariableAssignment_0= ruleVariableAssignment | this_EventRaising_1= ruleEventRaising | this_ProcedureCall_2= ruleProcedureCall ) ';' )
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:684:1: ( (this_VariableAssignment_0= ruleVariableAssignment | this_EventRaising_1= ruleEventRaising | this_ProcedureCall_2= ruleProcedureCall ) ';' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:684:2: (this_VariableAssignment_0= ruleVariableAssignment | this_EventRaising_1= ruleEventRaising | this_ProcedureCall_2= ruleProcedureCall ) ';'
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:684:2: (this_VariableAssignment_0= ruleVariableAssignment | this_EventRaising_1= ruleEventRaising | this_ProcedureCall_2= ruleProcedureCall )
            int alt8=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA8_1 = input.LA(2);

                if ( ((LA8_1>=31 && LA8_1<=41)) ) {
                    alt8=1;
                }
                else if ( (LA8_1==16) ) {
                    alt8=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("684:2: (this_VariableAssignment_0= ruleVariableAssignment | this_EventRaising_1= ruleEventRaising | this_ProcedureCall_2= ruleProcedureCall )", 8, 1, input);

                    throw nvae;
                }
                }
                break;
            case 18:
                {
                alt8=1;
                }
                break;
            case 20:
                {
                alt8=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("684:2: (this_VariableAssignment_0= ruleVariableAssignment | this_EventRaising_1= ruleEventRaising | this_ProcedureCall_2= ruleProcedureCall )", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:685:5: this_VariableAssignment_0= ruleVariableAssignment
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStatementAccess().getVariableAssignmentParserRuleCall_0_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVariableAssignment_in_ruleStatement1616);
                    this_VariableAssignment_0=ruleVariableAssignment();
                    _fsp--;

                     
                            current = this_VariableAssignment_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:695:5: this_EventRaising_1= ruleEventRaising
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStatementAccess().getEventRaisingParserRuleCall_0_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEventRaising_in_ruleStatement1643);
                    this_EventRaising_1=ruleEventRaising();
                    _fsp--;

                     
                            current = this_EventRaising_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:705:5: this_ProcedureCall_2= ruleProcedureCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStatementAccess().getProcedureCallParserRuleCall_0_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleProcedureCall_in_ruleStatement1670);
                    this_ProcedureCall_2=ruleProcedureCall();
                    _fsp--;

                     
                            current = this_ProcedureCall_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }

            match(input,19,FOLLOW_19_in_ruleStatement1679); 

                    createLeafNode(grammarAccess.getStatementAccess().getSemicolonKeyword_1(), null); 
                

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
    // $ANTLR end ruleStatement


    // $ANTLR start entryRuleVariableAssignment
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:724:1: entryRuleVariableAssignment returns [EObject current=null] : iv_ruleVariableAssignment= ruleVariableAssignment EOF ;
    public final EObject entryRuleVariableAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableAssignment = null;


        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:724:60: (iv_ruleVariableAssignment= ruleVariableAssignment EOF )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:725:2: iv_ruleVariableAssignment= ruleVariableAssignment EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVariableAssignmentRule(), currentNode); 
            pushFollow(FOLLOW_ruleVariableAssignment_in_entryRuleVariableAssignment1712);
            iv_ruleVariableAssignment=ruleVariableAssignment();
            _fsp--;

             current =iv_ruleVariableAssignment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableAssignment1722); 

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
    // $ANTLR end entryRuleVariableAssignment


    // $ANTLR start ruleVariableAssignment
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:732:1: ruleVariableAssignment returns [EObject current=null] : ( (lv_variableReference_0= ruleVariableReference ) (lv_operator_1= ruleAssignmentOperator ) (lv_value_2= ruleConditionalExpression ) ) ;
    public final EObject ruleVariableAssignment() throws RecognitionException {
        EObject current = null;

        EObject lv_variableReference_0 = null;

        Enumerator lv_operator_1 = null;

        EObject lv_value_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:737:6: ( ( (lv_variableReference_0= ruleVariableReference ) (lv_operator_1= ruleAssignmentOperator ) (lv_value_2= ruleConditionalExpression ) ) )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:738:1: ( (lv_variableReference_0= ruleVariableReference ) (lv_operator_1= ruleAssignmentOperator ) (lv_value_2= ruleConditionalExpression ) )
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:738:1: ( (lv_variableReference_0= ruleVariableReference ) (lv_operator_1= ruleAssignmentOperator ) (lv_value_2= ruleConditionalExpression ) )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:738:2: (lv_variableReference_0= ruleVariableReference ) (lv_operator_1= ruleAssignmentOperator ) (lv_value_2= ruleConditionalExpression )
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:738:2: (lv_variableReference_0= ruleVariableReference )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:741:6: lv_variableReference_0= ruleVariableReference
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVariableAssignmentAccess().getVariableReferenceVariableReferenceParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleVariableReference_in_ruleVariableAssignment1781);
            lv_variableReference_0=ruleVariableReference();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVariableAssignmentRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "variableReference", lv_variableReference_0, "VariableReference", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:759:2: (lv_operator_1= ruleAssignmentOperator )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:762:6: lv_operator_1= ruleAssignmentOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVariableAssignmentAccess().getOperatorAssignmentOperatorEnumRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAssignmentOperator_in_ruleVariableAssignment1819);
            lv_operator_1=ruleAssignmentOperator();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVariableAssignmentRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "operator", lv_operator_1, "AssignmentOperator", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:780:2: (lv_value_2= ruleConditionalExpression )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:783:6: lv_value_2= ruleConditionalExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVariableAssignmentAccess().getValueConditionalExpressionParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleConditionalExpression_in_ruleVariableAssignment1857);
            lv_value_2=ruleConditionalExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVariableAssignmentRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "value", lv_value_2, "ConditionalExpression", currentNode);
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
    // $ANTLR end ruleVariableAssignment


    // $ANTLR start entryRuleProcedureCall
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:808:1: entryRuleProcedureCall returns [EObject current=null] : iv_ruleProcedureCall= ruleProcedureCall EOF ;
    public final EObject entryRuleProcedureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcedureCall = null;


        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:808:55: (iv_ruleProcedureCall= ruleProcedureCall EOF )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:809:2: iv_ruleProcedureCall= ruleProcedureCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.getProcedureCallRule(), currentNode); 
            pushFollow(FOLLOW_ruleProcedureCall_in_entryRuleProcedureCall1894);
            iv_ruleProcedureCall=ruleProcedureCall();
            _fsp--;

             current =iv_ruleProcedureCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleProcedureCall1904); 

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
    // $ANTLR end entryRuleProcedureCall


    // $ANTLR start ruleProcedureCall
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:816:1: ruleProcedureCall returns [EObject current=null] : ( (lv_procedure_0= ruleProcedure ) '(' ')' ) ;
    public final EObject ruleProcedureCall() throws RecognitionException {
        EObject current = null;

        EObject lv_procedure_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:821:6: ( ( (lv_procedure_0= ruleProcedure ) '(' ')' ) )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:822:1: ( (lv_procedure_0= ruleProcedure ) '(' ')' )
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:822:1: ( (lv_procedure_0= ruleProcedure ) '(' ')' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:822:2: (lv_procedure_0= ruleProcedure ) '(' ')'
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:822:2: (lv_procedure_0= ruleProcedure )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:825:6: lv_procedure_0= ruleProcedure
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getProcedureCallAccess().getProcedureProcedureParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleProcedure_in_ruleProcedureCall1963);
            lv_procedure_0=ruleProcedure();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getProcedureCallRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "procedure", lv_procedure_0, "Procedure", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            match(input,16,FOLLOW_16_in_ruleProcedureCall1976); 

                    createLeafNode(grammarAccess.getProcedureCallAccess().getLeftParenthesisKeyword_1(), null); 
                
            match(input,17,FOLLOW_17_in_ruleProcedureCall1985); 

                    createLeafNode(grammarAccess.getProcedureCallAccess().getRightParenthesisKeyword_2(), null); 
                

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
    // $ANTLR end ruleProcedureCall


    // $ANTLR start entryRuleProcedure
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:858:1: entryRuleProcedure returns [EObject current=null] : iv_ruleProcedure= ruleProcedure EOF ;
    public final EObject entryRuleProcedure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcedure = null;


        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:858:51: (iv_ruleProcedure= ruleProcedure EOF )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:859:2: iv_ruleProcedure= ruleProcedure EOF
            {
             currentNode = createCompositeNode(grammarAccess.getProcedureRule(), currentNode); 
            pushFollow(FOLLOW_ruleProcedure_in_entryRuleProcedure2018);
            iv_ruleProcedure=ruleProcedure();
            _fsp--;

             current =iv_ruleProcedure; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleProcedure2028); 

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
    // $ANTLR end entryRuleProcedure


    // $ANTLR start ruleProcedure
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:866:1: ruleProcedure returns [EObject current=null] : (lv_identifier_0= RULE_ID ) ;
    public final EObject ruleProcedure() throws RecognitionException {
        EObject current = null;

        Token lv_identifier_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:871:6: ( (lv_identifier_0= RULE_ID ) )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:872:1: (lv_identifier_0= RULE_ID )
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:872:1: (lv_identifier_0= RULE_ID )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:874:6: lv_identifier_0= RULE_ID
            {
            lv_identifier_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleProcedure2074); 

            		createLeafNode(grammarAccess.getProcedureAccess().getIdentifierIDTerminalRuleCall_0(), "identifier"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getProcedureRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "identifier", lv_identifier_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
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
    // $ANTLR end ruleProcedure


    // $ANTLR start entryRuleEventRaising
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:899:1: entryRuleEventRaising returns [EObject current=null] : iv_ruleEventRaising= ruleEventRaising EOF ;
    public final EObject entryRuleEventRaising() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventRaising = null;


        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:899:54: (iv_ruleEventRaising= ruleEventRaising EOF )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:900:2: iv_ruleEventRaising= ruleEventRaising EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEventRaisingRule(), currentNode); 
            pushFollow(FOLLOW_ruleEventRaising_in_entryRuleEventRaising2114);
            iv_ruleEventRaising=ruleEventRaising();
            _fsp--;

             current =iv_ruleEventRaising; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEventRaising2124); 

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
    // $ANTLR end entryRuleEventRaising


    // $ANTLR start ruleEventRaising
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:907:1: ruleEventRaising returns [EObject current=null] : ( 'raise' '(' (lv_event_2= ruleSignalEvent ) ')' ) ;
    public final EObject ruleEventRaising() throws RecognitionException {
        EObject current = null;

        EObject lv_event_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:912:6: ( ( 'raise' '(' (lv_event_2= ruleSignalEvent ) ')' ) )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:913:1: ( 'raise' '(' (lv_event_2= ruleSignalEvent ) ')' )
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:913:1: ( 'raise' '(' (lv_event_2= ruleSignalEvent ) ')' )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:913:2: 'raise' '(' (lv_event_2= ruleSignalEvent ) ')'
            {
            match(input,20,FOLLOW_20_in_ruleEventRaising2158); 

                    createLeafNode(grammarAccess.getEventRaisingAccess().getRaiseKeyword_0(), null); 
                
            match(input,16,FOLLOW_16_in_ruleEventRaising2167); 

                    createLeafNode(grammarAccess.getEventRaisingAccess().getLeftParenthesisKeyword_1(), null); 
                
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:921:1: (lv_event_2= ruleSignalEvent )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:924:6: lv_event_2= ruleSignalEvent
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEventRaisingAccess().getEventSignalEventParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleSignalEvent_in_ruleEventRaising2201);
            lv_event_2=ruleSignalEvent();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEventRaisingRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "event", lv_event_2, "SignalEvent", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            match(input,17,FOLLOW_17_in_ruleEventRaising2214); 

                    createLeafNode(grammarAccess.getEventRaisingAccess().getRightParenthesisKeyword_3(), null); 
                

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
    // $ANTLR end ruleEventRaising


    // $ANTLR start entryRuleBooleanOrExpression
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:953:1: entryRuleBooleanOrExpression returns [EObject current=null] : iv_ruleBooleanOrExpression= ruleBooleanOrExpression EOF ;
    public final EObject entryRuleBooleanOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanOrExpression = null;


        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:953:61: (iv_ruleBooleanOrExpression= ruleBooleanOrExpression EOF )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:954:2: iv_ruleBooleanOrExpression= ruleBooleanOrExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBooleanOrExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleBooleanOrExpression_in_entryRuleBooleanOrExpression2247);
            iv_ruleBooleanOrExpression=ruleBooleanOrExpression();
            _fsp--;

             current =iv_ruleBooleanOrExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanOrExpression2257); 

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
    // $ANTLR end entryRuleBooleanOrExpression


    // $ANTLR start ruleBooleanOrExpression
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:961:1: ruleBooleanOrExpression returns [EObject current=null] : ( (lv_operand1_0= ruleBooleanAndExpression ) ( '||' (lv_operand2_2= ruleBooleanAndExpression ) )* ) ;
    public final EObject ruleBooleanOrExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_operand1_0 = null;

        EObject lv_operand2_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:966:6: ( ( (lv_operand1_0= ruleBooleanAndExpression ) ( '||' (lv_operand2_2= ruleBooleanAndExpression ) )* ) )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:967:1: ( (lv_operand1_0= ruleBooleanAndExpression ) ( '||' (lv_operand2_2= ruleBooleanAndExpression ) )* )
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:967:1: ( (lv_operand1_0= ruleBooleanAndExpression ) ( '||' (lv_operand2_2= ruleBooleanAndExpression ) )* )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:967:2: (lv_operand1_0= ruleBooleanAndExpression ) ( '||' (lv_operand2_2= ruleBooleanAndExpression ) )*
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:967:2: (lv_operand1_0= ruleBooleanAndExpression )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:970:6: lv_operand1_0= ruleBooleanAndExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getBooleanOrExpressionAccess().getOperand1BooleanAndExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBooleanAndExpression_in_ruleBooleanOrExpression2316);
            lv_operand1_0=ruleBooleanAndExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getBooleanOrExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "operand1", lv_operand1_0, "BooleanAndExpression", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:988:2: ( '||' (lv_operand2_2= ruleBooleanAndExpression ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==21) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:988:3: '||' (lv_operand2_2= ruleBooleanAndExpression )
            	    {
            	    match(input,21,FOLLOW_21_in_ruleBooleanOrExpression2330); 

            	            createLeafNode(grammarAccess.getBooleanOrExpressionAccess().getVerticalLineVerticalLineKeyword_1_0(), null); 
            	        
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:992:1: (lv_operand2_2= ruleBooleanAndExpression )
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:995:6: lv_operand2_2= ruleBooleanAndExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getBooleanOrExpressionAccess().getOperand2BooleanAndExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleBooleanAndExpression_in_ruleBooleanOrExpression2364);
            	    lv_operand2_2=ruleBooleanAndExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getBooleanOrExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "operand2", lv_operand2_2, "BooleanAndExpression", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


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
    // $ANTLR end ruleBooleanOrExpression


    // $ANTLR start entryRuleBooleanAndExpression
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1020:1: entryRuleBooleanAndExpression returns [EObject current=null] : iv_ruleBooleanAndExpression= ruleBooleanAndExpression EOF ;
    public final EObject entryRuleBooleanAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanAndExpression = null;


        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1020:62: (iv_ruleBooleanAndExpression= ruleBooleanAndExpression EOF )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1021:2: iv_ruleBooleanAndExpression= ruleBooleanAndExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBooleanAndExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleBooleanAndExpression_in_entryRuleBooleanAndExpression2403);
            iv_ruleBooleanAndExpression=ruleBooleanAndExpression();
            _fsp--;

             current =iv_ruleBooleanAndExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanAndExpression2413); 

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
    // $ANTLR end entryRuleBooleanAndExpression


    // $ANTLR start ruleBooleanAndExpression
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1028:1: ruleBooleanAndExpression returns [EObject current=null] : ( (lv_operand1_0= ruleBitwiseXorExpression ) ( '&&' (lv_operand2_2= ruleBitwiseXorExpression ) )* ) ;
    public final EObject ruleBooleanAndExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_operand1_0 = null;

        EObject lv_operand2_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1033:6: ( ( (lv_operand1_0= ruleBitwiseXorExpression ) ( '&&' (lv_operand2_2= ruleBitwiseXorExpression ) )* ) )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1034:1: ( (lv_operand1_0= ruleBitwiseXorExpression ) ( '&&' (lv_operand2_2= ruleBitwiseXorExpression ) )* )
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1034:1: ( (lv_operand1_0= ruleBitwiseXorExpression ) ( '&&' (lv_operand2_2= ruleBitwiseXorExpression ) )* )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1034:2: (lv_operand1_0= ruleBitwiseXorExpression ) ( '&&' (lv_operand2_2= ruleBitwiseXorExpression ) )*
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1034:2: (lv_operand1_0= ruleBitwiseXorExpression )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1037:6: lv_operand1_0= ruleBitwiseXorExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getBooleanAndExpressionAccess().getOperand1BitwiseXorExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBitwiseXorExpression_in_ruleBooleanAndExpression2472);
            lv_operand1_0=ruleBitwiseXorExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getBooleanAndExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "operand1", lv_operand1_0, "BitwiseXorExpression", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1055:2: ( '&&' (lv_operand2_2= ruleBitwiseXorExpression ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==22) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1055:3: '&&' (lv_operand2_2= ruleBitwiseXorExpression )
            	    {
            	    match(input,22,FOLLOW_22_in_ruleBooleanAndExpression2486); 

            	            createLeafNode(grammarAccess.getBooleanAndExpressionAccess().getAmpersandAmpersandKeyword_1_0(), null); 
            	        
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1059:1: (lv_operand2_2= ruleBitwiseXorExpression )
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1062:6: lv_operand2_2= ruleBitwiseXorExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getBooleanAndExpressionAccess().getOperand2BitwiseXorExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleBitwiseXorExpression_in_ruleBooleanAndExpression2520);
            	    lv_operand2_2=ruleBitwiseXorExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getBooleanAndExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "operand2", lv_operand2_2, "BitwiseXorExpression", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


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
    // $ANTLR end ruleBooleanAndExpression


    // $ANTLR start entryRuleBitwiseXorExpression
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1087:1: entryRuleBitwiseXorExpression returns [EObject current=null] : iv_ruleBitwiseXorExpression= ruleBitwiseXorExpression EOF ;
    public final EObject entryRuleBitwiseXorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitwiseXorExpression = null;


        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1087:62: (iv_ruleBitwiseXorExpression= ruleBitwiseXorExpression EOF )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1088:2: iv_ruleBitwiseXorExpression= ruleBitwiseXorExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBitwiseXorExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleBitwiseXorExpression_in_entryRuleBitwiseXorExpression2559);
            iv_ruleBitwiseXorExpression=ruleBitwiseXorExpression();
            _fsp--;

             current =iv_ruleBitwiseXorExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBitwiseXorExpression2569); 

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
    // $ANTLR end entryRuleBitwiseXorExpression


    // $ANTLR start ruleBitwiseXorExpression
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1095:1: ruleBitwiseXorExpression returns [EObject current=null] : ( (lv_operand1_0= ruleBitwiseOrExpression ) ( '^' (lv_operand2_2= ruleBitwiseOrExpression ) )* ) ;
    public final EObject ruleBitwiseXorExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_operand1_0 = null;

        EObject lv_operand2_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1100:6: ( ( (lv_operand1_0= ruleBitwiseOrExpression ) ( '^' (lv_operand2_2= ruleBitwiseOrExpression ) )* ) )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1101:1: ( (lv_operand1_0= ruleBitwiseOrExpression ) ( '^' (lv_operand2_2= ruleBitwiseOrExpression ) )* )
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1101:1: ( (lv_operand1_0= ruleBitwiseOrExpression ) ( '^' (lv_operand2_2= ruleBitwiseOrExpression ) )* )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1101:2: (lv_operand1_0= ruleBitwiseOrExpression ) ( '^' (lv_operand2_2= ruleBitwiseOrExpression ) )*
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1101:2: (lv_operand1_0= ruleBitwiseOrExpression )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1104:6: lv_operand1_0= ruleBitwiseOrExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getBitwiseXorExpressionAccess().getOperand1BitwiseOrExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBitwiseOrExpression_in_ruleBitwiseXorExpression2628);
            lv_operand1_0=ruleBitwiseOrExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getBitwiseXorExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "operand1", lv_operand1_0, "BitwiseOrExpression", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1122:2: ( '^' (lv_operand2_2= ruleBitwiseOrExpression ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==23) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1122:3: '^' (lv_operand2_2= ruleBitwiseOrExpression )
            	    {
            	    match(input,23,FOLLOW_23_in_ruleBitwiseXorExpression2642); 

            	            createLeafNode(grammarAccess.getBitwiseXorExpressionAccess().getCircumflexAccentKeyword_1_0(), null); 
            	        
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1126:1: (lv_operand2_2= ruleBitwiseOrExpression )
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1129:6: lv_operand2_2= ruleBitwiseOrExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getBitwiseXorExpressionAccess().getOperand2BitwiseOrExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleBitwiseOrExpression_in_ruleBitwiseXorExpression2676);
            	    lv_operand2_2=ruleBitwiseOrExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getBitwiseXorExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "operand2", lv_operand2_2, "BitwiseOrExpression", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


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
    // $ANTLR end ruleBitwiseXorExpression


    // $ANTLR start entryRuleBitwiseOrExpression
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1154:1: entryRuleBitwiseOrExpression returns [EObject current=null] : iv_ruleBitwiseOrExpression= ruleBitwiseOrExpression EOF ;
    public final EObject entryRuleBitwiseOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitwiseOrExpression = null;


        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1154:61: (iv_ruleBitwiseOrExpression= ruleBitwiseOrExpression EOF )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1155:2: iv_ruleBitwiseOrExpression= ruleBitwiseOrExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBitwiseOrExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleBitwiseOrExpression_in_entryRuleBitwiseOrExpression2715);
            iv_ruleBitwiseOrExpression=ruleBitwiseOrExpression();
            _fsp--;

             current =iv_ruleBitwiseOrExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBitwiseOrExpression2725); 

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
    // $ANTLR end entryRuleBitwiseOrExpression


    // $ANTLR start ruleBitwiseOrExpression
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1162:1: ruleBitwiseOrExpression returns [EObject current=null] : ( (lv_operand1_0= ruleBitwiseAndExpression ) ( '|' (lv_operand2_2= ruleBitwiseAndExpression ) )* ) ;
    public final EObject ruleBitwiseOrExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_operand1_0 = null;

        EObject lv_operand2_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1167:6: ( ( (lv_operand1_0= ruleBitwiseAndExpression ) ( '|' (lv_operand2_2= ruleBitwiseAndExpression ) )* ) )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1168:1: ( (lv_operand1_0= ruleBitwiseAndExpression ) ( '|' (lv_operand2_2= ruleBitwiseAndExpression ) )* )
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1168:1: ( (lv_operand1_0= ruleBitwiseAndExpression ) ( '|' (lv_operand2_2= ruleBitwiseAndExpression ) )* )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1168:2: (lv_operand1_0= ruleBitwiseAndExpression ) ( '|' (lv_operand2_2= ruleBitwiseAndExpression ) )*
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1168:2: (lv_operand1_0= ruleBitwiseAndExpression )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1171:6: lv_operand1_0= ruleBitwiseAndExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getBitwiseOrExpressionAccess().getOperand1BitwiseAndExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBitwiseAndExpression_in_ruleBitwiseOrExpression2784);
            lv_operand1_0=ruleBitwiseAndExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getBitwiseOrExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "operand1", lv_operand1_0, "BitwiseAndExpression", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1189:2: ( '|' (lv_operand2_2= ruleBitwiseAndExpression ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==24) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1189:3: '|' (lv_operand2_2= ruleBitwiseAndExpression )
            	    {
            	    match(input,24,FOLLOW_24_in_ruleBitwiseOrExpression2798); 

            	            createLeafNode(grammarAccess.getBitwiseOrExpressionAccess().getVerticalLineKeyword_1_0(), null); 
            	        
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1193:1: (lv_operand2_2= ruleBitwiseAndExpression )
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1196:6: lv_operand2_2= ruleBitwiseAndExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getBitwiseOrExpressionAccess().getOperand2BitwiseAndExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleBitwiseAndExpression_in_ruleBitwiseOrExpression2832);
            	    lv_operand2_2=ruleBitwiseAndExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getBitwiseOrExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "operand2", lv_operand2_2, "BitwiseAndExpression", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


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
    // $ANTLR end ruleBitwiseOrExpression


    // $ANTLR start entryRuleBitwiseAndExpression
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1221:1: entryRuleBitwiseAndExpression returns [EObject current=null] : iv_ruleBitwiseAndExpression= ruleBitwiseAndExpression EOF ;
    public final EObject entryRuleBitwiseAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitwiseAndExpression = null;


        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1221:62: (iv_ruleBitwiseAndExpression= ruleBitwiseAndExpression EOF )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1222:2: iv_ruleBitwiseAndExpression= ruleBitwiseAndExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBitwiseAndExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleBitwiseAndExpression_in_entryRuleBitwiseAndExpression2871);
            iv_ruleBitwiseAndExpression=ruleBitwiseAndExpression();
            _fsp--;

             current =iv_ruleBitwiseAndExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBitwiseAndExpression2881); 

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
    // $ANTLR end entryRuleBitwiseAndExpression


    // $ANTLR start ruleBitwiseAndExpression
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1229:1: ruleBitwiseAndExpression returns [EObject current=null] : ( (lv_operand1_0= ruleEqualityExpression ) ( '&' (lv_operand2_2= ruleEqualityExpression ) )* ) ;
    public final EObject ruleBitwiseAndExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_operand1_0 = null;

        EObject lv_operand2_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1234:6: ( ( (lv_operand1_0= ruleEqualityExpression ) ( '&' (lv_operand2_2= ruleEqualityExpression ) )* ) )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1235:1: ( (lv_operand1_0= ruleEqualityExpression ) ( '&' (lv_operand2_2= ruleEqualityExpression ) )* )
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1235:1: ( (lv_operand1_0= ruleEqualityExpression ) ( '&' (lv_operand2_2= ruleEqualityExpression ) )* )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1235:2: (lv_operand1_0= ruleEqualityExpression ) ( '&' (lv_operand2_2= ruleEqualityExpression ) )*
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1235:2: (lv_operand1_0= ruleEqualityExpression )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1238:6: lv_operand1_0= ruleEqualityExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getBitwiseAndExpressionAccess().getOperand1EqualityExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleEqualityExpression_in_ruleBitwiseAndExpression2940);
            lv_operand1_0=ruleEqualityExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getBitwiseAndExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "operand1", lv_operand1_0, "EqualityExpression", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1256:2: ( '&' (lv_operand2_2= ruleEqualityExpression ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==25) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1256:3: '&' (lv_operand2_2= ruleEqualityExpression )
            	    {
            	    match(input,25,FOLLOW_25_in_ruleBitwiseAndExpression2954); 

            	            createLeafNode(grammarAccess.getBitwiseAndExpressionAccess().getAmpersandKeyword_1_0(), null); 
            	        
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1260:1: (lv_operand2_2= ruleEqualityExpression )
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1263:6: lv_operand2_2= ruleEqualityExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getBitwiseAndExpressionAccess().getOperand2EqualityExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEqualityExpression_in_ruleBitwiseAndExpression2988);
            	    lv_operand2_2=ruleEqualityExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getBitwiseAndExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "operand2", lv_operand2_2, "EqualityExpression", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


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
    // $ANTLR end ruleBitwiseAndExpression


    // $ANTLR start entryRuleEqualityExpression
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1288:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1288:60: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1289:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEqualityExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression3027);
            iv_ruleEqualityExpression=ruleEqualityExpression();
            _fsp--;

             current =iv_ruleEqualityExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpression3037); 

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
    // $ANTLR end entryRuleEqualityExpression


    // $ANTLR start ruleEqualityExpression
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1296:1: ruleEqualityExpression returns [EObject current=null] : ( (lv_operand1_0= ruleRelationalExpression ) ( (lv_operator_1= ruleEqualityOperator ) (lv_operand2_2= ruleRelationalExpression ) )* ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_operand1_0 = null;

        Enumerator lv_operator_1 = null;

        EObject lv_operand2_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1301:6: ( ( (lv_operand1_0= ruleRelationalExpression ) ( (lv_operator_1= ruleEqualityOperator ) (lv_operand2_2= ruleRelationalExpression ) )* ) )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1302:1: ( (lv_operand1_0= ruleRelationalExpression ) ( (lv_operator_1= ruleEqualityOperator ) (lv_operand2_2= ruleRelationalExpression ) )* )
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1302:1: ( (lv_operand1_0= ruleRelationalExpression ) ( (lv_operator_1= ruleEqualityOperator ) (lv_operand2_2= ruleRelationalExpression ) )* )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1302:2: (lv_operand1_0= ruleRelationalExpression ) ( (lv_operator_1= ruleEqualityOperator ) (lv_operand2_2= ruleRelationalExpression ) )*
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1302:2: (lv_operand1_0= ruleRelationalExpression )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1305:6: lv_operand1_0= ruleRelationalExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEqualityExpressionAccess().getOperand1RelationalExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression3096);
            lv_operand1_0=ruleRelationalExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEqualityExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "operand1", lv_operand1_0, "RelationalExpression", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1323:2: ( (lv_operator_1= ruleEqualityOperator ) (lv_operand2_2= ruleRelationalExpression ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>=42 && LA14_0<=43)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1323:3: (lv_operator_1= ruleEqualityOperator ) (lv_operand2_2= ruleRelationalExpression )
            	    {
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1323:3: (lv_operator_1= ruleEqualityOperator )
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1326:6: lv_operator_1= ruleEqualityOperator
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEqualityExpressionAccess().getOperatorEqualityOperatorEnumRuleCall_1_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEqualityOperator_in_ruleEqualityExpression3135);
            	    lv_operator_1=ruleEqualityOperator();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEqualityExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "operator", lv_operator_1, "EqualityOperator", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }

            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1344:2: (lv_operand2_2= ruleRelationalExpression )
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1347:6: lv_operand2_2= ruleRelationalExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEqualityExpressionAccess().getOperand2RelationalExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression3173);
            	    lv_operand2_2=ruleRelationalExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEqualityExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "operand2", lv_operand2_2, "RelationalExpression", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


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
    // $ANTLR end ruleEqualityExpression


    // $ANTLR start entryRuleRelationalExpression
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1372:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1372:62: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1373:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRelationalExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression3212);
            iv_ruleRelationalExpression=ruleRelationalExpression();
            _fsp--;

             current =iv_ruleRelationalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpression3222); 

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
    // $ANTLR end entryRuleRelationalExpression


    // $ANTLR start ruleRelationalExpression
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1380:1: ruleRelationalExpression returns [EObject current=null] : ( (lv_operand1_0= ruleShiftExpression ) ( (lv_operator_1= ruleRelationalOperator ) (lv_operand2_2= ruleShiftExpression ) )* ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_operand1_0 = null;

        Enumerator lv_operator_1 = null;

        EObject lv_operand2_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1385:6: ( ( (lv_operand1_0= ruleShiftExpression ) ( (lv_operator_1= ruleRelationalOperator ) (lv_operand2_2= ruleShiftExpression ) )* ) )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1386:1: ( (lv_operand1_0= ruleShiftExpression ) ( (lv_operator_1= ruleRelationalOperator ) (lv_operand2_2= ruleShiftExpression ) )* )
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1386:1: ( (lv_operand1_0= ruleShiftExpression ) ( (lv_operator_1= ruleRelationalOperator ) (lv_operand2_2= ruleShiftExpression ) )* )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1386:2: (lv_operand1_0= ruleShiftExpression ) ( (lv_operator_1= ruleRelationalOperator ) (lv_operand2_2= ruleShiftExpression ) )*
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1386:2: (lv_operand1_0= ruleShiftExpression )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1389:6: lv_operand1_0= ruleShiftExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getOperand1ShiftExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleShiftExpression_in_ruleRelationalExpression3281);
            lv_operand1_0=ruleShiftExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getRelationalExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "operand1", lv_operand1_0, "ShiftExpression", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1407:2: ( (lv_operator_1= ruleRelationalOperator ) (lv_operand2_2= ruleShiftExpression ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=44 && LA15_0<=47)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1407:3: (lv_operator_1= ruleRelationalOperator ) (lv_operand2_2= ruleShiftExpression )
            	    {
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1407:3: (lv_operator_1= ruleRelationalOperator )
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1410:6: lv_operator_1= ruleRelationalOperator
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getOperatorRelationalOperatorEnumRuleCall_1_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleRelationalOperator_in_ruleRelationalExpression3320);
            	    lv_operator_1=ruleRelationalOperator();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getRelationalExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "operator", lv_operator_1, "RelationalOperator", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }

            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1428:2: (lv_operand2_2= ruleShiftExpression )
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1431:6: lv_operand2_2= ruleShiftExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getOperand2ShiftExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleShiftExpression_in_ruleRelationalExpression3358);
            	    lv_operand2_2=ruleShiftExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getRelationalExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "operand2", lv_operand2_2, "ShiftExpression", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


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
    // $ANTLR end ruleRelationalExpression


    // $ANTLR start entryRuleConditionalExpression
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1456:1: entryRuleConditionalExpression returns [EObject current=null] : iv_ruleConditionalExpression= ruleConditionalExpression EOF ;
    public final EObject entryRuleConditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpression = null;


        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1456:63: (iv_ruleConditionalExpression= ruleConditionalExpression EOF )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1457:2: iv_ruleConditionalExpression= ruleConditionalExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConditionalExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleConditionalExpression_in_entryRuleConditionalExpression3397);
            iv_ruleConditionalExpression=ruleConditionalExpression();
            _fsp--;

             current =iv_ruleConditionalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConditionalExpression3407); 

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
    // $ANTLR end entryRuleConditionalExpression


    // $ANTLR start ruleConditionalExpression
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1464:1: ruleConditionalExpression returns [EObject current=null] : ( (lv_operand1_0= ruleBooleanOrExpression ) ( '?' (lv_operand2_2= ruleShiftExpression ) ':' (lv_operand3_4= ruleShiftExpression ) )? ) ;
    public final EObject ruleConditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_operand1_0 = null;

        EObject lv_operand2_2 = null;

        EObject lv_operand3_4 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1469:6: ( ( (lv_operand1_0= ruleBooleanOrExpression ) ( '?' (lv_operand2_2= ruleShiftExpression ) ':' (lv_operand3_4= ruleShiftExpression ) )? ) )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1470:1: ( (lv_operand1_0= ruleBooleanOrExpression ) ( '?' (lv_operand2_2= ruleShiftExpression ) ':' (lv_operand3_4= ruleShiftExpression ) )? )
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1470:1: ( (lv_operand1_0= ruleBooleanOrExpression ) ( '?' (lv_operand2_2= ruleShiftExpression ) ':' (lv_operand3_4= ruleShiftExpression ) )? )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1470:2: (lv_operand1_0= ruleBooleanOrExpression ) ( '?' (lv_operand2_2= ruleShiftExpression ) ':' (lv_operand3_4= ruleShiftExpression ) )?
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1470:2: (lv_operand1_0= ruleBooleanOrExpression )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1473:6: lv_operand1_0= ruleBooleanOrExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionAccess().getOperand1BooleanOrExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBooleanOrExpression_in_ruleConditionalExpression3466);
            lv_operand1_0=ruleBooleanOrExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getConditionalExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "operand1", lv_operand1_0, "BooleanOrExpression", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1491:2: ( '?' (lv_operand2_2= ruleShiftExpression ) ':' (lv_operand3_4= ruleShiftExpression ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==26) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1491:3: '?' (lv_operand2_2= ruleShiftExpression ) ':' (lv_operand3_4= ruleShiftExpression )
                    {
                    match(input,26,FOLLOW_26_in_ruleConditionalExpression3480); 

                            createLeafNode(grammarAccess.getConditionalExpressionAccess().getQuestionMarkKeyword_1_0(), null); 
                        
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1495:1: (lv_operand2_2= ruleShiftExpression )
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1498:6: lv_operand2_2= ruleShiftExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionAccess().getOperand2ShiftExpressionParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleShiftExpression_in_ruleConditionalExpression3514);
                    lv_operand2_2=ruleShiftExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getConditionalExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "operand2", lv_operand2_2, "ShiftExpression", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }

                    match(input,27,FOLLOW_27_in_ruleConditionalExpression3527); 

                            createLeafNode(grammarAccess.getConditionalExpressionAccess().getColonKeyword_1_2(), null); 
                        
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1520:1: (lv_operand3_4= ruleShiftExpression )
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1523:6: lv_operand3_4= ruleShiftExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionAccess().getOperand3ShiftExpressionParserRuleCall_1_3_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleShiftExpression_in_ruleConditionalExpression3561);
                    lv_operand3_4=ruleShiftExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getConditionalExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "operand3", lv_operand3_4, "ShiftExpression", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

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
    // $ANTLR end ruleConditionalExpression


    // $ANTLR start entryRuleShiftExpression
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1548:1: entryRuleShiftExpression returns [EObject current=null] : iv_ruleShiftExpression= ruleShiftExpression EOF ;
    public final EObject entryRuleShiftExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShiftExpression = null;


        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1548:57: (iv_ruleShiftExpression= ruleShiftExpression EOF )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1549:2: iv_ruleShiftExpression= ruleShiftExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getShiftExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleShiftExpression_in_entryRuleShiftExpression3600);
            iv_ruleShiftExpression=ruleShiftExpression();
            _fsp--;

             current =iv_ruleShiftExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleShiftExpression3610); 

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
    // $ANTLR end entryRuleShiftExpression


    // $ANTLR start ruleShiftExpression
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1556:1: ruleShiftExpression returns [EObject current=null] : ( (lv_operand1_0= ruleAdditiveExpression ) ( (lv_operator_1= ruleShiftOperator ) (lv_operand2_2= ruleAdditiveExpression ) )* ) ;
    public final EObject ruleShiftExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_operand1_0 = null;

        Enumerator lv_operator_1 = null;

        EObject lv_operand2_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1561:6: ( ( (lv_operand1_0= ruleAdditiveExpression ) ( (lv_operator_1= ruleShiftOperator ) (lv_operand2_2= ruleAdditiveExpression ) )* ) )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1562:1: ( (lv_operand1_0= ruleAdditiveExpression ) ( (lv_operator_1= ruleShiftOperator ) (lv_operand2_2= ruleAdditiveExpression ) )* )
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1562:1: ( (lv_operand1_0= ruleAdditiveExpression ) ( (lv_operator_1= ruleShiftOperator ) (lv_operand2_2= ruleAdditiveExpression ) )* )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1562:2: (lv_operand1_0= ruleAdditiveExpression ) ( (lv_operator_1= ruleShiftOperator ) (lv_operand2_2= ruleAdditiveExpression ) )*
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1562:2: (lv_operand1_0= ruleAdditiveExpression )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1565:6: lv_operand1_0= ruleAdditiveExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getShiftExpressionAccess().getOperand1AdditiveExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleShiftExpression3669);
            lv_operand1_0=ruleAdditiveExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getShiftExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "operand1", lv_operand1_0, "AdditiveExpression", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1583:2: ( (lv_operator_1= ruleShiftOperator ) (lv_operand2_2= ruleAdditiveExpression ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=48 && LA17_0<=49)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1583:3: (lv_operator_1= ruleShiftOperator ) (lv_operand2_2= ruleAdditiveExpression )
            	    {
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1583:3: (lv_operator_1= ruleShiftOperator )
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1586:6: lv_operator_1= ruleShiftOperator
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getShiftExpressionAccess().getOperatorShiftOperatorEnumRuleCall_1_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleShiftOperator_in_ruleShiftExpression3708);
            	    lv_operator_1=ruleShiftOperator();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getShiftExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "operator", lv_operator_1, "ShiftOperator", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }

            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1604:2: (lv_operand2_2= ruleAdditiveExpression )
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1607:6: lv_operand2_2= ruleAdditiveExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getShiftExpressionAccess().getOperand2AdditiveExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleShiftExpression3746);
            	    lv_operand2_2=ruleAdditiveExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getShiftExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "operand2", lv_operand2_2, "AdditiveExpression", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


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
    // $ANTLR end ruleShiftExpression


    // $ANTLR start entryRuleAdditiveExpression
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1632:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1632:60: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1633:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAdditiveExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression3785);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();
            _fsp--;

             current =iv_ruleAdditiveExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpression3795); 

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
    // $ANTLR end entryRuleAdditiveExpression


    // $ANTLR start ruleAdditiveExpression
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1640:1: ruleAdditiveExpression returns [EObject current=null] : ( (lv_operand1_0= ruleMultiplicativeExpression ) ( (lv_operator_1= ruleAdditiveOperator ) (lv_operand2_2= ruleMultiplicativeExpression ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_operand1_0 = null;

        Enumerator lv_operator_1 = null;

        EObject lv_operand2_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1645:6: ( ( (lv_operand1_0= ruleMultiplicativeExpression ) ( (lv_operator_1= ruleAdditiveOperator ) (lv_operand2_2= ruleMultiplicativeExpression ) )* ) )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1646:1: ( (lv_operand1_0= ruleMultiplicativeExpression ) ( (lv_operator_1= ruleAdditiveOperator ) (lv_operand2_2= ruleMultiplicativeExpression ) )* )
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1646:1: ( (lv_operand1_0= ruleMultiplicativeExpression ) ( (lv_operator_1= ruleAdditiveOperator ) (lv_operand2_2= ruleMultiplicativeExpression ) )* )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1646:2: (lv_operand1_0= ruleMultiplicativeExpression ) ( (lv_operator_1= ruleAdditiveOperator ) (lv_operand2_2= ruleMultiplicativeExpression ) )*
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1646:2: (lv_operand1_0= ruleMultiplicativeExpression )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1649:6: lv_operand1_0= ruleMultiplicativeExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getAdditiveExpressionAccess().getOperand1MultiplicativeExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression3854);
            lv_operand1_0=ruleMultiplicativeExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAdditiveExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "operand1", lv_operand1_0, "MultiplicativeExpression", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1667:2: ( (lv_operator_1= ruleAdditiveOperator ) (lv_operand2_2= ruleMultiplicativeExpression ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>=50 && LA18_0<=51)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1667:3: (lv_operator_1= ruleAdditiveOperator ) (lv_operand2_2= ruleMultiplicativeExpression )
            	    {
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1667:3: (lv_operator_1= ruleAdditiveOperator )
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1670:6: lv_operator_1= ruleAdditiveOperator
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getAdditiveExpressionAccess().getOperatorAdditiveOperatorEnumRuleCall_1_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAdditiveOperator_in_ruleAdditiveExpression3893);
            	    lv_operator_1=ruleAdditiveOperator();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getAdditiveExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "operator", lv_operator_1, "AdditiveOperator", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }

            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1688:2: (lv_operand2_2= ruleMultiplicativeExpression )
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1691:6: lv_operand2_2= ruleMultiplicativeExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getAdditiveExpressionAccess().getOperand2MultiplicativeExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression3931);
            	    lv_operand2_2=ruleMultiplicativeExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getAdditiveExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "operand2", lv_operand2_2, "MultiplicativeExpression", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


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
    // $ANTLR end ruleAdditiveExpression


    // $ANTLR start entryRuleMultiplicativeExpression
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1716:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1716:66: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1717:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMultiplicativeExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression3970);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();
            _fsp--;

             current =iv_ruleMultiplicativeExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpression3980); 

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
    // $ANTLR end entryRuleMultiplicativeExpression


    // $ANTLR start ruleMultiplicativeExpression
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1724:1: ruleMultiplicativeExpression returns [EObject current=null] : ( (lv_operand1_0= ruleUnaryExpression ) ( (lv_operator_1= ruleMultiplicativeOperator ) (lv_operand2_2= ruleUnaryExpression ) )* ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_operand1_0 = null;

        Enumerator lv_operator_1 = null;

        EObject lv_operand2_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1729:6: ( ( (lv_operand1_0= ruleUnaryExpression ) ( (lv_operator_1= ruleMultiplicativeOperator ) (lv_operand2_2= ruleUnaryExpression ) )* ) )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1730:1: ( (lv_operand1_0= ruleUnaryExpression ) ( (lv_operator_1= ruleMultiplicativeOperator ) (lv_operand2_2= ruleUnaryExpression ) )* )
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1730:1: ( (lv_operand1_0= ruleUnaryExpression ) ( (lv_operator_1= ruleMultiplicativeOperator ) (lv_operand2_2= ruleUnaryExpression ) )* )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1730:2: (lv_operand1_0= ruleUnaryExpression ) ( (lv_operator_1= ruleMultiplicativeOperator ) (lv_operand2_2= ruleUnaryExpression ) )*
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1730:2: (lv_operand1_0= ruleUnaryExpression )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1733:6: lv_operand1_0= ruleUnaryExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getOperand1UnaryExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression4039);
            lv_operand1_0=ruleUnaryExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMultiplicativeExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "operand1", lv_operand1_0, "UnaryExpression", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1751:2: ( (lv_operator_1= ruleMultiplicativeOperator ) (lv_operand2_2= ruleUnaryExpression ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=52 && LA19_0<=54)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1751:3: (lv_operator_1= ruleMultiplicativeOperator ) (lv_operand2_2= ruleUnaryExpression )
            	    {
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1751:3: (lv_operator_1= ruleMultiplicativeOperator )
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1754:6: lv_operator_1= ruleMultiplicativeOperator
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getOperatorMultiplicativeOperatorEnumRuleCall_1_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleMultiplicativeOperator_in_ruleMultiplicativeExpression4078);
            	    lv_operator_1=ruleMultiplicativeOperator();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getMultiplicativeExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "operator", lv_operator_1, "MultiplicativeOperator", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }

            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1772:2: (lv_operand2_2= ruleUnaryExpression )
            	    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1775:6: lv_operand2_2= ruleUnaryExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getOperand2UnaryExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression4116);
            	    lv_operand2_2=ruleUnaryExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getMultiplicativeExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "operand2", lv_operand2_2, "UnaryExpression", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


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
    // $ANTLR end ruleMultiplicativeExpression


    // $ANTLR start entryRuleUnaryExpression
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1800:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1800:57: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1801:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnaryExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression4155);
            iv_ruleUnaryExpression=ruleUnaryExpression();
            _fsp--;

             current =iv_ruleUnaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryExpression4165); 

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
    // $ANTLR end entryRuleUnaryExpression


    // $ANTLR start ruleUnaryExpression
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1808:1: ruleUnaryExpression returns [EObject current=null] : ( (lv_operator_0= ruleUnaryOperator )? (lv_operand_1= rulePrimaryExpression ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_0 = null;

        EObject lv_operand_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1813:6: ( ( (lv_operator_0= ruleUnaryOperator )? (lv_operand_1= rulePrimaryExpression ) ) )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1814:1: ( (lv_operator_0= ruleUnaryOperator )? (lv_operand_1= rulePrimaryExpression ) )
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1814:1: ( (lv_operator_0= ruleUnaryOperator )? (lv_operand_1= rulePrimaryExpression ) )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1814:2: (lv_operator_0= ruleUnaryOperator )? (lv_operand_1= rulePrimaryExpression )
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1814:2: (lv_operator_0= ruleUnaryOperator )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=50 && LA20_0<=51)||(LA20_0>=55 && LA20_0<=56)) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1817:6: lv_operator_0= ruleUnaryOperator
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnaryExpressionAccess().getOperatorUnaryOperatorEnumRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnaryOperator_in_ruleUnaryExpression4224);
                    lv_operator_0=ruleUnaryOperator();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUnaryExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "operator", lv_operator_0, "UnaryOperator", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }
                    break;

            }

            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1835:3: (lv_operand_1= rulePrimaryExpression )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1838:6: lv_operand_1= rulePrimaryExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getUnaryExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_rulePrimaryExpression_in_ruleUnaryExpression4263);
            lv_operand_1=rulePrimaryExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getUnaryExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "operand", lv_operand_1, "PrimaryExpression", currentNode);
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
    // $ANTLR end ruleUnaryExpression


    // $ANTLR start entryRulePrimaryExpression
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1863:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1863:59: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1864:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPrimaryExpressionRule(), currentNode); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression4300);
            iv_rulePrimaryExpression=rulePrimaryExpression();
            _fsp--;

             current =iv_rulePrimaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression4310); 

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
    // $ANTLR end entryRulePrimaryExpression


    // $ANTLR start rulePrimaryExpression
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1871:1: rulePrimaryExpression returns [EObject current=null] : (this_VariableReference_0= ruleVariableReference | this_LiteralValue_1= ruleLiteralValue | ( '(' this_NestedExpression_3= ruleNestedExpression ')' ) ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_VariableReference_0 = null;

        EObject this_LiteralValue_1 = null;

        EObject this_NestedExpression_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1876:6: ( (this_VariableReference_0= ruleVariableReference | this_LiteralValue_1= ruleLiteralValue | ( '(' this_NestedExpression_3= ruleNestedExpression ')' ) ) )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1877:1: (this_VariableReference_0= ruleVariableReference | this_LiteralValue_1= ruleLiteralValue | ( '(' this_NestedExpression_3= ruleNestedExpression ')' ) )
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1877:1: (this_VariableReference_0= ruleVariableReference | this_LiteralValue_1= ruleLiteralValue | ( '(' this_NestedExpression_3= ruleNestedExpression ')' ) )
            int alt21=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case 18:
                {
                alt21=1;
                }
                break;
            case RULE_INT:
            case RULE_HEX_LITERAL:
            case RULE_BOOLEAN_LITERAL:
            case RULE_STRING:
            case RULE_FLOATING_POINT_LITERAL:
                {
                alt21=2;
                }
                break;
            case 16:
                {
                alt21=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1877:1: (this_VariableReference_0= ruleVariableReference | this_LiteralValue_1= ruleLiteralValue | ( '(' this_NestedExpression_3= ruleNestedExpression ')' ) )", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1878:5: this_VariableReference_0= ruleVariableReference
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getVariableReferenceParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVariableReference_in_rulePrimaryExpression4357);
                    this_VariableReference_0=ruleVariableReference();
                    _fsp--;

                     
                            current = this_VariableReference_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1888:5: this_LiteralValue_1= ruleLiteralValue
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLiteralValueParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleLiteralValue_in_rulePrimaryExpression4384);
                    this_LiteralValue_1=ruleLiteralValue();
                    _fsp--;

                     
                            current = this_LiteralValue_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1897:6: ( '(' this_NestedExpression_3= ruleNestedExpression ')' )
                    {
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1897:6: ( '(' this_NestedExpression_3= ruleNestedExpression ')' )
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1897:7: '(' this_NestedExpression_3= ruleNestedExpression ')'
                    {
                    match(input,16,FOLLOW_16_in_rulePrimaryExpression4399); 

                            createLeafNode(grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getNestedExpressionParserRuleCall_2_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNestedExpression_in_rulePrimaryExpression4421);
                    this_NestedExpression_3=ruleNestedExpression();
                    _fsp--;

                     
                            current = this_NestedExpression_3; 
                            currentNode = currentNode.getParent();
                        
                    match(input,17,FOLLOW_17_in_rulePrimaryExpression4429); 

                            createLeafNode(grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_2_2(), null); 
                        

                    }


                    }
                    break;

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
    // $ANTLR end rulePrimaryExpression


    // $ANTLR start entryRuleNestedExpression
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1921:1: entryRuleNestedExpression returns [EObject current=null] : iv_ruleNestedExpression= ruleNestedExpression EOF ;
    public final EObject entryRuleNestedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedExpression = null;


        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1921:58: (iv_ruleNestedExpression= ruleNestedExpression EOF )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1922:2: iv_ruleNestedExpression= ruleNestedExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNestedExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleNestedExpression_in_entryRuleNestedExpression4463);
            iv_ruleNestedExpression=ruleNestedExpression();
            _fsp--;

             current =iv_ruleNestedExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNestedExpression4473); 

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
    // $ANTLR end entryRuleNestedExpression


    // $ANTLR start ruleNestedExpression
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1929:1: ruleNestedExpression returns [EObject current=null] : (lv_expression_0= ruleConditionalExpression ) ;
    public final EObject ruleNestedExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1934:6: ( (lv_expression_0= ruleConditionalExpression ) )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1935:1: (lv_expression_0= ruleConditionalExpression )
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1935:1: (lv_expression_0= ruleConditionalExpression )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1938:6: lv_expression_0= ruleConditionalExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getNestedExpressionAccess().getExpressionConditionalExpressionParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleConditionalExpression_in_ruleNestedExpression4531);
            lv_expression_0=ruleConditionalExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getNestedExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "expression", lv_expression_0, "ConditionalExpression", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // $ANTLR end ruleNestedExpression


    // $ANTLR start entryRuleLiteralValue
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1963:1: entryRuleLiteralValue returns [EObject current=null] : iv_ruleLiteralValue= ruleLiteralValue EOF ;
    public final EObject entryRuleLiteralValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralValue = null;


        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1963:54: (iv_ruleLiteralValue= ruleLiteralValue EOF )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1964:2: iv_ruleLiteralValue= ruleLiteralValue EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLiteralValueRule(), currentNode); 
            pushFollow(FOLLOW_ruleLiteralValue_in_entryRuleLiteralValue4567);
            iv_ruleLiteralValue=ruleLiteralValue();
            _fsp--;

             current =iv_ruleLiteralValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralValue4577); 

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
    // $ANTLR end entryRuleLiteralValue


    // $ANTLR start ruleLiteralValue
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1971:1: ruleLiteralValue returns [EObject current=null] : (lv_value_0= ruleLiteral ) ;
    public final EObject ruleLiteralValue() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1976:6: ( (lv_value_0= ruleLiteral ) )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1977:1: (lv_value_0= ruleLiteral )
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1977:1: (lv_value_0= ruleLiteral )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:1980:6: lv_value_0= ruleLiteral
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getLiteralValueAccess().getValueLiteralParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleLiteral_in_ruleLiteralValue4635);
            lv_value_0=ruleLiteral();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLiteralValueRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "value", lv_value_0, "Literal", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // $ANTLR end ruleLiteralValue


    // $ANTLR start entryRuleLiteral
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2005:1: entryRuleLiteral returns [String current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final String entryRuleLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLiteral = null;


        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2005:48: (iv_ruleLiteral= ruleLiteral EOF )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2006:2: iv_ruleLiteral= ruleLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral4672);
            iv_ruleLiteral=ruleLiteral();
            _fsp--;

             current =iv_ruleLiteral.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral4683); 

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
    // $ANTLR end entryRuleLiteral


    // $ANTLR start ruleLiteral
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2013:1: ruleLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_HEX_LITERAL_0= RULE_HEX_LITERAL | this_BOOLEAN_LITERAL_1= RULE_BOOLEAN_LITERAL | this_INT_2= RULE_INT | this_STRING_3= RULE_STRING | this_FLOATING_POINT_LITERAL_4= RULE_FLOATING_POINT_LITERAL ) ;
    public final AntlrDatatypeRuleToken ruleLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_HEX_LITERAL_0=null;
        Token this_BOOLEAN_LITERAL_1=null;
        Token this_INT_2=null;
        Token this_STRING_3=null;
        Token this_FLOATING_POINT_LITERAL_4=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2019:6: ( (this_HEX_LITERAL_0= RULE_HEX_LITERAL | this_BOOLEAN_LITERAL_1= RULE_BOOLEAN_LITERAL | this_INT_2= RULE_INT | this_STRING_3= RULE_STRING | this_FLOATING_POINT_LITERAL_4= RULE_FLOATING_POINT_LITERAL ) )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2020:1: (this_HEX_LITERAL_0= RULE_HEX_LITERAL | this_BOOLEAN_LITERAL_1= RULE_BOOLEAN_LITERAL | this_INT_2= RULE_INT | this_STRING_3= RULE_STRING | this_FLOATING_POINT_LITERAL_4= RULE_FLOATING_POINT_LITERAL )
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2020:1: (this_HEX_LITERAL_0= RULE_HEX_LITERAL | this_BOOLEAN_LITERAL_1= RULE_BOOLEAN_LITERAL | this_INT_2= RULE_INT | this_STRING_3= RULE_STRING | this_FLOATING_POINT_LITERAL_4= RULE_FLOATING_POINT_LITERAL )
            int alt22=5;
            switch ( input.LA(1) ) {
            case RULE_HEX_LITERAL:
                {
                alt22=1;
                }
                break;
            case RULE_BOOLEAN_LITERAL:
                {
                alt22=2;
                }
                break;
            case RULE_INT:
                {
                alt22=3;
                }
                break;
            case RULE_STRING:
                {
                alt22=4;
                }
                break;
            case RULE_FLOATING_POINT_LITERAL:
                {
                alt22=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("2020:1: (this_HEX_LITERAL_0= RULE_HEX_LITERAL | this_BOOLEAN_LITERAL_1= RULE_BOOLEAN_LITERAL | this_INT_2= RULE_INT | this_STRING_3= RULE_STRING | this_FLOATING_POINT_LITERAL_4= RULE_FLOATING_POINT_LITERAL )", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2020:6: this_HEX_LITERAL_0= RULE_HEX_LITERAL
                    {
                    this_HEX_LITERAL_0=(Token)input.LT(1);
                    match(input,RULE_HEX_LITERAL,FOLLOW_RULE_HEX_LITERAL_in_ruleLiteral4723); 

                    		current.merge(this_HEX_LITERAL_0);
                        
                     
                        createLeafNode(grammarAccess.getLiteralAccess().getHEX_LITERALTerminalRuleCall_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2028:10: this_BOOLEAN_LITERAL_1= RULE_BOOLEAN_LITERAL
                    {
                    this_BOOLEAN_LITERAL_1=(Token)input.LT(1);
                    match(input,RULE_BOOLEAN_LITERAL,FOLLOW_RULE_BOOLEAN_LITERAL_in_ruleLiteral4749); 

                    		current.merge(this_BOOLEAN_LITERAL_1);
                        
                     
                        createLeafNode(grammarAccess.getLiteralAccess().getBOOLEAN_LITERALTerminalRuleCall_1(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2036:10: this_INT_2= RULE_INT
                    {
                    this_INT_2=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleLiteral4775); 

                    		current.merge(this_INT_2);
                        
                     
                        createLeafNode(grammarAccess.getLiteralAccess().getINTTerminalRuleCall_2(), null); 
                        

                    }
                    break;
                case 4 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2044:10: this_STRING_3= RULE_STRING
                    {
                    this_STRING_3=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleLiteral4801); 

                    		current.merge(this_STRING_3);
                        
                     
                        createLeafNode(grammarAccess.getLiteralAccess().getSTRINGTerminalRuleCall_3(), null); 
                        

                    }
                    break;
                case 5 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2052:10: this_FLOATING_POINT_LITERAL_4= RULE_FLOATING_POINT_LITERAL
                    {
                    this_FLOATING_POINT_LITERAL_4=(Token)input.LT(1);
                    match(input,RULE_FLOATING_POINT_LITERAL,FOLLOW_RULE_FLOATING_POINT_LITERAL_in_ruleLiteral4827); 

                    		current.merge(this_FLOATING_POINT_LITERAL_4);
                        
                     
                        createLeafNode(grammarAccess.getLiteralAccess().getFLOATING_POINT_LITERALTerminalRuleCall_4(), null); 
                        

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
    // $ANTLR end ruleLiteral


    // $ANTLR start ruleTimeUnit
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2067:1: ruleTimeUnit returns [Enumerator current=null] : ( ( 's' ) | ( 'ms' ) | ( 'ns' ) ) ;
    public final Enumerator ruleTimeUnit() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2071:6: ( ( ( 's' ) | ( 'ms' ) | ( 'ns' ) ) )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2072:1: ( ( 's' ) | ( 'ms' ) | ( 'ns' ) )
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2072:1: ( ( 's' ) | ( 'ms' ) | ( 'ns' ) )
            int alt23=3;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt23=1;
                }
                break;
            case 29:
                {
                alt23=2;
                }
                break;
            case 30:
                {
                alt23=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("2072:1: ( ( 's' ) | ( 'ms' ) | ( 'ns' ) )", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2072:2: ( 's' )
                    {
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2072:2: ( 's' )
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2072:4: 's'
                    {
                    match(input,28,FOLLOW_28_in_ruleTimeUnit4884); 

                            current = grammarAccess.getTimeUnitAccess().getSecondEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getTimeUnitAccess().getSecondEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2078:6: ( 'ms' )
                    {
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2078:6: ( 'ms' )
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2078:8: 'ms'
                    {
                    match(input,29,FOLLOW_29_in_ruleTimeUnit4899); 

                            current = grammarAccess.getTimeUnitAccess().getMillisecondEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getTimeUnitAccess().getMillisecondEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2084:6: ( 'ns' )
                    {
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2084:6: ( 'ns' )
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2084:8: 'ns'
                    {
                    match(input,30,FOLLOW_30_in_ruleTimeUnit4914); 

                            current = grammarAccess.getTimeUnitAccess().getNanosecondEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getTimeUnitAccess().getNanosecondEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;

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
    // $ANTLR end ruleTimeUnit


    // $ANTLR start ruleAssignmentOperator
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2094:1: ruleAssignmentOperator returns [Enumerator current=null] : ( ( '=' ) | ( '*=' ) | ( '/=' ) | ( '%=' ) | ( '+=' ) | ( '-=' ) | ( '<<=' ) | ( '>>=' ) | ( '&=' ) | ( '^=' ) | ( '|=' ) ) ;
    public final Enumerator ruleAssignmentOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2098:6: ( ( ( '=' ) | ( '*=' ) | ( '/=' ) | ( '%=' ) | ( '+=' ) | ( '-=' ) | ( '<<=' ) | ( '>>=' ) | ( '&=' ) | ( '^=' ) | ( '|=' ) ) )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2099:1: ( ( '=' ) | ( '*=' ) | ( '/=' ) | ( '%=' ) | ( '+=' ) | ( '-=' ) | ( '<<=' ) | ( '>>=' ) | ( '&=' ) | ( '^=' ) | ( '|=' ) )
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2099:1: ( ( '=' ) | ( '*=' ) | ( '/=' ) | ( '%=' ) | ( '+=' ) | ( '-=' ) | ( '<<=' ) | ( '>>=' ) | ( '&=' ) | ( '^=' ) | ( '|=' ) )
            int alt24=11;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt24=1;
                }
                break;
            case 32:
                {
                alt24=2;
                }
                break;
            case 33:
                {
                alt24=3;
                }
                break;
            case 34:
                {
                alt24=4;
                }
                break;
            case 35:
                {
                alt24=5;
                }
                break;
            case 36:
                {
                alt24=6;
                }
                break;
            case 37:
                {
                alt24=7;
                }
                break;
            case 38:
                {
                alt24=8;
                }
                break;
            case 39:
                {
                alt24=9;
                }
                break;
            case 40:
                {
                alt24=10;
                }
                break;
            case 41:
                {
                alt24=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("2099:1: ( ( '=' ) | ( '*=' ) | ( '/=' ) | ( '%=' ) | ( '+=' ) | ( '-=' ) | ( '<<=' ) | ( '>>=' ) | ( '&=' ) | ( '^=' ) | ( '|=' ) )", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2099:2: ( '=' )
                    {
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2099:2: ( '=' )
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2099:4: '='
                    {
                    match(input,31,FOLLOW_31_in_ruleAssignmentOperator4957); 

                            current = grammarAccess.getAssignmentOperatorAccess().getAssignEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAssignmentOperatorAccess().getAssignEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2105:6: ( '*=' )
                    {
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2105:6: ( '*=' )
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2105:8: '*='
                    {
                    match(input,32,FOLLOW_32_in_ruleAssignmentOperator4972); 

                            current = grammarAccess.getAssignmentOperatorAccess().getMultAssignEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAssignmentOperatorAccess().getMultAssignEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2111:6: ( '/=' )
                    {
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2111:6: ( '/=' )
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2111:8: '/='
                    {
                    match(input,33,FOLLOW_33_in_ruleAssignmentOperator4987); 

                            current = grammarAccess.getAssignmentOperatorAccess().getDivAssignEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAssignmentOperatorAccess().getDivAssignEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2117:6: ( '%=' )
                    {
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2117:6: ( '%=' )
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2117:8: '%='
                    {
                    match(input,34,FOLLOW_34_in_ruleAssignmentOperator5002); 

                            current = grammarAccess.getAssignmentOperatorAccess().getModAssignEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAssignmentOperatorAccess().getModAssignEnumLiteralDeclaration_3(), null); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2123:6: ( '+=' )
                    {
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2123:6: ( '+=' )
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2123:8: '+='
                    {
                    match(input,35,FOLLOW_35_in_ruleAssignmentOperator5017); 

                            current = grammarAccess.getAssignmentOperatorAccess().getAddAssignEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAssignmentOperatorAccess().getAddAssignEnumLiteralDeclaration_4(), null); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2129:6: ( '-=' )
                    {
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2129:6: ( '-=' )
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2129:8: '-='
                    {
                    match(input,36,FOLLOW_36_in_ruleAssignmentOperator5032); 

                            current = grammarAccess.getAssignmentOperatorAccess().getSubAssignEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAssignmentOperatorAccess().getSubAssignEnumLiteralDeclaration_5(), null); 
                        

                    }


                    }
                    break;
                case 7 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2135:6: ( '<<=' )
                    {
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2135:6: ( '<<=' )
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2135:8: '<<='
                    {
                    match(input,37,FOLLOW_37_in_ruleAssignmentOperator5047); 

                            current = grammarAccess.getAssignmentOperatorAccess().getLeftShiftAssignEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAssignmentOperatorAccess().getLeftShiftAssignEnumLiteralDeclaration_6(), null); 
                        

                    }


                    }
                    break;
                case 8 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2141:6: ( '>>=' )
                    {
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2141:6: ( '>>=' )
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2141:8: '>>='
                    {
                    match(input,38,FOLLOW_38_in_ruleAssignmentOperator5062); 

                            current = grammarAccess.getAssignmentOperatorAccess().getRightShiftAssignEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAssignmentOperatorAccess().getRightShiftAssignEnumLiteralDeclaration_7(), null); 
                        

                    }


                    }
                    break;
                case 9 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2147:6: ( '&=' )
                    {
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2147:6: ( '&=' )
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2147:8: '&='
                    {
                    match(input,39,FOLLOW_39_in_ruleAssignmentOperator5077); 

                            current = grammarAccess.getAssignmentOperatorAccess().getAndAssignEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAssignmentOperatorAccess().getAndAssignEnumLiteralDeclaration_8(), null); 
                        

                    }


                    }
                    break;
                case 10 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2153:6: ( '^=' )
                    {
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2153:6: ( '^=' )
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2153:8: '^='
                    {
                    match(input,40,FOLLOW_40_in_ruleAssignmentOperator5092); 

                            current = grammarAccess.getAssignmentOperatorAccess().getXorAssignEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAssignmentOperatorAccess().getXorAssignEnumLiteralDeclaration_9(), null); 
                        

                    }


                    }
                    break;
                case 11 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2159:6: ( '|=' )
                    {
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2159:6: ( '|=' )
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2159:8: '|='
                    {
                    match(input,41,FOLLOW_41_in_ruleAssignmentOperator5107); 

                            current = grammarAccess.getAssignmentOperatorAccess().getOrAssignEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAssignmentOperatorAccess().getOrAssignEnumLiteralDeclaration_10(), null); 
                        

                    }


                    }
                    break;

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
    // $ANTLR end ruleAssignmentOperator


    // $ANTLR start ruleEqualityOperator
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2169:1: ruleEqualityOperator returns [Enumerator current=null] : ( ( '==' ) | ( '!=' ) ) ;
    public final Enumerator ruleEqualityOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2173:6: ( ( ( '==' ) | ( '!=' ) ) )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2174:1: ( ( '==' ) | ( '!=' ) )
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2174:1: ( ( '==' ) | ( '!=' ) )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==42) ) {
                alt25=1;
            }
            else if ( (LA25_0==43) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2174:1: ( ( '==' ) | ( '!=' ) )", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2174:2: ( '==' )
                    {
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2174:2: ( '==' )
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2174:4: '=='
                    {
                    match(input,42,FOLLOW_42_in_ruleEqualityOperator5150); 

                            current = grammarAccess.getEqualityOperatorAccess().getEqualsEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getEqualityOperatorAccess().getEqualsEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2180:6: ( '!=' )
                    {
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2180:6: ( '!=' )
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2180:8: '!='
                    {
                    match(input,43,FOLLOW_43_in_ruleEqualityOperator5165); 

                            current = grammarAccess.getEqualityOperatorAccess().getNotEqualsEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getEqualityOperatorAccess().getNotEqualsEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;

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
    // $ANTLR end ruleEqualityOperator


    // $ANTLR start ruleRelationalOperator
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2190:1: ruleRelationalOperator returns [Enumerator current=null] : ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) ) ;
    public final Enumerator ruleRelationalOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2194:6: ( ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) ) )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2195:1: ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) )
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2195:1: ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) )
            int alt26=4;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt26=1;
                }
                break;
            case 45:
                {
                alt26=2;
                }
                break;
            case 46:
                {
                alt26=3;
                }
                break;
            case 47:
                {
                alt26=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("2195:1: ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) )", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2195:2: ( '<' )
                    {
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2195:2: ( '<' )
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2195:4: '<'
                    {
                    match(input,44,FOLLOW_44_in_ruleRelationalOperator5208); 

                            current = grammarAccess.getRelationalOperatorAccess().getSmallerEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getSmallerEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2201:6: ( '>' )
                    {
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2201:6: ( '>' )
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2201:8: '>'
                    {
                    match(input,45,FOLLOW_45_in_ruleRelationalOperator5223); 

                            current = grammarAccess.getRelationalOperatorAccess().getGreaterEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getGreaterEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2207:6: ( '<=' )
                    {
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2207:6: ( '<=' )
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2207:8: '<='
                    {
                    match(input,46,FOLLOW_46_in_ruleRelationalOperator5238); 

                            current = grammarAccess.getRelationalOperatorAccess().getSmallerEqualEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getSmallerEqualEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2213:6: ( '>=' )
                    {
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2213:6: ( '>=' )
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2213:8: '>='
                    {
                    match(input,47,FOLLOW_47_in_ruleRelationalOperator5253); 

                            current = grammarAccess.getRelationalOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3(), null); 
                        

                    }


                    }
                    break;

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
    // $ANTLR end ruleRelationalOperator


    // $ANTLR start ruleShiftOperator
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2223:1: ruleShiftOperator returns [Enumerator current=null] : ( ( '<<' ) | ( '>>' ) ) ;
    public final Enumerator ruleShiftOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2227:6: ( ( ( '<<' ) | ( '>>' ) ) )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2228:1: ( ( '<<' ) | ( '>>' ) )
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2228:1: ( ( '<<' ) | ( '>>' ) )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==48) ) {
                alt27=1;
            }
            else if ( (LA27_0==49) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2228:1: ( ( '<<' ) | ( '>>' ) )", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2228:2: ( '<<' )
                    {
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2228:2: ( '<<' )
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2228:4: '<<'
                    {
                    match(input,48,FOLLOW_48_in_ruleShiftOperator5296); 

                            current = grammarAccess.getShiftOperatorAccess().getLeftEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getShiftOperatorAccess().getLeftEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2234:6: ( '>>' )
                    {
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2234:6: ( '>>' )
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2234:8: '>>'
                    {
                    match(input,49,FOLLOW_49_in_ruleShiftOperator5311); 

                            current = grammarAccess.getShiftOperatorAccess().getRightEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getShiftOperatorAccess().getRightEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;

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
    // $ANTLR end ruleShiftOperator


    // $ANTLR start ruleAdditiveOperator
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2244:1: ruleAdditiveOperator returns [Enumerator current=null] : ( ( '+' ) | ( '-' ) ) ;
    public final Enumerator ruleAdditiveOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2248:6: ( ( ( '+' ) | ( '-' ) ) )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2249:1: ( ( '+' ) | ( '-' ) )
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2249:1: ( ( '+' ) | ( '-' ) )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==50) ) {
                alt28=1;
            }
            else if ( (LA28_0==51) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2249:1: ( ( '+' ) | ( '-' ) )", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2249:2: ( '+' )
                    {
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2249:2: ( '+' )
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2249:4: '+'
                    {
                    match(input,50,FOLLOW_50_in_ruleAdditiveOperator5354); 

                            current = grammarAccess.getAdditiveOperatorAccess().getPlusEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAdditiveOperatorAccess().getPlusEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2255:6: ( '-' )
                    {
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2255:6: ( '-' )
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2255:8: '-'
                    {
                    match(input,51,FOLLOW_51_in_ruleAdditiveOperator5369); 

                            current = grammarAccess.getAdditiveOperatorAccess().getMinusEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAdditiveOperatorAccess().getMinusEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;

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
    // $ANTLR end ruleAdditiveOperator


    // $ANTLR start ruleMultiplicativeOperator
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2265:1: ruleMultiplicativeOperator returns [Enumerator current=null] : ( ( '*' ) | ( '/' ) | ( '%' ) ) ;
    public final Enumerator ruleMultiplicativeOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2269:6: ( ( ( '*' ) | ( '/' ) | ( '%' ) ) )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2270:1: ( ( '*' ) | ( '/' ) | ( '%' ) )
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2270:1: ( ( '*' ) | ( '/' ) | ( '%' ) )
            int alt29=3;
            switch ( input.LA(1) ) {
            case 52:
                {
                alt29=1;
                }
                break;
            case 53:
                {
                alt29=2;
                }
                break;
            case 54:
                {
                alt29=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("2270:1: ( ( '*' ) | ( '/' ) | ( '%' ) )", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2270:2: ( '*' )
                    {
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2270:2: ( '*' )
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2270:4: '*'
                    {
                    match(input,52,FOLLOW_52_in_ruleMultiplicativeOperator5412); 

                            current = grammarAccess.getMultiplicativeOperatorAccess().getMulEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getMultiplicativeOperatorAccess().getMulEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2276:6: ( '/' )
                    {
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2276:6: ( '/' )
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2276:8: '/'
                    {
                    match(input,53,FOLLOW_53_in_ruleMultiplicativeOperator5427); 

                            current = grammarAccess.getMultiplicativeOperatorAccess().getDivEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getMultiplicativeOperatorAccess().getDivEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2282:6: ( '%' )
                    {
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2282:6: ( '%' )
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2282:8: '%'
                    {
                    match(input,54,FOLLOW_54_in_ruleMultiplicativeOperator5442); 

                            current = grammarAccess.getMultiplicativeOperatorAccess().getModEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getMultiplicativeOperatorAccess().getModEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;

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
    // $ANTLR end ruleMultiplicativeOperator


    // $ANTLR start ruleUnaryOperator
    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2292:1: ruleUnaryOperator returns [Enumerator current=null] : ( ( '+' ) | ( '-' ) | ( '~' ) | ( '!' ) ) ;
    public final Enumerator ruleUnaryOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2296:6: ( ( ( '+' ) | ( '-' ) | ( '~' ) | ( '!' ) ) )
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2297:1: ( ( '+' ) | ( '-' ) | ( '~' ) | ( '!' ) )
            {
            // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2297:1: ( ( '+' ) | ( '-' ) | ( '~' ) | ( '!' ) )
            int alt30=4;
            switch ( input.LA(1) ) {
            case 50:
                {
                alt30=1;
                }
                break;
            case 51:
                {
                alt30=2;
                }
                break;
            case 55:
                {
                alt30=3;
                }
                break;
            case 56:
                {
                alt30=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("2297:1: ( ( '+' ) | ( '-' ) | ( '~' ) | ( '!' ) )", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2297:2: ( '+' )
                    {
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2297:2: ( '+' )
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2297:4: '+'
                    {
                    match(input,50,FOLLOW_50_in_ruleUnaryOperator5485); 

                            current = grammarAccess.getUnaryOperatorAccess().getPositiveEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getUnaryOperatorAccess().getPositiveEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2303:6: ( '-' )
                    {
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2303:6: ( '-' )
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2303:8: '-'
                    {
                    match(input,51,FOLLOW_51_in_ruleUnaryOperator5500); 

                            current = grammarAccess.getUnaryOperatorAccess().getNegativeEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getUnaryOperatorAccess().getNegativeEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2309:6: ( '~' )
                    {
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2309:6: ( '~' )
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2309:8: '~'
                    {
                    match(input,55,FOLLOW_55_in_ruleUnaryOperator5515); 

                            current = grammarAccess.getUnaryOperatorAccess().getComplementEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getUnaryOperatorAccess().getComplementEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2315:6: ( '!' )
                    {
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2315:6: ( '!' )
                    // ../com.yakindu.statechart.model.expressions/src-gen/com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.g:2315:8: '!'
                    {
                    match(input,56,FOLLOW_56_in_ruleUnaryOperator5530); 

                            current = grammarAccess.getUnaryOperatorAccess().getNotEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getUnaryOperatorAccess().getNotEnumLiteralDeclaration_3(), null); 
                        

                    }


                    }
                    break;

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
    // $ANTLR end ruleUnaryOperator


 

    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTriggerExpression_in_ruleExpression130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGuardExpression_in_ruleExpression157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActionExpression_in_ruleExpression184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTriggerExpression_in_entryRuleTriggerExpression216 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTriggerExpression226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTrigger_in_ruleTriggerExpression285 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleTriggerExpression299 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleTrigger_in_ruleTriggerExpression333 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ruleGuardExpression_in_entryRuleGuardExpression372 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGuardExpression382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanOrExpression_in_ruleGuardExpression440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActionExpression_in_entryRuleActionExpression476 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActionExpression486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatement_in_ruleActionExpression544 = new BitSet(new long[]{0x0000000000140012L});
    public static final BitSet FOLLOW_ruleTrigger_in_entryRuleTrigger581 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTrigger591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvent_in_ruleTrigger649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvent_in_entryRuleEvent685 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEvent695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignalEvent_in_ruleEvent742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeEvent_in_ruleEvent769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignalEvent_in_entryRuleSignalEvent801 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSignalEvent811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSignalEvent857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeEvent_in_entryRuleTimeEvent897 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTimeEvent907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleTimeEvent941 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleTimeEvent950 = new BitSet(new long[]{0x0000000000040030L});
    public static final BitSet FOLLOW_ruleTimeExpression_in_ruleTimeEvent984 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleTimeEvent997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeExpression_in_entryRuleTimeExpression1030 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTimeExpression1040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeConstant_in_ruleTimeExpression1087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableReference_in_ruleTimeExpression1114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableReference_in_entryRuleVariableReference1146 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableReference1156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_ruleVariableReference1215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleVariableReference1235 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleVariableReference1244 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleVariable_in_ruleVariableReference1278 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleVariableReference1291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_entryRuleVariable1325 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariable1335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariable1381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeConstant_in_entryRuleTimeConstant1421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTimeConstant1431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTimeConstant1478 = new BitSet(new long[]{0x0000000070000002L});
    public static final BitSet FOLLOW_ruleTimeUnit_in_ruleTimeConstant1520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatement_in_entryRuleStatement1558 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatement1568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableAssignment_in_ruleStatement1616 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ruleEventRaising_in_ruleStatement1643 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ruleProcedureCall_in_ruleStatement1670 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleStatement1679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableAssignment_in_entryRuleVariableAssignment1712 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableAssignment1722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableReference_in_ruleVariableAssignment1781 = new BitSet(new long[]{0x000003FF80000000L});
    public static final BitSet FOLLOW_ruleAssignmentOperator_in_ruleVariableAssignment1819 = new BitSet(new long[]{0x018C0000000503F0L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_ruleVariableAssignment1857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProcedureCall_in_entryRuleProcedureCall1894 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProcedureCall1904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProcedure_in_ruleProcedureCall1963 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleProcedureCall1976 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleProcedureCall1985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProcedure_in_entryRuleProcedure2018 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProcedure2028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleProcedure2074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventRaising_in_entryRuleEventRaising2114 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEventRaising2124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleEventRaising2158 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleEventRaising2167 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSignalEvent_in_ruleEventRaising2201 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleEventRaising2214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanOrExpression_in_entryRuleBooleanOrExpression2247 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanOrExpression2257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanAndExpression_in_ruleBooleanOrExpression2316 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_ruleBooleanOrExpression2330 = new BitSet(new long[]{0x018C0000000503F0L});
    public static final BitSet FOLLOW_ruleBooleanAndExpression_in_ruleBooleanOrExpression2364 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleBooleanAndExpression_in_entryRuleBooleanAndExpression2403 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanAndExpression2413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitwiseXorExpression_in_ruleBooleanAndExpression2472 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_ruleBooleanAndExpression2486 = new BitSet(new long[]{0x018C0000000503F0L});
    public static final BitSet FOLLOW_ruleBitwiseXorExpression_in_ruleBooleanAndExpression2520 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_ruleBitwiseXorExpression_in_entryRuleBitwiseXorExpression2559 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBitwiseXorExpression2569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitwiseOrExpression_in_ruleBitwiseXorExpression2628 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleBitwiseXorExpression2642 = new BitSet(new long[]{0x018C0000000503F0L});
    public static final BitSet FOLLOW_ruleBitwiseOrExpression_in_ruleBitwiseXorExpression2676 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_ruleBitwiseOrExpression_in_entryRuleBitwiseOrExpression2715 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBitwiseOrExpression2725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitwiseAndExpression_in_ruleBitwiseOrExpression2784 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_ruleBitwiseOrExpression2798 = new BitSet(new long[]{0x018C0000000503F0L});
    public static final BitSet FOLLOW_ruleBitwiseAndExpression_in_ruleBitwiseOrExpression2832 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_ruleBitwiseAndExpression_in_entryRuleBitwiseAndExpression2871 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBitwiseAndExpression2881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleBitwiseAndExpression2940 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleBitwiseAndExpression2954 = new BitSet(new long[]{0x018C0000000503F0L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleBitwiseAndExpression2988 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression3027 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpression3037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression3096 = new BitSet(new long[]{0x00000C0000000002L});
    public static final BitSet FOLLOW_ruleEqualityOperator_in_ruleEqualityExpression3135 = new BitSet(new long[]{0x018C0000000503F0L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression3173 = new BitSet(new long[]{0x00000C0000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression3212 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpression3222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShiftExpression_in_ruleRelationalExpression3281 = new BitSet(new long[]{0x0000F00000000002L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_ruleRelationalExpression3320 = new BitSet(new long[]{0x018C0000000503F0L});
    public static final BitSet FOLLOW_ruleShiftExpression_in_ruleRelationalExpression3358 = new BitSet(new long[]{0x0000F00000000002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_entryRuleConditionalExpression3397 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConditionalExpression3407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanOrExpression_in_ruleConditionalExpression3466 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_ruleConditionalExpression3480 = new BitSet(new long[]{0x018C0000000503F0L});
    public static final BitSet FOLLOW_ruleShiftExpression_in_ruleConditionalExpression3514 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleConditionalExpression3527 = new BitSet(new long[]{0x018C0000000503F0L});
    public static final BitSet FOLLOW_ruleShiftExpression_in_ruleConditionalExpression3561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShiftExpression_in_entryRuleShiftExpression3600 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleShiftExpression3610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleShiftExpression3669 = new BitSet(new long[]{0x0003000000000002L});
    public static final BitSet FOLLOW_ruleShiftOperator_in_ruleShiftExpression3708 = new BitSet(new long[]{0x018C0000000503F0L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleShiftExpression3746 = new BitSet(new long[]{0x0003000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression3785 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpression3795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression3854 = new BitSet(new long[]{0x000C000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_ruleAdditiveExpression3893 = new BitSet(new long[]{0x018C0000000503F0L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression3931 = new BitSet(new long[]{0x000C000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression3970 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpression3980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression4039 = new BitSet(new long[]{0x0070000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_ruleMultiplicativeExpression4078 = new BitSet(new long[]{0x018C0000000503F0L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression4116 = new BitSet(new long[]{0x0070000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression4155 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryExpression4165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_ruleUnaryExpression4224 = new BitSet(new long[]{0x00000000000503F0L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleUnaryExpression4263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression4300 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression4310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableReference_in_rulePrimaryExpression4357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralValue_in_rulePrimaryExpression4384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rulePrimaryExpression4399 = new BitSet(new long[]{0x018C0000000503F0L});
    public static final BitSet FOLLOW_ruleNestedExpression_in_rulePrimaryExpression4421 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_rulePrimaryExpression4429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNestedExpression_in_entryRuleNestedExpression4463 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNestedExpression4473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_ruleNestedExpression4531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralValue_in_entryRuleLiteralValue4567 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralValue4577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleLiteralValue4635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral4672 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral4683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEX_LITERAL_in_ruleLiteral4723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BOOLEAN_LITERAL_in_ruleLiteral4749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleLiteral4775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleLiteral4801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_FLOATING_POINT_LITERAL_in_ruleLiteral4827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleTimeUnit4884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleTimeUnit4899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleTimeUnit4914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleAssignmentOperator4957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleAssignmentOperator4972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleAssignmentOperator4987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleAssignmentOperator5002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleAssignmentOperator5017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleAssignmentOperator5032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleAssignmentOperator5047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleAssignmentOperator5062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleAssignmentOperator5077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleAssignmentOperator5092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleAssignmentOperator5107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleEqualityOperator5150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleEqualityOperator5165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleRelationalOperator5208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleRelationalOperator5223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleRelationalOperator5238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleRelationalOperator5253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleShiftOperator5296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleShiftOperator5311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleAdditiveOperator5354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleAdditiveOperator5369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleMultiplicativeOperator5412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleMultiplicativeOperator5427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleMultiplicativeOperator5442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleUnaryOperator5485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleUnaryOperator5500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleUnaryOperator5515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleUnaryOperator5530 = new BitSet(new long[]{0x0000000000000002L});

}