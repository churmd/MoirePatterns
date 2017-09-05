package model.patterns;

import java.awt.Color;
import java.util.ArrayList;

import model.Coord;
import model.ShapeInfo;
import model.ShapeType;

public class ConcentricCirclesPattern implements Pattern{

	private ArrayList<ShapeInfo> circles;
	private int numCirc;
	
	public ConcentricCirclesPattern() {
		numCirc = 100;
		circles = new ArrayList<>(numCirc);
		
		double diameter = 1.0 / numCirc;
		double radius = diameter / 2.0;
		
		Coord coord = new Coord(0.5,  0.5);
		
		for(int i = 0; i < numCirc; i++) {
			double size = (i + 1) * diameter;
			ShapeInfo sInfo = new ShapeInfo(ShapeType.Ellipse, size, size, coord, Color.BLACK);
			circles.add(sInfo);
		}
	}
	
	@Override
	public ArrayList<ShapeInfo> getPattern() {
		return circles;
	}

	@Override
	public PatternType getPatternType() {
		return PatternType.ConcentricCircles;
	}

}
