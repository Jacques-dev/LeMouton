package containers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Draw implements Iterable<Image> {
	
	private final List<Image> draw;
	
	/**
	A Draw is a set of Images
	*/
	public Draw() {
		draw = new ArrayList<Image>();
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
}
