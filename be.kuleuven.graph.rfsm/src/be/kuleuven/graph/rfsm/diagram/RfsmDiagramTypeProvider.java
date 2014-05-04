package be.kuleuven.graph.rfsm.diagram;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;

public class RfsmDiagramTypeProvider extends AbstractDiagramTypeProvider {

	public RfsmDiagramTypeProvider() {
		super();
		setFeatureProvider(new RfsmFeatureProvider(this));
	}

}
