package model.patterns;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import model.Coord;
import model.ShapeInfo;
import model.ShapeType;

public class RandomDotPattern implements Pattern {

	private ArrayList<ShapeInfo> dots;
	private double width, height;
	private Color outline, fill;

	public RandomDotPattern() {
		int numDots = 2000;
		dots = new ArrayList<>(numDots);
		width = 0.005;
		height = 0.005;
		outline = Color.BLACK;
		fill = Color.BLACK;

		Random gen = new Random();

		for (int i = 0; i < numDots; i++) {
			double x = gen.nextDouble();
			double y = gen.nextDouble();
			ShapeInfo sInfo = new ShapeInfo(ShapeType.Ellipse, width, height, 
											new Coord(x, y), outline, fill);
			dots.add(sInfo);
		}

	}

	@Override
	public ArrayList<ShapeInfo> getPattern() {
		return dots;
	}

	@Override
	public PatternType getPatternType() {
		return PatternType.RandomDots;
	}

}
