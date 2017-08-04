package model;

public class ShapeInfo {

	private ShapeType type;
	private double width, height;
	private Coord coord;

	/**
	 * Stores generic information used to draw any shape
	 * Positions and lengths are set between 0 and 1 to allow scaling  
	 * @param type The type of shape to draw
	 * @param width The width of the shape (scaled between 0-1)
	 * @param Height The height of the shape (scaled between 0-1)
	 * @param coord The coordinates of the centre of the shape (scaled between 0-1)
	 */
	public ShapeInfo(ShapeType type, double width, double Height, Coord coord) {
		setType(type);
		setWidth(width);
		setHeight(Height);
		setCoord(coord);
	}

	/**
	 * @return the type
	 */
	public ShapeType getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(ShapeType type) {
		this.type = type;
	}

	/**
	 * @return the width
	 */
	public Number getWidth() {
		return width;
	}

	/**
	 * @param width
	 *            the width to set
	 */
	public void setWidth(double width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public Number getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * @return the coord
	 */
	public Coord getCoord() {
		return coord;
	}

	/**
	 * @param coord
	 *            the coord to set
	 */
	public void setCoord(Coord coord) {
		this.coord = coord;
	}
}
