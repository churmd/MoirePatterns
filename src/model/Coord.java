package model;

public class Coord {

	private Number x, y;
	
	/**
	 * Creates a 2D coordinate
	 * @param x The x value 
	 * @param y The y value
	 */
	public Coord(Number x, Number y) {
		this.setX(x);
		this.setY(y);
	}

	/**
	 * @return the x
	 */
	public Number getX() {
		return x;
	}


	/**
	 * @param x the x to set
	 */
	public void setX(Number x) {
		this.x = x;
	}
	
	/**
	 * @return the y
	 */
	public Number getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(Number y) {
		this.y = y;
	}
	
}
