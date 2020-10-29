package containers;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Image implements Iterable<Shape> {
	
	private final Set<Shape> image;
	
	/**
	An Image is a set of Shapes
	*/
	public Image() {
		image = new TreeSet<Shape>();
	}
	
	/**
	@param s is a Shape
	*/
	public void add(final Shape s) {
		image.add(s);
	}
	
	/**
	@return the sum of all the Shapes area contained
	*/
	public double area() {
		double area = 0;
		for (Shape shape : this) {
			area += shape.area();
		}
		return area;
	}

	/**
	@return the sum of all the Shapes perimeters contained 
	*/
	public double perimeter() {
		double perimeter = 0;
		for (Shape shape : this) {
			perimeter += shape.perimeter();
		}
		return perimeter;
	}
	
	/**
	@param o : is an object with no type defined
    @return a boolean which significate if this Arc is equal to another one
	*/
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Image)) {return false;}
		Image x = (Image) o;
		return image.equals(x.image);
	}
	
	/**
    @return a hash code value for the object
	*/
	@Override
	public int hashCode() {
		return Objects.hash(image);
	}
	
	/**
	An Iterator is an object that can be used to loop through collections
	*/
	@Override
	public Iterator<Shape> iterator() {
		return image.iterator();
	}
	
	/**
	@return a textual representation of an Image
	*/
	@Override
	public String toString() {
		// return ("Image \n ------\n" + image.toString() + "\n------");		
		
		StringBuilder resultat = new StringBuilder("Image \n ------\n");
		
		for (Shape shape : this) {
			resultat.append(shape +"\n");
		}
		
		resultat.append("------");
	
		return resultat.toString();
	}
	
	/**
	This method able to sort all the Shapes already stocked in set by their perimeter
	*/
	public void sortByPerimeter() {
		List<Shape> test = new ArrayList<Shape>(image);
		Collections.sort(test, new Comparator<Shape>() {
			public int compare(Shape s1, Shape s2) {
				return s1.compareToPerimeters(s2);
			}
		});
	}
	
	/**
	This method able to sort all the Shapes already stocked in set by their area
	*/
	public void sortByArea() {
		List<Shape> test = new ArrayList<Shape>(image);
		Collections.sort(test, new Comparator<Shape>() {
			public int compare(Shape s1, Shape s2) {
				return s1.compareToAreas(s2);
			}
		});
	}
	
	/**
	@param limite define a certain perimeter
	@return the number of Shapes contained which have a perimeter less than the limit given in parameter
	*/
	public int howManyInferiorShapePerimeter(double limite) {
		int resultat = 0;
		for (Shape shape : this) {
			if (shape.perimeter() < limite) resultat +=1;
		}
		return resultat;
	}
}
