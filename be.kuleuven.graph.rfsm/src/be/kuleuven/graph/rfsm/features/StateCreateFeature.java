package be.kuleuven.graph.rfsm.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;

import be.kuleuven.model.rfsm.RfsmFactory;
import be.kuleuven.model.rfsm.RfsmGraph;
import be.kuleuven.model.rfsm.State;

public class StateCreateFeature extends AbstractCreateFeature {

	private static int counter = 1;

	public StateCreateFeature(IFeatureProvider fp) {
        // set name and description of the creation feature
        super(fp, "State", "Create State");
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		ContainerShape targetContainer = context.getTargetContainer();
		if (targetContainer instanceof Diagram) {
			RfsmGraph rfsmGraph = (RfsmGraph) getBusinessObjectForPictogramElement(context
					.getTargetContainer());
			if (rfsmGraph.getRootState() == null) {
				return true;
			}
		}
		if (getBusinessObjectForPictogramElement(targetContainer) instanceof State) {
			return true;
		}
		return false;
	}

	@Override
	public Object[] create(ICreateContext context) {
		State state = RfsmFactory.eINSTANCE.createState();
		state.setName("State_" + counter++);

		final Object target = getBusinessObjectForPictogramElement(context
				.getTargetContainer());
		if (target instanceof RfsmGraph ) {
			RfsmGraph rfsmGraph = (RfsmGraph) target;
			if (rfsmGraph.getRootState() == null) {
				rfsmGraph.setRootState(state);
			}
		}
		if (target instanceof State) {
			State parentState = (State) target;
			parentState.getStates().add(state);
		}

		addGraphicalRepresentation(context, state);

		return new Object[] { state };
	}

}
