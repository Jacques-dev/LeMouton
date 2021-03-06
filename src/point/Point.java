package point;

import java.util.Objects;

public class Point {
	private final float x;
	private final float y;
	
	/**
	@param x is the x-coordinate of the Point
	@param y is the y-coordinate of the Point
	*/
	public Point(float x, float y) {
		try {
			this.x = x;
			this.y = y;
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}
	
	/**
	This is a different constructor creating a Point in (0,0)
	*/
	public Point() {
		this(0,0);
	}
	
	/**
	This is a different constructor using an other Point to create a copy
	@param p is a Point to copy
	*/
	public Point(final Point p) {
		this(p.getX(), p.getY());
	}
	
	/**
	@return the x-coordinate of the Point
	*/
	public float getX() {
		return x;
	}
	
	/**
	@return the y-coordinate of the Point
	*/
	public float getY() {
		return y;
	}
	
	/**
	@param p2 is a second Point to get a distance difference
	@return a distance difference between the actual Point and the second one given in parameter
	*/
	public float distance(Point p2) {
		return (float) Math.sqrt((p2.getX()-x)*(p2.getX()-x) + (p2.getY()-y)*(p2.getY()-y));
	}
	
	/**
	@param p2 is a second Point to get an abscissa distance difference
	@return an abscissa distance difference between the actual Point and the second one given in parameter
	*/
	public float distanceX(Point p2) {
		return x-p2.getX();
	}
	
	/**
	@param p2 is a second Point to get an ordinal distance difference
	@return an ordinal distance difference between the actual Point and the second one given in parameter
	*/
	public float distanceY(Point p2) {
		return y-p2.getY();
	}
	
	/**
	@param x is the x-coordinate of the new Point of translation
	@param y is the y-coordinate of the new Point of translation
	@return a new Point of translation
	*/
	public Point translation(int x, int y) {
		return new Point(x,y);
	}
	
	/**
	@param symetricPoint is the Point of symetry
	@return a new Point after symmetry
	*/
	public Point symmetry(Point symetricPoint) {
		return new Point(-(x - symetricPoint.getX()) + symetricPoint.getX(),-(y - symetricPoint.getY()) + symetricPoint.getY());
	}
	
	/**
	@param o is the Point of origin
	@param angle is angle of rotation
	@return a new Point after rotation
	*/
	public Point rotate(Point o, int angle) {
		float xM, yM, x, y;
		angle *= Math.PI / 180;
	    xM = this.x - o.getX();
	    yM = this.y - o.getY();
	    x = (float) (xM * Math.cos(angle) + yM * Math.sin (angle) + o.getX());
	    y = (float) (- xM * Math.sin (angle) + yM * Math.cos (angle) + o.getY());
	    return new Point(x, y);
	}
	
	/**
	@return a textual representation of a Point
	*/
	@Override
	public String toString() {
		if (x % 1 == 0) {
		  if (y % 1 == 0) return "("+(int)x+","+(int)y+")";
		  return "("+(int)x+","+y+")";
		}
		if (y % 1 == 0) return "("+x+","+(int)y+")";
		return "("+x+","+y+")";
	}
	
	/**
	@param o : is an object with no type defined
    @return a boolean which significate if this Arc is equal to another one
	*/
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Point)) {return false;}
		Point p = (Point) o;
		return x == p.x && y == p.y;
	}
	
	
	/**
    @return a hash code value for the object
	*/
	@Override
	public int hashCode() {
		return Objects.hash(x,y);
	}
}
