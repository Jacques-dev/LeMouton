package shape;

import java.util.Objects;

import containers.Shape;
import exceptions.LineCreationException;
import function.LinearFunction;
import function.Vector;
import point.Point;

public class Line extends Shape {
	private final Point p1;
	private final Point p2;
	private final LinearFunction f;
	private final int width = 1;
	
	/**
	@param p1 is one of the point belonging to the line
	@param p2 is one of the point belonging to the line
	@throws LineCreationException 
	*/
	public Line(Point p1, Point p2) throws LineCreationException {
		this.p1 = p1;
		this.p2 = p2;
		this.f = new LinearFunction(p1,p2);
	}
	
	/**
	@return the area of the line
	*/
	@Override
	public double area() {
		return p1.distance(p2) * width;
	}

	/**
	@return the perimeter of the line
	*/
	@Override
	public double perimeter() {
		return (p1.distance(p2) * 2) + (2 * width);
	}

	/**
	@param origine is the homothety origin
	@param ratio is the homothety ratio
	@return a new Line after a homothety
	@throws LineCreationException 
	*/
	@Override
	public Line homothety(Point origine, int ratio) throws LineCreationException {
		float x1 = origine.getX() + ratio * (p1.getX() - origine.getX());
		float y1 = origine.getY() + ratio * (p1.getY() - origine.getY());
		
		float x2 = origine.getX() + ratio * (p2.getX() - origine.getX());
		float y2 = origine.getY() + ratio * (p2.getY() - origine.getY());
		return new Line(new Point(x1,y1), new Point(x2,y2));
	}
	
	/**
	@param origin is the origin Point of translation
	@param destination is the new center Point of the Line after translation
	@return a new Line after a translation
	@throws LineCreationException 
	*/
	public Line translation(Point origin, Point destination) throws LineCreationException {
		float center_x = origin.distanceX(p1);
		float center_y = origin.distanceY(p1);
		
		Point newP1 = new Point(destination.getX()-center_x, destination.getY()-center_y);
		Point newP2 = new Point(destination.getX()+center_x, destination.getY()+center_y);
		
		return new Line(newP1, newP2);
	}
	
	/**
	@param destination is the new center Point of the Line after translation
	@return a new Line after a translation
	@throws LineCreationException 
	*/
	@Override
	public Line translation(Point destination) throws LineCreationException {
		return translation(centerOfLine(), destination);
	}
	
	/**
	@param angle is the degree of rotation
	@return a new Line after a rotation
	@throws LineCreationException 
	*/
	@Override
	public Line rotation(int angle) throws LineCreationException {
		Point center = this.centerOfLine();
		Point newP1 = this.p1.rotate(center, angle);
		Point newP2 = newP1.symmetry(center);
		
		return new Line(newP1,newP2);
	}
	
	/**
	@param angle is the degree of rotation
	@param p is the origin Point rotation
	@return a new Line after a rotation
	@throws LineCreationException 
	*/
	public Line rotationFromPoint(int angle, Point p) throws LineCreationException {
		Point center = this.centerOfLine();
		Point newP1 = this.p1.rotate(p, angle);
		Point newP2 = newP1.symmetry(center);
		
		return new Line(newP1,newP2);
	}
	
	/**
	@param p is the Point of symmetry
	@return a new Line corresponding the its central symmetry
	@throws LineCreationException 
	*/
	@Override
	public Line centralSymmetry(Point p) throws LineCreationException {
		return new Line(p1.symmetry(p), p2.symmetry(p));
	}
	
	/**
	@param l is the Line of symmetry
	@return a new Line corresponding the its axial symmetry
	@throws LineCreationException 
	*/
	@Override
	public Line axialSymmetry(Line l) throws LineCreationException {
	
		Point intersect_P1 = this.intersectionPoint(l);
		
		Vector vec = new Vector(p1, intersect_P1);
		Point P1_sym = new Point(intersect_P1.getX() - vec.getY(), intersect_P1.getY() - vec.getX());
		
		
		Vector vec2 = new Vector(p2, intersect_P1);
		Point P2_sym = new Point(intersect_P1.getX() - vec2.getY(), intersect_P1.getY() - vec2.getX());
		
		return new Line(P1_sym, P2_sym);
	}

	/**
	@param l2 is the second line to calculate the intersection point
	@return a Point which is the intersection point of two lines
	*/
	public Point intersectionPoint(Line l2) { // ax + b = a'x + b'
		
		float a1 = f.getA();
		float b1 = f.getB();
		
		LinearFunction f2 = l2.getF();
		float a2 = f2.getA();
		float b2 = f2.getB();
		
		float x;
		if ((a1-a2) == 0) x = 0;
		else x = (b2 - b1) / (a1 - a2);
		
		float y = a1 * x + b1;

		return new Point(x,y);
	}
	
	/**
	@param l2 is the second line to calculate l2 is orthogonal with this
	@return a boolean which indicate if two Lines are orthogonal
	*/
	public boolean isOrthogonal(Line l2) {
		Vector v1 = new Vector(this);
		Vector v2 = new Vector(l2.getP1(),l2.getP2());
		return (v1.getX()*v2.getX()) + (v1.getY()*v2.getY()) == 0;
	}
	
	/**
	@return a Point which is the center point of this
	*/
	public Point centerOfLine() {
		float x, y;
		
		x = (p1.getX() + p2.getX()) / 2;
		y = (p1.getY() + p2.getY()) / 2;
		
		return new Point(x,y);
	}
	
	/**
	@return a textual representation of a Line
	*/
	@Override
	public String toString() {
		
		StringBuilder resultat = new StringBuilder("\t\t\tLine\n");
		
		resultat.append("\t\t\t\tcoord : [" + p1.toString() + "; " + p2.toString() + "]\tf(x) = " + f.toString() + "\n");
	
		return resultat.toString();
	}
	
	/**
	@param o : is an object with no type defined
    @return a boolean which significate if this Arc is equal to another one
	*/
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Line)) {return false;}
		Line x = (Line) o;
		return p1.equals(x.p1) && p2.equals(x.p2);
	}
	
	/**
    @return a hash code value for the object
	*/
	@Override
	public int hashCode() {
		return Objects.hash(p1,p2);
	}

	/**
	@return one of the two Points belonging to the Line
	*/
	public Point getP1() {
		return p1;
	}

	/**
	@return one of the two Points belonging to the Line
	*/
	public Point getP2() {
		return p2;
	}
	
	/**
	@return the linear function of the Line
	*/
	public LinearFunction getF() {
		return f;
	}
}
