package draw;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import image.Image;
import shape.Shape;

public class Draw implements Iterable<Image> {
	
	private final Set<Image> draw;
	
	public Draw() {
		draw = new TreeSet<Image>();
	}
	
	public void add(final Image i) {
		draw.add(i);
		
	}
	
	public double area() {
		double area = 0;
		for (Image image : this) {
			area += image.area();
		}
		return area;
	}

	public double perimeter() {
		double perimeter = 0;
		for (Image image : this) {
			perimeter += image.perimeter();
		}
		return perimeter;
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Draw)) {return false;}
		Draw x = (Draw) o;
		return draw.equals(x.draw);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(draw);
	}

	@Override
	public Iterator<Image> iterator() {
		return draw.iterator();
	}
	
	@Override
	public String toString() {
		// return ("Draw \n ------\n" + draw.toString() + "\n------");		
		
		StringBuilder resultat = new StringBuilder("Draw \n ------\n");
		
		for (Image image : this) {
			resultat.append(image +"\n");
		}
		
		resultat.append("------");
	
		return resultat.toString();
	}
	
	public int howManyInferiorImageArea(double limite) {
		int resultat = 0;
		for (Image image : this) {
			if (image.area() < limite) resultat +=1;
		}
		return resultat;
	}
}
