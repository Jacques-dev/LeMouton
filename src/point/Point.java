package point;

import java.util.Objects;

public class Point {
	private final double x;
	private final double y;
	
	public Point(double x2, double y2) {
		this.x = x2;
		this.y = y2;
	}
	
	public Point() {
		this(0,0);
	}
	
	public Point(final Point p) {
		this(p.getX(), p.getY());
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double distance(Point p2) {
		return Math.sqrt((p2.getX()-x)*(p2.getX()-x) + (p2.getY()-y)*(p2.getY()-y));
	}
	
	public Point translation(int x, int y) {
		return new Point(x,y);
	}
	
	@Override
	public String toString() {
		return "("+x+","+y+")";
	}
	
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
