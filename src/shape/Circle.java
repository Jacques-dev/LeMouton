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
	public Shape homothety(Point p, int ratio) {
		double x = (center.getX()-p.getX())*ratio;
		double y = (center.getY()-p.getY())*ratio;
		return new Circle(new Point(x+center.getX(),y+center.getY()), radius*ratio);
	}

	@Override
	public Shape translation(Point p) {
		return new Circle(p, radius);
	}

	@Override
	public Shape rotation(int angle) {
		return this;
	}

	@Override
	public Shape centralSymmetry() {
		return new Circle(symmetry(center), radius);
	}

	@Override
	public Shape axialSymmetry(Line l) {
		
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
