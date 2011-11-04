/*
* generated by Xtext
*/

package org.yakindu.sct.generator.model.base.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.eclipse.xtext.common.services.TerminalsGrammarAccess;

@Singleton
public class BaseGenGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class BaseGeneratorModelElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "BaseGeneratorModel");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cBaseGeneratorKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cStatechartReferencesAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cStatechartReferencesStatechartReferencesParserRuleCall_2_0 = (RuleCall)cStatechartReferencesAssignment_2.eContents().get(0);
		private final Assignment cConfigurationAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cConfigurationGeneratorConfigurationParserRuleCall_3_0 = (RuleCall)cConfigurationAssignment_3.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		/// **
		// * @author Andreas Muelder
		// * / BaseGeneratorModel returns gen::GeneratorModel:
		//	"BaseGenerator" "{" statechartReferences=StatechartReferences configuration=GeneratorConfiguration "}";
		public ParserRule getRule() { return rule; }

		//"BaseGenerator" "{" statechartReferences=StatechartReferences configuration=GeneratorConfiguration "}"
		public Group getGroup() { return cGroup; }

		//"BaseGenerator"
		public Keyword getBaseGeneratorKeyword_0() { return cBaseGeneratorKeyword_0; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_1() { return cLeftCurlyBracketKeyword_1; }

		//statechartReferences=StatechartReferences
		public Assignment getStatechartReferencesAssignment_2() { return cStatechartReferencesAssignment_2; }

		//StatechartReferences
		public RuleCall getStatechartReferencesStatechartReferencesParserRuleCall_2_0() { return cStatechartReferencesStatechartReferencesParserRuleCall_2_0; }

		//configuration=GeneratorConfiguration
		public Assignment getConfigurationAssignment_3() { return cConfigurationAssignment_3; }

		//GeneratorConfiguration
		public RuleCall getConfigurationGeneratorConfigurationParserRuleCall_3_0() { return cConfigurationGeneratorConfigurationParserRuleCall_3_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_4() { return cRightCurlyBracketKeyword_4; }
	}

	public class StatechartReferencesElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "StatechartReferences");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cStatechartsKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cStatechartsAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cStatechartsStatechartCrossReference_2_0 = (CrossReference)cStatechartsAssignment_2.eContents().get(0);
		private final RuleCall cStatechartsStatechartIDTerminalRuleCall_2_0_1 = (RuleCall)cStatechartsStatechartCrossReference_2_0.eContents().get(1);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cCommaKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cStatechartsAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final CrossReference cStatechartsStatechartCrossReference_3_1_0 = (CrossReference)cStatechartsAssignment_3_1.eContents().get(0);
		private final RuleCall cStatechartsStatechartIDTerminalRuleCall_3_1_0_1 = (RuleCall)cStatechartsStatechartCrossReference_3_1_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//StatechartReferences returns gen::StatechartReferences:
		//	"statecharts " "{" statecharts+=[sct::Statechart]+ ("," statecharts+=[sct::Statechart])* "}";
		public ParserRule getRule() { return rule; }

		//"statecharts " "{" statecharts+=[sct::Statechart]+ ("," statecharts+=[sct::Statechart])* "}"
		public Group getGroup() { return cGroup; }

		//"statecharts "
		public Keyword getStatechartsKeyword_0() { return cStatechartsKeyword_0; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_1() { return cLeftCurlyBracketKeyword_1; }

		//statecharts+=[sct::Statechart]+
		public Assignment getStatechartsAssignment_2() { return cStatechartsAssignment_2; }

		//[sct::Statechart]
		public CrossReference getStatechartsStatechartCrossReference_2_0() { return cStatechartsStatechartCrossReference_2_0; }

		//ID
		public RuleCall getStatechartsStatechartIDTerminalRuleCall_2_0_1() { return cStatechartsStatechartIDTerminalRuleCall_2_0_1; }

		//("," statecharts+=[sct::Statechart])*
		public Group getGroup_3() { return cGroup_3; }

		//","
		public Keyword getCommaKeyword_3_0() { return cCommaKeyword_3_0; }

		//statecharts+=[sct::Statechart]
		public Assignment getStatechartsAssignment_3_1() { return cStatechartsAssignment_3_1; }

		//[sct::Statechart]
		public CrossReference getStatechartsStatechartCrossReference_3_1_0() { return cStatechartsStatechartCrossReference_3_1_0; }

		//ID
		public RuleCall getStatechartsStatechartIDTerminalRuleCall_3_1_0_1() { return cStatechartsStatechartIDTerminalRuleCall_3_1_0_1; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_4() { return cRightCurlyBracketKeyword_4; }
	}

	public class GeneratorConfigurationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "GeneratorConfiguration");
		private final Assignment cConfigurationsAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cConfigurationsConfigurationsParserRuleCall_0 = (RuleCall)cConfigurationsAssignment.eContents().get(0);
		
		//GeneratorConfiguration returns gen::GeneratorConfiguration:
		//	configurations+=Configurations+;
		public ParserRule getRule() { return rule; }

		//configurations+=Configurations+
		public Assignment getConfigurationsAssignment() { return cConfigurationsAssignment; }

		//Configurations
		public RuleCall getConfigurationsConfigurationsParserRuleCall_0() { return cConfigurationsConfigurationsParserRuleCall_0; }
	}

	public class ConfigurationsElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Configurations");
		private final RuleCall cOutletConfigurationParserRuleCall = (RuleCall)rule.eContents().get(1);
		
		//Configurations returns gen::Configuration:
		//	OutletConfiguration;
		public ParserRule getRule() { return rule; }

		//OutletConfiguration
		public RuleCall getOutletConfigurationParserRuleCall() { return cOutletConfigurationParserRuleCall; }
	}

	public class OutletConfigurationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "OutletConfiguration");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cOutletConfigurationCustomAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cOutletKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cProjectNameKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Keyword cEqualsSignKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cProjectNameAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cProjectNameSTRINGTerminalRuleCall_5_0 = (RuleCall)cProjectNameAssignment_5.eContents().get(0);
		private final Keyword cFolderKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Keyword cEqualsSignKeyword_7 = (Keyword)cGroup.eContents().get(7);
		private final Assignment cTargetFolderAssignment_8 = (Assignment)cGroup.eContents().get(8);
		private final RuleCall cTargetFolderSTRINGTerminalRuleCall_8_0 = (RuleCall)cTargetFolderAssignment_8.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_9 = (Keyword)cGroup.eContents().get(9);
		
		//OutletConfiguration returns gen::OutletConfiguration:
		//	{OutletConfigurationCustom} "outlet" "{" "projectName" "=" projectName=STRING "folder" "=" targetFolder=STRING "}";
		public ParserRule getRule() { return rule; }

		//{OutletConfigurationCustom} "outlet" "{" "projectName" "=" projectName=STRING "folder" "=" targetFolder=STRING "}"
		public Group getGroup() { return cGroup; }

		//{OutletConfigurationCustom}
		public Action getOutletConfigurationCustomAction_0() { return cOutletConfigurationCustomAction_0; }

		//"outlet"
		public Keyword getOutletKeyword_1() { return cOutletKeyword_1; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }

		//"projectName"
		public Keyword getProjectNameKeyword_3() { return cProjectNameKeyword_3; }

		//"="
		public Keyword getEqualsSignKeyword_4() { return cEqualsSignKeyword_4; }

		//projectName=STRING
		public Assignment getProjectNameAssignment_5() { return cProjectNameAssignment_5; }

		//STRING
		public RuleCall getProjectNameSTRINGTerminalRuleCall_5_0() { return cProjectNameSTRINGTerminalRuleCall_5_0; }

		//"folder"
		public Keyword getFolderKeyword_6() { return cFolderKeyword_6; }

		//"="
		public Keyword getEqualsSignKeyword_7() { return cEqualsSignKeyword_7; }

		//targetFolder=STRING
		public Assignment getTargetFolderAssignment_8() { return cTargetFolderAssignment_8; }

		//STRING
		public RuleCall getTargetFolderSTRINGTerminalRuleCall_8_0() { return cTargetFolderSTRINGTerminalRuleCall_8_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_9() { return cRightCurlyBracketKeyword_9; }
	}
	
	
	private BaseGeneratorModelElements pBaseGeneratorModel;
	private StatechartReferencesElements pStatechartReferences;
	private GeneratorConfigurationElements pGeneratorConfiguration;
	private ConfigurationsElements pConfigurations;
	private OutletConfigurationElements pOutletConfiguration;
	
	private final GrammarProvider grammarProvider;

	private TerminalsGrammarAccess gaTerminals;

	@Inject
	public BaseGenGrammarAccess(GrammarProvider grammarProvider,
		TerminalsGrammarAccess gaTerminals) {
		this.grammarProvider = grammarProvider;
		this.gaTerminals = gaTerminals;
	}
	
	public Grammar getGrammar() {	
		return grammarProvider.getGrammar(this);
	}
	

	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	/// **
	// * @author Andreas Muelder
	// * / BaseGeneratorModel returns gen::GeneratorModel:
	//	"BaseGenerator" "{" statechartReferences=StatechartReferences configuration=GeneratorConfiguration "}";
	public BaseGeneratorModelElements getBaseGeneratorModelAccess() {
		return (pBaseGeneratorModel != null) ? pBaseGeneratorModel : (pBaseGeneratorModel = new BaseGeneratorModelElements());
	}
	
	public ParserRule getBaseGeneratorModelRule() {
		return getBaseGeneratorModelAccess().getRule();
	}

	//StatechartReferences returns gen::StatechartReferences:
	//	"statecharts " "{" statecharts+=[sct::Statechart]+ ("," statecharts+=[sct::Statechart])* "}";
	public StatechartReferencesElements getStatechartReferencesAccess() {
		return (pStatechartReferences != null) ? pStatechartReferences : (pStatechartReferences = new StatechartReferencesElements());
	}
	
	public ParserRule getStatechartReferencesRule() {
		return getStatechartReferencesAccess().getRule();
	}

	//GeneratorConfiguration returns gen::GeneratorConfiguration:
	//	configurations+=Configurations+;
	public GeneratorConfigurationElements getGeneratorConfigurationAccess() {
		return (pGeneratorConfiguration != null) ? pGeneratorConfiguration : (pGeneratorConfiguration = new GeneratorConfigurationElements());
	}
	
	public ParserRule getGeneratorConfigurationRule() {
		return getGeneratorConfigurationAccess().getRule();
	}

	//Configurations returns gen::Configuration:
	//	OutletConfiguration;
	public ConfigurationsElements getConfigurationsAccess() {
		return (pConfigurations != null) ? pConfigurations : (pConfigurations = new ConfigurationsElements());
	}
	
	public ParserRule getConfigurationsRule() {
		return getConfigurationsAccess().getRule();
	}

	//OutletConfiguration returns gen::OutletConfiguration:
	//	{OutletConfigurationCustom} "outlet" "{" "projectName" "=" projectName=STRING "folder" "=" targetFolder=STRING "}";
	public OutletConfigurationElements getOutletConfigurationAccess() {
		return (pOutletConfiguration != null) ? pOutletConfiguration : (pOutletConfiguration = new OutletConfigurationElements());
	}
	
	public ParserRule getOutletConfigurationRule() {
		return getOutletConfigurationAccess().getRule();
	}

	//terminal ID:
	//	"^"? ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	} 

	//terminal INT returns ecore::EInt:
	//	"0".."9"+;
	public TerminalRule getINTRule() {
		return gaTerminals.getINTRule();
	} 

	//terminal STRING:
	//	"\"" ("\\" ("b" | "t" | "n" | "f" | "r" | "u" | "\"" | "\'" | "\\") | !("\\" | "\""))* "\"" | "\'" ("\\" ("b" | "t" |
	//	"n" | "f" | "r" | "u" | "\"" | "\'" | "\\") | !("\\" | "\'"))* "\'";
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	} 

	//terminal ML_COMMENT:
	//	"/ *"->"* /";
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	} 

	//terminal SL_COMMENT:
	//	"//" !("\n" | "\r")* ("\r"? "\n")?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	} 

	//terminal WS:
	//	(" " | "\t" | "\r" | "\n")+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	} 

	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	} 
}
