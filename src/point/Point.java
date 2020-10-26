package point;

import java.util.Objects;

public class Point {
	private final int x;
	private final int y;
	
	public Point(int x2, int y2) {
		this.x = x2;
		this.y = y2;
	}
	
	public Point() {
		this(0,0);
	}
	
	public Point(final Point p) {
		this(p.getX(), p.getY());
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int distance(Point p2) {
		return (int) Math.sqrt((p2.getX()-x)*(p2.getX()-x) + (p2.getY()-y)*(p2.getY()-y));
	}
	
	public int distanceX(Point p2) {
		return p2.getX()-x;
	}
	
	public int distanceY(Point p2) {
		return p2.getY()-y;
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
