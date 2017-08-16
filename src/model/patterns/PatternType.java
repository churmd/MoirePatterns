package model.patterns;

public enum PatternType {

	RandomDots("Random Dots"), Squares("Squares");
	
	private String name;
	
	private PatternType(String name) {
		this.name= name;
	}
	
	public String toString() {
		return name;
	}
}
