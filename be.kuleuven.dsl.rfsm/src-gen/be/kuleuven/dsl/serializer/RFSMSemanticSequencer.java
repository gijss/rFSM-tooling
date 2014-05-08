package be.kuleuven.dsl.serializer;

import be.kuleuven.dsl.services.RFSMGrammarAccess;
import be.kuleuven.model.rfsm.Event;
import be.kuleuven.model.rfsm.Function;
import be.kuleuven.model.rfsm.RfsmGraph;
import be.kuleuven.model.rfsm.RfsmPackage;
import be.kuleuven.model.rfsm.State;
import be.kuleuven.model.rfsm.Transition;
import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;

@SuppressWarnings("all")
public class RFSMSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private RFSMGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == RfsmPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case RfsmPackage.EVENT:
				if(context == grammarAccess.getEventRule()) {
					sequence_Event(context, (Event) semanticObject); 
					return; 
				}
				else break;
			case RfsmPackage.FUNCTION:
				if(context == grammarAccess.getFunctionRule()) {
					sequence_Function(context, (Function) semanticObject); 
					return; 
				}
				else break;
			case RfsmPackage.RFSM_GRAPH:
				if(context == grammarAccess.getRfsmGraphRule()) {
					sequence_RfsmGraph(context, (RfsmGraph) semanticObject); 
					return; 
				}
				else break;
			case RfsmPackage.STATE:
				if(context == grammarAccess.getStateRule()) {
					sequence_State(context, (State) semanticObject); 
					return; 
				}
				else break;
			case RfsmPackage.TRANSITION:
				if(context == grammarAccess.getTransitionRule()) {
					sequence_Transition(context, (Transition) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (name=ID? event=STRING)
	 */
	protected void sequence_Event(EObject context, Event semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID? call=STRING)
	 */
	protected void sequence_Function(EObject context, Function semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID? rootState=State transitions+=Transition*)
	 */
	protected void sequence_RfsmGraph(EObject context, RfsmGraph semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID states+=State* entry=Function? doo=Function? exit=Function?)
	 */
	protected void sequence_State(EObject context, State semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID? source+=[State|QualifiedName] target+=[State|QualifiedName] events+=Event* priorityNumber=INT?)
	 */
	protected void sequence_Transition(EObject context, Transition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
