package containers;

import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Mural implements Iterable<Draw> {
	
	private final Set<Draw> mural;
	
	/**
	A Mural is a set of Draws
	*/
	public Mural() {
		mural = new TreeSet<Draw>();
	}
	
	/**
	@param i is an Draw containing Images
	*/
	public void add(final Draw i) {
		try {
			mural.add(i);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
	}
	
	/**
	@param o is an object with no type defined
    @return a boolean which significate if this Arc is equal to another one
	*/
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Mural)) {return false;}
		Mural x = (Mural) o;
		return mural.equals(x.mural);
	}
	
	/**
    @return a hash code value for the object
	*/
	@Override
	public int hashCode() {
		return Objects.hash(mural);
	}
	
	/**
	An Iterator is an object that can be used to loop through collections
	*/
	@Override
	public Iterator<Draw> iterator() {
		return mural.iterator();
	}
	
	/**
	@return a textual representation of all the Draws contained
	*/
	@Override
	public String toString() {	
		
		StringBuilder resultat = new StringBuilder("Mural \n ------\n");
		
		for (Draw draw : this) {
			resultat.append(draw +"\n");
		}
		
		resultat.append("------");
	
		return resultat.toString();
	}
}
