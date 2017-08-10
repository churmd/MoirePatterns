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
