package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import model.Model;
import model.ShapeInfo;

public class PatternView extends JPanel implements Observer {

	private Model model;
	private ShapeFactory shapeFact;

	public PatternView(Model model) {
		super();
		this.model = model;
		shapeFact = new ShapeFactory();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Shrink drawing area to allow a blank border
		int totalW = getWidth();
		int totalH = getHeight();
		double scale = 0.9;
		double width = totalW * scale;
		double height = totalH * scale;
		double xOffset = ((1 - scale) * totalW) / 2.0;
		double yOffset = ((1 - scale) * totalH) / 2.0;

		Graphics2D g2 = (Graphics2D) g;
		AffineTransform tranDefault = new AffineTransform();
		g2.setTransform(tranDefault);

		drawPattern(g2, width, height, xOffset, yOffset);

		AffineTransform tranAltered = getTransform(width, height);
		g2.setTransform(tranAltered);

		drawPattern(g2, width, height, xOffset, yOffset);
	}

	private void drawPattern(Graphics2D g2, double width, double height, double xOffset, double yOffset) {
		for (ShapeInfo sInfo : model.getPattern()) {
			Shape s = shapeFact.getShape(sInfo, width, height, xOffset, yOffset);

			if (sInfo.isShapeFilled()) {
				g2.setColor(sInfo.getFill());
				g2.fill(s);
			}
			g2.setColor(sInfo.getOutline());
			g2.draw(s);
		}
	}

	private AffineTransform getTransform(double width, double height) {
		AffineTransform tran = new AffineTransform();
		tran.rotate(model.getAngle(), getWidth() / 2.0, getHeight() / 2.0);
		tran.translate(model.getxOffset() * width, model.getyOffset() * height);
		return tran;
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}
}
