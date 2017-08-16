package model.patterns;

import java.awt.Color;
import java.util.ArrayList;

import model.Coord;
import model.ShapeInfo;
import model.ShapeType;

public class SquaresPattern implements Pattern {

	private ArrayList<ShapeInfo> squares;
	private int rowID;

	public SquaresPattern() {
		
		int numXBlackSq = 50;
		
		int numXSq = 2 * numXBlackSq;
		int numYSq = numXSq;

		squares = new ArrayList<>(numXSq * numYSq);
		
		double sqWidth = 1.0 / numXSq;
		double sqHeight = 1.0 / numYSq;

		rowID = 0;

		for (int i = 0; i < numYSq; i++) {
			double ypos = i * sqHeight;
			double xpos = rowID * sqWidth;

			while (xpos < 1.0) {
				Coord coord = new Coord(xpos, ypos);
				ShapeInfo sInfo = new ShapeInfo(ShapeType.Rectangle, sqWidth, sqHeight, coord, Color.BLACK,
						Color.BLACK);
				squares.add(sInfo);
				
				xpos = xpos + (2.0 * sqWidth);
			}
			
			if(rowID == 0) {
				rowID = 1;
			} else {
				rowID = 0;
			}
		}

	}

	@Override
	public ArrayList<ShapeInfo> getPattern() {
		return squares;
	}

	@Override
	public PatternType getPatternType() {
		return PatternType.Squares;
	}

}
