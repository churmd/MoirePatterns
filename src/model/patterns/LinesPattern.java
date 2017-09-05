package model.patterns;

import java.awt.Color;
import java.util.ArrayList;

import model.Coord;
import model.ShapeInfo;
import model.ShapeType;

public class LinesPattern implements Pattern{

	private int numLines;
	private ArrayList<ShapeInfo> lines;
	
	public LinesPattern() {
		numLines = 100;
		lines = new ArrayList<>(numLines);
		
		double gap = 1.0 / numLines;
		double indent = gap / 2.0;
		
		for(int i = 0; i < numLines; i++) {
			double x = (i * gap) + indent;
			Coord c = new Coord(x, 0); 
			
			ShapeInfo sInfo = new ShapeInfo(ShapeType.Line, 0, 1, c, Color.BLACK, Color.BLACK);
			lines.add(sInfo);
		}
		
	}
	
	@Override
	public ArrayList<ShapeInfo> getPattern() {
		return lines;
	}

	@Override
	public PatternType getPatternType() {
		return PatternType.Lines;
	}

}
