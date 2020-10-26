package function;
import point.Point;

public class LinearFunction { // y = ax + b
	private final float a;
	private final float b;
	
	/**
	@param p1 is a Points which will define the linear function of a Line
	@param p2 is a Points which will define the linear function of a Line
	*/
	public LinearFunction(Point p1, Point p2) {
		if ((p2.getY() - p1.getY()) == 0) {
			this.a = ((p2.getY() - p1.getY()) / (p2.getX() - p1.getX()));
			this.b = (p1.getY() - (a * p1.getX()));
		} else {
			this.a = 0;
			this.b = p1.getY();
		}
	}
	
	/**
	@param x is the x-coordinate of the searched point on a line
	@param y is the x-coordinate of the searched point on a line if the line is like x = c
	@param p is one of the Point belonging to the line
	@return a Point which is the Point on the symmetrical line
	*/
	public Point getNewPointOnTheLine(float x, float y, Point p) { // newX = (yp-b)/a
		if (p.getY() == 0) return new Point(p.getX(),y); // x = c
		if (a != 0) return new Point(((p.getY() - b) / a), p.getY());
		return new Point(x, p.getY()); // y = z
	}
	
	/**
	@return the steering coefficient of the function
	*/
	public float getA() {
		return a;
	}
	
	/**
	
	@return the original y-intercept
	*/
	public float getB() {
		return b;
	}
	
	/**
	@return a textual representation of a linear function
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
