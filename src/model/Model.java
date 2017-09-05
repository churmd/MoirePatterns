package model;

import java.util.ArrayList;
import java.util.Observable;

import model.patterns.LinesPattern;
import model.patterns.Pattern;
import model.patterns.PatternType;
import model.patterns.RandomDotPattern;
import model.patterns.SquaresPattern;

public class Model extends Observable {

	private Pattern pattern;
	private double angle, xOffset, yOffset;

	public Model() {
		pattern = new RandomDotPattern();
		setAngle(0);
		setxOffset(0);
		setyOffset(0);
	}

	/**
	 * Changes the current pattern
	 * 
	 * @param pt
	 *            The new pattern to be used
	 */
	public void setPattern(PatternType pt) {
		switch (pt) {
		case RandomDots:
			pattern = new RandomDotPattern();
			break;
		case Squares:
			pattern = new SquaresPattern();
			break;
		case Lines:
			pattern = new LinesPattern();
			break;
		default:
			break;
		}
		
		setxOffset(0);
		setyOffset(0);
		setAngle(0);
		
		setChanged();
		notifyObservers();
	}

	/**
	 * 
	 * @return The current pattern type
	 */
	public PatternType getPatternType() {
		return pattern.getPatternType();
	}

	/**
	 * The description of the pattern
	 * 
	 * @return The pattern in the form of a list of ShapeInfo's
	 */
	public ArrayList<ShapeInfo> getPattern() {
		return pattern.getPattern();
	}

	/**
	 * @return the angle
	 */
	public double getAngle() {
		return angle;
	}

	/**
	 * @param angle
	 *            the angle to set
	 */
	public void setAngle(double angle) {
		angle = angle % (2 * Math.PI);
		this.angle = angle;
		setChanged();
		notifyObservers();
	}

	/**
	 * @return the xOffset
	 */
	public double getxOffset() {
		return xOffset;
	}

	/**
	 * @param xOffset
	 *            the xOffset to set
	 */
	public void setxOffset(double xOffset) {
		if (xOffset >= -1 && xOffset <= 1) {
			this.xOffset = xOffset;
		}
		setChanged();
		notifyObservers();
	}

	/**
	 * @return the yOffset
	 */
	public double getyOffset() {
		return yOffset;
	}

	/**
	 * @param yOffset
	 *            the yOffset to set
	 */
	public void setyOffset(double yOffset) {
		if (yOffset >= -1 && yOffset <= 1) {
			this.yOffset = yOffset;
		}
		setChanged();
		notifyObservers();
	}
}
