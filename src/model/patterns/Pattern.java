package model.patterns;

import java.util.ArrayList;

import model.ShapeInfo;

public interface Pattern {
	
	/**
	 * The description of the pattern 
	 * @return The pattern in the form of a list of ShapeInfo's
	 */
	ArrayList<ShapeInfo> getPattern();
	 
}
