package model.patterns;

import java.util.ArrayList;
import java.util.Random;

import model.Coord;
import model.ShapeInfo;
import model.ShapeType;

public class RandomDotPattern implements Pattern {

	private ArrayList<ShapeInfo> dots;
	private double width, height = 0.05;

	public RandomDotPattern(int numDots) {
		dots = new ArrayList<>(numDots);

		Random gen = new Random();

		for (int i = 0; i < numDots; i++) {
			double x = gen.nextDouble();
			double y = gen.nextDouble();
			ShapeInfo sInfo = new ShapeInfo(ShapeType.Ellipse, width, height, new Coord(x, y));
			dots.add(sInfo);
		}

	}

	@Override
	public ArrayList<ShapeInfo> getPattern() {
		return dots;
	}

}
