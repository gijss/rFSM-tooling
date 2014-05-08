/*
* generated by Xtext
*/
grammar InternalRFSM;

options {
	superClass=AbstractInternalAntlrParser;
	
}

@lexer::header {
package be.kuleuven.dsl.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package be.kuleuven.dsl.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import be.kuleuven.dsl.services.RFSMGrammarAccess;

}

@parser::members {

 	private RFSMGrammarAccess grammarAccess;
 	
    public InternalRFSMParser(TokenStream input, RFSMGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "RfsmGraph";	
   	}
   	
   	@Override
   	protected RFSMGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRuleRfsmGraph
entryRuleRfsmGraph returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getRfsmGraphRule()); }
	 iv_ruleRfsmGraph=ruleRfsmGraph 
	 { $current=$iv_ruleRfsmGraph.current; } 
	 EOF 
;

// Rule RfsmGraph
ruleRfsmGraph returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((	otherlv_0='[RfsmGraphName:' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getRfsmGraphAccess().getRfsmGraphNameKeyword_0_0());
    }
(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getRfsmGraphAccess().getNameIDTerminalRuleCall_0_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getRfsmGraphRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"ID");
	    }

)
)	otherlv_2=']' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getRfsmGraphAccess().getRightSquareBracketKeyword_0_2());
    }
)?(
(
		{ 
	        newCompositeNode(grammarAccess.getRfsmGraphAccess().getRootStateStateParserRuleCall_1_0()); 
	    }
		lv_rootState_3_0=ruleState		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getRfsmGraphRule());
	        }
       		set(
       			$current, 
       			"rootState",
        		lv_rootState_3_0, 
        		"State");
	        afterParserOrEnumRuleCall();
	    }

)
)?(
(
		{ 
	        newCompositeNode(grammarAccess.getRfsmGraphAccess().getTransitionsTransitionParserRuleCall_2_0()); 
	    }
		lv_transitions_4_0=ruleTransition		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getRfsmGraphRule());
	        }
       		add(
       			$current, 
       			"transitions",
        		lv_transitions_4_0, 
        		"Transition");
	        afterParserOrEnumRuleCall();
	    }

)
)*)
;





// Entry rule entryRuleState
entryRuleState returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getStateRule()); }
	 iv_ruleState=ruleState 
	 { $current=$iv_ruleState.current; } 
	 EOF 
;

// Rule State
ruleState returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='state' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getStateAccess().getStateKeyword_0());
    }
(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getStateAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getStateRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"ID");
	    }

)
)	otherlv_2='{' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getStateAccess().getLeftCurlyBracketKeyword_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getStateAccess().getStatesStateParserRuleCall_3_0()); 
	    }
		lv_states_3_0=ruleState		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getStateRule());
	        }
       		add(
       			$current, 
       			"states",
        		lv_states_3_0, 
        		"State");
	        afterParserOrEnumRuleCall();
	    }

)
)*(	otherlv_4='entry:' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getStateAccess().getEntryKeyword_4_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getStateAccess().getEntryFunctionParserRuleCall_4_1_0()); 
	    }
		lv_entry_5_0=ruleFunction		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getStateRule());
	        }
       		set(
       			$current, 
       			"entry",
        		lv_entry_5_0, 
        		"Function");
	        afterParserOrEnumRuleCall();
	    }

)
))?(	otherlv_6='doo:' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getStateAccess().getDooKeyword_5_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getStateAccess().getDooFunctionParserRuleCall_5_1_0()); 
	    }
		lv_doo_7_0=ruleFunction		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getStateRule());
	        }
       		set(
       			$current, 
       			"doo",
        		lv_doo_7_0, 
        		"Function");
	        afterParserOrEnumRuleCall();
	    }

)
))?(	otherlv_8='exit:' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getStateAccess().getExitKeyword_6_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getStateAccess().getExitFunctionParserRuleCall_6_1_0()); 
	    }
		lv_exit_9_0=ruleFunction		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getStateRule());
	        }
       		set(
       			$current, 
       			"exit",
        		lv_exit_9_0, 
        		"Function");
	        afterParserOrEnumRuleCall();
	    }

)
))?	otherlv_10='}' 
    {
    	newLeafNode(otherlv_10, grammarAccess.getStateAccess().getRightCurlyBracketKeyword_7());
    }
)
;





// Entry rule entryRuleTransition
entryRuleTransition returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getTransitionRule()); }
	 iv_ruleTransition=ruleTransition 
	 { $current=$iv_ruleTransition.current; } 
	 EOF 
;

// Rule Transition
ruleTransition returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='transition' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getTransitionAccess().getTransitionKeyword_0());
    }
(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getTransitionAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getTransitionRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"ID");
	    }

)
)?	otherlv_2='from' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getTransitionAccess().getFromKeyword_2());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getTransitionRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getTransitionAccess().getSourceStateCrossReference_3_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_4='to' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getTransitionAccess().getToKeyword_4());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getTransitionRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getTransitionAccess().getTargetStateCrossReference_5_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getTransitionAccess().getEventsEventParserRuleCall_6_0()); 
	    }
		lv_events_6_0=ruleEvent		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTransitionRule());
	        }
       		add(
       			$current, 
       			"events",
        		lv_events_6_0, 
        		"Event");
	        afterParserOrEnumRuleCall();
	    }

)
)*(	otherlv_7='priority' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getTransitionAccess().getPriorityKeyword_7_0());
    }
(
(
		lv_priorityNumber_8_0=RULE_INT
		{
			newLeafNode(lv_priorityNumber_8_0, grammarAccess.getTransitionAccess().getPriorityNumberINTTerminalRuleCall_7_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getTransitionRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"priorityNumber",
        		lv_priorityNumber_8_0, 
        		"INT");
	    }

)
))?)
;





// Entry rule entryRuleEvent
entryRuleEvent returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getEventRule()); }
	 iv_ruleEvent=ruleEvent 
	 { $current=$iv_ruleEvent.current; } 
	 EOF 
;

// Rule Event
ruleEvent returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((	otherlv_0='[EventName:' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getEventAccess().getEventNameKeyword_0_0());
    }
(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getEventAccess().getNameIDTerminalRuleCall_0_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getEventRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"ID");
	    }

)
)	otherlv_2=']' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getEventAccess().getRightSquareBracketKeyword_0_2());
    }
)?	otherlv_3='onevent' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getEventAccess().getOneventKeyword_1());
    }
(
(
		lv_event_4_0=RULE_STRING
		{
			newLeafNode(lv_event_4_0, grammarAccess.getEventAccess().getEventSTRINGTerminalRuleCall_2_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getEventRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"event",
        		lv_event_4_0, 
        		"STRING");
	    }

)
))
;





// Entry rule entryRuleFunction
entryRuleFunction returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getFunctionRule()); }
	 iv_ruleFunction=ruleFunction 
	 { $current=$iv_ruleFunction.current; } 
	 EOF 
;

// Rule Function
ruleFunction returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((	otherlv_0='[FunctionName:' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getFunctionAccess().getFunctionNameKeyword_0_0());
    }
(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getFunctionAccess().getNameIDTerminalRuleCall_0_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getFunctionRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"ID");
	    }

)
)	otherlv_2=']' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getFunctionAccess().getRightSquareBracketKeyword_0_2());
    }
)?(
(
		lv_call_3_0=RULE_STRING
		{
			newLeafNode(lv_call_3_0, grammarAccess.getFunctionAccess().getCallSTRINGTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getFunctionRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"call",
        		lv_call_3_0, 
        		"STRING");
	    }

)
))
;





// Entry rule entryRuleQualifiedName
entryRuleQualifiedName returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getQualifiedNameRule()); } 
	 iv_ruleQualifiedName=ruleQualifiedName 
	 { $current=$iv_ruleQualifiedName.current.getText(); }  
	 EOF 
;

// Rule QualifiedName
ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(    this_ID_0=RULE_ID    {
		$current.merge(this_ID_0);
    }

    { 
    newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
    }
(
	kw='.' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
    }
    this_ID_2=RULE_ID    {
		$current.merge(this_ID_2);
    }

    { 
    newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
    }
)*)
    ;





RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


