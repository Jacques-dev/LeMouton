package fresco;

import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import draw.Draw;

public class Fresco implements Iterable<Draw> {

	private final Set<Draw> fresco;
	
	/**
	A Draw is a set of Images
	*/
	public Fresco() {
		this.fresco = new TreeSet<Draw>();
	}
	
	/**
	@param i is an Draw containing Images
	*/
	public void add(final Draw i) {
		try {
			this.fresco.add(i);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
	}
	
	/**
	@return the sum of all the Draws area contained
	*/
	public double area() {
		double area = 0;
		for (Draw d : this) {
			area += d.area();
		}
		return area;
	}

	/**
	@return the sum of all the Draws perimeters contained 
	*/
	public double perimeter() {
		double perimeter = 0;
		for (Draw d : this) {
			perimeter += d.perimeter();
		}
		return perimeter;
	}
	
	/**
	@param o is an object with no type defined
    @return a boolean which significate if this Arc is equal to another one
	*/
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Fresco)) {return false;}
		Fresco x = (Fresco) o;
		return fresco.equals(x.fresco);
	}
	
	/**
    @return a hash code value for the object
	*/
	@Override
	public int hashCode() {
		return Objects.hash(fresco);
	}
	
	/**
	An Iterator is an object that can be used to loop through collections
	*/
	@Override
	public Iterator<Draw> iterator() {
		return fresco.iterator();
	}
	
	/**
	@return a textual representation of all the Draws contained
	*/
	@Override
	public String toString() {	
		
		StringBuilder resultat = new StringBuilder("Fresco\n");
		
		for (Draw d : this) {
			resultat.append(d.toString() + "\n");
		}
		
		resultat.append("------");
	
		return resultat.toString();
	}
	
	/**
	@param limite define a certain area
	@return the number of Draws contained which have an area less than the limit given in parameter
	*/
	public int howManyInferiorDrawArea(double limite) {
		int resultat = 0;
		for (Draw d : this) {
			if (d.area() < limite) resultat +=1;
		}
		return resultat;
	}
}
