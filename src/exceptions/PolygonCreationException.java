package exceptions;

@SuppressWarnings("serial")
public class PolygonCreationException extends Exception{
	public PolygonCreationException(String s) {
        super ("Somme of the arguments are not receivable : " + s);
    }
}
