package be.kuleuven.graph.rfsm.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

import be.kuleuven.model.rfsm.State;

public class StateAddFeature extends AbstractAddShapeFeature {
	
	private static final IColorConstant STATE_FOREGROUND = new ColorConstant(98, 131, 167);
	private static final IColorConstant STATE_BACKGROUND = new ColorConstant(187, 218, 247);

	public StateAddFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canAdd(IAddContext context) {
		if (context.getNewObject() instanceof State) {
			ContainerShape targetContainer = context.getTargetContainer();
			if (targetContainer instanceof Diagram) {
				return true;
			}
			if (getBusinessObjectForPictogramElement(targetContainer) instanceof State) {
				return true;
			}
		}
		return false;
	}

	@Override
	public PictogramElement add(IAddContext context) {
		State state = (State) context.getNewObject();
		int stateWidth = IPictogramConstants.STATE_DEFAULT_WIDTH;
		int stateHeight = IPictogramConstants.STATE_DEFAULT_HEIGHT;
		int textBoxHeight = IPictogramConstants.TEXT_BOX_HEIGHT;
		int bufferSpace = IPictogramConstants.BUFFER_SPACE;

		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		IGaService gaService = Graphiti.getGaService();
		ContainerShape targetDiagram = context.getTargetContainer();

		ContainerShape mainContainerShape = peCreateService.createContainerShape(targetDiagram, true);
		Rectangle invisibleRectangle = gaService.createInvisibleRectangle(mainContainerShape);
		gaService.setLocationAndSize(invisibleRectangle, context.getX(), context.getY(), stateWidth,
				stateHeight);

		RoundedRectangle stateRectangle = gaService.createRoundedRectangle(invisibleRectangle, 10, 10);
		stateRectangle.setLineWidth(2);
		gaService.setLocationAndSize(stateRectangle, 0, 0, stateWidth, stateHeight);
		stateRectangle.setLineVisible(true);
		stateRectangle.setBackground(manageColor(STATE_BACKGROUND));
		stateRectangle.setForeground(manageColor(STATE_FOREGROUND));
		stateRectangle.setFilled(true);
		link(mainContainerShape, state);

		Text stateText = gaService.createText(invisibleRectangle, state.getName());
		stateText.setForeground(manageColor(IColorConstant.BLACK));
		stateText.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		stateText.setFont(gaService.manageDefaultFont(getDiagram(), false, true));
		gaService.setLocationAndSize(stateText, bufferSpace, bufferSpace, stateWidth, textBoxHeight);

        peCreateService.createChopboxAnchor(mainContainerShape);
  
        layoutPictogramElement(mainContainerShape);
        
		return mainContainerShape;
	}

}
