package image;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import shape.Shape;

public class Image implements Iterable<Shape> {
	
	private final Set<Shape> image;
	
	public Image() {
		image = new TreeSet<Shape>();
	}
	
	public void add(final Shape s) {
		image.add(s);
		
	}
	
	public double area() {
		double area = 0;
		for (Shape shape : this) {
			area += shape.area();
		}
		return area;
	}

	public double perimeter() {
		double perimeter = 0;
		for (Shape shape : this) {
			perimeter += shape.perimeter();
		}
		return perimeter;
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Image)) {return false;}
		Image x = (Image) o;
		return image.equals(x.image);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(image);
	}

	@Override
	public Iterator<Shape> iterator() {
		return image.iterator();
	}
	
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
	
	public void sortByPerimeter() {
		List<Shape> test = new ArrayList<Shape>(image);
		Collections.sort(test, new Comparator<Shape>() {
			public int compare(Shape s1, Shape s2) {
				return s1.compareToPerimeters(s2);
			}
		});
	}
	
	public void sortByArea() {
		List<Shape> test = new ArrayList<Shape>(image);
		Collections.sort(test, new Comparator<Shape>() {
			public int compare(Shape s1, Shape s2) {
				return s1.compareToAreas(s2);
			}
		});
	}
	
	public int howManyInferiorShapePerimeter(double limite) {
		int resultat = 0;
		for (Shape shape : this) {
			if (shape.perimeter() < limite) resultat +=1;
		}
		return resultat;
	}
}