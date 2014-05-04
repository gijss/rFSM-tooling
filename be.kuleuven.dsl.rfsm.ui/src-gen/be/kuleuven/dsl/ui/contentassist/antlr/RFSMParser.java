/*
* generated by Xtext
*/
package be.kuleuven.dsl.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import be.kuleuven.dsl.services.RFSMGrammarAccess;

public class RFSMParser extends AbstractContentAssistParser {
	
	@Inject
	private RFSMGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected be.kuleuven.dsl.ui.contentassist.antlr.internal.InternalRFSMParser createParser() {
		be.kuleuven.dsl.ui.contentassist.antlr.internal.InternalRFSMParser result = new be.kuleuven.dsl.ui.contentassist.antlr.internal.InternalRFSMParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getRfsmGraphAccess().getGroup(), "rule__RfsmGraph__Group__0");
					put(grammarAccess.getStateAccess().getGroup(), "rule__State__Group__0");
					put(grammarAccess.getStateAccess().getGroup_4(), "rule__State__Group_4__0");
					put(grammarAccess.getStateAccess().getGroup_5(), "rule__State__Group_5__0");
					put(grammarAccess.getStateAccess().getGroup_6(), "rule__State__Group_6__0");
					put(grammarAccess.getTransitionAccess().getGroup(), "rule__Transition__Group__0");
					put(grammarAccess.getTransitionAccess().getGroup_6(), "rule__Transition__Group_6__0");
					put(grammarAccess.getEventAccess().getGroup(), "rule__Event__Group__0");
					put(grammarAccess.getQualifiedNameAccess().getGroup(), "rule__QualifiedName__Group__0");
					put(grammarAccess.getQualifiedNameAccess().getGroup_1(), "rule__QualifiedName__Group_1__0");
					put(grammarAccess.getRfsmGraphAccess().getNameAssignment_1(), "rule__RfsmGraph__NameAssignment_1");
					put(grammarAccess.getRfsmGraphAccess().getRootStateAssignment_3(), "rule__RfsmGraph__RootStateAssignment_3");
					put(grammarAccess.getRfsmGraphAccess().getTransitionsAssignment_4(), "rule__RfsmGraph__TransitionsAssignment_4");
					put(grammarAccess.getStateAccess().getNameAssignment_1(), "rule__State__NameAssignment_1");
					put(grammarAccess.getStateAccess().getStatesAssignment_3(), "rule__State__StatesAssignment_3");
					put(grammarAccess.getStateAccess().getEntryAssignment_4_1(), "rule__State__EntryAssignment_4_1");
					put(grammarAccess.getStateAccess().getDooAssignment_5_1(), "rule__State__DooAssignment_5_1");
					put(grammarAccess.getStateAccess().getExitAssignment_6_1(), "rule__State__ExitAssignment_6_1");
					put(grammarAccess.getTransitionAccess().getSourceAssignment_2(), "rule__Transition__SourceAssignment_2");
					put(grammarAccess.getTransitionAccess().getTargetAssignment_4(), "rule__Transition__TargetAssignment_4");
					put(grammarAccess.getTransitionAccess().getEventsAssignment_5(), "rule__Transition__EventsAssignment_5");
					put(grammarAccess.getTransitionAccess().getPriorityNumberAssignment_6_1(), "rule__Transition__PriorityNumberAssignment_6_1");
					put(grammarAccess.getEventAccess().getEventAssignment_1(), "rule__Event__EventAssignment_1");
					put(grammarAccess.getFunctionAccess().getCallAssignment(), "rule__Function__CallAssignment");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			be.kuleuven.dsl.ui.contentassist.antlr.internal.InternalRFSMParser typedParser = (be.kuleuven.dsl.ui.contentassist.antlr.internal.InternalRFSMParser) parser;
			typedParser.entryRuleRfsmGraph();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public RFSMGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(RFSMGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
