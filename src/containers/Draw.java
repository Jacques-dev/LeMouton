package containers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

import exceptions.EllipseCreationException;
import exceptions.LineCreationException;
import exceptions.PolygonCreationException;
import point.Point;
import shape.Line;

public class Draw implements Iterable<Image>, Container {
	
	private final ArrayList<Image> draw;
	
	/**
	A Draw is an ArrayList of Images
	*/
	public Draw() {
		draw = new ArrayList<Image>();
	}
	
	/**
	A Draw is an ArrayList of Images
	*/
	private Draw(ArrayList<Image> a) {
		this.draw = a;
	}
	
	/**
	@param i is an Image containing Shapes
	*/
	public void add(final Image i) {
		try {
			if (!draw.contains(i)) draw.add(i);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
	}
	
	/**
	@return the sum of all the Images area contained
	*/
	public double area() {
		double area = 0;
		for (Image image : this) {
			area += image.area();
		}
		return area;
	}

	/**
	@return the sum of all the Images perimeters contained 
	*/
	public double perimeter() {
		double perimeter = 0;
		for (Image image : this) {
			perimeter += image.perimeter();
		}
		return perimeter;
	}
	
	/**
	@param o is an object with no type defined
    @return a boolean which significate if this Arc is equal to another one
	*/
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Draw)) {return false;}
		Draw x = (Draw) o;
		return draw.equals(x.draw);
	}
	
	/**
    @return a hash code value for the object
	*/
	@Override
	public int hashCode() {
		return Objects.hash(draw);
	}
	
	/**
	An Iterator is an object that can be used to loop through collections
	*/
	@Override
	public Iterator<Image> iterator() {
		return draw.iterator();
	}
	
	/**
	@return a textual representation of all the Images contained
	*/
	@Override
	public String toString() {	
		
		StringBuilder resultat = new StringBuilder("\tDraw\n");
		
		for (Image image : this) {
			resultat.append(image.toString() +"\n");
		}
	
		return resultat.toString();
	}
	
	/**
	@param limite define a certain area
	@return the number of Images contained which have an area less than the limit given in parameter
	*/
	public int howManyInferiorImageArea(double limite) {
		int resultat = 0;
		for (Image image : this) {
			if (image.area() < limite) resultat +=1;
		}
		return resultat;
	}

	/**
	@param p is the homothety origin Point
	@param ratio is the homothety ratio
	@return a new Draw after a homothety
	@throws EllipseCreationException check for orthogonality, if lines cross the center point, and if it's not a circle
	@throws LineCreationException check if no Null argument are given
	@throws PolygonCreationException check more than 2 arguments are given
	*/
	@Override
	public Draw homothety(Point p, int ratio) throws EllipseCreationException, LineCreationException, PolygonCreationException {
		Draw d = new Draw();
		
		for (Image image : this) {
			d.add((Image) image.homothety(p, ratio));
		}
		
		return d;
	}

	/**
	@param p is the origin Point of translation
	@return a new Draw after a translation
	@throws EllipseCreationException check for orthogonality, if lines cross the center point, and if it's not a circle
	@throws PolygonCreationException check more than 2 arguments are given
	*/
	@Override
	public Draw translation(Point p) throws EllipseCreationException, LineCreationException, PolygonCreationException {
		Draw d = new Draw();
		
		for (Image image : this) {
			d.add((Image) image.translation(p));
		}
		
		return d;
	}

	/**
	@param angle is the degree of rotation
	@return a new Draw after a rotation
	@throws EllipseCreationException check for orthogonality, if lines cross the center point, and if it's not a circle
	@throws PolygonCreationException check more than 2 arguments are given
	*/
	@Override
	public Draw rotation(int angle) throws EllipseCreationException, LineCreationException, PolygonCreationException {
		Draw d = new Draw();
		
		for (Image image : this) {
			d.add((Image) image.rotation(angle));
		}
		
		return d;
	}

	/**
	@param p is the Point of symmetry
	@return a new Draw corresponding the its central symmetry
	@throws EllipseCreationException check for orthogonality, if lines cross the center point, and if it's not a circle
	@throws PolygonCreationException check more than 2 arguments are given
	*/
	@Override
	public Draw centralSymmetry(Point p) throws EllipseCreationException, LineCreationException, PolygonCreationException {
		Draw d = new Draw();
		
		for (Image image : this) {
			d.add((Image) image.centralSymmetry(p));
		}
		
		return d;
	}

	/**
	@param l is the Line of symmetry
	@return a new Draw corresponding the its axial symmetry
	@throws EllipseCreationException check for orthogonality, if lines cross the center point, and if it's not a circle
	@throws LineCreationException check if no Null argument are given 
	@throws PolygonCreationException check more than 2 arguments are given
	*/
	@Override
	public Draw axialSymmetry(Line l) throws EllipseCreationException, LineCreationException, PolygonCreationException {
		Draw d = new Draw();
		
		for (Image image : this) {
			d.add((Image) image.axialSymmetry(l));
		}
		
		return d;
	}
	
	/** 
	@return a copy of Draw
	*/
	@Override
	public Draw copy() {
		return new Draw(draw);
	}
}
