package containers;

public abstract class Shape implements Container {
	/**
	@param shape is the shape that will be used to compare perimeters 
	@return a int corresponding to the perimeters difference
	*/
	public int compareToPerimeters(final Shape shape) {
		return (int) (this.perimeter() - shape.perimeter());
	}
	
	/**
	@param shape is the shape that will be used to compare areas 
	@return a int corresponding to the areas difference
	*/
	public int compareToAreas(final Shape shape) {
		return (int) (this.area() - shape.area());
	}
}
