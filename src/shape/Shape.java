package shape;

import point.Point;

public abstract class Shape implements ShapesMethodes {
	
	/**
	@param p is the Point of symetry
	@return a new Point after symmetry
	*/
	public Point symmetry(Point p) {
		return new Point(-p.getX(),-p.getY());
	}

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
	
	/**
	@param m is the Point that will change of position
	@param o is the Point of origin
	@param angle is angle of rotation
	@return a new Point after rotation
	*/
	public Point rotate(Point m, Point o, int angle) {
		float xM, yM, x, y;
		angle *= Math.PI / 180;
	    xM = m.getX() - o.getX();
	    yM = m.getY() - o.getY();
	    x = (float) (xM * Math.cos(angle) + yM * Math.sin (angle) + o.getX());
	    y = (float) (- xM * Math.sin (angle) + yM * Math.cos (angle) + o.getY());
	    return new Point(x, y);
	}
}
