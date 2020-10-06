package shape;

import java.util.Objects;

import point.Point;

public class Line extends Shape {
	private final Point p1;
	private final Point p2;
	
	public Line(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	@Override
	public double area() {
		return 0;
	}

	@Override
	public double perimeter() {
		return p1.distance(p2);
	}



	@Override
	public Shape homothety(Point origine, int ratio) {
		double x1 = origine.getX() + ratio * (p1.getX() - origine.getX());
		double y1 = origine.getY() + ratio * (p1.getY() - origine.getY());
		
		double x2 = origine.getX() + ratio * (p2.getX() - origine.getX());
		double y2 = origine.getY() + ratio * (p2.getY() - origine.getY());
		return new Line(new Point(x1,y1), new Point(x2,y2));
	}



	@Override
	public Shape translation(Point p) {
		return new Line(translate(p1,p), translate(p2,p));
	}



	@Override
	public Shape rotation() {
		double xCentre = (p1.getX()+p2.getX())/2;
		double yCentre = (p1.getY()+p2.getY())/2;
		
		double p1x = xCentre + (p1.getY() - yCentre);
		double p1y = yCentre + (p1.getX() - xCentre);
		
		double p2x = xCentre + (p2.getY() - yCentre);
		double p2y = yCentre + (p2.getX() - xCentre);
		
		return new Line(new Point(p1x, p1y), new Point(p2x, p2y));
	}



	@Override
	public Shape centralSymmetry() {
		return new Line(symmetry(p2), symmetry(p1));
	}



	@Override
	public Shape axialSymmetry(String axe) {
		switch (axe) {
		case "x":
			return new Line(symmetryX(p1), symmetryX(p2));
		case "y":
			return new Line(symmetryY(p2), symmetryY(p1));
		default:
			throw new IllegalArgumentException("x or y argument only");
		}
	}
	
	@Override
	public String toString() {
		return p1.toString() + p2.toString();
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Line)) {return false;}
		Line x = (Line) o;
		return p1.equals(x.p1) && p2.equals(x.p2);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(p1,p2);
	}
}
