package be.kuleuven.graph.rfsm.diagram;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;

import be.kuleuven.graph.rfsm.features.StateAddFeature;
import be.kuleuven.graph.rfsm.features.StateCreateFeature;
import be.kuleuven.graph.rfsm.features.StatelayoutFeature;
import be.kuleuven.graph.rfsm.features.TransitionAddFeature;
import be.kuleuven.graph.rfsm.features.TransitionCreateFeature;
import be.kuleuven.model.rfsm.State;
import be.kuleuven.model.rfsm.Transition;

public class RfsmFeatureProvider extends DefaultFeatureProvider {

	public RfsmFeatureProvider(IDiagramTypeProvider dtp) {
		super(dtp);
	}

	@Override
	public IAddFeature getAddFeature(IAddContext context) {
	    if (context.getNewObject() instanceof State) {
	        return new StateAddFeature(this);
	    } else if (context.getNewObject() instanceof Transition){
	    	return new TransitionAddFeature(this);
	    }
	    return super.getAddFeature(context);
	}

	@Override
	public ICreateFeature[] getCreateFeatures() {
		return new ICreateFeature[] { new StateCreateFeature(this) };
	}

	@Override
	public ILayoutFeature getLayoutFeature(ILayoutContext context) {
		PictogramElement pictogramElement = context.getPictogramElement();
	    Object bo = getBusinessObjectForPictogramElement(pictogramElement);
	    if (bo instanceof State) {
	    	return new StatelayoutFeature(this);
	    }
		return super.getLayoutFeature(context);
	}

	@Override
	public ICreateConnectionFeature[] getCreateConnectionFeatures() {
		return new ICreateConnectionFeature[] { new TransitionCreateFeature(this)};
	}
	
}
