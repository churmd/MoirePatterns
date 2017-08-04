package control;

import model.Model;
import model.patterns.PatternType;

public class Controller {

	private Model model;

	public Controller(Model model) {
		this.model = model;
	}

	/**
	 * Changes the pattern being used if it different to the current pattern
	 * 
	 * @param pt
	 *            The new pattern to use
	 */
	public void changePattern(PatternType pt) {
		PatternType current = model.getPatternType();
		if (current != pt) {
			model.setPattern(pt);
		}
	}
	
	/**
	 * Sets the size of the pattern
	 * 
	 * @param size
	 *            The new size for the pattern (must be 1 or larger)
	 */
	public void setPatternSize(int size) {
		model.setPatternSize(size);
	}
	
	public void setAngle(double angle) {
		model.setAngle(angle);
	}
	
	public void setXOffset(double xOffset) {
		model.setxOffset(xOffset);
	}
	
	public void setYOffset(double yOffset) {
		model.setyOffset(yOffset);
	}
}
