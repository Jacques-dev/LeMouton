package point;

import java.util.Objects;

public class Point {
	private final float x;
	private final float y;
	
	/**
	
	@param 
	*/
	public Point(float x2, float y2) {
		this.x = x2;
		this.y = y2;
	}
	
	/**
	
	*/
	public Point() {
		this(0,0);
	}
	
	/**
	
	@param 
	*/
	public Point(final Point p) {
		this(p.getX(), p.getY());
	}
	
	/**
	
	@return 
	*/
	public float getX() {
		return x;
	}
	
	/**
	
	@return 
	*/
	public float getY() {
		return y;
	}
	
	/**
	
	@param 
	@return 
	*/
	public float distance(Point p2) {
		return (float) Math.sqrt((p2.getX()-x)*(p2.getX()-x) + (p2.getY()-y)*(p2.getY()-y));
	}
	
	/**
	
	@param 
	@return 
	*/
	public float distanceX(Point p2) {
		return p2.getX()-x;
	}
	
	/**
	
	@param 
	@return 
	*/
	public float distanceY(Point p2) {
		return p2.getY()-y;
	}
	
	/**
	
	@param 
	@return 
	*/
	public Point translation(int x, int y) {
		return new Point(x,y);
	}
	
	/**
	 
	@return 
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
