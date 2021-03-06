package shape;

import java.util.ArrayList;
import java.util.Objects;

import exceptions.LineCreationException;
import exceptions.PolygonCreationException;
import point.Point;


public class Polygon extends Shape {

	private final ArrayList<Line> lines;
	private Point center;
	
	/**
	@param lines is a list of the lines belonging to the Polygon
	*/
	public Polygon(ArrayList<Line> lines) throws PolygonCreationException {
		if (lines.size() < 3) {
			throw new PolygonCreationException("Less than 3 Lines are specified in arguments.");
		}
		this.lines = lines;
		float centerX = 0, centerY = 0;
		for (int i = 0; i < lines.size(); i++) {
			centerX += lines.get(i).getP1().getX();	
			centerY += lines.get(i).getP1().getY();
			centerX += lines.get(i).getP2().getX();	
			centerY += lines.get(i).getP2().getY();
		}
		centerX /= (2*lines.size());
		centerY /= (2*lines.size());
		this.center = new Point(centerX, centerY);
	}
	
	/**
	@return the area of the Polygon
	*/
	@Override
	public double area() {
		double somme = 0;
		for (int i = 0; i < this.lines.size(); i++) {
			somme =+ this.lines.get(i).getP1().getX() * this.lines.get(i).getP2().getY() - this.lines.get(i).getP1().getY() * this.lines.get(i).getP2().getX();
		}
		return somme;
	}

	/**
	@return the perimeter of the Polygon
	*/
	@Override
	public double perimeter() {
		double res = 0;
		for (Line l : this.lines) {
			res += l.perimeter();
		}
		return res;
	}
	
	/**
	@param p is the homothety origin
	@param ratio is the homothety ratio
	@return a new Polygon after a homothety
	@throws LineCreationException check if no Null argument are given 
	 * @throws PolygonCreationException 
	*/
	@Override
	public Polygon homothety(Point p, int ratio) throws LineCreationException, PolygonCreationException {
		ArrayList<Line> tmpLines = new ArrayList<Line>();
		for (int i = 0; i < this.lines.size(); i++) {
			tmpLines.add(this.lines.get(i).homothety(p, ratio));
		}
		return new Polygon(tmpLines);
	}

	/**
	@param p is the new center Point of the Polygon after translation
	@return a new Polygon after a translation
	@throws LineCreationException check if no Null argument are given 
	@throws PolygonCreationException check more than 2 arguments are given
	*/
	@Override
	public Polygon translation(Point p) throws LineCreationException, PolygonCreationException {
		ArrayList<Line> tmpLines = new ArrayList<Line>();
		for (int i = 0; i < this.lines.size(); i++) {
			tmpLines.add(this.lines.get(i).translation(center,p));
		}
		return new Polygon(tmpLines);
	}

	/**
	@param angle is the degree of rotation
	@return a new Polygon after a rotation
	@throws LineCreationException check if no Null argument are given 
	@throws PolygonCreationException check more than 2 arguments are given
	*/
	@Override
	public Polygon rotation(int angle) throws LineCreationException, PolygonCreationException {
		ArrayList<Line> tmpLines = new ArrayList<Line>();
		for (int i = 0; i < this.lines.size(); i++) {
			tmpLines.add(this.lines.get(i).rotationFromPoint(angle,center));
		}
		return new Polygon(tmpLines);
	}

	/**
	@return a new Polygon corresponding the its central symmetry
	@throws LineCreationException check if no Null argument are given 
	@throws PolygonCreationException check more than 2 arguments are given
	*/
	@Override
	public Polygon centralSymmetry(Point p) throws LineCreationException, PolygonCreationException {
		ArrayList<Line> tmpLines = new ArrayList<Line>();
		for (int i = 0; i < this.lines.size(); i++) {
			tmpLines.add(this.lines.get(i).centralSymmetry(p));
		}
		return new Polygon(tmpLines);
	}

	/**
	@param l is the Line of symmetry
	@return a new Polygon corresponding the its axial symmetry
	@throws LineCreationException check if no Null argument are given 
	@throws PolygonCreationException check more than 2 arguments are given
	*/
	@Override
	public Polygon axialSymmetry(Line l) throws LineCreationException, PolygonCreationException {
		ArrayList<Line> tmpLines = new ArrayList<Line>();
		for (int i = 0; i < this.lines.size(); i++) {
			tmpLines.add(this.lines.get(i).axialSymmetry(l));
		}
		return new Polygon(tmpLines);
	}
	
	/**
	@return a textual representation of a Polygon
	*/
	public String toString() {
		StringBuilder s = new StringBuilder();
		
		ArrayList<Point> pointList = new ArrayList<Point>();
		
		for (Line l : this.lines) {
			boolean existsP1 = false;
			boolean existsP2 = false;
			for (Point p : pointList) {
				existsP1 = false;
				existsP2 = false;
				if (l.getP1().equals(p)) {
					existsP1 = true;
				}
				if (l.getP2().equals(p)) {
					existsP2 = true;
				}
			}
			if (!existsP1) {
				pointList.add(l.getP1());
			}
			if (!existsP2) {
				pointList.add(l.getP2());
			}
		}
		
		s.append("\t\t\tPolygon\n");
		for (Point p : pointList) {
			s.append("\t\t\t\tPoint : " + p.toString() + "\n");
		}
		
		s.append("\n");
		return s.toString();
	}
	
	/**
	@param o : is an object with no type defined
    @return a boolean which show if this Arc is equal to another one
	*/
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Polygon)) {return false;}
		Polygon x = (Polygon) o;
		return lines.equals(x.lines) && center.equals(x.center);
	}
	
	/**
    @return a hash code value for the object
	*/
	@Override
	public int hashCode() {
		return Objects.hash(lines,center);
	}
	
	/** 
	@return a copy of Polygon
	@throws PolygonCreationException check more than 2 arguments are given
	*/
	@Override
	public Polygon copy() throws PolygonCreationException {
		return new Polygon(this.lines);
	}
}
