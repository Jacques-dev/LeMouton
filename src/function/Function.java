package function;
import point.Point;

public class Function { // y = ax + b
	private final int a;
	private final int b;
	
	public Function(Point p1, Point p2) {
		if ((p2.getY() - p1.getY()) == 0) {
			this.a = ((p2.getY() - p1.getY()) / (p2.getX() - p1.getX()));
			this.b = (p1.getY() - (a * p1.getX()));
		} else {
			this.a = 0;
			this.b = p1.getY();
		}
	}
	
	public boolean isOnLine(Point p) { // yp == a * xp + b
		if (p.getY() == (a * p.getX()) + b) return true;
		return false;
	}
	
	public Point getNewPoint(int x, Point p) { // newX = (yp-b)/a
		if (a != 0) return new Point(((p.getY() - b) / a), p.getY());
		return new Point(x, p.getY());
	}
	
	public String toString() {
		if (a != 0) return "[y = " + a + "x + " + b + "]";
		return "[y = " + b + "]";
	}
}
