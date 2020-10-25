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
	public Line homothety(Point origine, int ratio) {
		double x1 = origine.getX() + ratio * (p1.getX() - origine.getX());
		double y1 = origine.getY() + ratio * (p1.getY() - origine.getY());
		
		double x2 = origine.getX() + ratio * (p2.getX() - origine.getX());
		double y2 = origine.getY() + ratio * (p2.getY() - origine.getY());
		return new Line(new Point(x1,y1), new Point(x2,y2));
	}



	@Override
	public Line translation(Point p) {
		return new Line(translate(p1,p), translate(p2,p));
	}



	@Override
	public Shape rotation(int angle) {
		double xCentre = (p1.getX()+p2.getX())/2;
		double yCentre = (p1.getY()+p2.getY())/2;
		
		double p1x = xCentre + (p1.getY() - yCentre);
		double p1y = yCentre + (p1.getX() - xCentre);
		
		double p2x = xCentre + (p2.getY() - yCentre);
		double p2y = yCentre + (p2.getX() - xCentre);
		
		return new Line(new Point(p1x, p1y), new Point(p2x, p2y));
	}

	
	
	public Line rotationFromPoint(Point p) {	
		double p1x = p.getX() + (p1.getY() - p.getY());
		double p1y = p.getY() + (p1.getX() - p.getX());
		
		double p2x = p.getX() + (p2.getY() - p.getY());
		double p2y = p.getY() + (p2.getX() - p.getX());
		
		return new Line(new Point(p1x, p1y), new Point(p2x, p2y));
	}


	
	@Override
	public Shape centralSymmetry() {
		return new Line(symmetry(p2), symmetry(p1));
	}
	
	

	public Line centralSymmetryFromPoint(Point p) {
		double p1x = p.getX() + (p.getX() - this.p1.getX());
		double p1y = p.getY() + (p.getY() - this.p1.getY());
		double p2x = p.getX() + (p.getX() - this.p2.getX());
		double p2y = p.getY() + (p.getY() - this.p2.getY());
		return new Line(new Point(p1x, p1y), new Point(p2x, p2y));
	}

	
	
	@Override
	public Shape axialSymmetry(Line l) {
		
	}
	
	
	
	public Line axialSymmetryFromPoint(Point p, String axe) {
		double p1modified;
		double p2modified;
		switch (axe) {
		case "x":
			p1modified = p.getY() + (p.getY() - this.p1.getY());
			p2modified = p.getY() + (p.getY() - this.p2.getY());
			return new Line(new Point(this.p1.getX(), p1modified), new Point(this.p2.getX(), p2modified));
		case "y":
			p1modified = p.getX() + (p.getX() - this.p1.getX());
			p2modified = p.getX() + (p.getX() - this.p2.getX());
			return new Line(new Point(p1modified, this.p1.getY()), new Point(p2modified, this.p2.getY()));
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

	public Point getP1() {
		return p1;
	}

	public Point getP2() {
		return p2;
	}
}
