package draw;

import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import image.Image;

public class Draw implements Iterable<Image> {
	
	private final Set<Image> draw;
	
	/**
	This class contains images
	*/
	public Draw() {
		draw = new TreeSet<Image>();
	}
	
	/**
	@param Image is an image containing shapes
	*/
	public void add(final Image i) {
		draw.add(i);	
	}
	
	/**
	@return the sum of all the images area contained
	*/
	public double area() {
		double area = 0;
		for (Image image : this) {
			area += image.area();
		}
		return area;
	}

	/**
	@return the sum of all the images perimeters contained 
	*/
	public double perimeter() {
		double perimeter = 0;
		for (Image image : this) {
			perimeter += image.perimeter();
		}
		return perimeter;
	}
	
	/**
	@param o : is an object with no type defined
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
	@return a string of all the images contained
	*/
	@Override
	public String toString() {	
		
		StringBuilder resultat = new StringBuilder("Draw \n ------\n");
		
		for (Image image : this) {
			resultat.append(image +"\n");
		}
		
		resultat.append("------");
	
		return resultat.toString();
	}
	
	/**
	@param limite define a certain area
	@return the number of images contained which have an area less than the limit given in parameter
	*/
	public int howManyInferiorImageArea(double limite) {
		int resultat = 0;
		for (Image image : this) {
			if (image.area() < limite) resultat +=1;
		}
		return resultat;
	}
}
