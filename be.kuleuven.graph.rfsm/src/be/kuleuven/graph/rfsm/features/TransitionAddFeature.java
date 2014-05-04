package be.kuleuven.graph.rfsm.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

import be.kuleuven.model.rfsm.Transition;

public class TransitionAddFeature extends AbstractAddFeature {

	private static final IColorConstant BLUISH_COLOR = new ColorConstant(
			98, 131, 167);

	public TransitionAddFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canAdd(IAddContext context) {
		if (context instanceof IAddConnectionContext
				&& context.getNewObject() instanceof Transition) {
			return true;
		}
		return false;
	}

	@Override
	public PictogramElement add(IAddContext context) {
		IAddConnectionContext addConContext = (IAddConnectionContext) context;
		Transition transition = (Transition) context.getNewObject();
		IPeCreateService peCreateService = Graphiti.getPeCreateService();

		Connection connection = peCreateService
				.createFreeFormConnection(getDiagram());
		connection.setStart(addConContext.getSourceAnchor());
		connection.setEnd(addConContext.getTargetAnchor());

		IGaService gaService = Graphiti.getGaService();
		Polyline polyline = gaService.createPolyline(connection);
		polyline.setLineWidth(2);
		polyline.setForeground(manageColor(BLUISH_COLOR));

		link(connection, transition);
		
	     ConnectionDecorator textDecorator =
	         peCreateService.createConnectionDecorator(connection, true,
	         0.5, true);
	     Text text = gaService.createDefaultText(getDiagram(),textDecorator);
	     text.setForeground(manageColor(IColorConstant.BLACK));
	     gaService.setLocation(text, 10, 0);
	     text.setValue(transition.getName());

	     ConnectionDecorator cd;
	     cd = peCreateService
	           .createConnectionDecorator(connection, false, 1.0, true);
	     createArrow(cd);

		return connection;
	}
	
	private Polyline createArrow(GraphicsAlgorithmContainer gaContainer) {
	    IGaService gaService = Graphiti.getGaService();
	    Polyline polyline =
	        gaService.createPolyline(gaContainer, new int[] { -15, 10, 0, 0, -15,
	                -10 });
	    polyline.setForeground(manageColor(BLUISH_COLOR));
	    polyline.setLineWidth(2);
	    return polyline;
	} 
	
}
