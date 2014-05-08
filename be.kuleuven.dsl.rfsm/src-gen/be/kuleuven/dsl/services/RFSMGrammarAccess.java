/*
* generated by Xtext
*/
package be.kuleuven.dsl.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.eclipse.xtext.common.services.TerminalsGrammarAccess;

@Singleton
public class RFSMGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class RfsmGraphElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "RfsmGraph");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cRootStateAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cRootStateStateParserRuleCall_0_0 = (RuleCall)cRootStateAssignment_0.eContents().get(0);
		private final Assignment cTransitionsAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cTransitionsTransitionParserRuleCall_1_0 = (RuleCall)cTransitionsAssignment_1.eContents().get(0);
		
		//RfsmGraph:
		//	rootState= //can have only one root state
		//	State //(hyperEdges += Connector)*
		//	transitions+=Transition*;
		public ParserRule getRule() { return rule; }

		//rootState= //can have only one root state
		//State //(hyperEdges += Connector)*
		//transitions+=Transition*
		public Group getGroup() { return cGroup; }

		//rootState= //can have only one root state
		//State
		public Assignment getRootStateAssignment_0() { return cRootStateAssignment_0; }

		////can have only one root state
		//State
		public RuleCall getRootStateStateParserRuleCall_0_0() { return cRootStateStateParserRuleCall_0_0; }

		//transitions+=Transition*
		public Assignment getTransitionsAssignment_1() { return cTransitionsAssignment_1; }

		//Transition
		public RuleCall getTransitionsTransitionParserRuleCall_1_0() { return cTransitionsTransitionParserRuleCall_1_0; }
	}

	public class StateElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "State");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cStateKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cStatesAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cStatesStateParserRuleCall_3_0 = (RuleCall)cStatesAssignment_3.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cEntryKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cEntryAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cEntryFunctionParserRuleCall_4_1_0 = (RuleCall)cEntryAssignment_4_1.eContents().get(0);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cDooKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Assignment cDooAssignment_5_1 = (Assignment)cGroup_5.eContents().get(1);
		private final RuleCall cDooFunctionParserRuleCall_5_1_0 = (RuleCall)cDooAssignment_5_1.eContents().get(0);
		private final Group cGroup_6 = (Group)cGroup.eContents().get(6);
		private final Keyword cExitKeyword_6_0 = (Keyword)cGroup_6.eContents().get(0);
		private final Assignment cExitAssignment_6_1 = (Assignment)cGroup_6.eContents().get(1);
		private final RuleCall cExitFunctionParserRuleCall_6_1_0 = (RuleCall)cExitAssignment_6_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_7 = (Keyword)cGroup.eContents().get(7);
		
		//State:
		//	"state" name=ID "{" states+=State* ("entry:" entry=Function)? ("doo:" doo=Function)? ("exit:" exit=Function)? "}";
		public ParserRule getRule() { return rule; }

		//"state" name=ID "{" states+=State* ("entry:" entry=Function)? ("doo:" doo=Function)? ("exit:" exit=Function)? "}"
		public Group getGroup() { return cGroup; }

		//"state"
		public Keyword getStateKeyword_0() { return cStateKeyword_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }

		//states+=State*
		public Assignment getStatesAssignment_3() { return cStatesAssignment_3; }

		//State
		public RuleCall getStatesStateParserRuleCall_3_0() { return cStatesStateParserRuleCall_3_0; }

		//("entry:" entry=Function)?
		public Group getGroup_4() { return cGroup_4; }

		//"entry:"
		public Keyword getEntryKeyword_4_0() { return cEntryKeyword_4_0; }

		//entry=Function
		public Assignment getEntryAssignment_4_1() { return cEntryAssignment_4_1; }

		//Function
		public RuleCall getEntryFunctionParserRuleCall_4_1_0() { return cEntryFunctionParserRuleCall_4_1_0; }

		//("doo:" doo=Function)?
		public Group getGroup_5() { return cGroup_5; }

		//"doo:"
		public Keyword getDooKeyword_5_0() { return cDooKeyword_5_0; }

		//doo=Function
		public Assignment getDooAssignment_5_1() { return cDooAssignment_5_1; }

		//Function
		public RuleCall getDooFunctionParserRuleCall_5_1_0() { return cDooFunctionParserRuleCall_5_1_0; }

		//("exit:" exit=Function)?
		public Group getGroup_6() { return cGroup_6; }

		//"exit:"
		public Keyword getExitKeyword_6_0() { return cExitKeyword_6_0; }

		//exit=Function
		public Assignment getExitAssignment_6_1() { return cExitAssignment_6_1; }

		//Function
		public RuleCall getExitFunctionParserRuleCall_6_1_0() { return cExitFunctionParserRuleCall_6_1_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_7() { return cRightCurlyBracketKeyword_7; }
	}

	public class TransitionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Transition");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cTransitionKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cFromKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cSourceAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cSourceStateCrossReference_3_0 = (CrossReference)cSourceAssignment_3.eContents().get(0);
		private final RuleCall cSourceStateQualifiedNameParserRuleCall_3_0_1 = (RuleCall)cSourceStateCrossReference_3_0.eContents().get(1);
		private final Keyword cToKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cTargetAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final CrossReference cTargetStateCrossReference_5_0 = (CrossReference)cTargetAssignment_5.eContents().get(0);
		private final RuleCall cTargetStateQualifiedNameParserRuleCall_5_0_1 = (RuleCall)cTargetStateCrossReference_5_0.eContents().get(1);
		private final Assignment cEventsAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final RuleCall cEventsEventParserRuleCall_6_0 = (RuleCall)cEventsAssignment_6.eContents().get(0);
		private final Group cGroup_7 = (Group)cGroup.eContents().get(7);
		private final Keyword cPriorityKeyword_7_0 = (Keyword)cGroup_7.eContents().get(0);
		private final Assignment cPriorityNumberAssignment_7_1 = (Assignment)cGroup_7.eContents().get(1);
		private final RuleCall cPriorityNumberINTTerminalRuleCall_7_1_0 = (RuleCall)cPriorityNumberAssignment_7_1.eContents().get(0);
		
		//Transition:
		//	"transition" name=ID? "from" source+=[State|QualifiedName] "to" target+=[State|QualifiedName] events+=Event*
		//	("priority" priorityNumber=INT)?;
		public ParserRule getRule() { return rule; }

		//"transition" name=ID? "from" source+=[State|QualifiedName] "to" target+=[State|QualifiedName] events+=Event* ("priority"
		//priorityNumber=INT)?
		public Group getGroup() { return cGroup; }

		//"transition"
		public Keyword getTransitionKeyword_0() { return cTransitionKeyword_0; }

		//name=ID?
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//"from"
		public Keyword getFromKeyword_2() { return cFromKeyword_2; }

		//source+=[State|QualifiedName]
		public Assignment getSourceAssignment_3() { return cSourceAssignment_3; }

		//[State|QualifiedName]
		public CrossReference getSourceStateCrossReference_3_0() { return cSourceStateCrossReference_3_0; }

		//QualifiedName
		public RuleCall getSourceStateQualifiedNameParserRuleCall_3_0_1() { return cSourceStateQualifiedNameParserRuleCall_3_0_1; }

		//"to"
		public Keyword getToKeyword_4() { return cToKeyword_4; }

		//target+=[State|QualifiedName]
		public Assignment getTargetAssignment_5() { return cTargetAssignment_5; }

		//[State|QualifiedName]
		public CrossReference getTargetStateCrossReference_5_0() { return cTargetStateCrossReference_5_0; }

		//QualifiedName
		public RuleCall getTargetStateQualifiedNameParserRuleCall_5_0_1() { return cTargetStateQualifiedNameParserRuleCall_5_0_1; }

		//events+=Event*
		public Assignment getEventsAssignment_6() { return cEventsAssignment_6; }

		//Event
		public RuleCall getEventsEventParserRuleCall_6_0() { return cEventsEventParserRuleCall_6_0; }

		//("priority" priorityNumber=INT)?
		public Group getGroup_7() { return cGroup_7; }

		//"priority"
		public Keyword getPriorityKeyword_7_0() { return cPriorityKeyword_7_0; }

		//priorityNumber=INT
		public Assignment getPriorityNumberAssignment_7_1() { return cPriorityNumberAssignment_7_1; }

		//INT
		public RuleCall getPriorityNumberINTTerminalRuleCall_7_1_0() { return cPriorityNumberINTTerminalRuleCall_7_1_0; }
	}

	public class EventElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Event");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cOneventKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cEventAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cEventSTRINGTerminalRuleCall_1_0 = (RuleCall)cEventAssignment_1.eContents().get(0);
		
		//Event:
		//	"onevent" event=STRING;
		public ParserRule getRule() { return rule; }

		//"onevent" event=STRING
		public Group getGroup() { return cGroup; }

		//"onevent"
		public Keyword getOneventKeyword_0() { return cOneventKeyword_0; }

		//event=STRING
		public Assignment getEventAssignment_1() { return cEventAssignment_1; }

		//STRING
		public RuleCall getEventSTRINGTerminalRuleCall_1_0() { return cEventSTRINGTerminalRuleCall_1_0; }
	}

	public class FunctionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Function");
		private final Assignment cCallAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cCallSTRINGTerminalRuleCall_0 = (RuleCall)cCallAssignment.eContents().get(0);
		
		//Function:
		//	call=STRING;
		public ParserRule getRule() { return rule; }

		//call=STRING
		public Assignment getCallAssignment() { return cCallAssignment; }

		//STRING
		public RuleCall getCallSTRINGTerminalRuleCall_0() { return cCallSTRINGTerminalRuleCall_0; }
	}

	public class QualifiedNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "QualifiedName");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cFullStopKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_1_1 = (RuleCall)cGroup_1.eContents().get(1);
		
		//QualifiedName:
		//	ID ("." ID)*;
		public ParserRule getRule() { return rule; }

		//ID ("." ID)*
		public Group getGroup() { return cGroup; }

		//ID
		public RuleCall getIDTerminalRuleCall_0() { return cIDTerminalRuleCall_0; }

		//("." ID)*
		public Group getGroup_1() { return cGroup_1; }

		//"."
		public Keyword getFullStopKeyword_1_0() { return cFullStopKeyword_1_0; }

		//ID
		public RuleCall getIDTerminalRuleCall_1_1() { return cIDTerminalRuleCall_1_1; }
	}
	
	
	private RfsmGraphElements pRfsmGraph;
	private StateElements pState;
	private TransitionElements pTransition;
	private EventElements pEvent;
	private FunctionElements pFunction;
	private QualifiedNameElements pQualifiedName;
	
	private final Grammar grammar;

	private TerminalsGrammarAccess gaTerminals;

	@Inject
	public RFSMGrammarAccess(GrammarProvider grammarProvider,
		TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaTerminals = gaTerminals;
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("be.kuleuven.dsl.RFSM".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	
	public Grammar getGrammar() {
		return grammar;
	}
	

	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	//RfsmGraph:
	//	rootState= //can have only one root state
	//	State //(hyperEdges += Connector)*
	//	transitions+=Transition*;
	public RfsmGraphElements getRfsmGraphAccess() {
		return (pRfsmGraph != null) ? pRfsmGraph : (pRfsmGraph = new RfsmGraphElements());
	}
	
	public ParserRule getRfsmGraphRule() {
		return getRfsmGraphAccess().getRule();
	}

	//State:
	//	"state" name=ID "{" states+=State* ("entry:" entry=Function)? ("doo:" doo=Function)? ("exit:" exit=Function)? "}";
	public StateElements getStateAccess() {
		return (pState != null) ? pState : (pState = new StateElements());
	}
	
	public ParserRule getStateRule() {
		return getStateAccess().getRule();
	}

	//Transition:
	//	"transition" name=ID? "from" source+=[State|QualifiedName] "to" target+=[State|QualifiedName] events+=Event*
	//	("priority" priorityNumber=INT)?;
	public TransitionElements getTransitionAccess() {
		return (pTransition != null) ? pTransition : (pTransition = new TransitionElements());
	}
	
	public ParserRule getTransitionRule() {
		return getTransitionAccess().getRule();
	}

	//Event:
	//	"onevent" event=STRING;
	public EventElements getEventAccess() {
		return (pEvent != null) ? pEvent : (pEvent = new EventElements());
	}
	
	public ParserRule getEventRule() {
		return getEventAccess().getRule();
	}

	//Function:
	//	call=STRING;
	public FunctionElements getFunctionAccess() {
		return (pFunction != null) ? pFunction : (pFunction = new FunctionElements());
	}
	
	public ParserRule getFunctionRule() {
		return getFunctionAccess().getRule();
	}

	//QualifiedName:
	//	ID ("." ID)*;
	public QualifiedNameElements getQualifiedNameAccess() {
		return (pQualifiedName != null) ? pQualifiedName : (pQualifiedName = new QualifiedNameElements());
	}
	
	public ParserRule getQualifiedNameRule() {
		return getQualifiedNameAccess().getRule();
	}

	//terminal ID returns ecore::EString:
	//	"^"? ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	} 

	//terminal INT returns ecore::EInt:
	//	"0".."9"+;
	public TerminalRule getINTRule() {
		return gaTerminals.getINTRule();
	} 

	//terminal STRING returns ecore::EString:
	//	"\"" ("\\" ("b" | "t" | "n" | "f" | "r" | "u" | "\"" | "\'" | "\\") | !("\\" | "\""))* "\"" | "\'" ("\\" ("b" | "t" |
	//	"n" | "f" | "r" | "u" | "\"" | "\'" | "\\") | !("\\" | "\'"))* "\'";
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	} 

	//terminal ML_COMMENT returns ecore::EString:
	//	"/ *"->"* /";
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	} 

	//terminal SL_COMMENT returns ecore::EString:
	//	"//" !("\n" | "\r")* ("\r"? "\n")?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	} 

	//terminal WS returns ecore::EString:
	//	(" " | "\t" | "\r" | "\n")+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	} 

	//terminal ANY_OTHER returns ecore::EString:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	} 
}
