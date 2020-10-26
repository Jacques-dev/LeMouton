package shape;

import java.util.Objects;

import function.Function;
import point.Point;

public class Line extends Shape {
	private final Point p1;
	private final Point p2;
	private final Function f;
	
	public Line(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
		this.f = new Function(p1,p2);
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
		int x1 = origine.getX() + ratio * (p1.getX() - origine.getX());
		int y1 = origine.getY() + ratio * (p1.getY() - origine.getY());
		
		int x2 = origine.getX() + ratio * (p2.getX() - origine.getX());
		int y2 = origine.getY() + ratio * (p2.getY() - origine.getY());
		return new Line(new Point(x1,y1), new Point(x2,y2));
	}



	@Override
	public Line translation(Point p) {
		return new Line(translate(p1,p), translate(p2,p));
	}



	@Override
	public Line rotation(int angle) {
		
	}

	
	
	public Line rotationFromPoint(Point p) {	
		int p1x = p.getX() + (p1.getY() - p.getY());
		int p1y = p.getY() + (p1.getX() - p.getX());
		
		int p2x = p.getX() + (p2.getY() - p.getY());
		int p2y = p.getY() + (p2.getX() - p.getX());
		
		return new Line(new Point(p1x, p1y), new Point(p2x, p2y));
	}


	
	@Override
	public Line centralSymmetry() {
		return new Line(symmetry(p2), symmetry(p1));
	}
	
	

	public Line centralSymmetryFromPoint(Point p) {
		int p1x = p.getX() + (p.getX() - this.p1.getX());
		int p1y = p.getY() + (p.getY() - this.p1.getY());
		int p2x = p.getX() + (p.getX() - this.p2.getX());
		int p2y = p.getY() + (p.getY() - this.p2.getY());
		return new Line(new Point(p1x, p1y), new Point(p2x, p2y));
	}

	
	
	@Override
	public Line axialSymmetry(Line l) {
		Point p1Onl = f.getNewPoint(p1.getX(),l.getP1());
		Point p2Onl = f.getNewPoint(p2.getX(),l.getP2());
		
		int p1X_Distance = p1.distanceX(p1Onl);
		int p1Y_Distance = p1.distanceY(p1Onl);
		int p2X_Distance = p2.distanceX(p2Onl);
		int p2Y_Distance = p2.distanceY(p2Onl);
		
		Point newP1 = new Point(p1Onl.getX()-p1Y_Distance, p1Onl.getY()-p1X_Distance);
		Point newP2 = new Point(p2Onl.getX()-p2Y_Distance, p2Onl.getY()-p2X_Distance);
		
		return new Line(newP1,newP2);
	}
	
	@Override
	public String toString() {
		return p1.toString() + p2.toString() + " " + f.toString();
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
