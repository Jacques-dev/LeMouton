package function;

import point.Point;
import shape.Line;

public class Vector {
	private final float x;
	private final float y;
	
	public Vector(Line l) {
		this.x = l.getP2().getX() - l.getP1().getX();
		this.y = l.getP2().getY() - l.getP1().getY();
	}
	
	public Vector(Point p1, Point p2) {
		this.x = p2.getX() - p1.getX();
		this.y = p2.getY() - p1.getY();
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public String toString() {
		return "V(" + x + "," + y + ")";
	}
}
