package shape;

import java.util.Objects;

import point.Point;

public class Circle extends Shape {
	
	private final Point center;
	private final double radius;
	private final double pi = Math.PI;
	
	public Circle(Point center, double radius) {
		this.center = center;
		this.radius = radius;
	}

	@Override
	public double area() {
		return pi * Math.pow(radius,  2);
	}

	@Override
	public double perimeter() {
		return 2 * pi * radius;
	}

	@Override
	public Circle homothety(Point p, int ratio) {
		float x = (center.getX()-p.getX())*ratio;
		float y = (center.getY()-p.getY())*ratio;
		return new Circle(new Point(x+center.getX(),y+center.getY()), radius*ratio);
	}

	@Override
	public Circle translation(Point p) {
		return new Circle(p, radius);
	}

	@Override
	public Circle rotation(int angle) {
		return this;
	}

	@Override
	public Circle centralSymmetry() {
		return new Circle(symmetry(center), radius);
	}

	@Override
	public Circle axialSymmetry(Line l) {
		Point pOnl = l.getF().getNewPointOnTheLine(center.getX(),l.getP1());
		float pX_Distance = center.distanceX(pOnl);
		float pY_Distance = center.distanceY(pOnl);
		
		Point newCenter = new Point(pOnl.getX()-pY_Distance, pOnl.getY()-pX_Distance);
		
		return new Circle (newCenter, radius);
	}
	
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Circle)) {return false;}
		Circle x = (Circle) o;
		return center == x.center && radius == x.radius && pi == x.pi;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(center,radius,pi);
	}
	

}
