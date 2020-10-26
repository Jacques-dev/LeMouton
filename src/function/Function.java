package function;
import point.Point;

public class Function { // y = ax + b
	private final float a;
	private final float b;
	
	/**
	
	@param  
	*/
	public Function(Point p1, Point p2) {
		if ((p2.getY() - p1.getY()) == 0) {
			this.a = ((p2.getY() - p1.getY()) / (p2.getX() - p1.getX()));
			this.b = (p1.getY() - (a * p1.getX()));
		} else {
			this.a = 0;
			this.b = p1.getY();
		}
	}
	
	/**
	
	@param 
	@return 
	*/
	public boolean isOnLine(Point p) { // yp == a * xp + b
		if (p.getY() == (a * p.getX()) + b) return true;
		return false;
	}
	
	/**
	
	@param 
	@return 
	*/
	public Point getNewPointOnTheLine(float x, Point p) { // newX = (yp-b)/a
		if (a != 0) return new Point(((p.getY() - b) / a), p.getY());
		return new Point(x, p.getY());
	}
	
	/**
	
	@return 
	*/
	public float getA() {
		return a;
	}
	
	/**
	
	@return 
	*/
	public float getB() {
		return b;
	}
	
	/**
	 
	@return 
	*/
	public String toString() {
		if (a != 0) {
			if (a % 1 == 0) {
				if (b % 1 == 0) {
					return "[y = " + (int)a + "x + " + (int)b + "]";
				}
				return "[y = " + (int)a + "x + " + b + "]";
			}
			return "[y = " + a + "x + " + b + "]";
		}
		else {
			if (b % 1 == 0) return "[y = " + (int)b + "]";
			return "[y = " + b + "]";
		}
	}
}
