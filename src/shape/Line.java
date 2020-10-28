package shape;

import java.util.Objects;

import exceptions.LineCreationException;
import function.LinearFunction;
import point.Point;

public class Line extends Shape {
	private final Point p1;
	private final Point p2;
	private final LinearFunction f;
	
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
		return 0;
	}

	/**
	@return the perimeter of the line
	*/
	@Override
	public double perimeter() {
		return p1.distance(p2);
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
	@param p is the new center Point of the Line after translation
	@return a new Line after a translation
	@throws LineCreationException 
	*/
	@Override
	public Line translation(Point p) throws LineCreationException {
		Point center = centerOfLine();
		
		float center_x = center.distanceX(p1);
		float center_y = center.distanceY(p1);
		
		Point newP1 = new Point(p.getX()-center_x, p.getY()-center_y);
		Point newP2 = new Point(p.getX()+center_x, p.getY()+center_y);
		
		return new Line(newP1, newP2);
	}
	
	/**
	@param angle is the degree of rotation
	@return a new Line after a rotation
	@throws LineCreationException 
	*/
	@Override
	public Line rotation(int angle) throws LineCreationException {
		Point center = this.centerOfLine();
		Point newP1 = this.rotate(p1, center, angle);
		Point newP2 = symmetry(p2, center);
		
		return new Line(newP1,newP2);
	}
	
	/**
	@param angle is the degree of rotation
	@return a new Line after a rotation
	@throws LineCreationException 
	*/
	public Line rotationFromPoint(int angle, Point p) throws LineCreationException {
		Point newP1 = this.rotate(p1, p, angle);
		Point newP2 = symmetry(p2, p);
		
		return new Line(newP1,newP2);
	}
	
	/**
	@return a new Line corresponding the its central symmetry
	@throws LineCreationException 
	*/
	@Override
	public Line centralSymmetry(Point p) throws LineCreationException {
		return new Line(symmetry(p1, p), symmetry(p2, p));
	}
	
	/**
	@param l is the Line of symmetry
	@return a new Line corresponding the its axial symmetry
	@throws LineCreationException 
	*/
	@Override
	public Line axialSymmetry(Line l) throws LineCreationException {
		Point p1Onl = f.getNewPointOnTheLine(p1.getX(), p1.getY(), l.getP1());
		Point p2Onl = f.getNewPointOnTheLine(p2.getX(), p2.getY(), l.getP2());
		
		float p1X_Distance = p1.distanceX(p1Onl);
		float p1Y_Distance = p1.distanceY(p1Onl);
		float p2X_Distance = p2.distanceX(p2Onl);
		float p2Y_Distance = p2.distanceY(p2Onl);
		
		Point newP1 = new Point(p1Onl.getX()+p1Y_Distance, p1Onl.getY()+p1X_Distance);
		Point newP2 = new Point(p2Onl.getX()+p2Y_Distance, p2Onl.getY()+p2X_Distance);
		
		return new Line(newP1,newP2);
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
	public boolean isOrthogonal(Line l2) { // y = ax + b    <->   ax - zy + b
		float a1 = f.getA();
		
		LinearFunction f2 = l2.getF();
		float a2 = f2.getA();
		
		System.out.println(a1);
		System.out.println(a2);
		if (a1 == a2) return false;
		if (1 + (a1 * a2) == 0) return true;
		return false;
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
		return "Line f(x)= " + f.toString()+ p1.toString() + "-" + p2.toString();
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
