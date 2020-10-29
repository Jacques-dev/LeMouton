package shape;

import java.util.Objects;

import containers.Shape;
import point.Point;

public class Circle extends Shape {
	
	private final Point center;
	private final double radius;
	private final double pi = Math.PI;
	
	/**
	@param center is the center Point of the Circle
	@param radius is the distance between the center and the limit of the Circle
	*/
	public Circle(Point center, double radius) {
		this.center = center;
		this.radius = radius;
	}

	/**
	@return the area of the Circle
	*/
	@Override
	public double area() {
		return pi * Math.pow(radius,  2);
	}

	/**
	@return the perimeter of the Circle
	*/
	@Override
	public double perimeter() {
		return 2 * pi * radius;
	}

	/**
	@param origine is the homothety origin
	@param ratio is the homothety ratio
	@return a new Circle after a homothety
	*/
	@Override
	public Circle homothety(Point p, int ratio) {
		float x = (center.getX()-p.getX())*ratio;
		float y = (center.getY()-p.getY())*ratio;
		return new Circle(new Point(x+center.getX(),y+center.getY()), radius*ratio);
	}

	/**
	@param p is the new center Point of the Circle after translation
	@return a new Circle after a translation
	*/
	@Override
	public Circle translation(Point p) {
		return new Circle(p, radius);
	}

	/**
	@param angle is the degree of rotation
	@return a new Circle after a rotation
	*/
	@Override
	public Circle rotation(int angle) {
		return this;
	}

	/**
	@return a new Circle corresponding the its central symmetry
	*/
	@Override
	public Circle centralSymmetry(Point p) {
		return new Circle(symmetry(center,  p), radius);
	}

	/**
	@param l is the Line of symmetry
	@return a new Circle corresponding the its axial symmetry
	*/
	@Override
	public Circle axialSymmetry(Line l) {
		Point pOnl = l.getF().getNewPointOnTheLine(center.getX(), center.getY(), l.getP1());
		float pX_Distance = center.distanceX(pOnl);
		float pY_Distance = center.distanceY(pOnl);
		
		Point newCenter = new Point(pOnl.getX()-pY_Distance, pOnl.getY()-pX_Distance);
		
		return new Circle (newCenter, radius);
	}
	
	/**
	@return a textual representation of a Circle
	*/
	public String toString() {
		
		StringBuilder resultat = new StringBuilder("\t\t\tCircle\n");
		
		resultat.append("\t\t\t\tcenter : " + center + "\tradius : " + radius + "\n");
	
		return resultat.toString();
	}
	
	/**
	@param o : is an object with no type defined
    @return a boolean which significate if this Arc is equal to another one
	*/
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Circle)) {return false;}
		Circle x = (Circle) o;
		return center == x.center && radius == x.radius && pi == x.pi;
	}
	
	/**
    @return a hash code value for the object
	*/
	@Override
	public int hashCode() {
		return Objects.hash(center,radius,pi);
	}
}
