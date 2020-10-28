package shape;

import java.util.ArrayList;
import java.util.Objects;

import exceptions.LineCreationException;
import point.Point;


public class Polygon extends Shape {

	private final ArrayList<Line> lines;
	private Point center;
	
	/**
	@param lines is a list of the lines belonging to the Polygon
	*/
	public Polygon(ArrayList<Line> lines) {
		this.lines = lines;
		float centerX = 0, centerY = 0;
		for (int i = 0; i < lines.size(); i++) {
			centerX += lines.get(i).getP1().getX();	
			centerY += lines.get(i).getP1().getY();
		}
		centerX /= lines.size();
		centerY /= lines.size();
		this.center = new Point(centerX, centerY);
	}
	
	/**
	@return the area of the Polygon
	*/
	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 0;
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
	@param origine is the homothety origin
	@param ratio is the homothety ratio
	@return a new Polygon after a homothety
	@throws LineCreationException 
	*/
	@Override
	public Polygon homothety(Point p, int ratio) throws LineCreationException {
		ArrayList<Line> tmpLines = new ArrayList<Line>();
		for (int i = 0; i < this.lines.size(); i++) {
			tmpLines.add(this.lines.get(i).homothety(p, ratio));
		}
		return new Polygon(tmpLines);
	}

	/**
	@param p is the new center Point of the Polygon after translation
	@return a new Polygon after a translation
	@throws LineCreationException 
	*/
	@Override
	public Polygon translation(Point p) throws LineCreationException {
		ArrayList<Line> tmpLines = new ArrayList<Line>();
		for (int i = 0; i < this.lines.size(); i++) {
			tmpLines.add(this.lines.get(i).translation(p));
		}
		return new Polygon(tmpLines);
	}

	/**
	@param angle is the degree of rotation
	@return a new Polygon after a rotation
	@throws LineCreationException 
	*/
	@Override
	public Polygon rotation(int angle) throws LineCreationException {
		ArrayList<Line> tmpLines = new ArrayList<Line>();
		for (int i = 0; i < this.lines.size(); i++) {
			tmpLines.add(this.lines.get(i).rotation(angle));
		}
		return new Polygon(tmpLines);
	}

	/**
	@return a new Polygon corresponding the its central symmetry
	@throws LineCreationException 
	*/
	@Override
	public Polygon centralSymmetry(Point p) throws LineCreationException {
		ArrayList<Line> tmpLines = new ArrayList<Line>();
		for (int i = 0; i < this.lines.size(); i++) {
			tmpLines.add(this.lines.get(i).centralSymmetry(p));
		}
		return new Polygon(tmpLines);
	}

	/**
	@param l is the Line of symmetry
	@return a new Polygon corresponding the its axial symmetry
	@throws LineCreationException 
	*/
	@Override
	public Polygon axialSymmetry(Line l) throws LineCreationException {
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
		return "";
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
}
