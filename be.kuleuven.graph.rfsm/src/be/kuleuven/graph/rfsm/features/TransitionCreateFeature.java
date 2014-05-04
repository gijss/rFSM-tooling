package be.kuleuven.graph.rfsm.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import be.kuleuven.model.rfsm.RfsmFactory;
import be.kuleuven.model.rfsm.RfsmGraph;
import be.kuleuven.model.rfsm.State;
import be.kuleuven.model.rfsm.Transition;

public class TransitionCreateFeature extends AbstractCreateConnectionFeature {

	private static int counter = 0;

	public TransitionCreateFeature(IFeatureProvider fp) {
		super(fp, "Tansition", "Create a Transition");
	}

	@Override
	public boolean canCreate(ICreateConnectionContext context) {
		Anchor sourceAnchor = context.getSourceAnchor();
		Anchor targetAnchor = context.getTargetAnchor();
		if (sourceAnchor != null && targetAnchor != null) {
			AnchorContainer sourceParent = sourceAnchor.getParent();
			if (sourceParent != null
					&& sourceParent.equals(targetAnchor.getParent())) {
				return false;
			}
		}
		PictogramElement sourcePe = context.getSourcePictogramElement();
		PictogramElement targetPe = context.getTargetPictogramElement();
		
		if (sourcePe != null && sourcePe.equals(targetPe)) {
			return false;
		}

		Object sourceBo = getBusinessObjectForPictogramElement(sourcePe);
		Object targetBo = getBusinessObjectForPictogramElement(targetPe);
		if ((sourceBo instanceof State) & (targetBo instanceof State)) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean canStartConnection(ICreateConnectionContext context) {
		if (context.getSourceAnchor() != null) {
			return true;
		}
		return false;
	}

	@Override
	public Connection create(ICreateConnectionContext context) {
		
		PictogramElement sourcePe = context.getSourcePictogramElement();
		PictogramElement targetPe = context.getTargetPictogramElement();
		Object sourceBo = getBusinessObjectForPictogramElement(sourcePe);
		Object targetBo = getBusinessObjectForPictogramElement(targetPe);

		Connection newConnection = null;
		if ((sourceBo instanceof State) & (targetBo instanceof State)) {
			newConnection = createStateToStateTransition(context);
		}
		
		return newConnection;
	}

	private Connection createStateToStateTransition(
			ICreateConnectionContext context) {
		State source = getState(context.getSourceAnchor());
		State target = getState(context.getTargetAnchor());

		Connection newConnection = null;
		if (source != null && target != null) {
			Transition transtiion = createTransition(source, target);
			addTransitionToHyperGraph(transtiion);
			AddConnectionContext addContext = new AddConnectionContext(
					context.getSourceAnchor(), context.getTargetAnchor());
			addContext.setNewObject(transtiion);
			newConnection = (Connection) getFeatureProvider().addIfPossible(
					addContext);
		}
		return newConnection;
	}

	private void addTransitionToHyperGraph(Transition transtiion) {
		RfsmGraph rfsmGraph = (RfsmGraph) getBusinessObjectForPictogramElement(getDiagram());
		rfsmGraph.getTransitions().add(transtiion);
	}

	private State getState(Anchor anchor) {
		if (anchor != null) {
			Object object = getBusinessObjectForPictogramElement(anchor
					.getParent());
			if (object instanceof State) {
				return (State) object;
			}
		}
		return null;
	}

	private Transition createTransition(State source, State target) {
		Transition transition = RfsmFactory.eINSTANCE.createTransition();
		transition.setName("Transtion_" + counter++);
		transition.getSource().add(source);
		transition.getTarget().add(target);
		return transition;
	}

}
