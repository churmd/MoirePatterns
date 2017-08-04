package model;

public class Coord {

	private double x, y;
	
	/**
	 * Creates a 2D coordinate
	 * @param x The x value 
	 * @param y The y value
	 */
	public Coord(double x, double y) {
		this.setX(x);
		this.setY(y);
	}

	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}


	/**
	 * @param x the x to set
	 */
	public void setX(double x) {
		this.x = x;
	}
	
	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(double y) {
		this.y = y;
	}
	
}
