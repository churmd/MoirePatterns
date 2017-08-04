package view;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import model.ShapeInfo;

public class ShapeFactory {

	public ShapeFactory() {
	}
	
	public Shape getShape(ShapeInfo sInfo) {
		Shape shape = new Rectangle(0, 0, 0, 0);
		switch (sInfo.getType()) {
		case Ellipse:
			shape = makeEllipse(sInfo);
			break; 
			
		default:
			break;
		}
		return shape;
	}
	
	private Ellipse2D.Double makeEllipse(ShapeInfo sInfo){
		double xr = sInfo.getWidth() / 2.0;
		double yr = sInfo.getHeight() / 2.0;
		double x = sInfo.getCoord().getX() - xr;
		double y = sInfo.getCoord().getY() - yr;
		return new Ellipse2D.Double(x, y, sInfo.getWidth(), sInfo.getHeight());
	}
}
