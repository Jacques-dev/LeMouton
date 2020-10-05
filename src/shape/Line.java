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
		int x1 = origine.getX() + ratio * (p1.getX() - origine.getX());
		int y1 = origine.getY() + ratio * (p1.getX() - origine.getY());
		
		int x2 = origine.getX() + ratio * (p2.getX() - origine.getX());
		int y2 = origine.getY() + ratio * (p2.getX() - origine.getY());
		return new Line(new Point(x1,y1), new Point(x2,y2));
	}



	@Override
	public Shape translation(Point p) {
		return new Line(translate(p1,p), translate(p2,p));
	}



	@Override
	public Shape rotation() { //AFAIRE---------------------------------------------------
		
		return null;
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
