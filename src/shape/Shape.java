package shape;

import point.Point;

public abstract class Shape implements ShapesMethodes {
	
	public Point translate(Point p1, Point p2) {
		return new Point(p1.getX()+p2.getX(), p1.getY()+p2.getY());
	}
	
	public Point symmetry(Point p) {
		return new Point(-p.getX(),-p.getY());
	}

	public int compareToPerimeters(final Shape shape) {
		return (int) (this.perimeter() - shape.perimeter());
	}
	
	public int compareToAreas(final Shape shape) {
		return (int) (this.area() - shape.area());
	}
	
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
