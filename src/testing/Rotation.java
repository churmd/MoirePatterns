package testing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class Rotation extends JPanel {

	private double angle = 0;

	public Rotation() {
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

//		Rectangle rect = new Rectangle(100, 100, 100, 50);
//		g2.setColor(Color.BLACK);
//		g2.fill(rect);
//
//		AffineTransform tran = g2.getTransform();
//		// tran.rotate(0.5);
//		tran.rotate(angle, 300, 300);
//		g2.setTransform(tran);
//
//		Rectangle rect2 = new Rectangle(400, 400, 100, 50);
//		g2.setColor(Color.RED);
//		g2.fill(rect2);
		
		double r = 25;
		Ellipse2D.Double circ = new Ellipse2D.Double(200-r, 200-r, 2*r, 2*r);
		g2.setColor(Color.BLACK);
		g2.fill(circ);
		
		AffineTransform tran = new AffineTransform();
		tran.rotate(angle, 300, 300);
		g2.setTransform(tran);
		
		Ellipse2D.Double circ2 = new Ellipse2D.Double(400-r, 400-r, 2*r, 2*r);
		g2.setColor(Color.RED);
		g2.fill(circ2);
		
	}

	@Override
	public void update(Graphics g) {
		super.update(g);
		repaint();
	}

	public void incAngle() {

		angle = angle + 0.1;
		repaint();
	}
}
