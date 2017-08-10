package model;

import java.util.ArrayList;
import java.util.Observable;

import model.patterns.Pattern;
import model.patterns.PatternType;
import model.patterns.RandomDotPattern;

public class Model extends Observable {

	private Pattern pattern;
	private int patternSize;
	private double angle, xOffset, yOffset;

	public Model() {
		patternSize = 2000;
		pattern = new RandomDotPattern(patternSize);
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
			pattern = new RandomDotPattern(patternSize);
			break;

		default:
			break;
		}
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
	 * Sets the size of the pattern
	 * 
	 * @param size
	 *            The new size for the pattern (must be 1 or larger)
	 */
	public void setPatternSize(int size) {
		if (size > 0) {
			patternSize = size;
		}
		setChanged();
		notifyObservers();
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
