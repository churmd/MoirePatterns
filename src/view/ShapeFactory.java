package view;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import model.ShapeInfo;

public class ShapeFactory {

	public ShapeFactory() {
	}

	public Shape getShape(ShapeInfo sInfo, double width, double height, double xOffset, double yOffset) {
		Shape shape = new Rectangle(0, 0, 0, 0);
		switch (sInfo.getType()) {
		case Ellipse:
			shape = makeEllipse(sInfo, width, height, xOffset, yOffset);
			break;
		case Rectangle:
			shape = makeRectangle(sInfo, width, height, xOffset, yOffset);
			break;
		default:
			break;
		}
		return shape;
	}

	private Shape makeRectangle(ShapeInfo sInfo, double width, double height, double xOffset, double yOffset) {
		double sqWidth = sInfo.getWidth() * width;
		double sqHeight = sInfo.getHeight() * height;
		double x = (sInfo.getCoord().getX() * width) + xOffset;
		double y = (sInfo.getCoord().getY() * height) + yOffset;
		return new Rectangle2D.Double(x, y, sqWidth, sqHeight);
	}

	private Ellipse2D.Double makeEllipse(ShapeInfo sInfo, double width, double height, double xOffset, double yOffset) {
		double xr = (sInfo.getWidth() * width) / 2.0;
		double yr = (sInfo.getHeight() * height) / 2.0;
		double x = ((sInfo.getCoord().getX() * width) + xOffset) - xr;
		double y = ((sInfo.getCoord().getY() * height) + yOffset) - yr;
		return new Ellipse2D.Double(x, y, sInfo.getWidth() * width, sInfo.getHeight() * height);
	}
}
