package be.kuleuven.graph.rfsm.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.impl.AbstractLayoutFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
public class StatelayoutFeature extends AbstractLayoutFeature {

	public StatelayoutFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canLayout(ILayoutContext context) {
		return true;
	}

	@Override
	public boolean layout(ILayoutContext context) {
		boolean anythingChanged = false;
		ContainerShape containerShape = (ContainerShape) context.getPictogramElement();
		GraphicsAlgorithm containerGa = containerShape.getGraphicsAlgorithm();
		// height
		if (containerGa.getHeight() < IPictogramConstants.STATE_DEFAULT_HEIGHT) {
			containerGa.setHeight(IPictogramConstants.STATE_DEFAULT_HEIGHT);
			anythingChanged = true;
		}

		// width
		if (containerGa.getWidth() < IPictogramConstants.STATE_DEFAULT_WIDTH) {
			containerGa.setWidth(IPictogramConstants.STATE_DEFAULT_WIDTH);
			anythingChanged = true;
		}
		int containerWidth = containerGa.getWidth();
		int containerHeight = containerGa.getHeight();

		//resize the parts of the state
		for (GraphicsAlgorithm child : containerGa.getGraphicsAlgorithmChildren()) {
			if (child instanceof RoundedRectangle) {
				child.setWidth(containerWidth);
				child.setHeight(containerHeight);
			}
			if (child instanceof Text) {
				child.setWidth(containerWidth - (2 * IPictogramConstants.BUFFER_SPACE));
			}
			anythingChanged = true;
		}

		//this will find the states within the state: disabled
//		for (Shape shape : containerShape.getChildren()) {
//			shape.getGraphicsAlgorithm().setWidth(containerWidth);
//		}

		return anythingChanged;
	}

}
