package model.patterns;

public enum PatternType {

	RandomDots("Random Dots");
	
	private String name;
	
	private PatternType(String name) {
		this.name= name;
	}
	
	public String toString() {
		return name;
	}
}
